
$(document).ready(function() {
	
	answerManager = AnswerManager.getInstance();
	listenersManager = ListenersManager.getInstance();
	
	answerManager.initAnswerArea();
	listenersManager.initListeners();
	
});



var AnswerManager = (function() {
	
	var answerArea;
	var answerAreaName = 'textEditor';
	var alreadyInitialized = false;
	
	var instance;
	
	var AnswerManager = function() {
		
		this.getAnswerArea = getAnswerArea;
		this.initAnswerArea = initAnswerArea
	};
	
	var initAnswerArea = function() {
		
		if(alreadyInitialized === false) {
			alreadyInitialized = true;
			
			answerArea = CKEDITOR.replace(answerAreaName);
		}
		else {
			console.log("Operation not permitted!! Init function can be called one time.");
		}
	};
	
	var getAnswerArea = function() {
		return answerArea;
	};
	

	var getInstance = function() {
    	
    	if (!instance) {
            instance = new AnswerManager(); 
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