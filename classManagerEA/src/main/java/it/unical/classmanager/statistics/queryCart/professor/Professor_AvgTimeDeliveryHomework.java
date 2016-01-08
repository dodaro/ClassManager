/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import it.unical.classmanager.model.dao.CartQueryDAO;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.ColumnStackedCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Chi consegna prima? 
 * Per ogni corso tra gli studenti iscritti calcola 
 * la media tra le differenze del giorno di asseganzione 
 * del compito e il giorno di consegna."
 */
public class Professor_AvgTimeDeliveryHomework extends AbstractQueryCart {
    
    public Professor_AvgTimeDeliveryHomework() {
	super();
    }
    
    public Professor_AvgTimeDeliveryHomework(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new ColumnStackedCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	// Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Object[]> avgTimeDeliveryHomework = cartQueryDAO.getAvgTimeDeliveryHomework((Professor)this.getUser());
	
	/*
	 * CourseClass, AvgTime
	 * CourseClass, AvgTime
	 * CourseClass, AvgTime
	 */
	
	//	cart.setTitle("Chi consegna prima?");
	//	cart.setyAxisTitle("Time Delivery");
	cart.setTitle(messageSource.getMessage("message.statistics.Professor_AvgTimeDeliveryHomework_Title",null,locale));
	cart.setyAxisTitle(messageSource.getMessage("message.statistics.Professor_AvgTimeDeliveryHomework_yAxisTitle",null,locale));
	cart.setSubTitle("");
	cart.setxAxisTitle("");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(0);
	
	StringBuilder categories = new StringBuilder("");
	String lastCourse = "";
	for(int i=0; i<avgTimeDeliveryHomework.size(); i++){
	    String currentData = "\'"+avgTimeDeliveryHomework.get(i)[0].toString()+"\'";
	    if(!lastCourse.equals(currentData)){
		lastCourse = currentData;
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
	
	HashMap<String, List<Float>> studentTime = new HashMap<String, List<Float>>();
	for(int i=0; i<avgTimeDeliveryHomework.size(); i++){
	    String student = avgTimeDeliveryHomework.get(i)[1].toString();
	    Float value = Float.parseFloat(avgTimeDeliveryHomework.get(i)[2].toString());
	    
	    List<Float> list = studentTime.get(student);
	    if(list==null){
		studentTime.put(student, new ArrayList<Float>());
	    }
	    studentTime.get(student).add(value);
	}
	
	Set<String> keySet = studentTime.keySet();
	int k =0;
	for(String key : keySet){
	    if(k==0){
		seriesContent.append("{");			
	    } else {
		seriesContent.append(", {");		
	    }
	    
	    seriesContent.append("\n");
	    seriesContent.append("name: \'"+key+"\',\n");
	    seriesContent.append("data: [");
	    
	    List<Float> list = studentTime.get(key);
	    for(int i=0; i<list.size(); i++){
		float currentValue = list.get(i);
		currentValue = (float) (((int)(currentValue*100.0f))/100.0f);
		if(i==0){
		    seriesContent.append(currentValue);			
		} else {
		    seriesContent.append(", "+currentValue);		
		}
	    }	    
	    seriesContent.append("],\n");
	    seriesContent.append(""+messageSource.getMessage("message.statistics.Professor_AvgTimeDeliveryHomework_StackPrefix",null,locale)+": \'student\'\n");
	    seriesContent.append("}");
	    
	    k++;
	}
	
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}
