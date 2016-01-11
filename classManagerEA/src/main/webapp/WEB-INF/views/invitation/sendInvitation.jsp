<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-12 col-md-12 col-lg-12">
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
					aria-hidden="true"> </span> <strong class="pull-left"> <spring:message
						code="message.invitation.sendHelpInfo7" />
				</strong>
				<div class="dropdown pull-left ">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="true"><spring:message code="message.invitation.sendHelpInfo8" /><span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<c:forEach items="${courseList.list}" var="singleCourse">
							<li><a
								href="/sendInvitation?courseName='${singleCourse.field1}'">${singleCourse.field1}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<br> <br> <br>
			<c:if test="${not empty courseSelected}">
				<div class="row col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default">
						<c:if test="${empty studentList}">
							<br>
							<div class="alert alert-danger" role="alert">
								<strong>Ops!</strong>
								<spring:message code="message.invitation.sendHelpInfo2" />
							</div>
						</c:if>
						<c:if test="${not empty studentList}">
							<table class="table">
								<caption>
									<spring:message code="message.invitation.sendHelpInfo1" />
								</caption>
								<thead>
									<tr>
										<th>#</th>
										<th><spring:message
												code="message.invitation.sendTableHeadField1" /></th>
										<th><form:form id="inviteAll"
												action="sendInvitation_InviteAll" method="POST">
												<button
													class="btn btn-default invitationActionButton pull-right"
													type="submit">
													<spring:message code="message.invitation.inviteAll" />
												</button>
												<input type="hidden" name="courseSelected"
													value="${courseSelected}">
												<input type="hidden" name="InviteAll" value="InviteAll">
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
											<td><form:form id="invite${k}"
													action="sendInvitation_InviteSingle" method="POST">
													<button
														class="btn btn-default invitationActionButton pull-right"
														type="submit">
														<spring:message code="message.invitation.inviteSingle" />
													</button>
													<input type="hidden" name="courseSelected"
														value="${courseSelected}">
													<input type="hidden" name="StudentName"
														value="${singleStudent.field1}">
												</form:form></td>
										</tr>
									</c:forEach>
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
						<c:if test="${empty invitedStudent}">
							<br>
							<div class="alert alert-danger" role="alert">
								<strong>Ops!</strong>
								<spring:message code="message.invitation.sendHelpInfo3" />
							</div>
						</c:if>
						<c:if test="${not empty invitedStudent}">
							<table class="table">
								<caption>
									<spring:message code="message.invitation.sendHelpInfo4" />
								</caption>
								<thead>
									<tr>
										<th>#</th>
										<th><spring:message
												code="message.invitation.sendTableHeadField1" /></th>
										<th><form:form id="cancelAll"
												action="sendInvitation_CancelAll" method="POST">
												<button
													class="btn btn-default invitationCancelButton pull-right"
													type="submit">
													<spring:message code="message.invitation.cancelAll" />
												</button>
												<input type="hidden" name="courseSelected"
													value="${courseSelected}">
												<input type="hidden" name="CancelAll" value="CancelAll">
											</form:form></th>
									</tr>
								</thead>
								<!-- Generated content -->
								<tbody>
									<c:set var="k" value="0" />
									<c:forEach items="${invitedStudent.list}" var="singleStudent">
										<tr>
											<c:set var="k" value="${k+1}" />
											<th scope="row">${k}</th>
											<td>${singleStudent.field1}</td>
											<td><form:form id="cancel${k}"
													action="sendInvitation_CancelSingle" method="POST">
													<button
														class="btn btn-default invitationCancelButton pull-right"
														type="submit">
														<spring:message code="message.invitation.cancelSingle" />
													</button>
													<input type="hidden" name="courseSelected"
														value="${courseSelected}">
													<input type="hidden" name="StudentName"
														value="${singleStudent.field1}">
												</form:form></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
					</div>
				</div>

			</c:if>

		</div>
	</div>
</div>