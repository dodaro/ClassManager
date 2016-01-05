$(function(){
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
//	    href: "searchusers?page={{number}}",
	    leaps: false
	}).on("page", function(event, num){
	    window.location.href = "noticeboard?page="+num;
	});
    
	var value = $("#selected-value").val();
	$("#page-size").val(value);
	
	
	
});