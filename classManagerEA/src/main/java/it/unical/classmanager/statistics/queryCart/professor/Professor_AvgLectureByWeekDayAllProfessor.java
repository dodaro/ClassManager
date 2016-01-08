/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

import java.util.List;

import it.unical.classmanager.model.dao.CartQueryDAO;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.ColumnStackedPercentCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Negli anni il numero medio di lezioni per ogni giorno della settimana"
 */
public class Professor_AvgLectureByWeekDayAllProfessor extends AbstractQueryCart {
    
    public Professor_AvgLectureByWeekDayAllProfessor() {
	super();
    }
    
    public Professor_AvgLectureByWeekDayAllProfessor(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new ColumnStackedPercentCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	// Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Professor> allProfessors = DaoHelper.getUserDAO().getAllProfessors();	
	List<Object[]> avg = cartQueryDAO.getAvgLectureByWeekDayAllProfessor(allProfessors);
	
	/*
	 * Professor, Monday, NumberLecture
	 * Professor, Tuesday, NumberLecture
	 * Professor, Wednesday, NumberLecture
	 * Professor, Thursday, NumberLecture
	 * Professor, Friday, NumberLecture
	 * Professor, Saturday, NumberLecture
	 * Professor, Sunday, NumberLecture
	 * 
	 */

	//	cart.setTitle("Negli anni il numero medio di lezioni per ogni giorno della settimana");
	//	cart.setyAxisTitle("Average Lectures");
	//	cart.setxAxisCategories("\'Monday\', \'Tuesday\', \'Wednesday\', \'Thursday\'"
	//		+ ", \'Friday\', \'Saturday\', \'Sunday\'");
	cart.setTitle(messageSource.getMessage("message.statistics.Professor_AvgLectureByWeekDayAllProfessor_Title",null,locale));
	cart.setyAxisTitle(messageSource.getMessage("message.statistics.Professor_AvgLectureByWeekDayAllProfessor_yAxisTitle",null,locale));
	cart.setxAxisCategories(messageSource.getMessage("message.statistics.Professor_AvgLectureByWeekDayAllProfessor_xAxisCategories",null,locale));
	cart.setSubTitle("");
	cart.setxAxisTitle("");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(0);	
	cart.setyAxisMinValue(0);
	cart.setyAxisMaxValue(0);
	cart.setyAxisCategories("");
	cart.setCategories("");
	StringBuilder categoriesDataContent = new StringBuilder("");
	cart.setCategoriesDataContent(categoriesDataContent);
	cart.setxPlotText("");
	cart.setyPlotText("");
	cart.setxPointTooltip("");
	cart.setyPointTooltip("");
	cart.setzPointTooltip("");
	cart.setToolTipValueSuffix("");
	StringBuilder seriesContent = new StringBuilder("");	
	
	for(int i=0; i<avg.size(); i+=7){
	    if(i==0){
		seriesContent.append("{");		
	    } else {
		seriesContent.append(", {");
	    }
	    
	    {
		seriesContent.append("\n");
		seriesContent.append("name: \'"+avg.get(i)[0].toString()+"\',\n");
		seriesContent.append("data: [");
		
		for(int j=0; j<7; j++){
		    float currentData = Float.parseFloat(avg.get(i+j)[2].toString());
		    if(j==0){
			seriesContent.append(currentData);			
		    } else {
			seriesContent.append(", "+currentData);			
		    }
		}
		
		seriesContent.append("]\n");
		seriesContent.append("}");
	    }
	}
	
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}




