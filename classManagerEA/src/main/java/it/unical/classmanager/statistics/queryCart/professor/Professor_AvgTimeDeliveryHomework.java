/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

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
	cart.setTitle("Chi consegna prima?");
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
