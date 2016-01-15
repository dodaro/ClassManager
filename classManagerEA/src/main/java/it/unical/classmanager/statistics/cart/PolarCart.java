package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class PolarCart extends AbstractCart {
    public PolarCart(){
	super(PolarCart.class.getSimpleName());
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
    //		    cartScript.append("polar: true\n");
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
    //		cartScript.append("pane: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("startAngle: 0,\n");
    //		    cartScript.append("endAngle: 360\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("xAxis: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("tickInterval: 45,\n");
    //		    cartScript.append("min: "+xAxisMinValue+",\n"); // 0
    //		    cartScript.append("max: "+xAxisMaxValue+""); // 360
    //		    //		    cartScript.append(",\n");
    //		    //		    cartScript.append("labels: {");
    //		    //		    {
    //		    //			cartScript.append("\n");
    //		    //			cartScript.append("formatter: function () {");
    //		    //			{
    //		    //			    cartScript.append("\n");
    //		    //			    cartScript.append("return this.value + \'\';\n"); // °
    //		    //			    cartScript.append("}");
    //		    //			}
    //		    //			cartScript.append("\n");
    //		    //			cartScript.append("}");
    //		    //		    }
    //		    cartScript.append("\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("yAxis: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("min: "+yAxisMinValue+",\n"); // 0
    //		    cartScript.append("max: "+yAxisMaxValue+""); // 360
    //		    
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("plotOptions: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("series: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("pointStart: 0,\n");
    //			cartScript.append("pointInterval: 45\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("column: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("pointPadding: 0,\n");
    //			cartScript.append("groupPadding: 0\n");
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
    //		//		    cartScript.append("type: \'column\',\n");
    //		//		    cartScript.append("name: \'Column\',\n");
    //		//		    cartScript.append("data: [8, 7, 6, 5, 4, 3, 2, 1],\n");
    //		//		    cartScript.append("pointPlacement: \'between\'\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		//		cartScript.append(", {");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("type: \'line\',\n");
    //		//		    cartScript.append("name: \'Line\',\n");
    //		//		    cartScript.append("data: [1, 2, 3, 4, 5, 6, 7, 8]\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		//		cartScript.append(", {");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("type: \'area\',\n");
    //		//		    cartScript.append("name: \'Area\',\n");
    //		//		    cartScript.append("data: [1, 8, 2, 7, 3, 6, 4, 5]\n");
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
