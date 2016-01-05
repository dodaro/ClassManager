package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class LineBasicCart extends AbstractCart {
    public LineBasicCart(){
	super();
	this.setName("LineBasicCart");
    }
    
    @Override
    protected void buildCart() {
	cartScript = new StringBuilder("");
	cartScript.append("<script type=\"text/javascript\">\n");
	cartScript.append("$(document).ready(function() {\n");
	{
	    cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
	    {
		cartScript.append("title: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'"+title+"\',\n");
		    cartScript.append("x: -20 //center\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("subtitle: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'"+subTitle+"\',\n");
		    cartScript.append("x: -20\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("xAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("categories: ["+xAxisCategories+"]\n"); // \'Jan\', \'Feb\', \'Mar\', \'Apr\', \'May\', \'Jun\',\'Jul\', \'Aug\', \'Sep\', \'Oct\', \'Nov\', \'Dec\'
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("yAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("title: {");
		    {
			cartScript.append("\n");
			cartScript.append("text: \'"+yAxisTitle+"\'\n");
			cartScript.append("}");
		    }
		    cartScript.append(",\n");
		    cartScript.append("min: "+yAxisMinValue+"\n");
		    cartScript.append(",\n");
		    cartScript.append("max: "+yAxisMaxValue+"\n");
		    cartScript.append(",\n");
		    cartScript.append("plotLines: [{");
		    {
			cartScript.append("\n");
			cartScript.append("value: 0,\n");
			cartScript.append("width: 1,\n");
			cartScript.append("color: \'#808080\'\n");
			cartScript.append("}");
		    }
		    cartScript.append("]\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("tooltip: {");
		{
		    cartScript.append("\n");
		    cartScript.append("valueSuffix: \'"+toolTipValueSuffix+"\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("legend: {");
		{
		    cartScript.append("\n");
		    cartScript.append("layout: \'vertical\',\n");
		    cartScript.append("align: \'right\',\n");
		    cartScript.append("verticalAlign: \'middle\',\n");
		    cartScript.append("borderWidth: 0\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("series: [");
		cartScript.append(seriesContent);
		//		cartScript.append("{");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Tokyo\',\n");
		//		    cartScript.append("data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'New York\',\n");
		//		    cartScript.append("data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Berlin\',\n");
		//		    cartScript.append("data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'London\',\n");
		//		    cartScript.append("data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]\n");
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
