//used to store temporary new events
var EventTmp = (function(){

	var tmpIds;
	var EventTmp = function(){

		tmpIds = -1;
		this.getNextId = getNextId;
	}

	var getNextId = function(){
		return tmpIds--;
	}
	return EventTmp;

})();

//init functions
$(document).ready(function() {

	createCalendar(false);
	$("#updateCalendar_div").hide();
	$("#delete_event_form").hide();
	$("#update_event_div").hide();

	eventTmp = new EventTmp();

	$('select[name="colorpicker-shortlist"]').simplecolorpicker();
});


function createCalendar(editable, currentDate){

	/*
	 * The javascript script "fullCalendar" creates and initializes the calendar.
	 * the parameters of the calendar ar defined using a JSON.
	 */
	$('#calendar').fullCalendar({

		/*
		 *defines the option to show in the header of the graphics component. Here are defined tree buttons to change
		 *the time of the visulization (prev day or month, next day or month, today) and the granularity of the visualization
		 *(month-week-day)
		 */ 
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		lang: 'it',
		defaultDate: '2015-12-12',

		//allows to modify the event shown
		editable: editable,
		// allows "more" link when too many events
		eventLimit: true,
		
		eventRender: function (event, element) {
		    element.find('.fc-event-title').html(event.title);
		},
		
		views:{
			titleFormat: 'MMM D YYYY'
		},

		/*
		 * loads the events from the server. The event should be represented in JSON format
		 */
		events: "/events",

		/*
		 * Defines what happens when an event is clicked.
		 */
		eventClick: function(calEvent, jsEvent, view) {

			//shows the delete form and fill it with the id of the event to delete
			//$("#delete_event_form").show();
			//$("#update_event_div").show();
			//$("#toDelete_input").val(event.id);
			if(editable){
				
				$("#updateEvent_modal").modal('show');
				$("#eventStart_update").val(calEvent.start.format());
				$("#eventEnd_update").val(calEvent.end.format());
				$("#eventId_update").val(calEvent.id)
				$("#eventTitle_update").val(calEvent.title)
				$('#colorPicker_update').simplecolorpicker('selectColor', calEvent.color);
			}

		},

		/*
		 * eventDrop and eventResize defines what happens when the graphical component representative of the event is moved,
		 * stretched or compressed
		 */
		eventDrop: function(event,dayDelta,minuteDelta,allDay,revertFunc){

			//updateEvent(event,dayDelta,minuteDelta,allDay,revertFunc);
		},
		eventResize: function(event,dayDelta,minuteDelta,allDay,revertFunc){

			//updateEvent(event,dayDelta,minuteDelta,allDay,revertFunc);
		},
		/*
		 * these allows to select graphically a specific range of time. In this application, when a range is selected
		 * a new event is created using the corresponding paramenters
		 */
		selectable: editable,
		selectHelper: true,
		select: 		
			function(start, end, allDay) 
			{ 
			$("#createEvent_modal").modal('show');
			$("#eventTitle_create").val("");
			$("#eventStart_create").val(start.format());
			$("#eventEnd_create").val(end.format());
			$('select[name="colorpicker"]').simplecolorpicker('selectColor', '#7bd148');

			$('#calendar').fullCalendar('unselect');
			}
	});
}

/**
 * called when the "edit" button is clicked
 */
$(document).ready(function(){	

	$("#modalButton_createEvent").click(function(event){

		var title = $("#eventTitle_create").val();
		if (title) 
		{
			var id = eventTmp.getNextId();
			var start = $("#eventStart_create").val();
			var end = $("#eventEnd_create").val();
			var color = $('#colorPicker_create').val();
			
			var eventJson = {"id" : id,"title":title,"start":start,"end":end,"color":color};
			$('#calendar').fullCalendar('renderEvent',eventJson,true);
		}
		//$('#calendar').fullCalendar('unselect');
		$("#createEvent_modal").modal('hide');
	});



	$("#modalButton_updateEvent").click(function(event)
			{
		$('#calendar').fullCalendar('removeEvents', $("#eventId_update").val());
		$('#calendar').fullCalendar('renderEvent',
				{
			id: $("#eventId_update").val(),
			title: $("#eventTitle_update").val(),
			start: $("#eventStart_update").val(),
			end: $("#eventEnd_update").val(),
			color: $('#colorPicker_update').val()
				},
				true // make the event "stick"
		);

		$("#updateEvent_modal").modal('hide');
			});

	$("#editCalendar_btn").click(function(event){

		$("#editCalendar_btn").hide();
		$("#updateCalendar_div").show();
		
		var moment = $('#calendar').fullCalendar('getDate');
		var view = $('#calendar').fullCalendar('getView');
		
		$('#calendar').fullCalendar('destroy');
		createCalendar(true);
		
		//in order to restore the date where the user was
		$('#calendar').fullCalendar('gotoDate', moment);
		$('#calendar').fullCalendar( 'changeView', view.type);
		
	});

	$("#revert_btn").click(function(event){
		revertFunc();
	});
});


