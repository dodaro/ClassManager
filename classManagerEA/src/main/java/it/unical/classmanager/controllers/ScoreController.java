package it.unical.classmanager.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import it.unical.classmanager.model.ScoresPageTransformView;
import it.unical.classmanager.model.dao.HomeworkDAO;
import it.unical.classmanager.model.dao.HomeworkDAOImpl;
import it.unical.classmanager.model.dao.HomeworkStudentSolvingDAO;
import it.unical.classmanager.model.dao.HomeworkStudentSolvingDAOImpl;
import it.unical.classmanager.model.data.Homework;
import it.unical.classmanager.model.data.HomeworkStudentSolving;

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
	public String getScores(Model model) {

		//TODO prendere dalla sessione
		int idCourse = 1;
		
		model.addAttribute("customHeader",ScoreController.HEADER);
		model.addAttribute("customBody",ScoreController.BODY);
		
		HomeworkDAO homeworkDAO = appContext.getBean("homeworkDAO",HomeworkDAOImpl.class);
		List<Homework> homeworks = homeworkDAO.getAllHomeworks(idCourse);
		
		model.addAttribute("homeworks", homeworks);
		
		ScoresPageTransformView transformView = new ScoresPageTransformView();
		
		for (Homework homework : homeworks) {
			
			for (HomeworkStudentSolving solution : homework.getHomeworkStudentSolvings()) {
				
				String username = solution.getStudent().getUsername();
				String name = solution.getStudent().getFirstName() + " " + solution.getStudent().getLastName();
				transformView.addStudent(username, name);
				
				transformView.addHomework(username, solution.getHomework().getId());
				transformView.addScore(solution.getId(), solution.getScore());
				
				transformView.addHomeworkName(solution.getHomework().getId(),solution.getHomework().getName());
				
				String key = solution.getHomework().getId() + "-" + username;
				transformView.addHomeworkSolution(key, solution.getId());
			}
		}
		
		model.addAttribute("map", new Gson().toJson(transformView));
		
		logger.info("getScores");
		return "layout";

	}
	
	@RequestMapping(value = "/update_scores", method = RequestMethod.POST)
	public @ResponseBody String getScoresData(Model model, @RequestBody List<HomeworkStudentSolving> homeworkStudentSolvings) {

		for (HomeworkStudentSolving homeworkStudentSolving : homeworkStudentSolvings) {
			
			int id = homeworkStudentSolving.getId();
			int score = homeworkStudentSolving.getScore();
			
			HomeworkStudentSolvingDAO dao = appContext.getBean("homeworkStudentSolvingDAO",HomeworkStudentSolvingDAOImpl.class);
			HomeworkStudentSolving original = dao.get(id);
			original.setScore(score);
			
			dao.update(original);
			
			//update db;
		}
		
		logger.info("update_score");
		return "200";

	}		
}
