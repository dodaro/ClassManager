<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Class Manager</title>
<script src="resources/lib/jquery/jquery.min.js"></script>
<script src="resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="resources/style/style.css" />
<link rel="stylesheet" type="text/css"
	href="resources/style/nav-bar.css" />
<script src="resources/script/nav-bar.js"></script>

<!-- Calendar -->
<link href='resources/lib/jquery-ui/jquery-ui.css' rel='stylesheet' />
<link href='resources/lib/fullcalendar-2.5.0/fullcalendar.css'
	rel='stylesheet' />
<link href='resources/lib/fullcalendar-2.5.0/fullcalendar.print.css'
	rel='stylesheet' media='print' />

<script src='resources/lib/jquery/jquery.min.js'></script>
<script src='resources/lib/jquery-ui/jquery-ui.js'></script>
<script src='resources/lib/fullcalendar-2.5.0/lib/moment.min.js'></script>
<script src='resources/lib/fullcalendar-2.5.0/fullcalendar.min.js'></script>
<script src='resources/lib/fullcalendar-2.5.0/lang-all.js'></script>

<script src='resources/script/calendar_functions.js'></script>
<!--  -->

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
				<a class="nav-bar-button logout" href="#"><span
					class="glyphicon glyphicon-log-out"></span> Logout</a>
			</div>
		</div>
	</nav>

	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<div class="col-sm-3 col-md-3 col-lg-2">
				<div id="sidebar-wrapper" class="sidebar-desktop">
					<!-- collapse width -->
					<ul class="sidebar-nav">
						<li><a href="#"><span class="glyphicon glyphicon-home"></span>
								Dashboard</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-book"></span>
								Classroom</a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-folder-open"></span> Materials</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-list"></span>
								Discussions</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-stats"></span>
								Statistics</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-9 col-md-9 col-lg-10">
				<div class="row row-content">
					<!-- contains the calendar -->
					<div style="margin-left: 20%; margin-right: 20%;">
						<div id='calendar'></div>
					</div>

					<!-- When an event is clicked the "event" field of this form is filled. If the user
	will click on the "delete" button a delete request will be send to the server -->
					<form:form id="delete_event_form" action="/delete_event"
						method="post" commandName="FullCalendarEventBean">
						<form:input type="hidden" path="id" />
						<input id="delete_event_submit" type="submit" value="Delete">
					</form:form>

					<!-- When an event is clicked the "event" field of this form is filled. If the user
	will click on the "update" button a delete request will be send to the server -->
					<div id="update_event_div">
						<form:form id="update_event_form" action="/update_event"
							method="post" commandName="FullCalendarEventBean">
							<form:input type="hidden" path="id" />
							<label for="title">Title:</label>
							<form:input type="title" path="title" />
							<label for="start">Start:</label>
							<form:input type="start" path="startDate" />
							<label for="end">End:</label>
							<form:input type="end" path="endDate" />
							<input id="update_event_submit" type="submit" value="Update">
						</form:form>
					</div>

					<div id="updateCalendar_button"><button>Update</button></div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>