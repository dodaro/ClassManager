/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.student;

import java.util.Date;
import java.util.List;

import it.unical.classmanager.model.dao.CartQueryDAO;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.SplineIrregularTimeCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Voti esami"
 */
public class Student_ExamScoreSeries extends AbstractQueryCart {
    
    public Student_ExamScoreSeries() {
	super();
    }
    
    public Student_ExamScoreSeries(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new SplineIrregularTimeCart());
    }
    
    @SuppressWarnings("deprecation")
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	//	Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Object[]> examScoreSeriesByStudent = cartQueryDAO.getExamScoreSeriesByStudent((Student)this.getUser());
	
	/*
	 * avgHomeworksByStudent
	 * Anno, Date, ExamName, Score
	 * Anno, Date, ExamName, Score
	 * Anno, Date, ExamName, Score
	 * Anno, Date, ExamName, Score
	 * ...
	 * Anno, Date, ExamName, Score
	 */
		
	//	cart.setTitle("Voti esami");
	//	cart.setSubTitle("La serie dei voti degli esami");
	//	cart.setxAxisTitle("Time");
	//	cart.setyAxisTitle("Score");
	cart.setTitle(messageSource.getMessage("message.statistics.Student_ExamScoreSeries_Title",null,locale));
	cart.setSubTitle(messageSource.getMessage("message.statistics.Student_ExamScoreSeries_SubTitle",null,locale));
	cart.setxAxisTitle(messageSource.getMessage("message.statistics.Student_ExamScoreSeries_xAxisTitle",null,locale));
	cart.setyAxisTitle(messageSource.getMessage("message.statistics.Student_ExamScoreSeries_yAxisTitle",null,locale));
	cart.setyAxisMinValue(0);
	cart.setyAxisMaxValue(30);
	StringBuilder seriesContent = new StringBuilder("");
	
	int currentYear = 0;
	
	if(examScoreSeriesByStudent.size()>0){
	    for(int i=0; i<examScoreSeriesByStudent.size(); i++){
		int year = Integer.parseInt(examScoreSeriesByStudent.get(i)[0].toString());
		Date date = (Date) examScoreSeriesByStudent.get(i)[1];
		//String examName = examScoreSeriesByStudent.get(i)[2].toString();
		float score = Float.parseFloat(examScoreSeriesByStudent.get(i)[3].toString());
		
		currentYear = year;
		
		if(i==0){
		    seriesContent.append("{name: \'"+currentYear+"\',\n");
		} else {
		    seriesContent.append(", {name: \'"+currentYear+"\',\n");
		}		
		
		StringBuilder data = new StringBuilder("");
		data.append("[Date.UTC("+date.getYear()+", "+(date.getMonth()-1)+", "+date.getDate()+"), "+score+"]\n");		
		
		i++;
		if(i<examScoreSeriesByStudent.size()){
		    do {
			year = Integer.parseInt(examScoreSeriesByStudent.get(i)[0].toString());
			date = (Date) examScoreSeriesByStudent.get(i)[1];
			//examName = examScoreSeriesByStudent.get(i)[2].toString();
			score = Float.parseFloat(examScoreSeriesByStudent.get(i)[3].toString());
			
			if(currentYear == year){
			    data.append(",[Date.UTC("+date.getYear()+", "+(date.getMonth()-1)+", "+date.getDate()+"), "+score+"]\n");		
			    i++;
			} else if(!(currentYear == year) && i<examScoreSeriesByStudent.size()){
			    i--;
			}
		    }
		    while((currentYear == year) && i<examScoreSeriesByStudent.size());
		}
		
		seriesContent.append("data: ["+data+"]}\n");
	    }
	}
	
	cart.setSeriesContent(seriesContent);
	
	return cart;
    }
    
}
