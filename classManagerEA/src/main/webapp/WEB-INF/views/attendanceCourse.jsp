<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Class Manager</title>
	<script src="resources/lib/jquery/jquery.min.js"></script>
	<script src="resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>	
	<link rel="stylesheet" type="text/css" href="resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="resources/style/style.css" />
	<link rel="stylesheet" type="text/css" href="resources/style/nav-bar.css" />	
	<script src="resources/script/nav-bar.js"></script>
	<script src="resources/script/login_register_modal.js"></script>
	
	<style type="text/css"> 
   		th, td
   		{
   			padding: 5px;
   			text-align: center;
   		}
  	</style>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header pull-left">
				<a id="menu-toggle" href="#" class="navbar-toggle">
					<span class="sr-only">Toggle navigation</span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				</a>
	  			<a class="navbar-brand" href="#">
	  				Class Manager
	  			</a>
			</div>			
			<div class="navbar-header pull-right">
            	<c:if test="${empty user}">
<!--             		<button type="button" class="btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->   		
    				<a id="login-button" class="nav-bar-button login" href="#"><span class="glyphicon glyphicon-log-out" ></span>Login</a>
    				<a class="nav-bar-button logout" href="aldo"><span class="glyphicon glyphicon-log-out"></span>Aldo Login</a>
				</c:if>
				<c:if test="${not empty user}">
					<a class="nav-bar-button logout" href="#"><span class="glyphicon glyphicon-log-out"></span><spring:message code="welcome.springmvc" text="default text" /> ${user}</a>
    				<a class="nav-bar-button logout" href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
				</c:if>
            </div>
	  	</div>
	</nav>
	
	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<div class="col-sm-3 col-md-3 col-lg-2">
				<div id="sidebar-wrapper" class="sidebar-desktop"> <!-- collapse width -->
					<ul class="sidebar-nav">
						<li>
							<a href="#"><span class="glyphicon glyphicon-home"></span> Dashboard</a>
						</li>
						<li>
						    <a href="#"><span class="glyphicon glyphicon-book"></span> Classroom</a>
						</li>
						<li>
						    <a href="#"><span class="glyphicon glyphicon-folder-open"></span> Materials</a>
						</li>
						<li>
						    <a href="#"><span class="glyphicon glyphicon-list"></span> Discussions</a>
						</li>
						<li>
						    <a href="#"><span class="glyphicon glyphicon-stats"></span> Statistics</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-sm-9 col-md-9 col-lg-10">
				<div class="row row-content">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="table-responsive">
							<table class="table">
								<tr>
									<th></th>
									<c:forEach items="${lectures}" var="lecture">
										<th>
											${lecture.number} ${lecture.topic}
										</th>
									</c:forEach>
								</tr>
								<c:forEach items="${students}" var="student">			
									<tr>
										<td>
											${student.username}
										</td>
										<c:set var="count" value="0" scope="page" />
										<c:forEach items="${student.attendanceStudentLectures}" var="asl">
											<c:set var="count" value="${count + 1}" scope="page"/>
											<c:choose>
											    <c:when test="${asl.lecture.number == count}">					        
											        <td>v</td>
											    </c:when>
											    <c:otherwise>
											    	<td></td>
											    </c:otherwise>
											</c:choose>
										</c:forEach>
										<c:forEach begin="${count}" end="${fn:length(lectures)}" varStatus="loop">
											<td></td>
										</c:forEach>
									</tr>
								</c:forEach>
								<tr>
									<th></th>
									<c:forEach items="${lectures}" var="lecture">
										<th>
											<form:form action="attendance" method="get" modelAttribute="lecture">
												<form:input path="id" value="${lecture.id}" hidden="true" />
												<input type="submit" value="Modify" class="btn-link"/>
											</form:form>
										</th>
									</c:forEach>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>