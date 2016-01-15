package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class Pie3DCart extends AbstractCart {
    public Pie3DCart(){
	super(Pie3DCart.class.getSimpleName());
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
    //		    cartScript.append("type: \'pie\',\n");
    //		    cartScript.append("options3d: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("enabled: true,\n");
    //			cartScript.append("alpha: 45,\n");
    //			cartScript.append("beta: 0\n");
    //			cartScript.append("}");
    //		    }
    //		    cartScript.append("\n");
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
    //			cartScript.append("depth: 35,\n");
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
    //		//		    cartScript.append("type: \'pie\',\n");
    //		//		    cartScript.append("name: \'Browser share\',\n");
    //		//		    cartScript.append("data: [\n");
    //		//		    cartScript.append("[\'Firefox\', 45.0],\n");
    //		//		    cartScript.append("[\'IE\', 26.8],\n");
    //		//		    cartScript.append("{");
    //		//		    {
    //		//			cartScript.append("\n");
    //		//			cartScript.append("name: \'Chrome\',\n");
    //		//			cartScript.append("y: 12.8,\n");
    //		//			cartScript.append("sliced: true,\n");
    //		//			cartScript.append("selected: true\n");
    //		//			cartScript.append("}");
    //		//		    }
    //		//		    cartScript.append(",\n");
    //		//		    cartScript.append("[\'Safari\', 8.5],\n");
    //		//		    cartScript.append("[\'Opera\', 6.2],\n");
    //		//		    cartScript.append("[\'Others\', 0.7]\n");
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
