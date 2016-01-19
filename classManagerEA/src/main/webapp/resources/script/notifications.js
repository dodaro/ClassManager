var ws = new WebSocket("ws://localhost:8080/wsexample");
takeOldNotifications();
var numberOfNewNotifications = 0;

ws.onopen = function() 
{
	ws.send("helo:" + document.getElementById("websocketUser").value);
	console.log("Connect");
};

ws.onmessage = function(evt) 
{
	console.log("Message received");
	takeNewNotifications();
};

ws.onclose = function() 
{
	console.log("Close");
};

ws.onerror = function(err) 
{
	console.log("Close");
};

function takeNewNotifications() 
{
	$.ajax(
	{
		url : '/getNewNotifications',
		datatype : 'text',
		success : function(data) 
		{
			var notifications = eval("(" + data + ")");
			console.log(notifications);
			if(notifications.length > 0)
			{
				numberOfNewNotifications += notifications.length;
				$('#badge').html('' + numberOfNewNotifications);
			}
			for (var i = 0; i < notifications.length; i++) 
			{
				var notification = notifications[i];
				drawNotification(notification, true);
			}
		}
	});
}

function takeOldNotifications() 
{
	$.ajax(
	{
		url : '/getOldNotifications',
		datatype : 'text',
		success : function(data) 
		{
			var notifications = eval("(" + data + ")");
			console.log(notifications);
			for (var i = 0; i < notifications.length; i++) 
			{
				var notification = notifications[i];
				drawNotification(notification, false);
			}
		}
	});
}

function drawNotification(notification, isNew) 
{
	var label = '';
	if(isNew)
		label = '<span class="label label-success label-notifications">New</span>';
	var source = label + '<span class="text-muted">' + notification[2] + '</span>, '
			+ '<span class="text-danger">' + notification[3] + '</span>'
			+ '<p class="text-info">' + notification[0] + '</p>';
	var div = '<div class="notificationRow">' + source + '</div>';
	var a = '<a href="' + notification[1] + '">' + div + '<a>';
	var li = '<li>' + a + '</li>'
	if(isNew)
		$('#panelNotifications').prepend(li);
	else
		$('#panelNotifications').append(li);
}
	
function resetBadge()
{
	numberOfNewNotifications = 0;
	$('#badge').html('');
	$.ajax(
	{
		url : '/setNoficationsRead',
		datatype : 'text',
		success : function(data) 
		{}
	});
}


	$('.dropdown.keep-open').on({
	    "shown.bs.dropdown": function() { this.closable = false; },
	    "click":             function() { this.closable = true; },
	    "hide.bs.dropdown":  function() { console.log("asdsd"); }
	});