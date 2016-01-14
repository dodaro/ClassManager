<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
	var ws = new WebSocket("ws://localhost:8080/wsexample");

	ws.onopen = function() {
	    document.write("WebSocket opened <br>");
	    ws.send("Hello Server");
	};

	ws.onmessage = function(evt) {
	    document.write("Message: " + evt.data);
	};

	ws.onclose = function() {
	    document.write("<br>WebSocket closed");
	};

	ws.onerror = function(err) {
	    document.write("Error: " + err);
	};
	</script>
</body>
</html>