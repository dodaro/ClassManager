<%@include file="pageCommons/include.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Class Manager</title>
<%@include file="pageCommons/head.jsp"%>
<jsp:include page="${customHeader}" flush="true" />
</head>
<body>
	<!-- NAVBAR -->
	<%@include file="pageCommons/navBar.jsp"%>

	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<div class="col-sm-3 col-md-3 col-lg-2">
				<div id="sidebar-wrapper" class="sidebar-desktop">
					<ul class="sidebar-nav">
						<jsp:include page="pageCommons/sideBar.jsp" flush="true" />
					</ul>
				</div>
			</div>

			<!-- CUSTOM BODY -->
			<div class="col-sm-9 col-md-9 col-lg-10">
				<jsp:include page="${customBody}" flush="true" />
			</div>

		</div>
	</div>

	<!-- Modal For Login-->
	<%@include file="pageCommons/loginModal.jsp"%>

	<!-- Modal For Register-->
	<%@include file="pageCommons/registerModal.jsp"%>

</body>
</html>