package it.unical.classmanager.controllers.forum;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.unical.classmanager.model.dao.QuestionAttachedContentDAO;
import it.unical.classmanager.model.dao.QuestionAttachedContentDAOImpl;
import it.unical.classmanager.model.dao.QuestionDAO;
import it.unical.classmanager.model.dao.QuestionDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.Question;
import it.unical.classmanager.model.data.QuestionAttachedContent;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.FileManager;

/**
 * Handles requests for the forum page.
 */
@Controller
public class InsertQuestionController {
	
	@Autowired
	private ApplicationContext appContext;
	
	
	@RequestMapping(value = "/forum/insertQuestion", method = RequestMethod.GET)
	public String createQuestion(Locale locale, Model model, HttpServletRequest request) {
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		model.addAttribute("username", username);
		
		Question question = new Question();
		model.addAttribute("question", question);
		
		
		return "forum/insertQuestion";
	}
	
	
	@RequestMapping(value = "/forum/insertQuestion", method = RequestMethod.POST)
	public String insertQuestion(Locale locale, Model model, @ModelAttribute("question") Question question, HttpServletRequest request) {
		
		
		UserDAO userDao = appContext.getBean("userDao",UserDAOImpl.class);
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		User tmpUser = userDao.get(username);
		
		question.setUser(tmpUser);
		Question newQuestion =  questionDAO.create(question);
		
		String attachedFilesID = request.getParameter("attachedFiles");

		if(attachedFilesID != null && !attachedFilesID.equals("")) {
			
			StringTokenizer tokenizer = new StringTokenizer(attachedFilesID, ";");
			QuestionAttachedContentDAO questionAttachedDAO = (QuestionAttachedContentDAOImpl) appContext.getBean("questionAttachedContentDAO", QuestionAttachedContentDAOImpl.class);
		
			while(tokenizer.hasMoreTokens()) {
				String tmpID = tokenizer.nextToken();
				
				QuestionAttachedContent tmpQuestionContent = questionAttachedDAO.get(Integer.parseInt(tmpID));
				tmpQuestionContent.setQuestion(newQuestion);
				questionAttachedDAO.update(tmpQuestionContent);
			}
		}
		
		
		return "redirect:questions";
	}
	
	
	@RequestMapping(value = "/forum/modifyQuestion", method = RequestMethod.POST)
	public String modifyQuestion(Locale locale, Model model, HttpServletRequest request) {
		
		int questionID = Integer.parseInt(request.getParameter("qid"));
		System.out.println("ID: " + questionID);
		
		QuestionDAOImpl dao = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		Question question = dao.get(questionID);
		
		model.addAttribute("question", question);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		model.addAttribute("username", username);
		
		
		return "forum/modifyQuestion";
	}
	
	
	@RequestMapping(value = "/forum/updateQuestion", method = RequestMethod.POST)
	public String updateQuestion(Locale locale, Model model, @ModelAttribute("question") Question question, HttpServletRequest request) {
		
		UserDAO userDao = appContext.getBean("userDao",UserDAOImpl.class);
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		User tmpUser = userDao.get(username);
		
		question.setUser(tmpUser);
		Question newQuestion =  questionDAO.update(question);
		
		String attachedFilesID = request.getParameter("attachedFiles");
		
		if(attachedFilesID != null && !attachedFilesID.equals("")) {
			
			StringTokenizer tokenizer = new StringTokenizer(attachedFilesID, ";");
			QuestionAttachedContentDAO questionAttachedDAO = (QuestionAttachedContentDAOImpl) appContext.getBean("questionAttachedContentDAO", QuestionAttachedContentDAOImpl.class);
		
			while(tokenizer.hasMoreTokens()) {
				String tmpID = tokenizer.nextToken();
				
				QuestionAttachedContent tmpQuestionContent = questionAttachedDAO.get(Integer.parseInt(tmpID));
				tmpQuestionContent.setQuestion(newQuestion);
				questionAttachedDAO.update(tmpQuestionContent);
			}
		}
		
		return "redirect:questions";
	}
	
	
	
	@RequestMapping(value = "/forum/uploadQuestionAttachment", method = RequestMethod.POST)
	public @ResponseBody String uploadQuestionAttachment(Locale locale, Model model, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		
		FileManager fm = new FileManager();
		String filePath = "files/forumAttachment/questionAttachment/" + username + "/" + file.getOriginalFilename();

		String newFileName = file.getOriginalFilename();
		if(new File(filePath).exists()) {
			
			ArrayList<String> fileNameSplitted = new ArrayList<String>(Arrays.asList(file.getOriginalFilename().split("\\.(?=[^\\.]+$)")));
			if(fileNameSplitted.size() == 1) {
				fileNameSplitted.add("");
			}
			else {
				fileNameSplitted.add(1, "." + fileNameSplitted.get(1));
			}

			
			String name = fileNameSplitted.get(0);
			String extension = fileNameSplitted.get(1);
			name += "_" + new Random(System.currentTimeMillis()).nextInt(1000000);
			
			newFileName = name + extension;
			filePath = "files/forumAttachment/questionAttachment/" + username + "/" + newFileName;
		}
		
		newFileName = StringEscapeUtils.escapeSql(newFileName);
		filePath = StringEscapeUtils.escapeSql(filePath);
		
		fm.mkMultipartFile(file, "forumAttachment/questionAttachment/" + username + "/", newFileName);
		
		
		QuestionAttachedContentDAO questionAttachedDAO = (QuestionAttachedContentDAOImpl) appContext.getBean("questionAttachedContentDAO", QuestionAttachedContentDAOImpl.class);
		
		QuestionAttachedContent questionAttached = new QuestionAttachedContent();
		
		File tmpFile = new File(filePath);
		String tmpMimeType = null;
		try {
			tmpMimeType = Files.probeContentType(tmpFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		questionAttached.setName(newFileName);
		questionAttached.setFilePath(filePath);
		questionAttached.setType(tmpMimeType);
		questionAttached = questionAttachedDAO.create(questionAttached);
		
		
		return "{\"name\": \""+ newFileName +"\", \"id\": \""+ Integer.toString(questionAttached.getId()) +"\", \"type\":\"insert\"}";
	}
	
	
	
	@RequestMapping(value = "/forum/removeQuestionAttachment", method = RequestMethod.POST)
	public @ResponseBody boolean removeQuestionAttachment(Locale locale, Model model, HttpServletRequest request) {
		
		int attachedFilesIDRemove = Integer.parseInt(request.getParameter("attachedIdRemove"));
		
		QuestionAttachedContentDAO questionAttachedDAO = (QuestionAttachedContentDAOImpl) appContext.getBean("questionAttachedContentDAO", QuestionAttachedContentDAOImpl.class);
		
		try{
			
			QuestionAttachedContent questionAttached = questionAttachedDAO.get(attachedFilesIDRemove);
			
			FileManager fm = new FileManager();
			fm.deleteFile(questionAttached.getFilePath());
			
			questionAttachedDAO.delete(questionAttached);
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	
	}
	
	
	
}
