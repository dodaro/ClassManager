/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.ColumnBasicCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Per ogni corso il numero medio di presenze di ogni studente"
 */
public class Professor_AvgAttendanceSingleStudent extends AbstractQueryCart {
    
    public Professor_AvgAttendanceSingleStudent() {
	
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
	cart.setTitle("Media presenze");
	cart.setSubTitle("Per ogni corso il numero medio di presenze di ogni studente");
	cart.setxAxisTitle("");
	cart.setyAxisTitle("yAxisTitle");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(0);
	cart.setxAxisCategories("\'Jan\',\'Feb\',\'Mar\',\'Apr\',\'May\',\'Jun\',\'Jul\',\'Aug\',\'Sep\',\'Oct\',\'Nov\',\'Dec\'");
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
	    seriesContent.append("name: \'Tokyo\',\n");
	    seriesContent.append("data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'New York\',\n");
	    seriesContent.append("data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'London\',\n");
	    seriesContent.append("data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Berlin\',\n");
	    seriesContent.append("data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}


