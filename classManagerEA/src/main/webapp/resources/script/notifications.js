var ws = new WebSocket("ws://localhost:8080/wsexample");

	ws.onopen = function() 
	{
	    ws.send("helo:"+document.getElementById("websocketUser").value);
	};

	ws.onmessage = function(evt) 
	{
	    //document.write("Message: " + evt.data);
		takeNewNotifications();
	};

	ws.onclose = function() 
	{
	    //document.write("<br>WebSocket closed");
	};

	ws.onerror = function(err) 
	{
	    //document.write("Error: " + err);
	};
	
	function takeNewNotifications() 
	{		
        $.ajax(
        {
            url : 'getNewNotifications',
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
		var source = 	
			'<span class="label label-success">New</span> ' + 
			'<span class="text-muted">'+notification[2]+'</span>, ' + 
			'<span class="text-danger">'+notification[3]+'</span>' + 
			'<p class="text-info">'+notification[0]+'</p>';
		var div = '<div class="notificationRow">'+source+'</div>';
		var a = '<a href="'+notification[1]+'">'+div+'<a>';
		var li = '<li>'+ a +'</li>'
		$('#panelNotifications').prepend(li);
	}
	
	function sendMessage()
    {
        ws.send(document.getElementById("message").value + "");
	}
	
function resetBadge()
{
	$('#badge').html('');
}