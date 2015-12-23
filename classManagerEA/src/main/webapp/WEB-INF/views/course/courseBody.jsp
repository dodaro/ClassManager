<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row row-content">
	<div class="col-sm-6 col-md-6 col-lg-6">
		<h3 class="text-muted">Courses <small>- ${professor.username}</small></h3>
	</div>
	<div class="col-sm-6 col-md-6 col-lg-6">
		<div style="float:right;">
			<a href="#" class="btn btn-success" data-toggle="modal" data-target="#myModal">
		      	<span class="glyphicon glyphicon-plus"></span> Add
		    </a>
	    </div>
	</div>
</div>
<div class="row row-content">
	<c:forEach items="${courses}" var="course">
		<div class="col-md-4">
			<a href="#" class="no-text-decoration">
				<div class="panel panel-default course">
					<div class="panel-body">
						<h4 class="text-info">${course.name}</h4>
						<p class="text-muted">CFU: ${course.cfu}</p>
						<p class="text-muted">Activation date: ${course.activationDate}</p>
						<p class="text-muted">End date: ${course.endDate}</p>
						<p class="text-muted">Reference year: ${course.referenceYear}</p>
						<p class="text-primary">Degree: ${course.degreeCourse.name}</p>
					</div>
				</div>
			</a>
		</div>
	</c:forEach>
</div>


<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  	<div class="modal-dialog">
	    <!-- Modal content-->
	    <div class="modal-content">
	      	<div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        	<h4 class="modal-title">Create course</h4>
	      	</div>
	      	<div class="modal-body">
	      		<form:form action="courses" method="post" modelAttribute="courseForm" role="form">
		        	<div class="form-group">
	   					 <label for="name">Name</label>
					    <form:input type="text" path="name" class="form-control" id="name" placeholder="Name" />
					</div>
					<div class="form-group">
						<label for="cfu">CFU</label>
					    <form:input type="number" path="cfu" class="form-control" id="cfu" placeholder="CFU" min="1" max="12" />
					</div>
	 					<div class="form-group"> 
	 						<label for="activationDate">Activation Date</label>
	 						<!-- Provare con sto input date -->
					    	<form:input type="text" path="activationDate" class="form-control" id="activationDate" />
 						</div>					 
						<%-- <div class="form-group"> 
							<label for="endDate">End Date</label>
					    	<form:input type="date" path="endDate" class="form-control" id="endDate" />
						</div> --%>
					<div class="form-group">
						<label for="referenceYear">Reference Year</label>
					    <form:input type="number" path="referenceYear" class="form-control" id="referenceYear" placeholder="Reference Year"  min="1" max="3" />
					</div>
					<%-- <div class="form-group">
						<label for="sel1">Degree Course: </label>
						<form:select path="degreeCourse" class="form-control" id="sel1">
							<c:forEach items="${degreeCourses}" var="degreeCourse">
								<option value="${degreeCourse}">${degreeCourse.name}</option>
							</c:forEach>
						</form:select>
					</div> --%>
	      	 		<button type="submit" class="btn btn-success">Submit</button>
	      	 	</form:form>
	      	</div>
	      	<div class="modal-footer">
	        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      	</div>
	    </div>	
	 </div>
</div>