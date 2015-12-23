package it.unical.classmanager.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.data.AttendanceStudentLecture;
import it.unical.classmanager.model.data.Communications;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.HomeworkStudentSolving;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.StudentExamPartecipation;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.DateTimeFactory;

@Controller
public class UsersListController {

	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MessageSource messageSource;
	
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
		
		
		for ( int i = 0 ; i < 10 ; i++ ) {
			String username = "StudentAldo";
	
			User user = new User();
			user.setUsername(username+i);
			user.setFirstName("Aldo_FirstName");
			user.setLastName("Aldo_LastName");
			user.setRole("Student");				    	
			user.setBirthDate(DateTimeFactory.getRandomDateLessThanYear(
					Calendar.getInstance().get(Calendar.YEAR)-18).getTime());
			user.setEmail("studentaldo@profaldo.it");
			user.setPassword(username+i);
			user.setConfirmPassword(user.getPassword());
			user.setHash(user.getPassword());
			user.setAddress("address");		
	
			Student student = new Student(user, 
					i, 
					DateTimeFactory.getRandomDate().getTime(), 
					new ArrayList<StudentExamPartecipation>(), 
					new ArrayList<AttendanceStudentLecture>(), 
					new ArrayList<RegistrationStudentClass>(), 
					new ArrayList<HomeworkStudentSolving>());
			
			userDao.create(student);

		}
		
		
		PagedListHolder<User> usersList = new PagedListHolder<User>(userDao.getAllUsers());
	    usersList.setPageSize(10);
	    request.getSession().setAttribute("UserListController_usersList", usersList);
		
		model.addAttribute("users",usersList);
		
		return "userslist";
	}
	
	/**
	 * Search for user
	 */
	@RequestMapping(value = "/searchusers", method = RequestMethod.GET)
	public String searchUsers(Model model,Locale locale,HttpServletRequest request ) {
		logger.info("Welcome home! The client locale is {}.", locale);
				
		if ( request.getSession().getAttribute("loggedIn") == null || request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin") ) {
			return "redirect:/";
		}
		
		PagedListHolder<User> usersList = (PagedListHolder<User>) request.getSession().getAttribute("UserListController_usersList");
		if ( usersList == null ) {
			//TODO: HANDLE SESSION TIMEOUT; FOR NOW JUST A REDIRECT
			handleSessionTimeOut();
		}
		
		String nav = request.getParameter("nav");
		if ( nav != null ) {
			if ( nav.equals("prev") ) {
				usersList.previousPage();
			} else if ( nav.equals("next") ) {
				usersList.nextPage();
			}
			model.addAttribute("users", usersList);
		    return "userslist";
		}
		
		
		String lastname = request.getParameter("query");
		if ( lastname == null || lastname.length() < 3 ) {
			model.addAttribute("error", messageSource.getMessage("searchField.length.error", null, locale));
		}
		
		String users = request.getParameter("users");
		int usersPerPage = ( users == null ) ? 10 : Integer.valueOf(users);
		if ( usersPerPage < 10 ) {
			usersPerPage = 10;
		} else if ( usersPerPage > 100 ) {
			usersPerPage = 100;
		}
		
		
		UserDAO userDao = (UserDAO) appContext.getBean("userDao");
		usersList.setSource(userDao.getUsersByLastName(lastname));
	    usersList.setPageSize(usersPerPage);
	    model.addAttribute("users", usersList);
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
		
//		//THIS IS A FAKE PASSWORD
		user.setPassword("password");
		user.setConfirmPassword(user.getPassword());
		user.setRole("Professor");
		Professor professor = new Professor(user,0,new ArrayList<Communications>(),new ArrayList<CourseClass>());
		userDao.create(professor);
//
//		
		return "";
	}
	
	private String handleSessionTimeOut() {
		return "redirect:/userslist";
	};

	
}
