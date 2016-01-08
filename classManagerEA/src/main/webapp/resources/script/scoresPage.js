/*
 * The html table stored information is handled using a bootstrap plug-in: "x-editable"
 * When an element of the table is clicked a pop up is shown and the changments are sent to path specified in the "url" property
 */
$(document).ready(function() {

	//toggle `popup` / `inline` mode
	$.fn.editable.defaults.mode = 'popup';     

	//TODO retrieve the score id and store values in array to send
	$('#scores_table a').editable({
		type: 'text',
		placement: 'right',
		url: function(params){
			updateData(params);
		},
		title: 'Change score'
	});

});

function updateData(params){
	
	$.ajax({ 
		headers: {
			Accept : "text/plain; charset=utf-8"
		},
		url: "/update_score", 
		type: 'POST', 
		dataType: 'json', 
		data: toSend, 
		contentType: 'application/json',
		mimeType: 'application/json',
		success: function(data) { 
			if(data == "200")
				window.location.replace("/scores");
		},
		error:function(data,status,er) { 
			alert("error: "+data+" status: "+status+" er:"+er);
		}
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
//
//	/*var students = JSON.parse(JSON.stringify(data.students));
//	var studentHomeworks = JSON.parse(JSON.stringify(data.studentHomeworks));
//	var scores = JSON.parse(JSON.stringify(data.scores));
//	var homeworksName = JSON.parse(JSON.stringify(data.homeworksName));
//	var homeworkSolution = JSON.parse(JSON.stringify(data.homeworkSolution));
//
//	var map_scores = {};
//
//	$.each(studentHomeworks, function(student, homeworks){
//
//		if(!(student in map_scores))
//			map_scores[student] = {};
//
//		$.each(homeworks, function(num, homework){
//
//			if(!homework in map_scores[student])
//				map_scores[student][homework] = {};
//
//			var keyHS = homework + "-" + student;
//			var id_ = homeworkSolution[keyHS]
//			map_scores[student][homework] = {'id': id_, 'score': scores[id_]};
//
//		});
//	});*/
//
///*
//	//starting from the hash map an html table is created
//	var content = "<tr><td></td>";
//	$.each(homeworksName, function(id, name){
//
//		content += "<td>" + name + "</td>";
//	});
//	content += "</tr>";
//
//	$.each(map_scores, function(student, homeworks){
//
//		content += "<tr>";
//		content += "<td>" + students[student] + "</td>";
//
//		$.each(homeworks, function(key, val){
//
//			content += "<td><a href=# data-pk=" + val.id + ">" + val.score + "</a></td>";
//		});
//		content += "</tr>";
//	});
//
//	$('#scores_table').append(content);
//
//	scoreContainer = new ScoreContainer();*/
//}
//
///*
// *	Sends data to the server for the update 
// */
//function sendData(){
//
//	if(scoreContainer.isEmpty())
//		return;
//
//	var toSend = JSON.stringify(scoreContainer.getScores());
//
//	$.ajax({ 
//		headers: {
//			Accept : "text/plain; charset=utf-8"
//		},
//		url: "/update_scores", 
//		type: 'POST', 
//		dataType: 'json', 
//		data: toSend, 
//		contentType: 'application/json',
//		mimeType: 'application/json',
//		success: function(data) { 
//			if(data == "200")
//				window.location.replace("/scores");
//		},
//		error:function(data,status,er) { 
//			alert("error: "+data+" status: "+status+" er:"+er);
//		}
//	});
//}
///*
// * stores temporary information about the score update. Called every time a score changes
// */
//function updateData(data){
//
//	scoreContainer.addScore(data);
//}