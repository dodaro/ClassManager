/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

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
	cart.setTitle("Negli anni il numero medio di lezioni per ogni giorno della settimana");
	cart.setSubTitle("");
	cart.setxAxisTitle("");
	cart.setyAxisTitle("yAxisTitle");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(0);
	cart.setxAxisCategories("\'Apples\', \'Oranges\', \'Pears\', \'Grapes\', \'Bananas\'");
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
	seriesContent.append("{");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'John\',\n");
	    seriesContent.append("data: [5, 3, 4, 7, 2]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Jane\',\n");
	    seriesContent.append("data: [2, 2, 3, 2, 1]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Joe\',\n");
	    seriesContent.append("data: [3, 4, 4, 2, 5]\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}




