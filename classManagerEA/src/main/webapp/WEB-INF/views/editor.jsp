<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page session="false" %>
<html>
<head>
	<title>Editor page</title>
	<link rel="stylesheet" type="text/css" href="resources/css/editor.css">
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/ace/ace.js" type="text/javascript" charset="utf-8"></script>
	<script src="resources/js/ace/ext-language_tools.js"></script>
	<script src="resources/js/editor.js"></script>
</head>
<body>


  <div class="container">

    <div class="menuSection">

    <div>
      <br/>
      <div>
        <div>
          <select id="editorLang" class="centered">
            <option value="c_cpp">C/C++</option>
            <option value="java">Java</option>
            <option value="html">HTML</option>
            <option value="javascript">Javascript</option>
            <option value="pytohn">Python</option>
            <option value="perl">Perl</option>
          </select> 
        </div>

        <div>
          <select id="editorTheme" class="centered">

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
        </div>
      </div>

      <br/>
      <br/>
      <div>
        <input type="button" id="tryCodeBtn" class="centered" value="try code" />
        <input type="button" id="toggleConsole" class="centered" value="toggle console" />
        <input type="button" id="clearConsole" class="centered" value="clear console" />
      </div>

    </div>

    </div>



    <div class="editorSection">
      	<div class="editor" id="editor"></div>
      	<div class="editor" id="console"></div>
    </div>
    
    <form:form id="editorForm" action="/editor" method="post" commandName="status" >
		<form:textarea id="codeTextarea" path="code"></form:textarea>
		<form:textarea id="consoleTextarea" path="consoleContent"></form:textarea>
		<form:input id="themeInput" path="theme"/>
		<form:input id="languageInput" path="language"/>
	</form:form>

  </div>


</body>
</html>
