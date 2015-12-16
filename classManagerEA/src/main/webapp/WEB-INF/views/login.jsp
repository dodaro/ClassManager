<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- <html> -->
<!-- 	<head> -->
<!-- 		<title>Login</title> -->
<!-- 	</head> -->
<!-- 	<body> -->
		<form:form action="login" method="POST" commandName="userLoginForm" role="form">
		<div class="form-group">
		  <label for="username">Username:</label></td>
		  <form:input type="text" name="username" path="username"  class="form-control"/>
		  <form:errors path="username" cssClass="error"/>
		</div>
		<div class="form-group">
		  <label for="password">Password:</label>
		  <form:input type="password" name="password" path="password"  class="form-control"/>
		  <form:errors path="password" cssClass="error"/>
		</div>
		  <button type="submit" class="btn btn-default">Login</button>
		  <a href="register"><spring:message code="message.register" text="default text"/></a>
		</form:form>
		<div>${error}</div>	
<!-- 	</body> -->
<!-- </html> -->