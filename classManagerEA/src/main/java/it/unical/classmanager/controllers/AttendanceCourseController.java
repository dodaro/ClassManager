package it.unical.classmanager.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.dao.AttendanceStudentLectureDAO;
import it.unical.classmanager.model.dao.AttendanceStudentLectureDAOImpl;
import it.unical.classmanager.model.dao.CourseClassDAO;
import it.unical.classmanager.model.dao.CourseClassDAOImpl;
import it.unical.classmanager.model.dao.LectureDAO;
import it.unical.classmanager.model.dao.LectureDAOImpl;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAO;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.AttendanceStudentLecture;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.model.data.Student;

/**
 * Gestisce la view per le presenze degli studenti di un corso
 * 
 * @author Alessandro
 *
 */

@Controller
public class AttendanceCourseController
{
	private final static String HEADER = "attendance/attendanceCourseHeader.jsp";
	private final static String BODY = "attendance/attendanceCourseBody.jsp";
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceLessonController.class);

	@Autowired
	private ApplicationContext context;
	
	@RequestMapping(value = "/view_attendance", method = RequestMethod.GET)
	public String loadCourseAttendances(Model model) 
	{
		// TODO Controllare che l'utente corrente non è uno studente o che sia loggato
		
		// TODO Prendere il corso selezionato in precedenza
		CourseClassDAO courseClassDAO = context.getBean("courseClassDAO", CourseClassDAOImpl.class);
		CourseClass course = courseClassDAO.get(4);	
		//LectureDAO lectureDAO = context.getBean("lectureDAO", LectureDAOImpl.class);
		List<Lecture> lectures = course.getLectures();//lectureDAO.getAllLecturesOfACourse(course);

		// TODO Prendere gli studenti iscritti al corso in ordine alfabetico
		// TODO Ordinare la lista delle lezioni a cui ha partecipato lo studente in base al numero lezione (Tramite query o funzione Java)
		//UserDAO userDao = context.getBean("userDao", UserDAOImpl.class);
		RegistrationStudentClassDAO userDao = context.getBean("registrationStudentClassDAO", RegistrationStudentClassDAOImpl.class);
		AttendanceStudentLectureDAO attendanceStudentLectureDAO = context.getBean("attendanceStudentLectureDAO", AttendanceStudentLectureDAOImpl.class);
		List<Student> students = userDao.getStudentsRegisteredToACourse(course);
		for (Student student : students)
		{
			student.setAttendanceStudentLectures(attendanceStudentLectureDAO.getAllAttendanceStudentLecturesOfACourse(student, course));
		}
								
		// Viene utilizzata casomai il professore intende modificare le presenze di una lezione
		Lecture lecture = new Lecture();
		
		model.addAttribute("course", course);
		model.addAttribute("lectures", lectures);
		model.addAttribute("students", students);
		model.addAttribute("lecture", lecture);		
		
		model.addAttribute("customHeader", AttendanceCourseController.HEADER);
		model.addAttribute("customBody", AttendanceCourseController.BODY);
		return "layout";
	}
}