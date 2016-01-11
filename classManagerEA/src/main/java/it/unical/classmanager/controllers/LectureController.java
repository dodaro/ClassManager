package it.unical.classmanager.controllers;

import java.io.File;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.unical.classmanager.model.AbstractFileBean;
import it.unical.classmanager.model.LectureControllerWrapper;
import it.unical.classmanager.model.LectureWrapper;
import it.unical.classmanager.model.FileBean;
import it.unical.classmanager.model.FolderBean;
import it.unical.classmanager.model.dao.CourseClassDAO;
import it.unical.classmanager.model.dao.CourseClassDAOImpl;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.dao.EventDAO;
import it.unical.classmanager.model.dao.EventDAOImpl;
import it.unical.classmanager.model.dao.HomeworkAttachedDAO;
import it.unical.classmanager.model.dao.HomeworkAttachedDAOImpl;
import it.unical.classmanager.model.dao.HomeworkAttachedStudentSolvingDAO;
import it.unical.classmanager.model.dao.HomeworkAttachedStudentSolvingDAOImpl;
import it.unical.classmanager.model.dao.HomeworkDAO;
import it.unical.classmanager.model.dao.HomeworkDAOImpl;
import it.unical.classmanager.model.dao.HomeworkStudentSolvingDAO;
import it.unical.classmanager.model.dao.HomeworkStudentSolvingDAOImpl;
import it.unical.classmanager.model.dao.LectureDAO;
import it.unical.classmanager.model.dao.LectureDAOImpl;
import it.unical.classmanager.model.dao.MaterialDAO;
import it.unical.classmanager.model.dao.MaterialDAOImpl;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAO;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Event;
import it.unical.classmanager.model.data.Homework;
import it.unical.classmanager.model.data.HomeworkAttached;
import it.unical.classmanager.model.data.HomeworkAttachedStudentSolving;
import it.unical.classmanager.model.data.HomeworkStudentSolving;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.model.data.Material;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.DateTimeFactory;
import it.unical.classmanager.utils.FileManager;

//TODO reload of the page when creating new things, update lecture button not yet implemented, retrieve path from session, modal to create lecture (date and hour), deny upload exe
//TODO validation
/**
 * This class allows to: 
 * - get Files starting from a root (students, lectures)
 * - create a new Lecture
 * - add an Homework (Professor)
 * - upload an Homework or a material for a lecture
 */
@Controller
public class LectureController {

	private final static String HEADER = "lecturesPage/lecturesPageHeader.jsp";
	private final static String BODY = "lecturesPage/lecturesPageBody.jsp";
	private static final String STUDENT_BODY = "lecturesPage/studentLecturePage/studentLecturesPageBody.jsp";

	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(LectureController.class);


	@RequestMapping(value = "/lectures", method = RequestMethod.GET)
	public String getClasses(Model model, HttpServletRequest request) {

		if(canCreate(request))
			model.addAttribute("canCreate", true);

		model.addAttribute("lecture", new Lecture());
		return getLectures(model);
	}


	private String getLectures(Model model){

		//TODO retrieve from session
		int idCourse = 1;
		String currentPath = FileManager.RESOURCES_PATH + File.separator + "enterpriseApplication" + File.separator + FileManager.LECTURES_PATH;

		model.addAttribute("customHeader", LectureController.HEADER);
		model.addAttribute("customBody", LectureController.BODY);

		LectureDAO lectureDao = appContext.getBean("lectureDAO", LectureDAOImpl.class);
		List<Lecture> allLecturesOfACourse = lectureDao.getAllLecturesOfACourse(idCourse);

		List<AbstractFileBean> lectures = new ArrayList<AbstractFileBean>();

		adaptLecture(lectures,allLecturesOfACourse, currentPath);

		model.addAttribute("contents", allLecturesOfACourse);
		model.addAttribute("files", lectures);
		model.addAttribute("pwd", FileManager.LECTURES_PATH);

		logger.info("getLectures");

		return "layout";
	}

