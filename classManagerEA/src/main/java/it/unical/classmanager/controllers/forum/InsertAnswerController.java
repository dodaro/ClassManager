package it.unical.classmanager.controllers.forum;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.editorData.EditorStatus;
import it.unical.classmanager.editorData.Environment;
import it.unical.classmanager.managers.EnvironmentManger;
import it.unical.classmanager.model.dao.AnswerDAO;
import it.unical.classmanager.model.dao.AnswerDAOImpl;
import it.unical.classmanager.model.dao.QuestionDAO;
import it.unical.classmanager.model.dao.QuestionDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.Answer;
import it.unical.classmanager.model.data.Question;
import it.unical.classmanager.model.data.User;
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
		question = questionDAO.get(question.getId());
		
		model.addAttribute("question", question);
		
		Answer answer = new Answer();
		model.addAttribute("answer", answer);
			
		return "forum/insertAnswer";
	}
	
	
	@RequestMapping(value = "/forum/insertAnswer", method = RequestMethod.POST)
	public String insertAnswer(Locale locale, Model model, @ModelAttribute("answer") Answer answer, HttpServletRequest request) {
		
		UserDAO userDao = appContext.getBean("userDao",UserDAOImpl.class);
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		AnswerDAO answerDAO = (AnswerDAOImpl) appContext.getBean("answerDAO", AnswerDAOImpl.class);
		
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		User tmpUser = userDao.get(username);
		
		int qid = Integer.parseInt((String) request.getParameter("qid"));
		Question tmpQuestion = questionDAO.get(qid);
		
		answer.setUser(tmpUser);
		answer.setQuestion(tmpQuestion);
		
		answerDAO.create(answer);
		
			
		return "redirect:detailedQuestion?qid=" + qid;
	}
	
	
	
}
