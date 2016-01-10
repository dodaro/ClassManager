
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
    
    
    //SPECIAL CLASS
    var ValidityChecker = (function(){
    	
    	var attachmentInputs = "";
    	
    	var ValidityChecker = function() {
    		
    		this.getAttachmentInputs = getAttachmentInputs;
    		this.setAttachmentInputs = setAttachmentInputs;
    		this.validatePage = validatePage;
    	};
    	
    	var setAttachmentInputs = function(val) {
    		attachmentInputs = val;
    	}
    	
    	var getAttachmentInputs = function() {
    		return attachmentInputs;
    	}
    	
    	var violationOccurred = function() {
    		
    		alert("Page violated... ");
			window.location="/forum/insertQuestion";
    	}
    	
    	var validatePage = function() {
    		
    		if(attachmentInputs !== $("#attachedFiles").val()) {
    			violationOccurred();
    			return false;
    		}
    		
    		var attachmentSplit = attachmentInputs.split(";");
    		if(attachmentSplit.indexOf("") != -1) {
    			
    			var index = attachmentSplit.indexOf("");
    			if (index > -1) {
    				attachmentSplit.splice(index, 1);
    			}
    		}
    		
    		
    		return true;
    	}
    	
    	
    	return ValidityChecker;
    })();
    
    var validityChecker = new ValidityChecker();
    
    //END SPECIAL CLASS
    
    
    
    //constructor
    var ListenersManager = function() {
    	
    	this.initListeners = initListeners;
    }
    
    
    var initListeners = function() {
    	
		if(alreadyInitialized === false) {
			alreadyInitialized = true;
			
			$(".removeAttachmentBtn").on("click", function(){
				
				if(validityChecker.validatePage() === true) {
				
  					var attachment = $(this);
  					var parameters = {name: $(attachment).data("aname"), id: $(attachment).data("aid"), type: "remove"};
  					
  					$.ajax({
  							url: "/forum/removeAnswerAttachment",
  							method: "POST",
  							data:{
  								attachedIdRemove: parameters.id
  							}
  						}).done(function(e, result, data) {
  							
  								var result = data.responseText;
  								if(result === "true") {

  									$(attachment).closest(".attachmentContainer").remove();
  								}
  								else {
  									alert("remove non andata a buon fine")
  								}
  						});
				}
				
			});
			
			$(".removeAttachmentBtn").bind('DOMSubtreeModified', function() {
			    
				validityChecker.setAttachmentInputs(-1);
				validityChecker.validatePage()
			});
			
			
			$('#attachedFiles').on("change", function(data, parameters) {
				
				
				parameters = parameters || {name: undefined, id: undefined, type: undefined};
				
				if(parameters.type === "remove") {
					
					var attachmentsIDs = validityChecker.getAttachmentInputs();
					attachmentsIDs = attachmentsIDs.replace(parameters.id, "");
					attachmentsIDs = attachmentsIDs.replace(";;", ";");
					validityChecker.setAttachmentInputs(attachmentsIDs);
				}
				else {
					
					if(validityChecker.getAttachmentInputs() === "") {
						validityChecker.setAttachmentInputs(parameters.id);
					}
					else {
						validityChecker.setAttachmentInputs(validityChecker.getAttachmentInputs() + ";" + parameters.id);
					}
					
					
					if(validityChecker.validatePage() === true) {
						
						var newAttachment = '<div class="attachmentContainer" data-aid="'+ parameters.id +'" class="row">'+
							'<div class="col-sm-10 col-md-10 col-lg-10">'+
		  					'	<div class="row">'+
		  					'		<div class="col-sm-2 col-md-2 col-lg-2">'+
							'  			<span style="font-size:2em;" class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>'+
		  					'		</div>'+
		  					'		<div class="col-sm-8 col-md-8 col-lg-8">'+
		  					'			<p>'+ parameters.name +'</p>'+
		  					'		</div>'+
		  					'		<div class="col-sm-2 col-md-2 col-lg-2">'+
		  					'			<div class="btn btn-danger removeAttachmentBtn">delete</div>'+
		  					'		</div>'+
		  					'	</div>'+
		  					'</div>'+
		  				'</div>'
		  					
		  				newAttachment = $(newAttachment);
		  					
		  				$(newAttachment).find(".removeAttachmentBtn").on("click", function(){
		  					
		  					if(validityChecker.validatePage() === true) {
		  					
			  					var attachment = $(this);
			  					
			  					$.ajax({
			  							url: "/forum/removeAnswerAttachment",
			  							method: "POST",
			  							data:{
			  								attachedIdRemove: parameters.id
			  							}
			  						}).done(function(e, result, data) {
			  							
			  								var result = data.responseText;
			  								if(result === "true") {

			  									$(attachment).closest(".attachmentContainer").remove();
			  									
			  									var attachmentsIDs = $('#attachedFiles').val();
			  									attachmentsIDs = attachmentsIDs.replace(parameters.id, "");
			  									attachmentsIDs = attachmentsIDs.replace(";;", ";");
			  									$('#attachedFiles').val(attachmentsIDs);
			  									

			  									parameters.type = "remove";
			  									$('#attachedFiles').trigger("change", parameters);
			  								}
			  								else {
			  									alert("remove non andata a buon fine")
			  								}
			  						});
		  					}
		  					
		  				});
						
						
						$('#attachmentSection').append(newAttachment);
						
					}
					
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