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

<title><spring:message code="message.forum.modifyQuestionTitle"/></title>

<link rel="stylesheet" type="text/css" href="/resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/resources/style/nav-bar.css" />
<link href="/resources/style/uploadFile_css/style.css" rel="stylesheet" />

<script src='/resources/lib/jquery/jquery.min.js'></script>
<script src="/resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="/resources/script/nav-bar.js"></script>
<script type="text/javascript" src="/resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/resources/script/forum/modifyQuestion.js"></script>


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
						
						<form:form action="updateQuestion" commandName="question" method="POST" accept-charset="utf-8" htmlEscape="true">
							<form:input path="id" style="display:none;"/>
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="panel panel-default">
										<div class="panel-heading"><spring:message code="message.forum.questionInfo"/></div>
										<div class="panel-body">
										
											<div class="row">
												<div class="form-group">
													<div class="col-md-7">
														<label for="questionTitleInpt"><spring:message code="message.forum.questionTitle"/></label>
														<spring:message code="message.forum.insertTitle" var="insertTitle"/>
														<form:input path="title" id="questionTitleInpt" class="form-control" type="text" placeholder="${insertTitle }"/>
													</div>
												</div>
											</div>
											<div class="row">
												<fieldset disabled>
													<div class="form-group">
														<div class="col-md-3">
															<label for="questionUsrInpt"><spring:message code="message.forum.questionOwner"/></label>
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
													<spring:message code="message.forum.questionDescription"/>
												</h3>
											</div>
											<div class="col-md-2">
												<h3><input class="btn btn-primary" type="submit" value="<spring:message code="message.forum.updateQuestion"/>" style="float: right; margin-right: 5px;"></h3>
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
										  						<c:forEach var="attachment" items="${question.getQuestionAttachedContents() }">
										  							<div class="attachmentContainer" data-aid="'+ parameters.id +'" class="row">
																		<div class="col-sm-10 col-md-10 col-lg-10">
																			<div class="row">
																				<div class="col-sm-2 col-md-2 col-lg-2">
																	  			<span style="font-size:2em;" class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>
																				</div>
																				<div class="col-sm-8 col-md-8 col-lg-8">
																					<p>${attachment.getName()}</p>
																				</div>
																				<div class="col-sm-2 col-md-2 col-lg-2">
																					<div data-aname="${attachment.getName()}" data-aid="${attachment.getId()}" class="btn btn-danger removeAttachmentBtn">delete</div>
																				</div>
																			</div>
																		</div>
																	</div>
										  						</c:forEach>
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
													<form id="upload" method="POST" action="/forum/uploadQuestionAttachment">
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
	
	
</body>

</html>