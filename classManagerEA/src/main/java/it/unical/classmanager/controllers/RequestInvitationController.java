package it.unical.classmanager.controllers;

import java.util.List;
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
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;
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
    
    @RequestMapping(value = "/requestInvitation", method = RequestMethod.GET)
    public String requestInvitation(Locale locale, Model model,HttpServletRequest request) {
	logger.info("RequestInvitation Page", locale);
	
	String username = (String) request.getSession().getAttribute("loggedIn");
	if ( username == null ) {			
	    return "redirect:/";
	}
	User user = DaoHelper.getUserDAO().get(username);
	model.addAttribute("user",user.getUsername());
	
	processSelectableCourse(locale, model, request, (Student) user);
	processCancellableCourse(locale, model, request, (Student) user);	
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
		
		processRequestInvitationAll((Student) user);		
		processSelectableCourse(locale, model, request, (Student) user);
		processCancellableCourse(locale, model, request, (Student) user);
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
		
		processRequestInvitationSingle((Student) user, courseName, professorName);
		processSelectableCourse(locale, model, request, (Student) user);
		processCancellableCourse(locale, model, request, (Student) user);
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
		
		processCancellInvitationAll((Student) user);
		processSelectableCourse(locale, model, request, (Student) user);
		processCancellableCourse(locale, model, request, (Student) user);
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
		
		processCancellInvitationSingle((Student) user, courseName, professorName);
		processSelectableCourse(locale, model, request, (Student) user);
		processCancellableCourse(locale, model, request, (Student) user);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/requestInvitation";
    }
    
    private void processSelectableCourse(Locale locale, Model model,HttpServletRequest request, Student student){
	InvitationBeanList selectableCourse = getSelectableCourse(student);
	if(selectableCourse!=null){
	    model.addAttribute("selectableCourse", selectableCourse);
	}
    }
    
    private InvitationBeanList getSelectableCourse(Student student){
	List<Object[]> selectableCourse = DaoHelper.getRegistrationStudentClassDAO().getSelectableCourse(student);
	if(selectableCourse.size()>0){
	    InvitationBeanList list = new InvitationBeanList();
	    for(int i=0; i<selectableCourse.size(); i++){
		list.addToList(new InvitationBean(
			selectableCourse.get(i)[0].toString(), 
			selectableCourse.get(i)[1].toString()));	    
	    }
	    return list;
	}	
	return null;
    }
    
    private void processCancellableCourse(Locale locale, Model model,HttpServletRequest request, Student student){
	InvitationBeanList cancellableCourse = getCancellableCourse(student);
	if(cancellableCourse!=null){
	    model.addAttribute("cancellableCourse", cancellableCourse);
	}
    }
    
    private InvitationBeanList getCancellableCourse(Student student){
	List<Object[]> cancellableCourse = DaoHelper.getRegistrationStudentClassDAO().getCancellableCourse(student);
	if(cancellableCourse.size()>0){
	    InvitationBeanList list = new InvitationBeanList();
	    for(int i=0; i<cancellableCourse.size(); i++){
		list.addToList(new InvitationBean(
			cancellableCourse.get(i)[0].toString(), 
			cancellableCourse.get(i)[1].toString()));	    
	    }
	    return list;
	}
	return null;
    }    
    
    private void processRequestInvitationAll(Student student) {
	InvitationBeanList selectableCourse = getSelectableCourse(student);
	for(int i=0; i<selectableCourse.size(); i++){
	    processRequestInvitationSingle(student, selectableCourse.get(i).getField1(), selectableCourse.get(i).getField2());
	}
    }
    
    private void processRequestInvitationSingle(Student student, String courseName, String professorName) {
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
    
    private void processCancellInvitationAll(Student student) {
	InvitationBeanList selectableCourse = getSelectableCourse(student);
	for(int i=0; i<selectableCourse.size(); i++){
	    processCancellInvitationSingle(student, selectableCourse.get(i).getField1(), selectableCourse.get(i).getField2());
	}
    }
    
    private void processCancellInvitationSingle(Student student, String courseName, String professorName) {
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