	@RequestMapping(value = "/lectureContent", method = RequestMethod.GET)
	public String getLectureContent(@Valid LectureControllerWrapper params,	
			BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

		//TODO retrieve from session
		int idCourse = 1;
		String courseName = "enterpriseApplication";
				
		model.addAttribute("customHeader", LectureController.HEADER);
		model.addAttribute("customBody", LectureController.BODY);

		if(result.hasErrors()){
			redirectAttributes.addAttribute("error", "path error");
			return "redirect:/sessionerror";
		}

		List<AbstractFileBean> lectureContent = new ArrayList<AbstractFileBean>();

		int lectureId = params.getParentId();
		String path = FileManager.RESOURCES_PATH + File.separator + courseName + File.separator + FileManager.LECTURES_PATH + File.separator + lectureId;

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		FolderBean homeworks = new FolderBean(lectureId,listOfFiles[0].getName(),AbstractFileBean.FOLDER_TYPE, listOfFiles[0].getPath(), listOfFiles[0].listFiles().length);
		FolderBean materials = new FolderBean(lectureId,listOfFiles[1].getName(),AbstractFileBean.FOLDER_TYPE, listOfFiles[1].getPath(), listOfFiles[1].listFiles().length);

		homeworks.setAction("/homeworks");
		homeworks.setParentId(lectureId);
		materials.setAction("/materials");
		materials.setParentId(lectureId);


		lectureContent.add(homeworks);
		lectureContent.add(materials);

		model.addAttribute("files", lectureContent);
		
		String referred = "/lectures?path=lectures";
		model.addAttribute("backPage", referred);
		
		logger.info("getLectureContent");

		return "layout";
	}


	@RequestMapping(value = "/homeworks", method = RequestMethod.GET)
	public String getHomeworks(@Valid LectureControllerWrapper params,	
			BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

		//TODO retrieve from session
		int courseId = 1;
		String courseName = "enterpiseApplication";
		
		model.addAttribute("customHeader", LectureController.HEADER);
		model.addAttribute("customBody", LectureController.BODY);

		if(result.hasErrors()){
			redirectAttributes.addAttribute("error", "path error");
			return "redirect:/sessionerror";
		}

		int idLecture = params.getParentId();
		String path = FileManager.RESOURCES_PATH + File.separator + courseName + File.separator + FileManager.LECTURES_PATH + File.separator + idLecture + File.separator + FileManager.HOMEWORK_PATH;
		
		model.addAttribute("homework", new Homework());
		model.addAttribute("parentId", idLecture);
		
		//BACK PAGE
		String referred = "/lectureContent?parentId=" + idLecture;
		model.addAttribute("backPage", referred);
		
		if(canCreate(request))
			model.addAttribute("canCreate", true);
		
		return getHomeworks(model, idLecture, path);
	}

	private String getHomeworks(Model model, int idLecture, String path) {

		HomeworkDAO homewrokDAO = appContext.getBean("homeworkDAO", HomeworkDAOImpl.class);
		List<Homework> allLectureHomeworks = homewrokDAO.getAllLectureHomeworks(idLecture);

		List<AbstractFileBean> homeworks = new ArrayList<AbstractFileBean>();

		for (Homework homework : allLectureHomeworks) {

			String name = homework.getName();
			String folderPath = path + File.separator + name;

			int childs = homework.getHomeworkAttacheds().size();

			FolderBean folder = new FolderBean(homework.getId(), name, AbstractFileBean.FOLDER_TYPE, folderPath, childs);
			folder.setParentId(homework.getId());
			folder.setAction("/homeworkAttached");
			homeworks.add(folder);

		}	

		model.addAttribute("contents", allLectureHomeworks);
		model.addAttribute("files", homeworks);
		model.addAttribute("pwd",FileManager.HOMEWORK_PATH);
		
		logger.info("getHomeworks");

		return "layout";
	}


	@RequestMapping(value = "/materials", method = RequestMethod.GET)
	public String getMaterials(@Valid LectureControllerWrapper params,	
			BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

		if(result.hasErrors()){
			redirectAttributes.addAttribute("error", "path error");
			return "redirect:/sessionerror";
		}

		int idLecture = params.getParentId();
		String path = params.getPath();

		model.addAttribute("customHeader", LectureController.HEADER);
		model.addAttribute("customBody", LectureController.BODY);
		model.addAttribute("pwd",FileManager.MATERIALS_PATH);

		MaterialDAO materialDAO = appContext.getBean("materialDAO", MaterialDAOImpl.class);
		List<Material> allLectureMaterials = materialDAO.getAllLectureMaterials(idLecture);

		List<AbstractFileBean> materials = new ArrayList<AbstractFileBean>();

		for (Material material : allLectureMaterials) {

			String name = material.getName();
			String filePath = path + File.separator + name;

			File file = new File(filePath);
			if(file.exists()){
				FileBean fileBean = FileBean.toFileBean(file);
				fileBean.setId(material.getId());
				fileBean.setParentId(idLecture);
				materials.add(fileBean);
			}
		}	

		model.addAttribute("files", materials);
		model.addAttribute("parentId",idLecture);

		if(canCreate(request))
			model.addAttribute("canCreate", true);
		
		String referred = "/lectureContent?parentId=" + idLecture;
		model.addAttribute("backPage", referred);
		
		logger.info("getMaterials");

		return "layout";
	}

