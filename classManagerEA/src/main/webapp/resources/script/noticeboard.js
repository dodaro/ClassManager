$(function(){
	$("#page-size").change(function() {
		var url = "noticeboard?notices=" + $( this ).find("option:selected").text();
		console.log(url);
				window.location.href=url;
	});
	
	var value = $("#selected-value").val();
	$("#page-size").val(value);
});