package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class LineTimeSeriesCart extends AbstractCart {
public LineTimeSeriesCart(){
super();
this.setName("LineTimeSeriesCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("$.getJSON(\'https://www.highcharts.com/samples/data/jsonp.php?filename=usdeur.json&callback=?\', function (data) {");
{
cartScript.append("\n");
cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
{
cartScript.append("chart: {");
{
cartScript.append("\n");
cartScript.append("zoomType: \'x\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'USD to EUR exchange rate over time\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: document.ontouchstart === undefined ?\n");
cartScript.append("\'Click and drag in the plot area to zoom in\' : \'Pinch the chart to zoom in\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("type: \'datetime\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Exchange rate\'\n");
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
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("area: {");
{
cartScript.append("\n");
cartScript.append("fillColor: {");
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
cartScript.append("[0, Highcharts.getOptions().colors[0]],\n");
cartScript.append("[1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get(\'rgba\')]\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("radius: 2\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("lineWidth: 1,\n");
cartScript.append("states: {");
{
cartScript.append("\n");
cartScript.append("hover: {");
{
cartScript.append("\n");
cartScript.append("lineWidth: 1\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("threshold: null\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("type: \'area\',\n");
cartScript.append("name: \'USD to EUR\',\n");
cartScript.append("data: data\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("</script>\n");
}
}
