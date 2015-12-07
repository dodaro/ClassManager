package it.unical.classmanager.controllers;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.UserRegister;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		model.addAttribute("userRegisterForm",new UserRegister());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleRegistration(Locale locale, Model model,UserRegister user) {
		System.out.println(user.toString());
		return "redirect:/";
	}
	
}
