<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<br>
	<div class="row">
	  <div class="col-lg-6">
	    <div class="input-group">
	      <div class="input-group-btn">
	        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	        	Filter type:
	        	<span class="caret"></span>
	        </button>
	        <ul class="dropdown-menu">
	          <li><a href="#">Year</a></li>
	          <li><a href="#">StudentId</a></li>
	        </ul>
	      </div><!-- /btn-group -->
	      <input type="text" class="form-control" aria-label="..." placeholder="filter for">
	      <span class="input-group-btn">
      		<button class="btn btn-default" type="button">Go!</button>
   		 </span>
	    </div><!-- /input-group -->
	  </div><!-- /.col-lg-6 -->
	</div><!-- /.row -->
<br>
<br>

<div class=row>
	<div class="col-lg-12">
		<table id="scores_table" class="table table-bordered table-condensed">
		
			<tr>
				<th></th>
				<c:forEach items="${homeworks}" var="homework">
					<th>${homework.id}</th>
				</c:forEach>
				
				<th></th>
				<c:forEach items="${exams}" var="exam">
					<th>${exam.id }</th>
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
								<td><a class="homework" href="#" data-pk="${solutionsArray[index].id}">${solutionsArray[index].score}</a></td>
								<c:set var="index" value="${index + 1}" scope="page" />
							</c:when>
							<c:otherwise>
								<td><a class="newHomework" href="#" data-pk="${homework.id} ${student.username}"></a></td>
							</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:forEach begin="${count}" end="${fn:length(homeworks)}" varStatus="loop">
							<td></td>
						</c:forEach>
						
						<c:set var="count" value="0" scope="page" />
						<c:set var="index" value="0" scope="page" />
						<c:set var="partArray" value="${partecipations}" scope="page" />
						<c:forEach items="${exams}" var="exam">
						<c:set var="count" value="${count + 1}" scope="page" />
							<c:choose>
							<c:when test="${partArray[index].exam.id == exam.id}">
								<td><a class="exam" href="#" data-pk="${partArray[index].id}">${partArray[index].score}</a></td>
								<c:set var="index" value="${index + 1}" scope="page" />
							</c:when>
							<c:otherwise>
								<td><a class="newExam" href="#" data-pk="${exam.id} ${student.username}"></a></td>
							</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:forEach begin="${count}" end="${fn:length(exams) - 1}" varStatus="loop">
							<td></td>
						</c:forEach>
				</tr>
			</c:forEach>
			
		
		</table>
	</div>
</div>