package it.unical.classmanager.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.User;

public class UserSessionChecker {
    
    public static User checkUserSession(Model model, HttpServletRequest request){
	User user = null;
	String username = (String) request.getSession().getAttribute("loggedIn");
	if ( username != null ) {
	    user = DaoHelper.getUserDAO().get(username);
	    model.addAttribute("user",user.getUsername());
	}			
	return user;
    }
    
}
