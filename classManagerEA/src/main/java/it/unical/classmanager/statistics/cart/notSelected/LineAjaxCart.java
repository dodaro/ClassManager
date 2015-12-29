package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class LineAjaxCart extends AbstractCart {
public LineAjaxCart(){
super();
this.setName("LineAjaxCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("// Get the CSV and create the chart\n");
cartScript.append("$.getJSON(\'https://www.highcharts.com/samples/data/jsonp.php?filename=analytics.csv&callback=?\', function (csv) {");
{
cartScript.append("\n");
cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
{
cartScript.append("data: {");
{
cartScript.append("\n");
cartScript.append("csv: csv\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Daily visits at www.highcharts.com\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'Source: Google Analytics\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("tickInterval: 7 * 24 * 3600 * 1000, // one week\n");
cartScript.append("tickWidth: 0,\n");
cartScript.append("gridLineWidth: 1,\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("align: \'left\',\n");
cartScript.append("x: 3,\n");
cartScript.append("y: -3\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: [{");
{
cartScript.append(" // left y axis\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: null\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("align: \'left\',\n");
cartScript.append("x: 3,\n");
cartScript.append("y: 16,\n");
cartScript.append("format: \'{");
{
cartScript.append("value:.,0f}");
}
cartScript.append("\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("showFirstLabel: false\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append(" // right y axis\n");
cartScript.append("linkedTo: 0,\n");
cartScript.append("gridLineWidth: 0,\n");
cartScript.append("opposite: true,\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: null\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("align: \'right\',\n");
cartScript.append("x: -3,\n");
cartScript.append("y: 16,\n");
cartScript.append("format: \'{");
{
cartScript.append("value:.,0f}");
}
cartScript.append("\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("showFirstLabel: false\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("align: \'left\',\n");
cartScript.append("verticalAlign: \'top\',\n");
cartScript.append("y: 20,\n");
cartScript.append("floating: true,\n");
cartScript.append("borderWidth: 0\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("shared: true,\n");
cartScript.append("crosshairs: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("series: {");
{
cartScript.append("\n");
cartScript.append("cursor: \'pointer\',\n");
cartScript.append("point: {");
{
cartScript.append("\n");
cartScript.append("events: {");
{
cartScript.append("\n");
cartScript.append("click: function (e) {");
{
cartScript.append("\n");
cartScript.append("hs.htmlExpand(null, {");
{
cartScript.append("\n");
cartScript.append("pageOrigin: {");
{
cartScript.append("\n");
cartScript.append("x: e.pageX || e.clientX,\n");
cartScript.append("y: e.pageY || e.clientY\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("headingText: this.series.name,\n");
cartScript.append("maincontentText: Highcharts.dateFormat(\'%A, %b %e, %Y\', this.x) + \':<br/> \' +\n");
cartScript.append("this.y + \' visits\',\n");
cartScript.append("width: 200\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
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
cartScript.append("name: \'All visits\',\n");
cartScript.append("lineWidth: 4,\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("radius: 4\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'New visitors\'\n");
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
