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
import it.unical.classmanager.statistics.cart.ColumnBasicCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Per ogni corso la media delle presenze di tutti gli studenti"
 */
public class Professor_AvgAttendanceStudent extends AbstractQueryCart {
    
    public Professor_AvgAttendanceStudent() {
	super();
    }
    
    public Professor_AvgAttendanceStudent(User user){
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
	List<Object[]> avgAttendanceStudent = cartQueryDAO.getAvgAttendanceStudent((Professor)this.getUser());
	
	/*
	 * CourseClass, AvgAttendance
	 * CourseClass, AvgAttendance
	 * CourseClass, AvgAttendance
	 */
	
	cart.setTitle(messageSource.getMessage("message.statistics.Professor_AvgAttendanceStudent_Title",null,locale));
	cart.setSubTitle(messageSource.getMessage("message.statistics.Professor_AvgAttendanceStudent_SubTitle",null,locale));
	cart.setyAxisTitle(messageSource.getMessage("message.statistics.Professor_AvgAttendanceStudent_yAxisTitle",null,locale));
	cart.setxAxisTitle("");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(0);
	
	StringBuilder categories = new StringBuilder("");	
	for(int i=0; i<avgAttendanceStudent.size(); i++){
	    String currentData = "\'"+avgAttendanceStudent.get(i)[0]+"\'";
	    if(i==0){
		categories.append(currentData);
	    } else {
		categories.append(", "+currentData);		
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
	seriesContent.append("{name: \'"+messageSource.getMessage("message.statistics.Professor_AvgAttendanceStudent_SeriesContentName",null,locale)+"\', data: [");
	for(int i=0; i<avgAttendanceStudent.size(); i++){
	    float currentData = Float.parseFloat(avgAttendanceStudent.get(i)[1].toString());
	    if(i==0){
		seriesContent.append(currentData);
	    } else {
		seriesContent.append(", "+currentData);		
	    }
	}
	seriesContent.append("]}");	
	
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}