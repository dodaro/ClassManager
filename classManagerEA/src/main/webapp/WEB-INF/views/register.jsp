<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<title>Register</title>
	</head>
	<body>
		<form:form action="register" method="POST" commandName="userRegisterForm">
			<label for="username">Username:</label><form:input type="text" name="username" path="username"/> <br>
			<label for="password">Password:</label><form:input type="password" name="password" path="password"/> <br>
			<label for="password_confirm">Conferma Password:</label><input type="password" name="password_confirm"/> <br>
			<label for="firtname">Nome:</label><form:input type="text" name="firstname" path="firstName"/> <br>
			<label for="lastname">Cognome:</label><form:input type="text" name="lastname" path="lastName"/> <br>
			<input type="submit" value="submit"/>
		</form:form>
	</body>
</html>