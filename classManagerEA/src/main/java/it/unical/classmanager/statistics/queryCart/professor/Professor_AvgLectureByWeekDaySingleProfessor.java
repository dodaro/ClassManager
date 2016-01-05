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
import it.unical.classmanager.statistics.cart.PolarSpiderCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Negli anni il numero medio di lezioni per ogni giorno della settimana"
 */
public class Professor_AvgLectureByWeekDaySingleProfessor extends AbstractQueryCart {
    
    public Professor_AvgLectureByWeekDaySingleProfessor() {
	super();
    }
    
    public Professor_AvgLectureByWeekDaySingleProfessor(User user){
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
	// Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Object[]> avg = cartQueryDAO.getAvgLectureByWeekDaySingleProfessor((Professor)this.getUser());

	/*
	 * Monday, NumberLecture
	 * Tuesday, NumberLecture
	 * Wednesday, NumberLecture
	 * Thursday, NumberLecture
	 * Friday, NumberLecture
	 * Saturday, NumberLecture
	 * Sunday, NumberLecture
	 * 
	 */
	
	cart.setTitle("Media numero lezioni per settimana");
	cart.setSubTitle("Negli anni il numero medio di lezioni per ogni giorno della settimana");
	cart.setxAxisTitle("");
	cart.setyAxisTitle("");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(360);	
	cart.setxAxisCategories("\'Monday\', \'Tuesday\', \'Wednesday\', \'Thursday\'"
		+ ", \'Friday\', \'Saturday\', \'Sunday\'");
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
		
	seriesContent.append("{name: \'Week\', data: [");
	for(int i=0; i<avg.size(); i++){
	    float avgValue = Float.parseFloat(avg.get(i)[1].toString());
	    if(i==0){
		seriesContent.append(avgValue);
	    } else {
		seriesContent.append(", "+avgValue);		
	    }
	}
	seriesContent.append("], pointPlacement: \'on\'}");
	cart.setSeriesContent(seriesContent);
	
	
	//	seriesContent.append("{");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("type: \'column\',\n");
	//	    seriesContent.append("name: \'Column\',\n");
	//	    seriesContent.append("data: [8, 7, 6, 5, 4, 3, 2, 1],\n");
	//	    seriesContent.append("pointPlacement: \'between\'\n");
	//	    seriesContent.append("}");
	//	}
	
	//	seriesContent.append("{");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("type: \'column\',\n");
	//	    seriesContent.append("name: \'Column\',\n");
	//	    seriesContent.append("data: [8, 7, 6, 5, 4, 3, 2, 1],\n");
	//	    seriesContent.append("pointPlacement: \'between\'\n");
	//	    seriesContent.append("}");
	//	}
	//	seriesContent.append(", {");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("type: \'line\',\n");
	//	    seriesContent.append("name: \'Line\',\n");
	//	    seriesContent.append("data: [1, 2, 3, 4, 5, 6, 7, 8]\n");
	//	    seriesContent.append("}");
	//	}
	//	seriesContent.append(", {");
	//	{
	//	    seriesContent.append("\n");
	//	    seriesContent.append("type: \'area\',\n");
	//	    seriesContent.append("name: \'Area\',\n");
	//	    seriesContent.append("data: [1, 8, 2, 7, 3, 6, 4, 5]\n");
	//	    seriesContent.append("}");
	//	}
	
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}
