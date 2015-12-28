$(function() {
	
	$(".btn-success").click(function(event) {
		
		var user = $(this).closest("tr").find(".user").html();
		console.log(user)
		
		
		$.post( "promoteuser", { user: user } );

	});
	
	$(".btn-danger").click(function(event) {
		e.preventDefault();
		alert("prevented remove");
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