<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>雇用サービス受付</title>	
</head>
<body>
	<div id ="header">
		雇用サービス受付<br />
		<%
			String userName = (String)session.getAttribute("userName");
		if (userName != null) { %>
		<div id="login">ログイン　：<%=userName %></div>
		<div id="logout"><a href="Logout" style="text-decoration: none">ログアウト</a></div>
		<% } %>
	</div>
</body>
</html>