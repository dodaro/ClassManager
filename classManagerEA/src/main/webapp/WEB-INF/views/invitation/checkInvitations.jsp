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
							<spring:message code="message.invitation.professorOperation2" />
						</h3>
					</div>
					<div class="panel-body">
						<div class="row col-sm-12 col-md-12 col-lg-12">
							<div class="panel panel-default">
								<c:if test="${not empty noStudent}">
									<br>
									<div class="alert alert-danger" role="alert">
										<strong>Ops!</strong>
										<spring:message code="message.invitation.sendHelpInfo5" />
									</div>
								</c:if>
								<c:if test="${empty noStudent}">
									<table class="table">
										<caption>
											<spring:message code="message.invitation.sendHelpInfo6" />
										</caption>
										<thead>
											<tr>
												<th>#</th>
												<th><spring:message
														code="message.invitation.sendTableHeadField1" /></th>
												<th><spring:message
														code="message.invitation.sendTableHeadField2" /></th>
												<th>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.acceptAll" />
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
												<td>Corso 2</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.acceptSingle" />
														</button>
													</form>
												</td>
											</tr>
											<tr>
												<th scope="row">2</th>
												<td>Studente 2</td>
												<td>Corso 2</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.acceptSingle" />
														</button>
													</form>
												</td>
											</tr>
											<tr>
												<th scope="row">3</th>
												<td>Studente 3</td>
												<td>Corso 1</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.acceptSingle" />
														</button>
													</form>
												</td>
											</tr>
											<tr>
												<th scope="row">4</th>
												<td>Studente 4</td>
												<td>Corso 3</td>
												<td>
													<form>
														<button
															class="btn btn-default invitationActionButton pull-right"
															type="submit">
															<spring:message code="message.invitation.acceptSingle" />
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
