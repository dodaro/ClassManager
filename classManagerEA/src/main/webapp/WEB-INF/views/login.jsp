<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<form:form action="login" method="POST" commandName="userLoginForm">
			<table>
				<tr>
				  <td><label for="username">Username:</label></td>
				  <td><form:input type="text" name="username" path="username"/></td> 
				  <td><form:errors path="username" cssClass="error"/></td>
				</tr>
				<tr>
				  <td><label for="password">Password:</label></td>
				  <td><form:input type="password" name="password" path="password"/></td> 
				  <td><form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit"/></td><td><a href="register"><spring:message code="message.register" text="default text"/></a></td>
				</tr>
			</table>
		</form:form>
		<div>${error}</div>	
	</body>
</html>