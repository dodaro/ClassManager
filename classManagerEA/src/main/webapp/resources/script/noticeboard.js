$(document).ready(function() {
	
	noticeBoard = NoticeBoardManager.getInstance();
	listenersManager = ListenersManager.getInstance();
	
	noticeBoard.initNewPostArea();
	listenersManager.initListeners();
	
});



var NoticeBoardManager = (function() {
	
	var newPostArea;
	var newPostAreaName = 'textEditor';
	var alreadyInitialized = false;
	
	var instance;
	
	var NoticeBoardManager = function() {
		this.getNewPostArea = getNewPostArea;
		this.initNewPostArea = initNewPostArea;
	};
	
	var initNewPostArea = function() {
		
		if(alreadyInitialized === false) {
			alreadyInitialized = true;
			
			newPostArea = CKEDITOR.replace(newPostAreaName);
			
			
			$("#page-size").change(function() {
				var url = "noticeboard?notices=" + $( this ).find("option:selected").text();
				console.log(url);
						window.location.href=url;
			});
			
			var value = $("#selected-value").val();
			$("#page-size").val(value);
			
			
			var totalPages = parseInt($("#options :input[name='total-pages']").val());
			var currentPage = parseInt($("#options :input[name='page-number']").val());
			
			$('#paginator').bootpag({
			    total: totalPages,
			    page: currentPage,
			    maxVisible: 5,
//			    href: "searchusers?page={{number}}",
			    leaps: false
			}).on("page", function(event, num){
			    window.location.href = "noticeboard?page="+num;
			});
		    
			var value = $("#selected-value").val();
			$("#page-size").val(value);
			
			
			
			
			
		}
		else {
			console.log("Operation not permitted!! Init function can be called one time.");
		}
	};
	
	var getNewPostArea = function() {
		return newPostArea;
	};
	

	var getInstance = function() {
    	
    	if (!instance) {
            instance = new NoticeBoardManager(); 
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
			
			$("#new-post").click(function(data) {
				if ( $("#form-div").is(":visible") ) {
					$("#form-div").hide();
				} else {
					$("#form-div").show();
				}
			});
			
			
			$(".edit").click(function(data) {
				var form = $(this).closest(".row").find(".form-edit-div");
				console.log(form);
				if ( form.is(":visible") ) {
					form.hide();
				} else {
					form.show();
				}
				
				form.find(".textEditor")
				CKEDITOR.replace(newPostAreaName);
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


