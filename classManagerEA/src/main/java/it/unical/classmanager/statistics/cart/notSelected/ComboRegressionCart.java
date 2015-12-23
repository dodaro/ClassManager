package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class ComboRegressionCart extends AbstractCart {
public ComboRegressionCart(){
super();
this.setName("ComboRegressionCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
{
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("min: -0.5,\n");
cartScript.append("max: 5.5\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("min: 0\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Scatter plot with regression line\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("type: \'line\',\n");
cartScript.append("name: \'Regression Line\',\n");
cartScript.append("data: [[0, 1.11], [5, 4.51]],\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("states: {");
{
cartScript.append("\n");
cartScript.append("hover: {");
{
cartScript.append("\n");
cartScript.append("lineWidth: 0\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("enableMouseTracking: false\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("type: \'scatter\',\n");
cartScript.append("name: \'Observations\',\n");
cartScript.append("data: [1, 1.5, 2.8, 3.5, 3.9, 4.2],\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("radius: 4\n");
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
