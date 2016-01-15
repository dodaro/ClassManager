package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class ColumnStackingGrouping3DCart extends AbstractCart {
    public ColumnStackingGrouping3DCart(){
	super(ColumnStackingGrouping3DCart.class.getSimpleName());
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
    //		    cartScript.append("type: \'column\',\n");
    //		    cartScript.append("options3d: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("enabled: true,\n");
    //			cartScript.append("alpha: 15,\n");
    //			cartScript.append("beta: 15,\n");
    //			cartScript.append("viewDistance: 25,\n");
    //			cartScript.append("depth: 40\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("marginTop: 80,\n");
    //		    cartScript.append("marginRight: 40\n");
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
    //		    cartScript.append("allowDecimals: false,\n");
    //		    cartScript.append("min: "+yAxisMinValue+",\n");
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
    //		    cartScript.append("headerFormat: \'<b>{");
    //		    {
    //			cartScript.append("point.key}");
    //		    }
    //		    cartScript.append("</b><br>\',\n");
    //		    cartScript.append("pointFormat: \'<span style=\"color:{");
    //		    {
    //			cartScript.append("series.color}");
    //		    }
    //		    cartScript.append("\">\u25CF</span> {");
    //		    {
    //			cartScript.append("series.name}");
    //		    }
    //		    cartScript.append(": {");
    //		    {
    //			cartScript.append("point.y}");
    //		    }
    //		    cartScript.append(" / {");
    //		    {
    //			cartScript.append("point.stackTotal}");
    //		    }
    //		    cartScript.append("\'\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("plotOptions: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("column: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("stacking: \'normal\',\n");
    //			cartScript.append("depth: 40\n");
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
    //		//		    cartScript.append("data: [5, 3, 4, 7, 2],\n");
    //		//		    cartScript.append("stack: \'male\'\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		//		cartScript.append(", {");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("name: \'Joe\',\n");
    //		//		    cartScript.append("data: [3, 4, 4, 2, 5],\n");
    //		//		    cartScript.append("stack: \'male\'\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		//		cartScript.append(", {");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("name: \'Jane\',\n");
    //		//		    cartScript.append("data: [2, 5, 6, 2, 1],\n");
    //		//		    cartScript.append("stack: \'female\'\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		//		cartScript.append(", {");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("name: \'Janet\',\n");
    //		//		    cartScript.append("data: [3, 0, 4, 4, 3],\n");
    //		//		    cartScript.append("stack: \'female\'\n");
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
