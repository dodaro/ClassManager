/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.PieGradientCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Professori/numero corsi che sostengono"
 */
public class Professor_NumberCourses extends AbstractQueryCart {
    
    public Professor_NumberCourses() {
	super();
    }
    
    public Professor_NumberCourses(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new PieGradientCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	// Do query!
	cart.setTitle("Professori/numero corsi che sostengono");
	StringBuilder seriesContent = new StringBuilder("");
	seriesContent.append("{");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Brands\',\n");
	    seriesContent.append("data: [\n");
	    seriesContent.append("{");
	    {
		seriesContent.append(" name: \'Microsoft Internet Explorer\', y: 56.33 }");
	    }
	    seriesContent.append(",\n");
	    seriesContent.append("{");
	    {
		seriesContent.append("\n");
		seriesContent.append("name: \'Chrome\',\n");
		seriesContent.append("y: 24.03,\n");
		seriesContent.append("sliced: true,\n");
		seriesContent.append("selected: true\n");
		seriesContent.append("}");
	    }
	    seriesContent.append(",\n");
	    seriesContent.append("{");
	    {
		seriesContent.append(" name: \'Firefox\', y: 10.38 }");
	    }
	    seriesContent.append(",\n");
	    seriesContent.append("{");
	    {
		seriesContent.append(" name: \'Safari\', y: 4.77 }");
	    }
	    seriesContent.append(", {");
	    {
		seriesContent.append(" name: \'Opera\', y: 0.91 }");
	    }
	    seriesContent.append(",\n");
	    seriesContent.append("{");
	    {
		seriesContent.append(" name: \'Proprietary or Undetectable\', y: 0.2 }");
	    }
	    seriesContent.append("\n");
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}	
	cart.setSeriesContent(seriesContent);
	
	return cart;
    }
    
}	
