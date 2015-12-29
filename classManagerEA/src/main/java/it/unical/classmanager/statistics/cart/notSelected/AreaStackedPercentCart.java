package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class AreaStackedPercentCart extends AbstractCart {
public AreaStackedPercentCart(){
super();
this.setName("AreaStackedPercentCart");
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
cartScript.append("type: \'area\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Historic and Estimated Worldwide Population Distribution by Region\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'Source: Wikipedia.org\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\'1750\', \'1800\', \'1850\', \'1900\', \'1950\', \'1999\', \'2050\'],\n");
cartScript.append("tickmarkPlacement: \'on\',\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
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
cartScript.append("text: \'Percent\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("pointFormat: \'<span style=\"color:{");
{
cartScript.append("series.color}");
}
cartScript.append("\">{");
{
cartScript.append("series.name}");
}
cartScript.append("</span>: <b>{");
{
cartScript.append("point.percentage:.1f}");
}
cartScript.append("%</b> ({");
{
cartScript.append("point.y:,.0f}");
}
cartScript.append(" millions)<br/>\',\n");
cartScript.append("shared: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("area: {");
{
cartScript.append("\n");
cartScript.append("stacking: \'percent\',\n");
cartScript.append("lineColor: \'#ffffff\',\n");
cartScript.append("lineWidth: 1,\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("lineWidth: 1,\n");
cartScript.append("lineColor: \'#ffffff\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Asia\',\n");
cartScript.append("data: [502, 635, 809, 947, 1402, 3634, 5268]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Africa\',\n");
cartScript.append("data: [106, 107, 111, 133, 221, 767, 1766]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Europe\',\n");
cartScript.append("data: [163, 203, 276, 408, 547, 729, 628]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'America\',\n");
cartScript.append("data: [18, 31, 54, 156, 339, 818, 1201]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Oceania\',\n");
cartScript.append("data: [2, 2, 2, 6, 13, 30, 46]\n");
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
