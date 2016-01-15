package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class ColumnDrilldownCart extends AbstractCart {    
    public ColumnDrilldownCart(){
	super(ColumnDrilldownCart.class.getSimpleName());
    }
    
    //    @Override
    //    protected void buildCart() {
    //	cartScript = new StringBuilder("");
    //	cartScript.append("<script type=\"text/javascript\">\n");
    //	cartScript.append("$(document).ready(function() {\n");
    //	{
    //	    cartScript.append("// Create the chart\n");
    //	    cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
    //	    {
    //		cartScript.append("chart: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("type: \'column\'\n");
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
    //		    cartScript.append("type: \'category\'\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("yAxis: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("title: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("text: \'"+yAxisTitle+"\'\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append("\n");
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
    //		cartScript.append("plotOptions: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("series: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("borderWidth: 0,\n");
    //			cartScript.append("dataLabels: {");
    //			{
    //			    cartScript.append("\n");
    //			    cartScript.append("enabled: true,\n");
    //			    cartScript.append("format: \'{");
    //			    {
    //				cartScript.append("point.y:.1f}");
    //			    }
    //			    cartScript.append("%\'\n");
    //			    cartScript.append("}");
    //			}
    //			cartScript.append("\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append("\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("tooltip: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("headerFormat: \'<span style=\"font-size:11px\">{");
    //		    {
    //			cartScript.append("series.name}");
    //		    }
    //		    cartScript.append("</span><br>\',\n");
    //		    cartScript.append("pointFormat: \'<span style=\"color:{");
    //		    {
    //			cartScript.append("point.color}");
    //		    }
    //		    cartScript.append("\">{");
    //		    {
    //			cartScript.append("point.name}");
    //		    }
    //		    cartScript.append("</span>: <b>{");
    //		    {
    //			cartScript.append("point.y:.2f}");
    //		    }
    //		    cartScript.append("%</b> of total<br/>\'\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("series: [");
    //		cartScript.append(seriesContent);
    //		//		cartScript.append("{");
    //		//		{
    //		//		    cartScript.append("\n");
    //		//		    cartScript.append("name: \'Brands\',\n");
    //		//		    cartScript.append("colorByPoint: true,\n");
    //		//		    cartScript.append("data: [{");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("name: \'Microsoft Internet Explorer\',\n");
    //		//			cartScript.append("y: 56.33,\n");
    //		//			cartScript.append("drilldown: \'Microsoft Internet Explorer\'\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append(", {");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("name: \'Chrome\',\n");
    //		//			cartScript.append("y: 24.03,\n");
    //		//			cartScript.append("drilldown: \'Chrome\'\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append(", {");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("name: \'Firefox\',\n");
    //		//			cartScript.append("y: 10.38,\n");
    //		//			cartScript.append("drilldown: \'Firefox\'\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append(", {");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("name: \'Safari\',\n");
    //		//			cartScript.append("y: 4.77,\n");
    //		//			cartScript.append("drilldown: \'Safari\'\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append(", {");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("name: \'Opera\',\n");
    //		//			cartScript.append("y: 0.91,\n");
    //		//			cartScript.append("drilldown: \'Opera\'\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append(", {");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("name: \'Proprietary or Undetectable\',\n");
    //		//			cartScript.append("y: 0.2,\n");
    //		//			cartScript.append("drilldown: null\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append("]\n");
    //		//		    cartScript.append("}");
    //		//		}
    //		cartScript.append("],\n");
    //		cartScript.append("drilldown: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("series: [");
    //		    cartScript.append(drilldownContent);
    //		    //		cartScript.append("{");
    //		    //		    {
    //		    //			cartScript.append("\n");
    //		    //			cartScript.append("name: \'Microsoft Internet Explorer\',\n");
    //		    //			cartScript.append("id: \'Microsoft Internet Explorer\',\n");
    //		    //			cartScript.append("data: [\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v11.0\',\n");
    //		    //			cartScript.append("24.13\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v8.0\',\n");
    //		    //			cartScript.append("17.2\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v9.0\',\n");
    //		    //			cartScript.append("8.11\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v10.0\',\n");
    //		    //			cartScript.append("5.33\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v6.0\',\n");
    //		    //			cartScript.append("1.06\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v7.0\',\n");
    //		    //			cartScript.append("0.5\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("}");
    //		    //		    }
    //		    //		    cartScript.append(", {");
    //		    //		    {
    //		    //			cartScript.append("\n");
    //		    //			cartScript.append("name: \'Chrome\',\n");
    //		    //			cartScript.append("id: \'Chrome\',\n");
    //		    //			cartScript.append("data: [\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v40.0\',\n");
    //		    //			cartScript.append("5\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v41.0\',\n");
    //		    //			cartScript.append("4.32\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v42.0\',\n");
    //		    //			cartScript.append("3.68\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v39.0\',\n");
    //		    //			cartScript.append("2.96\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v36.0\',\n");
    //		    //			cartScript.append("2.53\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v43.0\',\n");
    //		    //			cartScript.append("1.45\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v31.0\',\n");
    //		    //			cartScript.append("1.24\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v35.0\',\n");
    //		    //			cartScript.append("0.85\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v38.0\',\n");
    //		    //			cartScript.append("0.6\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v32.0\',\n");
    //		    //			cartScript.append("0.55\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v37.0\',\n");
    //		    //			cartScript.append("0.38\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v33.0\',\n");
    //		    //			cartScript.append("0.19\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v34.0\',\n");
    //		    //			cartScript.append("0.14\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v30.0\',\n");
    //		    //			cartScript.append("0.14\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("}");
    //		    //		    }
    //		    //		    cartScript.append(", {");
    //		    //		    {
    //		    //			cartScript.append("\n");
    //		    //			cartScript.append("name: \'Firefox\',\n");
    //		    //			cartScript.append("id: \'Firefox\',\n");
    //		    //			cartScript.append("data: [\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v35\',\n");
    //		    //			cartScript.append("2.76\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v36\',\n");
    //		    //			cartScript.append("2.32\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v37\',\n");
    //		    //			cartScript.append("2.31\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v34\',\n");
    //		    //			cartScript.append("1.27\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v38\',\n");
    //		    //			cartScript.append("1.02\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v31\',\n");
    //		    //			cartScript.append("0.33\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v33\',\n");
    //		    //			cartScript.append("0.22\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v32\',\n");
    //		    //			cartScript.append("0.15\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("}");
    //		    //		    }
    //		    //		    cartScript.append(", {");
    //		    //		    {
    //		    //			cartScript.append("\n");
    //		    //			cartScript.append("name: \'Safari\',\n");
    //		    //			cartScript.append("id: \'Safari\',\n");
    //		    //			cartScript.append("data: [\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v8.0\',\n");
    //		    //			cartScript.append("2.56\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v7.1\',\n");
    //		    //			cartScript.append("0.77\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v5.1\',\n");
    //		    //			cartScript.append("0.42\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v5.0\',\n");
    //		    //			cartScript.append("0.3\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v6.1\',\n");
    //		    //			cartScript.append("0.29\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v7.0\',\n");
    //		    //			cartScript.append("0.26\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v6.2\',\n");
    //		    //			cartScript.append("0.17\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("}");
    //		    //		    }
    //		    //		    cartScript.append(", {");
    //		    //		    {
    //		    //			cartScript.append("\n");
    //		    //			cartScript.append("name: \'Opera\',\n");
    //		    //			cartScript.append("id: \'Opera\',\n");
    //		    //			cartScript.append("data: [\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v12.x\',\n");
    //		    //			cartScript.append("0.34\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v28\',\n");
    //		    //			cartScript.append("0.24\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v27\',\n");
    //		    //			cartScript.append("0.17\n");
    //		    //			cartScript.append("],\n");
    //		    //			cartScript.append("[\n");
    //		    //			cartScript.append("\'v29\',\n");
    //		    //			cartScript.append("0.16\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("]\n");
    //		    //			cartScript.append("}");
    //		    //		    }
    //		    cartScript.append("]\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append("\n");
    //		cartScript.append("}");
    //	    }
    //	    cartScript.append(");\n");
    //	    cartScript.append("}");
    //	}
    //	cartScript.append(");\n");
    //	cartScript.append("</script>\n");
    //    }
    
}
