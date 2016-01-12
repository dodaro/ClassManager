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

import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.CustomHeaderAndBody;
import it.unical.classmanager.utils.UserSessionChecker;

/**
 * @author Aloisius92
 * Handles requests for the statistics page.
 */
@Controller
public class InvitationController {    
    private static final Logger logger = LoggerFactory.getLogger(InvitationController.class);
    private final static String HEADER = "pageCommons/head.jsp";
    private final static String BODY_STUDENT = "invitation/invitationStudent.jsp";
    private final static String BODY_PROFESSOR = "invitation/invitationProfessor.jsp";
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired  
    MessageSource messageSource;
    
    public static void checkNewInvitations(Model model, String user){
	checkNewInvitations(model, DaoHelper.getUserDAO().get(user));
    }
    
    public static void checkNewInvitations(Model model, User user){
	int newInvitations = 0;
	if(user instanceof Student){
	    newInvitations = DaoHelper.getRegistrationStudentClassDAO().getNewInvitationsOfStudent((Student) user);
	} else if (user instanceof Professor){
	    newInvitations = DaoHelper.getRegistrationStudentClassDAO().getNewInvitationsOfProfessor((Professor) user);
	}
	
	if(newInvitations>0){
	    model.addAttribute("newInvitations", newInvitations+"");	    
	}
    }
    
    /**
     * Show statistics based on the kind of user.
     */
    @RequestMapping(value = "/invitation", method = RequestMethod.GET)
    public String statistics(Locale locale, Model model,HttpServletRequest request) {
	logger.info("Invitation Page", locale);
	
	User user = UserSessionChecker.checkUserSession(model, request);
	if ( user == null ) {			
	    return "redirect:/";
	}
	
	if(user instanceof Student){
	    logger.info("Student invitation page accessed by "+user.getUsername(), locale);
	    model.addAttribute("student", (Student)user);
	    CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY_STUDENT);
	}
	if(user instanceof Professor){
	    logger.info("Professor invitation page accessed by "+user.getUsername(), locale);	
	    model.addAttribute("professor", (Professor)user);
	    CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY_PROFESSOR);
	}
	
	InvitationController.checkNewInvitations(model, user);
	
	return "layout";
    }
    
}
