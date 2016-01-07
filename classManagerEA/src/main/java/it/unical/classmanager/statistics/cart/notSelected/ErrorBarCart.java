package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class ErrorBarCart extends AbstractCart {
public ErrorBarCart(){
super();
this.setName("ErrorBarCart");
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
cartScript.append("zoomType: \'xy\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Temperature vs Rainfall\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: [{");
{
cartScript.append("\n");
cartScript.append("categories: [\'Jan\', \'Feb\', \'Mar\', \'Apr\', \'May\', \'Jun\', \'Jul\', \'Aug\', \'Sep\', \'Oct\', \'Nov\', \'Dec\']\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("yAxis: [{");
{
cartScript.append(" // Primary yAxis\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("format: \'{");
{
cartScript.append("value}");
}
cartScript.append(" °C\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: Highcharts.getOptions().colors[1]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Temperature\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: Highcharts.getOptions().colors[1]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append(" // Secondary yAxis\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Rainfall\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: Highcharts.getOptions().colors[0]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("format: \'{");
{
cartScript.append("value}");
}
cartScript.append(" mm\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: Highcharts.getOptions().colors[0]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("opposite: true\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("shared: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Rainfall\',\n");
cartScript.append("type: \'column\',\n");
cartScript.append("yAxis: 1,\n");
cartScript.append("data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("pointFormat: \'<span style=\"font-weight: bold; color: {");
{
cartScript.append("series.color}");
}
cartScript.append("\">{");
{
cartScript.append("series.name}");
}
cartScript.append("</span>: <b>{");
{
cartScript.append("point.y:.1f}");
}
cartScript.append(" mm</b> \'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Rainfall error\',\n");
cartScript.append("type: \'errorbar\',\n");
cartScript.append("yAxis: 1,\n");
cartScript.append("data: [[48, 51], [68, 73], [92, 110], [128, 136], [140, 150], [171, 179], [135, 143], [142, 149], [204, 220], [189, 199], [95, 110], [52, 56]],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("pointFormat: \'(error range: {");
{
cartScript.append("point.low}");
}
cartScript.append("-{");
{
cartScript.append("point.high}");
}
cartScript.append(" mm)<br/>\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Temperature\',\n");
cartScript.append("type: \'spline\',\n");
cartScript.append("data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("pointFormat: \'<span style=\"font-weight: bold; color: {");
{
cartScript.append("series.color}");
}
cartScript.append("\">{");
{
cartScript.append("series.name}");
}
cartScript.append("</span>: <b>{");
{
cartScript.append("point.y:.1f}");
}
cartScript.append("°C</b> \'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Temperature error\',\n");
cartScript.append("type: \'errorbar\',\n");
cartScript.append("data: [[6, 8], [5.9, 7.6], [9.4, 10.4], [14.1, 15.9], [18.0, 20.1], [21.0, 24.0], [23.2, 25.3], [26.1, 27.8], [23.2, 23.9], [18.0, 21.1], [12.9, 14.0], [7.6, 10.0]],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("pointFormat: \'(error range: {");
{
cartScript.append("point.low}");
}
cartScript.append("-{");
{
cartScript.append("point.high}");
}
cartScript.append("°C)<br/>\'\n");
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
