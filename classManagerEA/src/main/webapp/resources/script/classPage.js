$(document).ready(function() {

	listenersManager = ListenersManager.getInstance();
	listenersManager.initListeners();

	uploadFile_index = 0;
	createClass_index = 1;
	addHomework_index = 2;
	addMaterials_index = 3;

	buttons = ["#uploadFile_btn", "#createNewClass_btn", "#addHomework_btn","#addMaterials_btn"];

	$("#uploadFile_div").hide();

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

				$("#createNewClass_modal").modal().show();
			});

			$("#addHomework_btn").on("click", function() {

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

//				var blob = new Blob(["/download?path=" + url]);
//				var evt = document.createEvent("HTMLEvents");
//				evt.initEvent("click");
//				var a = $("<a>", {
//					download: encodeURIComponent("/download?path=" + url),
//					href: URL.createObjectURL(blob)
//				});
//
//				a.get(0).dispatchEvent(evt);
				
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
	$.post("\delete_lecture",{'lectureId':lectureId},function(){
		
	});
}

function delete_homeworks(event){
	
	event.stopImmediatePropagation();
	alert("deleteHomeworks");
}

function delete_homeworkAttached(event){
	
	event.stopImmediatePropagation();
	
	var homeworkId = $(event.srcElement).closest("form").find("input[name=id]").val();
	$.post("\delete_homeworkAttached",{'homeworkAttachedId':homeworkId},function(){
		
	});
}

function delete_materials(event){
	
	event.stopImmediatePropagation();
	
	var materialId = $(event.srcElement).closest("form").find("input[name=id]").val();
	$.post("\delete_homeworkAttached",{'materialId':materialId},function(){
		
	});
}