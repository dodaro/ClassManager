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

<title>Add a response</title>

<link rel="stylesheet" type="text/css" href="resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="resources/style/nav-bar.css" />

<script src='resources/lib/jquery/jquery.min.js'></script>
<script src="resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="resources/script/nav-bar.js"></script>
<script type="text/javascript" src="resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="resources/script/forum.js"></script>
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
					<div class="col-sm-12 col-md-12 col-lg-12">
						
						<div class="row">
							<div id="previewQuestionArea" class="col-md-12">
								<div class="panel panel-warning">
								  <div class="panel-heading">Question preview</div>
								  <div class="panel-body">
								    ${content}
								  </div>
								</div>
							</div>
							
							<div id="responseArea" class="col-md-12">
								<form>
									<hr />
									<h3 style="margin-left: 10px;">Your Answer</h3>
						        	<div id="area">
							            <textarea id="textEditor" rows="10" cols="80">
							                This is my textarea to be replaced with CKEditor.
							            </textarea>
						        	</div>
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
