
$(document).ready(function() {
	
	questionManager = QuestionManager.getInstance();
	listenersManager = ListenersManager.getInstance();
	
	questionManager.initQuestionArea();
	listenersManager.initListeners();
	
});



var QuestionManager = (function() {
	
	var questionArea;
	var questionAreaName = 'textEditor';
	var alreadyInitialized = false;
	
	var instance;
	
	var QuestionManager = function() {
		
		this.getQuestionArea = getQuestionArea;
		this.initQuestionArea = initQuestionArea
	};
	
	var initQuestionArea = function() {
		
		if(alreadyInitialized === false) {
			alreadyInitialized = true;
			
			questionArea = CKEDITOR.replace(questionAreaName);
		}
		else {
			console.log("Operation not permitted!! Init function can be called one time.");
		}
	};
	
	var getQuestionArea = function() {
		return questionArea;
	};
	

	var getInstance = function() {
    	
    	if (!instance) {
            instance = new QuestionManager(); 
        } 
        return instance; 
    };
    
    
    //return singleton obj
    return {
    	getInstance: getInstance
    };
	
})();


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