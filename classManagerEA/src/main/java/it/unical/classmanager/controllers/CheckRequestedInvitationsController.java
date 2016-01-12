package it.unical.classmanager.controllers;

import java.util.Calendar;
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

import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAO;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.CustomHeaderAndBody;
import it.unical.classmanager.utils.GenericContainerBean;
import it.unical.classmanager.utils.GenericContainerBeanList;
import it.unical.classmanager.utils.UserSessionChecker;

/**
 * @author Aloisius92
 * Handles requests for checking the requested invitations.
 */
@Controller
public class CheckRequestedInvitationsController {
    private static final Logger logger = LoggerFactory.getLogger(CheckRequestedInvitationsController.class);
    private final static String HEADER = "pageCommons/head.jsp";
    private final static String BODY = "invitation/checkRequestedInvitations.jsp";
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired  
    MessageSource messageSource;
    
    @RequestMapping(value = "/checkRequestedInvitations", method = RequestMethod.GET)
    public String checkRequestedInvitations(Locale locale, Model model,HttpServletRequest request) {
	logger.info("CheckRequestedInvitations Page", locale);

	User user = UserSessionChecker.checkUserSession(model, request);
	if ( user == null ) {			
	    return "redirect:/";
	}	
	
	processAcceptableCourse(locale, model, request, (Student) user);
	InvitationController.checkNewInvitations(model, user);
	CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);
	
	return "layout";
    }
    
    @RequestMapping(value = "/checkRequestedInvitations_All", method = RequestMethod.POST)
    public String acceptAll(
	    @RequestParam(value = "AcceptAll", required = true) String value, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Accept: "+value);
		
		User user = UserSessionChecker.checkUserSession(model, request);
		if ( user == null ) {			
		    return "redirect:/";
		}	
		
		processAcceptInvitationAll((Student) user);
		processAcceptableCourse(locale, model, request, (Student) user);
		InvitationController.checkNewInvitations(model, user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);

		return "layout";
    }
    
    @RequestMapping(value = "/checkRequestedInvitations_Single", method = RequestMethod.POST)
    public String acceptSingle(
	    @RequestParam(value = "CourseName", required = true) String courseName, 
	    @RequestParam(value = "ProfessorName", required = false) String professorName,
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		System.err.println("Accept: "+courseName+", Professor: "+professorName);
		
		User user = UserSessionChecker.checkUserSession(model, request);
		if ( user == null ) {			
		    return "redirect:/";
		}	
		
		processAcceptInvitationSingle((Student) user, courseName, professorName);
		processAcceptableCourse(locale, model, request, (Student) user);
		InvitationController.checkNewInvitations(model, user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);

		return "layout";
    }
    
    private void processAcceptableCourse(Locale locale, Model model,HttpServletRequest request, Student student){
	GenericContainerBeanList acceptableCourse = getAcceptableCourse(student);
	if(acceptableCourse!=null){
	    model.addAttribute("acceptableCourse", acceptableCourse);
	}
    }
    
    private GenericContainerBeanList getAcceptableCourse(Student student){
	List<Object[]> acceptableCourse = DaoHelper.getRegistrationStudentClassDAO().getAcceptableCourse(student);
	if(acceptableCourse.size()>0){
	    GenericContainerBeanList list = new GenericContainerBeanList();
	    for(int i=0; i<acceptableCourse.size(); i++){
		list.addToList(new GenericContainerBean(
			acceptableCourse.get(i)[0].toString(),
			acceptableCourse.get(i)[1].toString()));	    
	    }
	    return list;
	}
	return null;
    }
    
    private void processAcceptInvitationAll(Student student) {
	GenericContainerBeanList acceptableCourse = getAcceptableCourse(student);
	for(int i=0; i<acceptableCourse.size(); i++){
	    processAcceptInvitationSingle(student, acceptableCourse.get(i).getField1(), acceptableCourse.get(i).getField2());
	}
    }
    
    private void processAcceptInvitationSingle(Student student, String courseName, String professorName) {
	CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseName);	
	RegistrationStudentClassDAO registrationStudentClassDAO = DaoHelper.getRegistrationStudentClassDAO();
	
	if(registrationStudentClassDAO.existRegistration(student, courseClass)){
	    RegistrationStudentClass registrationStudentClass = registrationStudentClassDAO.getRegistration(student, courseClass);
	    registrationStudentClass.setAcceptedDate(Calendar.getInstance().getTime());
	    registrationStudentClassDAO.update(registrationStudentClass);
	}
    } 
    
}
