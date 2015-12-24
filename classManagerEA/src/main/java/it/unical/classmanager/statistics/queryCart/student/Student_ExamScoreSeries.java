/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.student;

import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.SplineIrregularTimeCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Voti esami"
 */
public class Student_ExamScoreSeries extends AbstractQueryCart {
    
    public Student_ExamScoreSeries() {
	
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new SplineIrregularTimeCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	// Do query!
	cart.setTitle("Voti esami");
	cart.setSubTitle("La serie dei voti degli esami");
	cart.setxAxisTitle("Time");
	cart.setyAxisTitle("Score");
	cart.setyAxisMinValue(0);
	cart.setyAxisMaxValue(30);
	StringBuilder seriesContent = new StringBuilder("");
	seriesContent.append("{");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'1° anno\',\n");
	    seriesContent.append("data: [\n");
	    seriesContent.append("[Date.UTC(2012, 2, 5), 26],\n");
	    seriesContent.append("[Date.UTC(2012, 2, 10), 30],\n");
	    seriesContent.append("[Date.UTC(2012, 2, 15), 28],\n");
	    seriesContent.append("[Date.UTC(2012, 2, 20), 24]\n");
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'2° Anno\',\n");
	    seriesContent.append("data: [\n");
	    seriesContent.append("[Date.UTC(2013, 2, 2), 29],\n");
	    seriesContent.append("[Date.UTC(2013, 2, 7), 27],\n");
	    seriesContent.append("[Date.UTC(2013, 2, 19), 30],\n");
	    seriesContent.append("[Date.UTC(2013, 2, 24), 25]\n");
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'3° Anno\',\n");
	    seriesContent.append("data: [\n");
	    seriesContent.append("[Date.UTC(2014, 3, 1), 26],\n");
	    seriesContent.append("[Date.UTC(2014, 3, 14), 26],\n");
	    seriesContent.append("[Date.UTC(2014, 3, 25), 29],\n");
	    seriesContent.append("[Date.UTC(2014, 3, 28), 30]\n");
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	
	return cart;
    }
    
}
