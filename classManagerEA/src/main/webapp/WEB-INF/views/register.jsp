<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
		<title>Register</title>
		
		<link href="resources/lib/jquery-ui/jquery-ui.css" rel="stylesheet"		 />
		
		<script type="text/javascript" src="resources/lib/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="resources/lib/jquery-ui/jquery-ui.js"></script>
		<script type="text/javascript" src="resources/script/register.js"></script>
	</head>
	<body>
		<form:form action="register" method="POST" commandName="userRegisterForm">
		
			<table>
				<tr>
				  <td><label for="username">Username:</label></td>
				  <td><form:input type="text" name="username" path="username"/></td> 
				  <td><form:errors path="username" cssClass="error"/><br></td>
				</tr>
				<tr>
				  <td><label for="password">Password:</label></td>
				  <td><form:input type="password" name="password" path="password"/></td> 
				  <td><form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
				  <td><label for="password_confirm"><spring:message code="message.passwordConfirm" text="default text"/>:</label></td>
				  <td><form:input type="password" name="confirmPassword" path="confirmPassword"/></td> 
				  <td><form:errors path="confirmPassword" cssClass="error"/></td>
				</tr>
				<tr>
				  <td><label for="firstname"><spring:message code="message.firstName" text="default text"/>:</label></td>
				  <td><form:input type="text" name="firstname" path="firstName"/></td> 
				  <td><form:errors path="firstName" cssClass="error"/></td>
				</tr>
				<tr>
				  <td><label for="lastname"><spring:message code="message.lastName" text="default text"/>:</label></td>
				  <td><form:input type="text" name="lastname" path="lastName"/></td> 
				  <td><form:errors path="lastName" cssClass="error"/></td>
				</tr>
				<tr>
				  <td><label for="email">Email:</label></td>
				  <td><form:input type="text" name="email" path="email"/></td> 
				  <td><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
				  <td><label for="address"><spring:message code="message.address" text="default text"/>:</label></td>
				  <td><form:input type="text" name="address" path="address"/></td> 
				  <td></td>
				</tr>
				<tr>
				  <td><label for="birthdate"><spring:message code="message.birthDate" text="default text"/>:</label></td>
				  <td><form:input id="datepicker" type="text" name="birthdate" path="birthDate"/></td> 
				  <td><form:errors path="birthDate" cssClass="error"/></td>
				</tr>
	
				
				<tr>
					<spring:message code="message.register" text="default text" var="registerLabel"/>
					<td><input type="submit" value="${registerLabel}"/></td>
				</tr>
			</table>
		
		
		
		</form:form>
		<div>${error}</div>
	</body>
</html>