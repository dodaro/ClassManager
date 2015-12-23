<!DOCTYPE html>
<%@include file="includeJSP.jsp"%>
<html>
<head>
<%@include file="head.jsp"%>
<c:forEach items="${cartList.carts}" var="singleCart">
	${singleCart.cartScript}
</c:forEach>

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

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script
	src="https://www.highcharts.com/samples/static/highslide-full.min.js"></script>
<script
	src="https://www.highcharts.com/samples/static/highslide.config.js"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="https://www.highcharts.com/samples/static/highslide.css" />

</head>
<body>
	<%@include file="topBar.jsp"%>
	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<%@include file="sideBar.jsp"%>
			<!-- END SIDEBAR -->

			<div class="col-sm-9 col-md-9 col-lg-10">
				<c:if test="${not empty student}">
					<h1>Student: ${student.username}</h1>
					<br>
					<%-- 					<%@include file="statisticsStudent.jsp"%> --%>
				</c:if>
				<c:if test="${not empty professor}">
					<h1>Professor: ${professor.username}</h1>
					<br>
					<%-- 					<%@include file="statisticsProfessor.jsp"%> --%>
				</c:if>

				<div class="col-sm-12 col-md-12 col-lg-12">
					<br>
					<div class="col-sm-5 col-md-5 col-lg-5">
						<div id="idCartContainer1"></div>
					</div>
					<div class="panel panel-default col-sm-7 col-md-7 col-lg-7">
						<div class="panel-heading">
							<h3 class="panel-title">Negli anni</h3>
						</div>
						<div class="panel panel-default col-sm-12 col-md-12 col-lg-12">
							<div class="panel-body">
								<div>
									<!-- Nav tabs -->
									<ul class="nav nav-tabs" role="tablist">
										<li role="presentation" class="active"><a
											href="#totalAvgLectureProfessor"
											aria-controls="totalAvgLectureProfessor" role="tab"
											data-toggle="tab">Media lezioni per professore </a></li>
										<li role="presentation"><a
											href="#totalAvgLectureProfessors"
											aria-controls="totalAvgLectureProfessors" role="tab"
											data-toggle="tab"> Media lezioni tra professori</a></li>
									</ul>
									<!-- Tab panes -->
									<div class="tab-content">
										<div role="tabpanel" class="tab-pane active"
											id="totalAvgLectureProfessor">
											<div id="idCartContainer4"></div>
										</div>
										<div role="tabpanel" class="tab-pane"
											id="totalAvgLectureProfessors">
											<div id="idCartContainer7"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default col-sm-12 col-md-12 col-lg-12">
						<div class="panel-heading">
							<h3 class="panel-title">Per anno</h3>
						</div>
						<div class="panel-body">
							<div>
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active"><a
										href="#noLectureProfessor" aria-controls="noLectureProfessor"
										role="tab" data-toggle="tab">Numero lezioni per professore</a></li>
									<li role="presentation"><a href="#noLectureProfessors"
										aria-controls="noLectureProfessors" role="tab"
										data-toggle="tab"> Numero lezioni tra professori</a></li>
								</ul>
								<!-- Tab panes -->
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active"
										id="noLectureProfessor">
										<div id="idCartContainer2"></div>
									</div>
									<div role="tabpanel" class="tab-pane" id="noLectureProfessors">
										<div id="idCartContainer5"></div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default col-sm-12 col-md-12 col-lg-12">
						<div class="panel-heading">
							<h3 class="panel-title">Per anno</h3>
						</div>
						<div class="panel-body">
							<div>
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active"><a
										href="#avgLectureProfessor"
										aria-controls="avgLectureProfessor" role="tab"
										data-toggle="tab">Media lezioni per professore</a></li>
									<li role="presentation"><a href="#avgLectureProfessors"
										aria-controls="avgLectureProfessors" role="tab"
										data-toggle="tab">Media lezioni tra professori</a></li>
								</ul>
								<!-- Tab panes -->
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active"
										id="avgLectureProfessor">
										<div id="idCartContainer3"></div>
									</div>
									<div role="tabpanel" class="tab-pane" id="avgLectureProfessors">
										<div id="idCartContainer6"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default col-sm-12 col-md-12 col-lg-12">
						<div class="panel-heading">
							<h3 class="panel-title">Homeworks Analysis</h3>
						</div>
						<div class="panel-body">
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div id="idCartContainer8"></div>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div id="idCartContainer9"></div>
							</div>
						</div>
					</div>

					<div class="panel panel-default col-sm-12 col-md-12 col-lg-12">
						<div class="panel-heading">
							<h3 class="panel-title">Attendances Analysis</h3>
						</div>
						<div class="panel-body">
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div id="idCartContainer10"></div>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div id="idCartContainer11"></div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
