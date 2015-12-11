package it.unical.classmanager.controllers;


import java.util.Locale;

import javax.crypto.spec.OAEPParameterSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.PasswordHashing;
import it.unical.classmanager.model.User;
import it.unical.classmanager.model.UserDAO;
import it.unical.classmanager.model.UserLogin;
import it.unical.classmanager.model.UserRegister;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	@Autowired
	private ApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		model.addAttribute("userLoginForm",new UserLogin());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(Locale locale, Model model,UserLogin user) {
		
		UserDAO userDao = (UserDAO) context.getBean("userDao");
		
		String username = user.getUsername();
		String givenPassword = user.getPassword();
		
		
		User userfromDB = userDao.getUser(username);
		
		String passwordField = userfromDB.getPassword();
		int separator = passwordField.lastIndexOf(":");
		String hash = passwordField.substring(0,separator);
		String salt = passwordField.substring(separator+1,passwordField.length());
		
		
		String calculated = PasswordHashing.getInstance().getHash(givenPassword,salt);
		
		logger.info(hash + " " + salt+ " "+ calculated); 
		if ( calculated.equals(hash) ) {
			
			//TODO: handle session
			
		}
		
		return "redirect:/";
	}
	
}
