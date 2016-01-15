package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class PieDonut3DCart extends AbstractCart {
    public PieDonut3DCart(){
	super(PieDonut3DCart.class.getSimpleName());
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
    //			cartScript.append("alpha: 45\n");
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
    //		cartScript.append("subtitle: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("text: \'"+subTitle+"\'\n");
    //		    cartScript.append("}");
    //		}
    //		cartScript.append(",\n");
    //		cartScript.append("plotOptions: {");
    //		{
    //		    cartScript.append("\n");
    //		    cartScript.append("pie: {");
    //		    {
    //			cartScript.append("\n");
    //			cartScript.append("innerSize: 100,\n");
    //			cartScript.append("depth: 45\n");
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
    //		//		    cartScript.append("name: \'Delivered amount\',\n");
    //		//		    cartScript.append("data: [\n");
    //		//		    cartScript.append("[\'Bananas\', 8],\n");
    //		//		    cartScript.append("[\'Kiwi\', 3],\n");
    //		//		    cartScript.append("[\'Mixed nuts\', 1],\n");
    //		//		    cartScript.append("[\'Oranges\', 6],\n");
    //		//		    cartScript.append("[\'Apples\', 8],\n");
    //		//		    cartScript.append("[\'Pears\', 4],\n");
    //		//		    cartScript.append("[\'Clementines\', 4],\n");
    //		//		    cartScript.append("[\'Reddish (bag)\', 1],\n");
    //		//		    cartScript.append("[\'Grapes (bunch)\', 1]\n");
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
