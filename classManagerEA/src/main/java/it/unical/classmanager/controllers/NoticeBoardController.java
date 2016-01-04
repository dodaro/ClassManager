package it.unical.classmanager.controllers;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class NoticeBoardController {

	@Autowired
	private ApplicationContext context;
	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);
	
	private final static String HEADER = "noticeboard/noticeboardHeader.jsp";
	private final static String BODY = "noticeboard/noticeboardBody.jsp";
	
	/**
	 * returns the notice board
	 */
	@RequestMapping(value = "/noticeboard", method = RequestMethod.GET)
	public String noticeBoard(Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		
		if ( request.getSession().getAttribute("loggedIn") == null || request.getSession().getAttribute("role") == null ) {
			redirectAttributes.addAttribute("error", "session");
			return "redirect:/sessionerror";
		}
		
		model.addAttribute("customHeader", NoticeBoardController.HEADER);
		model.addAttribute("customBody", NoticeBoardController.BODY);

		return "layout";
			
	}
	
}
