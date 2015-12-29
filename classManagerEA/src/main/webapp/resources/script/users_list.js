$(function() {
	
	$(".btn-success").click(function(event) {
		event.preventDefault();
		var user = $(this).closest("tr").find(".user").html();
		$.post( "edituser", { user: user,action :"promote" }, function(data){
			location.href=data;	
		});

	});
	
	$(".btn-danger").click(function(event) {
		event.preventDefault();
		var user = $(this).closest("tr").find(".user").html();
		$.post( "edituser", { user: user,action :"delete" }, function(data){
			location.href=data;	
		});
	});
	
	var totalPages = parseInt($("#options :input[name='total-pages']").val());
	var currentPage = parseInt($("#options :input[name='page-number']").val());
	
	$('#paginator').bootpag({
	    total: totalPages,
	    page: currentPage,
	    maxVisible: 5,
//	    href: "searchusers?page={{number}}",
	    leaps: false
	}).on("page", function(event, num){
	    window.location.href = "searchusers?page="+num;
	});
    
		
	
})