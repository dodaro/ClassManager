package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

public class ClickablePointsCart extends AbstractCart {

	public ClickablePointsCart(){
		super();
		this.setName("ClickablePointsCart");
	}

	@Override
	protected void buildCart() {
		cartScript = new StringBuilder("");
		cartScript.append("<script type=\"text/javascript\">");
		cartScript.append("$(document).ready(function() {");
		cartScript.append("$.getJSON("
				+ "'https://www.highcharts.com/samples/data/jsonp.php?filename=analytics.csv&callback=?',"
				+ " function (csv) {");
		cartScript.append("$('#"+getIdContainer()+"').highcharts(");
		cartScript.append("{");	
		{	// Data
			cartScript.append("data: {csv: csv},");
		}	// End Data
		{	// Title 
			cartScript.append("title: {text: 'Daily visits at www.highcharts.com'},");
		}	// End Title
		{	// Subtitle
			cartScript.append("subtitle: {text: 'Source: Google Analytics'},");
		}	// End Subtitle
		{	// X Axis
			cartScript.append("xAxis: {");
			cartScript.append("tickInterval: 7 * 24 * 3600 * 1000,");
			cartScript.append("tickWidth: 0,gridLineWidth: 1,");
			cartScript.append("labels: {align: 'left',x: 3,y: -3}},");  
		}	// End X Axis
		{	// Y Axis
			cartScript.append("yAxis: [");
			cartScript.append("{title: {text: null},");
			cartScript.append("labels: {align: 'left',x: 3,y: 16,format: '{value:.,0f}'},");
			cartScript.append("showFirstLabel: false},");
			cartScript.append("{linkedTo: 0,gridLineWidth: 0,opposite: true,title: {text: null},");
			cartScript.append("labels: {align: 'right',x: -3,y: 16,format: '{value:.,0f}'},");
			cartScript.append("showFirstLabel: false}");
			cartScript.append("],");
		}	// End Y Axis
		{	// Legend
			cartScript.append("legend: {align: 'left',verticalAlign: 'top',y: 20,floating: true,borderWidth: 0},");
		}	// End Legend
		{	// Tooltip
			cartScript.append("tooltip: {shared: true,crosshairs: true},");
		}	// End Tooltip
		{	// PlotOptions
			cartScript.append("plotOptions: {");
			cartScript.append("series: {");
			cartScript.append("cursor: 'pointer',");
			cartScript.append("point: {events: {click: function (e) {");
			cartScript.append("hs.htmlExpand(null, {");
			cartScript.append("pageOrigin: {x: e.pageX || e.clientX,y: e.pageY || e.clientY},");
			cartScript.append("headingText: this.series.name,");
			cartScript.append("maincontentText: Highcharts.dateFormat('%A, %b %e, %Y', this.x) + ':<br/> ' + this.y + ' visits',");
			cartScript.append("width: 200");
			cartScript.append("});");
			cartScript.append("}}},");
			cartScript.append("marker: {lineWidth: 1}");
			cartScript.append("}},");
		}	// End PlotOptions
		{	// Series
			cartScript.append("series: [");
			cartScript.append("{name: 'All visits',lineWidth: 4,marker: {radius: 4}},");
			cartScript.append("{name: 'New visitors'}");
			cartScript.append("]");
		}	// End Series
		cartScript.append("});});});");
		
		cartScript.append("</script>");			
	}
}
