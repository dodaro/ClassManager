<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Welcome To Class Manager</title>
</head>
<body>
	<h1>This is the welcome web page</h1>
	<a href="register">Register</a>
	<br>
	<a href="login">Login</a>
	<br>

	<c:if test="${empty loggedIn}">
		<a id="login-button" class="nav-bar-button login" href="#"><span
			class="glyphicon glyphicon-log-out"></span>Login</a>
	</c:if>

	<!-- Modal For Login-->
	<%@include file="pageCommons/loginModal.jsp"%>

	<!-- Modal For Register-->
	<%@include file="pageCommons/registerModal.jsp"%>
</body>
</html>
