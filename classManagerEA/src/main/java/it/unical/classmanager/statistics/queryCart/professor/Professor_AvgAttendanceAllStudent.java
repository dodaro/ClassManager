/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.professor;

import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.ColumnDrilldownCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Per ogni corso la media delle presenze di tutti gli studenti"
 */
public class Professor_AvgAttendanceAllStudent extends AbstractQueryCart {
    
    public Professor_AvgAttendanceAllStudent() {
	
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new ColumnDrilldownCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	cart.setTitle("Media delle presenze");
	cart.setSubTitle("Per ogni corso la media delle presenze di tutti gli studenti");
	cart.setxAxisTitle("");
	cart.setyAxisTitle("yAxisTitle");
	cart.setxAxisMinValue(0);
	cart.setxAxisMaxValue(0);
	cart.setxAxisCategories("");
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
	    seriesContent.append("name: \'Brands\',\n");
	    seriesContent.append("colorByPoint: true,\n");
	    seriesContent.append("data: [{");
	    {
		seriesContent.append("\n");
		seriesContent.append("name: \'Microsoft Internet Explorer\',\n");
		seriesContent.append("y: 56.33,\n");
		seriesContent.append("drilldown: \'Microsoft Internet Explorer\'\n");
		seriesContent.append("}");
	    }
	    seriesContent.append(", {");
	    {
		seriesContent.append("\n");
		seriesContent.append("name: \'Chrome\',\n");
		seriesContent.append("y: 24.03,\n");
		seriesContent.append("drilldown: \'Chrome\'\n");
		seriesContent.append("}");
	    }
	    seriesContent.append(", {");
	    {
		seriesContent.append("\n");
		seriesContent.append("name: \'Firefox\',\n");
		seriesContent.append("y: 10.38,\n");
		seriesContent.append("drilldown: \'Firefox\'\n");
		seriesContent.append("}");
	    }
	    seriesContent.append(", {");
	    {
		seriesContent.append("\n");
		seriesContent.append("name: \'Safari\',\n");
		seriesContent.append("y: 4.77,\n");
		seriesContent.append("drilldown: \'Safari\'\n");
		seriesContent.append("}");
	    }
	    seriesContent.append(", {");
	    {
		seriesContent.append("\n");
		seriesContent.append("name: \'Opera\',\n");
		seriesContent.append("y: 0.91,\n");
		seriesContent.append("drilldown: \'Opera\'\n");
		seriesContent.append("}");
	    }
	    seriesContent.append(", {");
	    {
		seriesContent.append("\n");
		seriesContent.append("name: \'Proprietary or Undetectable\',\n");
		seriesContent.append("y: 0.2,\n");
		seriesContent.append("drilldown: null\n");
		seriesContent.append("}");
	    }
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	StringBuilder drilldownContent = new StringBuilder("");
	drilldownContent.append("{");
	    {
		drilldownContent.append("\n");
		drilldownContent.append("name: \'Microsoft Internet Explorer\',\n");
		drilldownContent.append("id: \'Microsoft Internet Explorer\',\n");
		drilldownContent.append("data: [\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v11.0\',\n");
		drilldownContent.append("24.13\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v8.0\',\n");
		drilldownContent.append("17.2\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v9.0\',\n");
		drilldownContent.append("8.11\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v10.0\',\n");
		drilldownContent.append("5.33\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v6.0\',\n");
		drilldownContent.append("1.06\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v7.0\',\n");
		drilldownContent.append("0.5\n");
		drilldownContent.append("]\n");
		drilldownContent.append("]\n");
		drilldownContent.append("}");
	    }
	    drilldownContent.append(", {");
	    {
		drilldownContent.append("\n");
		drilldownContent.append("name: \'Chrome\',\n");
		drilldownContent.append("id: \'Chrome\',\n");
		drilldownContent.append("data: [\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v40.0\',\n");
		drilldownContent.append("5\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v41.0\',\n");
		drilldownContent.append("4.32\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v42.0\',\n");
		drilldownContent.append("3.68\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v39.0\',\n");
		drilldownContent.append("2.96\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v36.0\',\n");
		drilldownContent.append("2.53\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v43.0\',\n");
		drilldownContent.append("1.45\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v31.0\',\n");
		drilldownContent.append("1.24\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v35.0\',\n");
		drilldownContent.append("0.85\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v38.0\',\n");
		drilldownContent.append("0.6\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v32.0\',\n");
		drilldownContent.append("0.55\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v37.0\',\n");
		drilldownContent.append("0.38\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v33.0\',\n");
		drilldownContent.append("0.19\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v34.0\',\n");
		drilldownContent.append("0.14\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v30.0\',\n");
		drilldownContent.append("0.14\n");
		drilldownContent.append("]\n");
		drilldownContent.append("]\n");
		drilldownContent.append("}");
	    }
	    drilldownContent.append(", {");
	    {
		drilldownContent.append("\n");
		drilldownContent.append("name: \'Firefox\',\n");
		drilldownContent.append("id: \'Firefox\',\n");
		drilldownContent.append("data: [\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v35\',\n");
		drilldownContent.append("2.76\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v36\',\n");
		drilldownContent.append("2.32\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v37\',\n");
		drilldownContent.append("2.31\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v34\',\n");
		drilldownContent.append("1.27\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v38\',\n");
		drilldownContent.append("1.02\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v31\',\n");
		drilldownContent.append("0.33\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v33\',\n");
		drilldownContent.append("0.22\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v32\',\n");
		drilldownContent.append("0.15\n");
		drilldownContent.append("]\n");
		drilldownContent.append("]\n");
		drilldownContent.append("}");
	    }
	    drilldownContent.append(", {");
	    {
		drilldownContent.append("\n");
		drilldownContent.append("name: \'Safari\',\n");
		drilldownContent.append("id: \'Safari\',\n");
		drilldownContent.append("data: [\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v8.0\',\n");
		drilldownContent.append("2.56\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v7.1\',\n");
		drilldownContent.append("0.77\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v5.1\',\n");
		drilldownContent.append("0.42\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v5.0\',\n");
		drilldownContent.append("0.3\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v6.1\',\n");
		drilldownContent.append("0.29\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v7.0\',\n");
		drilldownContent.append("0.26\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v6.2\',\n");
		drilldownContent.append("0.17\n");
		drilldownContent.append("]\n");
		drilldownContent.append("]\n");
		drilldownContent.append("}");
	    }
	    drilldownContent.append(", {");
	    {
		drilldownContent.append("\n");
		drilldownContent.append("name: \'Opera\',\n");
		drilldownContent.append("id: \'Opera\',\n");
		drilldownContent.append("data: [\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v12.x\',\n");
		drilldownContent.append("0.34\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v28\',\n");
		drilldownContent.append("0.24\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v27\',\n");
		drilldownContent.append("0.17\n");
		drilldownContent.append("],\n");
		drilldownContent.append("[\n");
		drilldownContent.append("\'v29\',\n");
		drilldownContent.append("0.16\n");
		drilldownContent.append("]\n");
		drilldownContent.append("]\n");
		drilldownContent.append("}");
	    }
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}
