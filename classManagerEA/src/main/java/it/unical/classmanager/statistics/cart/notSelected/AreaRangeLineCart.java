package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class AreaRangeLineCart extends AbstractCart {
public AreaRangeLineCart(){
super();
this.setName("AreaRangeLineCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("var ranges = [\n");
cartScript.append("[1246406400000, 14.3, 27.7],\n");
cartScript.append("[1246492800000, 14.5, 27.8],\n");
cartScript.append("[1246579200000, 15.5, 29.6],\n");
cartScript.append("[1246665600000, 16.7, 30.7],\n");
cartScript.append("[1246752000000, 16.5, 25.0],\n");
cartScript.append("[1246838400000, 17.8, 25.7],\n");
cartScript.append("[1246924800000, 13.5, 24.8],\n");
cartScript.append("[1247011200000, 10.5, 21.4],\n");
cartScript.append("[1247097600000, 9.2, 23.8],\n");
cartScript.append("[1247184000000, 11.6, 21.8],\n");
cartScript.append("[1247270400000, 10.7, 23.7],\n");
cartScript.append("[1247356800000, 11.0, 23.3],\n");
cartScript.append("[1247443200000, 11.6, 23.7],\n");
cartScript.append("[1247529600000, 11.8, 20.7],\n");
cartScript.append("[1247616000000, 12.6, 22.4],\n");
cartScript.append("[1247702400000, 13.6, 19.6],\n");
cartScript.append("[1247788800000, 11.4, 22.6],\n");
cartScript.append("[1247875200000, 13.2, 25.0],\n");
cartScript.append("[1247961600000, 14.2, 21.6],\n");
cartScript.append("[1248048000000, 13.1, 17.1],\n");
cartScript.append("[1248134400000, 12.2, 15.5],\n");
cartScript.append("[1248220800000, 12.0, 20.8],\n");
cartScript.append("[1248307200000, 12.0, 17.1],\n");
cartScript.append("[1248393600000, 12.7, 18.3],\n");
cartScript.append("[1248480000000, 12.4, 19.4],\n");
cartScript.append("[1248566400000, 12.6, 19.9],\n");
cartScript.append("[1248652800000, 11.9, 20.2],\n");
cartScript.append("[1248739200000, 11.0, 19.3],\n");
cartScript.append("[1248825600000, 10.8, 17.8],\n");
cartScript.append("[1248912000000, 11.8, 18.5],\n");
cartScript.append("[1248998400000, 10.8, 16.1]\n");
cartScript.append("],\n");
cartScript.append("averages = [\n");
cartScript.append("[1246406400000, 21.5],\n");
cartScript.append("[1246492800000, 22.1],\n");
cartScript.append("[1246579200000, 23],\n");
cartScript.append("[1246665600000, 23.8],\n");
cartScript.append("[1246752000000, 21.4],\n");
cartScript.append("[1246838400000, 21.3],\n");
cartScript.append("[1246924800000, 18.3],\n");
cartScript.append("[1247011200000, 15.4],\n");
cartScript.append("[1247097600000, 16.4],\n");
cartScript.append("[1247184000000, 17.7],\n");
cartScript.append("[1247270400000, 17.5],\n");
cartScript.append("[1247356800000, 17.6],\n");
cartScript.append("[1247443200000, 17.7],\n");
cartScript.append("[1247529600000, 16.8],\n");
cartScript.append("[1247616000000, 17.7],\n");
cartScript.append("[1247702400000, 16.3],\n");
cartScript.append("[1247788800000, 17.8],\n");
cartScript.append("[1247875200000, 18.1],\n");
cartScript.append("[1247961600000, 17.2],\n");
cartScript.append("[1248048000000, 14.4],\n");
cartScript.append("[1248134400000, 13.7],\n");
cartScript.append("[1248220800000, 15.7],\n");
cartScript.append("[1248307200000, 14.6],\n");
cartScript.append("[1248393600000, 15.3],\n");
cartScript.append("[1248480000000, 15.3],\n");
cartScript.append("[1248566400000, 15.8],\n");
cartScript.append("[1248652800000, 15.2],\n");
cartScript.append("[1248739200000, 14.8],\n");
cartScript.append("[1248825600000, 14.4],\n");
cartScript.append("[1248912000000, 15],\n");
cartScript.append("[1248998400000, 13.6]\n");
cartScript.append("];\n");
cartScript.append("$('#"+getIdContainer()+"').highcharts({\n");
{
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'July temperatures\'\n");
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
cartScript.append("text: null\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("crosshairs: true,\n");
cartScript.append("shared: true,\n");
cartScript.append("valueSuffix: \'°C\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("legend: {");
{
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("series: [{");
{
cartScript.append("\n");
cartScript.append("name: \'Temperature\',\n");
cartScript.append("data: averages,\n");
cartScript.append("zIndex: 1,\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("fillColor: \'white\',\n");
cartScript.append("lineWidth: 2,\n");
cartScript.append("lineColor: Highcharts.getOptions().colors[0]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Range\',\n");
cartScript.append("data: ranges,\n");
cartScript.append("type: \'arearange\',\n");
cartScript.append("lineWidth: 0,\n");
cartScript.append("linkedTo: \':previous\',\n");
cartScript.append("color: Highcharts.getOptions().colors[0],\n");
cartScript.append("fillOpacity: 0.3,\n");
cartScript.append("zIndex: 0\n");
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
