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

<title><spring:message code="message.forum.insertAnswerTitle"/></title>

<link rel="stylesheet" type="text/css" href="/resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/resources/style/nav-bar.css" />
<link href="/resources/style/uploadFile_css/style.css" rel="stylesheet" />

<script src='/resources/lib/jquery/jquery.min.js'></script>
<script src="/resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="/resources/script/nav-bar.js"></script>
<script type="text/javascript" src="/resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/resources/script/forum/insertAnswer.js"></script>


<script src="/resources/script/fileBrowserScript.js"></script>
<script src="/resources/lib/uploadFile-lib/jquery.knob.js"></script>

<script src="/resources/lib/uploadFile-lib/jquery.ui.widget.js"></script>
<script src="/resources/lib/uploadFile-lib/jquery.iframe-transport.js"></script>
<script src="/resources/lib/uploadFile-lib/jquery.fileupload.js"></script>

<script src="/resources/script/forum/uploadAttachment.js"></script>

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
						
						<div class="row">
							<div id="previewQuestionArea" class="col-md-12">
								<div class="panel panel-warning">
								  <div class="panel-heading"><spring:message code="message.forum.questionPreview"/></div>
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
								  </div>
								</div>
							</div>
							
							<div id="answerArea" class="col-md-12">
								<form:form commandName="answer" action="insertAnswer" accept-charset="utf-8">
									<hr />
									<h3 style="margin-left: 10px;">
										<spring:message code="message.forum.yourAnswer"/>
										<input class="btn btn-primary" type="submit" value="<spring:message code="message.forum.sendAnswer"/>" style="float: right; margin-right: 5px;">
									</h3>
						        	<div id="area" style="margin-top: 15px;">
							            <form:textarea path="description" id="textEditor"></form:textarea>
						        	</div>
						        	<input name="qid" value="${question.getId() }" style="display:none;">
						        	
						        	<div class="row" style="margin-top: 20px;">
								  		<div class="col-sm-12 col-md-12 col-lg-12">
								  		
							  				<div class="panel-group" id="accordion" role="tablist">
												<div class="panel panel-default">
													<div class="panel-heading" role="tab" id="headingOne">
														<div class="panel-title">
															<div>
																<div role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
																 <b><spring:message code="message.forum.loadedAttachment" /></b>
																</div>
															</div>
														</div>
													</div>
													<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
														<div class="panel-body">
														
												  				<div class="row">
												  					<div id="attachmentSection" class="col-sm-12 col-md-12 col-lg-12">
												  					</div>
												  				</div>
														
														</div>
													</div>
												</div>
											</div>	
								  		</div>
								  	</div>									
									<input id="attachedFiles" style="display: none;" name="attachedFiles">
						        </form:form>
						        
						        <div class="row" style="margin-top: 20px">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="panel-group" id="accordion2" role="tablist">
											<div class="panel panel-default">
												<div class="panel-heading" role="tab" id="headingTwo">
													<div class="panel-title">
														<div>
															<div class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo" aria-expanded="false" aria-controls="collapseOne"> 
															 <h4><b><spring:message code="message.forum.loadAttachment" /></b></h4>
															</div>
														</div>
													</div>
												</div>
												<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
													<div class="panel-body">
														<div id="uploadFile_div">
															<form id="upload" method="POST" action="/forum/uploadAnswerAttachment">
																<div id="drop">
																	<spring:message code="lectureManager.drophere" text="default text" /> 
																	<a> <spring:message code="lectureManager.browse" text="default text" /> </a>
																	<input type="file" name="file" />
																</div>
																<ul>
																	<!-- The file uploads will be shown here -->
																</ul>
															</form>
														</div>
													</div>
												</div>
											</div>
										</div>
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
