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
    public String sendInvitation(
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
		
		processInviteAll((Professor) user, courseSelected);
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
		
		processInviteSingle((Professor) user, courseSelected, studentName);
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
		
		processCancellAll((Professor) user, courseSelected);
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
		
		processCancellSingle((Professor) user, courseSelected, studentName);
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		
		return "invitation/sendInvitation";
    }
    
    private void processSelectableCourse(Locale locale, Model model,HttpServletRequest request, String professorName){
	InvitationBeanList list = getSelectableCourse(professorName);
	if(list!=null){
	    model.addAttribute("courseList", list);
	}
    }
    
    private InvitationBeanList getSelectableCourse(String professorName){
	if(professorName!=null){
	    Professor professor = (Professor) DaoHelper.getUserDAO().get(professorName);
	    List<Object[]> selectableCourse = DaoHelper.getRegistrationStudentClassDAO().getSelectableCourse(professor);
	    if(selectableCourse.size()>0){
		InvitationBeanList list = new InvitationBeanList();
		for(int i=0; i<selectableCourse.size(); i++){
		    list.addToList(new InvitationBean(selectableCourse.get(i)[0].toString()));	    
		}
		return list;
	    }
	}
	return null;
    }
    
    private void processSelectableStudent(Locale locale, Model model,HttpServletRequest request, String courseName){
	InvitationBeanList list = getSelectableStudent(courseName);
	if(list!=null){
	    model.addAttribute("studentList", list);
	}    
    }
    
    private InvitationBeanList getSelectableStudent(String courseName){
	if(courseName!=null){
	    CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseName);
	    List<Object[]> selectableStudent = DaoHelper.getRegistrationStudentClassDAO().getSelectableStudent(courseClass);
	    if(selectableStudent.size()>0){
		InvitationBeanList list = new InvitationBeanList();
		for(int i=0; i<selectableStudent.size(); i++){
		    list.addToList(new InvitationBean(selectableStudent.get(i)[0].toString()));	    
		}
		return list;
	    }
	}
	return null;
    }
    
    private void processCancellableStudent(Locale locale, Model model,HttpServletRequest request, String courseName){
	InvitationBeanList list = getCancellableStudent(courseName);
	if(list!=null){
	    model.addAttribute("invitedStudent", list);
	}    
    }
    
    private InvitationBeanList getCancellableStudent(String courseName){
	if(courseName!=null){
	    CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseName);
	    List<Object[]> cancellableStudent = DaoHelper.getRegistrationStudentClassDAO().getCancellableStudent(courseClass);
	    if(cancellableStudent.size()>0){
		InvitationBeanList list = new InvitationBeanList();
		for(int i=0; i<cancellableStudent.size(); i++){
		    list.addToList(new InvitationBean(cancellableStudent.get(i)[0].toString()));	    
		}
		return list;
	    }
	}
	return null;
    }
    
    private void processInviteAll(Professor professor, String courseSelected) {
	InvitationBeanList selectableStudent = getSelectableStudent(courseSelected);
	for(int i=0; i<selectableStudent.size(); i++){
	    processInviteSingle(professor, courseSelected, selectableStudent.get(i).getField1());
	}
    }
    
    private void processInviteSingle(Professor professor, String courseSelected, String studentName) {
	CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseSelected);
	Student student = (Student)  DaoHelper.getUserDAO().get(studentName);
	
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
    
    private void processCancellAll(Professor professor, String courseSelected) {
	InvitationBeanList cancellableStudent = getCancellableStudent(courseSelected);
	for(int i=0; i<cancellableStudent.size(); i++){
	    processInviteSingle(professor, courseSelected, cancellableStudent.get(i).getField1());
	}
    }
    
    private void processCancellSingle(Professor professor, String courseSelected, String studentName) {
	CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseSelected);
	Student student = (Student)  DaoHelper.getUserDAO().get(studentName);
	
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
