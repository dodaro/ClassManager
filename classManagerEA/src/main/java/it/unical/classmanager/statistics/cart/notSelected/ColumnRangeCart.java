package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class ColumnRangeCart extends AbstractCart {
public ColumnRangeCart(){
super();
this.setName("ColumnRangeCart");
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
cartScript.append("type: \'columnrange\',\n");
cartScript.append("inverted: true\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Temperature variation by month\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("subtitle: {");
{
cartScript.append("\n");
cartScript.append("text: \'Observed in Vik i Sogn, Norway\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("categories: [\'Jan\', \'Feb\', \'Mar\', \'Apr\', \'May\', \'Jun\', \'Jul\', \'Aug\', \'Sep\', \'Oct\', \'Nov\', \'Dec\']\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: {");
{
cartScript.append("\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Temperature ( °C )\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("valueSuffix: \'°C\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("columnrange: {");
{
cartScript.append("\n");
cartScript.append("dataLabels: {");
{
cartScript.append("\n");
cartScript.append("enabled: true,\n");
cartScript.append("formatter: function () {");
{
cartScript.append("\n");
cartScript.append("return this.y + \'°C\';\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
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
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Temperatures\',\n");
cartScript.append("data: [\n");
cartScript.append("[-9.7, 9.4],\n");
cartScript.append("[-8.7, 6.5],\n");
cartScript.append("[-3.5, 9.4],\n");
cartScript.append("[-1.4, 19.9],\n");
cartScript.append("[0.0, 22.6],\n");
cartScript.append("[2.9, 29.5],\n");
cartScript.append("[9.2, 30.7],\n");
cartScript.append("[7.3, 26.5],\n");
cartScript.append("[4.4, 18.0],\n");
cartScript.append("[-3.1, 11.4],\n");
cartScript.append("[-5.2, 10.4],\n");
cartScript.append("[-13.5, 9.8]\n");
cartScript.append("]\n");
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
