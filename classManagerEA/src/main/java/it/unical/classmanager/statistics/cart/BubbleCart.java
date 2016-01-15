package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class BubbleCart extends AbstractCart {    
    public BubbleCart(){
	super(BubbleCart.class.getSimpleName());
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
    //		cartScript.append("legend: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("enabled: false\n");
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
    //		cartScript.append("subtitle: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("text: \'"+subTitle+"\'\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("xAxis: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("gridLineWidth: 1,\n");
    //		    cartScript.append("title: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("text: \'"+xAxisTitle+"\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("labels: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("format: \'{");
    //			{
    //			    cartScript.append("value}");
    //			}
    //			cartScript.append(" gr\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("plotLines: [{");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("color: \'black\',\n");
    //			cartScript.append("dashStyle: \'dot\',\n");
    //			cartScript.append("width: 2,\n");
    //			cartScript.append("value: 65,\n");
    //			cartScript.append("label: {");
    //			{
    //			    cartScript.append("\n");
    //			    cartScript.append("rotation: 0,\n");
    //			    cartScript.append("y: 15,\n");
    //			    cartScript.append("style: {");
    //			    {
    //				cartScript.append("\n");
    //				cartScript.append("fontStyle: \'italic\'\n");
    //				cartScript.append("}");
    //			    }
    //			    cartScript.append(",\n");
    //			    cartScript.append("text: \'"+xPlotText+"\'\n"); // Safe fat intake 65g/day
    //			    cartScript.append("}");
    //			}
    //			cartScript.append(",\n");
    //			cartScript.append("zIndex: 3\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append("]\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("yAxis: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("startOnTick: false,\n");
    //		    cartScript.append("endOnTick: false,\n");
    //		    cartScript.append("title: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("text: \'"+yAxisTitle+"\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("labels: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("format: \'{");
    //			{
    //			    cartScript.append("value}");
    //			}
    //			cartScript.append(" gr\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append(",\n");
    //		    cartScript.append("maxPadding: 0.2,\n");
    //		    cartScript.append("plotLines: [{");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("color: \'black\',\n");
    //			cartScript.append("dashStyle: \'dot\',\n");
    //			cartScript.append("width: 2,\n");
    //			cartScript.append("value: 50,\n");
    //			cartScript.append("label: {");
    //			{
    //			    cartScript.append("\n");
    //			    cartScript.append("align: \'right\',\n");
    //			    cartScript.append("style: {");
    //			    {
    //				cartScript.append("\n");
    //				cartScript.append("fontStyle: \'italic\'\n");
    //				cartScript.append("}");
    //			    }
    //			    cartScript.append(",\n");
    //			    cartScript.append("text: \'"+yPlotText+"\',\n"); // Safe sugar intake 50g/day
    //			    cartScript.append("x: -10\n");
    //			    cartScript.append("}");
    //			}
    //			cartScript.append(",\n");
    //			cartScript.append("zIndex: 3\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append("]\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("tooltip: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("useHTML: true,\n");
    //		    cartScript.append("headerFormat: \'<table>\',\n");
    //		    cartScript.append("pointFormat: \'<tr><th colspan=\"2\"><h3>{");
    //		    {
    //			cartScript.append("point.country}");
    //		    }
    //		    cartScript.append("</h3></th></tr>\' +\n");
    //		    cartScript.append("\'<tr><th>"+xPointTooltip+":</th><td>{");
    //		    {
    //			cartScript.append("point.x}");
    //		    }
    //		    cartScript.append("g</td></tr>\' +\n");
    //		    cartScript.append("\'<tr><th>"+yPointTooltip+":</th><td>{");
    //		    {
    //			cartScript.append("point.y}");
    //		    }
    //		    cartScript.append("g</td></tr>\' +\n");
    //		    cartScript.append("\'<tr><th>"+zPointTooltip+":</th><td>{");
    //		    {
    //			cartScript.append("point.z}");
    //		    }
    //		    cartScript.append("%</td></tr>\',\n");
    //		    cartScript.append("footerFormat: \'</table>\',\n");
    //		    cartScript.append("followPointer: true\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("plotOptions: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("series: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("dataLabels: {");
    //			{
    //			    cartScript.append("\n");
    //			    cartScript.append("enabled: true,\n");
    //			    cartScript.append("format: \'{");
    //			    {
    //				cartScript.append("point.name}");
    //			    }
    //			    cartScript.append("\'\n");
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
    //		//		    cartScript.append("data: [\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 95, y: 95, z: 13.8, name: \'BE\', country: \'Belgium\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 86.5, y: 102.9, z: 14.7, name: \'DE\', country: \'Germany\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 80.8, y: 91.5, z: 15.8, name: \'FI\', country: \'Finland\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 80.4, y: 102.5, z: 12, name: \'NL\', country: \'Netherlands\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 80.3, y: 86.1, z: 11.8, name: \'SE\', country: \'Sweden\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 78.4, y: 70.1, z: 16.6, name: \'ES\', country: \'Spain\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 74.2, y: 68.5, z: 14.5, name: \'FR\', country: \'France\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 73.5, y: 83.1, z: 10, name: \'NO\', country: \'Norway\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 71, y: 93.2, z: 24.7, name: \'UK\', country: \'United Kingdom\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 69.2, y: 57.6, z: 10.4, name: \'IT\', country: \'Italy\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 68.6, y: 20, z: 16, name: \'RU\', country: \'Russia\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 65.5, y: 126.4, z: 35.3, name: \'US\', country: \'United States\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 65.4, y: 50.8, z: 28.5, name: \'HU\', country: \'Hungary\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 63.4, y: 51.8, z: 15.4, name: \'PT\', country: \'Portugal\' }");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append(" x: 64, y: 82.9, z: 31.3, name: \'NZ\', country: \'New Zealand\' }");
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
