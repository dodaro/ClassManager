<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-12 col-md-12 col-lg-12">
	<br>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<spring:message code="message.invitation.operation" />
			</h3>
		</div>
		<div class="panel-body">
			<ul>
				<li><a href="./requestInvitation"><spring:message
							code="message.invitation.studentOperation1" /></a></li>
				<li><a href="./checkRequestedInvitations"><spring:message
							code="message.invitation.studentOperation2" /></a></li>
			</ul>
		</div>
	</div>
</div>