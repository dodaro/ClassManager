package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class AreaInvertedCart extends AbstractCart {
public AreaInvertedCart(){
super();
this.setName("AreaInvertedCart");
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
cartScript.append("inverted: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Average fruit consumption during one week\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("position: \'absolute\',\n");
cartScript.append("right: \'0px\',\n");
cartScript.append("bottom: \'10px\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("layout: \'vertical\',\n");
cartScript.append("align: \'right\',\n");
cartScript.append("verticalAlign: \'top\',\n");
cartScript.append("x: -150,\n");
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
cartScript.append("categories: [\n");
cartScript.append("\'Monday\',\n");
cartScript.append("\'Tuesday\',\n");
cartScript.append("\'Wednesday\',\n");
cartScript.append("\'Thursday\',\n");
cartScript.append("\'Friday\',\n");
cartScript.append("\'Saturday\',\n");
cartScript.append("\'Sunday\'\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Number of units\'\n");
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
cartScript.append(",\n");
cartScript.append("min: 0\n");
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
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'John\',\n");
cartScript.append("data: [3, 4, 3, 5, 4, 10, 12]\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Jane\',\n");
cartScript.append("data: [1, 3, 4, 3, 3, 5, 4]\n");
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
