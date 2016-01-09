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
 * Handles requests for send invitation to students.
 */
@Controller
public class SendInvitationController {
    
    private static final Logger logger = LoggerFactory.getLogger(SendInvitationController.class);
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired  
    MessageSource messageSource;
    
    @RequestMapping(value = "/sendInvitation", method = RequestMethod.GET)
    public String statistics(
	    @RequestParam(value = "courseName", required = false) String courseName,
	    Locale locale, 
	    Model model,
	    HttpServletRequest request) {
		logger.info("SendInvitation Page", locale);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());
		
		System.err.println("CourseName received: "+courseName);
		model.addAttribute("courseSelected", courseName);
		
		processSelectableCourse(locale, model, request, username);
		processSelectableStudent(locale, model, request,courseName);
		processCancellableStudent(locale, model, request,courseName);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/sendInvitation";
    }
    
    @RequestMapping(value = "/sendInvitation_InviteAll", method = RequestMethod.POST)
    public String inviteAll(
	    @RequestParam(value = "courseSelected", required = true) String courseSelected,
	    @RequestParam(value = "InviteAll", required = true) String value, 
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
		
		model.addAttribute("courseSelected", courseSelected);
		
		InvitationBeanList list = new InvitationBeanList();
		list.addToList(new InvitationBean("Corso 1"));
		list.addToList(new InvitationBean("Corso 2"));
		list.addToList(new InvitationBean("Corso 3"));
		list.addToList(new InvitationBean("Corso 4"));
		model.addAttribute("courseList", list);
		
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/sendInvitation";
    }
    
    @RequestMapping(value = "/sendInvitation_InviteSingle", method = RequestMethod.POST)
    public String inviteSingle(
	    @RequestParam(value = "courseSelected", required = true) String courseSelected,
	    @RequestParam(value = "StudentName", required = true) String studentName, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Received: "+studentName);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());
		
		model.addAttribute("courseSelected", courseSelected);
		
		InvitationBeanList list = new InvitationBeanList();
		list.addToList(new InvitationBean("Corso 1"));
		list.addToList(new InvitationBean("Corso 2"));
		list.addToList(new InvitationBean("Corso 3"));
		list.addToList(new InvitationBean("Corso 4"));
		model.addAttribute("courseList", list);
		
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/sendInvitation";
    }
    
    @RequestMapping(value = "/sendInvitation_CancelAll", method = RequestMethod.POST)
    public String cancelAll(
	    @RequestParam(value = "courseSelected", required = true) String courseSelected,
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
		
		model.addAttribute("courseSelected", courseSelected);
		
		InvitationBeanList list = new InvitationBeanList();
		list.addToList(new InvitationBean("Corso 1"));
		list.addToList(new InvitationBean("Corso 2"));
		list.addToList(new InvitationBean("Corso 3"));
		list.addToList(new InvitationBean("Corso 4"));
		model.addAttribute("courseList", list);
		
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/sendInvitation";
    }
    
    @RequestMapping(value = "/sendInvitation_CancelSingle", method = RequestMethod.POST)
    public String cancelSingle(
	    @RequestParam(value = "courseSelected", required = true) String courseSelected,
	    @RequestParam(value = "StudentName", required = true) String studentName, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Cancel: "+studentName);
		
		String username = (String) request.getSession().getAttribute("loggedIn");
		if ( username == null ) {			
		    return "redirect:/";
		}
		User user = DaoHelper.getUserDAO().get(username);
		model.addAttribute("user",user.getUsername());
		
		model.addAttribute("courseSelected", courseSelected);
		
		InvitationBeanList list = new InvitationBeanList();
		list.addToList(new InvitationBean("Corso 1"));
		list.addToList(new InvitationBean("Corso 2"));
		list.addToList(new InvitationBean("Corso 3"));
		list.addToList(new InvitationBean("Corso 4"));
		model.addAttribute("courseList", list);
		
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/sendInvitation";
    }
    
    private void processSelectableCourse(Locale locale, Model model,HttpServletRequest request, String professorName){
	if(professorName!=null){
	    InvitationBeanList list = new InvitationBeanList();
	    list.addToList(new InvitationBean("Corso 1"));
	    list.addToList(new InvitationBean("Corso 2"));
	    list.addToList(new InvitationBean("Corso 3"));
	    list.addToList(new InvitationBean("Corso 4"));
	    model.addAttribute("courseList", list);
	}
    }
    
    private void processSelectableStudent(Locale locale, Model model,HttpServletRequest request, String courseName){
	if(courseName!=null){
	    InvitationBeanList list = new InvitationBeanList();
	    list.addToList(new InvitationBean("Studente 1"));
	    list.addToList(new InvitationBean("Studente 2"));
	    list.addToList(new InvitationBean("Studente 3"));
	    list.addToList(new InvitationBean("Studente 4"));
	    model.addAttribute("studentList", list);
	}
    }
    
    private void processCancellableStudent(Locale locale, Model model,HttpServletRequest request, String courseName){
	if(courseName!=null){
	    InvitationBeanList list = new InvitationBeanList();
	    list.addToList(new InvitationBean("Studente 1"));
	    list.addToList(new InvitationBean("Studente 2"));
	    list.addToList(new InvitationBean("Studente 3"));
	    list.addToList(new InvitationBean("Studente 4"));
	    model.addAttribute("invitedStudent", list);
	}
    }
}
