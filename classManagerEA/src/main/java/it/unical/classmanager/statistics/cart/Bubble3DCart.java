package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class Bubble3DCart extends AbstractCart {
    public Bubble3DCart(){
	super(Bubble3DCart.class.getSimpleName());
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
    //		    cartScript.append("type: \'bubble\',\n");
    //		    cartScript.append("plotBorderWidth: 1,\n");
    //		    cartScript.append("zoomType: \'xy\'\n");
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
    //		    cartScript.append("gridLineWidth: 1\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("yAxis: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("startOnTick: false,\n");
    //		    cartScript.append("endOnTick: false\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("series: [");
    //		cartScript.append(seriesContent);
    //		//		cartScript.append("{");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("data: [\n");
    //		//		    cartScript.append("[9, 81, 63],\n");
    //		//		    cartScript.append("[98, 5, 89],\n");
    //		//		    cartScript.append("[51, 50, 73],\n");
    //		//		    cartScript.append("[41, 22, 14],\n");
    //		//		    cartScript.append("[58, 24, 20],\n");
    //		//		    cartScript.append("[78, 37, 34],\n");
    //		//		    cartScript.append("[55, 56, 53],\n");
    //		//		    cartScript.append("[18, 45, 70],\n");
    //		//		    cartScript.append("[42, 44, 28],\n");
    //		//		    cartScript.append("[3, 52, 59],\n");
    //		//		    cartScript.append("[31, 18, 97],\n");
    //		//		    cartScript.append("[79, 91, 63],\n");
    //		//		    cartScript.append("[93, 23, 23],\n");
    //		//		    cartScript.append("[44, 83, 22]\n");
    //		//		    cartScript.append("],\n");
    //		//		    cartScript.append("marker: {");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("fillColor: {");
    //		//			{
    //		//			    cartScript.append("\n");
    //		//			    cartScript.append("radialGradient: {");
    //		//			    {
    //		//				cartScript.append(" cx: 0.4, cy: 0.3, r: 0.7 }");
    //		//			    }
    //		//			    cartScript.append(",\n");
    //		//			    cartScript.append("stops: [\n");
    //		//			    cartScript.append("[0, \'rgba(255,255,255,0.5)\'],\n");
    //		//			    cartScript.append("[1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0.5).get(\'rgba\')]\n");
    //		//			    cartScript.append("]\n");
    //		//			    cartScript.append("}");
    //		//			}
    //		//			cartScript.append("\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		//		cartScript.append(", {");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("data: [\n");
    //		//		    cartScript.append("[42, 38, 20],\n");
    //		//		    cartScript.append("[6, 18, 1],\n");
    //		//		    cartScript.append("[1, 93, 55],\n");
    //		//		    cartScript.append("[57, 2, 90],\n");
    //		//		    cartScript.append("[80, 76, 22],\n");
    //		//		    cartScript.append("[11, 74, 96],\n");
    //		//		    cartScript.append("[88, 56, 10],\n");
    //		//		    cartScript.append("[30, 47, 49],\n");
    //		//		    cartScript.append("[57, 62, 98],\n");
    //		//		    cartScript.append("[4, 16, 16],\n");
    //		//		    cartScript.append("[46, 10, 11],\n");
    //		//		    cartScript.append("[22, 87, 89],\n");
    //		//		    cartScript.append("[57, 91, 82],\n");
    //		//		    cartScript.append("[45, 15, 98]\n");
    //		//		    cartScript.append("],\n");
    //		//		    cartScript.append("marker: {");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("fillColor: {");
    //		//			{
    //		//			    cartScript.append("\n");
    //		//			    cartScript.append("radialGradient: {");
    //		//			    {
    //		//				cartScript.append(" cx: 0.4, cy: 0.3, r: 0.7 }");
    //		//			    }
    //		//			    cartScript.append(",\n");
    //		//			    cartScript.append("stops: [\n");
    //		//			    cartScript.append("[0, \'rgba(255,255,255,0.5)\'],\n");
    //		//			    cartScript.append("[1, Highcharts.Color(Highcharts.getOptions().colors[1]).setOpacity(0.5).get(\'rgba\')]\n");
    //		//			    cartScript.append("]\n");
    //		//			    cartScript.append("}");
    //		//			}
    //		//			cartScript.append("\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append("\n");
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
