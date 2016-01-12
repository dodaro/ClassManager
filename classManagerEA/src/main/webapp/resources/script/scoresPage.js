/*
 * The html table stored information is handled using a bootstrap plug-in: "x-editable"
 * When an element of the table is clicked a pop up is shown and the changments are sent to path specified in the "url" property
 */
$(document).ready(function() {

	//toggle `popup` / `inline` mode
	$.fn.editable.defaults.mode = 'popup';     

	$('#scores_table a.homework').editable({
		type: 'text',
		placement: 'right',
		url: function(params){

			var type = 'update'
				updateData(params, type);
		},
		title: 'Change score'
	});

	$('#scores_table a.newHomework').editable({
		type: 'text',
		placement: 'right',
		url: function(params){

			var type = 'new'
				updateData(params, type);
		},
		title: 'Change score'
	});

	$('#scores_table a.exam').editable({
		type: 'text',
		placement: 'right',
		url: function(params){

			var type = 'update'
				updateExam(params, type);
		},
		title: 'Change score'
	});

	$('#scores_table a.newExam').editable({
		type: 'text',
		placement: 'right',
		url: function(params){

			var type = 'new'
				updateExam(params, type);
		},
		success: function(data){
			//return data.success.code;
		},
		validate: function(response, newValue){

			if(!data.match("^[0-9]+?"))
				return "invalid text";
			if(data < 0 || data > 30)
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
		part = {'parentId':parentId, 'studentId' : studentId,'score':data.value};
	}
	else{
		url = "/update_Partecipation";
		part = {'id':data.pk, 'score':data.value, 'type':data.type};
	}

	$.ajax({ 
		url: url, 
		type: 'POST',  
		data: JSON.stringify(part), 
		dataType: 'json',
		contentType: 'application/json',
	});
}



/* * OLD VERSION * *\
//var ScoreContainer = (function(){
//
//	var toSend;
//	var isEmpty;
//	var addScore;
//	var getScores;
//	var ScoreContainer = function(){
//
//		this.toSend = {};
//		this.isEmpty = isEmpty;
//		this.addScore = addScore;
//		this.getScores = getScores;
//	}
//
//	var getScores = function(){
//		
//		var res = new Array();
//		$.each(this.toSend, function(id, data){
//			
//			res.push({'id':data.id, 'score':data.score});
//		});
//		
//		return res;
//	}
//
//	var isEmpty = function(){
//
//		if(this.toSend.length == 0)
//			return true;
//		return false;
//	}
//
//	var addScore = function(data){
//
//		var homeworkStudentSolving = {'id':data.pk, 'score':data.value};
//		this.toSend[data.pk] = homeworkStudentSolving;
//	}
//
//	return ScoreContainer;
//
//})();
//
///**
// * This functions uses the informations stored in the "data" model object, that is an instance of the "scoresPageTransformView"
// * class and organizes them in an bidimensional hash map of the form map[studentID][homeworkID] = score
// */
//function init(){

///*var students = JSON.parse(JSON.stringify(data.students));
//var studentHomeworks = JSON.parse(JSON.stringify(data.studentHomeworks));
//var scores = JSON.parse(JSON.stringify(data.scores));
//var homeworksName = JSON.parse(JSON.stringify(data.homeworksName));
//var homeworkSolution = JSON.parse(JSON.stringify(data.homeworkSolution));

//var map_scores = {};

//$.each(studentHomeworks, function(student, homeworks){

//if(!(student in map_scores))
//map_scores[student] = {};

//$.each(homeworks, function(num, homework){

//if(!homework in map_scores[student])
//map_scores[student][homework] = {};

//var keyHS = homework + "-" + student;
//var id_ = homeworkSolution[keyHS]
//map_scores[student][homework] = {'id': id_, 'score': scores[id_]};

//});
//});*/

///*
////starting from the hash map an html table is created
//var content = "<tr><td></td>";
//$.each(homeworksName, function(id, name){

//content += "<td>" + name + "</td>";
//});
//content += "</tr>";

//$.each(map_scores, function(student, homeworks){

//content += "<tr>";
//content += "<td>" + students[student] + "</td>";

//$.each(homeworks, function(key, val){

//content += "<td><a href=# data-pk=" + val.id + ">" + val.score + "</a></td>";
//});
//content += "</tr>";
//});

//$('#scores_table').append(content);

//scoreContainer = new ScoreContainer();*/
//}

///*
//*	Sends data to the server for the update 
//*/
//function sendData(){

//if(scoreContainer.isEmpty())
//return;

//var toSend = JSON.stringify(scoreContainer.getScores());

//$.ajax({ 
//headers: {
//Accept : "text/plain; charset=utf-8"
//},
//url: "/update_scores", 
//type: 'POST', 
//dataType: 'json', 
//data: toSend, 
//contentType: 'application/json',
//mimeType: 'application/json',
//success: function(data) { 
//if(data == "200")
//window.location.replace("/scores");
//},
//error:function(data,status,er) { 
//alert("error: "+data+" status: "+status+" er:"+er);
//}
//});
//}
///*
//* stores temporary information about the score update. Called every time a score changes
//*/
//function updateData(data){

//scoreContainer.addScore(data);
//}

$(document).ready(function() {

	$(document).find('input').on('input', function(e){

		folders = [];
		files = [];

		var value = this.value.trim();

		if(value.length) {

			$("table td").each(function(index){

				var elem = $(this).find("a").text();
				var current = elem.text();
				if(typeof current != 'undefined')
					if(current.toLowerCase().indexOf(value.toLowerCase()) == -1){
						elem.hide();
					}
					else
						elem.show();
			});
		}

		else {

			$(".data a").each(function(index){
				$(this).show();
			});

		}

	});
});