<!-- Se non le includo qui non funziona -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<h3 class="text-muted"><spring:message code="message.attendance.courseAttendances" text="default text"/> ${course.name} <small> - ${professor.username}</small></h3>
	</div>
</div>
<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<div class="table-responsive">
			<table class="tablesorter table table-condensed">
				<thead>
					<tr>
						<th class="sortable">
							<spring:message code="message.attendance.students" text="default text"/>
							<span class="glyphicon glyphicon-chevron-up headerSortDown"></span>
							<span class="glyphicon glyphicon-chevron-down headerSortUp"></span>
						</th>
						<th><spring:message code="message.attendance.lectures" text="default text"/></th>
						<c:forEach items="${lectures}" var="lecture">
							<th>${lecture.number}</th>
						</c:forEach>
					<tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>${student.username}</td>
							<td></td>
	
							<c:set var="count" value="0" scope="page" />
							<c:set var="index" value="0" scope="page" />
							<c:set var="lecturesArray"
								value="${student.attendanceStudentLectures}" scope="page" />
							<c:forEach items="${lectures}" var="lecture">
								<c:set var="count" value="${count + 1}" scope="page" />
								<c:choose>
									<c:when test="${lecturesArray[index].lecture.number == count}">
										<td><span><i class="glyphicon glyphicon-ok"></i></span></td>
										<c:set var="index" value="${index + 1}" scope="page" />
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:forEach begin="${count}" end="${fn:length(lectures)}" varStatus="loop">
								<td></td>
							</c:forEach>
						</tr>	
					</c:forEach>				
				</tbody>
				<tr>
					<td></td>
					<td></td>
					<c:forEach items="${lectures}" var="lecture">
						<td>
							<form:form action="attendance" method="get"	modelAttribute="lecture" id="modifyAttendance">
								<form:input path="id" value="${lecture.id}" hidden="true" />
								<a href="javascript:{}" onclick="document.getElementById('modifyAttendance').submit();" class="no-text-decoration">
									<span class="glyphicon glyphicon-pencil fa-4x"></span>
								</a>
								<input type="hidden" value="Modify" class="btn-link" />
							</form:form>
						</td>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</div>