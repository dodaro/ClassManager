package it.unical.classmanager.controllers;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class LogoutController {
	
	@Autowired
	private ApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Destroys the session relying on the common method called in GET
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout(Locale locale, Model model,HttpServletRequest request) {
		return handleRequest(locale,model,request);
	}

	/**
	 * Destroys the session relying on the common method called in POST
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String postLogout(Locale locale, Model model,HttpServletRequest request) {
		return handleRequest(locale, model, request);
	}
	
	private String handleRequest(Locale locale, Model model, HttpServletRequest request) {
		request.getSession().setAttribute("loggedIn", null);
		return "redirect:/";
	}
	
	
}
