<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>サービス一覧</title>	
</head>
<body>

	<%@ include file="Header.jsp" %>

	<div id="main">
		サービス一覧<hr color=white width=30%>
		<p><a href="RegistList" style="text-decoration: none">雇用者一覧</a></p>
		<p><a href="RegRegist.jsp" style="text-decoration: none">雇用者登録</a></p>
		<p><a href="RegistInfo.jsp" style="text-decoration: none">雇用者一覧(詳細込)</a></p>
	</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>