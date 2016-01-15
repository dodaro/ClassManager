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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAO;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.CustomHeaderAndBody;
import it.unical.classmanager.utils.GenericContainerBeanList;
import it.unical.classmanager.utils.UserSessionChecker;

/**
 * @author Aloisius92
 * Handles requests for send invitation to students.
 */
@Controller
public class SendInvitationController {
    private static final Logger logger = LoggerFactory.getLogger(SendInvitationController.class);
    private final static String HEADER = "invitation/invitationHead.jsp";
    private final static String BODY = "invitation/sendInvitation.jsp";
    
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
		
		User user = UserSessionChecker.checkUserSession(model, request);
		if ( user == null ) {			
		    return "redirect:/";
		}		
		
		if(courseName!=null){
		    model.addAttribute("courseSelected", courseName);
		}
		
		processSelectableCourse(locale, model, request, user.getUsername());
		processSelectableStudent(locale, model, request, courseName);
		processCancellableStudent(locale, model, request, courseName);
		InvitationController.checkNewInvitations(model, user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);
		
		return "layout";
    }
    
    @RequestMapping(value = "/sendInvitation", method = RequestMethod.POST)
    public String sendInvitation(
	    @RequestParam(value = "courseName", required = false) String courseName,
	    @RequestParam(value = "sendFile", required = false) CommonsMultipartFile sendFile,
	    Locale locale, 
	    Model model,
	    HttpServletRequest request) {
		logger.info("SendInvitation Page", locale);
		
		User user = UserSessionChecker.checkUserSession(model, request);
		if ( user == null ) {			
		    return "redirect:/";
		}		
		
		if(courseName!=null){
		    System.err.println("CourseName received: "+courseName.trim());
		    model.addAttribute("courseSelected", courseName);
		}
		
		processInviteStudentFromFile(model, sendFile, (Professor) user);
		processSelectableCourse(locale, model, request, user.getUsername());
		processSelectableStudent(locale, model, request, courseName);
		processCancellableStudent(locale, model, request, courseName);
		InvitationController.checkNewInvitations(model, user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);
		
		return "layout";
    }
    
    @RequestMapping(value = "/sendInvitation_InviteAll", method = RequestMethod.POST)
    public String inviteAll(
	    @RequestParam(value = "courseSelected", required = true) String courseSelected,
	    @RequestParam(value = "InviteAll", required = true) String value, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){
		
		User user = UserSessionChecker.checkUserSession(model, request);
		if ( user == null ) {			
		    return "redirect:/";
		}	
		
		model.addAttribute("courseSelected", courseSelected);

		processInviteAll((Professor) user, courseSelected);
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);
		
		return "layout";
    }    
    
    @RequestMapping(value = "/sendInvitation_InviteSingle", method = RequestMethod.POST)
    public String inviteSingle(
	    @RequestParam(value = "courseSelected", required = true) String courseSelected,
	    @RequestParam(value = "StudentName", required = true) String studentName, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){		
		
		User user = UserSessionChecker.checkUserSession(model, request);
		if ( user == null ) {			
		    return "redirect:/";
		}	
		
		model.addAttribute("courseSelected", courseSelected);

		processInviteSingle((Professor) user, courseSelected, studentName);
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);
		
		return "layout";
    }
    
    @RequestMapping(value = "/sendInvitation_CancelAll", method = RequestMethod.POST)
    public String cancelAll(
	    @RequestParam(value = "courseSelected", required = true) String courseSelected,
	    @RequestParam(value = "CancelAll", required = true) String value, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){	
		
		User user = UserSessionChecker.checkUserSession(model, request);
		if ( user == null ) {			
		    return "redirect:/";
		}	
		
		model.addAttribute("courseSelected", courseSelected);

		processCancellAll((Professor) user, courseSelected);
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);
		
		return "layout";
    }
    
    @RequestMapping(value = "/sendInvitation_CancelSingle", method = RequestMethod.POST)
    public String cancelSingle(
	    @RequestParam(value = "courseSelected", required = true) String courseSelected,
	    @RequestParam(value = "StudentName", required = true) String studentName, 
	    Locale locale,
	    Model model,
	    HttpServletRequest request){		
		
		User user = UserSessionChecker.checkUserSession(model, request);
		if ( user == null ) {			
		    return "redirect:/";
		}	
		
		model.addAttribute("courseSelected", courseSelected);

		processCancellSingle((Professor) user, courseSelected, studentName);
		processSelectableStudent(locale, model, request, courseSelected);
		processCancellableStudent(locale, model, request, courseSelected);
		InvitationController.checkNewInvitations(model, user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY);
		
		return "layout";
    }
    
    private void processSelectableCourse(Locale locale, Model model,HttpServletRequest request, String professorName){
	GenericContainerBeanList list = getSelectableCourse(professorName);
	if(list!=null){
	    model.addAttribute("courseList", list);
	}
    }
    
    private GenericContainerBeanList getSelectableCourse(String professorName){
	if(professorName!=null){
	    Professor professor = (Professor) DaoHelper.getUserDAO().get(professorName);
	    List<Object[]> objectList = DaoHelper.getRegistrationStudentClassDAO().getSelectableCourse(professor);
	    if(objectList.size()>0){
		GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
		return beanList;
	    }
	}
	return null;
    }
    
    private void processSelectableStudent(Locale locale, Model model,HttpServletRequest request, String courseName){
	GenericContainerBeanList list = getSelectableStudent(courseName);
	if(list!=null){
	    model.addAttribute("studentList", list);
	}    
    }
    
    private GenericContainerBeanList getSelectableStudent(String courseName){
	if(courseName!=null){
	    CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseName.substring(1, courseName.length()-1));
	    List<Object[]> objectList = DaoHelper.getRegistrationStudentClassDAO().getSelectableStudent(courseClass);
	    if(objectList.size()>0){
		GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
		return beanList;
	    }
	}
	return null;
    }
    
    private void processCancellableStudent(Locale locale, Model model,HttpServletRequest request, String courseName){
	GenericContainerBeanList list = getCancellableStudent(courseName);
	if(list!=null){
	    model.addAttribute("invitedStudent", list);
	}    
    }
    
    private GenericContainerBeanList getCancellableStudent(String courseName){
	if(courseName!=null){
	    CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseName.substring(1, courseName.length()-1));
	    List<Object[]> objectList = DaoHelper.getRegistrationStudentClassDAO().getCancellableStudent(courseClass);
	    if(objectList.size()>0){
		GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
		return beanList;
	    }
	}
	return null;
    }
    
    private void processInviteAll(Professor professor, String courseSelected) {
	GenericContainerBeanList selectableStudent = getSelectableStudent(courseSelected);
	for(int i=0; i<selectableStudent.size(); i++){
	    processInviteSingle(professor, courseSelected, selectableStudent.get(i).getField1());
	}
    }
    
    private void processInviteSingle(Professor professor, String courseSelected, String studentName) {
	CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseSelected);
	Student student = (Student)  DaoHelper.getUserDAO().get(studentName);
	RegistrationStudentClassDAO registrationStudentClassDAO = DaoHelper.getRegistrationStudentClassDAO();
	int maxIndex = registrationStudentClassDAO.getMaxIndex();
	Calendar cal = Calendar.getInstance();
	
	if(courseClass!=null && student!=null && !registrationStudentClassDAO.existRegistration(student, courseClass)){
	    RegistrationStudentClass registrationStudentClass = new RegistrationStudentClass(
		    maxIndex+1,
		    cal.getTime(), 
		    null, 
		    null, 
		    student, 
		    courseClass);
	    
	    registrationStudentClassDAO.create(registrationStudentClass);
	    //System.err.println("Correct invitation for "+student.getUsername()+", Course: "+courseClass.getName()+"\n");
	}
    }  
    
    private void processInviteStudentFromFile(Model model, CommonsMultipartFile sendFile, Professor professor) {
	if(sendFile != null){
	    if (!sendFile.isEmpty()) {
		byte[] bytes = sendFile.getBytes();
		String fileContent = new String(bytes);
		String[] courseStudentRows = fileContent.split(";");
		for (String row : courseStudentRows){
		    String[] rowSplitted = row.split(",");
		    if(rowSplitted.length==2){
			String courseName = rowSplitted[0].trim();
			String studentUsername = rowSplitted[1].trim();
			//System.out.println("Send invitations to "+studentUsername+" for "+courseName);
			processInviteSingle(professor, courseName, studentUsername);
		    } else {
			// File format wrong
			System.err.println("Wrong file format! File:"+sendFile.getOriginalFilename());
			model.addAttribute("fileFormatError", "fileFormatErrorMessage");
			return;
		    }
		}
	    } 
	}
    }
    
    private void processCancellAll(Professor professor, String courseSelected) {
	GenericContainerBeanList cancellableStudent = getCancellableStudent(courseSelected);
	for(int i=0; i<cancellableStudent.size(); i++){
	    processCancellSingle(professor, courseSelected, cancellableStudent.get(i).getField1());
	}
    }
    
    private void processCancellSingle(Professor professor, String courseSelected, String studentName) {
	CourseClass courseClass = DaoHelper.getCourseClassDAO().get(courseSelected);
	Student student = (Student)  DaoHelper.getUserDAO().get(studentName);
	RegistrationStudentClassDAO registrationStudentClassDAO = DaoHelper.getRegistrationStudentClassDAO();
	
	if(registrationStudentClassDAO.existRegistration(student, courseClass)){
	    RegistrationStudentClass registrationStudentClass = registrationStudentClassDAO.getRegistration(student, courseClass);
	    registrationStudentClassDAO.delete(registrationStudentClass);
	}
    }  
    
}
