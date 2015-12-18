<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page session="false" %>
<html>
<head>
	<title>Editor page</title>
	<link rel="stylesheet" type="text/css" href="resources/css/editor.css">
	<link rel="stylesheet" type="text/css" href="resources/lib/bootstrap-3.3.5-dist/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="resources/style/nav-bar.css" />

	<script src="resources/lib/jquery/jquery.min.js"></script>
	
	<script src="resources/js/ace/ace.js" type="text/javascript" charset="utf-8"></script>
	<script src="resources/js/ace/ext-language_tools.js"></script>
	<script src="resources/js/editor.js"></script>
	
	<script src="resources/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
	<script src="resources/script/nav-bar.js"></script>

</head>


<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header pull-left">
				<a id="menu-toggle" href="#" class="navbar-toggle"> <span
					class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="navbar-brand" href="#"> Class Manager </a>
			</div>
			<div class="navbar-header pull-right">
				<a class="nav-bar-button logout" href="aldo"><span
					class="glyphicon glyphicon-log-out"></span> Aldo Login</a> <a
					class="nav-bar-button logout" href="#"><span
					class="glyphicon glyphicon-log-out"></span> Logout</a>
			</div>
		</div>
	</nav>

	<div class="container-fluid page-content">
		<div class="row">
			<!-- SIDEBAR -->
			<div class="col-sm-3 col-md-3 col-lg-2">
				<div id="sidebar-wrapper" class="sidebar-desktop">
					<!-- collapse width -->
					<ul class="sidebar-nav">
						<li><a href="#"><span class="glyphicon glyphicon-home"></span>
								Dashboard</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-book"></span>
								Classroom</a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-folder-open"></span> Materials</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-list"></span>
								Discussions</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-stats"></span>
								Statistics</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-9 col-md-9 col-lg-10 editorContainer">
				<div class="row row-content">
					<div class="col-sm-12 col-md-12 col-lg-12">
						
						<div>
							<div class="row">
								<div class="col-md-2">
								
								<select id="editorLang" class="form-control">
						            <option value="c_cpp">C/C++</option>
						            <option value="java">Java</option>
						            <option value="html">HTML</option>
						            <option value="javascript">Javascript</option>
						            <option value="pytohn">Python</option>
						            <option value="perl">Perl</option>
						          </select> 
						          
						          
						          <select id="editorTheme" class="form-control">
						
						            <option value="monokai">Monokai</option>
						            <option value="chrome">Chrome</option>
						            <option value="clouds">Clouds</option>
						            <option value="clouds_midnight">Clouds Midnight</option>
						            <option value="cobalt">Cobalt</option>
						            <option value="crimson_editor">Crimson Editor</option>
						            <option value="dawn">Dawn</option>
						            <option value="eclipse">Eclipse</option>
						            <option value="idle_fingers">Idle Fingers</option>
						            <option value="kr_theme">Kr Theme</option>
						            <option value="merbivore">Merbivore</option>
						            <option value="merbivore_soft">Merbivore Soft</option>
						            <option value="mono_industrial">Mono Industrial</option>
						            <option value="pastel_on_dark">Pastel On Dark</option>
						            <option value="solarized_dark">Solarized Dark</option>
						            <option value="solarized_light">Solarized Light</option>
						            <option value="textmate">TextMate</option>
						            <option value="tomorrow">Tomorrow</option>
						            <option value="tomorrow_night">Tomorrow Night</option>
						            <option value="tomorrow_night_blue">Tomorrow Night Blue</option>
						            <option value="tomorrow_night_bright">Tomorrow Night Bright</option>
						            <option value="tomorrow_night_eighties">Tomorrow Night Eighties</option>
						            <option value="twilight">Twilight</option>
						            <option value="vibrant_ink">Vibrant Ink</option>
						          </select>
						          
						          <input type="button" id="tryCodeBtn" class="btn btn-primary" value="try code" />
						        <input type="button" id="toggleConsole" class="btn btn-primary" value="toggle console" />
						        <input type="button" id="clearConsole" class="btn btn-primary" value="clear console" />
								
								</div>
								<div class="col-md-10">
									<div class="row">
										<div class="col-md-12">
											<div class="editor" id="editor"></div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12">
											<div class="editor" id="console"></div>
										</div>
									</div>
									
									<form:form id="editorForm" action="/editor" method="post" commandName="status" >
										<form:textarea id="codeTextarea" path="code"></form:textarea>
										<form:textarea id="consoleTextarea" path="consoleContent"></form:textarea>
										<form:input id="themeInput" path="theme"/>
										<form:input id="languageInput" path="language"/>
									</form:form>
								
								</div>
							</div>
						</div>
						

						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>





</html>
