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

import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.data.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegisterController {
	
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired  
	private MessageSource messageSource;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model,HttpServletRequest request) {
		if ( request.getSession().getAttribute("loggedIn") != null ) {
			return "redirect:/";
		}
		

		model.addAttribute("userRegisterForm", new User() );
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleRegistration(@Valid @ModelAttribute("userRegisterForm")User user,BindingResult result,Locale locale, Model model,HttpServletRequest request) {
		if ( request.getSession().getAttribute("loggedIn") != null ) {
			return "redirect:/";
		}
		
		if ( result.hasErrors() ) {
			return "register";
		}
		
		UserDAO userDao = (UserDAO) context.getBean("userDao");
		if ( userDao.exists(user.getUsername()) ) {
			model.addAttribute("error",messageSource.getMessage("message.usernameTaken",null,locale));
			return "register";
		} else {
			user.setHash(user.getPassword());
			userDao.create(user);
			return "redirect:/";
		}
	}
	
}
