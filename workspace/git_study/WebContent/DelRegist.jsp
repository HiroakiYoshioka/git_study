<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="user.bean.RegistrantInfo"%>

<!DOCTYPE html>

<jsp:useBean id="userInfo" scope="session" class="user.bean.UserInfo" />
<jsp:useBean id="targetInfo" scope="session" class="user.bean.RegistrantInfo" />
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>登録者削除</title>
</head>
<body>

	<%@ include file="Header.jsp" %>

	<div id="main">
		登録者削除
		<hr color=white width=30%>
		<table border="0" align="center">
			<tr>
			<th>ID</th>
			<td><input type='text' name='regId' value=<jsp:getProperty name="targetInfo" property="rId" /> disabled="disabled"></td>
			</tr>
			<tr>
			<th>名前</th>
			<td><input type='text' name='regName' value=<jsp:getProperty name="targetInfo" property="rName" /> disabled="disabled"></td>
			</tr>
			<tr>
			<th>年齢</th>
			<td><input type='text' name='regAge' value=<jsp:getProperty name="targetInfo" property="rAge" /> disabled="disabled"></td>
			</tr>
			<tr><th></th><td><input type="button" value="実行" onClick="location.href='ProcDel'"></td>
		</table>
	<br />
	<div id="menu"><a href="MenuList.jsp" style="text-decoration: none">一覧へ</a></div>
	<div id="back">
		<a href="javascript:history.back();" style="text-decoration: none">戻る</a>
	</div>
	</div>

	<%@ include file="Footer.jsp" %>

</body>
</html>