	@RequestMapping(value = "/homeworkAttached", method = RequestMethod.GET)
	public String getHomeworkAttached(@Valid LectureControllerWrapper params,	
			BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

		if(result.hasErrors()){
			redirectAttributes.addAttribute("error", "path error");
			return "redirect:/sessionerror";
		}

		int idHomework = params.getParentId();
		String path = params.getPath();

		model.addAttribute("customHeader", LectureController.HEADER);
		model.addAttribute("customBody", LectureController.BODY);

		HomeworkAttachedDAO homeworkAttachedDAO = appContext.getBean("homeworkAttachedDAO", HomeworkAttachedDAOImpl.class);
		List<HomeworkAttached> allHomeworkAttacheds = homeworkAttachedDAO.getAllHomeworkAttacheds(idHomework);

		List<AbstractFileBean> homeworksAttacheds = new ArrayList<AbstractFileBean>();

		for (HomeworkAttached homeworkAttached : allHomeworkAttacheds) {

			String filePath = homeworkAttached.getFilePath();

			File file = new File(filePath);
			if(file.exists()){
				FileBean fileBean = FileBean.toFileBean(file);
				fileBean.setId(homeworkAttached.getId());
				fileBean.setParentId(idHomework);
				fileBean.setAction("#");
				homeworksAttacheds.add(fileBean);
			}
		}	

		model.addAttribute("pwd",FileManager.HOMEWORK_ATTACHED_PATH);
		model.addAttribute("parentId",idHomework);
		model.addAttribute("files", homeworksAttacheds);


		String username = (String) request.getSession().getAttribute("loggedIn");
		UserDAO userDAO = appContext.getBean("userDao", UserDAO.class);
		User user = userDAO.get(username);

		if(user.getRole().equals(User.STUDENT)){
			getHomeworkStudentSolving(model, username, homeworksAttacheds, path);
			model.addAttribute("canCreate",false);
		}
		else
			model.addAttribute("canCreate",true);


		//BACK PAGE
		HomeworkDAO homeworkDAO = DaoHelper.getHomeworkDAO();
		String referred = "/homeworks?parentId=" + homeworkDAO.get(idHomework).getLecture().getId();;
		model.addAttribute("backPage", referred);
				
		logger.info("getHomeworkAttached");
		return "layout";
	}

	private void getHomeworkStudentSolving(Model model, String username, List<AbstractFileBean> homeworksAttacheds, String path) {

		//TODO retrieve from session
		int idCourse = 1;
		String courseName = "enterpriseApplication";

		HomeworkStudentSolvingDAO homeworkStudentSolvingDAO = appContext.getBean("homeworkStudentSolvingDAO", HomeworkStudentSolvingDAOImpl.class);
		List<HomeworkStudentSolving> allHomeworkStudentSolvings = homeworkStudentSolvingDAO.getAllHomeworkStudentSolvings(username);

		for (HomeworkStudentSolving solution : allHomeworkStudentSolvings) {

			String name = solution.getHomework().getName();
			String folderPath = FileManager.RESOURCES_PATH + File.separator + courseName + File.separator + FileManager.STUDENTS_PATH + File.separator + solution.getStudent().getUsername() + File.separator + FileManager.HOMEWORK_PATH + solution.getId();

			int childs = solution.getHomeworkAttachedStudentSolvings().size();

			FolderBean folder = new FolderBean(solution.getId(), name, AbstractFileBean.FOLDER_TYPE, folderPath, childs);
			folder.setParentId(solution.getStudent().getIdentificationNumber());
			folder.setAction("/studentHomeworkAttachments");
			folder.setId(solution.getId());
			homeworksAttacheds.add(folder);
		}	

		model.addAttribute("customBody", LectureController.STUDENT_BODY);
		model.addAttribute("pwd",FileManager.HOMEWORK_STUDENT_SOLVING_PATH);
		model.addAttribute("files", homeworksAttacheds);
	}


