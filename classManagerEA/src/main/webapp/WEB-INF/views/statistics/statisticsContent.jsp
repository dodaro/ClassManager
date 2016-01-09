<!DOCTYPE html>
<%@include file="../pagesCommon/includeJSP.jsp"%>
<html>
<head>
<%@include file="../pagesCommon/head.jsp"%>
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
	<%@include file="../pagesCommon/topBar.jsp"%>
	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<%@include file="../pagesCommon/sideBar.jsp"%>
			<!-- END SIDEBAR -->

			<div class="col-sm-9 col-md-9 col-lg-10">
				<c:if test="${not empty student}">
					<%@include file="statisticsStudent.jsp"%>
				</c:if>
				<c:if test="${not empty professor}">
					<%@include file="statisticsProfessor.jsp"%>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
