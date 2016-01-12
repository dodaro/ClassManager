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

import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.UserSessionChecker;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    
    @Autowired
    ApplicationContext appContext;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model,HttpServletRequest request) {
	logger.info("Welcome home! The client locale is {}.", locale);	
	
	User user = UserSessionChecker.checkUserSession(model, request);
	if (user == null) {			
	    return "welcome";
	} 	
	
	model.addAttribute("user",user);
	String role = (String) request.getSession().getAttribute("role");
	if ( role != null ) {
	    model.addAttribute("role",role);
	}
	
	//	corsi attivi per utente (stud/prof)
	//	calendario
	//	ultime lezioni aggiunte
	//	ultimi materiali aggiunti
	//	ultimi compiti
	//	esami disponibili
	
	return "layout";
    }
    
}