/**
 * called when the "confirm update" button is clicked
 */
$(document).ready(function(){

	$("#confirm_btn").click(function(event){

		if (!confirm("Are you sure about this change?")) {
			window.redirect("/calendar");
		}

		var toSend = [];
		var calendar = $('#calendar').fullCalendar('clientEvents');
		$.each(calendar, function( index, value ) {

			var event = new Object();

			event.id = value.id;
			event.title = value.title;
			event.startDate = value.start.format();
			if(value.end != null)
			event.endDate = value.end.format();
			event.color = value.color;

			toSend.push(event);
		});

		calendar = JSON.stringify(toSend);

		$.ajax({ 
			headers: {
				Accept : "text/plain; charset=utf-8"
			},
			url: "/update_calendar", 
			type: 'POST', 
			dataType: 'json', 
			data: calendar, 
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(data) { 
				window.redirect("/calendar");
			},
			error:function(data,status,er) { 
				revertFunc();

			}
		});
	});
});

/**
 * called when the "delete" button is clicked
 */
$(document).ready(function(){

	$("#delete_event_btn").click(function(event){

		var eventToRemove = $("#eventId_update").val();
		$('#calendar').fullCalendar('removeEvents', eventToRemove);
	});
});

function revertFunc(){
	window.location.replace("/calendar");
}

/* TODO USE DATE AND HOURS
 * TODO CHECK INPUT AND DATE VALIDITY
 */

/*
events: [
{
	 title: 'All Day Event',
	 start: '2015-12-01',
	 editable: true
	 dow: [1, 4];
},
{
	 title: 'Long Event',
	 start: '2015-12-07',
	 end: '2015-12-10'
},
{
	 id: 999,
	 title: 'Repeating Event',
	 start: '2015-12-09T16:00:00'
},
{
	 id: 999,
	 title: 'Repeating Event',
	 start: '2015-12-16T16:00:00'
},
{
	 title: 'Conference',
	 start: '2015-12-11',
	 end: '2015-12-13'
},
{
	 title: 'Meeting',
	 start: '2015-12-12T10:30:00',
	 end: '2015-12-12T12:30:00'
},
{
	 title: 'Lunch',
	 start: '2015-12-12T12:00:00'
},
{
	 title: 'Meeting',
	 start: '2015-12-12T14:30:00'
},
{
	 title: 'Happy Hour',
	 start: '2015-12-12T17:30:00'
},
{
	 title: 'Dinner',
	 start: '2015-12-12T20:00:00'
},
{
	 title: 'Birthday Party',
	 start: '2015-12-13T07:00:00'
},
{
	 title: 'Click for Google',
	 url: 'http://google.com/',
	 start: '2015-12-28'
}
]

/*
 * sends an Ajax request to the server when an event is modify in order to store the new information
 */
/*function updateEvent(event,dayDelta,minuteDelta,allDay,revertFunc){

	alert(event.title + " was dropped on " + event.start.format());

	if (!confirm("Are you sure about this change?")) {
		revertFunc();
	}
	else{

		var end = event.end.format();//.split("-");
		//var endDate = new Date(end[2], end[1] - 1, end[0]);

		var start = event.start.format();//.split("-");
		//var startDate = new Date(start[2], start[1] - 1, start[0]);

		var event = {'endDate': start, 'id': event.id, 'startDate': end, 'title': event.title};

		$.ajax({ 
			headers: {
				Accept : "text/plain; charset=utf-8"
			},
			url: "/update_event", 
			type: 'POST', 
			dataType: 'json', 
			data: JSON.stringify(event), 
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(data) { 
				window.redirect("/calendar");
			},
			error:function(data,status,er) { 
				alert("error: "+data+" status: "+status+" er:"+er);
				revertFunc();

			}
		});


	}
}

/*
 * sends an Ajax request to the server when an event is created in order to store the new information
 */
/*function createEvent(title,start,end){


	var end = end.format();//.split("-");
	//var endDate = JSON.stringify(new Date(end[2], end[1] - 1, end[0]));

	var start = start.format();//.split("-");
	//var startDate = new Date(start[2], start[1] - 1, start[0]).toString();

	var event = {'endDate': start, 'id': tmpIds, 'startDate': end, 'title': event.title};

	$.ajax({ 
		headers: {
			Accept : "text/plain; charset=utf-8"
		},
		url: "/create_event", 
		type: 'POST', 
		dataType: 'json', 
		data: JSON.stringify(event), 
		contentType: 'application/json',
		mimeType: 'application/json',
		success: function(data) { 
			window.redirect("/calendar");
		},
		error:function(data,status,er) { 
			alert("error: "+data+" status: "+status+" er:"+er);
			revertFunc();

		}
	});

}

/**
 * called when the "delete" button is clicked
 */
/*$(document).ready(function(){

	$("#delete_event_submit").click(function(event){

		if (!confirm("Are you sure about this change?")) {
			event.preventDefault();
		}
	});
});
 */