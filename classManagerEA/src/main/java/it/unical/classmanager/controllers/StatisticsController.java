package it.unical.classmanager.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.CartsList;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.queryCart.professor.Professor_AvgLectureByWeekDayAllProfessor;
import it.unical.classmanager.statistics.queryCart.professor.Professor_AvgLectureByWeekDaySingleProfessor;
import it.unical.classmanager.statistics.queryCart.professor.Professor_AvgScoreHomework;
import it.unical.classmanager.statistics.queryCart.professor.Professor_AvgTimeDeliveryHomework;
import it.unical.classmanager.statistics.queryCart.professor.Professor_AvgAttendanceAllStudent;
import it.unical.classmanager.statistics.queryCart.professor.Professor_AvgAttendanceSingleStudent;
import it.unical.classmanager.statistics.queryCart.professor.Professor_ForYearAvgLectureByWeekDayAllProfessor;
import it.unical.classmanager.statistics.queryCart.professor.Professor_ForYearAvgLectureByWeekDaySingleProfessor;
import it.unical.classmanager.statistics.queryCart.professor.Professor_ForYearLectureByWeekDayAllProfessor;
import it.unical.classmanager.statistics.queryCart.professor.Professor_ForYearLectureByWeekDaySingleProfessor;
import it.unical.classmanager.statistics.queryCart.professor.Professor_NumberCourses;
import it.unical.classmanager.statistics.queryCart.student.Student_AvgHomeworks;
import it.unical.classmanager.statistics.queryCart.student.Student_AvgAttendance;
import it.unical.classmanager.statistics.queryCart.student.Student_AvgTimeDeliveryHomeworks;
import it.unical.classmanager.statistics.queryCart.student.Student_HomeworkScoreSeries;
import it.unical.classmanager.statistics.queryCart.student.Student_ExamScoreSeries;

/**
 * @author Aloisius92
 * Handles requests for the statistics page.
 */
