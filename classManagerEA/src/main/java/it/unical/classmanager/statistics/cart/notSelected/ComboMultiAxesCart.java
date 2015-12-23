package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class ComboMultiAxesCart extends AbstractCart {
public ComboMultiAxesCart(){
super();
this.setName("ComboMultiAxesCart");
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
cartScript.append("text: \'Average Monthly Weather Data for Tokyo\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'Source: WorldClimate.com\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: [{");
{
cartScript.append("\n");
cartScript.append("categories: [\'Jan\', \'Feb\', \'Mar\', \'Apr\', \'May\', \'Jun\',\n");
cartScript.append("\'Jul\', \'Aug\', \'Sep\', \'Oct\', \'Nov\', \'Dec\'],\n");
cartScript.append("crosshair: true\n");
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
cartScript.append("°C\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: Highcharts.getOptions().colors[2]\n");
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
cartScript.append("color: Highcharts.getOptions().colors[2]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("opposite: true\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append(" // Secondary yAxis\n");
cartScript.append("gridLineWidth: 0,\n");
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
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append(" // Tertiary yAxis\n");
cartScript.append("gridLineWidth: 0,\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Sea-Level Pressure\',\n");
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
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("format: \'{");
{
cartScript.append("value}");
}
cartScript.append(" mb\',\n");
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
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("layout: \'vertical\',\n");
cartScript.append("align: \'left\',\n");
cartScript.append("x: 80,\n");
cartScript.append("verticalAlign: \'top\',\n");
cartScript.append("y: 55,\n");
cartScript.append("floating: true,\n");
cartScript.append("backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || \'#FFFFFF\'\n");
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
cartScript.append("valueSuffix: \' mm\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Sea-Level Pressure\',\n");
cartScript.append("type: \'spline\',\n");
cartScript.append("yAxis: 2,\n");
cartScript.append("data: [1016, 1016, 1015.9, 1015.5, 1012.3, 1009.5, 1009.6, 1010.2, 1013.1, 1016.9, 1018.2, 1016.7],\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("dashStyle: \'shortdot\',\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("valueSuffix: \' mb\'\n");
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
cartScript.append("valueSuffix: \' °C\'\n");
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
