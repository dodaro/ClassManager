<!DOCTYPE html>
<%@include file="includeJSP.jsp"%>
<html>
<head>
<%@include file="head.jsp"%>

<c:forEach items="${cartList.carts}" var="singleCart">
${singleCart.cartScript}
</c:forEach>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script
	src="https://www.highcharts.com/samples/static/highslide-full.min.js"></script>
<script
	src="https://www.highcharts.com/samples/static/highslide.config.js"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="https://www.highcharts.com/samples/static/highslide.css" />

</head>
<body>
	<%@include file="topBar.jsp"%>
	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<%@include file="sideBar.jsp"%>
			<!-- END SIDEBAR -->

			<div class="col-sm-9 col-md-9 col-lg-10">
				<div class="row row-content">
					<div class="panel-group col-sm-12 col-md-12 col-lg-12"
						id="accordion" role="tablist" aria-multiselectable="true">
						<c:forEach items="${cartList.carts}" var="singleCart">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab"
									id="heading${singleCart.name}">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapse${singleCart.name}"
											aria-expanded="false"
											aria-controls="collapse${singleCart.name}">
											${singleCart.name} </a>
									</h4>
								</div>
								<div id="collapse${singleCart.name}"
									class="panel-collapse collapse in" role="tabpanel"
									aria-labelledby="heading${singleCart.name}">
									<div class="panel-body">
										<div id="${singleCart.idContainer}"></div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					
					<div id="container" style="display: none;">
					<table>
						<tr>
							<td>Alpha Angle</td>
							<td><input id="R0" type="range" min="0" max="45" value="15" />
								<span id="R0-value" class="value"></span></td>
						</tr>
						<tr>
							<td>Beta Angle</td>
							<td><input id="R1" type="range" min="0" max="45" value="15" />
								<span id="R1-value" class="value"></span></td>
						</tr>
					</table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>
