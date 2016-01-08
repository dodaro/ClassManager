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
import it.unical.classmanager.statistics.cart.PolarSpiderCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Media compiti per corso"
 */
public class Student_AvgHomeworks extends AbstractQueryCart {
    
    public Student_AvgHomeworks() {
	super();
    }
    
    public Student_AvgHomeworks(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new PolarSpiderCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	//	Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Object[]> avgHomeworksByStudent = cartQueryDAO.getAvgHomeworksByStudent((Student)this.getUser());
	
	/*
	 * avgHomeworksByStudent
	 * Course1, AvgScore
	 * Course2, AvgScore
	 * Course3, AvgScore
	 * ...
	 * CourseN, AvgScore
	 */	
	
	//	cart.setTitle("Media compiti");
	cart.setTitle(messageSource.getMessage("message.statistics.Student_AvgHomeworks_Title",null,locale));
	
	StringBuilder categories = new StringBuilder("");
	for(int i=0; i<avgHomeworksByStudent.size(); i++){
	    if(i==0){
		categories.append("\'"+avgHomeworksByStudent.get(i)[0].toString()+"\'");
	    } else {
		categories.append(", \'"+avgHomeworksByStudent.get(i)[0].toString()+"\'");		
	    }
	}
	cart.setxAxisCategories(categories.toString());
	cart.setyAxisMinValue(0);
	StringBuilder seriesContent = new StringBuilder("");
	
	seriesContent.append("{name: \'"+messageSource.getMessage("message.statistics.Student_AvgHomeworks_SeriesContentName",null,locale)+"\', data: [");
	for(int i=0; i<avgHomeworksByStudent.size(); i++){
	    float avgValue = Float.parseFloat(avgHomeworksByStudent.get(i)[1].toString());
	    if(i==0){
		seriesContent.append(avgValue);
	    } else {
		seriesContent.append(", "+avgValue);		
	    }
	}
	seriesContent.append("], pointPlacement: \'on\'}");
	cart.setSeriesContent(seriesContent);
	
	return cart;
    }
    
}
