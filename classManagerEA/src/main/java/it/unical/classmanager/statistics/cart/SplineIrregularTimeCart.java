package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class SplineIrregularTimeCart extends AbstractCart {
    
    public SplineIrregularTimeCart(){
	super();
	this.setName("SplineIrregularTimeCart");
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
		    cartScript.append("type: \'spline\'\n");
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
		    cartScript.append("type: \'datetime\',\n");
		    cartScript.append("dateTimeLabelFormats: {");
		    {
			//cartScript.append(" // don\'t display the dummy year\n");
			cartScript.append("month: \'%e. %b\',\n");
			cartScript.append("year: \'%b\'\n");
			cartScript.append("}");
		    }
		    cartScript.append(",\n");
		    cartScript.append("title: {");
		    {
			cartScript.append("\n");
			cartScript.append("text: \'"+xAxisTitle+"\'\n");
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
		    cartScript.append("min: "+yAxisMinValue+"\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("tooltip: {");
		{
		    cartScript.append("\n");
		    cartScript.append("headerFormat: \'<b>{");
		    {
			cartScript.append("series.name}");
		    }
		    cartScript.append("</b><br>\',\n");
		    cartScript.append("pointFormat: \'{");
		    {
			cartScript.append("point.x:%e. %b}");
		    }
		    cartScript.append(": {");
		    {
			cartScript.append("point.y:.2f}");
		    }
		    cartScript.append(" m\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("spline: {");
		    {
			cartScript.append("\n");
			cartScript.append("marker: {");
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
		cartScript.append(",\n");
		cartScript.append("series: [");
		cartScript.append(seriesContent);
		//		cartScript.append("{");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Winter 2012-2013\',\n");
		//		    cartScript.append("// Define the data points. All series have a dummy year\n");
		//		    cartScript.append("// of 1970/71 in order to be compared on the same x axis. Note\n");
		//		    cartScript.append("// that in JavaScript, months start at 0 for January, 1 for February etc.\n");
		//		    cartScript.append("data: [\n");
		//		    cartScript.append("[Date.UTC(1970, 9, 21), 0],\n");
		//		    cartScript.append("[Date.UTC(1970, 10, 4), 0.28],\n");
		//		    cartScript.append("[Date.UTC(1970, 10, 9), 0.25],\n");
		//		    cartScript.append("[Date.UTC(1970, 10, 27), 0.2],\n");
		//		    cartScript.append("[Date.UTC(1970, 11, 2), 0.28],\n");
		//		    cartScript.append("[Date.UTC(1970, 11, 26), 0.28],\n");
		//		    cartScript.append("[Date.UTC(1970, 11, 29), 0.47],\n");
		//		    cartScript.append("[Date.UTC(1971, 0, 11), 0.79],\n");
		//		    cartScript.append("[Date.UTC(1971, 0, 26), 0.72],\n");
		//		    cartScript.append("[Date.UTC(1971, 1, 3), 1.02],\n");
		//		    cartScript.append("[Date.UTC(1971, 1, 11), 1.12],\n");
		//		    cartScript.append("[Date.UTC(1971, 1, 25), 1.2],\n");
		//		    cartScript.append("[Date.UTC(1971, 2, 11), 1.18],\n");
		//		    cartScript.append("[Date.UTC(1971, 3, 11), 1.19],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 1), 1.85],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 5), 2.22],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 19), 1.15],\n");
		//		    cartScript.append("[Date.UTC(1971, 5, 3), 0]\n");
		//		    cartScript.append("]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Winter 2013-2014\',\n");
		//		    cartScript.append("data: [\n");
		//		    cartScript.append("[Date.UTC(1970, 9, 29), 0],\n");
		//		    cartScript.append("[Date.UTC(1970, 10, 9), 0.4],\n");
		//		    cartScript.append("[Date.UTC(1970, 11, 1), 0.25],\n");
		//		    cartScript.append("[Date.UTC(1971, 0, 1), 1.66],\n");
		//		    cartScript.append("[Date.UTC(1971, 0, 10), 1.8],\n");
		//		    cartScript.append("[Date.UTC(1971, 1, 19), 1.76],\n");
		//		    cartScript.append("[Date.UTC(1971, 2, 25), 2.62],\n");
		//		    cartScript.append("[Date.UTC(1971, 3, 19), 2.41],\n");
		//		    cartScript.append("[Date.UTC(1971, 3, 30), 2.05],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 14), 1.7],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 24), 1.1],\n");
		//		    cartScript.append("[Date.UTC(1971, 5, 10), 0]\n");
		//		    cartScript.append("]\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Winter 2014-2015\',\n");
		//		    cartScript.append("data: [\n");
		//		    cartScript.append("[Date.UTC(1970, 10, 25), 0],\n");
		//		    cartScript.append("[Date.UTC(1970, 11, 6), 0.25],\n");
		//		    cartScript.append("[Date.UTC(1970, 11, 20), 1.41],\n");
		//		    cartScript.append("[Date.UTC(1970, 11, 25), 1.64],\n");
		//		    cartScript.append("[Date.UTC(1971, 0, 4), 1.6],\n");
		//		    cartScript.append("[Date.UTC(1971, 0, 17), 2.55],\n");
		//		    cartScript.append("[Date.UTC(1971, 0, 24), 2.62],\n");
		//		    cartScript.append("[Date.UTC(1971, 1, 4), 2.5],\n");
		//		    cartScript.append("[Date.UTC(1971, 1, 14), 2.42],\n");
		//		    cartScript.append("[Date.UTC(1971, 2, 6), 2.74],\n");
		//		    cartScript.append("[Date.UTC(1971, 2, 14), 2.62],\n");
		//		    cartScript.append("[Date.UTC(1971, 2, 24), 2.6],\n");
		//		    cartScript.append("[Date.UTC(1971, 3, 2), 2.81],\n");
		//		    cartScript.append("[Date.UTC(1971, 3, 12), 2.63],\n");
		//		    cartScript.append("[Date.UTC(1971, 3, 28), 2.77],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 5), 2.68],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 10), 2.56],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 15), 2.39],\n");
		//		    cartScript.append("[Date.UTC(1971, 4, 20), 2.3],\n");
		//		    cartScript.append("[Date.UTC(1971, 5, 5), 2],\n");
		//		    cartScript.append("[Date.UTC(1971, 5, 10), 1.85],\n");
		//		    cartScript.append("[Date.UTC(1971, 5, 15), 1.49],\n");
		//		    cartScript.append("[Date.UTC(1971, 5, 23), 1.08]\n");
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
