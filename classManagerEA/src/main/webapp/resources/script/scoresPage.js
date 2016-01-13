/*
 * The html table stored information is handled using a bootstrap plug-in: "x-editable"
 * When an element of the table is clicked a pop up is shown and the changments are sent to path specified in the "url" property
 */
$(document).ready(function() {

	listenersManager = ListenersManager.getInstance();
	listenersManager.initListeners();
	
	//toggle `popup` / `inline` mode
	$.fn.editable.defaults.mode = 'popup';     

	$('#scores_table a.homework').editable({
		type: 'text',
		placement: 'right',
		url: function(params){

			var type = 'update';
			updateData(params, type);
		},
		validate: function(data){

			if(!data.score.match("^[0-9]+?"))
				return "invalid text";
			if(data.score < 0 || data.score > 30 || (data.score < 30 && data.praise))
				return "invalid range";
		},
		title: 'Change score'
	});

	$('#scores_table a.newHomework').editable({
		type: 'text',
		placement: 'right',
		url: function(params){

			var type = 'new';
			updateData(params, type);
		},
		validate: function(data){

			if(!data.score.match("^[0-9]+?"))
				return "invalid text";
			if(data.score < 0 || data.score > 30 || (data.score < 30 && data.praise))
				return "invalid range";
		},
		title: 'Change score'
	});

	$('#scores_table a.exam').editable({
		type: 'text',
		placement: 'right',
		url: function(params){

			var type = 'update';
			updateExam(params, type);
		},
		address: {},
		validate: function(data){

			if(!data.score.match("^[0-9]+?"))
				return "invalid text";
			if(data.score < 0 || data.score > 30 || (data.score < 30 && data.praise))
				return "invalid range";
		},
		title: 'Change score'
	});

	$('#scores_table a.newExam').editable({
		type: 'text',
		placement: 'right',
		url: function(params){

			var type = 'new';
			updateExam(params, type);
		},
		validate: function(data){

			if(!data.score.match("^[0-9]+?"))
				return "invalid text";
			if(data.score < 0 || data.score > 30 || (data.score < 30 && data.praise))
				return "invalid range";
		},
		title: 'Change score',
	});

});


function updateExam(data, type){

	var part;
	var url;

	if(type === 'new'){

		url = "/create_Partecipation";
		parentId = data.pk.split(" ")[0];
		studentId = data.pk.split(" ")[1];
		part = {'parentId':parentId, 'studentId' : studentId,'score':data.value.score, 'praise':data.value.praise};
	}
	else{
		url = "/update_Partecipation";
		part = {'id':data.pk, 'score': data.value.score, 'praise': data.value.praise};
	}

/*	$.ajax({ 
		url: url, 
		type: 'POST',  
		data: JSON.stringify(part), 
		dataType: 'json',
		contentType: 'application/json',
	});*/
}

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
			
			$('#filter').keyup(function () {

	            var rex = new RegExp($(this).val(), 'i');
	            $('.searchable tr').hide();
	            $('.searchable tr').filter(function () {
	                return rex.test($(this).text());
	            }).show();

	        });
			
			$('#exams_checkbox').change(function(){

			    if($(this).is(':checked')){
			       $(".exam-td").show();
			    }
			    else{
			    	$(".exam-td").hide();
			    }    
			});
			
			$('#homeworks_checkbox').change(function(){

			    if($(this).is(':checked')){
			       $(".homework-td").show();
			    }
			    else{
			    	$(".homework-td").hide();
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
