package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class BarStackedCart extends AbstractCart {
public BarStackedCart(){
super();
this.setName("BarStackedCart");
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
cartScript.append("text: \'Stacked bar chart\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\'Apples\', \'Oranges\', \'Pears\', \'Grapes\', \'Bananas\']\n");
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
cartScript.append("text: \'Total fruit consumption\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("reversed: true\n");
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
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'John\',\n");
cartScript.append("data: [5, 3, 4, 7, 2]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Jane\',\n");
cartScript.append("data: [2, 2, 3, 2, 1]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Joe\',\n");
cartScript.append("data: [3, 4, 4, 2, 5]\n");
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
