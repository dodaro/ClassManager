$(function() {
	$("#login-form").submit(function(event) {
		event.preventDefault();
		var form = $("#login-form");
		var data = {};
		
		$.each(this, function(i, v) {
            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
		});
		
		
		$.ajax({
		  contentType : 'application/json; charset=utf-8',
		  url: form.attr("action"),
		  type : form.attr("method"),
		  datatype : 'json',
		  data: JSON.stringify(data)
		}).done(function(data) {
			
			$(".glyphicon").remove();
			$(".errors").empty();
			$(".has-error").removeClass("has-error has-feedback");
			
			if(data.status==="ERROR")	{
                for(var key in data.errorsMap)	{
                	var error = data.errorsMap[key];
                    console.log(key + " " + error);
                    var formGroup =  $("input[name=" + key + "]").parent();
                    formGroup.append('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
                    formGroup.addClass("has-error has-feedback");
                    var errorDiv = formGroup.find(".errors");
                    errorDiv.append('<span class="help-inline">' + error + '</span>');
                }
			}
		});
	});
});