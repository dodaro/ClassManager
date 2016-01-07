package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class ColumnStackedCart extends AbstractCart {
    public ColumnStackedCart(){
	super();
	this.setName("ColumnStackedCart");
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
		cartScript.append("xAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("categories: ["+xAxisCategories+"]\n"); // \'Apples\', \'Oranges\', \'Pears\', \'Grapes\', \'Bananas\'
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
		    cartScript.append(",\n");
		    cartScript.append("stackLabels: {");
		    {
			cartScript.append("\n");
			cartScript.append("enabled: true,\n");
			cartScript.append("style: {");
			{
			    cartScript.append("\n");
			    cartScript.append("fontWeight: \'bold\',\n");
			    cartScript.append("color: (Highcharts.theme && Highcharts.theme.textColor) || \'gray\'\n");
			    cartScript.append("}");
			}
			cartScript.append("\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("legend: {");
		{
		    cartScript.append("\n");
		    cartScript.append("align: \'right\',\n");
		    cartScript.append("x: -30,\n");
		    cartScript.append("verticalAlign: \'top\',\n");
		    cartScript.append("y: 25,\n");
		    cartScript.append("floating: true,\n");
		    cartScript.append("backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || \'white\',\n");
		    cartScript.append("borderColor: \'#CCC\',\n");
		    cartScript.append("borderWidth: 1,\n");
		    cartScript.append("shadow: false\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("tooltip: {");
		{
		    cartScript.append("\n");
		    cartScript.append("headerFormat: \'<b>{");
		    {
			cartScript.append("point.x}");
		    }
		    cartScript.append("</b><br/>\',\n");
		    cartScript.append("pointFormat: \'{");
		    {
			cartScript.append("series.name}");
		    }
		    cartScript.append(": {");
		    {
			cartScript.append("point.y}");
		    }
		    //		    cartScript.append("<br/>Total: {");
		    //		    {
		    //			cartScript.append("point.stackTotal}");
		    //		    }
		    cartScript.append("\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("column: {");
		    {
			cartScript.append("\n");
			cartScript.append("stacking: \'normal\',\n");
			cartScript.append("dataLabels: {");
			{
			    cartScript.append("\n");
			    cartScript.append("enabled: true,\n");
			    cartScript.append("color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || \'white\',\n");
			    cartScript.append("style: {");
			    {
				cartScript.append("\n");
				cartScript.append("textShadow: \'0 0 3px black\'\n");
				cartScript.append("}");
			    }
			    cartScript.append("\n");
			    cartScript.append("}");
			}
			cartScript.append("\n");
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
		//		    cartScript.append("name: \'John\',\n");
		//		    cartScript.append("data: [5, 3, 4, 7, 2]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Jane\',\n");
		//		    cartScript.append("data: [2, 2, 3, 2, 1]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Joe\',\n");
		//		    cartScript.append("data: [3, 4, 4, 2, 5]\n");
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
