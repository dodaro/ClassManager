package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class LineLogAxisCart extends AbstractCart {
public LineLogAxisCart(){
super();
this.setName("LineLogAxisCart");
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
cartScript.append("text: \'Logarithmic axis demo\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("tickInterval: 1\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("type: \'logarithmic\',\n");
cartScript.append("minorTickInterval: 0.1\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("headerFormat: \'<b>{");
{
cartScript.append("series.name}");
}
cartScript.append("</b><br />\',\n");
cartScript.append("pointFormat: \'x = {");
{
cartScript.append("point.x}");
}
cartScript.append(", y = {");
{
cartScript.append("point.y}");
}
cartScript.append("\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("data: [1, 2, 4, 8, 16, 32, 64, 128, 256, 512],\n");
cartScript.append("pointStart: 1\n");
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
