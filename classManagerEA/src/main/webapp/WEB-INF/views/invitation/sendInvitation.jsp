<!DOCTYPE html>
<%@include file="../pagesCommon/includeJSP.jsp"%>
<html>
<head>
<%@include file="../pagesCommon/head.jsp"%>
</head>
<body>
	<%@include file="../pagesCommon/topBar.jsp"%>
	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<%@include file="../pagesCommon/sideBar.jsp"%>
			<!-- END SIDEBAR -->

			<div class="col-sm-9 col-md-9 col-lg-10">
				<br>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<spring:message code="message.invitation.professorOperation1" />
						</h3>
					</div>
					<div class="panel-body">
						<div class="row col-sm-12 col-md-12 col-lg-12">
							<br> <span class="glyphicon glyphicon-info-sign pull-left"
								aria-hidden="true"> </span> <strong class="pull-left">
								Scegli un corso: </strong>
							<div class="dropdown pull-left ">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true">
									Courses <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<li><a href="#">Course1</a></li>
									<li><a href="#">Course2</a></li>
									<li><a href="#">Course3</a></li>
									<li><a href="#">Course4</a></li>
								</ul>
							</div>
						</div>
						<br> <br> <br>
						<div class="row col-sm-12 col-md-12 col-lg-12">
							<div class="panel panel-default">
								<c:if test="${not empty noStudent}">
									<br>
									<div class="alert alert-danger" role="alert">
										<strong>Ops!</strong>
										<spring:message code="message.invitation.sendHelpInfo2" />
									</div>
								</c:if>
								<c:if test="${empty noStudent}">
									<table class="table">
										<caption>
											<spring:message code="message.invitation.sendHelpInfo1" />
										</caption>
										<thead>
											<tr>
												<th>#</th>
												<th><spring:message
														code="message.invitation.sendTableHeadField1" /></th>
												<th>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.inviteAll" />
														</button>
													</form>
												</th>
											</tr>
										</thead>
										<!-- Generated content -->
										<tbody>
											<tr>
												<th scope="row">1</th>
												<td>Studente 1</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.inviteSingle" />
														</button>
													</form>
												</td>
											</tr>
											<tr>
												<th scope="row">2</th>
												<td>Studente 2</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.inviteSingle" />
														</button>
													</form>
												</td>
											</tr>
											<tr>
												<th scope="row">3</th>
												<td>Studente 3</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.inviteSingle" />
														</button>
													</form>
												</td>
											</tr>
										</tbody>
									</table>
								</c:if>
							</div>
						</div>

						<br>
						<hr>
						<br>

						<div class="row col-sm-12 col-md-12 col-lg-12">
							<div class="panel panel-default">
								<c:if test="${not empty noInvitedStudent}">
									<br>
									<div class="alert alert-danger" role="alert">
										<strong>Ops!</strong>
										<spring:message code="message.invitation.sendHelpInfo3" />
									</div>
								</c:if>
								<c:if test="${empty noInvitedStudent}">
									<table class="table">
										<caption>
											<spring:message code="message.invitation.sendHelpInfo4" />
										</caption>
										<thead>
											<tr>
												<th>#</th>
												<th><spring:message
														code="message.invitation.sendTableHeadField1" /></th>
												<th>
													<form>
														<button
															class="btn btn-default invitationCancelButton pull-right"
															type="submit">
															<spring:message code="message.invitation.cancelAll" />
														</button>
													</form>
												</th>
											</tr>
										</thead>
										<!-- Generated content -->
										<tbody>
											<tr>
												<th scope="row">1</th>
												<td>Studente 1</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationCancelButton pull-right"
															type="submit">
															<spring:message code="message.invitation.cancelSingle" />
														</button>
													</form>
												</td>
											</tr>
											<tr>
												<th scope="row">2</th>
												<td>Studente 2</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationCancelButton pull-right"
															type="submit">
															<spring:message code="message.invitation.cancelSingle" />
														</button>
													</form>
												</td>
											</tr>
											<tr>
												<th scope="row">3</th>
												<td>Studente 3</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationCancelButton pull-right"
															type="submit">
															<spring:message code="message.invitation.cancelSingle" />
														</button>
													</form>
												</td>
											</tr>
										</tbody>
									</table>
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
