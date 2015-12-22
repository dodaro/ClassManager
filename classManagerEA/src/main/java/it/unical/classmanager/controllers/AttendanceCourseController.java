package it.unical.classmanager.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	private static final Logger logger = LoggerFactory.getLogger(AttendanceLessonController.class);
	
	@RequestMapping(value = "/view_attendance", method = RequestMethod.GET)
	public String loadCourseAttendances(Model model) 
	{
		// TODO Controllare che l'utente corrente non è uno studente o che sia loggato
		
		// TODO Prendere il corso selezionato in precedenza
		CourseClass course = new CourseClass();
		course.setName("Enterprise Application");	
		List<Lecture> lectures = new ArrayList<Lecture>();
		for(int i = 0; i < 100; i++)
		{
			Lecture l = new Lecture();
			l.setId(i);
			l.setNumber(i + 1);
			l.setTopic("Topic" + i);
			lectures.add(l);
		}
		course.setLectures(lectures);

		// TODO Prendere gli studenti iscritti al corso in ordine alfabetico
		// TODO Ordinare la lista delle lezioni a cui ha partecipato lo studente in base al numero lezione (Tramite query o funzione Java)
		Student[] students = new Student[5];
		Random rand = new Random();
		for(int i = 0; i < students.length; i++)
		{
			students[i] = new Student();
			students[i].setUsername("Student" + i);
			List<AttendanceStudentLecture> asl = new ArrayList<AttendanceStudentLecture>();
			
			for (int j = 0; j < lectures.size(); j++)
			{
				// Popolo random le lezioni a cui uno studente ha partecipato
				int  n = rand.nextInt(2) + 1;
				if(n == 1)
				{
					AttendanceStudentLecture a = new AttendanceStudentLecture((i*students.length)+j, students[i], lectures.get(j));
					asl.add(a);
				}
			}
			students[i].setAttendanceStudentLectures(asl);
		}
				
		// Viene utilizzata casomai il professore intende modificare le presenze di una lezione
		Lecture lecture = new Lecture();
		
		model.addAttribute("course", course);
		model.addAttribute("lectures", course.getLectures());
		model.addAttribute("students", students);
		model.addAttribute("lecture", lecture);		
		
		return "attendanceCourse";
	}
}