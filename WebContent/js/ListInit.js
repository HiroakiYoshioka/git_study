$(function() {

	$(document).ready(function() {
		
		$.ajax({
			type: "GET",
			url:"RegIdGet",
			cache: false,
			success : function(data) {
				var resStr = JSON.stringify(data.regInfo);
				var responseObj = JSON.parse(resStr);

				$("#regId").append(responseObj[0].rId);
				$("#regName").append(responseObj[0].rName);
				$("#regAge").append(responseObj[0].rAge);

				var tabs = document.getElementById("target");

				for(var i=0; i<responseObj.length; i++) {
					var lv = document.createElement("a");
					lv.setAttribute("href", "#");
					lv.setAttribute("onclick", "test(" + responseObj[i].rId +", this)");
					var tabText = document.createTextNode(responseObj[i].rId);
					lv.appendChild(tabText);
					tabs.appendChild(lv);
					if (i==0) {
						$("#target a").addClass('select');
						var id = document.getElementById("hId");
						var name = document.getElementById("hName");
						var age = document.getElementById("hAge");
						id.setAttribute("value", responseObj[i].rId);
						name.setAttribute("value", responseObj[i].rName);
						age.setAttribute("value", responseObj[i].rAge);
						
						var frm = document.getElementById("btn");
						var modBtn = document.createElement("input");
						modBtn.setAttribute("type", "submit");
						modBtn.setAttribute("name", "mod");
						modBtn.setAttribute("value", "変更");
						frm.appendChild(modBtn);
						
						var delBtn = document.createElement("input");
						delBtn.setAttribute("type", "submit");
						delBtn.setAttribute("name", "del");
						delBtn.setAttribute("value", "削除");
						frm.appendChild(delBtn);

					}
				}
			
			},
			error : function(XMLHttpRequest, textStatus, erroThrown) {
				alert("NG");
			}
		});
	});
});