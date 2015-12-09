<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css" media="screen">

    .container {
      width: 100%;
      height: 100%;
      position: absolute;
      top: 0;
      right: 0;
      bottom: 0;
      left: 0;
    }

    .menuSection {

      float: left;
      width: 15%;
      height: 100%;
      background-color: #E6E6E6;
    }

    .centered {
      display: block;
      margin-left: auto ;
      margin-right: auto ;
    }

    .editorSection {
      margin: auto;
      width: 100%;
      height: 100%;
      background-color: black;
    }

    #editor { 
      height: 80%;
    }

    #console {
    	height: 19%;
    	border-style: solid;
    	border-width: 1px;
    	border-color: black;
    }



</style>
<link rel="stylesheet" type="text/css" href="resources/script/minimap.min.css">
<script src="resources/script/jquery.min.js"></script>
<script src="resources/script/ace/ace.js" type="text/javascript" charset="utf-8"></script>
<script src="resources/script/ace/ext-language_tools.js"></script>
<script src="resources/script/index.js"></script>
<script src="resources/script/minimap.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


  <div class="container">

    <div class="menuSection">

    <div>
      <br/>
      <div>
        <div>
          <select id="editorLang" class="centered">
            <option value="javascript">Javascript</option>
            <option value="xml">XML</option>
            <option value="html">HTML</option>
            <option value="c_cpp" selected="selected">C/C++</option>
          </select> 
        </div>

        <div>
          <select id="editorTheme" class="centered">

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
            <option value="monokai" selected="selected">Monokai</option>
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
        <input type="button" id="addConsoleLine" class="centered" value="add line console" />
        
      </div>

    </div>

    </div>



    <div class="editorSection">
      <div class="editor" id="editor"></div>
      <div class="editor" id="console"></div>
		<div id="asd">
			<form:form id="codeForm" action="/home" method="post" commandName="snippet" style="display:none;">
				<form:textarea id="codeTextarea" path="code"></form:textarea>
				<form:textarea id="consoleTextarea" path="console"></form:textarea>
			</form:form>
		</div>
    </div>

  </div>


</body>
</html>
