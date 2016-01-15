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

<title><spring:message code="message.forum.questionsTitle"/></title>

<link rel="stylesheet" type="text/css" href="/resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/resources/style/nav-bar.css" />
<link rel="stylesheet" type="text/css" href="/resources/style/questions.css" />

<script src='/resources/lib/jquery/jquery.min.js'></script>
<script src="/resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="/resources/script/nav-bar.js"></script>
<script src="/resources/lib/bootpag/jquery.bootpag.min.js"></script>
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
							
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="panel panel-default">
										  <div class="panel-heading">
										  	<div class="row">
										  		<div class="col-md-12">
										  			<h4><b><spring:message code="message.forum.questionsTitle"/></b></h4>
										  		</div>
										  	</div>
										    
										  </div>
										</div>	
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-offset-8 col-md-2">
										<a class="btn btn-primary btn-sm" href="/forum/searchQuestion"><spring:message code="message.forum.searchQuestion"/></a>
									</div>
									<div class="col-md-2">
										<form action="insertQuestion">
											<input class="btn btn-primary btn-sm" type="submit" value="<spring:message code="message.forum.insertQuestion"/>"/>
										</form>
									</div>
								</div>
								
								<c:if test="${pageCount != 0}">
									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div id="paginatorTop">
											</div>
										</div>
									</div>
								</c:if>
								
								
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<ul id="questionsList" class="list-group">
											<c:forEach var="question" items="${questions}">
												<li class="list-group-item answerRow" data-qid="${question.getId() }">
												  <div class="row text-center">
													<div class="col-md-2">
														<div class="col-sm-12 col-md-12 col-lg-12" style="margin-top: 10px">
												  			<div class="pull-right" style="background-color: #8096A5; padding: 10 10 10 10">
													  			<div class="row">
																	<div class="col-md-12">
																		${question.getAnswers().size()}
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-12">answer</div>
																</div>
												  			</div>
											  			</div>
													</div>
													<div class="col-md-10">
														<div class="row"><div class="col-md-12"><h4>
														<a class="questionLink" href="/forum/detailedQuestion?qid=${question.getId()}">${question.getTitle()}</a>
														</h4></div></div>
														<div class="row">
															<div class="col-sm-12 col-md-12 col-lg-12">
													  			<p class="pull-right" style="background-color: #E0EAF1; padding: 5 5 5 5">
														  		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
													  			${question.getUser().getUsername() }
													  			</p>
													  		</div>
														</div>
													</div>
												  </div>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
								
								<c:if test="${pageCount != 0}">
									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div id="paginatorBottom">
											</div>
										</div>
									</div>
								</c:if>
								
								<input type="hidden" value="${currPage }" id="currPage" />
								<input type="hidden" value="${pageCount }" id="pageCount" />
								<input type="hidden" value="${pageSize }" id="pageSize" />
							</div>

						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	
	
</body>

</html>
