package it.unical.classmanager.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.data.AttendanceStudentLecture;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.model.data.Student;

/**
 * Gestisce la view per le presenze
 * 
 * @author Alessandro
 *
 */

@Controller
public class AttendanceLessonController
{
	private static final Logger logger = LoggerFactory.getLogger(AttendanceCourseController.class);
		
	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String loadLessonAttendances(HttpServletRequest request, @ModelAttribute("lecture") Lecture lecture, Model model) 
	{
		// TODO Controllare che l'utente corrente non è uno studente o che sia loggato
		
		if(lecture == null)
			lecture = new Lecture();
		else
			logger.info("Id: " + lecture.getId());
			
		lecture.setTopic("PO");		

		// TODO Prendere gli studenti che seguono quella determinata materia dal DB scartando quelli che sono stati già inseriti come presenti
		// In questo modo si possono marcare come selezionati gli utenti che sono stati salvati come presenti in precedenza
		// Una volta effettuato il submit poi la lista degli studenti presenti verrà aggiornata
		Student[] students = new Student[5];
		for(int i = 0; i < students.length; i++)
		{
			students[i] = new Student();
			students[i].setUsername("Student" + i);
		}
		Student[] studentsChecked = new Student[2];
		List<AttendanceStudentLecture> asl = new ArrayList<AttendanceStudentLecture>();
		for(int i = 0; i < studentsChecked.length; i++)
		{
			studentsChecked[i] = new Student();
			studentsChecked[i].setUsername("StudentChecked" + i);
			asl.add(new AttendanceStudentLecture(1, studentsChecked[i], lecture));
		}
		lecture.setAttendanceStudentLectures(asl);
		
		model.addAttribute("lecture", lecture);
		model.addAttribute("students", students);
		model.addAttribute("attendanceStudentLectures", lecture.getAttendanceStudentLectures());
		return "attendanceLesson";
	}
	
	@RequestMapping(value = "/attendance", method = RequestMethod.POST)
	public String saveLessonAttendances(HttpServletRequest request, @ModelAttribute("lecture") Lecture lecture, Model model) 
	{
		logger.info("Size: " + lecture.getAttendanceStudentLectures().size());	
		
		// TODO Effettuare l'update della lezione
		return "attendanceLesson";
	}
	
	/*
	 * La funzione seguente permette mappare gli oggetti, in questo caso gli studenti che vengono dichiarati presenti alla suddetta lezione, come appartenenti alla classe Studente.
	 * Questo perchè Spring non permette di restituire una lista di oggetti, ma solo una lista di String (int, float ecc.). 
	 * Quindi, all'interno di questa list<String> vengono presi gli studenti nel seguente modo: in tale lista sono contenute le chiavi primarie degli studenti, che, tramite query vengono presi dal DB.
	 * Successivamente vengono create le tuple relative alla partecipazione dello studente alla data lezione, e vengono restituite. 
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception 
	{
		binder.registerCustomEditor(List.class, "attendanceStudentLectures", new CustomCollectionEditor(List.class) 
		{
			@Override
			protected Object convertElement(Object element) 
			{	
				if (element instanceof String) 
				{
					AttendanceStudentLecture attendanceStudentLecture = new AttendanceStudentLecture(); 
					// TODO Trovare lo studente nel DB data la chiave primaria e creare la tupla per la presenza
					Student s = new Student();
					s.setUsername((String)element);
					attendanceStudentLecture.setStudent(s);
					return attendanceStudentLecture;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}
}