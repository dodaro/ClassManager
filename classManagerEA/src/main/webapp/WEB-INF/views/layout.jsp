<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Class Manager</title>
<script src="resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="resources/lib/jquery-ui/jquery-ui.js"></script>
<script src="resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>

<link rel="stylesheet" type="text/css"
	href="resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<!-- <link rel="stylesheet" type="text/css" href="resources/style/style.css" /> -->
<link rel="stylesheet" type="text/css"
	href="resources/style/nav-bar.css" />
<link rel="stylesheet" type="text/css"
	href="resources/lib/jquery-ui/jquery-ui.css" />


<script src="resources/script/nav-bar.js"></script>
<script src="resources/script/layout.js"></script>

<jsp:include page="${customHeader}" flush="true" />

</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header pull-left">
				<a id="menu-toggle" href="#" class="navbar-toggle"> <span
					class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="navbar-brand" href="#"> Class Manager </a>
			</div>
			<div class="navbar-header pull-right">
				<a class="nav-bar-button logout" href="./db_init"><span
					class="glyphicon glyphicon-log-out"></span>InitDB</a>
				<c:if test="${empty loggedIn}">
					<!--             		<button type="button" class="btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->



					<a id="login-button" class="nav-bar-button login" href="#"><span
						class="glyphicon glyphicon-log-out"></span>Login</a>
					<a class="nav-bar-button logout" href="aldo"><span
						class="glyphicon glyphicon-log-out"></span>Aldo Login</a>
				</c:if>
				<c:if test="${not empty loggedIn}">
					<a class="nav-bar-button logout" href="#"><span
						class="glyphicon glyphicon-log-out"></span> <spring:message
							code="welcome.springmvc" text="default text" /> ${loggedIn}</a>
					<a class="nav-bar-button logout" href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a>
				</c:if>
				<c:if test="${not empty loggedIn && role == 'admin' }">
					<a class="nav-bar-button logout" href="userslist"><span
						class="glyphicon glyphicon-log-out"></span>User List</a>
				</c:if>
			</div>
		</div>
	</nav>

	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<!-- 			<div class="col-sm-3 col-md-3 col-lg-2"> -->
			<!-- 				<div id="sidebar-wrapper" class="sidebar-desktop"> -->
			<!-- 					collapse width -->
			<!-- 					<ul class="sidebar-nav"> -->
			<!-- 						<li><a href="#"><span class="glyphicon glyphicon-home"></span> -->
			<!-- 								Dashboard</a></li> -->
			<!-- 						<li><a href="#"><span class="glyphicon glyphicon-book"></span> -->
			<!-- 								Classroom</a></li> -->
			<!-- 						<li><a href="#"><span -->
			<!-- 								class="glyphicon glyphicon-folder-open"></span> Materials</a></li> -->
			<!-- 						<li><a href="#"><span class="glyphicon glyphicon-list"></span> -->
			<!-- 								Discussions</a></li> -->
			<!-- 						<li><a href="./statistics"><span -->
			<!-- 								class="glyphicon glyphicon-stats"></span> Statistics</a></li> -->
			<!-- 						<li><a href="./invitation"><span -->
			<!-- 								class="glyphicon glyphicon-gift" aria-hidden="true"></span> -->
			<!-- 								Invitation</a></li> -->
			<!-- 						<li><a href="./noticeboard?init=1"><span -->
			<%-- 								class="glyphicon glyphicon-send"></span> <spring:message --%>
			<%-- 									code="message.noticeboard" text="default text" /> con fake --%>
			<!-- 								init</a></li> -->
			<!-- 						<li><a href="./noticeboard"><span -->
			<%-- 								class="glyphicon glyphicon-send"></span> <spring:message --%>
			<%-- 									code="message.noticeboard" text="default text" /> senza init</a></li> --%>
			<!-- 					</ul> -->
			<!-- 				</div> -->
			<!-- 			</div> -->

			<jsp:include page="./pagesCommon/sideBar.jsp" flush="true" />

<!-- 			<div class="col-sm-10 col-md-10 col-lg-10"> -->
<!-- 				<br> -->
<!-- 				<div class="panel panel-default"> -->
<!-- 					<div class="panel-heading"> -->
<!-- 						<strong>Weather Large</strong> -->
<!-- 					</div> -->
<!-- 					<div class="panel-body"> -->
<!-- 						<a -->
<!-- 							href="http://www.accuweather.com/en/it/rende/211946/weather-forecast/211946" -->
<!-- 							class="aw-widget-legal"> </a> -->
<!-- 						<div id="awcc1452438100523" class="aw-widget-current" -->
<!-- 							data-locationkey="211946" data-unit="c" data-language="en-us" -->
<!-- 							data-useip="false" data-uid="awcc1452438100523"></div> -->
<!-- 						<script type="text/javascript" -->
<!-- 							src="http://oap.accuweather.com/launch.js"></script> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 			<div class="col-sm-2 col-md-2 col-lg-2"></div> -->
<!-- 			<div class="col-sm-3 col-md-3 col-lg-3"> -->
<!-- 				<br> -->
<!-- 				<div class="panel panel-default"> -->
<!-- 					<div class="panel-heading"> -->
<!-- 						<strong>Weather Small</strong> -->
<!-- 					</div> -->
<!-- 					<div class="panel-body"> -->
<!-- 						<a -->
<!-- 							href="http://www.accuweather.com/en/it/rende/211946/weather-forecast/211946" -->
<!-- 							class="aw-widget-legal"> </a> -->
<!-- 						<div id="awcc1452438172150" class="aw-widget-current" -->
<!-- 							data-locationkey="211946" data-unit="c" data-language="en-us" -->
<!-- 							data-useip="false" data-uid="awcc1452438172150"></div> -->
<!-- 						<script type="text/javascript" -->
<!-- 							src="http://oap.accuweather.com/launch.js"></script> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 			<div class="col-sm-2 col-md-2 col-lg-2"></div> -->
<!-- 			<div class="col-sm-3 col-md-3 col-lg-3"> -->
<!-- 				<br> -->
<!-- 				<div class="panel panel-default"> -->
<!-- 					<div class="panel-heading"> -->
<!-- 						<strong>Clock</strong> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="panel-body"> -->
<!-- 					<script type="text/javascript" -->
<!-- 						src="http://100widgets.com/js_data.php?id=27"></script> -->
<!-- 					<script type="text/javascript" -->
<!-- 						src="http://100widgets.com/js_data.php?id=37"></script> -->
<!-- 					<script type="text/javascript" -->
<!-- 						src="http://100widgets.com/js_data.php?id=48"></script> -->
<!-- 				</div> -->
<!-- 			</div> -->

<%-- 			<jsp:include page="${customBody}" flush="true" /> --%>

			<div class="col-sm-9 col-md-9 col-lg-10">
				<jsp:include page="${customBody}" flush="true" />
			</div>

		</div>
	</div>

	<!-- Modal For Login-->
	<div id="login-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<!-- Modal For Register-->
	<div id="register-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<spring:message code="message.register" text="default text" />
					</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


</body>

</html>