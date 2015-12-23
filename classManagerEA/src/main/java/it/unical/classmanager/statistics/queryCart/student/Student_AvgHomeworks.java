/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.student;

import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.PolarCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Media compiti per corso"
 */
public class Student_AvgHomeworks extends AbstractQueryCart {
    
    public Student_AvgHomeworks() {
	
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new PolarCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	//	Do query to DB and get the results!
	cart.setTitle("Media compiti per corso");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(360);
	cart.setyAxisMinValue(0);
	StringBuilder seriesContent = new StringBuilder("");
	seriesContent.append("{");
	{
	    seriesContent.append("\n");
	    seriesContent.append("type: \'column\',\n");
	    seriesContent.append("name: \'Column\',\n");
	    seriesContent.append("data: [8, 7, 6, 5, 4, 3, 2, 1],\n");
	    seriesContent.append("pointPlacement: \'between\'\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("type: \'line\',\n");
	    seriesContent.append("name: \'Line\',\n");
	    seriesContent.append("data: [1, 2, 3, 4, 5, 6, 7, 8]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("type: \'area\',\n");
	    seriesContent.append("name: \'Area\',\n");
	    seriesContent.append("data: [1, 8, 2, 7, 3, 6, 4, 5]\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	
	return cart;
    }
    
}
