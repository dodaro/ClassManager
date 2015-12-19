package it.unical.classmanager.controllers;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DBInitializatorController {
	
	private boolean initialized = false;
	
//	@Autowired
//	private ApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Destroys the session relying on the common method called in GET
	 */
	@RequestMapping(value = "/db_init", method = RequestMethod.GET)
	public String initDB(Locale locale, Model model,HttpServletRequest request) {
		
		if(!initialized){
			logger.info("DB initializing...", locale);
			initialized = true;
		} else {
			logger.info("The DB is initialized!", locale);
		}
		
		return "redirect:/";
	}
}
