var editor;
var consl;

var language;
var theme;



$(document).ready(function() {

	language = $("#editorLang").val();
	theme = $("#editorTheme").val();
	initEditor();

	$("#editorLang").on("click", function() {

		language = $("#editorLang").val();
		setLanguage(language);
	});

	$("#editorTheme").on("click", function() {

		theme = $("#editorTheme").val();
		setTheme(theme);
	});

	$("#toggleConsole").on("click", function(){

		$("#console").toggle();

		if($("#console").is(":visible")) {

			$("#editor").css("height", "80%")			
		}
		else {
			$("#editor").css("height", "100%")
		}
	
	});


	$("#clearConsole").on("click", function() {

		consl.setValue("");
	});


	$("#addConsoleLine").on("click", function() {

		consl.session.insert(consl.getCursorPosition(), consoleInitialText);
	});	

	
	$('#tryCodeBtn').on("click", function() {
		
		$('#codeTextarea').val(editor.getValue());
		$('#codeForm').submit();
	});
	
});


function initEditor() {

	editor = ace.edit("editor");
	editor.setOptions({
	    enableBasicAutocompletion: true,
	});

	consl = ace.edit("console");
	consl.setOptions({
		readOnly: true,
		theme: "ace/theme/cobalt",
		mode: "ace/mode/text",
		highlightActiveLine: false,
		showGutter: false,
		showPrintMargin: false
	});


	
	setTheme(theme);
	setLanguage(language);

	insertText();
};


function setLanguage(language) {
	editor.getSession().setMode("ace/mode/" + language);
};

function setTheme(theme) {
	editor.setTheme("ace/theme/" + theme);
}


function insertText() {

	editor.session.insert(editor.getCursorPosition(), $('#codeTextarea').val());
	consl.session.insert(consl.getCursorPosition(), $("#consoleTextarea").val());
}

