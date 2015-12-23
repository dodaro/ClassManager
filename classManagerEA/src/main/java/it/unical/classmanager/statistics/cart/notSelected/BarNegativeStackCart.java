package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class BarNegativeStackCart extends AbstractCart {
public BarNegativeStackCart(){
super();
this.setName("BarNegativeStackCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("// Data gathered from http://populationpyramid.net/germany/2015/\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("// Age categories\n");
cartScript.append("var categories = [\'0-4\', \'5-9\', \'10-14\', \'15-19\',\n");
cartScript.append("\'20-24\', \'25-29\', \'30-34\', \'35-39\', \'40-44\',\n");
cartScript.append("\'45-49\', \'50-54\', \'55-59\', \'60-64\', \'65-69\',\n");
cartScript.append("\'70-74\', \'75-79\', \'80-84\', \'85-89\', \'90-94\',\n");
cartScript.append("\'95-99\', \'100 + \'];\n");
cartScript.append("$(document).ready(function () {");
{
cartScript.append("\n");
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
cartScript.append("text: \'Population pyramid for Germany, 2015\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'Source: <a href=\"http://populationpyramid.net/germany/2015/\">Population Pyramids of the World from 1950 to 2100</a>\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: [{");
{
cartScript.append("\n");
cartScript.append("categories: categories,\n");
cartScript.append("reversed: false,\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("step: 1\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append(" // mirror axis on right side\n");
cartScript.append("opposite: true,\n");
cartScript.append("reversed: false,\n");
cartScript.append("categories: categories,\n");
cartScript.append("linkedTo: 0,\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("step: 1\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: null\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("formatter: function () {");
{
cartScript.append("\n");
cartScript.append("return Math.abs(this.value) + \'%\';\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("series: {");
{
cartScript.append("\n");
cartScript.append("stacking: \'normal\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("formatter: function () {");
{
cartScript.append("\n");
cartScript.append("return \'<b>\' + this.series.name + \', age \' + this.point.category + \'</b><br/>\' +\n");
cartScript.append("\'Population: \' + Highcharts.numberFormat(Math.abs(this.point.y), 0);\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Male\',\n");
cartScript.append("data: [-2.2, -2.2, -2.3, -2.5, -2.7, -3.1, -3.2,\n");
cartScript.append("-3.0, -3.2, -4.3, -4.4, -3.6, -3.1, -2.4,\n");
cartScript.append("-2.5, -2.3, -1.2, -0.6, -0.2, -0.0, -0.0]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Female\',\n");
cartScript.append("data: [2.1, 2.0, 2.2, 2.4, 2.6, 3.0, 3.1, 2.9,\n");
cartScript.append("3.1, 4.1, 4.3, 3.6, 3.4, 2.6, 2.9, 2.9,\n");
cartScript.append("1.8, 1.2, 0.6, 0.1, 0.0]\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("</script>\n");
}
}
