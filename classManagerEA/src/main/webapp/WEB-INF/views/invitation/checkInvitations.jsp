<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-12 col-md-12 col-lg-12">
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
					<c:if test="${empty studentList}">
						<br>
						<div class="alert alert-danger" role="alert">
							<strong>Ops!</strong>
							<spring:message code="message.invitation.sendHelpInfo5" />
						</div>
					</c:if>
					<c:if test="${not empty studentList}">
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
									<th><form:form id="acceptAll"
											action="checkInvitations_AcceptAll" method="POST">
											<button
												class="btn btn-default invitationActionButton pull-right"
												type="submit">
												<spring:message code="message.invitation.acceptAll" />
											</button>
											<input type="hidden" name="AcceptAll" value="AcceptAll">
										</form:form></th>
								</tr>
							</thead>
							<!-- Generated content -->
							<tbody>
								<c:set var="k" value="0" />
								<c:forEach items="${studentList.list}" var="singleStudent">
									<tr>
										<c:set var="k" value="${k+1}" />
										<th scope="row">${k}</th>
										<td>${singleStudent.field1}</td>
										<td>${singleStudent.field2}</td>
										<td><form:form id="accept${k}"
												action="checkInvitations_AcceptSingle" method="POST">
												<button
													class="btn btn-default invitationActionButton pull-right"
													type="submit">
													<spring:message code="message.invitation.acceptSingle" />
												</button>
												<input type="hidden" name="studentName"
													value="${singleStudent.field1}">
												<input type="hidden" name="courseName"
													value="${singleStudent.field2}">
											</form:form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>

		</div>
	</div>
</div>