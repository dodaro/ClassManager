$(document).ready(function() {

	listenersManager = ListenersManager.getInstance();
	listenersManager.initListeners();

	uploadFile_index = 0;
	createClass_index = 1;
	addHomework_index = 2;
	addMaterials_index = 3;

	buttons = ["#uploadFile_btn", "#createNewClass_btn", "#addHomework_btn","#addMaterials_btn"];

	$("#uploadFile_div").hide();
	
	/*$( ".datepicker" ).datepicker({
    	changeYear: true,
    	dateFormat: "dd/mm/yy",
    	yearRange: "-100:+100",	
    });*/
	
	$( ".datepicker" ).datetimepicker({
		format: 'DD/MM/YYYY'
	});
	
	$( ".timepicker" ).datetimepicker({
		format: 'HH:mm'
	});
	
});


    
//class
var ListenersManager = (function(){

	//private fields
	var alreadyInitialized = false;

	var instance;

	//constructor
	var ListenersManager = function() {

		this.initListeners = initListeners;
	}


	var initListeners = function() {

		if(alreadyInitialized === false) {
			alreadyInitialized = true;



			$("#createNewClass_btn").on("click", function() {

				$("#lecture-form").attr("action", "/lectures");
				$("#createNewClass_modal").modal().show();

			});


			$("#addHomework_btn").on("click", function() {

				$("#homework-form").attr("action", "/homeworks");
				$("#addHomework_modal").modal().show();
			});

			/*
			 * shows and hide the upload div
			 */
			$("#uploadFile_btn").on("click", function() {

				if($("#uploadFile_div").is(":hidden")){
					$("#uploadFile_div").show();
				}
				else
					$("#uploadFile_div").hide();
			});

			$("div.file").click(function(event){

				var path = $(this).siblings("input[name=path]").val();
				$("#visualizer").attr("href", path);

				$("#visualizer_modal").modal().show();
				$("#visualizer").gdocsViewer({ width: '100%', height: '100%' });

				event.preventDefault();
			});

			$("#download_btn_modal").click(function(){

				var url = $("#visualizer").attr("href");
				window.open("/download?path=" + url);

			});
			
			

			/*$("#delete_btn_modal").click(function(){
				var url = $("#visualizer").attr("href");
				$.get( "/contents/delete", {"path" : url}, function(data){

					if(data == true)
						window.location.replace("fileBrowser");
				});	
			});*/

		}
		else {
			console.log("Operation not permitted!! Init function can be called one time.");
		}
	} 


	var getInstance = function() {

		if (!instance) {
			instance = new ListenersManager();  
		} 
		return instance; 
	};


	//return singleton obj
	return {
		getInstance: getInstance
	};

})();

function delete_lectures(event){

	event.stopImmediatePropagation();

	var lectureId = $(event.srcElement).closest("form").find("input[name=parentId]").val();
	$.post("/delete_lecture",{'lectureId':lectureId},function(){

	});
}

function delete_homeworks(event){

	event.stopImmediatePropagation();
	alert("deleteHomeworks");
}

function delete_homeworkAttached(event){

	event.stopImmediatePropagation();

	var homeworkId = $(event.srcElement).closest("form").find("input[name=id]").val();
	$.post("/delete_homeworkAttached",{'homeworkAttachedId':homeworkId},function(){

	});
}

function delete_homeworkStudentSolving(event){

	event.stopImmediatePropagation();

	var hssId = $(event.srcElement).closest("form").find("input[name=id]").val();
	$.post("/delete_homeworkStudentSolving",{'homeworkStudentSolvingId':hssId},function(){

	});
}

function delete_homeworkAttached(event){

	event.stopImmediatePropagation();

	var homeworkId = $(event.srcElement).closest("form").find("input[name=id]").val();
	$.post("/delete_homeworkStudentSolvingAttachment",{'homeworkStudentSolvingAttachedId':homeworkId},function(){

	});
}

function delete_materials(event){

	event.stopImmediatePropagation();

	var materialId = $(event.srcElement).closest("form").find("input[name=id]").val();
	$.post("\delete_homeworkAttached",{'materialId':materialId},function(){

	});
}

function update_lectures(event){
	
	event.stopImmediatePropagation();
	
	var lectureId = $(event.srcElement).closest("form").find("input[name=parentId]").val();
	var topic = $(event.srcElement).closest("form").find("input[name=topic]").val();
	var description = $(event.srcElement).closest("form").find("input[name=description]").val();
	var classroom = $(event.srcElement).closest("form").find("input[name=classroom]").val();
	var date = $(event.srcElement).closest("form").find("input[name=date]").val();
	var bhour = $(event.srcElement).closest("form").find("input[name=beginHour]").val();
	var ehour = $(event.srcElement).closest("form").find("input[name=endHour]").val();
	
	$("#createLectureModal_id").val(lectureId);
	
	$("#lecture-form").find("input[name=parentId]").val(lectureId);
	$("#lecture-form").find("input[name=topic]").val(topic);
	$("#lecture-form").find("input[name=description]").val(description);
	$("#lecture-form").find("input[name=classroom]").val(classroom);
	$("#lecture-form").find("input[name=date]").val(date);
	$("#lecture-form").find("input[name=beginHour]").val(bhour);
	$("#lecture-form").find("input[name=endHour]").val(ehour);
	
	$("#lecture-form").attr("action", "/update_lecture");
	$("#createNewClass_modal").modal().show();
	
}

function update_homeworks(event){
	
	event.stopImmediatePropagation();
	
	var homeworkId = $(event.srcElement).closest("form").find("input[name=id]").val();
	var name = $(event.srcElement).closest("form").find("input[name=name]").val();
	var description = $(event.srcElement).closest("form").find("input[name=description]").val();
	
	$("#addHomeworkModal_id").val(homeworkId);
	
	$("#homework-form").find("input[name=id]").val(homeworkId);
	$("#homework-form").find("input[name=name]").val(name);
	$("#homework-form").find("input[name=description]").val(description);
	
	$("#homework-form").attr("action", "/update_homework");
	$("#addHomework_modal").modal().show();
	
}

function addLink(){
	
	alert("ciao");
}

function reload(){
	
	window.location.reload();
}