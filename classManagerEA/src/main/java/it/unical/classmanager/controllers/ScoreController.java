package it.unical.classmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import it.unical.classmanager.model.PartecipationWrapper;
import it.unical.classmanager.model.ScoresPageTransformView;
import it.unical.classmanager.model.dao.AttendanceStudentLectureDAO;
import it.unical.classmanager.model.dao.AttendanceStudentLectureDAOImpl;
import it.unical.classmanager.model.dao.CourseClassDAO;
import it.unical.classmanager.model.dao.CourseClassDAOImpl;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.dao.HomeworkDAO;
import it.unical.classmanager.model.dao.HomeworkDAOImpl;
import it.unical.classmanager.model.dao.HomeworkStudentSolvingDAO;
import it.unical.classmanager.model.dao.HomeworkStudentSolvingDAOImpl;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAO;
import it.unical.classmanager.model.dao.RegistrationStudentClassDAOImpl;
import it.unical.classmanager.model.dao.StudentExamPartecipationDAO;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Exam;
import it.unical.classmanager.model.data.Homework;
import it.unical.classmanager.model.data.HomeworkStudentSolving;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.StudentExamPartecipation;

@Controller
public class ScoreController {

	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

	private final static String HEADER = "scoresPage/scoresPageHeader.jsp";
	private final static String BODY = "scoresPage/scoresPageBody.jsp";

	/**
	 * This controller handles requests related to the visualization and evaluation of homeworks
	 */
	//TODO ADD ALSO EXAM EVALUATION
	@RequestMapping(value = "/scores", method = RequestMethod.GET)
	public String getScores(Model model, Integer yearFilter, Integer lectureFilter) {

		//TODO prendere dalla sessione
		int idCourse = 1;

		model.addAttribute("customHeader",ScoreController.HEADER);
		model.addAttribute("customBody",ScoreController.BODY);

		HomeworkDAO homeworkDAO = appContext.getBean("homeworkDAO",HomeworkDAOImpl.class);
		List<Homework> homeworks = homeworkDAO.getAllHomeworks(idCourse);

		CourseClassDAO courseClassDAO = appContext.getBean("courseClassDAO", CourseClassDAOImpl.class);
		CourseClass course = courseClassDAO.get(idCourse);

		RegistrationStudentClassDAO userDao = appContext.getBean("registrationStudentClassDAO", RegistrationStudentClassDAOImpl.class);
		List<Student> students = userDao.getStudentsRegisteredToACourse(course);
		
		StudentExamPartecipationDAO studentExamPartecipationDAO = DaoHelper.getStudentExamPartecipationDAO();
		
		
		List<Exam> exams = course.getExams();
		List<StudentExamPartecipation> partecipations = new ArrayList<StudentExamPartecipation>();
		
		for (Student student : students) {
			for (Exam exam : exams) {
				
				List<StudentExamPartecipation> partecipationBy = studentExamPartecipationDAO.getPartecipationBy(student, exam);
				if(partecipationBy != null)
					partecipations.addAll(partecipationBy);
			}
		}

		partecipations.remove(0);
		model.addAttribute("students", students);
		model.addAttribute("homeworks", homeworks);
		model.addAttribute("partecipations", partecipations);
		model.addAttribute("exams", exams);

		model.addAttribute("lectureId", lectureFilter);
		model.addAttribute("yearFilter", yearFilter);
		
		model.addAttribute("lectures", course.getLectures());
		model.addAttribute("lecture", new Lecture());
		
		logger.info("getScores");
		return "layout";

	}

	@RequestMapping(value = "/update_score", method = RequestMethod.POST)
	public @ResponseBody String updateHomework(Model model, @RequestBody HomeworkStudentSolving homeworkStudentSolving) {

		int id = homeworkStudentSolving.getId();
		int score = homeworkStudentSolving.getScore();

		if(score > 30 || score < 0)
			return "{errors:{'code': 400, 'msg': \"incorrect range\"}}";
		
		HomeworkStudentSolvingDAO dao = appContext.getBean("homeworkStudentSolvingDAO",HomeworkStudentSolvingDAOImpl.class);
		HomeworkStudentSolving original = dao.get(id);
		original.setScore(score);

		dao.update(original);

		logger.info("update_score");
		return "200";

	}
	
	@RequestMapping(value = "/create_Partecipation", method = RequestMethod.POST)
	public @ResponseBody String updateExam(@RequestBody PartecipationWrapper part, Model model) {

		boolean praise = part.getPraise();
		int examId = part.getParentId();
		String studentId = part.getStudentId();
		int score = part.getScore();
		
		if(score > 30 || score < 0)
			return "{errors:{'code': 400, 'msg': \"incorrect range\"}}";
		
		Exam exam = DaoHelper.getExamDAO().get(examId);
		Student student = new Student(DaoHelper.getUserDAO().get(studentId));
		
		StudentExamPartecipationDAO studentExamPartecipationDAO = DaoHelper.getStudentExamPartecipationDAO();
		StudentExamPartecipation sep = new StudentExamPartecipation();
		sep.setExam(exam);
		sep.setPraise(praise);
		sep.setStudent(student);
		sep.setScore(score);
		
		studentExamPartecipationDAO.create(sep);

		logger.info("create partecipation");
		return "{errors:{'code': 200, 'msg': \"ok\"}}";

	}
	
	@RequestMapping(value = "/update_Partecipation", method = RequestMethod.POST)
	public @ResponseBody String updatePartecipation(Model model, @RequestBody StudentExamPartecipation studentExamPartecipation) {

		int id = studentExamPartecipation.getId();
		int score = studentExamPartecipation.getScore();

		if(score > 30 || score < 0)
			return "{errors:{'code': 400, 'msg': \"incorrect range\"}}";
		
		StudentExamPartecipationDAO studentExamPartecipationDAO = DaoHelper.getStudentExamPartecipationDAO();
		StudentExamPartecipation original = studentExamPartecipationDAO.get(id);
		original.setScore(score);

		studentExamPartecipationDAO.update(original);

		logger.info("update partecipation");
		return "200";

	}
}
