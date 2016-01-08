package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class AreaMissingCart extends AbstractCart {
public AreaMissingCart(){
super();
this.setName("AreaMissingCart");
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
cartScript.append("type: \'area\',\n");
cartScript.append("spacingBottom: 30\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Fruit consumption *\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'* Jane\\'s banana consumption is unknown\',\n");
cartScript.append("floating: true,\n");
cartScript.append("align: \'right\',\n");
cartScript.append("verticalAlign: \'bottom\',\n");
cartScript.append("y: 15\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("layout: \'vertical\',\n");
cartScript.append("align: \'left\',\n");
cartScript.append("verticalAlign: \'top\',\n");
cartScript.append("x: 150,\n");
cartScript.append("y: 100,\n");
cartScript.append("floating: true,\n");
cartScript.append("borderWidth: 1,\n");
cartScript.append("backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || \'#FFFFFF\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\'Apples\', \'Pears\', \'Oranges\', \'Bananas\', \'Grapes\', \'Plums\', \'Strawberries\', \'Raspberries\']\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Y-Axis\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("formatter: function () {");
{
cartScript.append("\n");
cartScript.append("return this.value;\n");
cartScript.append("}");
}
cartScript.append("\n");
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
cartScript.append("return \'<b>\' + this.series.name + \'</b><br/>\' +\n");
cartScript.append("this.x + \': \' + this.y;\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("area: {");
{
cartScript.append("\n");
cartScript.append("fillOpacity: 0.5\n");
cartScript.append("}");
}
cartScript.append("\n");
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
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'John\',\n");
cartScript.append("data: [0, 1, 4, 4, 5, 2, 3, 7]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Jane\',\n");
cartScript.append("data: [1, 0, 3, null, 3, 1, 2, 1]\n");
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
