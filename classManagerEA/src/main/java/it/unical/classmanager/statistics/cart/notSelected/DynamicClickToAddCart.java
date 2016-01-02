package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class DynamicClickToAddCart extends AbstractCart {
public DynamicClickToAddCart(){
super();
this.setName("DynamicClickToAddCart");
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
cartScript.append("type: \'scatter\',\n");
cartScript.append("margin: [70, 50, 60, 80],\n");
cartScript.append("events: {");
{
cartScript.append("\n");
cartScript.append("click: function (e) {");
{
cartScript.append("\n");
cartScript.append("// find the clicked values and the series\n");
cartScript.append("var x = e.xAxis[0].value,\n");
cartScript.append("y = e.yAxis[0].value,\n");
cartScript.append("series = this.series[0];\n");
cartScript.append("// Add it\n");
cartScript.append("series.addPoint([x, y]);\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'User supplied data\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'Click the plot area to add a point. Click a point to remove it.\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("gridLineWidth: 1,\n");
cartScript.append("minPadding: 0.2,\n");
cartScript.append("maxPadding: 0.2,\n");
cartScript.append("maxZoom: 60\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Value\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("minPadding: 0.2,\n");
cartScript.append("maxPadding: 0.2,\n");
cartScript.append("maxZoom: 60,\n");
cartScript.append("plotLines: [{");
{
cartScript.append("\n");
cartScript.append("value: 0,\n");
cartScript.append("width: 1,\n");
cartScript.append("color: \'#808080\'\n");
cartScript.append("}");
}
cartScript.append("]\n");
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
cartScript.append("exporting: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("series: {");
{
cartScript.append("\n");
cartScript.append("lineWidth: 1,\n");
cartScript.append("point: {");
{
cartScript.append("\n");
cartScript.append("events: {");
{
cartScript.append("\n");
cartScript.append("\'click\': function () {");
{
cartScript.append("\n");
cartScript.append("if (this.series.data.length > 1) {");
{
cartScript.append("\n");
cartScript.append("this.remove();\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
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
cartScript.append("data: [[20, 20], [80, 80]]\n");
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
