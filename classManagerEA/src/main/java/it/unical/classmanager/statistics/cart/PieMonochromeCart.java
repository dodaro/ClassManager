package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class PieMonochromeCart extends AbstractCart {
    public PieMonochromeCart(){
	super(PieMonochromeCart.class.getSimpleName());
    }
    
    //    @Override
    //    protected void buildCart() {
    //	cartScript = new StringBuilder("");
    //	cartScript.append("<script type=\"text/javascript\">\n");
    //	cartScript.append("$(document).ready(function() {\n");
    //	{
    //	    //cartScript.append("// Make monochrome colors and set them as default for all pies\n");
    //	    cartScript.append("Highcharts.getOptions().plotOptions.pie.colors = (function () {");
    //	    {
    //		cartScript.append("\n");
    //		cartScript.append("var colors = [],\n");
    //		cartScript.append("base = Highcharts.getOptions().colors[0],\n");
    //		cartScript.append("i;\n");
    //		cartScript.append("for (i = 0; i < 10; i += 1) {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("// Start out with a darkened base color (negative brighten), and end\n");
    //		    cartScript.append("// up with a much brighter color\n");
    //		    cartScript.append("colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append("\n");
    //		cartScript.append("return colors;\n");
    //		cartScript.append("}");
    //	    }
    //	    cartScript.append("());\n");
    //	    //cartScript.append("// Build the chart\n");
    //	    cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
    //	    {
    //		cartScript.append("chart: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("plotBackgroundColor: null,\n");
    //		    cartScript.append("plotBorderWidth: null,\n");
    //		    cartScript.append("plotShadow: false,\n");
    //		    cartScript.append("type: \'pie\'\n");
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
    //		cartScript.append("tooltip: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("pointFormat: \'{");
    //		    {
    //			cartScript.append("series.name}");
    //		    }
    //		    cartScript.append(": <b>{");
    //		    {
    //			cartScript.append("point.percentage:.1f}");
    //		    }
    //		    cartScript.append("%</b>\'\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("plotOptions: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("pie: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("allowPointSelect: true,\n");
    //			cartScript.append("cursor: \'pointer\',\n");
    //			cartScript.append("dataLabels: {");
    //			{
    //			    cartScript.append("\n");
    //			    cartScript.append("enabled: true,\n");
    //			    cartScript.append("format: \'<b>{");
    //			    {
    //				cartScript.append("point.name}");
    //			    }
    //			    cartScript.append("</b>: {");
    //			    {
    //				cartScript.append("point.percentage:.1f}");
    //			    }
    //			    cartScript.append(" %\',\n");
    //			    cartScript.append("style: {");
    //			    {
    //				cartScript.append("\n");
    //				cartScript.append("color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || \'black\'\n");
    //				cartScript.append("}");
    //			    }
    //			    cartScript.append("\n");
    //			    cartScript.append("}");
    //			}
    //			cartScript.append("\n");
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
    //		//		    cartScript.append("name: \'Brands\',\n");
    //		//		    cartScript.append("data: [\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" name: \'Microsoft Internet Explorer\', y: 56.33 }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" name: \'Chrome\', y: 24.03 }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" name: \'Firefox\', y: 10.38 }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" name: \'Safari\', y: 4.77 }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" name: \'Opera\', y: 0.91 }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" name: \'Proprietary or Undetectable\', y: 0.2 }");
    //		//		    }
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("]\n");
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
