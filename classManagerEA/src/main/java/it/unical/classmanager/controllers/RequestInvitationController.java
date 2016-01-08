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
	
	//	model.addAttribute("noUnselectableCourse", "empty");
	//	model.addAttribute("noSelectableCourse", "empty");
	
	InvitationController.checkNewInvitations(model, user);
	
	return "invitation/requestInvitation";
    }
    
}
