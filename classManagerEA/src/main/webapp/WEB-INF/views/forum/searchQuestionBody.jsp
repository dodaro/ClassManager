<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

	<div class="row row-content">
		<div class="col-sm-12 col-md-12 col-lg-12">

			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">

					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="panel-group" id="accordion" role="tablist">
								<div class="panel panel-default">
									<div class="panel-heading" role="tab" id="headingOne">
										<div class="panel-title">
											<div>
												<div role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> 
												 <h4><b><spring:message code="message.forum.searchQuestionForm" /></b></h4>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
										<div class="panel-body">

											<form:form commandName="searchSettings" action="searchQuestion" method="POST">

												<div class="form-group">
													<label for="questionNameInp"><spring:message code="message.forum.questionName" /></label>
													<spring:message code='message.forum.questionNamePlace' var="questionNamePlace"/> 
													<form:input path="questionName" type="text" class="form-control" id="questionNameInp" placeholder="${questionNamePlace }" ></form:input>
												</div>

												<div class="form-group">
													<label for="descriptionInp"><spring:message code="message.forum.questionDescription" /></label>
													<spring:message code='message.forum.questionDescriptionPlace'  var="descriptionPlace"/>
													<form:input path="questionDescription" type="text" class="form-control" id="descriptionInp" placeholder="${descriptionPlace }" ></form:input>
												</div>

												<div class="form-group">
													<label for="authorInp"><spring:message code="message.forum.questionAuthor" /></label>
													<spring:message code='message.forum.questionAuthorPlace' var="authorPlace" />
													<form:input path="username" type="text" class="form-control" id="authorInp" placeholder="${authorPlace }"></form:input>
												</div>

												<!-- 
												<div class="form-group">
													<label for="lectureInp">Lecture name</label>
													<form:input path="lectureName" type="text" class="form-control" id="lectureInp" placeholder="insert lecture name..."></form:input>
												</div>
												-->

												<button type="submit" class="btn btn-primary">Submit</button>
											</form:form>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="row">
										<div class="col-md-12">
											<h4>
												<b><spring:message code="message.forum.foundedQuestions" /></b>
											</h4>
										</div>
									</div>

								</div>
								<div class="panel-body">
									<div class="row">
										<div class="col-md-12">
											
											<c:forEach var="question" items="${questionsList}">
											<li class="list-group-item answerRow" data-qid="${question.getId() }">
											  <div class="row text-center">
												<div class="col-md-3">
													<div class="col-md-6">
														<div class="row"><div class="col-md-12">${question.getAnswers().size()}</div></div>
														<div class="row"><div class="col-md-12">answer</div></div>
													</div>
													<div class="col-md-6">
														<div class="row"><div class="col-md-12">15(fittizio)</div></div>
														<div class="row"><div class="col-md-12">views</div></div>
													</div>
												</div>
												<div class="col-md-9">
													<div class="row"><div class="col-md-12"><h4>
													<a class="questionLink" href="/forum/detailedQuestion?qid=${question.getId()}">${question.getTitle()}</a>
													</h4></div></div>
													<div class="row"><div class="col-md-12 text-right">${question.getUser().getUsername() }</div></div>
												</div>
											  </div>
											</li>
										</c:forEach>
										
										
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>





				</div>

			</div>

		</div>
	</div>

