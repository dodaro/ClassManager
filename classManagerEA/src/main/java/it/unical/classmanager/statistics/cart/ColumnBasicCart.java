package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class ColumnBasicCart extends AbstractCart {
    public ColumnBasicCart(){
	super();
	this.setName("ColumnBasicCart");
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
		    cartScript.append("type: \'column\'\n");
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
		cartScript.append("xAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("categories: [\n");
		    cartScript.append(xAxisCategories);
		    cartScript.append("],\n");
		    cartScript.append("crosshair: true\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("yAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("min: "+yAxisMinValue+",\n");
		    cartScript.append("title: {");
		    {
			cartScript.append("\n");
			cartScript.append("text: \'"+yAxisTitle+"\'\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("tooltip: {");
		{
		    cartScript.append("\n");
		    cartScript.append("headerFormat: \'<span style=\"font-size:10px\">{");
		    {
			cartScript.append("point.key}");
		    }
		    cartScript.append("</span><table>\',\n");
		    cartScript.append("pointFormat: \'<tr><td style=\"color:{");
		    {
			cartScript.append("series.color}");
		    }
		    cartScript.append(";padding:0\">");
		    {
			//cartScript.append("{series.name} :");
		    }
		    cartScript.append(" </td>\' +\n");
		    cartScript.append("\'<td style=\"padding:0\"><b>{");
		    {
			cartScript.append("point.y:.1f}");
		    }
		    cartScript.append("</b></td></tr>\',\n");
		    cartScript.append("footerFormat: \'</table>\',\n");
		    cartScript.append("shared: true,\n");
		    cartScript.append("useHTML: true\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("column: {");
		    {
			cartScript.append("\n");
			cartScript.append("pointPadding: 0.2,\n");
			cartScript.append("borderWidth: 0\n");
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
		//		    cartScript.append("name: \'Tokyo\',\n");
		//		    cartScript.append("data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'New York\',\n");
		//		    cartScript.append("data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'London\',\n");
		//		    cartScript.append("data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Berlin\',\n");
		//		    cartScript.append("data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]\n");
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