	@RequestMapping(value = "/studentHomeworkAttachments", method = RequestMethod.GET)
	public String getHomeworkStudentSolvingAttached(@RequestParam("id") int idHomeworkStudentSolving, Model model, HttpServletRequest request) {

		model.addAttribute("customHeader", LectureController.HEADER);
		model.addAttribute("customBody", LectureController.STUDENT_BODY);

		HomeworkAttachedStudentSolvingDAO homeworkAttachedStudentSolvingDAO = appContext.getBean("homeworkAttachedStudentSolvingDAO", HomeworkAttachedStudentSolvingDAOImpl.class);
		List<HomeworkAttachedStudentSolving> allHomeworkAttachedStudentSolvings = homeworkAttachedStudentSolvingDAO.getAllHomeworkAttachedStudentSolvings(idHomeworkStudentSolving);

		List<AbstractFileBean> homeworksAttacheds = new ArrayList<AbstractFileBean>();

		for (HomeworkAttachedStudentSolving hssAttached : allHomeworkAttachedStudentSolvings) {

			String filePath = hssAttached.getFilePath();

			File file = new File(filePath);
			if(file.exists()){
				FileBean fileBean = FileBean.toFileBean(file);
				fileBean.setId(hssAttached.getId());
				fileBean.setParentId(idHomeworkStudentSolving);
				fileBean.setAction("#");
				homeworksAttacheds.add(fileBean);
			}
		}	

		model.addAttribute("pwd",FileManager.HOMEWORK_STUDENT_SOLVING_ATTACHMENT_PATH);
		model.addAttribute("parentId",idHomeworkStudentSolving);
		model.addAttribute("files", homeworksAttacheds);

		logger.info("getHomeworkStudentSolvingAttached");
		return "layout";
	}



	/**
	 * creates a new class
	 * @param model
	 * @param lecture the informations about the new Lecture
	 * @return classPage.jsp
	 */
	@RequestMapping(value = "/lectures", method = RequestMethod.POST)
	public String createClass(@Valid @ModelAttribute("lecture") LectureWrapper lectureWrapper, BindingResult result, HttpServletRequest request, Model model) {

	
		if(result.hasErrors()){

			model.addAttribute("modalState", "_open");
			model.addAttribute("lecture", lectureWrapper);

			if(canCreate(request))
				model.addAttribute("canCreate", true);
			
			return getLectures(model);
		}

		Lecture lecture = lectureWrapper.getLecture();
		
		//TODO Devo ricavarlo dalla sessione
		String currentPath = "enterpriseApplication/lectures";
		int id = 1;

		//retrieves the owner course of the new lesson
		CourseClassDAO courseClassDao = appContext.getBean("courseClassDAO",CourseClassDAOImpl.class);
		CourseClass courseClass = courseClassDao.get(id);

		lecture.setCourseClass(courseClass);

		//creates the new lecture
		LectureDAO lectureDao = appContext.getBean("lectureDAO",LectureDAOImpl.class);

		//retrieves the informations about the last lesson owned by the logged user
		Lecture lastLecture = lectureDao.getLastLectureAdded(courseClass.getId());

		//One more than the last lecture
		int number = 0;
		if(lastLecture != null)
			number = lastLecture.getNumber() + 1;

		lecture.setNumber(number);

		// Calculating random lecture start hour
		Time beginTime = DateTimeFactory.getRandomTimeBetween(
				new Time(8,0,0), 
				new Time(15,0,0));
		Time endTime = new Time(beginTime.getHours()+2, beginTime.getMinutes(), beginTime.getSeconds());

		lecture.setDate(lecture.getDate());
		lecture.setClassroom(lecture.getClassroom());

		lecture.setBeginHour(beginTime);
		lecture.setEndHour(endTime);

		int newId = lectureDao.create(lecture);

		createCalendarEvent(lecture);

		//creates the corresponding folder
		String name = Integer.toString(newId);
		boolean success = false;

		success = new FileManager().mkDir(currentPath, name);
		success = new FileManager().mkDir(currentPath + File.separator + name, FileManager.HOMEWORK_PATH);
		success = new FileManager().mkDir(currentPath + File.separator + name, FileManager.MATERIALS_PATH);

		if(!success){
			logger.error("failed to create directory " + name + " in " + currentPath);
			return "/layout";
		}

		logger.info("createClass");

		return "redirect:/lectures?path=lectures";

	}


