package it.unical.classmanager.controllers;


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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.PasswordHashing;
import it.unical.classmanager.model.UserLogin;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired  
	private MessageSource messageSource;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String register(Locale locale, Model model,HttpServletRequest request) {
		if ( request.getSession().getAttribute("loggedIn") != null ) {
			return "redirect:/";
		}
		model.addAttribute("userLoginForm",new UserLogin());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@Valid @ModelAttribute("userLoginForm")UserLogin user,BindingResult result,Model model, Locale locale,HttpServletRequest request) {
		
		if ( request.getSession().getAttribute("loggedIn") != null ) {
			return "redirect:/";
		}
		
		if ( result.hasErrors() ) {
			return "login";
		}
		
		UserDAO userDao = (UserDAOImpl) context.getBean("userDao");
		
		String username = user.getUsername();
		String givenPassword = user.getPassword();
		
		
		User userfromDB = userDao.get(username);
		
		//TODO: deserves better handling
		if ( userfromDB == null ) {
			model.addAttribute("error",messageSource.getMessage("message.invalidUser",null,locale));
			return "";
		}
		
		String passwordField = userfromDB.getHash();
		int separator = passwordField.lastIndexOf(":");
		String hash = passwordField.substring(0,separator);
		String salt = passwordField.substring(separator+1,passwordField.length());
		
		
		String calculated = PasswordHashing.getInstance().getHash(givenPassword,salt);
		
		logger.info(hash + " " + salt+ " "+ calculated); 
		if ( calculated.equals(hash) ) {
			request.getSession().setAttribute("loggedIn", user.getUsername());			
		}
		
		return "redirect:/";
	}
	
}
