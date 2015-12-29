<!-- Se non le includo qui non funziona -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<form:form action="attendance" method="post" modelAttribute="lecture">
			<h3>${lecture.number}${lecture.topic} - Attendances</h3>
			<div class="table-responsive">
				<table class="table">
					<tr>
						<th>Student</th>
						<th>Attendence</th>
					</tr>
					<c:forEach items="${studentsPresent}" var="student">
						<tr>
							<td><label>${student.username}</label></td>
							<td><form:checkbox path="attendanceStudentLectures"	value="${student.username}" checked="checked" /></td>
						</tr>
					</c:forEach>
					<c:forEach items="${studentsNotPresent}" var="student">
						<tr>
							<td><label>${student.username}</label></td>
							<td><form:checkbox path="attendanceStudentLectures"	value="${student.username}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<input class="btn btn-default" type="submit" value="Update" />
		</form:form>
	</div>
</div>