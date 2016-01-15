package it.unical.classmanager.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.CartsList;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.queryCart.Professor_AvgAttendanceStudent;
import it.unical.classmanager.statistics.queryCart.Professor_AvgLectureByWeekDayAllProfessor;
import it.unical.classmanager.statistics.queryCart.Professor_AvgLectureByWeekDaySingleProfessor;
import it.unical.classmanager.statistics.queryCart.Professor_AvgScoreHomework;
import it.unical.classmanager.statistics.queryCart.Professor_AvgTimeDeliveryHomework;
import it.unical.classmanager.statistics.queryCart.Professor_ForYearLectureByWeekDaySingleProfessor;
import it.unical.classmanager.statistics.queryCart.Professor_NumberCourses;
import it.unical.classmanager.statistics.queryCart.Student_AvgAttendance;
import it.unical.classmanager.statistics.queryCart.Student_AvgHomeworks;
import it.unical.classmanager.statistics.queryCart.Student_AvgTimeDeliveryHomeworks;
import it.unical.classmanager.statistics.queryCart.Student_ExamScoreSeries;
import it.unical.classmanager.statistics.queryCart.Student_HomeworkScoreSeries;
import it.unical.classmanager.utils.CustomHeaderAndBody;
import it.unical.classmanager.utils.UserSessionChecker;

/**
 * @author Aloisius92
 * Handles requests for the statistics page.
 */
@Controller
public class StatisticsController {    
    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);
    private final static String HEADER = "statistics/statisticsHead.jsp";
    private final static String BODY_STUDENT = "statistics/statisticsStudent.jsp";
    private final static String BODY_PROFESSOR = "statistics/statisticsProfessor.jsp";
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired  
    MessageSource messageSource;
    
    /**
     * Show statistics based on the kind of user.
     */
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String statistics(Locale locale, Model model,HttpServletRequest request) {
	logger.info("Statistics Page", locale);
	
	User user = UserSessionChecker.checkUserSession(model, request);
	if ( user != null ) {			
	    if(user instanceof Student){
		logger.info("Student statistics page accessed by "+user.getUsername(), locale);
		model.addAttribute("student", (Student)user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY_STUDENT);
		statisticsForStudent(locale, model, request, (Student)user);	  
		return "layout";
	    }
	    if(user instanceof Professor){
		logger.info("Professor statistics page accessed by "+user.getUsername(), locale);	
		model.addAttribute("professor", (Professor)user);
		CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY_PROFESSOR);
		statisticsForProfessor(locale, model, request, (Professor)user);		
		return "layout";
	    }
	}
	
	return "redirect:/";
    }
    
    public void statisticsForStudent(Locale locale, Model model,HttpServletRequest request, Student student) {
	Student_AvgHomeworks q1 = new Student_AvgHomeworks(student);
	Student_AvgAttendance q2 = new Student_AvgAttendance(student);
	Student_AvgTimeDeliveryHomeworks q3 = new Student_AvgTimeDeliveryHomeworks(student);
	Student_HomeworkScoreSeries q4 = new Student_HomeworkScoreSeries(student);
	Student_ExamScoreSeries q5 = new Student_ExamScoreSeries(student);
	
	AbstractCart[] cartsArray = {
		(q1).getCart(messageSource, locale),
		(q2).getCart(messageSource, locale),
		(q3).getCart(messageSource, locale),
		(q4).getCart(messageSource, locale),
		(q5).getCart(messageSource, locale)
	};
	
	CartsList carts = new CartsList();
	for(int i=1; i<=cartsArray.length; i++){
	    AbstractCart cart = cartsArray[i-1];
	    cart.setIdContainer("idCartContainer"+i); // This should be done in view!
	    carts.add(cart);
	}	
	
	model.addAttribute("cartList", carts);
    }
    
    public void statisticsForProfessor(Locale locale, Model model,HttpServletRequest request, Professor professor) {
	Professor_NumberCourses q1 = new Professor_NumberCourses(professor);
	Professor_ForYearLectureByWeekDaySingleProfessor q2 = new Professor_ForYearLectureByWeekDaySingleProfessor(professor);
	Professor_AvgLectureByWeekDaySingleProfessor q3 = new Professor_AvgLectureByWeekDaySingleProfessor(professor);
	Professor_AvgLectureByWeekDayAllProfessor q4 = new Professor_AvgLectureByWeekDayAllProfessor(professor);
	Professor_AvgTimeDeliveryHomework q5 = new Professor_AvgTimeDeliveryHomework(professor);
	Professor_AvgScoreHomework q6 = new Professor_AvgScoreHomework(professor);
	Professor_AvgAttendanceStudent q7 = new Professor_AvgAttendanceStudent(professor);
	
	AbstractCart[] cartsArray = {
		q1.getCart(messageSource, locale),
		q2.getCart(messageSource, locale),
		q3.getCart(messageSource, locale),
		q4.getCart(messageSource, locale),
		q5.getCart(messageSource, locale),
		q6.getCart(messageSource, locale),
		q7.getCart(messageSource, locale),
	};
	
	CartsList carts = new CartsList();
	for(int i=1; i<=cartsArray.length; i++){
	    AbstractCart cart = cartsArray[i-1];
	    cart.setIdContainer("idCartContainer"+i);
	    carts.add(cart);
	}	
	
	model.addAttribute("cartList", carts);
    }
}
