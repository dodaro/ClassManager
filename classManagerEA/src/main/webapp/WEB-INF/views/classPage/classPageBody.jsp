<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">

		<!-- SET SCORE MODAL -->
		<div id="scoreUpdate_modal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Update Score</h4>
					</div>
					<div class="modal-body">
						<input id="oldScore_modal" type="number" min="0" max="30" required>
					</div>
					<div class="modal-footer">
						<button id="score_confirm" type="button" class="btn btn-success">Update
							Score</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>

		<!-- MODAL VISUALIZE DOC -->
		<div id="visualizer_modal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 id="fileTitle_model" class="modal-title"></h4>
					</div>
					<div class="modal-body">
						<a id="visualizer" href="#"></a>
					</div>
					<div class="modal-footer">
						<button id="download_btn_modal" type="button"
							class="btn btn-default" data-dismiss="modal">Download</button>
						<button id="delete_btn_modal" type="button"
							class="btn btn-default" data-dismiss="modal">Delete</button>
					</div>
				</div>
			</div>
		</div>

		<!-- MODAL -->
		<div id="createNewClass_modal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 id="fileTitle_model" class="modal-title"></h4>
					</div>

					<div class="modal-body">
						<div class="form-group">
							<label for="eventTitle_create">Title: </label> <input
								class="form-control" id="eventTitle_create" type="text" /> <label
								for="eventStart">Start: </label> <input class="form-control"
								id="eventStart_create" type="text" /> <label for="eventEnd">End:</label>
							<input class="form-control" id="eventEnd_create" type="text" />
							<label for="colorPicker">Color:</label>
						</div>
					</div>
					<div class="modal-footer">
						<button id="modalButton_createEvent" type="button" class="btn btn-success">Create</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>

		<!-- browser -->
		<div class="filemanager">

			<div class="search">
				<input type="search" placeholder="Find a file.." />
			</div>
			<div class="breadcrumbs"></div>

			<div class="row row-content">
				<div id="createNewClass_btn" class="btn btn-default">Add New</div>
			</div>

			<ul class="data"></ul>
			<div class="nothingfound">
				<div class="nofiles"></div>
				<span>No files here.</span>
			</div>
		</div>
		<!-- browser -->

	</div>
</div>