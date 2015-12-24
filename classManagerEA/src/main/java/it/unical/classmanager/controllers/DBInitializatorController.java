package it.unical.classmanager.controllers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.dao.AnswerAttachedContentDAO;
import it.unical.classmanager.model.dao.AnswerAttachedContentDAOImpl;
import it.unical.classmanager.model.dao.AnswerDAO;
import it.unical.classmanager.model.dao.AnswerDAOImpl;
import it.unical.classmanager.model.dao.AttendanceStudentLectureDAO;
import it.unical.classmanager.model.dao.AttendanceStudentLectureDAOImpl;
import it.unical.classmanager.model.dao.CommunicationsDAO;
import it.unical.classmanager.model.dao.CommunicationsDAOImpl;
import it.unical.classmanager.model.dao.CourseClassDAO;
import it.unical.classmanager.model.dao.CourseClassDAOImpl;
import it.unical.classmanager.model.dao.DegreeCourseDAO;
import it.unical.classmanager.model.dao.DegreeCourseDAOImpl;
import it.unical.classmanager.model.dao.DepartementDAO;
import it.unical.classmanager.model.dao.DepartementDAOImpl;
import it.unical.classmanager.model.dao.EventDAO;
import it.unical.classmanager.model.dao.EventDAOImpl;
import it.unical.classmanager.model.dao.ExamDAO;
import it.unical.classmanager.model.dao.ExamDAOImpl;
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
import it.unical.classmanager.model.dao.QuestionAttachedContentDAO;
import it.unical.classmanager.model.dao.QuestionAttachedContentDAOImpl;
import it.unical.classmanager.model.dao.QuestionDAO;
import it.unical.classmanager.model.dao.QuestionDAOImpl;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAO;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAOImpl;
import it.unical.classmanager.model.dao.StudentExamPartecipationDAO;
import it.unical.classmanager.model.dao.StudentExamPartecipationDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.Answer;
import it.unical.classmanager.model.data.AnswerAttachedContent;
import it.unical.classmanager.model.data.AttendanceStudentLecture;
import it.unical.classmanager.model.data.Communications;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.DegreeCourse;
import it.unical.classmanager.model.data.Departement;
import it.unical.classmanager.model.data.Event;
import it.unical.classmanager.model.data.Exam;
import it.unical.classmanager.model.data.Homework;
import it.unical.classmanager.model.data.HomeworkAttached;
import it.unical.classmanager.model.data.HomeworkAttachedStudentSolving;
import it.unical.classmanager.model.data.HomeworkStudentSolving;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.model.data.Material;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Question;
import it.unical.classmanager.model.data.QuestionAttachedContent;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.StudentExamPartecipation;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.DateTimeFactory;

/**
 * @author Aloisius92
 * This is a controller for the creation of the entire db.
 */
@Controller
public class DBInitializatorController {

	/**
	 * This flag is for avoiding the duplication of the db
	 */
	private static boolean initialized = false;
	/**
	 * The number of professor to insert into the db
	 */
	private static int numProfessors = 2;
	/**
	 * The total number of users
	 */
	private static int numUser = numProfessors*numProfessors;
	/**
	 * The minimum age for be a Professor
	 */
	private static int ageForProfessor = 30;
	/**
	 * The minimum age for be a Student
	 */
	private static int ageForStudent = 19;
	/**
	 * The number of lecture that must be done by cfu
	 */
	private static int lectureForCfu = 2;
	/**
	 * The probability for a student for the attendance of a lesson
	 */
	private static float attendanceStudentProbability = 0.75f;
	/**
	 * The probability for a lecture that contains materials
	 */
	private static float lectureMaterialProbability = 0.75f;
	/**
	 * The probability for a student that has done a homework
	 */
	private static float homeworkStudentProbability = 0.75f;
	/**
	 * The probability that a student ask a question
	 */
	private static float questionStudentProbability = 0.1f;
	/**
	 * The probability that a professor ask a question
	 */
	private static float questionProfessorProbability = 0.05f;
	/**
	 * The probability that a student answer to a question
	 */
	private static float answerStudentProbability = 0.50f;
	/**
	 * The probability that a professor answer to a question
	 */
	private static float answerProfessorProbability = 0.80f;
	/**
	 * The probability that a user have an Event
	 */
	private static float eventUserProbability = 0.05f;
	/**
	 * The probability that there is a communications by a professor
	 */
	private static float professorCommunicationsProbability = 0.02f;
	/**
	 * The probability that a question has an attachment
	 */
	private static float questionAttachmentProbability = 0.02f;
	/**
	 * The probability that an answer has an attachment
	 */
	private static float answerAttachmentProbability = 0.02f;
	/**
	 * The probability that a homework has an attachment
	 */
	private static float homeworkAttachmentProbability = 0.02f;
	/**
	 * The probability that a homework has an attachment
	 */
	private static float homeworkStudentSolvingAttachmentProbability = 0.02f;

