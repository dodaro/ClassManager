package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class ComboCart extends AbstractCart {
public ComboCart(){
super();
this.setName("ComboCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
{
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Combination chart\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\'Apples\', \'Oranges\', \'Pears\', \'Bananas\', \'Plums\']\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("items: [{");
{
cartScript.append("\n");
cartScript.append("html: \'Total fruit consumption\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("left: \'50px\',\n");
cartScript.append("top: \'18px\',\n");
cartScript.append("color: (Highcharts.theme && Highcharts.theme.textColor) || \'black\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("type: \'column\',\n");
cartScript.append("name: \'Jane\',\n");
cartScript.append("data: [3, 2, 1, 3, 4]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("type: \'column\',\n");
cartScript.append("name: \'John\',\n");
cartScript.append("data: [2, 3, 5, 7, 6]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("type: \'column\',\n");
cartScript.append("name: \'Joe\',\n");
cartScript.append("data: [4, 3, 3, 9, 0]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("type: \'spline\',\n");
cartScript.append("name: \'Average\',\n");
cartScript.append("data: [3, 2.67, 3, 6.33, 3.33],\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("lineWidth: 2,\n");
cartScript.append("lineColor: Highcharts.getOptions().colors[3],\n");
cartScript.append("fillColor: \'white\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("type: \'pie\',\n");
cartScript.append("name: \'Total consumption\',\n");
cartScript.append("data: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Jane\',\n");
cartScript.append("y: 13,\n");
cartScript.append("color: Highcharts.getOptions().colors[0] // Jane\'s color\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'John\',\n");
cartScript.append("y: 23,\n");
cartScript.append("color: Highcharts.getOptions().colors[1] // John\'s color\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Joe\',\n");
cartScript.append("y: 19,\n");
cartScript.append("color: Highcharts.getOptions().colors[2] // Joe\'s color\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("center: [100, 80],\n");
cartScript.append("size: 100,\n");
cartScript.append("showInLegend: false,\n");
cartScript.append("dataLabels: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
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
