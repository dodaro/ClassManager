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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.classmanager.invitations.InvitationBean;
import it.unical.classmanager.invitations.InvitationBeanList;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.User;

/**
 * @author Aloisius92
 * Handles requests for checking the requested invitations.
 */
@Controller
public class CheckRequestedInvitationsController {
    
    private static final Logger logger = LoggerFactory.getLogger(CheckRequestedInvitationsController.class);
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired  
    MessageSource messageSource;
    
    @RequestMapping(value = "/checkRequestedInvitations", method = RequestMethod.GET)
    public String statistics(Locale locale, Model model,HttpServletRequest request) {
	logger.info("CheckRequestedInvitations Page", locale);
	
	String username = (String) request.getSession().getAttribute("loggedIn");	
	if ( username == null ) {			
	    return "redirect:/";
	}
	User user = DaoHelper.getUserDAO().get(username);
	model.addAttribute("user",user.getUsername());
		
	processAcceptableCourse(locale, model, request);
	InvitationController.checkNewInvitations(model, user);
	
	return "invitation/checkRequestedInvitations";
    }
    
    @RequestMapping(value = "/checkRequestedInvitations_All", method = RequestMethod.POST)
    public String acceptAll(
	    @RequestParam(value = "AcceptAll", required = true) String value, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Accept: "+value);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());
						
		processAcceptableCourse(locale, model, request);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/checkRequestedInvitations";
    }
    
    @RequestMapping(value = "/checkRequestedInvitations_Single", method = RequestMethod.POST)
    public String acceptSingle(
	    @RequestParam(value = "CourseName", required = true) String courseName, 
	    @RequestParam(value = "ProfessorName", required = false) String professorName,
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Accept: "+courseName+", Professor: "+professorName);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());

		processAcceptableCourse(locale, model, request);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/checkRequestedInvitations";
    }
  
    
    private void processAcceptableCourse(Locale locale, Model model,HttpServletRequest request){
	InvitationBeanList list = new InvitationBeanList();
	list.addToList(new InvitationBean("Corso 1", "Professore 1"));
	list.addToList(new InvitationBean("Corso 2", "Professore 2"));
	list.addToList(new InvitationBean("Corso 3", "Professore 3"));
	list.addToList(new InvitationBean("Corso 4", "Professore 4"));
	model.addAttribute("acceptableCourse", list);
    }
    
}
