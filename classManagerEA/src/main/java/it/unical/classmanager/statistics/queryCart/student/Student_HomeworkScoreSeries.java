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
	
	cart.setTitle("Voti compiti");
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
	cart.setyAxisTitle("Scores");
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
		
		//	{name: \'"+courseName+"\', data: [
		//	7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6
		//	]}
		
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
    
    //    @Override
    //    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
    //	//	Query
    //	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
    //	List<Object[]> homeworkScoreSeriesByStudent = cartQueryDAO.getHomeworkScoreSeriesByStudent((Student)this.getUser());
    //	
    //	/*
    //	 * homeworkScoreSeriesByStudent
    //	 * Course, Homework, Score
    //	 * Course, Homework, Score
    //	 * Course, Homework, Score
    //	 * ...
    //	 * Course, Homework, Score
    //	 */
    //	
    //	cart.setTitle("Voti compiti");
    //	cart.setSubTitle("");
    //	cart.setxAxisCategories("");
    //	cart.setyAxisTitle("Scores");
    //	StringBuilder seriesContent = new StringBuilder("");
    //		
    //	String currentCourse = "";	
    //	if(homeworkScoreSeriesByStudent.size()>0){
    //	    for(int i=0; i<homeworkScoreSeriesByStudent.size(); i++){
    //		String courseName = homeworkScoreSeriesByStudent.get(i)[0].toString();
    //		//String homeWorkName = avgHomeworksByStudent.get(i)[1].toString();
    //		float score = Float.parseFloat(homeworkScoreSeriesByStudent.get(i)[2].toString());
    //		
    //		currentCourse = courseName;
    //		
    //		if(i==0){
    //		    seriesContent.append("{name: \'"+currentCourse+"\',\n");
    //		} else {
    //		    seriesContent.append(", {name: \'"+currentCourse+"\',\n");
    //		}		
    //		
    //		StringBuilder data = new StringBuilder("");
    //		data.append(score);
    //		
    //		i++;
    //		do {
    //		    courseName = homeworkScoreSeriesByStudent.get(i)[0].toString();
    //		    //homeWorkName = avgHomeworksByStudent.get(i)[1].toString();
    //		    score = Float.parseFloat(homeworkScoreSeriesByStudent.get(i)[2].toString());
    //		    if(courseName.equals(currentCourse)){
    //			data.append(", "+score);
    //			i++;
    //		    } else if(!courseName.equals(currentCourse) && i<homeworkScoreSeriesByStudent.size()){
    //			i--;
    //		    }
    //		}
    //		while(currentCourse.equals(courseName) && i<homeworkScoreSeriesByStudent.size());
    //		
    //		seriesContent.append("data: ["+data+"]}\n");
    //	    }
    //	}
    //	
    //	//	seriesContent.append("{");
    //	//	{
    //	//	    seriesContent.append("\n");
    //	//	    seriesContent.append("name: \'Asia\',\n");
    //	//	    seriesContent.append("data: [502, 635, 809, 947, 1402, 3634, 5268]\n");
    //	//	    seriesContent.append("}");
    //	//	}
    //	//	seriesContent.append(", {");
    //	//	{
    //	//	    seriesContent.append("\n");
    //	//	    seriesContent.append("name: \'Africa\',\n");
    //	//	    seriesContent.append("data: [106, 107, 111, 133, 221, 767, 1766]\n");
    //	//	    seriesContent.append("}");
    //	//	}
    //	//	seriesContent.append(", {");
    //	//	{
    //	//	    seriesContent.append("\n");
    //	//	    seriesContent.append("name: \'Europe\',\n");
    //	//	    seriesContent.append("data: [163, 203, 276, 408, 547, 729, 628]\n");
    //	//	    seriesContent.append("}");
    //	//	}
    //	//	seriesContent.append(", {");
    //	//	{
    //	//	    seriesContent.append("\n");
    //	//	    seriesContent.append("name: \'America\',\n");
    //	//	    seriesContent.append("data: [18, 31, 54, 156, 339, 818, 1201]\n");
    //	//	    seriesContent.append("}");
    //	//	}
    //	//	seriesContent.append(", {");
    //	//	{
    //	//	    seriesContent.append("\n");
    //	//	    seriesContent.append("name: \'Oceania\',\n");
    //	//	    seriesContent.append("data: [2, 2, 2, 6, 13, 30, 46]\n");
    //	//	    seriesContent.append("}");
    //	//	}	
    //	cart.setSeriesContent(seriesContent);
    //	return cart;
    //    }
    
}
