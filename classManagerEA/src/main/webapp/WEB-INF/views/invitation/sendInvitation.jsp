<!DOCTYPE html>
<%@include file="../pagesCommon/includeJSP.jsp"%>
<html>
<head>
<%@include file="../pagesCommon/head.jsp"%>
</head>
<body>
	<%@include file="../pagesCommon/topBar.jsp"%>
	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<%@include file="../pagesCommon/sideBar.jsp"%>
			<!-- END SIDEBAR -->

			<div class="col-sm-9 col-md-9 col-lg-10">
				<br>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<spring:message code="message.invitation.professorOperation1" />
						</h3>
					</div>
					<div class="panel-body">body</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
