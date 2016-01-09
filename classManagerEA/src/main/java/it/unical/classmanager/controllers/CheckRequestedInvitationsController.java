package it.unical.classmanager.controllers;

import java.util.List;
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
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;
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
    public String checkRequestedInvitations(Locale locale, Model model,HttpServletRequest request) {
	logger.info("CheckRequestedInvitations Page", locale);
	
	String username = (String) request.getSession().getAttribute("loggedIn");	
	if ( username == null ) {			
	    return "redirect:/";
	}
	User user = DaoHelper.getUserDAO().get(username);
	model.addAttribute("user",user.getUsername());
	
	processAcceptableCourse(locale, model, request, (Student) user);
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
		
		processAcceptInvitationAll((Student) user);
		processAcceptableCourse(locale, model, request, (Student) user);
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
		
		processAcceptInvitationSingle((Student) user, courseName, professorName);
		processAcceptableCourse(locale, model, request, (Student) user);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/checkRequestedInvitations";
    }
    
    private void processAcceptableCourse(Locale locale, Model model,HttpServletRequest request, Student student){
	InvitationBeanList acceptableCourse = getAcceptableCourse(student);
	if(acceptableCourse!=null){
	    model.addAttribute("acceptableCourse", acceptableCourse);
	}
    }
    
    private InvitationBeanList getAcceptableCourse(Student student){
	List<Object[]> acceptableCourse = DaoHelper.getRegistrationStudentClassDAO().getAcceptableCourse(student);
	if(acceptableCourse.size()>0){
	    InvitationBeanList list = new InvitationBeanList();
	    for(int i=0; i<acceptableCourse.size(); i++){
		list.addToList(new InvitationBean(
			acceptableCourse.get(i)[0].toString(),
			acceptableCourse.get(i)[1].toString()));	    
	    }
	    return list;
	}
	return null;
    }
    
    private void processAcceptInvitationAll(Student student) {
	InvitationBeanList acceptableCourse = getAcceptableCourse(student);
	for(int i=0; i<acceptableCourse.size(); i++){
	    processAcceptInvitationSingle(student, acceptableCourse.get(i).getField1(), acceptableCourse.get(i).getField2());
	}
    }
    
    private void processAcceptInvitationSingle(Student student, String courseName, String professorName) {
	CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseName);
	Professor professor = (Professor) DaoHelper.getUserDAO().get(professorName);
	
	//    RegistrationStudentClass registrationStudentClass = new RegistrationStudentClass(
	//	    k,
	//	    invitationDate, 
	//	    date, 
	//	    date, 
	//	    student, 
	//	    courseClass);
	//    k++;
	//    registrationStudentClassDAO.create(registrationStudentClass);
    } 
    
}