	private static Random random = new Random();

	@Autowired
	ApplicationContext appContext;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Functions that begin the process to create the entire db.
	 */
	@RequestMapping(value = "/db_init", method = RequestMethod.GET)
	public String dbInitialization(Locale locale, Model model, HttpServletRequest request) {		
		if(!initialized){
			logger.info("DB initializing...", locale);

			dbDegreeCourseDepartmentInit(locale, model, request);
			dbUserStudentProfessorInit(locale, model, request);
			dbCourseClassInit(locale, model, request);
			dbLectureInit(locale, model, request);
			dbRegistrationStudentClassInit(locale, model, request);
			dbAttendanceStudentLectureInit(locale, model, request);
			dbMaterialInit(locale, model, request);
			dbHomeworkInit(locale, model, request);
			dbHomeworkStudentSolvingInit(locale, model, request);
			dbQuestionAnswerInit(locale, model, request);
			dbExamInit(locale, model, request);
			dbStudentExamPartecipationInit(locale, model, request);
			dbEventInit(locale, model, request);
			dbCommunicationInit(locale, model, request);
			// Attached contents
			dbQuestionAttachedContentInit(locale, model, request);
			dbAnswerAttachedContentInit(locale, model, request);
			dbHomeworkAttachedInit(locale, model, request);
			dbHomeworkAttachedStudentSolvingInit(locale, model, request);
			
			

			logger.info("INITIALIZATION DONE!!!", locale);
			
			initialized = true;
		} else {
			logger.info("The DB is up!", locale);
		}	

		return "redirect:/";
	}

