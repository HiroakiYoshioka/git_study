<%@ page language="java" contentType="text/html; charset=UTF-8" import="user.bean.RegistrantInfo"
import="user.bean.RegistrantInfo"
import="java.util.ArrayList"
%>

<!DOCTYPE html>

<jsp:useBean id="userInfo" scope="session" class="user.bean.UserInfo" />
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>雇用者情報詳細</title>	
</head>
<body>
	<%@ include file="Header.jsp" %>

	<div id="main">
	雇用者情報詳細<hr color=white width=30%>
		<table class="regList">
		<% 
		   RegistrantInfo outInfo = null;
		   String onNum = request.getParameter("onNum");

		   if (onNum!=null) {
			   ArrayList<RegistrantInfo> rInfo = (ArrayList<RegistrantInfo>) session.getAttribute("regList");
			   outInfo = rInfo.get(Integer.parseInt(onNum));
			   session.setAttribute("targetInfo", outInfo);
			} else {
			   outInfo = (RegistrantInfo)session.getAttribute("targetInfo");	
			}
		%>
		<tr>
			<th width="150">ID</th>
			<td width="200"><%=outInfo.getrId() %></td>
		</tr>
		<tr>
			<th>名前</th>
			<td><%=outInfo.getrName() %></td>
		</tr>
		<tr>
			<th>年齢</th>
			<td><%=outInfo.getrAge() %></td>
		</tr>
		</table>
		<br />
		<input type="button" value="変更" onClick="location.href='ModRegist.jsp'">　　　
		<input type="button" value="削除" onClick="location.href='DelRegist.jsp'">
		<br /><br />
		<div id="menu"><a href="MenuList.jsp" style="text-decoration: none">一覧へ</a></div>
		<a href="javascript:history.back();" style="text-decoration: none">戻る</a>
 	</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>