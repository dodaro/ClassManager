/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.unical.classmanager.model.dao.CartQueryDAO;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.ColumnBasicCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Per ogni anno il numero totale di lezioni per ogni giorno della settimana"
 */
public class Professor_ForYearLectureByWeekDaySingleProfessor extends AbstractQueryCart {
    
    public Professor_ForYearLectureByWeekDaySingleProfessor() {
	super();
    }
    
    public Professor_ForYearLectureByWeekDaySingleProfessor(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new ColumnBasicCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	// Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Object[]> queryData = cartQueryDAO.getForYearLectureByWeekDay((Professor)this.getUser());
	HashMap<String, List<Float>> dayLecture = new HashMap<String, List<Float>>();
	String days[] = {"Sunday", "Monday", "Tuesday","Wednesday",
		"Thursday", "Friday", "Saturday"};
	for(int i=0; i<days.length; i++){
	    dayLecture.put(days[i], new ArrayList<Float>());
	}
	
	/*
	 * 2012, Monday, NumberLecture
	 * 2012, Tuesday, NumberLecture
	 * 2012, Wednesday, NumberLecture
	 * 2012, Thursday, NumberLecture
	 * 2012, Friday, NumberLecture
	 * 2012, Saturday, NumberLecture
	 * 2012, Sunday, NumberLecture
	 * 2013, Monday, NumberLecture
	 * 2013, Tuesday, NumberLecture
	 * 2013, Wednesday, NumberLecture
	 * 2013, Thursday, NumberLecture
	 * 2013, Friday, NumberLecture
	 * 2013, Saturday, NumberLecture
	 * 2013, Sunday, NumberLecture
	 * 2014, Monday, NumberLecture
	 * 2014, Tuesday, NumberLecture
	 * 2014, Wednesday, NumberLecture
	 * 2014, Thursday, NumberLecture
	 * 2014, Friday, NumberLecture
	 * 2014, Saturday, NumberLecture
	 * 2014, Sunday, NumberLecture
	 * 
	 */
		
	cart.setTitle(messageSource.getMessage("message.statistics.Professor_ForYearLectureByWeekDaySingleProfessor_Title",null,locale));
	cart.setSubTitle(messageSource.getMessage("message.statistics.Professor_ForYearLectureByWeekDaySingleProfessor_SubTitle",null,locale));
	cart.setyAxisTitle(messageSource.getMessage("message.statistics.Professor_ForYearLectureByWeekDaySingleProfessor_yAxisTitle",null,locale));
	cart.setxAxisTitle("");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(0);
	
	StringBuilder categories = new StringBuilder("");
	String lastYear = "";
	for(int i=0; i<queryData.size(); i++){
	    String currentData = "\'"+queryData.get(i)[0].toString()+"\'";
	    if(!lastYear.equals(currentData)){
		lastYear = currentData;
		if(i==0){
		    categories.append(currentData);
		} else {
		    categories.append(", "+currentData);		
		}
	    }
	}	
	cart.setxAxisCategories(categories.toString());
	
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
	
	for(int i=0; i<queryData.size(); i++){
	    //String day = queryData.get(i)[1].toString();
	    int dayIndex = Integer.parseInt(queryData.get(i)[1].toString())-1;
	    Float value = Float.parseFloat(queryData.get(i)[2].toString());	 
	    dayLecture.get(days[dayIndex]).add(value);
	}
	
	for(int i=0; i<days.length; i++){
	    if(i==0){
		seriesContent.append("{");			
	    } else {
		seriesContent.append(", {");		
	    }
	    seriesContent.append("name: \'"+days[i]+"\',");
	    seriesContent.append("data: [");
	    
	    List<Float> list = dayLecture.get(days[i]);
	    for(int j=0; j<list.size(); j++){
		float currentValue = list.get(j);
		if(j==0){
		    seriesContent.append(currentValue);			
		} else {
		    seriesContent.append(", "+currentValue);		
		}
	    }		    
	    seriesContent.append("]}");
	}
	
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}
