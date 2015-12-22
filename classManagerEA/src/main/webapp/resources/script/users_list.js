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
		
	
})