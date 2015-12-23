<!-- Se non le includo qui non funziona -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<div class="table-responsive">
			<table class="table">
				<tr>
					<th></th>
					<c:forEach items="${lectures}" var="lecture">
						<th>${lecture.number} ${lecture.topic}</th>
					</c:forEach>
				</tr>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.username}</td>

						<c:set var="count" value="0" scope="page" />
						<c:set var="index" value="0" scope="page" />
						<c:set var="lecturesArray"
							value="${student.attendanceStudentLectures}" scope="page" />
						<c:forEach items="${lectures}" var="lecture">
							<c:set var="count" value="${count + 1}" scope="page" />
							<c:choose>
								<c:when test="${lecturesArray[index].lecture.number == count}">
									<td>v</td>
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
				<tr>
					<th></th>
					<c:forEach items="${lectures}" var="lecture">
						<th><form:form action="attendance" method="get"	modelAttribute="lecture">
								<form:input path="id" value="${lecture.id}" hidden="true" />
								<input type="submit" value="Modify" class="btn-link" />
							</form:form></th>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</div>