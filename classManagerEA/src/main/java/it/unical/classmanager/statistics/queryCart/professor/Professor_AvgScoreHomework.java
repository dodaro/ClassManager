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
import it.unical.classmanager.statistics.cart.ColumnStackedAndGroupedCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Chi prende i voti migliori? 
 * Per ogni corso tra gli studenti iscritti 
 * calcola la media tra le valutazioni dei compiti, 
 * (se uno studente non svolge il compito valutazione 0)."
 */
public class Professor_AvgScoreHomework extends AbstractQueryCart {
    
    public Professor_AvgScoreHomework() {
	super();
    }
    
    public Professor_AvgScoreHomework(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new ColumnStackedAndGroupedCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	// Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Object[]> avgScoreHomework = cartQueryDAO.getAvgScoreHomework((Professor)this.getUser());
	
	/*
	 * CourseClass, Student, AvgScore
	 * CourseClass, Student, AvgScore
	 * CourseClass, Student, AvgScore
	 */
	
	//	cart.setTitle("Chi prende i voti migliori?");
	//	cart.setyAxisTitle("Scores");
	cart.setTitle(messageSource.getMessage("message.statistics.Professor_AvgScoreHomework_Title",null,locale));
	cart.setyAxisTitle(messageSource.getMessage("message.statistics.Professor_AvgScoreHomework_yAxisTitle",null,locale));
	cart.setSubTitle("");
	cart.setxAxisTitle("");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(0);
	
	StringBuilder categories = new StringBuilder("");
	String lastCourse = "";
	for(int i=0; i<avgScoreHomework.size(); i++){
	    String currentData = "\'"+avgScoreHomework.get(i)[0].toString()+"\'";
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
	cart.setyAxisMaxValue(30);
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
	
	HashMap<String, List<Float>> studentScores = new HashMap<String, List<Float>>();
	for(int i=0; i<avgScoreHomework.size(); i++){
	    String student = avgScoreHomework.get(i)[1].toString();
	    Float value = Float.parseFloat(avgScoreHomework.get(i)[2].toString());
	    
	    List<Float> list = studentScores.get(student);
	    if(list==null){
		studentScores.put(student, new ArrayList<Float>());
	    }
	    studentScores.get(student).add(value);
	}
	
	Set<String> keySet = studentScores.keySet();
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
	    
	    List<Float> list = studentScores.get(key);
	    for(int i=0; i<list.size(); i++){
		float currentValue = list.get(i);
		if(i==0){
		    seriesContent.append(currentValue);			
		} else {
		    seriesContent.append(", "+currentValue);		
		}
	    }	    
	    seriesContent.append("],\n");
	    seriesContent.append(""+messageSource.getMessage("message.statistics.Professor_AvgScoreHomework_StackPrefix",null,locale)+": \'student\'\n");
	    seriesContent.append("}");
	    
	    k++;
	}
	
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}



