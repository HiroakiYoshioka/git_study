<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="user.bean.RegistrantInfo" import="java.util.ArrayList"%>

<!DOCTYPE html>

<jsp:useBean id="userInfo" scope="session" class="user.bean.UserInfo" />
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="js/ListInit.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/ListDetail.js" charset="UTF-8"></script>
<title>雇用者一覧</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div id="main">
		雇用者一覧
		<hr color=white width=30%>
		<div class="tabbox">
			<p class="tabs" id="target">

			</p>
		</div>

		<table class="regList" id="regList">
			<tbody>
				<tr>
					<th width="150">ID</th>
					<td width="200" id="regId"></td>
				</tr>
				<tr>
					<th>名前</th>
					<td id="regName"></td>
				</tr>
				<tr>
					<th>年齢</th>
					<td id="regAge"></td>
				</tr>
			</tbody>
		</table>
		<br />
		<form action='HidHandler' method=POST id='btn'>
			<input type='hidden' name='id' id='hId'>
			<input type='hidden' name='name' id='hName'>
			<input type='hidden' name='age' id='hAge'>			
		</form>
		<div id="back">
		<a href="javascript:history.back();" style="text-decoration: none">戻る</a>
		</div>
	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>