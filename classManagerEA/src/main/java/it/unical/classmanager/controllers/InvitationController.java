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

import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;

/**
 * @author Aloisius92
 * Handles requests for the statistics page.
 */
@Controller
public class InvitationController {
    
    private static final Logger logger = LoggerFactory.getLogger(InvitationController.class);
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired  
    MessageSource messageSource;
    
    /**
     * Show statistics based on the kind of user.
     */
    @RequestMapping(value = "/invitation", method = RequestMethod.GET)
    public String statistics(Locale locale, Model model,HttpServletRequest request) {
	logger.info("Invitation Page", locale);
	
	String username = (String) request.getSession().getAttribute("loggedIn");
	
	if ( username == null ) {			
	    return "redirect:/";
	}	
	
	UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		
	User user = userDao.get(username);
	model.addAttribute("user",user.getUsername());
	
	if(user instanceof Student){
	    logger.info("Student invitation page accessed by "+user.getUsername(), locale);
	    model.addAttribute("student", (Student)user);
	    
	}
	if(user instanceof Professor){
	    logger.info("Professor invitation page accessed by "+user.getUsername(), locale);	
	    model.addAttribute("professor", (Professor)user);
	}
	
	return "invitation";
    }
    
}
