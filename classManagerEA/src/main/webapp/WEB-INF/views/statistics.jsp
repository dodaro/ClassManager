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
				<div class="col-sm-12 col-md-12 col-lg-12">
					<br>
					<div class="panel panel-default col-sm-4 col-md-4 col-lg-4">
						<div class="panel-body">
							<div id="idCartContainer1"></div>
						</div>
					</div>
					<div class="panel panel-default col-sm-8 col-md-8 col-lg-8">
						<div class="panel-body">
							<div id="idCartContainer2"></div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12">
					<br>
					<div class="panel panel-default col-sm-7 col-md-7 col-lg-7">
						<div class="panel-body">
							<div id="idCartContainer5"></div>
						</div>
					</div>
					<div class="panel panel-default col-sm-5 col-md-5 col-lg-5">
						<div class="panel-body">
							<div id="idCartContainer3"></div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default ">
						<div class="panel-body">
							<div id="idCartContainer4"></div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-9 col-md-9 col-lg-10">
				<c:if test="${not empty student}">
					<h1>Student: ${student.username}</h1>
					<br>
					<%@include file="statisticsStudent.jsp"%>
				</c:if>
				<c:if test="${not empty professor}">
					<h1>Professor: ${professor.username}</h1>
					<br>
					<%@include file="statisticsProfessor.jsp"%>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
