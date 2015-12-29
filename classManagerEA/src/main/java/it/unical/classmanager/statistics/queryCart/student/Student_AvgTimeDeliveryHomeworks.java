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
 * Query: "Media tempi consegna compiti per corso"
 */
public class Student_AvgTimeDeliveryHomeworks extends AbstractQueryCart {
    
    public Student_AvgTimeDeliveryHomeworks() {
	super();
    }
    
    public Student_AvgTimeDeliveryHomeworks(User user){
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
	List<Object[]> avgTimeDeliveryHomeworksByStudent = cartQueryDAO.getAvgTimeDeliveryHomeworksByStudent((Student)this.getUser());
	
	/*
	 * avgTimeDeliveryHomeworksByStudent
	 * Course, AvgTime
	 * Course, AvgTime
	 * Course, AvgTime
	 * ...
	 * Course, AvgTime
	 */
	
	cart.setTitle("Media tempi di consegna");
	StringBuilder categories = new StringBuilder("");
	for(int i=0; i<avgTimeDeliveryHomeworksByStudent.size(); i++){
	    if(i==0){
		categories.append("\'"+avgTimeDeliveryHomeworksByStudent.get(i)[0].toString()+"\'");
	    } else {
		categories.append(", \'"+avgTimeDeliveryHomeworksByStudent.get(i)[0].toString()+"\'");		
	    }
	}
	cart.setxAxisCategories(categories.toString());
//	cart.setxAxisCategories("\'Sales\', \'Marketing\', "
//		+ "\'Development\', \'Customer Support\', "
//		+ "\'Information Technology\', \'Administration\'");
	cart.setyAxisMinValue(0);
	StringBuilder seriesContent = new StringBuilder("");
	
	seriesContent.append("{name: \'All Courses\', data: [");
	for(int i=0; i<avgTimeDeliveryHomeworksByStudent.size(); i++){
	    float avgValue = Float.parseFloat(avgTimeDeliveryHomeworksByStudent.get(i)[1].toString());
	    if(i==0){
		seriesContent.append(avgValue);
	    } else {
		seriesContent.append(", "+avgValue);		
	    }
	}
	seriesContent.append("], pointPlacement: \'on\'}");
	
	//	seriesContent.append("{");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("name: \'Allocated Budget\',\n");
	//	    seriesContent.append("data: [43000, 19000, 60000, 35000, 17000, 10000],\n");
	//	    seriesContent.append("pointPlacement: \'on\'\n");
	//	    seriesContent.append("}");
	//	}
	//	seriesContent.append(", {");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("name: \'Actual Spending\',\n");
	//	    seriesContent.append("data: [50000, 39000, 42000, 31000, 26000, 14000],\n");
	//	    seriesContent.append("pointPlacement: \'on\'\n");
	//	    seriesContent.append("}");
	//	}
	cart.setSeriesContent(seriesContent);
	
	return cart;
    }
    
}
