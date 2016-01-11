<!DOCTYPE html>
<%@include file="./pagesCommon/includeJSP.jsp"%>
<html>
<head>
<%@include file="./pagesCommon/head.jsp"%>

<!-- Insert this script -->
<script type="text/javascript"
	src="https://gmskfstatic.test.edgekey.net/api/sketchfab-viewer-1.0.0.js"></script>

</head>
<body>
	<%@include file="./pagesCommon/topBar.jsp"%>
	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<%@include file="./pagesCommon/sideBar.jsp"%>
			<!-- END SIDEBAR -->

			<div class="col-sm-10 col-md-10 col-lg-10">
				<br>
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong>Viewer</strong>
					</div>
					<div class="panel-body">
						<!-- Insert an empty iframe -->
						<iframe width="100%" height="640px" src="" id="api-frame"
							allowfullscreen mozallowfullscreen="true"
							webkitallowfullscreen="true"></iframe>
					</div>
				</div>
			</div>

			<!-- Initialize the viewer -->
			<script type="text/javascript">
				var iframe = document.getElementById('api-frame');
				var version = '1.0.0';
				//var urlid = '7w7pAfrCfjovwykkEeRFLGw5SXS';
				//var urlid = 'f47b09dfa055440f90c449f962353745';
				//var urlid = '34352a8033d54fd78103b2709e7189a6';
				var urlid = '22213fa014d04ae18497d9d517e326c9';
				
				var client = new Sketchfab(version, iframe);

				client.init(urlid, {
					success : function onSuccess(api) {
						api.start();
						api.addEventListener('viewerready', function() {

							// API is ready to use
							// Insert your code here
							console.log('Viewer is ready');

						});
					},
					error : function onError() {
						console.log('Viewer error');
					}
				});
			</script>

		</div>
	</div>
</body>
</html>
