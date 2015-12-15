package it.unical.classmanager.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.classmanager.model.FullCalendarEventBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AldoLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(AldoLoginController.class);
	
	/**
	 * Manages the request related to the calendar
	 */
	@RequestMapping(value = "/aldo", method = RequestMethod.GET)
	public String getCalendar(Model model,HttpServletRequest request) {
		
		request.getSession().setAttribute("loggedIn", true);
		return "redirect:/";
			
	}
	
}
