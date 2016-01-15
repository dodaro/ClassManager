package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class PieLegendCart extends AbstractCart {
    public PieLegendCart(){
	super(PieLegendCart.class.getSimpleName());
    }
    
    //    @Override
    //    protected void buildCart() {
    //	cartScript = new StringBuilder("");
    //	cartScript.append("<script type=\"text/javascript\">\n");
    //	cartScript.append("$(document).ready(function() {\n");
    //	{
    //	    cartScript.append("$(document).ready(function () {");
    //	    {
    //		cartScript.append("\n");
    //		cartScript.append("// Build the chart\n");
    //		cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
    //		{
    //		    cartScript.append("chart: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("plotBackgroundColor: null,\n");
    //			cartScript.append("plotBorderWidth: null,\n");
    //			cartScript.append("plotShadow: false,\n");
    //			cartScript.append("type: \'pie\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("title: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("text: \'"+title+"\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("tooltip: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("pointFormat: \'{");
    //			{
    //			    cartScript.append("series.name}");
    //			}
    //			cartScript.append(": <b>{");
    //			{
    //			    cartScript.append("point.percentage:.1f}");
    //			}
    //			cartScript.append("%</b>\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("plotOptions: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("pie: {");
    //			{
    //			    cartScript.append("\n");
    //			    cartScript.append("allowPointSelect: true,\n");
    //			    cartScript.append("cursor: \'pointer\',\n");
    //			    cartScript.append("dataLabels: {");
    //			    {
    //				cartScript.append("\n");
    //				cartScript.append("enabled: false\n");
    //				cartScript.append("}");
    //			    }
    //			    cartScript.append(",\n");
    //			    cartScript.append("showInLegend: true\n");
    //			    cartScript.append("}");
    //			}
    //			cartScript.append("\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //			cartScript.append("series: [");
    //			cartScript.append(seriesContent);
    //			//		cartScript.append("{");
    //			//		    {
    //			//			cartScript.append("\n");
    //			//			cartScript.append("name: \'Brands\',\n");
    //			//			cartScript.append("colorByPoint: true,\n");
    //			//			cartScript.append("data: [{");
    //			//			{
    //			//			    cartScript.append("\n");
    //			//			    cartScript.append("name: \'Microsoft Internet Explorer\',\n");
    //			//			    cartScript.append("y: 56.33\n");
    //			//			    cartScript.append("}");
    //			//			}
    //			//			cartScript.append(", {");
    //			//			{
    //			//			    cartScript.append("\n");
    //			//			    cartScript.append("name: \'Chrome\',\n");
    //			//			    cartScript.append("y: 24.03,\n");
    //			//			    cartScript.append("sliced: true,\n");
    //			//			    cartScript.append("selected: true\n");
    //			//			    cartScript.append("}");
    //			//			}
    //			//			cartScript.append(", {");
    //			//			{
    //			//			    cartScript.append("\n");
    //			//			    cartScript.append("name: \'Firefox\',\n");
    //			//			    cartScript.append("y: 10.38\n");
    //			//			    cartScript.append("}");
    //			//			}
    //			//			cartScript.append(", {");
    //			//			{
    //			//			    cartScript.append("\n");
    //			//			    cartScript.append("name: \'Safari\',\n");
    //			//			    cartScript.append("y: 4.77\n");
    //			//			    cartScript.append("}");
    //			//			}
    //			//			cartScript.append(", {");
    //			//			{
    //			//			    cartScript.append("\n");
    //			//			    cartScript.append("name: \'Opera\',\n");
    //			//			    cartScript.append("y: 0.91\n");
    //			//			    cartScript.append("}");
    //			//			}
    //			//			cartScript.append(", {");
    //			//			{
    //			//			    cartScript.append("\n");
    //			//			    cartScript.append("name: \'Proprietary or Undetectable\',\n");
    //			//			    cartScript.append("y: 0.2\n");
    //			//			    cartScript.append("}");
    //			//			}
    //			//			cartScript.append("]\n");
    //			//			cartScript.append("}");
    //			//		    }
    //		    cartScript.append("]\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(");\n");
    //		cartScript.append("}");
    //	    }
    //	    cartScript.append(");\n");
    //	    cartScript.append("}");
    //	}
    //	cartScript.append(");\n");
    //	cartScript.append("</script>\n");
    //    }
}
