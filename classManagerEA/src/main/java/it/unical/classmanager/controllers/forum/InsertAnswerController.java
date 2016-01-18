package it.unical.classmanager.controllers.forum;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.dao.AnswerAttachedContentDAO;
import it.unical.classmanager.model.dao.AnswerAttachedContentDAOImpl;
import it.unical.classmanager.model.dao.AnswerDAO;
import it.unical.classmanager.model.dao.AnswerDAOImpl;
import it.unical.classmanager.model.dao.QuestionDAO;
import it.unical.classmanager.model.dao.QuestionDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.Answer;
import it.unical.classmanager.model.data.AnswerAttachedContent;
import it.unical.classmanager.model.data.Question;
import it.unical.classmanager.model.data.User;

/**
 * Handles requests for the forum page.
 */
@Controller
public class InsertAnswerController {
	
	@Autowired
	private ApplicationContext appContext;
	
	private final static String HEADER = "forum/insertAnswerHead.jsp";
	private final static String BODY = "forum/insertAnswerBody.jsp";
	
	
	@RequestMapping(value = "/forum/createAnswer", method = RequestMethod.POST)
	public String createAnswer(Locale locale, Model model, HttpServletRequest request) {
		
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		
		int qid = Integer.parseInt(request.getParameter("qid"));
		Question question = questionDAO.get(qid);
		
		model.addAttribute("question", question);
		
		Answer answer = new Answer();
		model.addAttribute("answer", answer);
			
		model.addAttribute("customHeader", InsertAnswerController.HEADER);
		model.addAttribute("customBody", InsertAnswerController.BODY);
		
		return "layout";
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
			
			model.addAttribute("customHeader", InsertAnswerController.HEADER);
			model.addAttribute("customBody", InsertAnswerController.BODY);
			
			return "layout";
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
	
	
}
