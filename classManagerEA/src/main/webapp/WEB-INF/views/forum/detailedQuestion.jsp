<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>${question.getTitle()}</title>

<link rel="stylesheet" type="text/css" href="/resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/resources/style/nav-bar.css" />
<link rel="stylesheet" type="text/css" href="/resources/style/questions.css" />

<script src='/resources/lib/jquery/jquery.min.js'></script>
<script src="/resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="/resources/script/nav-bar.js"></script>
<script src="/resources/script/forum/questions.js"></script>
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
								  <div class="panel-body">
								  
								  	<div class="row">
								  		<div class="col-sm-12 col-md-12 col-lg-12">
									  		<h3><b>${question.getTitle()}</b></h3>
								  			<hr />
								  		</div>
								  	</div>
								  	<div class="row">
								  		<div class="col-sm-12 col-md-12 col-lg-12">
								  			<p>${question.getDescription()}</p>
								  		</div>
								  	</div>
								  	<div class="row">
								  		<div class="col-sm-12 col-md-12 col-lg-12">
								  			<p class="pull-right" style="background-color: #E0EAF1; padding: 10 10 10 10">
									  		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
								  			${question.getUser().getUsername()}
								  			</p>
								  			
								  		</div>
								  	</div>
								  	
								  	<c:if test="${owner == true}">
										<div class="row">
									  		<div class="col-sm-12 col-md-12 col-lg-12">
									  			<form action="/forum/modifyQuestion" method="POST">
									  				<input type="submit" class="btn btn-sm btn-warning" value="<spring:message code="message.forum.modifyQuestionBtn"/>"/>
									  				<input name="qid" value="${question.getId() }" style="display:none;"/>
									  			</form>
									  		</div>
									  	</div>
								  	</c:if>
								  	
								  </div>
								</div>	
								
								
								
								<div class="row">
									<div class="col-xs-6 col-sm-10 col-md-10 col-lg-10">
										<h4 style="margin-left: 10px;"><span class="badge">${question.getAnswers().size()}</span> <spring:message code="message.forum.answers"/></h4>
									</div>
									<div class="col-xs-6 col-sm-2 col-md-2 col-lg-2">
										<form action="createAnswer" method="POST">
											<input class="btn btn-primary btn-sm" type="submit" value="<spring:message code="message.forum.insertAnswer"/>" style="float:right; margin-right: 10px"/>
											<input name="qid" value="${question.getId() }" style="display:none;"/>
										</form>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<c:forEach var="answer" items="${question.getAnswers()}">
											<div class="well">
												<div class="row">
											  		<div class="col-sm-12 col-md-12 col-lg-12">
											  			<p>${answer.getDescription() }</p>
											  		</div>
											  	</div>
											  	<div class="row">
											  		<c:choose>
													  <c:when test="${answer.getUser().getUsername() eq loggedUser}">
													    <div class="col-sm-6 col-md-6 col-lg-6">
												  			<form action="/forum/modifyAnswer" method="POST">
												  				<input type="submit" class="btn btn-sm btn-warning" value="<spring:message code="message.forum.modifyAnswer"/>"/>
												  				<input name="qid" value="${question.getId() }" style="display:none;"/>
												  				<input name="aid" value="${answer.getId() }" style="display:none;"/>
												  			</form>
												  		</div>
												  		<div class="col-sm-6 col-md-6 col-lg-6">
												  			<p class="pull-right" style="background-color: #E0EAF1; padding: 10 10 10 10">
													  		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
												  			${answer.getUser().getUsername()}
												  			</p>
												  		</div>
													  </c:when>
													  <c:otherwise>
													    <div class="col-sm-12 col-md-12 col-lg-12">
												  			<p class="pull-right" style="background-color: #E0EAF1; padding: 10 10 10 10">
													  		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
												  			${answer.getUser().getUsername()}
												  			</p>
												  		</div>
													  </c:otherwise>
													</c:choose>
											  	
											  	</div>
											</div>
										</c:forEach>
										
									</div>
								</div>
								
								<c:if test="${question.getAnswers().size() > 0}">
									<form action="createAnswer" method="POST">
										<input class="btn btn-primary btn-sm" type="submit" value="<spring:message code="message.forum.insertAnswer"/>"/>
										<input name="qid" value="${question.getId() }" style="display:none;"/>
									</form>
							  	</c:if>

						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	  </div>
	</div>
	
	
	
</body>

</html>