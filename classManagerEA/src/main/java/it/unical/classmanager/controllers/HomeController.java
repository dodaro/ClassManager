package it.unical.classmanager.controllers;

import java.sql.Time;
import java.util.List;
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

import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.CustomHeaderAndBody;
import it.unical.classmanager.utils.GenericContainerBeanList;
import it.unical.classmanager.utils.UserSessionChecker;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final static String HEADER = "home/homeHead.jsp";
    private final static String BODY_STUDENT = "home/homeBodyStudent.jsp";
    private final static String BODY_PROFESSOR = "home/homeBodyProfessor.jsp";
    
    @Autowired
    ApplicationContext appContext;
    
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model,HttpServletRequest request) {
	logger.info("Welcome home! The client locale is {}.", locale);	
	
	User user = UserSessionChecker.checkUserSession(model, request);
	if (user == null) {			
	    return "welcome";
	} 	
	
	model.addAttribute("user",user);
	String role = (String) request.getSession().getAttribute("role");
	if ( role != null ) {
	    model.addAttribute("role",role);
	}
	
	setWelcomeMessage(locale, model, request);
	
	if(user instanceof Student){
	    model.addAttribute("student", (Student)user);
	    CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY_STUDENT);
	    setLastLectures(locale, model, request, (Student)user);
	    setLastMaterials(locale, model, request, (Student)user);
	    setLastHomeworks(locale, model, request, (Student)user);
	}
	
	if(user instanceof Professor){
	    model.addAttribute("professor", (Professor)user);
	    CustomHeaderAndBody.setCustomHeadAndBody(model, HEADER, BODY_PROFESSOR);
	    setLastLectures(locale, model, request, (Professor)user);
	    setLastMaterials(locale, model, request, (Professor)user);
	    setLastHomeworks(locale, model, request, (Professor)user);
	}
	
	return "layout";
    }
    
    @SuppressWarnings("deprecation")
    private void setWelcomeMessage(Locale locale, Model model,HttpServletRequest request){
	Time time = new Time(System.currentTimeMillis());
	String message1="", message2="";
	if(time.getHours()>=7 && time.getHours()<12){
	    message1 = messageSource.getMessage("message.homeGoodMorning1",null,locale);
	    message2 = messageSource.getMessage("message.homeGoodMorning2",null,locale);
	} else if(time.getHours()>=12 && time.getHours()<16){
	    message1 = messageSource.getMessage("message.homeGoodAfternoon1",null,locale);
	    message2 = messageSource.getMessage("message.homeGoodAfternoon2",null,locale);	    
	} else if(time.getHours()>=16 && time.getHours()<21){
	    message1 = messageSource.getMessage("message.homeGoodEvening1",null,locale);
	    message2 = messageSource.getMessage("message.homeGoodEvening2",null,locale);	    
	} else {
	    message1 = messageSource.getMessage("message.homeGoodNight1",null,locale);
	    message2 = messageSource.getMessage("message.homeGoodNight2",null,locale);	    
	}
	
	model.addAttribute("welcomeMessage1", message1);
	model.addAttribute("welcomeMessage2", message2);	
    }
    
    private void setLastLectures(Locale locale, Model model,HttpServletRequest request, Student student){
	List<Object[]> objectList = DaoHelper.getLectureDAO().getLastLectures(student);
	if(objectList.size()>0){
	    GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
	    model.addAttribute("lastLectureList", beanList);
	}	
    }
    
    private void setLastLectures(Locale locale, Model model,HttpServletRequest request, Professor professor){
	List<Object[]> objectList = DaoHelper.getLectureDAO().getLastLectures(professor);
	if(objectList.size()>0){
	    GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
	    model.addAttribute("lastLectureList", beanList);
	}
    }
    
    private void setLastMaterials(Locale locale, Model model,HttpServletRequest request, Student student){
	List<Object[]> objectList = DaoHelper.getMaterialDAO().getLastMaterials(student);
	if(objectList.size()>0){
	    GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
	    model.addAttribute("lastMaterialList", beanList);
	}
    }
    
    private void setLastMaterials(Locale locale, Model model,HttpServletRequest request, Professor professor){
	List<Object[]> objectList = DaoHelper.getMaterialDAO().getLastMaterials(professor);
	if(objectList.size()>0){
	    GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
	    model.addAttribute("lastMaterialList", beanList);
	}
    }
    
    private void setLastHomeworks(Locale locale, Model model,HttpServletRequest request, Student student){
	List<Object[]> objectList = DaoHelper.getHomeworkDAO().getLastHomeworks(student);
	if(objectList.size()>0){
	    GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
	    model.addAttribute("lastHomeworkList", beanList);
	}
    }
    
    private void setLastHomeworks(Locale locale, Model model,HttpServletRequest request, Professor professor){
	List<Object[]> objectList = DaoHelper.getHomeworkDAO().getLastHomeworks(professor);
	if(objectList.size()>0){
	    GenericContainerBeanList beanList = new GenericContainerBeanList(objectList);
	    model.addAttribute("lastHomeworkList", beanList);
	}
    }
}
