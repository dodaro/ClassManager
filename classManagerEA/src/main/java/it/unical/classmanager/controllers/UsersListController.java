package it.unical.classmanager.controllers;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.data.Communications;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;

@Controller
public class UsersListController {

	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired  
	private MessageSource messageSource;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/userslist", method = RequestMethod.GET)
	public String usersList(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
				
		if ( request.getSession().getAttribute("loggedIn") == null || request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin") ) {
			return "redirect:/";
		}
		
		UserDAO userDao = (UserDAO) appContext.getBean("userDao");
		List<User> usersList = userDao.getAllUsers();
		
		model.addAttribute("users",usersList);
		
		return "userslist";
	}
	
	/**
	 * Search for user
	 */
	@RequestMapping(value = "/searchusers", method = RequestMethod.POST)
	public String searchUsers(Locale locale, Model model,HttpServletRequest request,@RequestParam("lastname") String lastName) {
		logger.info("Welcome home! The client locale is {}.", locale);
				
		if ( request.getSession().getAttribute("loggedIn") == null || request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin") ) {
			return "redirect:/";
		}
				
		if ( lastName == null || lastName.length() <= 0 ) {
			return "redirect:/userslist";
		} else if ( lastName.length() < 4 ) {
			model.addAttribute("inputError",messageSource.getMessage("searchField.length.error",null, locale));
		}
		
		UserDAO userDao = (UserDAO) appContext.getBean("userDao");
		List<User> usersList = userDao.getUsersByLastName(lastName);
		
		model.addAttribute("users",usersList);
		
		return "userslist";
	}

	
	/**
	 * makes user Professor
	 */
	@RequestMapping(value = "/promoteuser", method = RequestMethod.POST)
	public String promoteuser(Locale locale, Model model,HttpServletRequest request,@RequestParam("user") String userName) {
		logger.info("Welcome home! The client locale is {}.", locale);
				
		if ( request.getSession().getAttribute("loggedIn") == null || request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")  ) {
			return "redirect:/";
		}
				
		if ( userName == null || userName.length() <= 0 ) {
			return "redirect:/userslist";
		} 
		
		UserDAO userDao = (UserDAO) appContext.getBean("userDao");
		User user = (User) userDao.get(userName);
		userDao.delete(user);
		//THIS IS A FAKE PASSWORD
		user.setPassword("password");
		user.setConfirmPassword(user.getPassword());
		user.setRole("Professor");
		logger.info(user.toString());
		
		Professor professor = new Professor(user,0,new ArrayList<Communications>(),new ArrayList<CourseClass>());
		userDao.create(professor);

		
		return "redirect:/userslist";
	}

	
}
