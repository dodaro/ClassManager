package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class GaugeDualCart extends AbstractCart {
public GaugeDualCart(){
super();
this.setName("GaugeDualCart");
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
cartScript.append("alignTicks: false,\n");
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
cartScript.append("text: \'Speedometer with dual axes\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("pane: {");
{
cartScript.append("\n");
cartScript.append("startAngle: -150,\n");
cartScript.append("endAngle: 150\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: [{");
{
cartScript.append("\n");
cartScript.append("min: 0,\n");
cartScript.append("max: 200,\n");
cartScript.append("lineColor: \'#339\',\n");
cartScript.append("tickColor: \'#339\',\n");
cartScript.append("minorTickColor: \'#339\',\n");
cartScript.append("offset: -25,\n");
cartScript.append("lineWidth: 2,\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("distance: -20,\n");
cartScript.append("rotation: \'auto\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tickLength: 5,\n");
cartScript.append("minorTickLength: 5,\n");
cartScript.append("endOnTick: false\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("min: 0,\n");
cartScript.append("max: 124,\n");
cartScript.append("tickPosition: \'outside\',\n");
cartScript.append("lineColor: \'#933\',\n");
cartScript.append("lineWidth: 2,\n");
cartScript.append("minorTickPosition: \'outside\',\n");
cartScript.append("tickColor: \'#933\',\n");
cartScript.append("minorTickColor: \'#933\',\n");
cartScript.append("tickLength: 5,\n");
cartScript.append("minorTickLength: 5,\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("distance: 12,\n");
cartScript.append("rotation: \'auto\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("offset: -20,\n");
cartScript.append("endOnTick: false\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Speed\',\n");
cartScript.append("data: [80],\n");
cartScript.append("dataLabels: {");
{
cartScript.append("\n");
cartScript.append("formatter: function () {");
{
cartScript.append("\n");
cartScript.append("var kmh = this.y,\n");
cartScript.append("mph = Math.round(kmh * 0.621);\n");
cartScript.append("return \'<span style=\"color:#339\">\' + kmh + \' km/h</span><br/>\' +\n");
cartScript.append("\'<span style=\"color:#933\">\' + mph + \' mph</span>\';\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("backgroundColor: {");
{
cartScript.append("\n");
cartScript.append("linearGradient: {");
{
cartScript.append("\n");
cartScript.append("x1: 0,\n");
cartScript.append("y1: 0,\n");
cartScript.append("x2: 0,\n");
cartScript.append("y2: 1\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("stops: [\n");
cartScript.append("[0, \'#DDD\'],\n");
cartScript.append("[1, \'#FFF\']\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
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
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("</script>\n");
}
}
