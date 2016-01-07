package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class PolarSpiderCart extends AbstractCart {
    
    public PolarSpiderCart(){
	super();
	this.setName("PolarSpiderCart");
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
		    cartScript.append("polar: true,\n");
		    cartScript.append("type: \'line\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("title: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'"+title+"\',\n");
		    cartScript.append("x: -80\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("pane: {");
		{
		    cartScript.append("\n");
		    cartScript.append("size: \'80%\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("xAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("categories: ["+xAxisCategories+"],\n"); //   \'Sales\', \'Marketing\', \'Development\', \'Customer Support\', \'Information Technology\', \'Administration\'
		    cartScript.append("tickmarkPlacement: \'on\',\n");
		    cartScript.append("lineWidth: 0\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("yAxis: {");
		{
		    cartScript.append("\n");
		    cartScript.append("gridLineInterpolation: \'polygon\',\n");
		    cartScript.append("lineWidth: 0,\n");
		    cartScript.append("min: "+yAxisMinValue+"\n"); // 0
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("tooltip: {");
		{
		    cartScript.append("\n");
		    cartScript.append("shared: true,\n");
		    cartScript.append("pointFormat: \'<span style=\"color:{");
		    {
			cartScript.append("series.color}");
		    }
		    cartScript.append("\">");
		    {
			//cartScript.append("{series.name}");
		    }
		    cartScript.append("<b>{"); // $
		    {
			cartScript.append("point.y:,.0f}");
		    }
		    cartScript.append("</b><br/>\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("legend: {");
		{
		    cartScript.append("\n");
		    cartScript.append("align: \'right\',\n");
		    cartScript.append("verticalAlign: \'top\',\n");
		    cartScript.append("y: 70,\n");
		    cartScript.append("layout: \'vertical\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("series: [");
		cartScript.append(seriesContent);
		//		cartScript.append("{");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Allocated Budget\',\n");
		//		    cartScript.append("data: [43000, 19000, 60000, 35000, 17000, 10000],\n");
		//		    cartScript.append("pointPlacement: \'on\'\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Actual Spending\',\n");
		//		    cartScript.append("data: [50000, 39000, 42000, 31000, 26000, 14000],\n");
		//		    cartScript.append("pointPlacement: \'on\'\n");
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
