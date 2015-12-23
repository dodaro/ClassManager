package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class SplinePlotBandsCart extends AbstractCart {
public SplinePlotBandsCart(){
super();
this.setName("SplinePlotBandsCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("// Data retrieved from http://vikjavev.no/ver/index.php?spenn=2d&sluttid=16.06.2015.\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
{
cartScript.append("chart: {");
{
cartScript.append("\n");
cartScript.append("type: \'spline\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Wind speed during two days\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'May 31 and and June 1, 2015 at two locations in Vik i Sogn, Norway\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("type: \'datetime\',\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("overflow: \'justify\'\n");
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
cartScript.append("text: \'Wind speed (m/s)\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("minorGridLineWidth: 0,\n");
cartScript.append("gridLineWidth: 0,\n");
cartScript.append("alternateGridColor: null,\n");
cartScript.append("plotBands: [{");
{
cartScript.append(" // Light air\n");
cartScript.append("from: 0.3,\n");
cartScript.append("to: 1.5,\n");
cartScript.append("color: \'rgba(68, 170, 213, 0.1)\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'Light air\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#606060\'\n");
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
cartScript.append(" // Light breeze\n");
cartScript.append("from: 1.5,\n");
cartScript.append("to: 3.3,\n");
cartScript.append("color: \'rgba(0, 0, 0, 0)\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'Light breeze\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#606060\'\n");
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
cartScript.append(" // Gentle breeze\n");
cartScript.append("from: 3.3,\n");
cartScript.append("to: 5.5,\n");
cartScript.append("color: \'rgba(68, 170, 213, 0.1)\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'Gentle breeze\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#606060\'\n");
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
cartScript.append(" // Moderate breeze\n");
cartScript.append("from: 5.5,\n");
cartScript.append("to: 8,\n");
cartScript.append("color: \'rgba(0, 0, 0, 0)\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'Moderate breeze\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#606060\'\n");
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
cartScript.append(" // Fresh breeze\n");
cartScript.append("from: 8,\n");
cartScript.append("to: 11,\n");
cartScript.append("color: \'rgba(68, 170, 213, 0.1)\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'Fresh breeze\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#606060\'\n");
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
cartScript.append(" // Strong breeze\n");
cartScript.append("from: 11,\n");
cartScript.append("to: 14,\n");
cartScript.append("color: \'rgba(0, 0, 0, 0)\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'Strong breeze\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#606060\'\n");
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
cartScript.append(" // High wind\n");
cartScript.append("from: 14,\n");
cartScript.append("to: 15,\n");
cartScript.append("color: \'rgba(68, 170, 213, 0.1)\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'High wind\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#606060\'\n");
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
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("valueSuffix: \' m/s\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("spline: {");
{
cartScript.append("\n");
cartScript.append("lineWidth: 4,\n");
cartScript.append("states: {");
{
cartScript.append("\n");
cartScript.append("hover: {");
{
cartScript.append("\n");
cartScript.append("lineWidth: 5\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("pointInterval: 3600000, // one hour\n");
cartScript.append("pointStart: Date.UTC(2015, 4, 31, 0, 0, 0)\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Hestavollane\',\n");
cartScript.append("data: [0.2, 0.8, 0.8, 0.8, 1, 1.3, 1.5, 2.9, 1.9, 2.6, 1.6, 3, 4, 3.6, 4.5, 4.2, 4.5, 4.5, 4, 3.1, 2.7, 4, 2.7, 2.3, 2.3, 4.1, 7.7, 7.1, 5.6, 6.1, 5.8, 8.6, 7.2, 9, 10.9, 11.5, 11.6, 11.1, 12, 12.3, 10.7, 9.4, 9.8, 9.6, 9.8, 9.5, 8.5, 7.4, 7.6]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Vik\',\n");
cartScript.append("data: [0, 0, 0.6, 0.9, 0.8, 0.2, 0, 0, 0, 0.1, 0.6, 0.7, 0.8, 0.6, 0.2, 0, 0.1, 0.3, 0.3, 0, 0.1, 0, 0, 0, 0.2, 0.1, 0, 0.3, 0, 0.1, 0.2, 0.1, 0.3, 0.3, 0, 3.1, 3.1, 2.5, 1.5, 1.9, 2.1, 1, 2.3, 1.9, 1.2, 0.7, 1.3, 0.4, 0.3]\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("navigation: {");
{
cartScript.append("\n");
cartScript.append("menuItemStyle: {");
{
cartScript.append("\n");
cartScript.append("fontSize: \'10px\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("</script>\n");
}
}
