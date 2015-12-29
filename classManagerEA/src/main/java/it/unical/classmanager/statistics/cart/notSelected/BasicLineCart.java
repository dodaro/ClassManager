package it.unical.classmanager.statistics.cart.notSelected;

import it.unical.classmanager.statistics.cart.AbstractCart;

public class BasicLineCart extends AbstractCart {
	
	public BasicLineCart(){
		super();
		this.setName("BasicLineCart");
	}

	@Override
	protected void buildCart() {
		cartScript = new StringBuilder("");
		cartScript.append("<script type=\"text/javascript\">");
		cartScript.append("$(document).ready((function() {");
		cartScript.append("$('#"+getIdContainer()+"').highcharts(");
		cartScript.append("{");
		{	// Title
			cartScript.append("title : {");
			cartScript.append("text : 'My title',");
			cartScript.append("x : -20");
			cartScript.append("},");
		}	// End Title
		{	// SubTitle
			cartScript.append("subtitle : {");
			cartScript.append("	text : 'Source: WorldClimate.com',");
			cartScript.append("	x : -20");
			cartScript.append("},");
		}	// End SubTitle
		{	// X Axis
			cartScript.append("xAxis : {");
			cartScript.append("categories :");
			cartScript.append("[");
			cartScript.append("'Jan', 'Feb', 'Mar', 'Apr','May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'");
			cartScript.append("]},");
		}	// End X Axis
		{	// Y Axis
			cartScript.append("yAxis : {");
			{	// Y Axis Title
				cartScript.append("title : {");
				cartScript.append("text : ");
				cartScript.append("'Temperature (°C)'");
				cartScript.append("},");
			}	// End Y Axis Title
			{	// Y Axis Plotlines
				cartScript.append("plotLines : [ {");
				cartScript.append("value : 0,");
				cartScript.append("width : 1,");
				cartScript.append("color : '#808080'");
				cartScript.append("}]");
			}	// End Y Axis Plotlines
			cartScript.append("},");
		}	// End Y Axis
		{	// Tooltip
			cartScript.append("tooltip : {");
			cartScript.append("	valueSuffix : ");
			cartScript.append("'°C'");
			cartScript.append("},");
		}	// End Tooltip
		{	// Legend
			cartScript.append("legend : {");
			cartScript.append("layout : 'vertical',");
			cartScript.append("align : 'right',");
			cartScript.append("verticalAlign : 'middle',");
			cartScript.append("borderWidth : 0");
			cartScript.append("},");
		}	// End Legend
		{	// Series, the content of Series must be generated automatically
			cartScript.append("series : [");
			{	// SubSeries
				cartScript.append("{");
				cartScript.append("name : 'Tokyo',");
				cartScript.append("data : [ 7.0, 6.9, 9.5, 14.5, 18.2,");
				cartScript.append("21.5, 25.2, 26.5, 23.3, 18.3,");
				cartScript.append("13.9, 9.6 ]");
				cartScript.append("},");
			}	// End SubSeries
			{	// SubSeries
				cartScript.append("{");
				cartScript.append("name : 'New York',");
				cartScript.append("data : [ -0.2, 0.8, 5.7, 11.3, 17.0,");
				cartScript.append("22.0, 24.8, 24.1, 20.1, 14.1,");
				cartScript.append("8.6, 2.5 ]");
				cartScript.append("},");
			}	// End SubSeries
			{	// SubSeries
				cartScript.append("{");
				cartScript.append("name : 'Berlin',");
				cartScript.append("data : [ -0.9, 0.6, 3.5, 8.4, 13.5,");
				cartScript.append("17.0, 18.6, 17.9, 14.3, 9.0,");
				cartScript.append("3.9, 1.0 ]");
				cartScript.append("},");
			}	// End SubSeries
			{	// SubSeries
				cartScript.append("{");
				cartScript.append("name : 'London',");
				cartScript.append("data : [ 3.9, 4.2, 5.7, 8.5, 11.9,");
				cartScript.append("15.2, 17.0, 16.6, 14.2, 10.3,");
				cartScript.append("6.6, 4.8 ]");
				cartScript.append("}");
			}	// End SubSeries
			cartScript.append("]");
		}	// End Series

		cartScript.append("});}));");
		cartScript.append("</script>");		
	}
}
