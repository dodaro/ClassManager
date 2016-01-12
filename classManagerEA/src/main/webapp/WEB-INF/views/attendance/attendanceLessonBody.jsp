<!-- Se non le includo qui non funziona -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<form:form action="attendance" method="post" modelAttribute="lecture">
			<h3 class="text-muted">
				<spring:message code="message.attendance.courseAttendances" text="default text"/> 
				<spring:message code="message.attendance.lecture" text="default text"/>:
				${lecture.number} ${lecture.topic} 
				<small> - ${course.name} - ${professor.username}</small>
			</h3>
			<div class="table-responsive">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>Student</th>
							<th>Attendence</th>
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