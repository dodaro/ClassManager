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
	cart.setxAxisTitle("x Axis");
	cart.setyAxisTitle("y Axis");
	cart.setyAxisMinValue(0);
	StringBuilder seriesContent = new StringBuilder("");
	seriesContent.append("{");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Winter 2012-2013\',\n");
	    seriesContent.append("// Define the data points. All series have a dummy year\n");
	    seriesContent.append("// of 1970/71 in order to be compared on the same x axis. Note\n");
	    seriesContent.append("// that in JavaScript, months start at 0 for January, 1 for February etc.\n");
	    seriesContent.append("data: [\n");
	    seriesContent.append("[Date.UTC(1970, 9, 21), 0],\n");
	    seriesContent.append("[Date.UTC(1970, 10, 4), 0.28],\n");
	    seriesContent.append("[Date.UTC(1970, 10, 9), 0.25],\n");
	    seriesContent.append("[Date.UTC(1970, 10, 27), 0.2],\n");
	    seriesContent.append("[Date.UTC(1970, 11, 2), 0.28],\n");
	    seriesContent.append("[Date.UTC(1970, 11, 26), 0.28],\n");
	    seriesContent.append("[Date.UTC(1970, 11, 29), 0.47],\n");
	    seriesContent.append("[Date.UTC(1971, 0, 11), 0.79],\n");
	    seriesContent.append("[Date.UTC(1971, 0, 26), 0.72],\n");
	    seriesContent.append("[Date.UTC(1971, 1, 3), 1.02],\n");
	    seriesContent.append("[Date.UTC(1971, 1, 11), 1.12],\n");
	    seriesContent.append("[Date.UTC(1971, 1, 25), 1.2],\n");
	    seriesContent.append("[Date.UTC(1971, 2, 11), 1.18],\n");
	    seriesContent.append("[Date.UTC(1971, 3, 11), 1.19],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 1), 1.85],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 5), 2.22],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 19), 1.15],\n");
	    seriesContent.append("[Date.UTC(1971, 5, 3), 0]\n");
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Winter 2013-2014\',\n");
	    seriesContent.append("data: [\n");
	    seriesContent.append("[Date.UTC(1970, 9, 29), 0],\n");
	    seriesContent.append("[Date.UTC(1970, 10, 9), 0.4],\n");
	    seriesContent.append("[Date.UTC(1970, 11, 1), 0.25],\n");
	    seriesContent.append("[Date.UTC(1971, 0, 1), 1.66],\n");
	    seriesContent.append("[Date.UTC(1971, 0, 10), 1.8],\n");
	    seriesContent.append("[Date.UTC(1971, 1, 19), 1.76],\n");
	    seriesContent.append("[Date.UTC(1971, 2, 25), 2.62],\n");
	    seriesContent.append("[Date.UTC(1971, 3, 19), 2.41],\n");
	    seriesContent.append("[Date.UTC(1971, 3, 30), 2.05],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 14), 1.7],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 24), 1.1],\n");
	    seriesContent.append("[Date.UTC(1971, 5, 10), 0]\n");
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Winter 2014-2015\',\n");
	    seriesContent.append("data: [\n");
	    seriesContent.append("[Date.UTC(1970, 10, 25), 0],\n");
	    seriesContent.append("[Date.UTC(1970, 11, 6), 0.25],\n");
	    seriesContent.append("[Date.UTC(1970, 11, 20), 1.41],\n");
	    seriesContent.append("[Date.UTC(1970, 11, 25), 1.64],\n");
	    seriesContent.append("[Date.UTC(1971, 0, 4), 1.6],\n");
	    seriesContent.append("[Date.UTC(1971, 0, 17), 2.55],\n");
	    seriesContent.append("[Date.UTC(1971, 0, 24), 2.62],\n");
	    seriesContent.append("[Date.UTC(1971, 1, 4), 2.5],\n");
	    seriesContent.append("[Date.UTC(1971, 1, 14), 2.42],\n");
	    seriesContent.append("[Date.UTC(1971, 2, 6), 2.74],\n");
	    seriesContent.append("[Date.UTC(1971, 2, 14), 2.62],\n");
	    seriesContent.append("[Date.UTC(1971, 2, 24), 2.6],\n");
	    seriesContent.append("[Date.UTC(1971, 3, 2), 2.81],\n");
	    seriesContent.append("[Date.UTC(1971, 3, 12), 2.63],\n");
	    seriesContent.append("[Date.UTC(1971, 3, 28), 2.77],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 5), 2.68],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 10), 2.56],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 15), 2.39],\n");
	    seriesContent.append("[Date.UTC(1971, 4, 20), 2.3],\n");
	    seriesContent.append("[Date.UTC(1971, 5, 5), 2],\n");
	    seriesContent.append("[Date.UTC(1971, 5, 10), 1.85],\n");
	    seriesContent.append("[Date.UTC(1971, 5, 15), 1.49],\n");
	    seriesContent.append("[Date.UTC(1971, 5, 23), 1.08]\n");
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	
	return cart;
    }
    
}
