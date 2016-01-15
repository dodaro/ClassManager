package it.unical.classmanager.controllers.blackboard;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the forum page.
 */
@Controller
public class BlackboardCollectorController {
	
	@Autowired
	private ApplicationContext appContext;
	

	
	@RequestMapping(value = "/blackboard", method = RequestMethod.GET)
	public String getBlackboardPage(Locale locale, Model model) {
		
		
		return "blackboard/blackboard";
	}
	
}