	/**
	 * allows to create a new directory in which store the files related to a particular homework
	 * @param lecture the lecture to which this homework is referred
	 */
	@RequestMapping(value = "/homeworks", method = RequestMethod.POST)
	public String addHomework(@Valid @ModelAttribute("homework") Homework homework, BindingResult result, @RequestParam("parentId") int lectureId, Model model) {

		if(result.hasErrors()){

			model.addAttribute("modalState", "_open");
			model.addAttribute("homework", homework);

			model.addAttribute("customHeader", LectureController.HEADER);
			model.addAttribute("customBody", LectureController.BODY);

			model.addAttribute("parentId", lectureId);

			return getHomeworks(model,lectureId, homework.getFilePath());
		}

		Lecture lecture = appContext.getBean("lectureDAO",LectureDAOImpl.class).get(lectureId);
		homework.setLecture(lecture);

		HomeworkDAO homeworkDAO = appContext.getBean("homeworkDAO",HomeworkDAOImpl.class);

		String lessonName = Integer.toString(lectureId);
		String currentPath = "enterpriseApplication/lectures" + File.separator + lessonName + File.separator + FileManager.HOMEWORK_PATH;

		int newId = homeworkDAO.create(homework);
		homework.setFilePath(currentPath + File.separator + newId);
		homeworkDAO.update(homework);

		boolean success = new FileManager().mkDir(currentPath, Integer.toString(newId));

		if(!success){
			logger.error("failed to create directory " + homework.getName() + " in " + currentPath);
			return "layout";
		}

		model.addAttribute("customHeader", LectureController.HEADER);
		model.addAttribute("customBody", LectureController.BODY);

		model.addAttribute("homework", new Homework());
		model.addAttribute("lectureID", lectureId);

		logger.info("createHomework");

		return "redirect:/homeworks?path=" + currentPath + "&parentId=" + lectureId;
	}


	/**
	 * allows to create a new directory in which store the files related to a particular homeworkStudentSolving
	 * @param homeworkId the homework to which this homeworStudentSolving is referred
	 */
	@RequestMapping(value = "/homeworksStudentSolving", method = RequestMethod.POST)
	public String addHomeworkStudentSolving(@RequestParam("parentId") int homeworkId, HttpServletRequest request, Model model) {

		//TODO Devo ricavarlo dalla sessione
		int idCourse = 1;
		String courseName = "enterpriseApplication";

		//retrieving the logged student
		String username = (String) request.getSession().getAttribute("loggedIn");
		UserDAO userDAO = appContext.getBean("userDao", UserDAO.class);
		User user = userDAO.get(username);
		Student student = new Student(user);

		//retrieving the referred homework
		HomeworkDAO homeworkDAO = appContext.getBean("homeworkDAO",HomeworkDAOImpl.class);
		Homework homework = homeworkDAO.get(homeworkId);

		//creating the solution
		HomeworkStudentSolving hss = new  HomeworkStudentSolving();
		hss.setDate(new Date());
		hss.setStudent(student);
		hss.setHomework(homework);

		HomeworkStudentSolvingDAO homeworkStudentSolvingDAO = appContext.getBean("homeworkStudentSolvingDAO", HomeworkStudentSolvingDAOImpl.class);
		int hssId = homeworkStudentSolvingDAO.create(hss).getId();

		String folderPath = courseName + File.separator + FileManager.STUDENTS_PATH + File.separator + username + File.separator + FileManager.HOMEWORK_PATH;
		boolean success = new FileManager().mkDir(folderPath, Integer.toString(hssId));

		if(!success){
			logger.error("failed to create directory " + homework.getName() + " in " + folderPath);
			return "layout";
		}

		return "redirect:/homeworks?path=" + homework.getFilePath() + "&parentId=" + homework.getLecture().getId();
	}



	@RequestMapping(value = "/update_lecture", method = RequestMethod.POST)
	public String updateLecture(@Valid @ModelAttribute("lecture") Lecture lecture, BindingResult result, HttpServletRequest request, Model model, RedirectAttributes redirect) {

		if(result.hasErrors()){

			model.addAttribute("modalState", "_open");
			model.addAttribute("lecture", lecture);

			return getLectures(model);
		}

		//TODO
		LectureDAO lectureDao = appContext.getBean("lectureDAO",LectureDAOImpl.class);
		Lecture old = lectureDao.get(lecture.getId());

		if(!lecture.getTopic().equals(old.getTopic()) && !lecture.getTopic().equals(""))
			old.setTopic(lecture.getTopic());

		if(!lecture.getDescription().equals(old.getDescription()) && !lecture.getDescription().equals(""))
			old.setTopic(lecture.getDescription());

		if(lecture.getDate() != null)
			if(lecture.getDate().compareTo(old.getDate()) != 0)
				old.setDate(lecture.getDate());

		if(lecture.getBeginHour() != null)
			if(lecture.getBeginHour().compareTo(old.getBeginHour()) != 0)
				old.setBeginHour(lecture.getBeginHour());

		if(lecture.getEndHour() != null)
			if(lecture.getEndHour().compareTo(old.getEndHour()) != 0)
				old.setEndHour(lecture.getEndHour());

		if(!lecture.getClassroom().equals(old.getClassroom()) && !lecture.getClassroom().equals(""))
			old.setClassroom(lecture.getClassroom());

		lectureDao.update(old);

		logger.info("update lecture");

		return "redirect:/lectures?path=lectures"; 
	}

