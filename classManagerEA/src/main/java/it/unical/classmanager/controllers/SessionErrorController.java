package it.unical.classmanager.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionErrorController {

	private final static String HEADER = "sessionerror/sessionerrorHeader.jsp";
	private final static String BODY = "sessionerror/sessionerrorBody.jsp";
	
	@Autowired
	ApplicationContext appContext;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MessageSource messageSource;
	
	
	/**
	 * Simply displays a page with the error given by the "error" String passed as attribute check NoticeBoardController to see how to use it.
	 */
	@RequestMapping(value = "/sessionerror", method = RequestMethod.GET)
	public String usersList(Locale locale, Model model,HttpServletRequest request,@ModelAttribute("error") String error) {
		
		
//		if ( error == null ) {
//			model.addAttribute("error",messageSource.getMessage("message.nosession", null, locale))
//		}
		if ( error.equals("session")) {
			model.addAttribute("error",messageSource.getMessage("message.nosession", null, locale));
		}
		
		model.addAttribute("customHeader", SessionErrorController.HEADER);
		model.addAttribute("customBody", SessionErrorController.BODY);

		return "layout";
	}
	
}
