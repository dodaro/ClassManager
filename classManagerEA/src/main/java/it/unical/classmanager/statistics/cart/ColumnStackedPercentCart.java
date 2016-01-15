package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class ColumnStackedPercentCart extends AbstractCart {
    public ColumnStackedPercentCart(){
	super(ColumnStackedPercentCart.class.getSimpleName());
    }
    
    //    @Override
    //    protected void buildCart() {
    //	cartScript = new StringBuilder("");
    //	cartScript.append("<script type=\"text/javascript\">\n");
    //	cartScript.append("$(document).ready(function() {\n");
    //	{
    //	    cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
    //	    {
    //		cartScript.append("chart: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("type: \'column\'\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("title: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("text: \'"+title+"\'\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("xAxis: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("categories: ["+xAxisCategories+"]\n"); // \'Apples\', \'Oranges\', \'Pears\', \'Grapes\', \'Bananas\'
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("yAxis: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("min: 0,\n");
    //		    cartScript.append("title: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("text: \'"+yAxisTitle+"\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append("\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("tooltip: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("pointFormat: \'<span style=\"color:{");
    //		    {
    //			cartScript.append("series.color}");
    //		    }
    //		    cartScript.append("\">{");
    //		    {
    //			cartScript.append("series.name}");
    //		    }
    //		    cartScript.append("</span>: <b>{");
    //		    {
    //			cartScript.append("point.y}");
    //		    }
    //		    cartScript.append("</b> ({");
    //		    {
    //			cartScript.append("point.percentage:.0f}");
    //		    }
    //		    cartScript.append("%)<br/>\',\n");
    //		    cartScript.append("shared: true\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("plotOptions: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("column: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("stacking: \'percent\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append("\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("series: [");
    //		cartScript.append(seriesContent);
    //		//		cartScript.append("{");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("name: \'John\',\n");
    //		//		    cartScript.append("data: [5, 3, 4, 7, 2]\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		//		cartScript.append(", {");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("name: \'Jane\',\n");
    //		//		    cartScript.append("data: [2, 2, 3, 2, 1]\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		//		cartScript.append(", {");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("name: \'Joe\',\n");
    //		//		    cartScript.append("data: [3, 4, 4, 2, 5]\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		cartScript.append("]\n");
    //		cartScript.append("}");
    //	    }
    //	    cartScript.append(");\n");
    //	    cartScript.append("}");
    //	}
    //	cartScript.append(");\n");
    //	cartScript.append("</script>\n");
    //    }
}
