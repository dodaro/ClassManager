package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class PieGradientCart extends AbstractCart {
    public PieGradientCart(){
	super();
	this.setName("PieGradientCart");
    }
    
    @Override
    protected void buildCart() {
	cartScript = new StringBuilder("");
	cartScript.append("<script type=\"text/javascript\">\n");
	cartScript.append("$(document).ready(function() {\n");
	{
	    cartScript.append("// Radialize the colors\n");
	    cartScript.append("Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {");
	    {
		cartScript.append("\n");
		cartScript.append("return {");
		{
		    cartScript.append("\n");
		    cartScript.append("radialGradient: {");
		    {
			cartScript.append("\n");
			cartScript.append("cx: 0.5,\n");
			cartScript.append("cy: 0.3,\n");
			cartScript.append("r: 0.7\n");
			cartScript.append("}");
		    }
		    cartScript.append(",\n");
		    cartScript.append("stops: [\n");
		    cartScript.append("[0, color],\n");
		    cartScript.append("[1, Highcharts.Color(color).brighten(-0.3).get(\'rgb\')] // darken\n");
		    cartScript.append("]\n");
		    cartScript.append("}");
		}
		cartScript.append(";\n");
		cartScript.append("}");
	    }
	    cartScript.append(");\n");
	    cartScript.append("// Build the chart\n");
	    cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
	    {
		cartScript.append("chart: {");
		{
		    cartScript.append("\n");
		    cartScript.append("plotBackgroundColor: null,\n");
		    cartScript.append("plotBorderWidth: null,\n");
		    cartScript.append("plotShadow: false,\n");
		    cartScript.append("type: \'pie\'\n");
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
		cartScript.append("tooltip: {");
		{
		    cartScript.append("\n");
		    cartScript.append("pointFormat: \'{");
		    {
			cartScript.append("series.name}");
		    }
		    cartScript.append(": <b>{");
		    {
			cartScript.append("point.y:.1f}"); // point.percentage
		    }
		    cartScript.append("</b>\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("pie: {");
		    {
			cartScript.append("\n");
			cartScript.append("allowPointSelect: true,\n");
			cartScript.append("cursor: \'pointer\',\n");
			cartScript.append("dataLabels: {");
			{
			    cartScript.append("\n");
			    cartScript.append("enabled: true,\n");
			    cartScript.append("format: \'<b>{");
			    {
				cartScript.append("point.name}");
			    }
			    cartScript.append("</b>: {");
			    {
				cartScript.append("point.y:.1f}");  // point.percentage
			    }
			    //cartScript.append(" %\n");
			    cartScript.append("\', style: {");
			    {
				cartScript.append("\n");
				cartScript.append("color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || \'black\'\n");
				cartScript.append("}");
			    }
			    cartScript.append(",\n");
			    cartScript.append("connectorColor: \'silver\'\n");
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
		//		    cartScript.append("name: \'Brands\',\n");
		//		    cartScript.append("data: [\n");
		//		    cartScript.append("{");
		//		    {
		//			cartScript.append(" name: \'Microsoft Internet Explorer\', y: 56.33 }");
		//		    }
		//		    cartScript.append(",\n");
		//		    cartScript.append("{");
		//		    {
		//			cartScript.append("\n");
		//			cartScript.append("name: \'Chrome\',\n");
		//			cartScript.append("y: 24.03,\n");
		//			cartScript.append("sliced: true,\n");
		//			cartScript.append("selected: true\n");
		//			cartScript.append("}");
		//		    }
		//		    cartScript.append(",\n");
		//		    cartScript.append("{");
		//		    {
		//			cartScript.append(" name: \'Firefox\', y: 10.38 }");
		//		    }
		//		    cartScript.append(",\n");
		//		    cartScript.append("{");
		//		    {
		//			cartScript.append(" name: \'Safari\', y: 4.77 }");
		//		    }
		//		    cartScript.append(", {");
		//		    {
		//			cartScript.append(" name: \'Opera\', y: 0.91 }");
		//		    }
		//		    cartScript.append(",\n");
		//		    cartScript.append("{");
		//		    {
		//			cartScript.append(" name: \'Proprietary or Undetectable\', y: 0.2 }");
		//		    }
		//		    cartScript.append("\n");
		//		    cartScript.append("]\n");
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
