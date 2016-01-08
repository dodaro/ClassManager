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
							<spring:message code="message.invitation.studentOperation1" />
						</h3>
					</div>
					<div class="panel-body">
						<div class="row col-sm-12 col-md-12 col-lg-12"></div>
						<div class="row col-sm-12 col-md-12 col-lg-12">
							<c:if test="${not empty noSelectableCourse}">
								<div class="alert alert-danger" role="alert">
									<strong>Ops!</strong>
									<spring:message code="message.invitation.requestHelpInfo3" />
								</div>
							</c:if>
							<c:if test="${empty noSelectableCourse}">
								<table class="table">
									<caption>
										<spring:message code="message.invitation.requestHelpInfo1" />
									</caption>
									<thead>
										<tr>
											<th>#</th>
											<th><spring:message
													code="message.invitation.requestTableHeadField1" /></th>
											<th><spring:message
													code="message.invitation.requestTableHeadField2" /></th>
											<th>
												<form>
													<button class="btn btn-default invitationActionButton"
														type="submit">
														<spring:message code="message.invitation.requestAll" />
													</button>
												</form>
											</th>
										</tr>
									</thead>
									<!-- Generated content -->
									<tbody>
										<tr>
											<th scope="row">1</th>
											<td>Corso 1</td>
											<td>Professore 1</td>
											<td>
												<form>
													<button class="btn btn-default invitationActionButton"
														type="submit">
														<spring:message code="message.invitation.requestSingle" />
													</button>
												</form>
											</td>
										</tr>
										<tr>
											<th scope="row">2</th>
											<td>Corso 2</td>
											<td>Professore 2</td>
											<td>
												<form>
													<button class="btn btn-default invitationActionButton"
														type="submit">
														<spring:message code="message.invitation.requestSingle" />
													</button>
												</form>
											</td>
										</tr>
										<tr>
											<th scope="row">3</th>
											<td>Corso 3</td>
											<td>Professore 3</td>
											<td>
												<form>
													<button class="btn btn-default invitationActionButton"
														type="submit">
														<spring:message code="message.invitation.requestSingle" />
													</button>
												</form>
											</td>
										</tr>
									</tbody>
								</table>
							</c:if>

						</div>
						<br>
						<hr>
						<br>
						<div class="row col-sm-12 col-md-12 col-lg-12"></div>
						<div class="row col-sm-12 col-md-12 col-lg-12">
							<c:if test="${not empty noUnselectableCourse}">
								<div class="alert alert-danger" role="alert">
									<strong>Ops!</strong>
									<spring:message code="message.invitation.requestHelpInfo4" />
								</div>
							</c:if>
							<c:if test="${empty noUnselectableCourse}">
								<table class="table">
									<caption>
										<spring:message code="message.invitation.requestHelpInfo2" />
									</caption>
									<thead>
										<tr>
											<th>#</th>
											<th><spring:message
													code="message.invitation.requestTableHeadField1" /></th>
											<th><spring:message
													code="message.invitation.requestTableHeadField2" /></th>
											<th>
												<form>
													<button class="btn btn-default invitationCancelButton"
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
											<td>Corso 1</td>
											<td>Professore 1</td>
											<td>
												<form>
													<button class="btn btn-default invitationCancelButton"
														type="submit">
														<spring:message code="message.invitation.cancelSingle" />
													</button>
												</form>
											</td>
										</tr>
										<tr>
											<th scope="row">2</th>
											<td>Corso 2</td>
											<td>Professore 2</td>
											<td>
												<form>
													<button class="btn btn-default invitationCancelButton"
														type="submit">
														<spring:message code="message.invitation.cancelSingle" />
													</button>
												</form>
											</td>
										</tr>
										<tr>
											<th scope="row">3</th>
											<td>Corso 3</td>
											<td>Professore 3</td>
											<td>
												<form>
													<button class="btn btn-default invitationCancelButton"
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
</body>
</html>
