package it.unical.classmanager.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.classmanager.invitations.InvitationBean;
import it.unical.classmanager.invitations.InvitationBeanList;
import it.unical.classmanager.model.UserJsonResponse;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.User;

/**
 * @author Aloisius92
 * Handles requests for request invitation to professors.
 */
@Controller
public class RequestInvitationController {
    
    private static final Logger logger = LoggerFactory.getLogger(RequestInvitationController.class);
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired  
    MessageSource messageSource;
    
    /**
     * Show statistics based on the kind of user.
     */
    @RequestMapping(value = "/requestInvitation", method = RequestMethod.GET)
    public String statistics(Locale locale, Model model,HttpServletRequest request) {
	logger.info("RequestInvitation Page", locale);
	
	String username = (String) request.getSession().getAttribute("loggedIn");
	if ( username == null ) {			
	    return "redirect:/";
	}
	User user = DaoHelper.getUserDAO().get(username);
	model.addAttribute("user",user.getUsername());
		
	processSelectableCourse(locale, model, request);
	processCancellableCourse(locale, model, request);	
	InvitationController.checkNewInvitations(model, user);
	
	return "invitation/requestInvitation";
    }
    
    @RequestMapping(value = "/requestInvitation_All", method = RequestMethod.POST)
    public String requestAll(
	    @RequestParam(value = "RequestAll", required = true) String value, 
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
						
		processSelectableCourse(locale, model, request);
		processCancellableCourse(locale, model, request);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/requestInvitation";
    }
    
    @RequestMapping(value = "/requestInvitation_Single", method = RequestMethod.POST)
    public String requestSingle(
	    @RequestParam(value = "CourseName", required = true) String courseName, 
	    @RequestParam(value = "ProfessorName", required = false) String professorName,
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Received: "+courseName+", Professor: "+professorName);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());
		
		processSelectableCourse(locale, model, request);
		processCancellableCourse(locale, model, request);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/requestInvitation";
    }
    
    @RequestMapping(value = "/requestInvitation_CancelAll", method = RequestMethod.POST)
    public String cancelAll(
	    @RequestParam(value = "CancelAll", required = true) String value, 
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
		
		processSelectableCourse(locale, model, request);
		processCancellableCourse(locale, model, request);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/requestInvitation";
    }
    
    @RequestMapping(value = "/requestInvitation_CancelSingle", method = RequestMethod.POST)
    public String cancelSingle(
	    @RequestParam(value = "CourseName", required = true) String courseName, 
	    @RequestParam(value = "ProfessorName", required = false) String professorName, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Cancel: "+courseName+", Professor: "+professorName);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());
				
		processSelectableCourse(locale, model, request);
		processCancellableCourse(locale, model, request);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/requestInvitation";
    }
    
    private void processSelectableCourse(Locale locale, Model model,HttpServletRequest request){
	InvitationBeanList list = new InvitationBeanList();
	list.addToList(new InvitationBean("Corso 1", "Professore 1"));
	list.addToList(new InvitationBean("Corso 2", "Professore 2"));
	list.addToList(new InvitationBean("Corso 3", "Professore 3"));
	list.addToList(new InvitationBean("Corso 4", "Professore 4"));
	model.addAttribute("selectableCourse", list);
    }
    
    private void processCancellableCourse(Locale locale, Model model,HttpServletRequest request){
	InvitationBeanList list = new InvitationBeanList();
	list.addToList(new InvitationBean("Corso 1", "Professore 1"));
	list.addToList(new InvitationBean("Corso 2", "Professore 2"));
	list.addToList(new InvitationBean("Corso 3", "Professore 3"));
	list.addToList(new InvitationBean("Corso 4", "Professore 4"));
	model.addAttribute("cancellableCourse", list);
    }
}
