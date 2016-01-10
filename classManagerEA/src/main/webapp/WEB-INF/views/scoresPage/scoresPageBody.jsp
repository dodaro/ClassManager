<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<p>
	<button type="button" onClick="sendData()" class="btn btn-default">Update Scores</button>
</p>
<table id="scores_table" class="table table-bordered table-condensed">

	<tr>
		<th></th>
		<c:forEach items="${homeworks}" var="homework">
			<th>${homework.id}</th>
		</c:forEach>
	</tr>
	
	<c:forEach items="${students}" var="student">
		<tr>
				<td>${student.username}</td>

				<c:set var="count" value="0" scope="page" />
				<c:set var="index" value="0" scope="page" />
				<c:set var="solutionsArray" value="${student.homeworkStudentSolvings}" scope="page" />
				<c:forEach items="${homeworks}" var="homework">
				<c:set var="count" value="${count + 1}" scope="page" />
					<c:choose>
					<c:when test="${solutionsArray[index].homework.id == homework.id}">
						<td><a href="#" data-pk="${solutionsArray[index].id}">${solutionsArray[index].score}</a></td>
						<c:set var="index" value="${index + 1}" scope="page" />
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:forEach begin="${count}" end="${fn:length(homeworks)}" varStatus="loop">
					<td></td>
				</c:forEach>
		</tr>
	</c:forEach>
	

</table>