	/**
	 * Functions that insert values in tables User, Student and Professor.
	 */
	private void dbUserStudentProfessorInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("User, Student, Professor creation...", locale);			
		UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		
		for(int i=0; i<numUser; i++){
			if(i<numProfessors){	// Creating professors	
				String username = "ProfAldo";					
				User user = new User();
				user.setUsername(username+i);
				user.setFirstName("ProfAldo_FirstName");
				user.setLastName("ProfAldo_LastName");
				user.setRole("Professor");	
				user.setBirthDate(DateTimeFactory.getRandomDateLessThanYear(
						Calendar.getInstance().get(Calendar.YEAR)-ageForProfessor).getTime());
				user.setEmail("profaldo@profaldo.it");
				user.setPassword(username+i);
				user.setConfirmPassword(user.getPassword());
				user.setHash(user.getPassword());
				user.setAddress("address");
				Professor professor = new Professor(user,
						i, new ArrayList<Communications>(),
						new ArrayList<CourseClass>());

				User retrievedUser = userDao.get(username+i);
				if(retrievedUser==null){
					userDao.create(professor);
					logger.info("Created "+professor, locale);						
				}
			} else {	// Creating students
				String username = "StudentAldo";

				User user = new User();
				user.setUsername(username+i);
				user.setFirstName("Aldo_FirstName");
				user.setLastName("Aldo_LastName");
				user.setRole("Student");				    	
				user.setBirthDate(DateTimeFactory.getRandomDateLessThanYear(
						Calendar.getInstance().get(Calendar.YEAR)-ageForStudent).getTime());
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

				User retrievedUser = userDao.get(username+i);
				if(retrievedUser==null){
					userDao.create(student);
					logger.info("Created "+student, locale);						
				} 
			}					
		}
		logger.info("Num Professors:"+userDao.getAllProfessors().size()+", Num Students:"+userDao.getAllStudents().size(), locale);
	}

	/**
	 * Functions that insert values in tables DegreeCourse and Department.
	 */
	private void dbDegreeCourseDepartmentInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("DegreeCourses creation...", locale);
		logger.info("Departments creation...", locale);
		DepartementDAO departementDAO = (DepartementDAOImpl) appContext.getBean("departementDAO", DepartementDAOImpl.class);		
		DegreeCourseDAO degreeCourseDAO = (DegreeCourseDAOImpl) appContext.getBean("degreeCourseDAO", DegreeCourseDAOImpl.class);

		Departement departement = new Departement(
				1, 
				"Mathematics And Computer Science", 
				"Via P. Pietro Bucci", 
				"Calabria", 
				"Italy", 
				new ArrayList<DegreeCourse>());	
		departementDAO.create(departement);
		logger.info("Created "+departement, locale);

		DegreeCourse degreeCourse1 = new DegreeCourse(
				1, 
				"0733", 
				"ComputerScience", 
				new ArrayList<CourseClass>(), 
				departement);
		degreeCourseDAO.create(degreeCourse1);

		DegreeCourse degreeCourse2 = new DegreeCourse(
				1, 
				"0737", 
				"ComputerScience", 
				new ArrayList<CourseClass>(), 
				departement);
		degreeCourseDAO.create(degreeCourse2);		
	}

	/**
	 * Functions that insert values in table CourseClass.
	 * In this function i have inserted 8 course of example.
	 */
	private void dbCourseClassInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("CourseClasses creation...", locale);	
		CourseClassDAO courseClassDao = (CourseClassDAOImpl) appContext.getBean("courseClassDAO", CourseClassDAOImpl.class);
		UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		
		List<Professor> allProfessors = userDao.getAllProfessors();
		DegreeCourseDAO degreeCourseDAO = (DegreeCourseDAOImpl) appContext.getBean("degreeCourseDAO", DegreeCourseDAOImpl.class);
		List<DegreeCourse> allDegreeCourses = degreeCourseDAO.getAllDegreeCourses();

		int year = DateTimeFactory.getRandomYear();
		int deltaYear;
		// ---------------------------------------- //
		deltaYear = random.nextInt(6)-3;
		CourseClass courseClass1 = new CourseClass(
				1, 
				"EnterpriseApplications", 
				5, 
				DateTimeFactory.getRandomDateBetweenMonths(year+deltaYear, Calendar.SEPTEMBER, Calendar.JUNE).getTime(), 
				null, 
				(short)(1+random.nextInt(3)), 
				allProfessors.get(random.nextInt(allProfessors.size())), 
				allDegreeCourses.get(random.nextInt(allDegreeCourses.size())), 
				new ArrayList<Exam>(),
				new ArrayList<RegistrationStudentClass>(),
				new ArrayList<Lecture>());
		courseClassDao.create(courseClass1);
		logger.info("Created "+courseClass1, locale);

		// ---------------------------------------- //
		deltaYear = random.nextInt(6)-3;		
		CourseClass courseClass2 = new CourseClass(
				2, 
				"Knowledge Management", 
				10, 
				DateTimeFactory.getRandomDateBetweenMonths(year+deltaYear, Calendar.SEPTEMBER, Calendar.JUNE).getTime(), 
				null, 
				(short)(1+random.nextInt(3)), 
				allProfessors.get(random.nextInt(allProfessors.size())), 
				allDegreeCourses.get(random.nextInt(allDegreeCourses.size())), 
				new ArrayList<Exam>(),
				new ArrayList<RegistrationStudentClass>(),
				new ArrayList<Lecture>());
		courseClassDao.create(courseClass2);
		logger.info("Created "+courseClass2, locale);

		// ---------------------------------------- //	
		deltaYear = random.nextInt(6)-3;
		CourseClass courseClass3 = new CourseClass(
				3, 
				"Computer Graphics", 
				6, 
				DateTimeFactory.getRandomDateBetweenMonths(year+deltaYear, Calendar.SEPTEMBER, Calendar.JUNE).getTime(), 
				null, 
				(short)(1+random.nextInt(3)), 
				allProfessors.get(random.nextInt(allProfessors.size())), 
				allDegreeCourses.get(random.nextInt(allDegreeCourses.size())), 
				new ArrayList<Exam>(),
				new ArrayList<RegistrationStudentClass>(),
				new ArrayList<Lecture>());
		courseClassDao.create(courseClass3);
		logger.info("Created "+courseClass3, locale);

		// ---------------------------------------- //	
		deltaYear = random.nextInt(6)-3;
		CourseClass courseClass4 = new CourseClass(
				4, 
				"Network Security", 
				10, 
				DateTimeFactory.getRandomDateBetweenMonths(year+deltaYear, Calendar.SEPTEMBER, Calendar.JUNE).getTime(), 
				null, 
				(short)(1+random.nextInt(3)), 
				allProfessors.get(random.nextInt(allProfessors.size())), 
				allDegreeCourses.get(random.nextInt(allDegreeCourses.size())), 
				new ArrayList<Exam>(),
				new ArrayList<RegistrationStudentClass>(),
				new ArrayList<Lecture>());
		courseClassDao.create(courseClass4);
		logger.info("Created "+courseClass4, locale);

		// ---------------------------------------- //	
		deltaYear = random.nextInt(6)-3;
		CourseClass courseClass5 = new CourseClass(
				5, 
				"Numerical Approximations Algorithms", 
				10, 
				DateTimeFactory.getRandomDateBetweenMonths(year+deltaYear, Calendar.SEPTEMBER, Calendar.JUNE).getTime(), 
				null, 
				(short)(1+random.nextInt(3)), 
				allProfessors.get(random.nextInt(allProfessors.size())), 
				allDegreeCourses.get(random.nextInt(allDegreeCourses.size())), 
				new ArrayList<Exam>(),
				new ArrayList<RegistrationStudentClass>(),
				new ArrayList<Lecture>());
		courseClassDao.create(courseClass5);
		logger.info("Created "+courseClass5, locale);

		// ---------------------------------------- //	
		deltaYear = random.nextInt(6)-3;
		CourseClass courseClass6 = new CourseClass(
				6, 
				"Modelling And Simulations", 
				5, 
				DateTimeFactory.getRandomDateBetweenMonths(year+deltaYear, Calendar.SEPTEMBER, Calendar.JUNE).getTime(), 
				null, 
				(short)(1+random.nextInt(3)), 
				allProfessors.get(random.nextInt(allProfessors.size())), 
				allDegreeCourses.get(random.nextInt(allDegreeCourses.size())), 
				new ArrayList<Exam>(),
				new ArrayList<RegistrationStudentClass>(),
				new ArrayList<Lecture>());
		courseClassDao.create(courseClass6);
		logger.info("Created "+courseClass6, locale);

		// ---------------------------------------- //
		deltaYear = random.nextInt(6)-3;	
		CourseClass courseClass7 = new CourseClass(
				7, 
				"Data Mining", 
				5, 
				DateTimeFactory.getRandomDateBetweenMonths(year+deltaYear, Calendar.SEPTEMBER, Calendar.JUNE).getTime(), 
				null, 
				(short)(1+random.nextInt(3)), 
				allProfessors.get(random.nextInt(allProfessors.size())), 
				allDegreeCourses.get(random.nextInt(allDegreeCourses.size())), 
				new ArrayList<Exam>(),
				new ArrayList<RegistrationStudentClass>(),
				new ArrayList<Lecture>());
		courseClassDao.create(courseClass7);
		logger.info("Created "+courseClass7, locale);

		// ---------------------------------------- //	
		deltaYear = random.nextInt(6)-3;
		CourseClass courseClass8 = new CourseClass(
				8, 
				"Data Warehouse", 
				5, 
				DateTimeFactory.getRandomDateBetweenMonths(year+deltaYear, Calendar.SEPTEMBER, Calendar.JUNE).getTime(), 
				null, 
				(short)(1+random.nextInt(3)), 
				allProfessors.get(random.nextInt(allProfessors.size())), 
				allDegreeCourses.get(random.nextInt(allDegreeCourses.size())), 
				new ArrayList<Exam>(),
				new ArrayList<RegistrationStudentClass>(),
				new ArrayList<Lecture>());
		courseClassDao.create(courseClass8);
		logger.info("Created "+courseClass8, locale);
	}	

	/**
	 * Functions that insert values in table RegistrationStudentClass.
	 */
	@SuppressWarnings("deprecation")
	private void dbRegistrationStudentClassInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("RegistrationStudentClasses creation...", locale);
		RegistrationStudentClassDAO registrationStudentClassDAO = (RegistrationStudentClassDAOImpl) appContext.getBean("registrationStudentClassDAO", RegistrationStudentClassDAOImpl.class);
		UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		
		CourseClassDAO courseClassDao = (CourseClassDAOImpl) appContext.getBean("courseClassDAO", CourseClassDAOImpl.class);

		int k=0;
		for(CourseClass courseClass : courseClassDao.getAllCourseClasses()){
			List<Lecture> lectures = courseClass.getLectures();
			Date date = lectures.get(0).getDate();
			int deltaDay = random.nextInt(3);
			int day = date.getDay()-deltaDay;
			day = day <= 0 ? 1 : day;
			Date invitationDate = new Date(date.getYear(), date.getMonth(), day);
			for(Student student : userDao.getAllStudents()){
				if(random.nextInt()%2==0){
					RegistrationStudentClass registrationStudentClass = new RegistrationStudentClass(
							k,
							invitationDate, 
							date, 
							date, 
							student, 
							courseClass);
					k++;
					registrationStudentClassDAO.create(registrationStudentClass);
					logger.info("Created "+registrationStudentClass, locale);
				}
			}
		}
	}

	/**
	 * Functions that insert values in table Lecture.
	 */
	@SuppressWarnings("deprecation")
	private void dbLectureInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("Lectures creation...", locale);
		LectureDAO lectureDAO = (LectureDAOImpl) appContext.getBean("lectureDAO", LectureDAOImpl.class);
		CourseClassDAO courseClassDao = (CourseClassDAOImpl) appContext.getBean("courseClassDAO", CourseClassDAOImpl.class);
		List<CourseClass> allCourseClasses = courseClassDao.getAllCourseClasses();

		int k = 0;
		for(CourseClass courseClass : allCourseClasses){
			int cfu = courseClass.getCfu();
			int year;
			// I check if the course is yet valid or not.
			if(courseClass.getEndDate()==null){
				// Course still active
				year = DateTimeFactory.getRandomYearBetween(
						courseClass.getActivationDate().getYear(), 
						Calendar.getInstance().get(Calendar.YEAR));
			} else {
				// Course terminated
				year = DateTimeFactory.getRandomYearBetween(
						courseClass.getActivationDate().getYear(), 
						courseClass.getEndDate().getYear());
			}

			Calendar lectureDateStart = DateTimeFactory.getRandomDate(year);
			for(int i=0; i<cfu*lectureForCfu; i++){
				// Calculating random lecture start hour
				Time beginTime = DateTimeFactory.getRandomTimeBetween(
						new Time(8,0,0), 
						new Time(15,0,0));
				Time endTime = new Time(beginTime.getHours()+2, beginTime.getMinutes(), beginTime.getSeconds());

				Lecture lecture = new Lecture(
						k,
						i, 
						"TopicLecture"+i, 
						"DescriptionLecture"+i, 
						lectureDateStart.getTime(), 
						beginTime, 
						endTime, 
						"MT"+(1+random.nextInt(100)),	// Set a random classroom 
						courseClass, 
						new ArrayList<Material>(), 
						new ArrayList<Question>(), 
						new ArrayList<AttendanceStudentLecture>(), 
						new ArrayList<Homework>());
				lectureDateStart.add(Calendar.DAY_OF_MONTH, 2);

				lectureDAO.create(lecture);
				logger.info("Created "+lecture, locale);
				k++;			
			}
		}
	}

	/**
	 * Functions that insert values in table AttendanceStudentLecture.
	 */
	private void dbAttendanceStudentLectureInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("AttendanceStudentLectures creation...", locale);
		AttendanceStudentLectureDAO attendanceStudentLectureDAO = (AttendanceStudentLectureDAOImpl) appContext.getBean("attendanceStudentLectureDAO", AttendanceStudentLectureDAOImpl.class);	
		RegistrationStudentClassDAO registrationStudentClassDAO = (RegistrationStudentClassDAOImpl) appContext.getBean("registrationStudentClassDAO", RegistrationStudentClassDAOImpl.class);

		int k=0;
		for(RegistrationStudentClass registrationStudentClass : registrationStudentClassDAO.getAllRegistrationStudentClasses()){
			CourseClass courseClass = registrationStudentClass.getCourseClass();
			for(Lecture lecture: courseClass.getLectures()){
				// In this part i create a random attendances distribution
				if(random.nextFloat()<=attendanceStudentProbability){
					AttendanceStudentLecture attendanceStudentLecture = new AttendanceStudentLecture(
							k, 
							registrationStudentClass.getStudent(), 
							lecture);
					attendanceStudentLectureDAO.create(attendanceStudentLecture);
					logger.info("Created "+attendanceStudentLecture, locale);
					k++;
				}
			}
		}

	}

	/**
	 * Functions that insert values in table Material.
	 */
	private void dbMaterialInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("Materials creation...", locale);		
		MaterialDAO materialDAO = (MaterialDAOImpl) appContext.getBean("materialDAO", MaterialDAOImpl.class);
		LectureDAO lectureDAO = (LectureDAOImpl) appContext.getBean("lectureDAO", LectureDAOImpl.class);

		int k=0;
		for(Lecture lecture : lectureDAO.getAllLectures()){
			if(random.nextFloat()<=lectureMaterialProbability){
				Material material = new Material(
						k, 
						"materialFile", 
						"txt", 
						false, 
						"files/materialFile.txt", // In future change this adding several files
						lecture);
				materialDAO.create(material);
				logger.info("Created "+material, locale);
				k++;
			}
		}
	}

	/**
	 * Functions that insert values in table Homework.
	 */
	private void dbHomeworkInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("Homeworks creation...", locale);		
		HomeworkDAO homeworkDAO = (HomeworkDAOImpl) appContext.getBean("homeworkDAO", HomeworkDAOImpl.class);
		LectureDAO lectureDAO = (LectureDAOImpl) appContext.getBean("lectureDAO", LectureDAOImpl.class);

		int k=0;
		for(Lecture lecture : lectureDAO.getAllLectures()){
			Homework homework = new Homework(
					k, 
					"Homework"+k, 
					"HomeworkDescription"+k, 
					"files/homeworkFile.txt", 
					lecture, 
					new ArrayList<HomeworkAttached>(), 
					new ArrayList<HomeworkStudentSolving>()); 
			homeworkDAO.create(homework);
			logger.info("Created "+homework, locale);
			k++;
		}
	}

	/**
	 * Functions that insert values in table HomeworkStudentSolving.
	 */
	private void dbHomeworkStudentSolvingInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("HomeworkStudentSolvings creation...", locale);	
		HomeworkStudentSolvingDAO homeworkStudentSolvingDAO = (HomeworkStudentSolvingDAOImpl) appContext.getBean("homeworkStudentSolvingDAO", HomeworkStudentSolvingDAOImpl.class);
		RegistrationStudentClassDAO registrationStudentClassDAO = (RegistrationStudentClassDAOImpl) appContext.getBean("registrationStudentClassDAO", RegistrationStudentClassDAOImpl.class);

		int k=0;
		for(RegistrationStudentClass registrationStudentClass : registrationStudentClassDAO.getAllRegistrationStudentClasses()){
			for(Lecture lecture : registrationStudentClass.getCourseClass().getLectures()){
				for(Homework homework : lecture.getHomeworks()){
					if(random.nextFloat()<=homeworkStudentProbability){
						HomeworkStudentSolving homeworkStudentSolving = new HomeworkStudentSolving(
								k, 
								18+random.nextInt(13), 
								registrationStudentClass.getStudent(), 
								homework, 
								new ArrayList<HomeworkAttachedStudentSolving>());
						homeworkStudentSolvingDAO.create(homeworkStudentSolving);
						logger.info("Created "+homeworkStudentSolving, locale);
						k++;
					}
				}
			}
		}
	}

	/**
	 * Functions that insert values in table QuestionAnswer.
	 */
	private void dbQuestionAnswerInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("Question and Answer creation...", locale);	
		AnswerDAO answerDAO = (AnswerDAOImpl) appContext.getBean("answerDAO", AnswerDAOImpl.class);
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);
		LectureDAO lectureDAO = (LectureDAOImpl) appContext.getBean("lectureDAO", LectureDAOImpl.class);
		UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		

		//	Random question creations
		int k=0;
		for(Lecture lecture : lectureDAO.getAllLectures()){
			CourseClass courseClass = lecture.getCourseClass();
			for(RegistrationStudentClass registrationStudentClass : courseClass.getRegistrationStudentClasses()){
				if(random.nextFloat()<=questionProfessorProbability){	// For professor
					Question question = new Question(
							k, 
							"Question"+k, 
							"DescriptionQuestion"+k, 
							courseClass.getProfessor(), 
							lecture, 
							new ArrayList<Answer>(), 
							new ArrayList<QuestionAttachedContent>());
					questionDAO.create(question);
					logger.info("Created "+question, locale);
					k++;
				}
				if(random.nextFloat()<=questionStudentProbability){	// For student
					Question question = new Question(
							k, 
							"Question"+k, 
							"DescriptionQuestion"+k, 
							registrationStudentClass.getStudent(), 
							lecture, 
							new ArrayList<Answer>(), 
							new ArrayList<QuestionAttachedContent>());
					questionDAO.create(question);
					logger.info("Created "+question, locale);
					k++;
				}
			}
		}

		// Random answer creations
		k=0;
		for(Question question : questionDAO.getAllQuestions()){
			for(User user : userDao.getAllProfessors()){
				if(random.nextFloat()<=answerProfessorProbability){	// For professor
					Answer answer = new Answer(
							k, 
							"DescriptionAnswer"+k,
							user, 
							question,
							new ArrayList<AnswerAttachedContent>());
					answerDAO.create(answer);
					logger.info("Created "+answer, locale);
					k++;
				}
			}
			for(User user : userDao.getAllStudents()){
				if(random.nextFloat()<=answerStudentProbability){	// For student
					Answer answer = new Answer(
							k, 
							"DescriptionAnswer"+k,
							user, 
							question,
							new ArrayList<AnswerAttachedContent>());
					answerDAO.create(answer);
					logger.info("Created "+answer, locale);
					k++;
				}
			}	
		}
	}

	/**
	 * Functions that insert values in table Exam.
	 */
	@SuppressWarnings("deprecation")
	private void dbExamInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("Exams creation...", locale);	
		ExamDAO examDAO = (ExamDAOImpl) appContext.getBean("examDAO", ExamDAOImpl.class);	
		CourseClassDAO courseClassDao = (CourseClassDAOImpl) appContext.getBean("courseClassDAO", CourseClassDAOImpl.class);

		//	Ordinary Exam creations
		int k=0;
		for(CourseClass courseClass : courseClassDao.getAllCourseClasses()){
			Lecture lecture = courseClass.getLectures().get(courseClass.getLectures().size()-1);
			Date lastLectureDate = lecture.getDate();
			Calendar date = new GregorianCalendar(
					lastLectureDate.getYear(), 
					lastLectureDate.getMonth(),
					lastLectureDate.getDay());
			date.add(Calendar.DAY_OF_MONTH, +14);			
			Exam exam = new Exam(
					k, 
					"Exam"+k, 
					date.getTime(), 
					"Ordinary", 
					courseClass, 
					new ArrayList<StudentExamPartecipation>());
			examDAO.create(exam);
			logger.info("Created "+exam, locale);
			k++;			
		}		

		//	Extra ordinary Exam creations
		for(CourseClass courseClass : courseClassDao.getAllCourseClasses()){
			Lecture lecture = courseClass.getLectures().get(courseClass.getLectures().size()-1);
			Date lastLectureDate = lecture.getDate();
			Calendar date = new GregorianCalendar(
					lastLectureDate.getYear(), 
					lastLectureDate.getMonth(),
					lastLectureDate.getDay());
			date.add(Calendar.MONTH, +2);			
			Exam exam = new Exam(
					k, 
					"Exam"+k, 
					date.getTime(), 
					"Extra-Ordinary", 
					courseClass, 
					new ArrayList<StudentExamPartecipation>());
			examDAO.create(exam);
			logger.info("Created "+exam, locale);
			k++;			
		}	
	}

	/**
	 * Functions that insert values in table StudentExamPartecipation.
	 */
	private void dbStudentExamPartecipationInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("StudentExamPartecipations creation...", locale);
		StudentExamPartecipationDAO studentExamPartecipationDAO = (StudentExamPartecipationDAOImpl) appContext.getBean("studentExamPartecipationDAO", StudentExamPartecipationDAOImpl.class);	
		UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		
		ExamDAO examDAO = (ExamDAOImpl) appContext.getBean("examDAO", ExamDAOImpl.class);	

		int k=0;		
		for(Student student : userDao.getAllStudents()){
			for(Exam exam : examDAO.getAllExams()){	
				List<StudentExamPartecipation> partecipations = studentExamPartecipationDAO.getPartecipationBy(student, exam);
				boolean examPassed = false;
				for(StudentExamPartecipation partecipation : partecipations){
					if(partecipation.getScore()>=18){
						examPassed=true;
					}
				}
				if(!examPassed){
					StudentExamPartecipation studentExamPartecipation = new StudentExamPartecipation(
							k, 
							1+random.nextInt(30), 
							random.nextInt()%21==0, 
							student, 
							exam);
					studentExamPartecipationDAO.create(studentExamPartecipation);
					logger.info("Created "+studentExamPartecipation, locale);
					k++;
				}
			}
		}
	}

	/**
	 * Functions that insert values in table Event.
	 */
	@SuppressWarnings("deprecation")
	private void dbEventInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("Events creation...", locale);	
		EventDAO eventDAO = (EventDAOImpl) appContext.getBean("eventDao", EventDAOImpl.class);	
		UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		
		CourseClassDAO courseClassDao = (CourseClassDAOImpl) appContext.getBean("courseClassDAO", CourseClassDAOImpl.class);

		Date date = courseClassDao.get(1).getActivationDate();

		int k = 0;
		for(User user : userDao.getAllUsers()){
			if(random.nextFloat()<=eventUserProbability){
				int numEvents = random.nextInt(10);
				for(int i=0; i<numEvents; i++){
					Calendar randomDate = DateTimeFactory.getRandomDate(date.getYear());
					Time beginTime = DateTimeFactory.getRandomTimeBetween(
							new Time(8,0,0), 
							new Time(15,0,0));
					Time endTime = new Time(beginTime.getHours()+(1+random.nextInt(10)), beginTime.getMinutes(), beginTime.getSeconds());

					Event event = new Event(
							k, 
							"EventTitle"+k,
							"EventDescription"+k, 
							randomDate.getTime(), 
							randomDate.getTime(), 
							"Place"+k, 
							beginTime, 
							endTime, 
							user);
					eventDAO.create(event);
					logger.info("Created "+event, locale);
					k++;
				}
			}
		}		
	}

	/**
	 * Functions that insert values in table Communication.
	 */
	private void dbCommunicationInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("Communications creation...", locale);	
		CommunicationsDAO communicationsDAO = (CommunicationsDAOImpl) appContext.getBean("communicationsDAO", CommunicationsDAOImpl.class);	
		UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		

		int k=0;
		for(Professor professor : userDao.getAllProfessors()){
			if(random.nextFloat()<=professorCommunicationsProbability){
				int numCommunications = random.nextInt(3);
				for(int i=0; i<numCommunications; i++){
					Communications communications = new Communications(
							k,
							"Communication"+k, 
							"Description"+k, 
							professor);
					communicationsDAO.create(communications);
					logger.info("Created "+communications, locale);
					k++;		
				}
			}			
		}		
	}

	/**
	 * Functions that insert values in table QuestionAttachedContent.
	 */
	private void dbQuestionAttachedContentInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("QuestionAttachedContents creation...", locale);	
		QuestionAttachedContentDAO questionAttachedContentDAO = (QuestionAttachedContentDAOImpl) appContext.getBean("questionAttachedContentDAO", QuestionAttachedContentDAOImpl.class);
		QuestionDAO questionDAO = (QuestionDAOImpl) appContext.getBean("questionDAO", QuestionDAOImpl.class);

		int k=0;
		for(Question question : questionDAO.getAllQuestions()){
			if(random.nextFloat()<=questionAttachmentProbability){
				QuestionAttachedContent questionAttachedContent = new QuestionAttachedContent(
						k, 
						"questionAttachedFile", 
						"txt", 
						"files/questionAttachedFile.txt", 
						question);
				questionAttachedContentDAO.create(questionAttachedContent);
				logger.info("Created "+questionAttachedContent, locale);
				k++;		
			}
		}
	}

	/**
	 * Functions that insert values in table AnswerAttachedContent.
	 */
	private void dbAnswerAttachedContentInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("AnswerAttachedContents creation...", locale);	
		AnswerAttachedContentDAO answerAttachedContentDAO = (AnswerAttachedContentDAOImpl) appContext.getBean("answerAttachedContentDAO", AnswerAttachedContentDAOImpl.class);	
		AnswerDAO answerDAO = (AnswerDAOImpl) appContext.getBean("answerDAO", AnswerDAOImpl.class);

		int k=0;
		for(Answer answer : answerDAO.getAllAnswers()){
			if(random.nextFloat()<=answerAttachmentProbability){
				AnswerAttachedContent answerAttachedContent = new AnswerAttachedContent(
						k, 
						"answerAttachedFile", 
						"txt", 
						"files/questionAttachedFile.txt", 
						answer);
				answerAttachedContentDAO.create(answerAttachedContent);
				logger.info("Created "+answerAttachedContent, locale);
				k++;		
			}
		}
	}

	/**
	 * Functions that insert values in table HomeworkAttached.
	 */
	private void dbHomeworkAttachedInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("HomeworkAttacheds creation...", locale);
		HomeworkAttachedDAO homeworkAttachedDAO = (HomeworkAttachedDAOImpl) appContext.getBean("homeworkAttachedDAO", HomeworkAttachedDAOImpl.class);	
		HomeworkDAO homeworkDAO = (HomeworkDAOImpl) appContext.getBean("homeworkDAO", HomeworkDAOImpl.class);
				
		int k=0;
		for(Homework homework : homeworkDAO.getAllHomeworks()){
			if(random.nextFloat()<=homeworkAttachmentProbability){
				HomeworkAttached homeworkAttached = new HomeworkAttached(
						k,
						"files/homeworkAttachedFile.txt",
						homework);
				homeworkAttachedDAO.create(homeworkAttached);
				logger.info("Created "+homeworkAttached, locale);
				k++;		
			}
		}
	}

	/**
	 * Functions that insert values in table HomeworkAttachedStudentSolving.
	 */
	private void dbHomeworkAttachedStudentSolvingInit(Locale locale, Model model, HttpServletRequest request){
		logger.info("HomeworkAttachedStudentSolvings creation...", locale);
		HomeworkAttachedStudentSolvingDAO homeworkAttachedStudentSolvingDAO = (HomeworkAttachedStudentSolvingDAOImpl) appContext.getBean("homeworkAttachedStudentSolvingDAO", HomeworkAttachedStudentSolvingDAOImpl.class);	
		HomeworkStudentSolvingDAO homeworkStudentSolvingDAO = (HomeworkStudentSolvingDAOImpl) appContext.getBean("homeworkStudentSolvingDAO", HomeworkStudentSolvingDAOImpl.class);

		int k=0;
		for(HomeworkStudentSolving homeworkStudentSolving : homeworkStudentSolvingDAO.getAllHomeworkStudentSolvings()){
			if(random.nextFloat()<=homeworkStudentSolvingAttachmentProbability){
				HomeworkAttachedStudentSolving homeworkAttachedStudentSolving = new HomeworkAttachedStudentSolving(
						k,
						"files/homeworkStudentSolvingAttachedFile.txt",
						homeworkStudentSolving);
				homeworkAttachedStudentSolvingDAO.create(homeworkAttachedStudentSolving);
				logger.info("Created "+homeworkAttachedStudentSolving, locale);
				k++;		
			}
		}
	}

}
