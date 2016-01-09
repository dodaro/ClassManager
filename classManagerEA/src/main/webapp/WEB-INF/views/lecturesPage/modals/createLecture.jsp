<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

		<!-- MODAL Create lecture-->
		<c:if test="${not empty lecture}">
			<div id="createNewClass_modal${modalState}" class="modal fade" role="dialog">
				<form:form id="lecture-form" action="/lectures" method="POST"
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
									<spring:bind path="description">
										<form:input type="text" name="description" path="description" class="form-control" />
										<span class="help-block">${status.errorMessages[0]}</span>
									</spring:bind>
								</div>

								<div class="form-group">
									<label for="classroom"> <spring:message
											code="lectureManager.classroom" text="default text" />
									</label>
									<spring:bind path="classroom">
										<form:input type="text" name="classroom" path="classroom" class="form-control" />
										<span class="help-block">${status.errorMessages[0]}</span>
									</spring:bind>
								</div>

								<div class="form-group">
									<label for="date"> <spring:message
											code="lectureManager.date" text="default text" />:
									</label>
									<spring:bind path="date">
										<div class='input-group date'>
											<form:input type="text" name="date" path="date"
												class="datepicker form-control" />
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
										<span class="help-block">${status.errorMessages[0]}</span>
									</spring:bind>
								</div>

								<div class="form-group">
									<label for="beginHour">
										<spring:message code="lectureManager.beginHour" text="default text" />:
									</label>
									<spring:bind path="beginHour">
										<div class='input-group date'>
											<form:input  type="text" name="beginHour" path="beginHour" class="timepicker form-control" />
											<span class="input-group-addon">
                       		 					<span class="glyphicon glyphicon-time"></span>
                    						</span>
										</div>
										<span class="help-block">${status.errorMessages[0]}</span>
									</spring:bind>
								</div>
								
								<div class="form-group">
									<label for="endHour">
										<spring:message code="lectureManager.endHour" text="default text" />:
									</label>
									<spring:bind path="endHour">
										<div class='input-group date'>
											<form:input  type="text" name="endHour" path="endHour" class="timepicker form-control" />
											<span class="input-group-addon">
			                     		 		<span class="glyphicon glyphicon-time"></span>
			                  				</span>
										</div>
										<span class="help-block">${status.errorMessages[0]}</span>
									</spring:bind>
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