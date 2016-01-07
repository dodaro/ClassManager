package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class GaugeVuMeterCart extends AbstractCart {
public GaugeVuMeterCart(){
super();
this.setName("GaugeVuMeterCart");
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
cartScript.append("type: \'gauge\',\n");
cartScript.append("plotBorderWidth: 1,\n");
cartScript.append("plotBackgroundColor: {");
{
cartScript.append("\n");
cartScript.append("linearGradient: {");
{
cartScript.append(" x1: 0, y1: 0, x2: 0, y2: 1 }");
}
cartScript.append(",\n");
cartScript.append("stops: [\n");
cartScript.append("[0, \'#FFF4C6\'],\n");
cartScript.append("[0.3, \'#FFFFFF\'],\n");
cartScript.append("[1, \'#FFF4C6\']\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotBackgroundImage: null,\n");
cartScript.append("height: 200\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'VU meter\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("pane: [{");
{
cartScript.append("\n");
cartScript.append("startAngle: -45,\n");
cartScript.append("endAngle: 45,\n");
cartScript.append("background: null,\n");
cartScript.append("center: [\'25%\', \'145%\'],\n");
cartScript.append("size: 300\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("startAngle: -45,\n");
cartScript.append("endAngle: 45,\n");
cartScript.append("background: null,\n");
cartScript.append("center: [\'75%\', \'145%\'],\n");
cartScript.append("size: 300\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: [{");
{
cartScript.append("\n");
cartScript.append("min: -20,\n");
cartScript.append("max: 6,\n");
cartScript.append("minorTickPosition: \'outside\',\n");
cartScript.append("tickPosition: \'outside\',\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("rotation: \'auto\',\n");
cartScript.append("distance: 20\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotBands: [{");
{
cartScript.append("\n");
cartScript.append("from: 0,\n");
cartScript.append("to: 6,\n");
cartScript.append("color: \'#C02316\',\n");
cartScript.append("innerRadius: \'100%\',\n");
cartScript.append("outerRadius: \'105%\'\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("pane: 0,\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'VU<br/><span style=\"font-size:8px\">Channel A</span>\',\n");
cartScript.append("y: -40\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("min: -20,\n");
cartScript.append("max: 6,\n");
cartScript.append("minorTickPosition: \'outside\',\n");
cartScript.append("tickPosition: \'outside\',\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("rotation: \'auto\',\n");
cartScript.append("distance: 20\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotBands: [{");
{
cartScript.append("\n");
cartScript.append("from: 0,\n");
cartScript.append("to: 6,\n");
cartScript.append("color: \'#C02316\',\n");
cartScript.append("innerRadius: \'100%\',\n");
cartScript.append("outerRadius: \'105%\'\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("pane: 1,\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'VU<br/><span style=\"font-size:8px\">Channel B</span>\',\n");
cartScript.append("y: -40\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("gauge: {");
{
cartScript.append("\n");
cartScript.append("dataLabels: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("dial: {");
{
cartScript.append("\n");
cartScript.append("radius: \'100%\'\n");
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
cartScript.append("name: \'Channel A\',\n");
cartScript.append("data: [-20],\n");
cartScript.append("yAxis: 0\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Channel B\',\n");
cartScript.append("data: [-20],\n");
cartScript.append("yAxis: 1\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("// Let the music play\n");
cartScript.append("function (chart) {");
{
cartScript.append("\n");
cartScript.append("setInterval(function () {");
{
cartScript.append("\n");
cartScript.append("if (chart.series) {");
{
cartScript.append(" // the chart may be destroyed\n");
cartScript.append("var left = chart.series[0].points[0],\n");
cartScript.append("right = chart.series[1].points[0],\n");
cartScript.append("leftVal,\n");
cartScript.append("rightVal,\n");
cartScript.append("inc = (Math.random() - 0.5) * 3;\n");
cartScript.append("leftVal = left.y + inc;\n");
cartScript.append("rightVal = leftVal + inc / 3;\n");
cartScript.append("if (leftVal < -20 || leftVal > 6) {");
{
cartScript.append("\n");
cartScript.append("leftVal = left.y - inc;\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("if (rightVal < -20 || rightVal > 6) {");
{
cartScript.append("\n");
cartScript.append("rightVal = leftVal;\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("left.update(leftVal, false);\n");
cartScript.append("right.update(rightVal, false);\n");
cartScript.append("chart.redraw();\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", 500);\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("</script>\n");
}
}
