<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>

<link href='resources/lib/jquery-ui/jquery-ui.css' rel='stylesheet' />
<link href='resources/lib/fullcalendar-2.5.0/fullcalendar.css'
	rel='stylesheet' />
<link href='resources/lib/fullcalendar-2.5.0/fullcalendar.print.css'
	rel='stylesheet' media='print' />

<script src='resources/lib/jquery/jquery.min.js'></script>
<script src='resources/lib/jquery-ui/jquery-ui.js'></script>
<script src='resources/lib/fullcalendar-2.5.0/lib/moment.min.js'></script>
<script src='resources/lib/fullcalendar-2.5.0/fullcalendar.min.js'></script>
<script src='resources/lib/fullcalendar-2.5.0/lang-all.js'></script>

<script src='resources/script/calendar_functions.js'></script>

</head>
<body>

	<!-- contains the calendar -->
	<div style="margin-left: 20%; margin-right: 20%;">
		<div id='calendar'></div>
	</div>

	<!-- When an event is clicked the "event" field of this form is filled. If the user
	will click on the "delete" button a delete request will be send to the server -->
	<form:form id="delete_event_form" action="/delete_event" method="post" commandName="FullCalendarEventBean">
		<form:input type="hidden" path="id" />
		<input id="delete_event_submit" type="submit" value="Delete">
	</form:form>

</body>
</html>
