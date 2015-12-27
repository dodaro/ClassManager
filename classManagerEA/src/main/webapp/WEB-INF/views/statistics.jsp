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
<%-- 				<%@include file="statisticsProfessor.jsp"%> --%>
					<%@include file="statisticsStudent.jsp"%>
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
