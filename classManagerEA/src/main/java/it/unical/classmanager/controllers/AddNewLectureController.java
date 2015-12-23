package it.unical.classmanager.controllers;


import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.dao.CourseClassDAO;
import it.unical.classmanager.model.dao.CourseClassDAOImpl;
import it.unical.classmanager.model.dao.LectureDAO;
import it.unical.classmanager.model.dao.LectureDAOImpl;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Event;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.utils.FileManager;

/**
 * Is called when a professor wants to create a new Lecture
 */
@Controller
public class AddNewLectureController {

	private final static String HEADER = "classPage/classPageHeader.jsp";
	private final static String BODY = "classPage/classPageBody.jsp";

	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(AddNewLectureController.class);


	@RequestMapping(value = "/classes", method = RequestMethod.GET)
	public String getClasses(Model model) {

		model.addAttribute("customHeader", AddNewLectureController.HEADER);
		model.addAttribute("customBody", AddNewLectureController.BODY);

		model.addAttribute("lecture", new Lecture());

		logger.info("getClassPage");
		return "layout";

	}

	@RequestMapping(value = "/createClass", method = RequestMethod.POST)
	public String createClass(Model model, Lecture lecture) {

		//Devo ricavarlo dalla sessione
		String currentPath = "enterpriseApplication/lectures";
		int id = 0;


		//retrieves the owner course of the new lesson
		CourseClassDAO courseClassDao = appContext.getBean("courseClassDAO",CourseClassDAOImpl.class);
		CourseClass courseClass = courseClassDao.get(id);

		lecture.setCourseClass(courseClass);

		//creates the new lecture
		LectureDAO lectureDao = appContext.getBean("lectureDAO",LectureDAOImpl.class);

		//retrieves the informations about the last lesson
		//TODO aggiungere controllo su professore
		Lecture lastLecture = lectureDao.getLastLectureAdded();

		//One more than the last lecture
		int number = 0;
		if(lastLecture != null)
			number = lastLecture.getNumber() + 1;
		
		lecture.setNumber(number);

		lectureDao.create(lecture);

		//creates the corresponding folder
		String name = lecture.getNumber() + " - " + lecture.getTopic();
		boolean success = false;

		success = new FileManager().mkDir(currentPath, name);
		success = new FileManager().mkDir(currentPath + File.separator + name, FileManager.HOMEWORK_PATH);
		success = new FileManager().mkDir(currentPath + File.separator + name, FileManager.MATERIALS_PATH);

		if(!success)
			logger.error("failed to create directory " + name + " in " + currentPath);

		model.addAttribute("customHeader", AddNewLectureController.HEADER);
		model.addAttribute("customBody", AddNewLectureController.BODY);

		model.addAttribute("lecture", new Lecture());
		logger.info("createClass");

		return "layout";

	}

}
