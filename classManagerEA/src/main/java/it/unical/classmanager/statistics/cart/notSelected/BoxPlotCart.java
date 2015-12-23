package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class BoxPlotCart extends AbstractCart {
public BoxPlotCart(){
super();
this.setName("BoxPlotCart");
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
cartScript.append("type: \'boxplot\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Highcharts Box Plot Example\'\n");
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
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\'1\', \'2\', \'3\', \'4\', \'5\'],\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Experiment No.\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Observations\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotLines: [{");
{
cartScript.append("\n");
cartScript.append("value: 932,\n");
cartScript.append("color: \'red\',\n");
cartScript.append("width: 1,\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'Theoretical mean: 932\',\n");
cartScript.append("align: \'center\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'gray\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Observations\',\n");
cartScript.append("data: [\n");
cartScript.append("[760, 801, 848, 895, 965],\n");
cartScript.append("[733, 853, 939, 980, 1080],\n");
cartScript.append("[714, 762, 817, 870, 918],\n");
cartScript.append("[724, 802, 806, 871, 950],\n");
cartScript.append("[834, 836, 864, 882, 910]\n");
cartScript.append("],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("headerFormat: \'<em>Experiment No {");
{
cartScript.append("point.key}");
}
cartScript.append("</em><br/>\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Outlier\',\n");
cartScript.append("color: Highcharts.getOptions().colors[0],\n");
cartScript.append("type: \'scatter\',\n");
cartScript.append("data: [ // x, y positions where 0 is the first category\n");
cartScript.append("[0, 644],\n");
cartScript.append("[4, 718],\n");
cartScript.append("[4, 951],\n");
cartScript.append("[4, 969]\n");
cartScript.append("],\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("fillColor: \'white\',\n");
cartScript.append("lineWidth: 1,\n");
cartScript.append("lineColor: Highcharts.getOptions().colors[0]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("pointFormat: \'Observation: {");
{
cartScript.append("point.y}");
}
cartScript.append("\'\n");
cartScript.append("}");
}
cartScript.append("\n");
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
