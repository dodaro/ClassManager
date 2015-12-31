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

<title>Add a question</title>

<link rel="stylesheet" type="text/css" href="resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="resources/style/nav-bar.css" />

<script src='resources/lib/jquery/jquery.min.js'></script>
<script src="resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="resources/script/nav-bar.js"></script>
<script type="text/javascript" src="resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="resources/script/forum/insertQuestion.js"></script>
</head>

<body style="background-color: #E6E6E6">
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
						
						<form:form commandName="question" method="POST" accept-charset="utf-8" htmlEscape="true">
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="panel panel-default">
										<div class="panel-heading">Question info</div>
										<div class="panel-body">
										
											<div class="row">
												<div class="form-group">
													<div class="col-md-7">
														<label for="questionTitleInpt">Question title</label>
														<form:input path="title" id="questionTitleInpt" class="form-control" type="text" placeholder="insert title..."/>
													</div>
												</div>
											</div>
											<div class="row">
												<fieldset disabled>
													<div class="form-group">
														<div class="col-md-3">
															<label for="questionUsrInpt">User</label>
															<input name="user" id="questionUsrInpt" class="form-control" type="text" value="${username }" />
														</div>
													</div>
												</fieldset>
											</div>
										</div>
									</div>
								
								</div>
							</div>
							
							<div class="row">
							
								<div id="questionArea" class="col-md-12">
								 		<hr />
										<div class="row">
											<div class="col-md-10">
												<h3 style="margin-left: 10px;">
													Question description
												</h3>
											</div>
											<div class="col-md-2">
												<h3><input class="btn btn-primary" type="submit" value="Submit question" style="float: right; margin-right: 5px;"></h3>
											</div>
										</div>
										
										<div class="row">
											<div class="col-md-12">
									        	<div id="area" style="margin-top: 15px;">
										            <form:textarea path="description" id="textEditor"></form:textarea>
									        	</div>
									        </div>
										</div>
								</div>			
							
							</div>
						</form:form>
						
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
</body>

</html>
