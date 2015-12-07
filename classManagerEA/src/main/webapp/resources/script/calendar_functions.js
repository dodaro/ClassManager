$(document).ready(function() {

	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: '',
			right: 'month,agendaWeek,agendaDay'
		},
		lang: 'it',
		defaultDate: '2015-12-12',
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		views:{
			titleFormat: 'MMM D YYYY'
		},
		events: "/events",
		eventClick: function(event, element) {

			event.title = "CLICKED!";

			$('#calendar').fullCalendar('updateEvent', event);

		},
		eventDrop: function(event,dayDelta,minuteDelta,allDay,revertFunc){

			updateEvent(event,dayDelta,minuteDelta,allDay,revertFunc);
		},
		eventResize: function(event,dayDelta,minuteDelta,allDay,revertFunc){

			updateEvent(event,dayDelta,minuteDelta,allDay,revertFunc);
		}
	});
});


function updateEvent(event,dayDelta,minuteDelta,allDay,revertFunc){

	alert(event.title + " was dropped on " + event.start.format());

	if (!confirm("Are you sure about this change?")) {
		revertFunc();
	}
	else{

		var start = start === null ? start.format() : null;
		var end = end === null ? ends.format() : null;
		var eventFullCalendarBean = {'end': end, 'id': event.id, 'start': start, 'title': event.title};
		
		$.ajax({
			type: "POST",
			url: "/update_event",
			data: eventFullCalendarBean,
			dataType: 'json',
			contentType: 'application/json',
		    mimeType: 'application/json',
			success: function(){alert("success")},
			error: function(){
				alert("an error occurs");
				revertFunc();
			}
		});
	}
}
/*
events: [
{
	 title: 'All Day Event',
	 start: '2015-12-01',
	 editable: true
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
]*/