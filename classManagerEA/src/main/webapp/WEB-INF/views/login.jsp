<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<form:form action="login" method="POST" commandName="userLoginForm">
			<label for="username">Username:</label><form:input type="text" name="username" path="username"/> <br>
			<label for="password">Password:</label><form:input type="password" name="password" path="password"/> <br>
			<input type="submit" value="submit"/>
		</form:form>
	</body>
</html>