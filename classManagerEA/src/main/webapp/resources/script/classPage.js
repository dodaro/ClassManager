$(document).ready(function() {
	
	listenersManager = ListenersManager.getInstance();
	listenersManager.initListeners();
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

