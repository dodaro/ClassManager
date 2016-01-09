/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.student;

import java.util.List;

import it.unical.classmanager.model.dao.CartQueryDAO;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.LineBasicCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Voti compiti per corso"
 */
public class Student_HomeworkScoreSeries extends AbstractQueryCart {
    
    public Student_HomeworkScoreSeries() {
	super();
    }
    
    public Student_HomeworkScoreSeries(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	//return buildCartFromQuery(new AreaStackedCart());
	return buildCartFromQuery(new LineBasicCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	//	Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Object[]> homeworkScoreSeriesByStudent = cartQueryDAO.getHomeworkScoreSeriesByStudent((Student)this.getUser());
	
	/*
	 * homeworkScoreSeriesByStudent
	 * Course, Homework, Score
	 * Course, Homework, Score
	 * Course, Homework, Score
	 * ...
	 * Course, Homework, Score
	 */	
	
	cart.setTitle(messageSource.getMessage("message.statistics.Student_HomeworkScoreSeries_Title",null,locale));
	cart.setSubTitle("");
	
	StringBuilder categories = new StringBuilder("");
	String lastCategorie = "";
	for(int i=0; i<homeworkScoreSeriesByStudent.size(); i++){
	    String courseName = homeworkScoreSeriesByStudent.get(i)[0].toString();
	    if(i==0){
		lastCategorie = courseName;
		//categories.append("\'"+courseName+"\'");
		categories.append("\' \'");
	    } else {
		if(!courseName.equals(lastCategorie)){
		    lastCategorie = courseName;
		    //categories.append(", \'"+courseName+"\'");
		    categories.append(", \' \'");
		}
	    }
	}
	cart.setxAxisCategories(" ");
	cart.setyAxisTitle(messageSource.getMessage("message.statistics.Student_HomeworkScoreSeries_yAxisTitle",null,locale));
	cart.setyAxisMinValue(0);
	cart.setyAxisMaxValue(30);	
	cart.setToolTipValueSuffix("");
	StringBuilder seriesContent = new StringBuilder("");
	
	String currentCourse = "";	
	if(homeworkScoreSeriesByStudent.size()>0){
	    for(int i=0; i<homeworkScoreSeriesByStudent.size(); i++){
		String courseName = homeworkScoreSeriesByStudent.get(i)[0].toString();
		//String homeWorkName = avgHomeworksByStudent.get(i)[1].toString();
		float score = Float.parseFloat(homeworkScoreSeriesByStudent.get(i)[2].toString());
		
		currentCourse = courseName;
		
		if(i==0){
		    seriesContent.append("{name: \'"+courseName+"\',\n");
		} else {
		    seriesContent.append(", {name: \'"+courseName+"\',\n");
		}		
		
		StringBuilder data = new StringBuilder("");
		data.append(score);
		
		i++;
		do {
		    courseName = homeworkScoreSeriesByStudent.get(i)[0].toString();
		    //homeWorkName = avgHomeworksByStudent.get(i)[1].toString();
		    score = Float.parseFloat(homeworkScoreSeriesByStudent.get(i)[2].toString());
		    if(courseName.equals(currentCourse)){
			data.append(", "+score);
			i++;
		    } else if(!courseName.equals(currentCourse) && i<homeworkScoreSeriesByStudent.size()){
			i--;
		    }
		}
		while(currentCourse.equals(courseName) && i<homeworkScoreSeriesByStudent.size());
		
		seriesContent.append("data: ["+data+"]}\n");
	    }
	}
	
	cart.setSeriesContent(seriesContent);
	return cart;
    }
    
}
