<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
			<label for="username">Username:</label><form:input type="text" name="username" path="username"/> <br>
			<label for="password">Password:</label><form:input type="password" name="password" path="password"/> <br>
			<label for="password_confirm">Conferma Password:</label><input type="password" name="password_confirm"/> <br>
			<label for="firtname">Nome:</label><form:input type="text" name="firstname" path="firstName"/> <br>
			<label for="lastname">Cognome:</label><form:input type="text" name="lastname" path="lastName"/> <br>
			<label for="email">Email:</label><form:input type="text" name="email" path="email"/> <br>
			<label for="address">Indirizzo</label><form:input type="text" name="address" path="address"/> <br>
			<label for="birthdate">Data di nascita:</label><form:input id="datepicker" type="text" name="birthdate" path="birthDate"/> <br>
			<input type="submit" value="submit"/>
		</form:form>
	</body>
</html>