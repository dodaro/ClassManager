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
 * Handles requests for checking the sended invitations.
 */
@Controller
public class CheckInvitationsController {
    
    private static final Logger logger = LoggerFactory.getLogger(CheckInvitationsController.class);
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired  
    MessageSource messageSource;
    
    /**
     * Show statistics based on the kind of user.
     */
    @RequestMapping(value = "/checkInvitations", method = RequestMethod.GET)
    public String statistics(Locale locale, Model model,HttpServletRequest request) {
	logger.info("CheckInvitations Page", locale);
	
	String username = (String) request.getSession().getAttribute("loggedIn");
	if ( username == null ) {			
	    return "redirect:/";
	}
	User user = DaoHelper.getUserDAO().get(username);
	model.addAttribute("user",user.getUsername());
	
	processAcceptableStudent(locale, model, request);
	InvitationController.checkNewInvitations(model, user);
	
	return "invitation/checkInvitations";
    }
    
    @RequestMapping(value = "/checkInvitations_AcceptAll", method = RequestMethod.POST)
    public String inviteAll(
	    @RequestParam(value = "AcceptAll", required = true) String value, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Received: "+value);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());
		
		processAcceptableStudent(locale, model, request);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/checkInvitations";
    }
    
    @RequestMapping(value = "/checkInvitations_AcceptSingle", method = RequestMethod.POST)
    public String inviteSingle(
	    @RequestParam(value = "courseName", required = true) String courseName,
	    @RequestParam(value = "studentName", required = true) String studentName, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Received: "+studentName+", Course: "+courseName);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());
		
		processAcceptableStudent(locale, model, request);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/checkInvitations";
    }
    
    private void processAcceptableStudent(Locale locale, Model model,HttpServletRequest request){
	InvitationBeanList list = new InvitationBeanList();
	list.addToList(new InvitationBean("Studente 1", "Corso 1"));
	list.addToList(new InvitationBean("Studente 2", "Corso 2"));
	list.addToList(new InvitationBean("Studente 3", "Corso 1"));
	list.addToList(new InvitationBean("Studente 4", "Corso 4"));
	model.addAttribute("studentList", list);
    }
}
