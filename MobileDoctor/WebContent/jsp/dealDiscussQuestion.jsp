<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.ltp.sqlconnection.SqlOpenAndOprea" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
    
	String strMessage = request.getParameter("QuestionDiscribe");
	String strAdministrative = request.getParameter("administrative");
	String sqlUpdate = "UPDATE QuestionStatistics SET requestCount = requestCount+1 WHERE administrative='"+strAdministrative+"'";
	String sqlInsert = "insert into discuss values('"+strAdministrative+"',"+0+",'"+strMessage+"',"+null+")";

	//连接数据库
	Connection conn =  new SqlOpenAndOprea().connecteToDatabase("com.mysql.jdbc.Driver","root", "123456","MobileDoctor");
	PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
	PreparedStatement psInsert = conn.prepareStatement(sqlInsert);
	psUpdate.executeUpdate();
	psInsert.executeUpdate();
	psInsert.close();
	psUpdate.close();
	conn.close();
	out.print("<script>");
	out.print("window.location.href='../Forum.html';"); 
	out.print("alert('提交成功');");
	out.print("</script>");
%>

</body>
</html>