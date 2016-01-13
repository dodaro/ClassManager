package it.unical.classmanager.controllers.forum;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.classmanager.controllers.forum.manager.ForumAttachmentGCManager;
import it.unical.classmanager.controllers.forum.manager.QuestionManager;
import it.unical.classmanager.editorData.EditorStatus;
import it.unical.classmanager.editorData.Environment;
import it.unical.classmanager.managers.EnvironmentManger;
import it.unical.classmanager.model.dao.AnswerDAO;
import it.unical.classmanager.model.dao.AnswerDAOImpl;
import it.unical.classmanager.model.dao.QuestionDAO;
import it.unical.classmanager.model.dao.QuestionDAOImpl;
import it.unical.classmanager.model.data.Answer;
import it.unical.classmanager.model.data.Question;
import it.unical.classmanager.utils.enumative.EnvironmentEnum;

/**
 * Handles requests for the forum page.
 */
@Controller
public class QuestionsController {
	
	@Autowired
	private ApplicationContext appContext;
	
	private QuestionManager questionManager;
	

	@RequestMapping(value = {"/questions", "/forum"}, method = RequestMethod.GET)
	public String redirectToQuestions(Locale locale, Model model) {
		return "redirect:/forum/questions";
	}
	
	@RequestMapping(value = "gc", method = RequestMethod.GET)
	public String attachmentGarbageCollect(Locale locale, Model model) {
		
		ForumAttachmentGCManager gc = new ForumAttachmentGCManager();
		gc.garbageCollect();
		
		return "";
	}
	
	
	@RequestMapping(value = "/forum/questions", method = RequestMethod.GET)
	public String getQuestions(Locale locale, Model model) {
		
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		List<Question> allQuestions = questionDAO.getAllQuestions();
		
		this.questionManager = new QuestionManager(allQuestions);
		
		model.addAttribute("questions", this.questionManager.getCurrentPageQuestions());
		model.addAttribute("pageCount", this.questionManager.getPageCount());
		
		model.addAttribute("currPage", Integer.toString(this.questionManager.getCurrentPageNumber())+1);
		model.addAttribute("pageSize", this.questionManager.getPageSize());
		
		return "forum/questions";
	}
	
	
	
	
	@RequestMapping(value = "/forum/questionsPage", method = RequestMethod.GET)
	public String getSpecificPage(Locale locale, Model model, @RequestParam("page") int pageNumber) {
		
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		List<Question> allQuestions = questionDAO.getAllQuestions();
		
		this.questionManager = new QuestionManager(allQuestions);
		
		model.addAttribute("questions", this.questionManager.getSpecificPageQuestions(pageNumber));
		model.addAttribute("pageCount", this.questionManager.getPageCount());
		model.addAttribute("currPage", Integer.toString(this.questionManager.getCurrentPageNumber())+1);
		model.addAttribute("pageSize", this.questionManager.getPageSize());
		
		return "forum/questions";
	}
	
	
}
