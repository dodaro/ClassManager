package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class ColumnPlacementCart extends AbstractCart {
public ColumnPlacementCart(){
super();
this.setName("ColumnPlacementCart");
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
cartScript.append("text: \'Efficiency Optimization by Branch\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\n");
cartScript.append("\'Seattle HQ\',\n");
cartScript.append("\'San Francisco\',\n");
cartScript.append("\'Tokyo\'\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: [{");
{
cartScript.append("\n");
cartScript.append("min: 0,\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Employees\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Profit (millions)\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("opposite: true\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("shadow: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("shared: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("column: {");
{
cartScript.append("\n");
cartScript.append("grouping: false,\n");
cartScript.append("shadow: false,\n");
cartScript.append("borderWidth: 0\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Employees\',\n");
cartScript.append("color: \'rgba(165,170,217,1)\',\n");
cartScript.append("data: [150, 73, 20],\n");
cartScript.append("pointPadding: 0.3,\n");
cartScript.append("pointPlacement: -0.2\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Employees Optimized\',\n");
cartScript.append("color: \'rgba(126,86,134,.9)\',\n");
cartScript.append("data: [140, 90, 40],\n");
cartScript.append("pointPadding: 0.4,\n");
cartScript.append("pointPlacement: -0.2\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Profit\',\n");
cartScript.append("color: \'rgba(248,161,63,1)\',\n");
cartScript.append("data: [183.6, 178.8, 198.5],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("valuePrefix: \'$\',\n");
cartScript.append("valueSuffix: \' M\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("pointPadding: 0.3,\n");
cartScript.append("pointPlacement: 0.2,\n");
cartScript.append("yAxis: 1\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Profit Optimized\',\n");
cartScript.append("color: \'rgba(186,60,61,.9)\',\n");
cartScript.append("data: [203.6, 198.8, 208.5],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("valuePrefix: \'$\',\n");
cartScript.append("valueSuffix: \' M\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("pointPadding: 0.4,\n");
cartScript.append("pointPlacement: 0.2,\n");
cartScript.append("yAxis: 1\n");
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
