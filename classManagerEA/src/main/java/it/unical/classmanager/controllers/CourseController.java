package it.unical.classmanager.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.dao.CourseClassDAO;
import it.unical.classmanager.model.dao.DegreeCourseDAO;
import it.unical.classmanager.model.dao.DegreeCourseDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.AttendanceStudentLecture;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.DegreeCourse;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;

/**
 * Gestione view relativa ai corsi del professore loggato con la possibilità di aggiungere nuovi corsi
 * @author Alessandro *
 */
@Controller
public class CourseController
{
	private final static String HEADER = "course/courseHeader.jsp";
	private final static String BODY = "course/courseBody.jsp";
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceCourseController.class);
	
	@Autowired
	private ApplicationContext context;
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String loadCourses(HttpServletRequest request, Model model) 
	{
		// TODO Controllare che l'utente corrente non è uno studente o che sia loggato
		UserDAO userDAO = context.getBean("userDao", UserDAOImpl.class);
		Professor professor = (Professor) userDAO.get("ProfAldo0");		
		model.addAttribute("professor", professor);
		model.addAttribute("courses", professor.getCourseClasses());
		 
		DegreeCourseDAO degreeCourseDAO = context.getBean("degreeCourseDAO", DegreeCourseDAOImpl.class);
		List<DegreeCourse> degreeCourses = degreeCourseDAO.getAllDegreeCourses();
		model.addAttribute("degreeCourses", degreeCourses);
		
		CourseClass course = new CourseClass();
		model.addAttribute("courseForm", course);
				
		model.addAttribute("customHeader", CourseController.HEADER);
		model.addAttribute("customBody", CourseController.BODY);
		return "layout";
	}
	
	@RequestMapping(value = "/courses", method = RequestMethod.POST)
	public String saveCourse(HttpServletRequest request, @ModelAttribute("courseForm") CourseClass course, Model model) 
	{
		// TODO Controllare che l'utente corrente non è uno studente o che sia loggato
		logger.info(course.toString());
				
		model.addAttribute("customHeader", CourseController.HEADER);
		model.addAttribute("customBody", CourseController.BODY);
		return "layout";
	}
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) 
	{
	  DateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(Date.class, orderDateEditor);
	}
}
