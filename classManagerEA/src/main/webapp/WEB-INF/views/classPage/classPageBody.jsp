<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	var filesType = "${filesType}";	
</script>

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

		<!-- MODAL Create class-->
		<div id="createNewClass_modal" class="modal fade" role="dialog">
			<form:form id="login-form" action="/createClass" method="POST"
				commandName="lecture" role="form">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<h4 id="fileTitle_model" class="modal-title"></h4>
						</div>

						<div class="modal-body">
							<div class="form-group">
								<label for="topic">Topic:</label>
								<form:input type="text" name="topic" path="topic"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="description">Description:</label>
								<form:input type="text" name="description" path="description"
									class="form-control" />
							</div>
						</div>

						<div class="modal-footer">
							<button type="submit" class="btn btn-success">Create</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</form:form>
		</div>


		<!-- browser -->
		<div class="filemanager">

			<div class="search">
				<input type="search" placeholder="Find a file.." />
			</div>
			<div class="breadcrumbs"></div>

			<div class="row row-content">
				<div id="createNewClass_btn" class="btn btn-default">Add New</div>
				<div id="uploadFile_btn" class="btn btn-default">Upload</div>
				<div id="addHomework_btn" class="btn btn-default">add Homework</div>
				
				<div id="uploadFile_div">
					<form id="upload" method="post" action="/uploadFile"
						enctype="multipart/form-data">
						<div id="drop">
							Drop Here <a>Browse</a> <input type="file" name="file" multiple />
						</div>
						<ul>
							<!-- The file uploads will be shown here -->
						</ul>
						<input id="toUpload_input" type="hidden" name="path" />
					</form>
				</div>
			</div>

			<ul class="data"></ul>
			<div class="nothingfound">
				<div class="nofiles"></div>
				<span>No files here.</span>
			</div>
		</div>
		<!-- browser -->




		<!-- MODAL Create class-->
		<div id="addHomework_modal" class="modal fade" role="dialog">
			<form:form id="login-form" action="/addHomework" method="POST"
				commandName="homework" role="form">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<h4 id="homeworkTopic_modal" class="modal-title"></h4>
						</div>

						<div class="modal-body">
							<div class="form-group">
								<label for="name">Name:</label>
								<form:input type="text" name="name" path="name"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="description">Description:</label>
								<form:input type="text" name="description" path="description"
									class="form-control" />
							</div>
							<input id="referredLesson_input" type="hidden" name="referredLesson"></input>
						</div>

						<div class="modal-footer">
							<button type="submit" class="btn btn-success">Add</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</form:form>
		</div>



	</div>
</div>