<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-12 col-md-12 col-lg-12">
	<div class="row">
		<br>
		<h3>${welcomeMessage1}<strong> ${user.username}</strong>,
		</h3>
		<h4>${welcomeMessage2}</h4>
	</div>
	<div class="row">
		<hr>
		<div class="col-sm-3 col-md-3 col-lg-3">
			<p>
				<strong>Corsi</strong>
			</p>
			<ul>
				<li><a href="#">Corso 1</a></li>
				<li><a href="#">Corso 2</a></li>
				<li><a href="#">Corso 3</a></li>
				<li><a href="#">Corso 4</a></li>
			</ul>
		</div>
		<div class="col-sm-9 col-md-9 col-lg-9">
			<div class="panel panel-default">
				<div class="panel-body">Calendario</div>
			</div>
		</div>
		<br>
	</div>
	<div class="row">
		<hr>
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne"> Ultimi compiti sottomessi </a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Student</th>
									<th>Course</th>
									<th>Homework</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td>Mark</td>
									<td>Course 1</td>
									<td><a href="#">Homework 1</a></td>
								</tr>
								<tr>
									<th scope="row">2</th>
									<td>Jacob</td>
									<td>Course 1</td>
									<td><a href="#">Homework 2</a></td>
								</tr>
								<tr>
									<th scope="row">3</th>
									<td>Stephan</td>
									<td>Course 2</td>
									<td><a href="#">Homework 3</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingTwo">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo"> Ultime Lezioni aggiunte </a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingTwo">
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>Course</th>
									<th>Lecture</th>
									<th>Date</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td>Course 1</td>
									<td><a href="#">Lecture 1</a></td>
									<td>12/06/2014</td>
								</tr>
								<tr>
									<th scope="row">2</th>
									<td>Course 1</td>
									<td><a href="#">Lecture 2</a></td>
									<td>12/06/2014</td>
								</tr>
								<tr>
									<th scope="row">3</th>
									<td>Course 2</td>
									<td><a href="#">Lecture 3</a></td>
									<td>12/06/2014</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingThree">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseThree"
							aria-expanded="false" aria-controls="collapseThree"> Ultimi materiali aggiunti </a>
					</h4>
				</div>
				<div id="collapseThree" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingThree">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Course</th>
									<th>Material</th>
									<th>Date</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td>Course 1</td>
									<td><a href="#">Material 1</a></td>
									<td>12/06/2014</td>
								</tr>
								<tr>
									<th scope="row">2</th>
									<td>Course 2</td>
									<td><a href="#">Material 1</a></td>
									<td>12/06/2014</td>
								</tr>
								<tr>
									<th scope="row">3</th>
									<td>Course 3</td>
									<td><a href="#">Material 1</a></td>
									<td>12/06/2014</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</div>