	@RequestMapping(value = "/update_homework", method = RequestMethod.POST)
	public String updateHomework(Model model, Homework homework, @RequestParam("parentId") int lectureId) {

		//TODO
		HomeworkDAO homeworkDAO = appContext.getBean("homeworkDAO",HomeworkDAOImpl.class);
		Homework old = homeworkDAO.get(homework.getId());

		if(!homework.getDescription().equals(old.getDescription()) && !homework.getDescription().equals(""))
			old.setDescription(homework.getDescription());

		if(!homework.getName().equals(old.getName()) && !homework.getName().equals(""))
			old.setName(homework.getName());

		homeworkDAO.update(old);

		logger.info("update homework");

		return "redirect:/homeworks?path=" + homework.getFilePath() + "&parentId=" + lectureId;
	}




	/**
	 * Handles the requests to upload a new file. Creates the file in the "path" in the file system
	 * @param file the file uploaded
	 * @param parentId the id of the parentFolder
	 * @return
	 */
	@RequestMapping(value="/upload_homeworkAttached", method=RequestMethod.POST)
	public String uploadHomework(@RequestParam("file") MultipartFile file, @RequestParam("parentId") int homeworkId) {

		HomeworkDAO homeworkDAO = appContext.getBean("homeworkDAO",HomeworkDAOImpl.class);
		Homework homework = homeworkDAO.get(homeworkId);

		String path = homework.getFilePath();
		System.out.println(file.getOriginalFilename());
		boolean success = new FileManager().mkMultipartFile(file, path, file.getOriginalFilename());
		if(!success)
			logger.error("cannot save the file " + path + "/" + file.getOriginalFilename());


		HomeworkAttached homeworkAttached = new HomeworkAttached();
		homeworkAttached.setFilePath(FileManager.RESOURCES_PATH + File.separator + path + File.separator + file.getOriginalFilename());
		homeworkAttached.setHomework(homework);
		homeworkAttached.setName(file.getOriginalFilename());

		HomeworkAttachedDAO homeworkAttachedDAO = appContext.getBean("homeworkAttachedDAO", HomeworkAttachedDAOImpl.class);
		homeworkAttachedDAO.create(homeworkAttached);

		logger.info("saving file");

		return "redirect:/homeworkAttached?path=" + path + "&parentId=" + homeworkId;
	}

	/**
	 * Handles the requests to upload a new file. Creates the file in the "path" in the file system
	 * @param file the file uploaded
	 * @param parentId the id of the parentFolder
	 * @return
	 */
	@RequestMapping(value="/upload_homeworkStudentSolvingAttachment", method=RequestMethod.POST)
	public String uploadHomeworkStudentSolving(@RequestParam("file") MultipartFile file, @RequestParam("parentId") int homeworkStudentSolvingId, HttpServletRequest request) {

		//TODO Devo ricavarlo dalla sessione
		int idCourse = 1;
		String courseName = "enterpriseApplication";

		HomeworkStudentSolvingDAO homeworkStudentSolvingDAO = appContext.getBean("homeworkStudentSolvingDAO", HomeworkStudentSolvingDAOImpl.class);
		HomeworkStudentSolving hss = homeworkStudentSolvingDAO.get(homeworkStudentSolvingId);

		//creating the attachment to track the file
		HomeworkAttachedStudentSolving hss_attachment = new HomeworkAttachedStudentSolving();
		hss_attachment.setHomeworkStudentSolving(hss);

		String username = (String) request.getSession().getAttribute("loggedIn");

		//creating the file on the file system
		String folderPath = courseName + File.separator + FileManager.STUDENTS_PATH + File.separator + username + File.separator + FileManager.HOMEWORK_PATH + File.separator + hss.getId();
		hss_attachment.setFilePath(FileManager.RESOURCES_PATH + File.separator + folderPath + File.separator + file.getOriginalFilename());


		HomeworkAttachedStudentSolvingDAO homeworkAttachedStudentSolvingDAO = appContext.getBean("homeworkAttachedStudentSolvingDAO", HomeworkAttachedStudentSolvingDAOImpl.class);
		homeworkAttachedStudentSolvingDAO.create(hss_attachment);

		boolean success = new FileManager().mkMultipartFile(file, folderPath, file.getOriginalFilename());

		if(!success){
			return "layout";
		}


		return "redirect:/homeworkAttached?path=" + hss.getHomework().getFilePath() + "&parentId=" + hss.getHomework().getId();
	}


