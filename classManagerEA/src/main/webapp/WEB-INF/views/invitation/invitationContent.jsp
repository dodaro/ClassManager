<!DOCTYPE html>
<%@include file="../pagesCommon/includeJSP.jsp"%>
<html>
<head>
<%@include file="../pagesCommon/head.jsp"%>
</head>
<body>
	<%@include file="../pagesCommon/topBar.jsp"%>
	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<%@include file="../pagesCommon/sideBar.jsp"%>
			<!-- END SIDEBAR -->

			<div class="col-sm-9 col-md-9 col-lg-10">
				<br>
				<c:if test="${not empty student}">
					<%@include file="invitationStudent.jsp"%>
				</c:if>
				<c:if test="${not empty professor}">
					<%@include file="invitationProfessor.jsp"%>
				</c:if>
			</div>


<!-- 			<div class="row col-sm-9 col-md-9 col-lg-10"> -->
<!-- 				<a -->
<!-- 					href="http://www.accuweather.com/en/us/new-york-ny/10007/weather-forecast/349727" -->
<!-- 					class="aw-widget-legal"> </a> -->
<!-- 				<div id="awcc1452422458690" class="aw-widget-current" -->
<!-- 					data-locationkey="" data-unit="f" data-language="en-us" -->
<!-- 					data-useip="true" data-uid="awcc1452422458690"></div> -->
<!-- 				<script type="text/javascript" -->
<!-- 					src="http://oap.accuweather.com/launch.js"></script> -->
<!-- 			</div> -->

<!-- 			<div class="row col-sm-9 col-md-9 col-lg-10"> -->
<!-- 				<a -->
<!-- 					href="http://www.accuweather.com/it/us/new-york-ny/10007/weather-forecast/349727" -->
<!-- 					class="aw-widget-legal"> </a> -->
<!-- 				<div id="awcc1452422672399" class="aw-widget-current" -->
<!-- 					data-locationkey="" data-unit="c" data-language="it" -->
<!-- 					data-useip="false" data-uid="awcc1452422672399"></div> -->
<!-- 				<script type="text/javascript" -->
<!-- 					src="http://oap.accuweather.com/launch.js"></script> -->
<!-- 			</div> -->

<!-- 			<div class="row col-sm-9 col-md-9 col-lg-10"> -->
<!-- 				<script type="text/javascript" -->
<!-- 					src="http://100widgets.com/js_data.php?id=27"></script> -->
<!-- 			</div> -->
		</div>
	</div>
</body>
</html>
