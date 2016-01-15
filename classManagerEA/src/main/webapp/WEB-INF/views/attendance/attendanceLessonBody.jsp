<!-- Se non le includo qui non funziona -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<form:form action="attendance" method="post" modelAttribute="lecture">
			<h3 class="text-muted">
				<spring:message code="message.attendance.courseAttendances" text="Attendances"/> 
				<spring:message code="message.attendance.lecture" text="Lecture"/>
			</h3>
			<h3 class="text-muted">				
				${lecture.number} ${lecture.date} 
				<small> - ${course.name} - ${professor.username}</small>
			</h3> 
			<h3 class="text-muted">				
				${lecture.topic} 
				<small> - ${course.name} - ${professor.username}</small>
			</h3> 
			<div class="table-responsive">
				<table class="tablesorter table table-condensed" id="myTable">
					<thead>
						<tr>
							<th>
								<spring:message code="message.attendance.students" text="Students"/>
								<span class="glyphicon glyphicon-chevron-up headerSortDown"></span>
								<span class="glyphicon glyphicon-chevron-down headerSortUp"></span>
							</th>
							<th><spring:message code="message.attendance.courseAttendances" text="Attendances"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${studentsPresent}" var="student">
							<tr>
								<td>${student.username}</td>
								<td><form:checkbox path="attendanceStudentLectures"	value="${student.username}" checked="checked" /></td>
							</tr>
						</c:forEach>
						<c:forEach items="${studentsNotPresent}" var="student">
							<tr>
								<td>${student.username}</td>
								<td><form:checkbox path="attendanceStudentLectures"	value="${student.username}" /></td>
							</tr>
						</c:forEach>				
					</tbody>
				<tr>
					<td></td>
					<td><input class="btn btn-default" type="submit" value="Update" /></td>
				</tr>
				</table>
			</div>
			
		</form:form>
	</div>
</div>