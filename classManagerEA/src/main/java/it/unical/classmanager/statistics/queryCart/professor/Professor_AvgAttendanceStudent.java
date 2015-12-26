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
	
	cart.setTitle("Media delle presenze");
	cart.setSubTitle("Per ogni corso la media delle presenze di tutti gli studenti");
	cart.setxAxisTitle("");
	cart.setyAxisTitle("Average Attendance");
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
	seriesContent.append("{name: \'All Courses\', data: [");
	for(int i=0; i<avgAttendanceStudent.size(); i++){
	    float currentData = Float.parseFloat(avgAttendanceStudent.get(i)[1].toString());
	    if(i==0){
		seriesContent.append(currentData);
	    } else {
		seriesContent.append(", "+currentData);		
	    }
	}
	seriesContent.append("]}");	
	
	//	seriesContent.append("{");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("name: \'Tokyo\',\n");
	//	    seriesContent.append("data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]\n");
	//	    seriesContent.append("}");
	//	}
	//	seriesContent.append(", {");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("name: \'New York\',\n");
	//	    seriesContent.append("data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]\n");
	//	    seriesContent.append("}");
	//	}
	//	seriesContent.append(", {");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("name: \'London\',\n");
	//	    seriesContent.append("data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]\n");
	//	    seriesContent.append("}");
	//	}
	//	seriesContent.append(", {");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("name: \'Berlin\',\n");
	//	    seriesContent.append("data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]\n");
	//	    seriesContent.append("}");
	//	}
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}