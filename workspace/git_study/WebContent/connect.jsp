<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, javax.naming.*, javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>データベースへの接続01</title>
</head>
<body>
<%
Context context = new InitialContext();
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/task");
//DataSource ds = (DataSource)context.lookup("java:comp/env/selfjsp");

Connection db = ds.getConnection();
/*
PreparedStatement stmt = db.prepareStatement("SELECT * FROM task.registrants");
ResultSet rs = stmt.executeQuery();

while(rs.next()){
	System.out.println(rs.getString("registrant_id"));
}*/

db.close();
%>

データベースへの接続に成功しました。
</body>
</html>
