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

<title>Questions</title>

<link rel="stylesheet" type="text/css" href="resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="resources/style/nav-bar.css" />
<link rel="stylesheet" type="text/css" href="resources/style/questions.css" />

<script src='resources/lib/jquery/jquery.min.js'></script>
<script src="resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="resources/script/nav-bar.js"></script>
<script src="resources/script/forum/questions.js"></script>
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
			<div class="navbar-header pull-right">
				<a id="initializeDBBtn" class="nav-bar-button logout" href="db_init"><span
					class="glyphicon glyphicon-log-out"></span> Init db</a>
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
					<div class="col-sm-12 col-md-12 col-lg-12">
						
						<div class="row">
							
							<div class="col-sm-12 col-md-12 col-lg-12">
							
								<div class="panel panel-default">
								  <div class="panel-heading">Domanda</div>
								  <div class="panel-body">
								    <p>ID: ${question.getId()}</p>
									<p>Title: ${question.getTitle()}</p>
									<p>Description: ${question.getDescription()}</p>
									<p>User: ${question.getUser().getUsername()}</p>
								  </div>
								</div>	
								
								<div>
								
								<form action="insertAnswer">
									<input type="submit" value="insert answer" />
								</form>
								
								<div>Risposte:</div>
								<c:forEach var="answer" items="${question.getAnswers()}">
									<div class="well">
										<p>ID: ${answer.getId() }</p>
										<p>Description: ${answer.getDescription() }</p>
										<p>User: ${answer.getUser() }</p>
									</div>
								</c:forEach>
								
								<form action="insertAnswer">
									<input type="submit" value="insert answer" />
								</form>
							
							</div>

						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	
	
</body>

</html>

<!-- When an event is clicked the "event" field of this form is filled. If the user
	will click on the "delete" button a delete request will be send to the server -->
<!--<form:form id="delete_event_form" action="/delete_event"
							method="post" commandName="FullCalendarEventBean">
							<input type="hidden" path="id" />
							<input id="delete_event_submit" type="submit" value="Delete">
						</form:form>-->
