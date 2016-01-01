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
		questionDAO.create(question);
		
		
		return "redirect:questions";
	}
	
	
	
	
	
}
