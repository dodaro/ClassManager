package it.unical.classmanager.controllers.forum;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.unical.classmanager.editorData.EditorStatus;
import it.unical.classmanager.editorData.Environment;
import it.unical.classmanager.managers.EnvironmentManger;
import it.unical.classmanager.model.dao.AnswerAttachedContentDAO;
import it.unical.classmanager.model.dao.AnswerAttachedContentDAOImpl;
import it.unical.classmanager.model.dao.AnswerDAO;
import it.unical.classmanager.model.dao.AnswerDAOImpl;
import it.unical.classmanager.model.dao.QuestionAttachedContentDAO;
import it.unical.classmanager.model.dao.QuestionAttachedContentDAOImpl;
import it.unical.classmanager.model.dao.QuestionDAO;
import it.unical.classmanager.model.dao.QuestionDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.Answer;
import it.unical.classmanager.model.data.AnswerAttachedContent;
import it.unical.classmanager.model.data.Question;
import it.unical.classmanager.model.data.QuestionAttachedContent;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.FileManager;
import it.unical.classmanager.utils.enumative.EnvironmentEnum;

/**
 * Handles requests for the forum page.
 */
@Controller
public class InsertAnswerController {
	
	@Autowired
	private ApplicationContext appContext;
	
	
	@RequestMapping(value = "/forum/createAnswer", method = RequestMethod.POST)
	public String createAnswer(Locale locale, Model model, HttpServletRequest request) {
		
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		
		int qid = Integer.parseInt(request.getParameter("qid"));
		Question question = questionDAO.get(qid);
		
		model.addAttribute("question", question);
		
		Answer answer = new Answer();
		model.addAttribute("answer", answer);
			
		return "forum/insertAnswer";
	}
	
	
	@RequestMapping(value = "/forum/insertAnswer", method = RequestMethod.POST)
	public String insertAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Locale locale, Model model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			
			System.out.println("Errore nei dati");
			
			int qid = Integer.parseInt(request.getParameter("qid"));
			QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
			Question question = questionDAO.get(qid);
			
			model.addAttribute("question", question);
			
			List<AnswerAttachedContent> attachemnts = new ArrayList<AnswerAttachedContent>();
			String attachedFilesID = request.getParameter("attachedFiles");

			if(attachedFilesID != null && !attachedFilesID.equals("")) {
				
				StringTokenizer tokenizer = new StringTokenizer(attachedFilesID, ";");
				AnswerAttachedContentDAO answerAttachedDAO = (AnswerAttachedContentDAOImpl) appContext.getBean("answerAttachedContentDAO", AnswerAttachedContentDAOImpl.class);
			
				while(tokenizer.hasMoreTokens()) {
					String tmpID = tokenizer.nextToken();
					
					AnswerAttachedContent tmpAnswerContent = answerAttachedDAO.get(Integer.parseInt(tmpID));
					attachemnts.add(tmpAnswerContent);
				}
			}
			
			
			model.addAttribute("attachments", attachemnts);
			model.addAttribute("attachmentsID", attachedFilesID);
			
