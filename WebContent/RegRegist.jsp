<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="user.bean.RegistrantInfo"%>

<!DOCTYPE html>

<jsp:useBean id="userInfo" scope="session" class="user.bean.UserInfo" />
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>雇用者登録</title>
</head>
<body>

	<%@ include file="Header.jsp" %>

	<div id="main">
		雇用者登録
		<hr color=white width=30%>
		<% String errMsg = (String)request.getAttribute("errMsg");
		if (errMsg!=null) { %>
		<div id="errMsg"><%=errMsg %></div><br />
		<%	}
		%>
		<form action='ProcReg' method=POST>

		<table border="0" align="center">
			<tr>
			<th>名前</th>
			<td><input type='text' name='regName'></td>
			</tr>
			<tr>
			<th>年齢</th>
			<td><input type='text' name='regAge'></td>
			</tr>
			<tr><th></th><td><input type='submit' name='button' value='登録'></td>
		</table>
	</form>
	<br />
	<div id="back">
		<a href="javascript:history.back();" style="text-decoration: none">戻る</a>
	</div>
	</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>