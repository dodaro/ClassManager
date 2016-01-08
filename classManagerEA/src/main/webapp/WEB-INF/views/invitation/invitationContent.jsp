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
				<c:if test="${not empty student}">
					<%@include file="invitationStudent.jsp"%>
				</c:if>
				<c:if test="${not empty professor}">
					<%@include file="invitationProfessor.jsp"%>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
