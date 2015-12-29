package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class PieSemiCircleCart extends AbstractCart {
    public PieSemiCircleCart(){
	super();
	this.setName("PieSemiCircleCart");
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
		    cartScript.append("plotBackgroundColor: null,\n");
		    cartScript.append("plotBorderWidth: 0,\n");
		    cartScript.append("plotShadow: false\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("title: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'"+title+"\',\n");
		    cartScript.append("align: \'center\',\n");
		    cartScript.append("verticalAlign: \'middle\',\n");
		    cartScript.append("y: 40\n");
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
			cartScript.append("point.percentage:.1f}");
		    }
		    cartScript.append("%</b>\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("pie: {");
		    {
			cartScript.append("\n");
			cartScript.append("dataLabels: {");
			{
			    cartScript.append("\n");
			    cartScript.append("enabled: true,\n");
			    cartScript.append("distance: -50,\n");
			    cartScript.append("style: {");
			    {
				cartScript.append("\n");
				cartScript.append("fontWeight: \'bold\',\n");
				cartScript.append("color: \'white\',\n");
				cartScript.append("textShadow: \'0px 1px 2px black\'\n");
				cartScript.append("}");
			    }
			    cartScript.append("\n");
			    cartScript.append("}");
			}
			cartScript.append(",\n");
			cartScript.append("startAngle: -90,\n");
			cartScript.append("endAngle: 90,\n");
			cartScript.append("center: [\'50%\', \'75%\']\n");
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
		//		    cartScript.append("type: \'pie\',\n");
		//		    cartScript.append("name: \'Browser share\',\n");
		//		    cartScript.append("innerSize: \'50%\',\n");
		//		    cartScript.append("data: [\n");
		//		    cartScript.append("[\'Firefox\',   10.38],\n");
		//		    cartScript.append("[\'IE\',       56.33],\n");
		//		    cartScript.append("[\'Chrome\', 24.03],\n");
		//		    cartScript.append("[\'Safari\',    4.77],\n");
		//		    cartScript.append("[\'Opera\',     0.91],\n");
		//		    cartScript.append("{");
		//		    {
		//			cartScript.append("\n");
		//			cartScript.append("name: \'Proprietary or Undetectable\',\n");
		//			cartScript.append("y: 0.2,\n");
		//			cartScript.append("dataLabels: {");
		//			{
		//			    cartScript.append("\n");
		//			    cartScript.append("enabled: false\n");
		//			    cartScript.append("}");
		//			}
		//			cartScript.append("\n");
		//			cartScript.append("}");
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
