package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class WaterfallCart extends AbstractCart {
public WaterfallCart(){
super();
this.setName("WaterfallCart");
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
cartScript.append("type: \'waterfall\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Highcharts Waterfall\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("type: \'category\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'USD\'\n");
cartScript.append("}");
}
cartScript.append("\n");
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
cartScript.append("pointFormat: \'<b>${");
{
cartScript.append("point.y:,.2f}");
}
cartScript.append("</b> USD\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("upColor: Highcharts.getOptions().colors[2],\n");
cartScript.append("color: Highcharts.getOptions().colors[3],\n");
cartScript.append("data: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Start\',\n");
cartScript.append("y: 120000\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Product Revenue\',\n");
cartScript.append("y: 569000\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Service Revenue\',\n");
cartScript.append("y: 231000\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Positive Balance\',\n");
cartScript.append("isIntermediateSum: true,\n");
cartScript.append("color: Highcharts.getOptions().colors[1]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Fixed Costs\',\n");
cartScript.append("y: -342000\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Variable Costs\',\n");
cartScript.append("y: -233000\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Balance\',\n");
cartScript.append("isSum: true,\n");
cartScript.append("color: Highcharts.getOptions().colors[1]\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("dataLabels: {");
{
cartScript.append("\n");
cartScript.append("enabled: true,\n");
cartScript.append("formatter: function () {");
{
cartScript.append("\n");
cartScript.append("return Highcharts.numberFormat(this.y / 1000, 0, \',\') + \'k\';\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#FFFFFF\',\n");
cartScript.append("fontWeight: \'bold\',\n");
cartScript.append("textShadow: \'0px 0px 3px black\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("pointPadding: 0\n");
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
