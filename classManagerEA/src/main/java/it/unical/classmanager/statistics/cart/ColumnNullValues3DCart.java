package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class ColumnNullValues3DCart extends AbstractCart {
    public ColumnNullValues3DCart(){
	super();
	this.setName("ColumnNullValues3DCart");
    }
    
    @Override
    protected void buildCart() {
	cartScript = new StringBuilder("");
	cartScript.append("<script type=\"text/javascript\">\n");
	cartScript.append("$(document).ready(function() {\n");
	{
	    cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
	    {
		cartScript.append("chart: {");
		{
		    cartScript.append("\n");
		    cartScript.append("type: \'column\',\n");
		    cartScript.append("margin: 75,\n");
		    cartScript.append("options3d: {");
		    {
			cartScript.append("\n");
			cartScript.append("enabled: true,\n");
			cartScript.append("alpha: 10,\n");
			cartScript.append("beta: 25,\n");
			cartScript.append("depth: 70\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("title: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'"+title+"\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("subtitle: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'"+subTitle+"\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("column: {");
		    {
			cartScript.append("\n");
			cartScript.append("depth: 25\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("xAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("categories: Highcharts.getOptions().lang.shortMonths\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("yAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("title: {");
		    {
			cartScript.append("\n");
			cartScript.append("text: "+yAxisTitle+"\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("series: [");
		cartScript.append(seriesContent);
		//		cartScript.append("{");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Sales\',\n");
		//		    cartScript.append("data: [2, 3, null, 4, 0, 5, 1, 4, 6, 3]\n");
		//		    cartScript.append("}");
		//		}
		cartScript.append("]\n");
		cartScript.append("}");
	    }
	    cartScript.append(");\n");
	    cartScript.append("}");
	}
	cartScript.append(");\n");
	cartScript.append("</script>\n");
    }
}
