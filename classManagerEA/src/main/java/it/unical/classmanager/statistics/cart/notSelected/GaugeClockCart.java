package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class GaugeClockCart extends AbstractCart {
public GaugeClockCart(){
super();
this.setName("GaugeClockCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("/**\n");
cartScript.append("* Get the current time\n");
cartScript.append("*/\n");
cartScript.append("function getNow() {");
{
cartScript.append("\n");
cartScript.append("var now = new Date();\n");
cartScript.append("return {");
{
cartScript.append("\n");
cartScript.append("hours: now.getHours() + now.getMinutes() / 60,\n");
cartScript.append("minutes: now.getMinutes() * 12 / 60 + now.getSeconds() * 12 / 3600,\n");
cartScript.append("seconds: now.getSeconds() * 12 / 60\n");
cartScript.append("}");
}
cartScript.append(";\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("/**\n");
cartScript.append("* Pad numbers\n");
cartScript.append("*/\n");
cartScript.append("function pad(number, length) {");
{
cartScript.append("\n");
cartScript.append("// Create an array of the remaining length + 1 and join it with 0\'s\n");
cartScript.append("return new Array((length || 2) + 1 - String(number).length).join(0) + number;\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("var now = getNow();\n");
cartScript.append("// Create the chart\n");
cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
{
cartScript.append("chart: {");
{
cartScript.append("\n");
cartScript.append("type: \'gauge\',\n");
cartScript.append("plotBackgroundColor: null,\n");
cartScript.append("plotBackgroundImage: null,\n");
cartScript.append("plotBorderWidth: 0,\n");
cartScript.append("plotShadow: false,\n");
cartScript.append("height: 200\n");
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
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'The Highcharts clock\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("pane: {");
{
cartScript.append("\n");
cartScript.append("background: [{");
{
cartScript.append("\n");
cartScript.append("// default background\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("// reflex for supported browsers\n");
cartScript.append("backgroundColor: Highcharts.svg ? {");
{
cartScript.append("\n");
cartScript.append("radialGradient: {");
{
cartScript.append("\n");
cartScript.append("cx: 0.5,\n");
cartScript.append("cy: -0.4,\n");
cartScript.append("r: 1.9\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("stops: [\n");
cartScript.append("[0.5, \'rgba(255, 255, 255, 0.2)\'],\n");
cartScript.append("[0.5, \'rgba(200, 200, 200, 0.2)\']\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(" : null\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("distance: -20\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("min: 0,\n");
cartScript.append("max: 12,\n");
cartScript.append("lineWidth: 0,\n");
cartScript.append("showFirstLabel: false,\n");
cartScript.append("minorTickInterval: \'auto\',\n");
cartScript.append("minorTickWidth: 1,\n");
cartScript.append("minorTickLength: 5,\n");
cartScript.append("minorTickPosition: \'inside\',\n");
cartScript.append("minorGridLineWidth: 0,\n");
cartScript.append("minorTickColor: \'#666\',\n");
cartScript.append("tickInterval: 1,\n");
cartScript.append("tickWidth: 2,\n");
cartScript.append("tickPosition: \'inside\',\n");
cartScript.append("tickLength: 10,\n");
cartScript.append("tickColor: \'#666\',\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Powered by<br/>Highcharts\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#BBB\',\n");
cartScript.append("fontWeight: \'normal\',\n");
cartScript.append("fontSize: \'8px\',\n");
cartScript.append("lineHeight: \'10px\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("y: 10\n");
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
cartScript.append("return this.series.chart.tooltipText;\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("data: [{");
{
cartScript.append("\n");
cartScript.append("id: \'hour\',\n");
cartScript.append("y: now.hours,\n");
cartScript.append("dial: {");
{
cartScript.append("\n");
cartScript.append("radius: \'60%\',\n");
cartScript.append("baseWidth: 4,\n");
cartScript.append("baseLength: \'95%\',\n");
cartScript.append("rearLength: 0\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("id: \'minute\',\n");
cartScript.append("y: now.minutes,\n");
cartScript.append("dial: {");
{
cartScript.append("\n");
cartScript.append("baseLength: \'95%\',\n");
cartScript.append("rearLength: 0\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("id: \'second\',\n");
cartScript.append("y: now.seconds,\n");
cartScript.append("dial: {");
{
cartScript.append("\n");
cartScript.append("radius: \'100%\',\n");
cartScript.append("baseWidth: 1,\n");
cartScript.append("rearLength: \'20%\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("animation: false,\n");
cartScript.append("dataLabels: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("// Move\n");
cartScript.append("function (chart) {");
{
cartScript.append("\n");
cartScript.append("setInterval(function () {");
{
cartScript.append("\n");
cartScript.append("now = getNow();\n");
cartScript.append("var hour = chart.get(\'hour\'),\n");
cartScript.append("minute = chart.get(\'minute\'),\n");
cartScript.append("second = chart.get(\'second\'),\n");
cartScript.append("// run animation unless we\'re wrapping around from 59 to 0\n");
cartScript.append("animation = now.seconds === 0 ?\n");
cartScript.append("false :\n");
cartScript.append("{");
{
cartScript.append("\n");
cartScript.append("easing: \'easeOutBounce\'\n");
cartScript.append("}");
}
cartScript.append(";\n");
cartScript.append("// Cache the tooltip text\n");
cartScript.append("chart.tooltipText =\n");
cartScript.append("pad(Math.floor(now.hours), 2) + \':\' +\n");
cartScript.append("pad(Math.floor(now.minutes * 5), 2) + \':\' +\n");
cartScript.append("pad(now.seconds * 5, 2);\n");
cartScript.append("hour.update(now.hours, true, animation);\n");
cartScript.append("minute.update(now.minutes, true, animation);\n");
cartScript.append("second.update(now.seconds, true, animation);\n");
cartScript.append("}");
}
cartScript.append(", 1000);\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("/**\n");
cartScript.append("* Easing function from https://github.com/danro/easing-js/blob/master/easing.js\n");
cartScript.append("*/\n");
cartScript.append("Math.easeOutBounce = function (pos) {");
{
cartScript.append("\n");
cartScript.append("if ((pos) < (1 / 2.75)) {");
{
cartScript.append("\n");
cartScript.append("return (7.5625 * pos * pos);\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("if (pos < (2 / 2.75)) {");
{
cartScript.append("\n");
cartScript.append("return (7.5625 * (pos -= (1.5 / 2.75)) * pos + 0.75);\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("if (pos < (2.5 / 2.75)) {");
{
cartScript.append("\n");
cartScript.append("return (7.5625 * (pos -= (2.25 / 2.75)) * pos + 0.9375);\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("return (7.5625 * (pos -= (2.625 / 2.75)) * pos + 0.984375);\n");
cartScript.append("}");
}
cartScript.append(";\n");
cartScript.append("</script>\n");
}
}
