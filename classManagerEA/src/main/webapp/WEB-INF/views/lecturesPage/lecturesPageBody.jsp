<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row row-content">
	<div class="col-sm-12 col-md-12 col-lg-12">

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
							class="btn btn-default" data-dismiss="modal">
							<spring:message code="lectureManager.download"
								text="default text" />
						</button>
					</div>
				</div>
			</div>
		</div>

		<!-- MODAL Create lecture-->
		<c:if test="${not empty lecture}">
			<div id="createNewClass_modal" class="modal fade ${fade}" role="dialog" style="display: ${display};">
				<form:form id="lecture-form" action="/createLecture" method="POST"
					commandName="lecture" role="form">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<h4 id="fileTitle_model" class="modal-title"></h4>
							</div>

							<div class="modal-body">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label for="topic"> <spring:message
											code="lectureManager.topic" text="default text" />
									</label>
									<spring:bind path="topic">
										<form:input type="text" name="topic" path="topic" class="form-control" />
										<span class="help-block">${status.errorMessages[0]}</span>
									</spring:bind>
								</div>
								
								<div class="form-group">
									<label for="description"> <spring:message
											code="lectureManager.description" text="default text" />
									</label>
									<form:input type="text" name="description" path="description"
										class="form-control" />
								</div>

								<div class="form-group">
									<label for="classroom"> <spring:message
											code="lectureManager.classroom" text="default text" />
									</label>
									<form:input type="text" name="classroom" path="classroom"
										class="form-control" />
								</div>
								
								<div class="form-group">
									<label for="date">
										<spring:message code="lectureManager.date" text="default text" />:
									</label>
									<form:input type="text" name="date" path="date" readonly='true' class="form-control datepicker" />
								</div>
								
								<form:input id="createLectureModal_id" type="hidden" name="id" path="id"/>
							</div>

							<div class="modal-footer">
								<button type="submit" class="btn btn-success">
									<spring:message code="lectureManager.done" text="default text" />
								</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">
									<spring:message code="lectureManager.close" text="default text" />
								</button>
							</div>

						</div>
					</div>
				</form:form>
			</div>
		</c:if>


		<!-- browser -->
		<div class="filemanager">

			<div class="search">
				<input type="search" placeholder="Find a file.." />
			</div>
			<div class="breadcrumbs"></div>

			<div class="row row-content">

				<c:if test="${not empty lecture}">
					<div id="createNewClass_btn" class="btn btn-default">
						<spring:message code="lectureManager.addNewLecture"
							text="default text" />
					</div>
				</c:if>
				<c:if test="${not empty pwd && pwd != 'lectures' && pwd != 'homeworks'}">
					<div id="uploadFile_btn" class="btn btn-default">
						<spring:message code="lectureManager.upload" text="default text" />
					</div>
				</c:if>
				<c:if test="${not empty homework}">
					<div id="addHomework_btn" class="btn btn-default">
						<spring:message code="lectureManager.addHomework"
							text="default text" />
					</div>
				</c:if>

				<div id="uploadFile_div" style="display: none;">
					<form id="upload" method="post" action="/upload_${pwd}"
						enctype="multipart/form-data">
						<div id="drop">
							<spring:message code="lectureManager.drophere"
								text="default text" />
							<a> <spring:message code="lectureManager.browse"
									text="default text" />
							</a> <input type="file" name="file" multiple />
						</div>
						<ul>
							<!-- The file uploads will be shown here -->
						</ul>
						<div class="btn btn-default" id="file_upload_btn"
							style="margin-top: 15px">
							<spring:message code="lectureManager.done" text="default text" />
						</div>
						<input id="toUpload_input" type="hidden" name="parentId"
							value="${parentId}" />
					</form>
				</div>
			</div>

			<ul class="data">
				<c:choose>
					<c:when test="${not empty files}">
						<c:set var="index" value="0" scope="page"/>  
						<c:set var="contentsArray" value="${contents}" scope="page"/>
						<c:forEach var="file" items="${files}">
							
							<li class="${file.type}">
								<form action="${file.action}">

									<input type="hidden" name="id" value="${contentsArray[index].id}"></input> 
									
									<c:if test="${not empty lecture}">
										<input type="hidden" name="topic" value="${contentsArray[index].topic}"></input>
										<input type="hidden" name="date" value="${contentsArray[index].date}"></input>
										<input type="hidden" name="beginHour" value="${contentsArray[index].beginHour}"></input>
										<input type="hidden" name="endHour" value="${contentsArray[index].beginHour}"></input>
										<input type="hidden" name="classroom" value="${contentsArray[index].classroom}"></input>
									</c:if>
									
									<c:if test="${not empty homework}"><input type="hidden" name="name" value="${contentsArray[index].name}"></input></c:if>
									
									<input type="hidden" name="description" value="${contentsArray[index].description}"></input>
									<input type="hidden" name="path" value="${file.path}"></input>
									<input type="hidden" name="parentId" value="${file.parentId}"></input>
									<input type="submit" style="display: none;"></input>

									<c:if test="${file.type == 'folder'}">

										<div onClick="this.parentNode.submit()" title="${file.name}"
											class="${file.type}">
											<span class="icon ${file.type}"></span> <span class="name">${file.name}</span>
											<span class="details"> <c:choose>
													<c:when test="${file.childs != 0}">
														${file.childs} <spring:message code="lectureManager.items"
															text="default text" />
													</c:when>
													<c:otherwise>
														<spring:message code="lectureManager.empty"
															text="default text" />
													</c:otherwise>
												</c:choose>
											</span> 
											<c:if test="${not empty pwd}">
												<span onclick="delete_${pwd}(event);" class="glyphicon glyphicon-trash" style="color: white"></span>
												<span onclick="update_${pwd}(event);" class="glyphicon glyphicon-pencil" style="color: white"></span>
											</c:if>
										</div>
									</c:if>

									<c:if test="${file.type == 'file'}">
										<div title="${file.name}" class="${file.type}">
											<span class="icon ${file.type} f-${file.extension}">.${file.extension}</span>
											<span class="name">${file.name}</span>
											<span class="details">${file.size} Bytes</span>
											<span onclick="delete_${pwd}(event);" class="glyphicon glyphicon-trash" style="color: white"></span>
											<span onclick="alert();" class="glyphicon glyphicon-download-alt" style="color: white"></span>
										</div>
									</c:if>

								</form>
							</li>
							<c:set var="index" value="${index + 1}"/>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="nothingfound">
							<div class="nofiles"></div>
							<span><spring:message code="lectureManager.nofileshere"
									text="default text" /></span>
						</div>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!-- browser -->




		<!-- MODAL addHomework-->
		<c:if test="${not empty homework}">
			<div id="addHomework_modal" class="modal fade" role="dialog">
				<form:form id="homework-form" action="/addHomework" method="POST"
					commandName="homework" role="form">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<h4 id="homeworkTopic_modal" class="modal-title"></h4>
							</div>

							<div class="modal-body">
								<div class="form-group">
									<label for="name"> <spring:message
											code="lectureManager.name" text="default text" />:
									</label>
									<form:input type="text" name="name" path="name"
										class="form-control" />
								</div>
								<div class="form-group">
									<label for="description"> <spring:message
											code="lectureManager.description" text="default text" />
									</label>
									<form:input type="text" name="description" path="description"
										class="form-control" />
								</div>

								<form:input id="addHomeworkModal_id" type="hidden" name="id" path="id" class="form-control" />
								<input type="hidden" name="parentId" value="${parentId}"></input>
								
							</div>

							<div class="modal-footer">
								<button type="submit" class="btn btn-success">
									<spring:message code="lectureManager.done" text="default text" />
								</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">
									<spring:message code="lectureManager.close" text="default text" />
								</button>
							</div>

						</div>
					</div>
				</form:form>
			</div>
		</c:if>


	</div>
</div>