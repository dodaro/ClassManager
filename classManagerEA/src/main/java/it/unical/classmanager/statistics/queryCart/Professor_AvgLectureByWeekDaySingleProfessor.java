/**
 * 
 */
package it.unical.classmanager.statistics.queryCart;

import java.util.List;

import it.unical.classmanager.model.dao.CartQueryDAO;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.PolarSpiderCart;

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
		
	cart.setTitle(messageSource.getMessage("message.statistics.Professor_AvgLectureByWeekDaySingleProfessor_Title",null,locale));
	cart.setSubTitle(messageSource.getMessage("message.statistics.Professor_AvgLectureByWeekDaySingleProfessor_SubTitle",null,locale));	
	cart.setxAxisCategories(messageSource.getMessage("message.statistics.Professor_AvgLectureByWeekDaySingleProfessor_xAxisCategories",null,locale));
	cart.setxAxisTitle("");
	cart.setyAxisTitle("");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(360);
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
	
	seriesContent.append("{name: \'"+messageSource.getMessage("message.statistics.Professor_AvgLectureByWeekDaySingleProfessor_SeriesContentName",null,locale)+"\', data: [");
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
	
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}
