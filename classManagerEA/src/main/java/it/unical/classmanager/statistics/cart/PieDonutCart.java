package it.unical.classmanager.statistics.cart;

/**
 * @author Aloisius92
 * This is a cart class type.
 */
public class PieDonutCart extends AbstractCart {
    
    public PieDonutCart(){
	super();
	this.setName("PieDonutCart");

    }
    
    @Override
    protected void buildCart() {
	cartScript = new StringBuilder("");
	cartScript.append("<script type=\"text/javascript\">\n");
	cartScript.append("$(document).ready(function() {\n");
	{
	    cartScript.append("var colors = Highcharts.getOptions().colors,\n");
	    cartScript.append("categories = ["+categories+"],\n"); // \'MSIE\', \'Firefox\', \'Chrome\', \'Safari\', \'Opera\'
	    cartScript.append("data = [");
	    cartScript.append(categoriesDataContent);
	    //cartScript.append("{");
	    //	    {
	    //		cartScript.append("\n");
	    //		cartScript.append("y: 56.33,\n");
	    //		cartScript.append("color: colors[0],\n");
	    //		cartScript.append("drilldown: {");
	    //		{
	    //		    cartScript.append("\n");
	    //		    cartScript.append("name: \'MSIE versions\',\n");
	    //		    cartScript.append("categories: [\'MSIE 6.0\', \'MSIE 7.0\', \'MSIE 8.0\', \'MSIE 9.0\', \'MSIE 10.0\', \'MSIE 11.0\'],\n");
	    //		    cartScript.append("data: [1.06, 0.5, 17.2, 8.11, 5.33, 24.13],\n");
	    //		    cartScript.append("color: colors[0]\n");
	    //		    cartScript.append("}");
	    //		}
	    //		cartScript.append("\n");
	    //		cartScript.append("}");
	    //	    }
	    //	    cartScript.append(", {");
	    //	    {
	    //		cartScript.append("\n");
	    //		cartScript.append("y: 10.38,\n");
	    //		cartScript.append("color: colors[1],\n");
	    //		cartScript.append("drilldown: {");
	    //		{
	    //		    cartScript.append("\n");
	    //		    cartScript.append("name: \'Firefox versions\',\n");
	    //		    cartScript.append("categories: [\'Firefox v31\', \'Firefox v32\', \'Firefox v33\', \'Firefox v35\', \'Firefox v36\', \'Firefox v37\', \'Firefox v38\'],\n");
	    //		    cartScript.append("data: [0.33, 0.15, 0.22, 1.27, 2.76, 2.32, 2.31, 1.02],\n");
	    //		    cartScript.append("color: colors[1]\n");
	    //		    cartScript.append("}");
	    //		}
	    //		cartScript.append("\n");
	    //		cartScript.append("}");
	    //	    }
	    //	    cartScript.append(", {");
	    //	    {
	    //		cartScript.append("\n");
	    //		cartScript.append("y: 24.03,\n");
	    //		cartScript.append("color: colors[2],\n");
	    //		cartScript.append("drilldown: {");
	    //		{
	    //		    cartScript.append("\n");
	    //		    cartScript.append("name: \'Chrome versions\',\n");
	    //		    cartScript.append("categories: [\'Chrome v30.0\', \'Chrome v31.0\', \'Chrome v32.0\', \'Chrome v33.0\', \'Chrome v34.0\',\n");
	    //		    cartScript.append("\'Chrome v35.0\', \'Chrome v36.0\', \'Chrome v37.0\', \'Chrome v38.0\', \'Chrome v39.0\', \'Chrome v40.0\', \'Chrome v41.0\', \'Chrome v42.0\', \'Chrome v43.0\'\n");
	    //		    cartScript.append("],\n");
	    //		    cartScript.append("data: [0.14, 1.24, 0.55, 0.19, 0.14, 0.85, 2.53, 0.38, 0.6, 2.96, 5, 4.32, 3.68, 1.45],\n");
	    //		    cartScript.append("color: colors[2]\n");
	    //		    cartScript.append("}");
	    //		}
	    //		cartScript.append("\n");
	    //		cartScript.append("}");
	    //	    }
	    //	    cartScript.append(", {");
	    //	    {
	    //		cartScript.append("\n");
	    //		cartScript.append("y: 4.77,\n");
	    //		cartScript.append("color: colors[3],\n");
	    //		cartScript.append("drilldown: {");
	    //		{
	    //		    cartScript.append("\n");
	    //		    cartScript.append("name: \'Safari versions\',\n");
	    //		    cartScript.append("categories: [\'Safari v5.0\', \'Safari v5.1\', \'Safari v6.1\', \'Safari v6.2\', \'Safari v7.0\', \'Safari v7.1\', \'Safari v8.0\'],\n");
	    //		    cartScript.append("data: [0.3, 0.42, 0.29, 0.17, 0.26, 0.77, 2.56],\n");
	    //		    cartScript.append("color: colors[3]\n");
	    //		    cartScript.append("}");
	    //		}
	    //		cartScript.append("\n");
	    //		cartScript.append("}");
	    //	    }
	    //	    cartScript.append(", {");
	    //	    {
	    //		cartScript.append("\n");
	    //		cartScript.append("y: 0.91,\n");
	    //		cartScript.append("color: colors[4],\n");
	    //		cartScript.append("drilldown: {");
	    //		{
	    //		    cartScript.append("\n");
	    //		    cartScript.append("name: \'Opera versions\',\n");
	    //		    cartScript.append("categories: [\'Opera v12.x\', \'Opera v27\', \'Opera v28\', \'Opera v29\'],\n");
	    //		    cartScript.append("data: [0.34, 0.17, 0.24, 0.16],\n");
	    //		    cartScript.append("color: colors[4]\n");
	    //		    cartScript.append("}");
	    //		}
	    //		cartScript.append("\n");
	    //		cartScript.append("}");
	    //	    }
	    //	    cartScript.append(", {");
	    //	    {
	    //		cartScript.append("\n");
	    //		cartScript.append("y: 0.2,\n");
	    //		cartScript.append("color: colors[5],\n");
	    //		cartScript.append("drilldown: {");
	    //		{
	    //		    cartScript.append("\n");
	    //		    cartScript.append("name: \'Proprietary or Undetectable\',\n");
	    //		    cartScript.append("categories: [],\n");
	    //		    cartScript.append("data: [],\n");
	    //		    cartScript.append("color: colors[5]\n");
	    //		    cartScript.append("}");
	    //		}
	    //		cartScript.append("\n");
	    //		cartScript.append("}");
	    //	    }
	    cartScript.append("],\n");
	    cartScript.append("browserData = [],\n");
	    cartScript.append("versionsData = [],\n");
	    cartScript.append("i,\n");
	    cartScript.append("j,\n");
	    cartScript.append("dataLen = data.length,\n");
	    cartScript.append("drillDataLen,\n");
	    cartScript.append("brightness;\n");
	    cartScript.append("// Build the data arrays\n");
	    cartScript.append("for (i = 0; i < dataLen; i += 1) {");
	    {
		cartScript.append("\n");
		cartScript.append("// add browser data\n");
		cartScript.append("browserData.push({");
		{
		    cartScript.append("\n");
		    cartScript.append("name: categories[i],\n");
		    cartScript.append("y: data[i].y,\n");
		    cartScript.append("color: data[i].color\n");
		    cartScript.append("}");
		}
		cartScript.append(");\n");
		cartScript.append("// add version data\n");
		cartScript.append("drillDataLen = data[i].drilldown.data.length;\n");
		cartScript.append("for (j = 0; j < drillDataLen; j += 1) {");
		{
		    cartScript.append("\n");
		    cartScript.append("brightness = 0.2 - (j / drillDataLen) / 5;\n");
		    cartScript.append("versionsData.push({");
		    {
			cartScript.append("\n");
			cartScript.append("name: data[i].drilldown.categories[j],\n");
			cartScript.append("y: data[i].drilldown.data[j],\n");
			cartScript.append("color: Highcharts.Color(data[i].color).brighten(brightness).get()\n");
			cartScript.append("}");
		    }
		    cartScript.append(");\n");
		    cartScript.append("}");
		}
		cartScript.append("\n");
		cartScript.append("}");
	    }
	    cartScript.append("\n");
	    cartScript.append("// Create the chart\n");
	    cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
	    {
		cartScript.append("chart: {");
		{
		    cartScript.append("\n");
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
		cartScript.append("subtitle: {");
		{
		    cartScript.append("\n");
		    cartScript.append("text: \'"+subTitle+"'\n");
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
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("plotOptions: {");
		{
		    cartScript.append("\n");
		    cartScript.append("pie: {");
		    {
			cartScript.append("\n");
			cartScript.append("shadow: false,\n");
			cartScript.append("center: [\'50%\', \'50%\']\n");
			cartScript.append("}");
		    }
		    cartScript.append("\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("tooltip: {");
		{
		    cartScript.append("\n");
		    cartScript.append("valueSuffix: \'%\'\n");
		    cartScript.append("}");
		}
		cartScript.append(",\n");
		cartScript.append("series: [");
		cartScript.append(seriesContent);
		//		cartScript.append("{");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Browsers\',\n");
		//		    cartScript.append("data: browserData,\n");
		//		    cartScript.append("size: \'60%\',\n");
		//		    cartScript.append("dataLabels: {");
		//		    {
		//			cartScript.append("\n");
		//			cartScript.append("formatter: function () {");
		//			{
		//			    cartScript.append("\n");
		//			    cartScript.append("return this.y > 5 ? this.point.name : null;\n");
		//			    cartScript.append("}");
		//			}
		//			cartScript.append(",\n");
		//			cartScript.append("color: \'#ffffff\',\n");
		//			cartScript.append("distance: -30\n");
		//			cartScript.append("}");
		//		    }
		//		    cartScript.append("\n");
		//		    cartScript.append("}");
		//		}
		//		cartScript.append(", {");
		//		{
		//		    cartScript.append("\n");
		//		    cartScript.append("name: \'Versions\',\n");
		//		    cartScript.append("data: versionsData,\n");
		//		    cartScript.append("size: \'80%\',\n");
		//		    cartScript.append("innerSize: \'60%\',\n");
		//		    cartScript.append("dataLabels: {");
		//		    {
		//			cartScript.append("\n");
		//			cartScript.append("formatter: function () {");
		//			{
		//			    cartScript.append("\n");
		//			    cartScript.append("// display only if larger than 1\n");
		//			    cartScript.append("return this.y > 1 ? \'<b>\' + this.point.name + \':</b> \' + this.y + \'%\' : null;\n");
		//			    cartScript.append("}");
		//			}
		//			cartScript.append("\n");
		//			cartScript.append("}");
		//		    }
		//		    cartScript.append("\n");
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
