package it.unical.classmanager.controllers;


import java.util.Calendar;
import java.util.GregorianCalendar;
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

import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DBInitializatorController {
	
	private static boolean initialized = false;
	private static int numUser = 1000;
	
	@Autowired
	ApplicationContext appContext;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/db_init", method = RequestMethod.GET)
	public String dbInitialization(Locale locale, Model model, HttpServletRequest request) {		
		if(!initialized){
			logger.info("DB initializing...");			

			UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);
		
			for(int i=0; i<numUser; i++){
				if(i<20){	// Creating professors
					String username = "ProfAldo";
					
					User user = new User();
					user.setUsername(username+i);
					user.setFirstName("ProfAldo");
					user.setLastName("ProfAldo");					
					Calendar date = new GregorianCalendar(2011, Calendar.JULY, 3);
				    date.add(Calendar.DAY_OF_MONTH, -7);				    
					user.setBirthDate(date.getTime());
					user.setEmail("profaldo@profaldo.it");
					user.setPassword("ginopaoli");
					user.setConfirmPassword(user.getPassword());
					user.setHash(user.getPassword());						
					userDao.create(user);
												
//					Professor professor = new Professor(i, user.getUsername(), 
//							user.getPassword(), user.getRole(), 
//							user.getFirstName(), user.getLastName(), 
//							user.getEmail(), user.getBirthDate(), 
//							user.getAddress(), new ArrayList<Event>(), 
//							new ArrayList<Question>(), new ArrayList<Answer>(),
//							i, new ArrayList<Communications>(),
//							new ArrayList<CourseClass>());
//					
//					userDao.create(professor);
//					logger.info("Created "+professor);
				} else { // Creo Studenti
//					String username = "StudentAldo";
//					
//					Student student = new Student();
//					student.setUsername(username+i);
//					student.setFirstName("aldo");
//					student.setLastName("aldo");
//					
//					Calendar date = new GregorianCalendar(2011, Calendar.JULY, 3);
//				    date.add(Calendar.DAY_OF_MONTH, -7);
//				    
//					student.setBirthDate(date.getTime());
//					student.setEmail("aldo@aldo.it");
//					student.setPassword("ginopaoli");
//					student.setConfirmPassword(student.getPassword());
//					student.setHash(student.getPassword());
//					
//					userDao.create(student);
				}					
			}
			
			initialized = true;
		} else {
			logger.info("The DB is up!");
		}	
		
		return "redirect:/";
		//return "layout";
	}
}
