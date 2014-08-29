$(function() {
	var requestObj = {
			userName : null,
			userPass : null,
	};
	
	$("#login").click(function() {
		requestObj.userName = $("#userName").val();
		requestObj.userPass = $("#passward").val();
		var requestJson = $.toJSON(requestObj);

		$.ajax({
			type: "POST",
			url:"Login",
			data: {"requestJs" : requestJson},
			success : function(data) {
				document.write(data);
				window.location.reload();
			},
			error : function(XMLHttpRequest, textStatus, erroThrown) {
				alert("NG");
			}
		});
	});
});