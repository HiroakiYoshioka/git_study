<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<jsp:useBean id="userInfo" scope="session" class="user.bean.UserInfo" />
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>サービス一覧</title>	
</head>
<body>

	<%@ include file="Header.jsp" %>

	<div id="main">
		只今、お問い合わせは受け付けておりません。<br />
		<div id="back">
		<a href="javascript:history.back();" style="text-decoration: none">戻る</a>
		</div>
	</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>