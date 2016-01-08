package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class GaugeSpeedometerCart extends AbstractCart {
public GaugeSpeedometerCart(){
super();
this.setName("GaugeSpeedometerCart");
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
cartScript.append("plotBackgroundColor: null,\n");
cartScript.append("plotBackgroundImage: null,\n");
cartScript.append("plotBorderWidth: 0,\n");
cartScript.append("plotShadow: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Speedometer\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("pane: {");
{
cartScript.append("\n");
cartScript.append("startAngle: -150,\n");
cartScript.append("endAngle: 150,\n");
cartScript.append("background: [{");
{
cartScript.append("\n");
cartScript.append("backgroundColor: {");
{
cartScript.append("\n");
cartScript.append("linearGradient: {");
{
cartScript.append(" x1: 0, y1: 0, x2: 0, y2: 1 }");
}
cartScript.append(",\n");
cartScript.append("stops: [\n");
cartScript.append("[0, \'#FFF\'],\n");
cartScript.append("[1, \'#333\']\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("borderWidth: 0,\n");
cartScript.append("outerRadius: \'109%\'\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("backgroundColor: {");
{
cartScript.append("\n");
cartScript.append("linearGradient: {");
{
cartScript.append(" x1: 0, y1: 0, x2: 0, y2: 1 }");
}
cartScript.append(",\n");
cartScript.append("stops: [\n");
cartScript.append("[0, \'#333\'],\n");
cartScript.append("[1, \'#FFF\']\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("borderWidth: 1,\n");
cartScript.append("outerRadius: \'107%\'\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("// default background\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("backgroundColor: \'#DDD\',\n");
cartScript.append("borderWidth: 0,\n");
cartScript.append("outerRadius: \'105%\',\n");
cartScript.append("innerRadius: \'103%\'\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("// the value axis\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("min: 0,\n");
cartScript.append("max: 200,\n");
cartScript.append("minorTickInterval: \'auto\',\n");
cartScript.append("minorTickWidth: 1,\n");
cartScript.append("minorTickLength: 10,\n");
cartScript.append("minorTickPosition: \'inside\',\n");
cartScript.append("minorTickColor: \'#666\',\n");
cartScript.append("tickPixelInterval: 30,\n");
cartScript.append("tickWidth: 2,\n");
cartScript.append("tickPosition: \'inside\',\n");
cartScript.append("tickLength: 10,\n");
cartScript.append("tickColor: \'#666\',\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("step: 2,\n");
cartScript.append("rotation: \'auto\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'km/h\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotBands: [{");
{
cartScript.append("\n");
cartScript.append("from: 0,\n");
cartScript.append("to: 120,\n");
cartScript.append("color: \'#55BF3B\' // green\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("from: 120,\n");
cartScript.append("to: 160,\n");
cartScript.append("color: \'#DDDF0D\' // yellow\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("from: 160,\n");
cartScript.append("to: 200,\n");
cartScript.append("color: \'#DF5353\' // red\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Speed\',\n");
cartScript.append("data: [80],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("valueSuffix: \' km/h\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("// Add some life\n");
cartScript.append("function (chart) {");
{
cartScript.append("\n");
cartScript.append("if (!chart.renderer.forExport) {");
{
cartScript.append("\n");
cartScript.append("setInterval(function () {");
{
cartScript.append("\n");
cartScript.append("var point = chart.series[0].points[0],\n");
cartScript.append("newVal,\n");
cartScript.append("inc = Math.round((Math.random() - 0.5) * 20);\n");
cartScript.append("newVal = point.y + inc;\n");
cartScript.append("if (newVal < 0 || newVal > 200) {");
{
cartScript.append("\n");
cartScript.append("newVal = point.y - inc;\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("point.update(newVal);\n");
cartScript.append("}");
}
cartScript.append(", 3000);\n");
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
