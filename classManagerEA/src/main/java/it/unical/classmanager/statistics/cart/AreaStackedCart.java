package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class AreaStackedCart extends AbstractCart {
    public AreaStackedCart(){
	super();
	this.setName("AreaStackedCart");
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
		    cartScript.append("categories: ["+xAxisCategories+"],\n"); // \'1750\', \'1800\', \'1850\', \'1900\', \'1950\', \'1999\', \'2050\'
		    cartScript.append("tickmarkPlacement: \'on\',\n");
		    cartScript.append("title: {");
		    {
			cartScript.append("\n");
			cartScript.append("enabled: false\n");
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
			cartScript.append("text: \'"+yAxisTitle+"\'\n");
			cartScript.append("}");
		    }
		    cartScript.append(",\n");
		    cartScript.append("labels: {");
		    {
			cartScript.append("\n");
			cartScript.append("formatter: function () {");
			{
			    cartScript.append("\n");
			    cartScript.append("return this.value / 1000;\n");
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
		    cartScript.append("shared: true,\n");
		    cartScript.append("valueSuffix: \' millions\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("area: {");
		    {
			cartScript.append("\n");
			cartScript.append("stacking: \'normal\',\n");
			cartScript.append("lineColor: \'#666666\',\n");
			cartScript.append("lineWidth: 1,\n");
			cartScript.append("marker: {");
			{
			    cartScript.append("\n");
			    cartScript.append("lineWidth: 1,\n");
			    cartScript.append("lineColor: \'#666666\'\n");
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
		//		    cartScript.append("name: \'Asia\',\n");
		//		    cartScript.append("data: [502, 635, 809, 947, 1402, 3634, 5268]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Africa\',\n");
		//		    cartScript.append("data: [106, 107, 111, 133, 221, 767, 1766]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Europe\',\n");
		//		    cartScript.append("data: [163, 203, 276, 408, 547, 729, 628]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'America\',\n");
		//		    cartScript.append("data: [18, 31, 54, 156, 339, 818, 1201]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Oceania\',\n");
		//		    cartScript.append("data: [2, 2, 2, 6, 13, 30, 46]\n");
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
