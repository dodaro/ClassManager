package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class SplineInvertedCart extends AbstractCart {
public SplineInvertedCart(){
super();
this.setName("SplineInvertedCart");
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
cartScript.append("type: \'spline\',\n");
cartScript.append("inverted: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Atmosphere Temperature by Altitude\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'According to the Standard Atmosphere Model\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("reversed: false,\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("enabled: true,\n");
cartScript.append("text: \'Altitude\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("formatter: function () {");
{
cartScript.append("\n");
cartScript.append("return this.value + \'km\';\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("maxPadding: 0.05,\n");
cartScript.append("showLastLabel: true\n");
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
cartScript.append(",\n");
cartScript.append("lineWidth: 2\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
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
cartScript.append("</b><br/>\',\n");
cartScript.append("pointFormat: \'{");
{
cartScript.append("point.x}");
}
cartScript.append(" km: {");
{
cartScript.append("point.y}");
}
cartScript.append("°C\'\n");
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
cartScript.append("enable: false\n");
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
cartScript.append("name: \'Temperature\',\n");
cartScript.append("data: [[0, 15], [10, -50], [20, -56.5], [30, -46.5], [40, -22.1],\n");
cartScript.append("[50, -2.5], [60, -27.7], [70, -55.7], [80, -76.5]]\n");
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
