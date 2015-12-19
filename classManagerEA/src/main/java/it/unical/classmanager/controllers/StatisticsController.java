package it.unical.classmanager.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StatisticsController {

	private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public String statistics(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Statistics Page", locale);

		String user = (String) request.getSession().getAttribute("loggedIn");

		if ( user == null ) {
			return "redirect:/";
		}	

		model.addAttribute("user",user);

		return "statistics";
	}

}