	/**
	 * Handles the requests to upload a new file. Creates the file in the "path" in the file system
	 * @param file the file uploaded
	 * @param parentId the id of the parentFolder
	 * @return
	 */
	@RequestMapping(value="/upload_materials", method=RequestMethod.POST)
	public String uploadMaterial(@RequestParam("file") MultipartFile file, @RequestParam("parentId") int lectureId) {

		//TODO retrieve from session
		Lecture lecture = appContext.getBean("lectureDAO",LectureDAOImpl.class).get(lectureId);
		String folder_name = Integer.toString(lectureId);

		String path = "enterpriseApplication" + File.separator + FileManager.LECTURES_PATH + File.separator + folder_name + File.separator + FileManager.MATERIALS_PATH;

		boolean success = new FileManager().mkMultipartFile(file, path, file.getOriginalFilename());
		if(!success)
			logger.error("cannot save the file " + path + "/" + file.getOriginalFilename());

		Material material = new Material();
		material.setName(file.getOriginalFilename());
		material.setFilePath(FileManager.RESOURCES_PATH + File.separator + path + File.separator + file.getOriginalFilename());
		material.setHidden(false);
		material.setType(file.getContentType().split("/")[1]);
		material.setLecture(lecture);

		MaterialDAO materialDAO = appContext.getBean("materialDAO", MaterialDAOImpl.class);
		materialDAO.create(material);

		logger.info("saving file");

		return "redirect:/materials?path=" + path + "&parentId=" + lectureId;
	}


	@RequestMapping(value="/delete_lecture", method=RequestMethod.POST)
	public String deleteLecture(@RequestParam("lectureId") int id) {

		LectureDAOImpl lectureDao = appContext.getBean("lectureDAO",LectureDAOImpl.class);
		Lecture lecture = lectureDao.get(id);
		if(lecture != null)
			lectureDao.delete(lecture);

		String name = Integer.toString(lecture.getId());
		String path = FileManager.RESOURCES_PATH + File.separator + "enterpriseApplication" + File.separator + FileManager.LECTURES_PATH + File.separator + name;

		boolean success = new FileManager().deleteDirectory(path);

		if(!success){
			logger.info("cannot delete the file " + path);
		}


		return "redirect:/lectures?path=lectures";
	}

	@RequestMapping(value="/delete_material", method=RequestMethod.POST)
	public String deleteMaterial(@RequestParam("materialId") int id) {

		MaterialDAO materialDAO = appContext.getBean("materialDAO", MaterialDAOImpl.class);
		Material material = materialDAO.get(id);
		if(material != null)
			materialDAO.delete(material);

		String path = material.getFilePath();
		boolean success = new FileManager().deleteFile(path);

		if(!success){
			logger.info("cannot delete the file " + path);
		}

		return "redirect:/lectures?path=lectures";
	}

	@RequestMapping(value="/delete_homework", method=RequestMethod.POST)
	public String deleteHomework(@RequestParam("homeworkId") int id) {

		HomeworkDAO homeworkDAO = appContext.getBean("homeworkDAO",HomeworkDAOImpl.class);
		Homework homework = homeworkDAO.get(id);
		if(homework != null){
			homeworkDAO.delete(homework);
		}

		String path = homework.getFilePath();
		boolean success = new FileManager().deleteDirectory(path);

		if(!success){
			logger.info("cannot delete the file " + path);
		}
		return "redirect:/lectures?path=lectures";
	}

