package it.unical.classmanager.controllers;


import java.util.ArrayList;
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
import it.unical.classmanager.model.data.AttendanceStudentLecture;
import it.unical.classmanager.model.data.Communications;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.HomeworkStudentSolving;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.StudentExamPartecipation;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.DateFactory;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DBInitializatorController {
	
	private static boolean initialized = false;
	private static int numProfessors = 32;
	private static int numUser = numProfessors*numProfessors;
	
	@Autowired
	ApplicationContext appContext;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/db_init", method = RequestMethod.GET)
	public String dbInitialization(Locale locale, Model model, HttpServletRequest request) {		
		if(!initialized){
			logger.info("DB initializing...");			

			UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);
		
			for(int i=0; i<numUser; i++){
				if(i<numProfessors){	// Creating professors
					String username = "ProfAldo";					
					User user = new User();
					user.setUsername(username+i);
					user.setFirstName("ProfAldo_FirstName");
					user.setLastName("ProfAldo_LastName");
					user.setRole("Professor");				    
					user.setBirthDate(DateFactory.getRandomDate().getTime());
					user.setEmail("profaldo@profaldo.it");
					user.setPassword("ginopaoli");
					user.setConfirmPassword(user.getPassword());
					user.setHash(user.getPassword());													
					Professor professor = new Professor(user,
							i, new ArrayList<Communications>(),
							new ArrayList<CourseClass>());
					
					User retrievedUser = userDao.get(username+i);
					if(retrievedUser==null){
						userDao.create(professor);
						logger.info("Created "+professor);						
					}
				} else {	// Creating students
					String username = "StudentAldo";
					
					User user = new User();
					user.setUsername(username+i);
					user.setFirstName("Aldo_FirstName");
					user.setLastName("Aldo_LastName");
					user.setRole("Student");				    
					user.setBirthDate(DateFactory.getRandomDate().getTime());
					user.setEmail("studentaldo@profaldo.it");
					user.setPassword("ginopaoli");
					user.setConfirmPassword(user.getPassword());
					user.setHash(user.getPassword());		
								
					Student student = new Student(user, 
							i, 
							DateFactory.getRandomDate().getTime(), 
							new ArrayList<StudentExamPartecipation>(), 
							new ArrayList<AttendanceStudentLecture>(), 
							new ArrayList<RegistrationStudentClass>(), 
							new ArrayList<HomeworkStudentSolving>());
				
					User retrievedUser = userDao.get(username+i);
					if(retrievedUser==null){
						userDao.create(student);
						logger.info("Created "+student);						
					} 
				}					
			}
			
			initialized = true;
		} else {
			logger.info("The DB is up!");
		}	
		
		return "redirect:/";
	}
}
