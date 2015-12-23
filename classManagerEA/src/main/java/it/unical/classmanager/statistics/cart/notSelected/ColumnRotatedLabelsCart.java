package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class ColumnRotatedLabelsCart extends AbstractCart {
public ColumnRotatedLabelsCart(){
super();
this.setName("ColumnRotatedLabelsCart");
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
cartScript.append("type: \'column\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'World\\'s largest cities per 2014\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'Source: <a href=\"http://en.wikipedia.org/wiki/List_of_cities_proper_by_population\">Wikipedia</a>\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("type: \'category\',\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("rotation: -45,\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("fontSize: \'13px\',\n");
cartScript.append("fontFamily: \'Verdana, sans-serif\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("min: 0,\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Population (millions)\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("pointFormat: \'Population in 2008: <b>{");
{
cartScript.append("point.y:.1f}");
}
cartScript.append(" millions</b>\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Population\',\n");
cartScript.append("data: [\n");
cartScript.append("[\'Shanghai\', 23.7],\n");
cartScript.append("[\'Lagos\', 16.1],\n");
cartScript.append("[\'Instanbul\', 14.2],\n");
cartScript.append("[\'Karachi\', 14.0],\n");
cartScript.append("[\'Mumbai\', 12.5],\n");
cartScript.append("[\'Moscow\', 12.1],\n");
cartScript.append("[\'São Paulo\', 11.8],\n");
cartScript.append("[\'Beijing\', 11.7],\n");
cartScript.append("[\'Guangzhou\', 11.1],\n");
cartScript.append("[\'Delhi\', 11.1],\n");
cartScript.append("[\'Shenzhen\', 10.5],\n");
cartScript.append("[\'Seoul\', 10.4],\n");
cartScript.append("[\'Jakarta\', 10.0],\n");
cartScript.append("[\'Kinshasa\', 9.3],\n");
cartScript.append("[\'Tianjin\', 9.3],\n");
cartScript.append("[\'Tokyo\', 9.0],\n");
cartScript.append("[\'Cairo\', 8.9],\n");
cartScript.append("[\'Dhaka\', 8.9],\n");
cartScript.append("[\'Mexico City\', 8.9],\n");
cartScript.append("[\'Lima\', 8.9]\n");
cartScript.append("],\n");
cartScript.append("dataLabels: {");
{
cartScript.append("\n");
cartScript.append("enabled: true,\n");
cartScript.append("rotation: -90,\n");
cartScript.append("color: \'#FFFFFF\',\n");
cartScript.append("align: \'right\',\n");
cartScript.append("format: \'{");
{
cartScript.append("point.y:.1f}");
}
cartScript.append("\', // one decimal\n");
cartScript.append("y: 10, // 10 pixels down from the top\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("fontSize: \'13px\',\n");
cartScript.append("fontFamily: \'Verdana, sans-serif\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
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
