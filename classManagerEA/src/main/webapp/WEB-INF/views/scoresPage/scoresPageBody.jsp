<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<br>

<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-addon" id="basic-addon1">
	  	<span class="glyphicon glyphicon-filter"></span>
	  </span>
	  
	  <spring:message code="scores.typeForFilter" text="default text" var="message"/>
      <input id="filter" name="filterText" type="text" class="form-control" aria-label="..." placeholder="${message}">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  
</div><!-- /.row -->
<br>

<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#filters_collapse" aria-expanded="false">
	<spring:message code="scores.moreFilters"/>
</button>
<div class="row collapse" id="filters_collapse">
	  <div class="col-lg-8">
	     <form action="/scores">
		      	<div class="input-group">
		      		
			 		<span class="input-group-addon">Lezione</span>
					<select name="lectureFilter" class="form-control">
				        <c:forEach items="${lectures}" var="item" varStatus="count"> 
				            <option value="${item.id}">${item.number} - ${item.topic}</option>
				        </c:forEach>
				        <option value="" selected><spring:message code="scores.all"/></option>
				    </select> 
				    
			     			
			  		<span class="input-group-addon"><spring:message code="scores.examYear"/></span>
			  		<input name="yearFilter" type="text" class="form-control" placeholder="exam year..">
			  		
			  		<span class="input-group-btn">
	      				<button id="filter_btn" class="btn btn-success" type="submit">
							<spring:message code="scores.apply"/>
						</button>
	   		  		</span>
	   		  	
		  		</div>

	      </form>
	  </div><!-- /.col-lg-6 -->
	  
	<div class="btn-group" data-toggle="buttons">
	  <label class="btn btn-primary active">
	    <input id="exams_checkbox" type="checkbox" checked><spring:message code="scores.exams"/>
	  </label>
	  <label class="btn btn-primary active">
	    <input id="homeworks_checkbox" type="checkbox" checked><spring:message code="scores.homework"/>
	  </label>
	</div>
</div>
	

<br>
<br>

<div class=row>
	<div class="col-lg-12">
		<table id="scores_table" class="table table-bordered table-condensed">
			<thead>
				<tr>
					<th></th>
					<c:forEach items="${homeworks}" var="homework">
						<c:choose>
							<c:when test="${not empty lectureId}">
								<c:if test="${homework.lecture.id == lectureId}">
									<th class="homework-td">${homework.name}</th>
								</c:if>
							</c:when>
							<c:otherwise>
								<th class="homework-td">${homework.name}</th>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:forEach items="${exams}" var="exam">
						<c:choose>
							<c:when test="${not empty yearFilter}">
								<c:if test="${exam.date.getYear() == yearFilter}">
									<fmt:formatDate value="${exam.date}"  type="date"  pattern="dd-mm-yyyy" var="formattedDate" />
									<th class="exam-td" style="color:red"><spring:message code="scores.exam"/>: ${formattedDate}</th>
								</c:if>
							</c:when>
							<c:otherwise>
								<fmt:formatDate value="${exam.date}"  type="date"  var="formattedDate" />
								<th class="exam-td" style="color:red"><spring:message code="scores.exam"/>: ${formattedDate}</th>							
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</tr>	
			</thead>
			
			<tbody class="searchable">
			<c:forEach items="${students}" var="student">
				
				<tr>
						<td>${student.username}</td>
		
						<c:set var="count" value="0" scope="page" />
						<c:set var="index" value="0" scope="page" />
						<c:set var="solutionsArray" value="${student.homeworkStudentSolvings}" scope="page" />
						
						<c:forEach items="${homeworks}" var="homework">
								<c:set var="count" value="${count + 1}" scope="page" />						
								<c:choose>
									<c:when test="${not empty lectureId}">
										<c:if test="${homework.lecture.id == lectureId}">
											<c:choose>
												<c:when test="${solutionsArray[index].homework.id == homework.id}">
													<td class="homework-td"><a class="homework" href="#" data-pk="${solutionsArray[index].id}">${solutionsArray[index].score}</a></td>
													<c:set var="index" value="${index + 1}" scope="page" />
												</c:when>
												<c:otherwise>
													<td class="homework-td"><a data-type="address" class="newHomework" href="#" data-pk="${homework.id} ${student.username}"></a></td>
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${solutionsArray[index].homework.id == homework.id}">
												<td class="homework-td"><a class="homework" href="#" data-pk="${solutionsArray[index].id}">${solutionsArray[index].score}</a></td>
												<c:set var="index" value="${index + 1}" scope="page" />
											</c:when>
											<c:otherwise>
												<td class="homework-td"><a data-type="address" class="newHomework" href="#" data-pk="${homework.id} ${student.username}"></a></td>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
						</c:forEach>
						
						
						<%-- ><c:forEach begin="${count}" end="${fn:length(homeworks) - 2}" varStatus="loop">
							<td></td>
						</c:forEach>--%>
						
						<c:set var="count" value="0" scope="page" />
						<c:set var="index" value="0" scope="page" />
						<c:set var="partArray" value="${partecipations}" scope="page" />
						<c:forEach items="${exams}" var="exam">
							<c:set var="count" value="${count + 1}" scope="page" />
								<c:choose>
									<c:when test="${not empty yearFilter}">
										<c:if test="${exam.date.getYear() == yearFilter}">
											<c:choose>
												<c:when test="${partArray[index].exam.id == exam.id}">
													<td class="exam-td"><a class="exam" href="#" data-pk="${partArray[index].id}">${partArray[index].score}</a></td>
													<c:set var="index" value="${index + 1}" scope="page" />
												</c:when>
												<c:otherwise>
													<td class="exam-td"><a data-type="address" class="newExam" href="#" data-pk="${exam.id} ${student.username}"></a></td>
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${partArray[index].exam.id == exam.id}">
												<td class="exam-td"><a class="exam" href="#" data-pk="${partArray[index].id}">${partArray[index].score}</a></td>
												<c:set var="index" value="${index + 1}" scope="page" />
											</c:when>
											<c:otherwise>
												<td class="exam-td"><a data-type="address" class="newExam" href="#" data-pk="${exam.id} ${student.username}"></a></td>
											</c:otherwise>
										</c:choose>										
									</c:otherwise>
								</c:choose>
						</c:forEach>
						
						<c:forEach begin="${count}" end="${fn:length(exams) - 1}" varStatus="loop">
							<td></td>
						</c:forEach>
				</tr>
				
			</c:forEach>
		
		</tbody>
	  </table>
	</div>
</div>