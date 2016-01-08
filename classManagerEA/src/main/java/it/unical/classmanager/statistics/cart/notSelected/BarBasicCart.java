package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class BarBasicCart extends AbstractCart {
public BarBasicCart(){
super();
this.setName("BarBasicCart");
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
cartScript.append("type: \'bar\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Historic World Population by Region\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'Source: <a href=\"https://en.wikipedia.org/wiki/World_population\">Wikipedia.org</a>\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\'Africa\', \'America\', \'Asia\', \'Europe\', \'Oceania\'],\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: null\n");
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
cartScript.append("text: \'Population (millions)\',\n");
cartScript.append("align: \'high\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
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
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("valueSuffix: \' millions\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("bar: {");
{
cartScript.append("\n");
cartScript.append("dataLabels: {");
{
cartScript.append("\n");
cartScript.append("enabled: true\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("layout: \'vertical\',\n");
cartScript.append("align: \'right\',\n");
cartScript.append("verticalAlign: \'top\',\n");
cartScript.append("x: -40,\n");
cartScript.append("y: 80,\n");
cartScript.append("floating: true,\n");
cartScript.append("borderWidth: 1,\n");
cartScript.append("backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || \'#FFFFFF\'),\n");
cartScript.append("shadow: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("credits: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Year 1800\',\n");
cartScript.append("data: [107, 31, 635, 203, 2]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Year 1900\',\n");
cartScript.append("data: [133, 156, 947, 408, 6]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Year 2012\',\n");
cartScript.append("data: [1052, 954, 4250, 740, 38]\n");
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
