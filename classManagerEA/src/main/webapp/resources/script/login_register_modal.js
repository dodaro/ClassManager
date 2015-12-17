$(function(){
	$("#login-button").click(function(e) {
		e.preventDefault();
		$("#modal-body").load("login",function() {
			$("#myModal").modal("show");
		});
	});
	
});