	@RequestMapping(value="/delete_homeworkAttached", method=RequestMethod.POST)
	public String deleteHomeworkAttached(@RequestParam("homeworkAttachedId") int id) {

		HomeworkAttachedDAO homeworkAttachedDAO = appContext.getBean("homeworkAttachedDAO", HomeworkAttachedDAOImpl.class);
		HomeworkAttached homeworkAttached = homeworkAttachedDAO.get(id);
		if(homeworkAttached != null)
			homeworkAttachedDAO.delete(homeworkAttached);

		String path = homeworkAttached.getFilePath();

		boolean success = new FileManager().deleteFile(path);

		if(!success){
			logger.info("cannot delete the file " + path);
		}

		return "redirect:/lectures?path=lectures";
	}

	@RequestMapping(value="/delete_homeworkStudentSolving", method=RequestMethod.POST)
	public String deleteHomeworkStudentSolving(@RequestParam("homeworkStudentSolvingId") int id, HttpServletRequest request) {

		//TODO retrieve from session
		int idCourse = 1;
		String courseName = "enterpriseApplication";

		HomeworkStudentSolvingDAO homeworkAttachedDAO = appContext.getBean("homeworkStudentSolvingDAO", HomeworkStudentSolvingDAOImpl.class);
		HomeworkStudentSolving hss = homeworkAttachedDAO.get(id);
		if(hss != null)
			homeworkAttachedDAO.delete(hss);

		String username = (String) request.getSession().getAttribute("loggedIn");
		String folderPath = FileManager.RESOURCES_PATH + File.separator + courseName + File.separator + FileManager.STUDENTS_PATH + File.separator + username + File.separator + FileManager.HOMEWORK_PATH + File.separator + hss.getId();

		boolean success = new FileManager().deleteFile(folderPath);

		if(!success){
			logger.info("cannot delete the file " + folderPath);
		}

		return "redirect:/lectures?path=lectures";
	}

	@RequestMapping(value="/delete_homeworkStudentSolvingAttachment", method=RequestMethod.POST)
	public String deleteHomeworkStudentSolvingAttached(@RequestParam("homeworkStudentSolvingAttachedId") int id) {

		HomeworkAttachedStudentSolvingDAO homeworkAttachedStudentSolvingDAO = appContext.getBean("homeworkAttachedStudentSolvingDAO", HomeworkAttachedStudentSolvingDAOImpl.class);
		HomeworkAttachedStudentSolving homeworkAttachedStudentSolving = homeworkAttachedStudentSolvingDAO.get(id);

		if(homeworkAttachedStudentSolving != null)
			homeworkAttachedStudentSolvingDAO.delete(homeworkAttachedStudentSolving);

		String path = homeworkAttachedStudentSolving.getFilePath();

		boolean success = new FileManager().deleteFile(path);

		if(!success){
			logger.info("cannot delete the file " + path);
		}

		return "redirect:/lectures?path=lectures";
	}
	/*
	 * simply adapt java File to an useful format required by the view
	 */
	private void adaptLecture(List<AbstractFileBean> dest, List<Lecture> source, String currentPath) {

		for (Lecture lecture : source) {

			String name = lecture.getNumber() + " - " + lecture.getTopic();
			String folderPath = currentPath + File.separator + lecture.getId();

			File f = new File(folderPath);
			int childs = 0;
			if(f.exists())
				childs = new File(folderPath).listFiles().length;

			FolderBean folder = new FolderBean(lecture.getId(), name, AbstractFileBean.FOLDER_TYPE, folderPath, childs);
			folder.setAction("lectureContent");
			folder.setParentId(lecture.getId());
			dest.add(folder);
		}	
	}

	/*
	 * creates a calendar event starting from the new lecture
	 */
	private void createCalendarEvent(Lecture lecture) {

		Event event = new Event();
		event.setColor("##0000ff");
		event.setDescription(lecture.getDescription());
		event.setEndDate(lecture.getDate());
		event.setStartDate(lecture.getDate());
		event.setHourBegin(lecture.getBeginHour());
		event.setHourEnd(lecture.getEndHour());
		event.setPlace("");
		event.setTitle(lecture.getTopic());
		event.setUser(lecture.getCourseClass().getProfessor());

		EventDAO eventDao = appContext.getBean("eventDao",EventDAOImpl.class);
		eventDao.create(event);
	}
	
	/*
	 * checks if the logged student can create homeworks or lectures
	 */
	private boolean canCreate(HttpServletRequest request) {
		
		//retrieving the logged student
		String username = (String) request.getSession().getAttribute("loggedIn");
		UserDAO userDAO = appContext.getBean("userDao", UserDAO.class);
		User user = userDAO.get(username);

		if(user.getRole().equals(User.STUDENT))
			return false;
		
		return true;
	}

}
