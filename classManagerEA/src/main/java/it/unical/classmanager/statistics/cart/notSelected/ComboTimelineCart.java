package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

/**
* @author Aloisius92
* This is a cart class type.
*/
public class ComboTimelineCart extends AbstractCart {
public ComboTimelineCart(){
super();
this.setName("ComboTimelineCart");
}

@Override
protected void buildCart() {
cartScript = new StringBuilder("");
cartScript.append("<script type=\"text/javascript\">\n");
cartScript.append("/**\n");
cartScript.append("* This is an advanced demo of setting up Highcharts with the flags feature borrowed from Highstock.\n");
cartScript.append("* It also shows custom graphics drawn in the chart area on chart load.\n");
cartScript.append("*/\n");
cartScript.append("/**\n");
cartScript.append("* Fires on chart load, called from the chart.events.load option.\n");
cartScript.append("*/\n");
cartScript.append("function onChartLoad() {");
{
cartScript.append("\n");
cartScript.append("var centerX = 140,\n");
cartScript.append("centerY = 110,\n");
cartScript.append("path = [],\n");
cartScript.append("angle,\n");
cartScript.append("radius,\n");
cartScript.append("badgeColor = Highcharts.Color(Highcharts.getOptions().colors[0]).brighten(-0.2).get(),\n");
cartScript.append("spike,\n");
cartScript.append("empImage,\n");
cartScript.append("big5,\n");
cartScript.append("label,\n");
cartScript.append("left,\n");
cartScript.append("right,\n");
cartScript.append("years,\n");
cartScript.append("renderer;\n");
cartScript.append("if (this.chartWidth < 530) {");
{
cartScript.append("\n");
cartScript.append("return;\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("// Draw the spiked disc\n");
cartScript.append("for (angle = 0; angle < 2 * Math.PI; angle += Math.PI / 24) {");
{
cartScript.append("\n");
cartScript.append("radius = spike ? 80 : 70;\n");
cartScript.append("path.push(\n");
cartScript.append("\'L\',\n");
cartScript.append("centerX + radius * Math.cos(angle),\n");
cartScript.append("centerY + radius * Math.sin(angle)\n");
cartScript.append(");\n");
cartScript.append("spike = !spike;\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("path[0] = \'M\';\n");
cartScript.append("path.push(\'z\');\n");
cartScript.append("this.renderer.path(path)\n");
cartScript.append(".attr({");
{
cartScript.append("\n");
cartScript.append("fill: badgeColor,\n");
cartScript.append("zIndex: 6\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".add();\n");
cartScript.append("// Employee image overlay\n");
cartScript.append("empImage = this.renderer.path(path)\n");
cartScript.append(".attr({");
{
cartScript.append("\n");
cartScript.append("zIndex: 7,\n");
cartScript.append("opacity: 0,\n");
cartScript.append("stroke: badgeColor,\n");
cartScript.append("\'stroke-width\': 1\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".add();\n");
cartScript.append("// Big 5\n");
cartScript.append("big5 = this.renderer.text(\'5\')\n");
cartScript.append(".attr({");
{
cartScript.append("\n");
cartScript.append("zIndex: 6\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".css({");
{
cartScript.append("\n");
cartScript.append("color: \'white\',\n");
cartScript.append("fontSize: \'100px\',\n");
cartScript.append("fontStyle: \'italic\',\n");
cartScript.append("fontFamily: \'\\'Brush Script MT\\', sans-serif\'\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".add();\n");
cartScript.append("big5.attr({");
{
cartScript.append("\n");
cartScript.append("x: centerX - big5.getBBox().width / 2,\n");
cartScript.append("y: centerY + 14\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("// Draw the label\n");
cartScript.append("label = this.renderer.text(\'Highcharts Anniversary\')\n");
cartScript.append(".attr({");
{
cartScript.append("\n");
cartScript.append("zIndex: 6\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".css({");
{
cartScript.append("\n");
cartScript.append("color: \'#FFFFFF\'\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".add();\n");
cartScript.append("left = centerX - label.getBBox().width / 2;\n");
cartScript.append("right = centerX + label.getBBox().width / 2;\n");
cartScript.append("label.attr({");
{
cartScript.append("\n");
cartScript.append("x: left,\n");
cartScript.append("y: centerY + 44\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("// The band\n");
cartScript.append("left = centerX - 90;\n");
cartScript.append("right = centerX + 90;\n");
cartScript.append("this.renderer\n");
cartScript.append(".path([\n");
cartScript.append("\'M\', left, centerY + 30,\n");
cartScript.append("\'L\', right, centerY + 30,\n");
cartScript.append("right, centerY + 50,\n");
cartScript.append("left, centerY + 50,\n");
cartScript.append("\'z\',\n");
cartScript.append("\'M\', left, centerY + 40,\n");
cartScript.append("\'L\', left - 20, centerY + 40,\n");
cartScript.append("left - 10, centerY + 50,\n");
cartScript.append("left - 20, centerY + 60,\n");
cartScript.append("left + 10, centerY + 60,\n");
cartScript.append("left, centerY + 50,\n");
cartScript.append("left + 10, centerY + 60,\n");
cartScript.append("left + 10, centerY + 50,\n");
cartScript.append("left, centerY + 50,\n");
cartScript.append("\'z\',\n");
cartScript.append("\'M\', right, centerY + 40,\n");
cartScript.append("\'L\', right + 20, centerY + 40,\n");
cartScript.append("right + 10, centerY + 50,\n");
cartScript.append("right + 20, centerY + 60,\n");
cartScript.append("right - 10, centerY + 60,\n");
cartScript.append("right, centerY + 50,\n");
cartScript.append("right - 10, centerY + 60,\n");
cartScript.append("right - 10, centerY + 50,\n");
cartScript.append("right, centerY + 50,\n");
cartScript.append("\'z\'\n");
cartScript.append("])\n");
cartScript.append(".attr({");
{
cartScript.append("\n");
cartScript.append("fill: badgeColor,\n");
cartScript.append("stroke: \'#FFFFFF\',\n");
cartScript.append("\'stroke-width\': 1,\n");
cartScript.append("zIndex: 5\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".add();\n");
cartScript.append("// 2009-2014\n");
cartScript.append("years = this.renderer.text(\'2009-2014\')\n");
cartScript.append(".attr({");
{
cartScript.append("\n");
cartScript.append("zIndex: 6\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".css({");
{
cartScript.append("\n");
cartScript.append("color: \'#FFFFFF\',\n");
cartScript.append("fontStyle: \'italic\',\n");
cartScript.append("fontSize: \'10px\'\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".add();\n");
cartScript.append("years.attr({");
{
cartScript.append("\n");
cartScript.append("x: centerX - years.getBBox().width / 2,\n");
cartScript.append("y: centerY + 62\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("// Prepare mouseover\n");
cartScript.append("renderer = this.renderer;\n");
cartScript.append("if (renderer.defs) {");
{
cartScript.append(" // is SVG\n");
cartScript.append("$.each(this.get(\'employees\').points, function () {");
{
cartScript.append("\n");
cartScript.append("var point = this,\n");
cartScript.append("pattern;\n");
cartScript.append("if (point.image) {");
{
cartScript.append("\n");
cartScript.append("pattern = renderer.createElement(\'pattern\').attr({");
{
cartScript.append("\n");
cartScript.append("id: \'pattern-\' + point.image,\n");
cartScript.append("patternUnits: \'userSpaceOnUse\',\n");
cartScript.append("width: 400,\n");
cartScript.append("height: 400\n");
cartScript.append("}");
}
cartScript.append(").add(renderer.defs);\n");
cartScript.append("renderer.image(\n");
cartScript.append("\'https://www.highcharts.com/images/employees2014/\' + point.image + \'.jpg\',\n");
cartScript.append("centerX - 80,\n");
cartScript.append("centerY - 80,\n");
cartScript.append("160,\n");
cartScript.append("213\n");
cartScript.append(").add(pattern);\n");
cartScript.append("Highcharts.addEvent(point, \'mouseOver\', function () {");
{
cartScript.append("\n");
cartScript.append("empImage\n");
cartScript.append(".attr({");
{
cartScript.append("\n");
cartScript.append("fill: \'url(#pattern-\' + point.image + \')\'\n");
cartScript.append("}");
}
cartScript.append(")\n");
cartScript.append(".animate({");
{
cartScript.append(" opacity: 1 }");
}
cartScript.append(", {");
{
cartScript.append(" duration: 500 }");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("Highcharts.addEvent(point, \'mouseOut\', function () {");
{
cartScript.append("\n");
cartScript.append("empImage.animate({");
{
cartScript.append(" opacity: 0 }");
}
cartScript.append(", {");
{
cartScript.append(" duration: 500 }");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("$(document).ready(function() {\n");
{
cartScript.append("var options = {");
{
cartScript.append("\n");
cartScript.append("chart: {");
{
cartScript.append("\n");
cartScript.append("events: {");
{
cartScript.append("\n");
cartScript.append("load: onChartLoad\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("xAxis: {");
{
cartScript.append("\n");
cartScript.append("type: \'datetime\',\n");
cartScript.append("minTickInterval: 365 * 24 * 36e5,\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("align: \'left\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("plotBands: [{");
{
cartScript.append("\n");
cartScript.append("from: Date.UTC(2009, 10, 27),\n");
cartScript.append("to: Date.UTC(2010, 11, 1),\n");
cartScript.append("color: \'#EFFFFF\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'<em>Offices:</em><br> Torstein\\'s basement\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#999999\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("y: 180\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("from: Date.UTC(2010, 11, 1),\n");
cartScript.append("to: Date.UTC(2013, 9, 1),\n");
cartScript.append("color: \'#FFFFEF\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'<em>Offices:</em><br> Tomtebu\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#999999\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("y: 30\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("from: Date.UTC(2013, 9, 1),\n");
cartScript.append("to: Date.UTC(2014, 10, 27),\n");
cartScript.append("color: \'#FFEFFF\',\n");
cartScript.append("label: {");
{
cartScript.append("\n");
cartScript.append("text: \'<em>Offices:</em><br> VikØrsta\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: \'#999999\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("y: 30\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Highcharts and Highsoft timeline\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("width: \'250px\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("yAxis: [{");
{
cartScript.append("\n");
cartScript.append("max: 100,\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("enabled: false\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("gridLineColor: \'rgba(0, 0, 0, 0.07)\'\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("allowDecimals: false,\n");
cartScript.append("max: 15,\n");
cartScript.append("labels: {");
{
cartScript.append("\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: Highcharts.getOptions().colors[2]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("title: {");
{
cartScript.append("\n");
cartScript.append("text: \'Employees\',\n");
cartScript.append("style: {");
{
cartScript.append("\n");
cartScript.append("color: Highcharts.getOptions().colors[2]\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("opposite: true,\n");
cartScript.append("gridLineWidth: 0\n");
cartScript.append("}");
}
cartScript.append("],\n");
cartScript.append("plotOptions: {");
{
cartScript.append("\n");
cartScript.append("series: {");
{
cartScript.append("\n");
cartScript.append("marker: {");
{
cartScript.append("\n");
cartScript.append("enabled: false,\n");
cartScript.append("symbol: \'circle\',\n");
cartScript.append("radius: 2\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("fillOpacity: 0.5\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("flags: {");
{
cartScript.append("\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("xDateFormat: \'%B %e, %Y\'\n");
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
cartScript.append("type: \'spline\',\n");
cartScript.append("id: \'google-trends\',\n");
cartScript.append("dashStyle: \'dash\',\n");
cartScript.append("name: \'Google search for <em>highcharts</em>\',\n");
cartScript.append("data: [{");
{
cartScript.append(" x: 1258322400000, /* November 2009 */ y: 0 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1260961200000, y: 5 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1263639600000, y: 7 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1266188400000, y: 5 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1268740800000, y: 6 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1271368800000, y: 8 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1274004000000, y: 11 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1276639200000, y: 9 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1279274400000, y: 12 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1281952800000, y: 13 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1284588000000, y: 17 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1287223200000, y: 17 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1289858400000, y: 18 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1292497200000, y: 20 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1295175600000, y: 20 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1297724400000, y: 27 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1300276800000, y: 32 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1302904800000, y: 29 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1305540000000, y: 34 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1308175200000, y: 34 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1310810400000, y: 36 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1313488800000, y: 43 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1316124000000, y: 44 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1318759200000, y: 42 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1321394400000, y: 47 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1324033200000, y: 46 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1326711600000, y: 50 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1329303600000, y: 57 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1331899200000, y: 54 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1334527200000, y: 59 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1337162400000, y: 62 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1339797600000, y: 66 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1342432800000, y: 61 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1345111200000, y: 68 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1347746400000, y: 67 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1350381600000, y: 73 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1353016800000, y: 63 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1355655600000, y: 54 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1358334000000, y: 67 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1360882800000, y: 74 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1363435200000, y: 81 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1366063200000, y: 89 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1368698400000, y: 83 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1371333600000, y: 88 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1373968800000, y: 86 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1376647200000, y: 81 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1379282400000, y: 83 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1381917600000, y: 95 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1384552800000, y: 86 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1387191600000, y: 83 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1389870000000, y: 89 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1392418800000, y: 90 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1394971200000, y: 94 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1397599200000, y: 100 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1400234400000, y: 100 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1402869600000, y: 99 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1405504800000, y: 99 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1408183200000, y: 93 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1410818400000, y: 97 }");
}
cartScript.append(", {");
{
cartScript.append(" x: 1413453600000, y: 98 }");
}
cartScript.append("],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("xDateFormat: \'%B %Y\',\n");
cartScript.append("valueSuffix: \' % of best month\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("name: \'Revenue\',\n");
cartScript.append("id: \'revenue\',\n");
cartScript.append("type: \'area\',\n");
cartScript.append("data: [[1257033600000, 2], [1259625600000, 3], [1262304000000, 2], [1264982400000, 3], [1267401600000, 4], [1270080000000, 4], [1272672000000, 4], [1275350400000, 4], [1277942400000, 5], [1280620800000, 7], [1283299200000, 6], [1285891200000, 9], [1288569600000, 10], [1291161600000, 8], [1293840000000, 10], [1296518400000, 13], [1298937600000, 15], [1301616000000, 14], [1304208000000, 15], [1306886400000, 16], [1309478400000, 22], [1312156800000, 19], [1314835200000, 20], [1317427200000, 32], [1320105600000, 34], [1322697600000, 36], [1325376000000, 34], [1328054400000, 40], [1330560000000, 37], [1333238400000, 35], [1335830400000, 40], [1338508800000, 38], [1341100800000, 39], [1343779200000, 43], [1346457600000, 49], [1349049600000, 43], [1351728000000, 54], [1354320000000, 44], [1356998400000, 43], [1359676800000, 43], [1362096000000, 52], [1364774400000, 52], [1367366400000, 56], [1370044800000, 62], [1372636800000, 66], [1375315200000, 62], [1377993600000, 63], [1380585600000, 60], [1383264000000, 60], [1385856000000, 58], [1388534400000, 65], [1391212800000, 52], [1393632000000, 72], [1396310400000, 57], [1398902400000, 70], [1401580800000, 63], [1404172800000, 65], [1406851200000, 65], [1409529600000, 89], [1412121600000, 100]],\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("xDateFormat: \'%B %Y\',\n");
cartScript.append("valueSuffix: \' % of best month\'\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("yAxis: 1,\n");
cartScript.append("name: \'Highsoft employees\',\n");
cartScript.append("id: \'employees\',\n");
cartScript.append("type: \'area\',\n");
cartScript.append("step: \'left\',\n");
cartScript.append("tooltip: {");
{
cartScript.append("\n");
cartScript.append("headerFormat: \'<span style=\"font-size: 11px;color:#666\">{");
{
cartScript.append("point.x:%B %e, %Y}");
}
cartScript.append("</span><br>\',\n");
cartScript.append("pointFormat: \'{");
{
cartScript.append("point.name}");
}
cartScript.append("<br><b>{");
{
cartScript.append("point.y}");
}
cartScript.append("</b>\',\n");
cartScript.append("valueSuffix: \' employees\'\n");
cartScript.append("}");
}
cartScript.append(",\n");
cartScript.append("data: [\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2009, 10, 1), y: 1, name: \'Torstein worked alone\', image: \'Torstein\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2010, 10, 20), y: 2, name: \'Grethe joined\', image: \'Grethe\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2011, 3, 1), y: 3, name: \'Erik joined\', image: null }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2011, 7, 1), y: 4, name: \'Gert joined\', image: \'Gert\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2011, 7, 15), y: 5, name: \'Hilde joined\', image: \'Hilde\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2012, 5, 1), y: 6, name: \'Guro joined\', image: \'Guro\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2012, 8, 1), y: 5, name: \'Erik left\', image: null }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2012, 8, 15), y: 6, name: \'Anne Jorunn joined\', image: \'AnneJorunn\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2013, 0, 1), y: 7, name: \'Hilde T. joined\', image: null }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2013, 7, 1), y: 8, name: \'Jon Arild joined\', image: \'JonArild\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2013, 7, 20), y: 9, name: \'Øystein joined\', image: \'Oystein\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2013, 9, 1), y: 10, name: \'Stephane joined\', image: \'Stephane\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2014, 9, 1), y: 11, name: \'Anita joined\', image: \'Anita\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2014, 10, 27), y: 11, name: \' \', image: null }");
}
cartScript.append("\n");
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append("]\n");
cartScript.append("}");
}
cartScript.append(";\n");
cartScript.append("// Add flags for important milestones. This requires Highstock.\n");
cartScript.append("if (Highcharts.seriesTypes.flags) {");
{
cartScript.append("\n");
cartScript.append("options.series.push({");
{
cartScript.append("\n");
cartScript.append("type: \'flags\',\n");
cartScript.append("name: \'Cloud\',\n");
cartScript.append("color: \'#333333\',\n");
cartScript.append("shape: \'squarepin\',\n");
cartScript.append("y: -80,\n");
cartScript.append("data: [\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2014, 4, 1), text: \'Highcharts Cloud Beta\', title: \'Cloud\', shape: \'squarepin\' }");
}
cartScript.append("\n");
cartScript.append("],\n");
cartScript.append("showInLegend: false\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("type: \'flags\',\n");
cartScript.append("name: \'Highmaps\',\n");
cartScript.append("color: \'#333333\',\n");
cartScript.append("shape: \'squarepin\',\n");
cartScript.append("y: -55,\n");
cartScript.append("data: [\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2014, 5, 13), text: \'Highmaps version 1.0 released\', title: \'Maps\' }");
}
cartScript.append("\n");
cartScript.append("],\n");
cartScript.append("showInLegend: false\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("type: \'flags\',\n");
cartScript.append("name: \'Highcharts\',\n");
cartScript.append("color: \'#333333\',\n");
cartScript.append("shape: \'circlepin\',\n");
cartScript.append("data: [\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2009, 10, 27), text: \'Highcharts version 1.0 released\', title: \'1.0\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2010, 6, 13), text: \'Ported from canvas to SVG rendering\', title: \'2.0\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2010, 10, 23), text: \'Dynamically resize and scale to text labels\', title: \'2.1\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2011, 9, 18), text: \'Highstock version 1.0 released\', title: \'Stock\', shape: \'squarepin\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2012, 7, 24), text: \'Gauges, polar charts and range series\', title: \'2.3\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2013, 2, 22), text: \'Multitouch support, more series types\', title: \'3.0\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2014, 3, 22), text: \'3D charts, heatmaps\', title: \'4.0\' }");
}
cartScript.append("\n");
cartScript.append("],\n");
cartScript.append("showInLegend: false\n");
cartScript.append("}");
}
cartScript.append(", {");
{
cartScript.append("\n");
cartScript.append("type: \'flags\',\n");
cartScript.append("name: \'Events\',\n");
cartScript.append("color: \'#333333\',\n");
cartScript.append("fillColor: \'rgba(255,255,255,0.8)\',\n");
cartScript.append("data: [\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2012, 10, 1), text: \'Highsoft won \"Entrepeneur of the Year\" in Sogn og Fjordane, Norway\', title: \'Award\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2012, 11, 25), text: \'Packt Publishing published <em>Learning Highcharts by Example</em>. Since then, many other books are written about Highcharts.\', title: \'First book\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2013, 4, 25), text: \'Highsoft nominated Norway\\'s Startup of the Year\', title: \'Award\' }");
}
cartScript.append(",\n");
cartScript.append("{");
{
cartScript.append(" x: Date.UTC(2014, 4, 25), text: \'Highsoft nominated Best Startup in Nordic Startup Awards\', title: \'Award\' }");
}
cartScript.append("\n");
cartScript.append("],\n");
cartScript.append("onSeries: \'revenue\',\n");
cartScript.append("showInLegend: false\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("}");
}
cartScript.append("\n");
cartScript.append("$(\'#container\').highcharts(options);\n");
cartScript.append("}");
}
cartScript.append(");\n");
cartScript.append("</script>\n");
}
}
