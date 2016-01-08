package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class AreaBasicCart extends AbstractCart {
    public AreaBasicCart(){
	super();
	this.setName("AreaBasicCart");
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
		    cartScript.append("type: \'area\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("title: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'US and USSR nuclear stockpiles\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("subtitle: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'Source: <a href=\"http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf\">\' +\n");
		    cartScript.append("\'thebulletin.metapress.com</a>\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("xAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("allowDecimals: false,\n");
		    cartScript.append("labels: {");
		    {
			cartScript.append("\n");
			cartScript.append("formatter: function () {");
			{
			    cartScript.append("\n");
			    cartScript.append("return this.value; // clean, unformatted number for year\n");
			    cartScript.append("}");
			}
			cartScript.append("\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("yAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("title: {");
		    {
			cartScript.append("\n");
			cartScript.append("text: \'Nuclear weapon states\'\n");
			cartScript.append("}");
		    }
		    cartScript.append(",\n");
		    cartScript.append("labels: {");
		    {
			cartScript.append("\n");
			cartScript.append("formatter: function () {");
			{
			    cartScript.append("\n");
			    cartScript.append("return this.value / 1000 + \'k\';\n");
			    cartScript.append("}");
			}
			cartScript.append("\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("tooltip: {");
		{
		    cartScript.append("\n");
		    cartScript.append("pointFormat: \'{");
		    {
			cartScript.append("series.name}");
		    }
		    cartScript.append(" produced <b>{");
		    {
			cartScript.append("point.y:,.0f}");
		    }
		    cartScript.append("</b><br/>warheads in {");
		    {
			cartScript.append("point.x}");
		    }
		    cartScript.append("\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("area: {");
		    {
			cartScript.append("\n");
			cartScript.append("pointStart: 1940,\n");
			cartScript.append("marker: {");
			{
			    cartScript.append("\n");
			    cartScript.append("enabled: false,\n");
			    cartScript.append("symbol: \'circle\',\n");
			    cartScript.append("radius: 2,\n");
			    cartScript.append("states: {");
			    {
				cartScript.append("\n");
				cartScript.append("hover: {");
				{
				    cartScript.append("\n");
				    cartScript.append("enabled: true\n");
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
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("series: [{");
		{
		    cartScript.append("\n");
		    cartScript.append("name: \'USA\',\n");
		    cartScript.append("data: [null, null, null, null, null, 6, 11, 32, 110, 235, 369, 640,\n");
		    cartScript.append("1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468, 20434, 24126,\n");
		    cartScript.append("27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342, 26662,\n");
		    cartScript.append("26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605,\n");
		    cartScript.append("24304, 23464, 23708, 24099, 24357, 24237, 24401, 24344, 23586,\n");
		    cartScript.append("22380, 21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950,\n");
		    cartScript.append("10871, 10824, 10577, 10527, 10475, 10421, 10358, 10295, 10104]\n");
		    cartScript.append("}");
		}
		cartScript.append(", {");
		{
		    cartScript.append("\n");
		    cartScript.append("name: \'USSR/Russia\',\n");
		    cartScript.append("data: [null, null, null, null, null, null, null, null, null, null,\n");
		    cartScript.append("5, 25, 50, 120, 150, 200, 426, 660, 869, 1060, 1605, 2471, 3322,\n");
		    cartScript.append("4238, 5221, 6129, 7089, 8339, 9399, 10538, 11643, 13092, 14478,\n");
		    cartScript.append("15915, 17385, 19055, 21205, 23044, 25393, 27935, 30062, 32049,\n");
		    cartScript.append("33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000, 37000,\n");
		    cartScript.append("35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000,\n");
		    cartScript.append("21000, 20000, 19000, 18000, 18000, 17000, 16000]\n");
		    cartScript.append("}");
		}
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
