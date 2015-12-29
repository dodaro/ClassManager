<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Users</title>
	<script src="resources/lib/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resources/lib/jquery-ui/jquery-ui.js"></script>
	<script src="resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>	
	<script src="resources/lib/bootpag/jquery.bootpag.min.js"></script>	
	
	<link rel="stylesheet" type="text/css" href="resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="resources/style/style.css" />
	<link rel="stylesheet" type="text/css" href="resources/style/nav-bar.css" />	
	<link rel="stylesheet" type="text/css" href="resources/lib/jquery-ui/jquery-ui.css"	 />
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	
		
	
	<script src="resources/script/nav-bar.js"></script>
	<script src="resources/script/layout.js"></script>
	<script src="resources/script/users_list.js"></script>
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
        		<a class="nav-bar-button logout" href="./db_init"><span class="glyphicon glyphicon-log-out"></span>InitDB</a>
				<c:if test="${empty user}">
<!--             		<button type="button" class="btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->
            		
            	
           
    				<a id="login-button" class="nav-bar-button login" href="#"><span class="glyphicon glyphicon-log-out" ></span>Login</a>
    				<a class="nav-bar-button logout" href="aldo"><span class="glyphicon glyphicon-log-out"></span>Aldo Login</a>
    			</c:if>
				<c:if test="${not empty user}">
					<a class="nav-bar-button logout" href="#"><span class="glyphicon glyphicon-log-out"></span><spring:message code="welcome.springmvc" text="default text" /> ${user}</a>
    				<a class="nav-bar-button logout" href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
				</c:if>
				<c:if test="${not empty user && role == 'admin' }">
					<a class="nav-bar-button logout" href="#"><span class="glyphicon glyphicon-log-out">User List</span></a>
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
						    <a href="./statistics"><span class="glyphicon glyphicon-stats"></span> Statistics</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-sm-9 col-md-9 col-lg-10">
				<h3>Users List</h3>
				<form class="form-inline" action="searchusers" method="GET" role="form">
				  <div class="form-group">
				    <label for="lastname"><spring:message code="message.lastName" text="default text"/></label>
				    <input type="text"  class="form-control" name="query" placeholder="Rossi"/>
				    	<label for="select"><spring:message code="message.usersperpage" text="default text"/></label>
						  <select class="form-control" name="users">
						  	<c:if test="${not empty pageSize}">
						  		<option selected="selected">${pageSize}</option>
						  	</c:if>
						    <option>10</option>
						    <option>25</option>
						    <option>50</option>
						    <option>100</option>
						  </select>
				  	<button type="submit" class="btn btn-default">Search</button>
				    	<c:if test="${not empty error}" >
				    		<span class="help-block"><spring:message code="searchField.length.error" text="default text"/></span>
					    	<script>$(".form-group").addClass("has-error")</script>
				    	</c:if>
				  </div>
				    
				</form>
				
				<table class="table table-striped table-bordered">
					<thead>
					      <tr>
					        <th>User
					        	<a href="sort?prop=username">
					        	<c:choose>
					        		<c:when test="${prop == 'username' && asc == true }">
						        		<i class="sort fa fa-sort-asc"></i>
					        		</c:when>
					        		<c:when test="${prop == 'username' && asc != true }">
						        		<i class="sort fa fa-sort-desc"></i>
						        	</c:when>
						        	<c:otherwise>
						        		<i class="sort fa fa-sort"></i>
						        	</c:otherwise>
					        	</c:choose>
					        		
					        	</a>
					        </th>
					        <th>
					        	<spring:message code="message.firstName" text="default text" /> 
					        	<a href="sort?prop=firstName">
						        	<c:choose>
						        		<c:when test="${prop == 'firstName' && asc == true }">
							        		<i class="sort fa fa-sort-asc"></i>
						        		</c:when>
						        		<c:when test="${prop == 'firstName' && asc != true }">
							        		<i class="sort fa fa-sort-desc"></i>
							        	</c:when>
							        	<c:otherwise>
							        		<i class="sort fa fa-sort"></i>
							        	</c:otherwise>
						        	</c:choose>
					        	</a>
					        </th>
					        <th>
					        	<spring:message code="message.lastName" text="default text" /> 
					        	<a href="sort?prop=lastName">
					        		<c:choose>
					        		<c:when test="${prop == 'lastName' && asc == true }">
						        		<i class="sort fa fa-sort-asc"></i>
					        		</c:when>
					        		<c:when test="${prop == 'lastName' && asc != true }">
						        		<i class="sort fa fa-sort-desc"></i>
						        	</c:when>
						        	<c:otherwise>
						        		<i class="sort fa fa-sort"></i>
						        	</c:otherwise>
					        	</c:choose>
					        	</a>
					        </th>
					        <th>Role
					        	<a href="sort?prop=role">
					        		<c:choose>
					        		<c:when test="${prop == 'role' && asc == true }">
						        		<i class="sort fa fa-sort-asc"></i>
					        		</c:when>
					        		<c:when test="${prop == 'role' && asc != true }">
						        		<i class="sort fa fa-sort-desc"></i>
						        	</c:when>
						        	<c:otherwise>
						        		<i class="sort fa fa-sort"></i>
						        	</c:otherwise>
					        	</c:choose>
					        	</a>
					        </th>
					        <th>Action</th>
					      </tr>
    				</thead>
    				<tbody>
    					<c:forEach var="user" items="${users.getPageList()}">
    						
							<tr>
								<td class="user">${user.username}</td>
								<td class="firstname">${user.firstName}</td>
								<td class="lastname">${user.lastName}</td>
								<td class="role">${user.role}</td>
								
								<td>
								<c:if test="${user.username != loggedIn }">
									<button type="submit" class="btn btn-danger"><spring:message code="message.delete" text="default text"/></button>
								</c:if>
								<c:if test="${user.role == 'Student'}">
									<button type="submit" class="btn btn-success"><spring:message code="message.professor" text="default text"/></button>
								</c:if>
								</td>
							</tr>
						</c:forEach>
    				</tbody>
				</table>
				<form id="options">
					<input name="total-pages" type="hidden" value="${pageCount}"/> 
					<input name="page-number" type="hidden" value="${pageNumber}"/> 
				</form>
				<div id="paginator">
				</div>
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
	      <div class="modal-body">
	        
	      </div>
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
	        <h4 class="modal-title"><spring:message code="message.register" text="default text"/></h4>
	      </div>
	      <div class="modal-body">
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	
</body>

</html>