package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class ColumnStackedAndGroupedCart extends AbstractCart {
    public ColumnStackedAndGroupedCart(){
	super();
	this.setName("ColumnStackedAndGroupedCart");
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
		    cartScript.append("allowDecimals: false,\n");
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
		    cartScript.append("formatter: function () {");
		    {
			cartScript.append("\n");
			cartScript.append("return \'<b>\' + this.x + \'</b><br/>\' +\n");
			cartScript.append("this.series.name + \': \' + this.y + \'<br/>\' +\n");
			cartScript.append("\'Total: \' + this.point.stackTotal;\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("column: {");
		    {
			cartScript.append("\n");
			cartScript.append("stacking: \'normal\'\n");
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
		//		    cartScript.append("data: [5, 3, 4, 7, 2],\n");
		//		    cartScript.append("stack: \'male\'\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Joe\',\n");
		//		    cartScript.append("data: [3, 4, 4, 2, 5],\n");
		//		    cartScript.append("stack: \'male\'\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Jane\',\n");
		//		    cartScript.append("data: [2, 5, 6, 2, 1],\n");
		//		    cartScript.append("stack: \'female\'\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Janet\',\n");
		//		    cartScript.append("data: [3, 0, 4, 4, 3],\n");
		//		    cartScript.append("stack: \'female\'\n");
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
