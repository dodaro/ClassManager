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

import it.unical.classmanager.invitations.InvitationBean;
import it.unical.classmanager.invitations.InvitationBeanList;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAO;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;
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
    
    @RequestMapping(value = "/checkInvitations", method = RequestMethod.GET)
    public String checkInvitations(Locale locale, Model model,HttpServletRequest request) {
	logger.info("CheckInvitations Page", locale);
	
	String username = (String) request.getSession().getAttribute("loggedIn");
	if ( username == null ) {			
	    return "redirect:/";
	}
	User user = DaoHelper.getUserDAO().get(username);
	model.addAttribute("user",user.getUsername());
	
	processAcceptableStudent(locale, model, request, (Professor) user);
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
		
		processInviteAll((Professor) user);
		processAcceptableStudent(locale, model, request, (Professor) user);
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
		
		processInviteSingle((Professor) user, studentName, courseName);
		processAcceptableStudent(locale, model, request, (Professor) user);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/checkInvitations";
    }
    
    private void processAcceptableStudent(Locale locale, Model model,HttpServletRequest request, Professor professor){
	InvitationBeanList list = getAcceptableStudent(professor);
	if(list!=null){
	    model.addAttribute("studentList", list);
	}
    }
    
    private InvitationBeanList getAcceptableStudent(Professor professor){
	List<Object[]> acceptableStudent = DaoHelper.getRegistrationStudentClassDAO().getAcceptableStudent(professor);
	if(acceptableStudent.size()>0){
	    InvitationBeanList list = new InvitationBeanList();
	    for(int i=0; i<acceptableStudent.size(); i++){
		list.addToList(new InvitationBean(
			acceptableStudent.get(i)[0].toString(),
			acceptableStudent.get(i)[1].toString()));	    
	    }
	    return list;
	}
	return null;
    }

    private void processInviteAll(Professor professor) {
	InvitationBeanList acceptableStudent = getAcceptableStudent(professor);
	for(int i=0; i<acceptableStudent.size(); i++){
	    processInviteSingle(professor, acceptableStudent.get(i).getField1(), acceptableStudent.get(i).getField2());
	}
    }
    
    private void processInviteSingle(Professor professor, String studentName, String courseSelected) {
	CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseSelected);
	Student student = (Student)  DaoHelper.getUserDAO().get(studentName);
	RegistrationStudentClassDAO registrationStudentClassDAO = DaoHelper.getRegistrationStudentClassDAO();
	
	if(registrationStudentClassDAO.existRegistration(student, courseClass)){
	    RegistrationStudentClass registrationStudentClass = registrationStudentClassDAO.getRegistration(student, courseClass);
	    registrationStudentClass.setAcceptedDate(Calendar.getInstance().getTime());
	    registrationStudentClassDAO.update(registrationStudentClass);
	}
    }  

}
