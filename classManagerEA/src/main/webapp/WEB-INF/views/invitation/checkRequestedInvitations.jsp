<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-12 col-md-12 col-lg-12">
	<br>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<spring:message code="message.invitation.studentOperation2" />
			</h3>
		</div>
		<div class="panel-body">
			<div class="row col-sm-12 col-md-12 col-lg-12"></div>
			<div class="row col-sm-12 col-md-12 col-lg-12">
				<div class="panel panel-default">
					<c:if test="${empty acceptableCourse}">
						<br>
						<div class="alert alert-danger" role="alert">
							<strong>Ops!</strong>
							<spring:message code="message.invitation.requestHelpInfo6" />
						</div>
					</c:if>
					<c:if test="${not empty acceptableCourse}">
						<table class="table">
							<caption>
								<spring:message code="message.invitation.requestHelpInfo5" />
							</caption>
							<thead>
								<tr>
									<th>#</th>
									<th><spring:message
											code="message.invitation.requestTableHeadField1" /></th>
									<th><spring:message
											code="message.invitation.requestTableHeadField4" /></th>
									<th><spring:message
											code="message.invitation.requestTableHeadField5" /></th>
									<th><spring:message
											code="message.invitation.requestTableHeadField2" /></th>
									<th><form:form id="acceptAll"
											action="checkRequestedInvitations_All" method="POST">
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
								<c:forEach items="${acceptableCourse.list}" var="singleCourse">
									<tr>
										<c:set var="k" value="${k+1}" />
										<th scope="row">${k}</th>
										<td>${singleCourse.field1}</td>
										<td>${singleCourse.field2}</td>
										<td>${singleCourse.field3}</td>
										<td>${singleCourse.field4}</td>
										<td><form:form id="accept${k}"
												action="checkRequestedInvitations_Single" method="POST">
												<button
													class="btn btn-default invitationActionButton pull-right"
													type="submit">
													<spring:message code="message.invitation.acceptSingle" />
												</button>
												<input type="hidden" name="CourseName"
													value="${singleCourse.field1}">
												<input type="hidden" name="ProfessorName"
													value="${singleCourse.field2}">
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