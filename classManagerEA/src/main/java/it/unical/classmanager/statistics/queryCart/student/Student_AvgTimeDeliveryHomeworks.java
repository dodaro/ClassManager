/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.student;

import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.PolarSpiderCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Media tempi consegna compiti per corso"
 */
public class Student_AvgTimeDeliveryHomeworks extends AbstractQueryCart {
    
    /**
     * 
     */
    public Student_AvgTimeDeliveryHomeworks() {
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
	//	Do query!
	
	cart.setTitle("Media tempi consegna compiti per corso");
	cart.setxAxisCategories("\'Sales\', \'Marketing\', "
		+ "\'Development\', \'Customer Support\', "
		+ "\'Information Technology\', \'Administration\'");
	cart.setyAxisMinValue(0);
	StringBuilder seriesContent = new StringBuilder("");
	seriesContent.append("{");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Allocated Budget\',\n");
	    seriesContent.append("data: [43000, 19000, 60000, 35000, 17000, 10000],\n");
	    seriesContent.append("pointPlacement: \'on\'\n");
	    seriesContent.append("}");
	}
	seriesContent.append(", {");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Actual Spending\',\n");
	    seriesContent.append("data: [50000, 39000, 42000, 31000, 26000, 14000],\n");
	    seriesContent.append("pointPlacement: \'on\'\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	
	return cart;
    }
    
}
