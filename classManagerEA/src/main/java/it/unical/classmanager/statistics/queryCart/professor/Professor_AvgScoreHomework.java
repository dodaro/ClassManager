/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

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
	cart.setTitle("Chi prende i voti migliori?");
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
	    seriesContent.append("data: [5, 3, 4, 7, 2],\n");
	    seriesContent.append("stack: \'male\'\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Joe\',\n");
	    seriesContent.append("data: [3, 4, 4, 2, 5],\n");
	    seriesContent.append("stack: \'male\'\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Jane\',\n");
	    seriesContent.append("data: [2, 5, 6, 2, 1],\n");
	    seriesContent.append("stack: \'female\'\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Janet\',\n");
	    seriesContent.append("data: [3, 0, 4, 4, 3],\n");
	    seriesContent.append("stack: \'female\'\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}



