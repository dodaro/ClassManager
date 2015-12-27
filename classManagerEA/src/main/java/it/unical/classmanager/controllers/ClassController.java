package it.unical.classmanager.controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.unical.classmanager.model.dao.CourseClassDAO;
import it.unical.classmanager.model.dao.CourseClassDAOImpl;
import it.unical.classmanager.model.dao.LectureDAO;
import it.unical.classmanager.model.dao.LectureDAOImpl;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Homework;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.utils.FileManager;

/**
 * This class allows to: 
 * - get Files starting from a root (students, lectures)
 * - create a new Lecture
 * - add an Homework (Professor)
 * - upload an Homework or a material for a lecture
 */
@Controller
public class ClassController {

	private final static String HEADER = "classPage/classPageHeader.jsp";
	private final static String BODY = "classPage/classPageBody.jsp";

	private final static short HOMEWORK_PATH_POSITION = 4;

	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);

	/*
	 * this path is used when a professor wants to see the folder of his students
	 */
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String getStudents(Model model) {

		model.addAttribute("customHeader", ClassController.HEADER);
		model.addAttribute("customBody", ClassController.BODY);

		model.addAttribute("lecture", new Lecture());
		model.addAttribute("homework", new Homework());
		
		model.addAttribute("filesType",FileBrowserController.LECTURES_ROOT_TYPE);
		logger.info("getClassPage");
		return "layout";

	}
	
	/*
	 * this path is used when a professor wants to see files related to his lectures
	 */
	@RequestMapping(value = "/classes", method = RequestMethod.GET)
	public String getClasses(Model model) {

		model.addAttribute("customHeader", ClassController.HEADER);
		model.addAttribute("customBody", ClassController.BODY);

		model.addAttribute("lecture", new Lecture());
		model.addAttribute("homework", new Homework());
		
		model.addAttribute("filesType",FileBrowserController.LECTURES_ROOT_TYPE);
		logger.info("getClassPage");
		return "layout";

	}

	/**
	 * creates a new class
	 * @param model
	 * @param lecture the informations about the new Lecture
	 * @return classPage.jsp
	 */
	@RequestMapping(value = "/createClass", method = RequestMethod.POST)
	public String createClass(Model model, Lecture lecture, HttpServletRequest request) {

		//TODO Devo ricavarlo dalla sessione
		String currentPath = "enterpriseApplication/lectures";
		int id = 0;
		
		//retrieves the owner course of the new lesson
		CourseClassDAO courseClassDao = appContext.getBean("courseClassDAO",CourseClassDAOImpl.class);
		CourseClass courseClass = courseClassDao.get(id);

		lecture.setCourseClass(courseClass);

		//creates the new lecture
		LectureDAO lectureDao = appContext.getBean("lectureDAO",LectureDAOImpl.class);

		//retrieves the informations about the last lesson owned by the logged user
		String username = (String) request.getSession().getAttribute("loggedIn");
		Lecture lastLecture = lectureDao.getLastLectureAdded(username);

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

		if(!success){
			logger.error("failed to create directory " + name + " in " + currentPath);
			return "layout";
		}

		model.addAttribute("customHeader", ClassController.HEADER);
		model.addAttribute("customBody", ClassController.BODY);

		model.addAttribute("lecture", new Lecture());
		model.addAttribute("homework", new Homework());

		model.addAttribute("filesType",FileBrowserController.LECTURES_ROOT_TYPE);	
		logger.info("createClass");

		return "layout";

	}

	/**
	 * allows to create a new directory in which store the files related to a particular homework
	 * @param lecture the lecture to which this homework is referred
	 */
	@RequestMapping(value = "/addHomework", method = RequestMethod.POST)
	public String addHomework(Model model, Homework homework, @RequestParam("referredLesson") String lesson) {

		String currentPath = "enterpriseApplication/lectures" + File.separator + lesson + File.separator + FileManager.HOMEWORK_PATH;
		boolean success = new FileManager().mkDir(currentPath, homework.getName());
		
		if(!success){
			logger.error("failed to create directory " + homework.getName() + " in " + currentPath);
			return "layout";
		}
		
		model.addAttribute("customHeader", ClassController.HEADER);
		model.addAttribute("customBody", ClassController.BODY);

		model.addAttribute("lecture", new Lecture());
		model.addAttribute("homework", new Homework());

				
		logger.info("createHomework");

		return "redirect:classes#files/enterpriceApplication/lectures/" + lesson + "/" + FileManager.HOMEWORK_PATH;
	}

	/**
	 * Handles the requests to upload a new file. Creates the file int the "path" in the file system
	 * @param file the file uploaded
	 * @param path the path where store the file
	 * @return
	 */
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("file") MultipartFile file, @RequestParam("path") String path) {


		boolean success = new FileManager().mkMultipartFile(file, path, file.getOriginalFilename());
		if(!success)
			logger.error("cannot save the file " + path + "/" + file.getOriginalFilename());


		/*
		 * We need to understand where the file is uploaded in order to create the corresponding database instance.
		 * i.e. a path like "files/lectures/homework/" implies that a new Homework must be created, so we extract the 
		 * keyword "homework", that is the last level of the path
		 */

		String locationSplit[] = path.split("/");
		String location = locationSplit[HOMEWORK_PATH_POSITION];

		//TODO Non so come fare ad aggiungere un nuovo homework:
		/*
		 *  1. Ricavare la lezione associata. lo posso fare dal path
		 *  2. Creo una cartella con il nome del file e creo il file dentro
		 *  3. Creo una istanza di homework nel database
		 *  4. Come gestisco i file collegati?
		 *  
		 *  Si potrebbe mettere nella view un bottone add homework. Il controller crea una nuova cartella ed
		 *  un'istanza di homework. dentro la cartella c'è il bottone upload, che aggiunge file collegati a quell'homework
		 */

		logger.info("saving file");
		return "{\"status\": " + success + "}";
	}

}
