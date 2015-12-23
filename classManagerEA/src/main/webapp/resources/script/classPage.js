$(document).ready(function() {

	listenersManager = ListenersManager.getInstance();
	listenersManager.initListeners();

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

			/*
			 * shows and hide the upload div
			 */
			$("#uploadFile_btn").on("click", function() {

				if($("#uploadFile_div").is(":hidden")){
					
					var url = window.location.href;
					url = escapeHTML(url.split("#")[1]);
					
					//TODO hide in the first path
					
					$('#toUpload_input').val(url);
					$("#uploadFile_div").show();
				}
				else
					$("#uploadFile_div").hide();
			});
			
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

function escapeHTML(text) {
	return text.replace(/%20/g, ' ').replace(/%2F/g, '/');
}