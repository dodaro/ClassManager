<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="col-sm-12 col-md-12 col-lg-12">
	<script type="text/javascript">
		$('#totalAvgLectureProfessor').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})
		$('#totalAvgLectureProfessors').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})
		$('#noLectureProfessor').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})
		$('#noLectureProfessors').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})
		$('#avgLectureProfessor').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})
		$('#avgLectureProfessors').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})
	</script>

	<div class="col-sm-12 col-md-12 col-lg-12">
		<br>
		<div class="col-sm-5 col-md-5 col-lg-5">
			<div id="idCartContainer1"></div>
		</div>
		<div class="panel panel-default col-sm-7 col-md-7 col-lg-7">
			<div class="panel-body col-sm-12 col-md-12 col-lg-12">
				<div>
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a
							href="#totalAvgLectureProfessor"
							aria-controls="totalAvgLectureProfessor" role="tab"
							data-toggle="tab"><spring:message
									code="message.statistics.Professor_AvgLectureByWeekDaySingleProfessor_TabHead" /></a></li>
						<li role="presentation"><a href="#totalAvgLectureProfessors"
							aria-controls="totalAvgLectureProfessors" role="tab"
							data-toggle="tab"><spring:message
									code="message.statistics.Professor_AvgLectureByWeekDayAllProfessor_TabHead" /></a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active"
							id="totalAvgLectureProfessor">
							<div id="idCartContainer3"></div>
						</div>
						<div role="tabpanel" class="tab-pane"
							id="totalAvgLectureProfessors">
							<div id="idCartContainer4"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-sm-12 col-md-12 col-lg-12">
		<div class="panel panel-default col-sm-12 col-md-12 col-lg-12">
			<div class="panel-body">
				<div id="idCartContainer2"></div>
			</div>
		</div>
	</div>

	<div class="col-sm-12 col-md-12 col-lg-12">
		<div class="panel panel-default col-sm-12 col-md-12 col-lg-12">
			<div class="panel-heading">
				<h3 class="panel-title">
					<spring:message code="message.statistics.Professor_Homework_Head" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div id="idCartContainer5"></div>
				</div>
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div id="idCartContainer6"></div>
				</div>
			</div>
		</div>

		<div class="panel panel-default col-sm-12 col-md-12 col-lg-12">
			<div class="panel-heading">
				<h3 class="panel-title">
					<spring:message code="message.statistics.Professor_Attendance_Head" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div id="idCartContainer7"></div>
				</div>
			</div>
		</div>
	</div>
</div>