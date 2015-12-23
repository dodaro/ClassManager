/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.student;

import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.AreaStackedCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Voti compiti per corso"
 */
public class Student_HomeworkScoreSeries extends AbstractQueryCart {
    
    public Student_HomeworkScoreSeries() {
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new AreaStackedCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	// Do Query!
	cart.setTitle("Voti compiti");
	cart.setSubTitle("Per ogni corso a cui partecipi");
	cart.setxAxisCategories("\'1750\', \'1800\', "
		+ "\'1850\', \'1900\', "
		+ "\'1950\', \'1999\', \'2050\'");
	cart.setyAxisTitle("y title");
	StringBuilder seriesContent = new StringBuilder("");
	seriesContent.append("{");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Asia\',\n");
	    seriesContent.append("data: [502, 635, 809, 947, 1402, 3634, 5268]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Africa\',\n");
	    seriesContent.append("data: [106, 107, 111, 133, 221, 767, 1766]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Europe\',\n");
	    seriesContent.append("data: [163, 203, 276, 408, 547, 729, 628]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'America\',\n");
	    seriesContent.append("data: [18, 31, 54, 156, 339, 818, 1201]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Oceania\',\n");
	    seriesContent.append("data: [2, 2, 2, 6, 13, 30, 46]\n");
	    seriesContent.append("}");
	}	
	cart.setSeriesContent(seriesContent);
	return cart;
    }
    
}
