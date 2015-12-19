<%@include file="includeJSP.jsp"%>
<html>
<head>
<%@include file="head.jsp"%>

<script type="text/javascript">
$(document).ready(function () {
    $.getJSON('https://www.highcharts.com/samples/data/jsonp.php?filename=usdeur.json&callback=?', function (data) {

        $('#container1').highcharts({
            chart: {
                zoomType: 'x'
            },
            title: {
                text: 'USD to EUR exchange rate over time'
            },
            subtitle: {
                text: document.ontouchstart === undefined ?
                        'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
            },
            xAxis: {
                type: 'datetime'
            },
            yAxis: {
                title: {
                    text: 'Exchange rate'
                }
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },

            series: [{
                type: 'area',
                name: 'USD to EUR',
                data: data
            }]
        });
    });
});
		</script>
		
		<script type="text/javascript">
		$(document).ready(function () {
    $('#container2').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Historic World Population by Region'
        },
        subtitle: {
            text: 'Source: <a href="https://en.wikipedia.org/wiki/World_population">Wikipedia.org</a>'
        },
        xAxis: {
            categories: ['Africa', 'America', 'Asia', 'Europe', 'Oceania'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Population (millions)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' millions'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -40,
            y: 80,
            floating: true,
            borderWidth: 1,
            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
            shadow: true
        },
        credits: {
            enabled: false
        },
        series: [{
            name: 'Year 1800',
            data: [107, 31, 635, 203, 2]
        }, {
            name: 'Year 1900',
            data: [133, 156, 947, 408, 6]
        }, {
            name: 'Year 2012',
            data: [1052, 954, 4250, 740, 38]
        }]
    });
});
		</script>
		

<script type="text/javascript">
	/*
	 The purpose of this demo is to demonstrate how multiple charts on the same page can be linked
	 through DOM and Highcharts events and API methods. It takes a standard Highcharts config with a
	 small variation for each data set, and a mouse/touch event handler to bind the charts together.
	 */

	 $(document).ready(function() {

		/**
		 * In order to synchronize tooltips and crosshairs, override the
		 * built-in events with handlers defined on the parent element.
		 */
		$('#container4').bind('mousemove touchmove', function(e) {
			var chart, point, i;

			for (i = 0; i < Highcharts.charts.length; i = i + 1) {
				chart = Highcharts.charts[i];
				e = chart.pointer.normalize(e); // Find coordinates within the chart
				point = chart.series[0].searchPoint(e, true); // Get the hovered point

				if (point) {
					point.onMouseOver(); // Show the hover marker
					chart.tooltip.refresh(point); // Show the tooltip
					chart.xAxis[0].drawCrosshair(e, point); // Show the crosshair
				}
			}
		});
		/**
		 * Override the reset function, we don't need to hide the tooltips and crosshairs.
		 */
		Highcharts.Pointer.prototype.reset = function() {
			return undefined;
		};

		/**
		 * Synchronize zooming through the setExtremes event handler.
		 */
		function syncExtremes(e) {
			var thisChart = this.chart;

			if (e.trigger !== 'syncExtremes') { // Prevent feedback loop
				Highcharts.each(Highcharts.charts, function(chart) {
					if (chart !== thisChart) {
						if (chart.xAxis[0].setExtremes) { // It is null while updating
							chart.xAxis[0].setExtremes(e.min, e.max, undefined,
									false, {
										trigger : 'syncExtremes'
									});
						}
					}
				});
			}
		}

		// Get the data. The contents of the data file can be viewed at
		// https://github.com/highcharts/highcharts/blob/master/samples/data/activity.json
		$.getJSON(
						'https://www.highcharts.com/samples/data/jsonp.php?filename=activity.json&callback=?',
						function(activity) {
							$
									.each(
											activity.datasets,
											function(i, dataset) {

												// Add X values
												dataset.data = Highcharts
														.map(
																dataset.data,
																function(val, j) {
																	return [
																			activity.xData[j],
																			val ];
																});

												$('<div class="chart">')
														.appendTo('#container4')
														.highcharts(
																{
																	chart : {
																		marginLeft : 40, // Keep all charts left aligned
																		spacingTop : 20,
																		spacingBottom : 20,
																		zoomType : 'x'
																	},
																	title : {
																		text : dataset.name,
																		align : 'left',
																		margin : 0,
																		x : 30
																	},
																	credits : {
																		enabled : false
																	},
																	legend : {
																		enabled : false
																	},
																	xAxis : {
																		crosshair : true,
																		events : {
																			setExtremes : syncExtremes
																		},
																		labels : {
																			format : '{value} km'
																		}
																	},
																	yAxis : {
																		title : {
																			text : null
																		}
																	},
																	tooltip : {
																		positioner : function() {
																			return {
																				x : this.chart.chartWidth
																						- this.label.width, // right aligned
																				y : -1
																			// align to title
																			};
																		},
																		borderWidth : 0,
																		backgroundColor : 'none',
																		pointFormat : '{point.y}',
																		headerFormat : '',
																		shadow : false,
																		style : {
																			fontSize : '18px'
																		},
																		valueDecimals : dataset.valueDecimals
																	},
																	series : [ {
																		data : dataset.data,
																		name : dataset.name,
																		type : dataset.type,
																		color : Highcharts
																				.getOptions().colors[i],
																		fillOpacity : 0.3,
																		tooltip : {
																			valueSuffix : ' '
																					+ dataset.unit
																		}
																	} ]
																});
											});
						});
	});
</script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
</head>
<body>
	<%@include file="topBar.jsp"%>

	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<%@include file="sideBar.jsp"%>

			<div class="col-sm-9 col-md-9 col-lg-10">
			
				<div class="row row-content">
					<div class="col-sm-6 col-md-6 col-lg-6">
						<div id="container1"></div>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6">
						<div id="container2"></div>
					</div>
				</div>
				<div class="row row-content">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div id="container4"></div>
					</div>
				</div>
				<div class="row row-content">
					<div class="col-sm-6 col-md-6 col-lg-6">
						<h3>Statistics</h3>
						<div style="text-align: center; margin-bottom: 20px"></div>
						<p>Statistics content</p>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6">
						<h3>Statistics</h3>
						<div style="text-align: center; margin-bottom: 20px"></div>
						<p>Statistics content</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
