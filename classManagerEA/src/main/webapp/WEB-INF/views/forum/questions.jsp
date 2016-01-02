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
									<div class="col-md-12">
										<form action="insertQuestion">
											<input class="btn btn-primary btn-sm" type="submit" value="<spring:message code="message.forum.insertQuestion"/>" style="float:right;"/>
										</form>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<ul id="" class="pagination">
										  <li>
										    <a href="questionsPrevious" aria-label="Previous">
										      <span aria-hidden="true">&laquo;</span>
										    </a>
										  </li>
										  
										  
										  <c:forEach begin="0" end="${pageCount-1}" var="i">
										  
										  	<c:choose>
											  <c:when test="${i eq currPage}">
											    <li class="active"><a href="questionsPage?page=<c:out value="${i}"/>"><c:out value="${i+1}"/></a></li>
											  </c:when>
											  <c:otherwise>
											    <li><a href="questionsPage?page=<c:out value="${i}"/>"><c:out value="${i+1}"/></a></li>
											  </c:otherwise>
											</c:choose>
											
									 	  </c:forEach>
									 	  
									 	  
										  <li>
										    <a href="questionsNext" aria-label="Next">
										      <span aria-hidden="true">&raquo;</span>
										    </a>
										  </li>
										</ul>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<ul id="questionsList" class="list-group">
											<c:forEach var="question" items="${questions}">
												<li class="list-group-item answerRow" data-qid="${question.getId() }">
												  <div class="row text-center">
													<div class="col-md-3">
														<div class="col-md-6">
															<div class="row"><div class="col-md-12">${question.getAnswers().size()}</div></div>
															<div class="row"><div class="col-md-12">answer</div></div>
														</div>
														<div class="col-md-6">
															<div class="row"><div class="col-md-12">15(fittizio)</div></div>
															<div class="row"><div class="col-md-12">views</div></div>
														</div>
													</div>
													<div class="col-md-9">
														<div class="row"><div class="col-md-12"><h4>
														<a class="questionLink" href="/forum/detailedQuestion?qid=${question.getId()}">${question.getTitle()}</a>
														</h4></div></div>
														<div class="row"><div class="col-md-12 text-right">${question.getUser().getUsername() }</div></div>
													</div>
												  </div>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<ul class="pagination">
										  <li>
										    <a href="questionsPrevious" aria-label="Previous">
										      <span aria-hidden="true">&laquo;</span>
										    </a>
										  </li>
										  
										  
										  <c:forEach begin="0" end="${pageCount-1}" var="i">
										  
										  	<c:choose>
											  <c:when test="${i eq currPage}">
											    <li class="active"><a href="questionsPage?page=<c:out value="${i}"/>"><c:out value="${i+1}"/></a></li>
											  </c:when>
											  <c:otherwise>
											    <li><a href="questionsPage?page=<c:out value="${i}"/>"><c:out value="${i+1}"/></a></li>
											  </c:otherwise>
											</c:choose>
											
									 	  </c:forEach>
									 	  
									 	  
										  <li>
										    <a href="questionsNext" aria-label="Next">
										      <span aria-hidden="true">&raquo;</span>
										    </a>
										  </li>
										</ul>
									</div>
								</div>
								
							
							</div>

						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	
	
</body>

</html>
