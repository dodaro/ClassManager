package it.unical.classmanager.controllers.forum;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.controllers.forum.data.QuestionSearchSetting;
import it.unical.classmanager.model.dao.QuestionDAO;
import it.unical.classmanager.model.dao.QuestionDAOImpl;
import it.unical.classmanager.model.data.Question;

/**
 * Handles requests for the forum page.
 */
@Controller
public class SearchQuestionController {
	
	@Autowired
	private ApplicationContext appContext;
	
	
	@RequestMapping(value = "/forum/searchQuestion", method = RequestMethod.GET)
	public String getSearchQuestionForm(Locale locale, Model model) {
		
		
		model.addAttribute("searchSettings", new QuestionSearchSetting());
		model.addAttribute("questionsList", new ArrayList<Question>());
		
		return "forum/searchQuestion";
	}
	
	
	
	@RequestMapping(value = "/forum/searchQuestion", method = RequestMethod.POST)
	public String getSearchedQuestion(Locale locale, Model model, @ModelAttribute("searchSettings") QuestionSearchSetting searchSettings) {
		
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		List<Question> searchedQuestions = questionDAO.searchQuestion(searchSettings);
		
		model.addAttribute("searchSettings", searchSettings);
		model.addAttribute("questionsList", searchedQuestions);
		
		return "forum/searchQuestion";
	}
	
}
