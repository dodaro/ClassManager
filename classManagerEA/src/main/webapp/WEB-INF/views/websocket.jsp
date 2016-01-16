<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
<script src="resources/lib/jquery/jquery.min.js"></script>
</head>
<body>
	<script>
	var ws = new WebSocket("ws://localhost:8080/wsexample");

	ws.onopen = function() 
	{
	    ws.send("helo:"+document.getElementById("websocketUser").value);
	};

	ws.onmessage = function(evt) 
	{
	    //document.write("Message: " + evt.data);
		takeNotifications();
	};

	ws.onclose = function() 
	{
	    document.write("<br>WebSocket closed");
	};

	ws.onerror = function(err) 
	{
	    document.write("Error: " + err);
	};
	
	function takeNotifications() 
	{		
        $.ajax(
        {
            url : 'ajaxtest',
	  		datatype : 'text',
            success : function(data) 
            {
                var notifications = eval ("(" + data + ")");
                console.log(notifications);
                $('#badge').html('' + notifications.length);
                for(var i = 0; i < notifications.length; i++)
               	{
                	var notification = notifications[i];
                	drawNotifications(notification);
               	}
            }
        });
    }
	function drawNotifications(notification)
	{		
		var source = 	'<span class="text-danger">'+notification[3]+'</span>' + 
						'<span class="text-muted">'+notification[2]+'</span>' + 
						'<spring:message code="'+notification[0]+'" text="Notification."/>';
		var div = '<div class="notificationRow">'+source+'</div>';
		var a = '<a href="'+notification[1]+'">'+div+'<a>';
		var li = '<li>'+ a +'</li>'
		$('#panelNotifications').prepend(li);
	}
	
	function sendMessage()
    {
        ws.send(document.getElementById("message").value + "");
	}
	</script>
	<input id="websocketUser" type="hidden" value="${websocketUser}" />
				
	<div id="panelNotifications">
	
	</div>	
</body>
</html>