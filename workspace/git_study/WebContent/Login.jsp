<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="js/Login.js" charset="UTF-8"></script>
<link rel="stylesheet" href="Task.css" type="text/css" />

<title>ログイン画面</title>
</head>
<body>

	<%@ include file="Header.jsp" %>

	<div id="main">
	<% String errMsg = (String)request.getAttribute("errMsg");
		if (errMsg!=null) { %>
		<div id="errMsg"><%=errMsg%></div><br />
	<%	}
	%>

	<table border="0" align="center">
		<tr>
		<th>ユーザ</th>
		<td><input type='text' id="userName"></td>
		</tr>
		<tr>
		<th>パスワード</th>
		<td><input type='password' id="passward"></td>
		</tr>
		<tr><th></th><td><input type='button' style="width:80px;height:30px" id="login" value='ログイン'></td>
	</table>
	</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>