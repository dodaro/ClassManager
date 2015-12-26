$(document).ready(function() {

	listenersManager = ListenersManager.getInstance();
	listenersManager.initListeners();

	navigationManager = NavigationManager.getInstance();
	navigationManager.init();

	uploadFile_index = 0;
	createClass_index = 1;
	addHomework_index = 2;

	buttons = ["#uploadFile_btn", "#createNewClass_btn", "#addHomework_btn"];

	$("#uploadFile_div").hide();
});

/*
 * This singleton class contains methods to keep track about the navigation among the folders
 * 
 */
var NavigationManager = (function(){

	//private fields
	var currentPath;
	var alreadyInitialized = false;
	var instance;
	var currentLesson;

	//constructor
	var NavigationManager = function() {

		this.init = init;
		this.getCurrentPath = getCurrentPath;
		this.imInHomeworks = imInHomeworks; 
		this.imInLectures = imInLectures; 
		this.getCurrentFolder = getCurrentFolder;
		this.getPreviousFolder = getPreviousFolder;
	}

	var init = function(){

		if(alreadyInitialized === false){
			alreadyInitialized = true;
			this.currentPath = getCurrentPath();
		}
	}

	var getInstance = function() {

		if (!instance) {
			instance = new NavigationManager();  
		} 
		return instance; 
	};

	/**
	 * return the complete current path, obtained splitting the window.location.href.
	 * The path returned looks like "root/lessons/lesson"
	 */
	var getCurrentPath = function(){

		var url = (window.location.href).split("#")[1];
		url = typeof url != 'undefined' ? escapeHTML(url) : "";
		this.currentPath = url;

		return this.currentPath;
	};

	/**
	 * return true if the current folder is "homeworks"
	 */
	var imInHomeworks = function(){

		var currentFolder = this.getCurrentFolder();

		var res = (currentFolder == "homeworks") ? true : false;
		return res;
	};

	/**
	 * return true if the current folder is "lectures"
	 */
	var imInLectures = function(){

		var currentFolder = this.getCurrentFolder();

		var res = (currentFolder == "lectures") || (currentFolder == "") ? true : false;
		return res;
	};

	/**
	 * return the name of the current folder, that is the last element of the {currentPath}
	 */
	var getCurrentFolder = function(){

		var url = this.getCurrentPath();
		url = url.split("/");
		var index = url.length - 1;

		return url[index];
	};

	/**
	 * returns the previous folder with respect to the currentFolder. That is the one-to-last element of the {currentPath}
	 */
	var getPreviousFolder = function(){

		var url = this.getCurrentPath();
		url = url.split("/");
		var index = url.length - 2;

		if(index >= 0)
			return url[index];
		else 
			return url[0];
	};


	//return singleton obj
	return {
		getInstance: getInstance,
		getCurrentPath: getCurrentPath,
		imInHomeworks: imInHomeworks,
		imInLectures: imInLectures,
		getCurrentFolder: getCurrentFolder,
		getPreviousFolder: getPreviousFolder
	};

})();


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

				$("#referredLesson_input").val(navigationManager.getPreviousFolder());
				$("#addHomework_modal").modal().show();
			});

			/*
			 * shows and hide the upload div
			 */
			$("#uploadFile_btn").on("click", function() {

				if($("#uploadFile_div").is(":hidden")){

					var url = navigationManager.getCurrentPath();

					$('#toUpload_input').val(url);
					$("#uploadFile_div").show();
				}
				else
					$("#uploadFile_div").hide();
			});

			/*
			 * used to display the correct components when navigating in folders
			 */
			$(window).on('hashchange', function() {

				if(navigationManager.imInLectures()){

					hideAllButtons();
					$(buttons[createClass_index]).show();
				}
				else if(navigationManager.imInHomeworks()){

					hideAllButtons();
					$(buttons[addHomework_index]).show();
				}
				else {

					hideAllButtons();
				}

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

function hideAllButtons(){

	buttons.forEach(function(id) {
		$(id).hide();
	});
}