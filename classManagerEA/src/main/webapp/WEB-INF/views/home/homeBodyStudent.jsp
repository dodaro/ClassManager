<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	var events = $
	{
		events
	};
	$("#calendar").fullcalendar(events);
	$("#calendar").fullcalendar({
		events : events,
		editable : false
	});
</script>

<div class="col-sm-12 col-md-12 col-lg-12">
	<div class="row">
		<br>
		<h3>${welcomeMessage1}<strong> ${user.username}</strong>,
			${welcomeMessage2}
		</h3>
		<br>
	</div>
</div>
<div class="col-sm-12 col-md-12 col-lg-12">
	<div class="row">
		<hr>
		<!----------------------->
		<!--      Calendar     -->
		<!----------------------->
		<div class="col-sm-9 col-md-9 col-lg-9">
			<div class="panel panel-default">
				<div class="panel-body">
					<div id="calendar"></div>
				</div>
			</div>
		</div>
		<!----------------------->
		<!--    End Calendar   -->
		<!----------------------->
		<!----------------------->
		<!--   Active Course   -->
		<!----------------------->
		<div class="col-sm-3 col-md-3 col-lg-3">
			<p>
				<strong><spring:message code="message.homeStudentCourses" /></strong>
			</p>
			<c:if test="${empty courseList}">
				<br>
				<div class="alert alert-info" role="alert">
					<spring:message code="message.noCourseList" />
				</div>
			</c:if>
			<c:if test="${not empty courseList}">
				<ul>
					<c:forEach items="${courseList.list}" var="singleCourse">
						<li><a href="/lectures?path=${singleCourse.field3}">${singleCourse.field1}</a></li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		<!----------------------->
		<!-- End Active Course -->
		<!----------------------->
	</div>
</div>
<div class="col-sm-12 col-md-12 col-lg-12">
	<div class="row">
		<hr>
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<!----------------------->
			<!--   Last Lectures   -->
			<!----------------------->
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne"> <spring:message
								code="message.homeLastLecture" />
						</a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">
						<c:if test="${empty lastLectureList}">
							<br>
							<div class="alert alert-info" role="alert">
								<spring:message code="message.nolastLectureList" />
							</div>
						</c:if>
						<c:if test="${not empty lastLectureList}">
							<table class="table table-condensed">
								<thead>
									<tr>
										<th>#</th>
										<th><spring:message code="message.homeTableMsg2" /></th>
										<th><spring:message code="message.homeTableMsg4" /></th>
										<th><spring:message code="message.homeTableMsg5" /></th>
										<th><spring:message code="message.homeTableMsg7" /></th>
									</tr>
								</thead>
								<tbody>
									<c:set var="k" value="0" />
									<c:forEach items="${lastLectureList.list}" var="singleLecture">
										<tr>
											<c:set var="k" value="${k+1}" />
											<th scope="row">${k}</th>
											<td>${singleLecture.field1}</td>
											<td>${singleLecture.field2}</td>
											<td>${singleLecture.field3}</td>
											<td>${singleLecture.field4}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
					</div>
				</div>
			</div>
			<!----------------------->
			<!-- End Last Lectures -->
			<!----------------------->
			<!----------------------->
			<!--   Last Materials  -->
			<!----------------------->
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingTwo">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo"> <spring:message
								code="message.homeLastMaterialsAdded" />
						</a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingTwo">
					<div class="panel-body">
						<c:if test="${empty lastMaterialList}">
							<br>
							<div class="alert alert-info" role="alert">
								<spring:message code="message.nolastMaterialList" />
							</div>
						</c:if>
						<c:if test="${not empty lastMaterialList}">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th><spring:message code="message.homeTableMsg7" /></th>
										<th><spring:message code="message.homeTableMsg6" /></th>
										<th><spring:message code="message.homeTableMsg5" /></th>
										<th><spring:message code="message.homeTableMsg2" /></th>
									</tr>
								</thead>
								<tbody>
									<c:set var="k" value="0" />
									<c:forEach items="${lastMaterialList.list}"
										var="singleMaterial">
										<tr>
											<c:set var="k" value="${k+1}" />
											<th scope="row">${k}</th>
											<td>${singleMaterial.field1}</td>
											<td>${singleMaterial.field2}</td>
											<td>${singleMaterial.field3}</td>
											<td>${singleMaterial.field4}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>

					</div>
				</div>
			</div>
			<!----------------------->
			<!--End Last Materials -->
			<!----------------------->
			<!----------------------->
			<!--   Last Homeworks  -->
			<!----------------------->
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingThree">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseThree"
							aria-expanded="false" aria-controls="collapseThree"> <spring:message
								code="message.homeLastHomeworkCorrected" />
						</a>
					</h4>
				</div>
				<div id="collapseThree" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingThree">
					<div class="panel-body">

						<c:if test="${empty lastHomeworkList}">
							<br>
							<div class="alert alert-info" role="alert">
								<spring:message code="message.nolastHomeworkList" />
							</div>
						</c:if>
						<c:if test="${not empty lastHomeworkList}">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th><spring:message code="message.homeTableMsg7" /></th>
										<th><spring:message code="message.homeTableMsg2" /></th>
										<th><spring:message code="message.homeTableMsg3" /></th>
										<th><spring:message code="message.homeTableMsg5" /></th>
										<th><spring:message code="message.homeTableMsg8" /></th>
									</tr>
								</thead>
								<tbody>
									<c:set var="k" value="0" />
									<c:forEach items="${lastHomeworkList.list}"
										var="singleHomework">
										<tr>
											<c:set var="k" value="${k+1}" />
											<th scope="row">${k}</th>
											<td>${singleHomework.field1}</td>
											<td>${singleHomework.field2}</td>
											<td>${singleHomework.field3}</td>
											<td>${singleHomework.field4}</td>
											<td>${singleHomework.field5}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
					</div>
				</div>
			</div>			
			<!----------------------->
			<!--End Last Homeworks -->
			<!----------------------->
		</div>
	</div>
</div>
