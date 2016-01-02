package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class SplineSymbolsCart extends AbstractCart {
public SplineSymbolsCart(){
super();
this.setName("SplineSymbolsCart");
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
cartScript.append("type: \'spline\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Monthly Average Temperature\'\n");
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
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\'Jan\', \'Feb\', \'Mar\', \'Apr\', \'May\', \'Jun\',\n");
cartScript.append("\'Jul\', \'Aug\', \'Sep\', \'Oct\', \'Nov\', \'Dec\']\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Temperature\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("formatter: function () {");
{
cartScript.append("\n");
cartScript.append("return this.value + \'°\';\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("crosshairs: true,\n");
cartScript.append("shared: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("spline: {");
{
cartScript.append("\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("radius: 4,\n");
cartScript.append("lineColor: \'#666666\',\n");
cartScript.append("lineWidth: 1\n");
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
cartScript.append("name: \'Tokyo\',\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("symbol: \'square\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, {");
{
cartScript.append("\n");
cartScript.append("y: 26.5,\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("symbol: \'url(https://www.highcharts.com/samples/graphics/sun.png)\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", 23.3, 18.3, 13.9, 9.6]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'London\',\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("symbol: \'diamond\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("data: [{");
{
cartScript.append("\n");
cartScript.append("y: 3.9,\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("symbol: \'url(https://www.highcharts.com/samples/graphics/snow.png)\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]\n");
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