			return "forum/insertAnswer";
		}
		
		
		UserDAO userDao = appContext.getBean("userDao",UserDAOImpl.class);
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		AnswerDAO answerDAO = (AnswerDAOImpl) appContext.getBean("answerDAO", AnswerDAOImpl.class);
		
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		User tmpUser = userDao.get(username);
		
		int qid = Integer.parseInt((String) request.getParameter("qid"));
		Question tmpQuestion = questionDAO.get(qid);
		
		answer.setUser(tmpUser);
		answer.setQuestion(tmpQuestion);
		
		Answer newAnswer =  answerDAO.create(answer);
		
		
		String attachedFilesID = request.getParameter("attachedFiles");

		if(attachedFilesID != null && !attachedFilesID.equals("")) {
			
			StringTokenizer tokenizer = new StringTokenizer(attachedFilesID, ";");
			AnswerAttachedContentDAO answerAttachedDAO = (AnswerAttachedContentDAOImpl) appContext.getBean("answerAttachedContentDAO", AnswerAttachedContentDAOImpl.class);
		
			while(tokenizer.hasMoreTokens()) {
				String tmpID = tokenizer.nextToken();
				
				AnswerAttachedContent tmpAnswerContent = answerAttachedDAO.get(Integer.parseInt(tmpID));
				tmpAnswerContent.setAnswer(newAnswer);
				answerAttachedDAO.update(tmpAnswerContent);
			}
		}
		
			
		return "redirect:detailedQuestion?qid=" + qid;
	}
	
	
	@RequestMapping(value = "/forum/modifyAnswer", method = RequestMethod.POST)
	public String modifyAnswer(Locale locale, Model model, HttpServletRequest request) {
		
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		int qid = Integer.parseInt(request.getParameter("qid"));
		Question question = questionDAO.get(qid);

		model.addAttribute("question", question);
		
		AnswerDAO answerDAO = (AnswerDAOImpl) appContext.getBean("answerDAO", AnswerDAOImpl.class);
		int aid = Integer.parseInt(request.getParameter("aid"));
		Answer answer = answerDAO.get(aid);
		
		model.addAttribute("answer", answer);
		
			
		return "forum/modifyAnswer";
	}
	
	
	@RequestMapping(value = "/forum/updateAnswer", method = RequestMethod.POST)
	public String updateAnswer(Locale locale, Model model, @ModelAttribute("answer") Answer answer, HttpServletRequest request) {
		
		UserDAO userDao = appContext.getBean("userDao",UserDAOImpl.class);
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		AnswerDAO answerDAO = (AnswerDAOImpl) appContext.getBean("answerDAO", AnswerDAOImpl.class);
		
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		User tmpUser = userDao.get(username);
		
		int qid = Integer.parseInt((String) request.getParameter("qid"));
		Question tmpQuestion = questionDAO.get(qid);
		
		answer.setUser(tmpUser);
		answer.setQuestion(tmpQuestion);
		
		Answer newAnswer =  answerDAO.update(answer);
		
		String attachedFilesID = request.getParameter("attachedFiles");
		
		if(attachedFilesID != null && !attachedFilesID.equals("")) {
			
			StringTokenizer tokenizer = new StringTokenizer(attachedFilesID, ";");
			AnswerAttachedContentDAO answerAttachedDAO = (AnswerAttachedContentDAOImpl) appContext.getBean("answerAttachedContentDAO", AnswerAttachedContentDAOImpl.class);
		
			while(tokenizer.hasMoreTokens()) {
				String tmpID = tokenizer.nextToken();
				
				AnswerAttachedContent tmpAnswerContent = answerAttachedDAO.get(Integer.parseInt(tmpID));
				tmpAnswerContent.setAnswer(newAnswer);
				answerAttachedDAO.update(tmpAnswerContent);
			}
		}
		
			
		return "redirect:detailedQuestion?qid=" + qid;
	}
	
	
	@RequestMapping(value = "/forum/uploadAnswerAttachment", method = RequestMethod.POST)
	public @ResponseBody String uploadAnswerAttachment(Locale locale, Model model, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		
		FileManager fm = new FileManager();
		String filePath = "files/forumAttachment/answerAttachment/" + username + "/" + file.getOriginalFilename();

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
			filePath = "files/forumAttachment/answerAttachment/" + username + "/" + newFileName;
		}
		
		newFileName = StringEscapeUtils.escapeSql(newFileName);
		filePath = StringEscapeUtils.escapeSql(filePath);
		
		fm.mkMultipartFile(file, "forumAttachment/answerAttachment/" +  username + "/", newFileName);
		
		
		AnswerAttachedContentDAO answerAttachedDAO = (AnswerAttachedContentDAOImpl) appContext.getBean("answerAttachedContentDAO", AnswerAttachedContentDAOImpl.class);
		AnswerAttachedContent answerAttached = new AnswerAttachedContent();
		
		File tmpFile = new File(filePath);
		String tmpMimeType = null;
		try {
			tmpMimeType = Files.probeContentType(tmpFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

			
		answerAttached.setName(newFileName);
		answerAttached.setFilePath(filePath);
		answerAttached.setType(tmpMimeType);
		answerAttached = answerAttachedDAO.create(answerAttached);
			
		
		return "{\"name\": \""+ newFileName +"\", \"id\": \""+ Integer.toString(answerAttached.getId()) +"\", \"type\":\"insert\"}";
	}
	
	
	
	@RequestMapping(value = "/forum/removeAnswerAttachment", method = RequestMethod.POST)
	public @ResponseBody boolean removeAnswerAttachment(Locale locale, Model model, HttpServletRequest request) {
		
		System.out.println("EEEEEE");
		
		int attachedFilesIDRemove = Integer.parseInt(request.getParameter("attachedIdRemove"));
		
		System.out.println("YYYYY: " + attachedFilesIDRemove);
		
		AnswerAttachedContentDAO answerAttachedDAO = (AnswerAttachedContentDAOImpl) appContext.getBean("answerAttachedContentDAO", AnswerAttachedContentDAOImpl.class);
		
		try{
			
			AnswerAttachedContent answerAttached = answerAttachedDAO.get(attachedFilesIDRemove);
			
			FileManager fm = new FileManager();
			fm.deleteFile(answerAttached.getFilePath());
			
			answerAttachedDAO.delete(answerAttached);
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	
	}
	
	
}
