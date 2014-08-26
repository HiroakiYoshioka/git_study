function test(test, obj){
	var param = ("000" + test).slice(-3);

	var responseObj = {
			rId : null,
			rName : null,
			rAge : null,
	};

	$.ajax({
		type: "GET",
		url:"RegistDetail",
		data: {"selectNum" : param},
		cache: false,
		success : function(data) {
			var resStr = JSON.stringify(data.responseMessage);
			responseObj = JSON.parse(resStr);

			$("#regId").html(responseObj.rId);
			$("#regName").html(responseObj.rName);
			$("#regAge").html(responseObj.rAge);
			
			$("#target a").removeClass('select');
			$(obj).addClass('select');
			
			var id = document.getElementById("hId");
			var name = document.getElementById("hName");
			var age = document.getElementById("hAge");
			id.setAttribute("value", responseObj.rId);
			name.setAttribute("value", responseObj.rName);
			age.setAttribute("value", responseObj.rAge);
		},
		error : function(XMLHttpRequest, textStatus, erroThrown) {
			alert("NG");
		}
	});
}