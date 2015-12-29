
<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<div id="editCalendar_div">
			<button id="editCalendar_btn">Edit Calendar</button>
		</div>

		<div id="updateCalendar_div">
			<button id="confirm_btn">Confirm Update</button>
			<button id="revert_btn">Revert</button>
		</div>
	</div>
</div>

<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<!-- When an event is clicked the "event" field of this form is filled. If the user
		will click on the "update" button a delete request will be send to the server -->

	</div>
</div>
<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<!-- contains the calendar -->
		<div style="margin-left: 20%; margin-right: 20%;">
			<div id='calendar'></div>
		</div>
	</div>
</div>
<!-- DIV CONTENT -->
<!-- MODAL -->
<div id="createEvent_modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Create Event</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="eventTitle_create">Title: </label> <input
						class="form-control" id="eventTitle_create" type="text" /> <label
						for="eventStart">Start: </label> <input class="form-control"
						id="eventStart_create" type="text" /> <label for="eventEnd">End:</label>
					<input class="form-control" id="eventEnd_create" type="text" /> <label
						for="colorPicker">Color:</label> <select
						name="colorpicker-shortlist" id="colorPicker_create">
						<option value="#7bd148">Green</option>
						<option value="#5484ed">Bold blue</option>
						<option value="#a4bdfc">Blue</option>
						<option value="#46d6db">Turquoise</option>
						<option value="#7ae7bf">Light green</option>
						<option value="#51b749">Bold green</option>
						<option value="#fbd75b">Yellow</option>
						<option value="#ffb878">Orange</option>
						<option value="#ff887c">Red</option>
						<option value="#dc2127">Bold red</option>
						<option value="#dbadff">Purple</option>
						<option value="#e1e1e1">Gray</option>
					</select>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalButton_createEvent" type="button"
					class="btn btn-success">Create</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- MODAL UPDATE -->
<div id="updateEvent_modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Create Event</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<input class="form-control" id="eventId_update" type="hidden" /> <label
						for="eventTitle_update">Title: </label> <input
						class="form-control" id="eventTitle_update" type="text" /> <label
						for="eventStart">Start: </label> <input class="form-control"
						id="eventStart_update" type="text" /> <label for="eventEnd">End:</label>
					<input class="form-control" id="eventEnd_update" type="text" /> <label
						for="colorPicker">Color:</label> <select
						name="colorpicker-shortlist" id="colorPicker_update">
						<option value="#7bd148">Green</option>
						<option value="#5484ed">Bold blue</option>
						<option value="#a4bdfc">Blue</option>
						<option value="#46d6db">Turquoise</option>
						<option value="#7ae7bf">Light green</option>
						<option value="#51b749">Bold green</option>
						<option value="#fbd75b">Yellow</option>
						<option value="#ffb878">Orange</option>
						<option value="#ff887c">Red</option>
						<option value="#dc2127">Bold red</option>
						<option value="#dbadff">Purple</option>
						<option value="#e1e1e1">Gray</option>
					</select>
				</div>
			</div>
			<div class="modal-footer">
				<button id="delete_event_btn" type="button" data-dismiss="modal"
					class="btn btn-default">Delete</button>
				<button id="modalButton_updateEvent" type="button"
					class="btn btn-success">Update</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>