@Controller
public class StatisticsController {
    
    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);
    
    @Autowired
    ApplicationContext appContext;
    
    /**
     * Show statistics based on the kind of user.
     */
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String statistics(Locale locale, Model model,HttpServletRequest request) {
	logger.info("Statistics Page", locale);
	
	String username = (String) request.getSession().getAttribute("loggedIn");
	
	return statisticsForStudent(locale, model, request, null);
	
	//	if ( username == null ) {			
	//	    return "redirect:/";
	//	}	
	//	
	//	UserDAO userDao = (UserDAOImpl)  appContext.getBean("userDao", UserDAOImpl.class);		
	//	User user = userDao.get(username);
	//	model.addAttribute("user",user.getUsername());
	//	
	//	if(user instanceof Student){
	//	    logger.info("Student statistics page accessed by "+user.getUsername(), locale);
	//	    model.addAttribute("student", (Student)user);
	//	    return statisticsForStudent(locale, model, request, (Student)user);
	//	    
	//	}
	//	if(user instanceof Professor){
	//	    logger.info("Professor statistics page accessed by "+user.getUsername(), locale);	
	//	    model.addAttribute("professor", (Professor)user);
	//	    return statisticsForProfessor(locale, model, request, (Professor)user);
	//	}
	//	
	//	return "redirect:/";
    }
    
    public String statisticsForStudent(Locale locale, Model model,HttpServletRequest request, Student student) {
	//	Query
	Student_AvgHomeworks q1 = new Student_AvgHomeworks();
	q1.getCart().setName("AverageHomeworksCourseClass");
	//	Query
	Student_AvgAttendance q2 = new Student_AvgAttendance();
	q2.getCart().setName("ForCourseClassAverageAttendance");
	//	Query
	Student_AvgTimeDeliveryHomeworks q3 = new Student_AvgTimeDeliveryHomeworks();
	q3.getCart().setName("ForCourseClassAverageTimeDeliveryHomeworks");
	//	Query
	Student_HomeworkScoreSeries q4 = new Student_HomeworkScoreSeries();
	q4.getCart().setName("ForCourseClassSeriesScoresHomeworks");
	//	Query
	Student_ExamScoreSeries q5 = new Student_ExamScoreSeries();
	q5.getCart().setName("SeriesScoreExams");
	
	AbstractCart[] cartsArray = {
		(q1).getCart(),
		(q2).getCart(),
		(q3).getCart(),
		(q4).getCart(),
		(q5).getCart()
	};
	
	CartsList carts = new CartsList();
	for(int i=1; i<=cartsArray.length; i++){
	    AbstractCart cart = cartsArray[i-1];
	    cart.setIdContainer("idCartContainer"+i); // This should be done in view!
	    carts.add(cart);
	}	
	
	model.addAttribute("cartList", carts);
	
	return "statistics";
    }
    
    public String statisticsForProfessor(Locale locale, Model model,HttpServletRequest request, Professor professor) {
	//	Q - Grafico professori e numero corsi che sostengono
	Professor_NumberCourses q1 = new Professor_NumberCourses();
	q1.getCart().setName("NumberCourses");
	
	//	Q - per ogni anno il numero totale di lezioni per ogni giorno della settimana
	Professor_ForYearLectureByWeekDaySingleProfessor q2 = new Professor_ForYearLectureByWeekDaySingleProfessor();
	q2.getCart().setName("ForYearLectureByWeekDaySingleProfessor");
	//	Q - per ogni anno il numero medio di lezioni per ogni giorno della settimana
	Professor_ForYearAvgLectureByWeekDaySingleProfessor q3 = new Professor_ForYearAvgLectureByWeekDaySingleProfessor();
	q3.getCart().setName("ForYearAvgLectureByWeekDaySingleProfessor");
	//	Q - negli anni il numero medio di lezioni per ogni giorno della settimana
	Professor_AvgLectureByWeekDaySingleProfessor q4 = new Professor_AvgLectureByWeekDaySingleProfessor();
	q4.getCart().setName("AvgLectureByWeekDaySingleProfessor");
	
	//	Q - per ogni anno il numero totale di lezioni per ogni giorno della settimana
	Professor_ForYearLectureByWeekDayAllProfessor q6 = new Professor_ForYearLectureByWeekDayAllProfessor();	
	q6.getCart().setName("ForYearLectureByWeekDayAllProfessor");
	//	Q - per ogni anno il numero medio di lezioni per ogni giorno della settimana
	Professor_ForYearAvgLectureByWeekDayAllProfessor q5 = new Professor_ForYearAvgLectureByWeekDayAllProfessor();
	q5.getCart().setName("ForYearAvgLectureByWeekDayAllProfessor");
	//	Q - negli anni il numero medio di lezioni per ogni giorno della settimana
	Professor_AvgLectureByWeekDayAllProfessor q7 = new Professor_AvgLectureByWeekDayAllProfessor();
	q7.getCart().setName("AvgLectureByWeekDayAllProfessor");
	
	//	Q - Chi consegna prima? Per ogni corso tra gli studenti iscritti calcola la media tra le differenze del giorno di asseganzione del compito e il giorno di consegna.
	Professor_AvgTimeDeliveryHomework q8 = new Professor_AvgTimeDeliveryHomework();
	q8.getCart().setName("AvgTimeDeliveryHomework");
	//	Q - Chi prende i voti migliori? Per ogni corso tra gli studenti iscritti calcola la media tra le valutazioni dei compiti, (se uno studente non svolge il compito valutazione 0).
	Professor_AvgScoreHomework q9 = new Professor_AvgScoreHomework();
	q9.getCart().setName("AvgScoreHomework");
	
	//	Q - per ogni corso la media delle presenze di tutti gli studenti
	Professor_AvgAttendanceAllStudent q10 = new Professor_AvgAttendanceAllStudent();
	q10.getCart().setName("AvgAttendanceAllStudent");
	//	Q - per ogni corso il numero medio di presenze di ogni studente
	Professor_AvgAttendanceSingleStudent q11 = new Professor_AvgAttendanceSingleStudent();	
	q11.getCart().setName("AvgAttendanceSingleStudent");
	
	AbstractCart[] cartsArray = {
		q1.getCart(),
		q2.getCart(),
		q3.getCart(),
		q4.getCart(),
		q5.getCart(),
		q6.getCart(),
		q7.getCart(),
		q8.getCart(),
		q9.getCart(),
		q10.getCart(),
		q11.getCart()
	};
	
	CartsList carts = new CartsList();
	for(int i=1; i<=cartsArray.length; i++){
	    AbstractCart cart = cartsArray[i-1];
	    cart.setIdContainer("idCartContainer"+i);
	    carts.add(cart);
	}	
	
	model.addAttribute("cartList", carts);
	
	return "statistics";
    }
}
