<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h2><spring:message code="message.noticeboard" text="default text"/></h2>
<form class="form-inline" action="searchusers" method="GET" role="form">
	<label for="select"><spring:message code="message.noticesperpage" text="default text"/></label>
	<select id="page-size" class="form-control" name="users">
	  <option value="10">10</option>
	  <option value="25">25</option>
	  <option value="50">50</option>
	  <option value="100">100</option>
	</select>
	<c:if test="${not empty pageSize}">
		<input id="selected-value" type="hidden" value="${pageSize}"/>
	</c:if>
</form>
	<div class="col-sm-9 col-md-9 col-lg-10">		
		<c:forEach var="notice" items="${noticesList.getPageList()}">
	  			<div class="row">
	  				<div class="col-sm-8 col-md-8 col-lg-8">
			  			<h4>${notice.name}</h4>

			  			<h4>Prof. ${notice.professor.getLastName()}</h4>
			  			 ${notice.description}
	  				</div>
	  				<div class="col-sm-4 col-md-4 col-lg-4">
	  				 	${notice.date}
	  				</div>
	  			</div>
	  			
		 
		</c:forEach>
		
		<form id="options">
			<input name="total-pages" type="hidden" value="${pageCount}"/> 
			<input name="page-number" type="hidden" value="${pageNumber}"/> 
		</form>
		<div id="paginator">
		</div>
		
	</div>

