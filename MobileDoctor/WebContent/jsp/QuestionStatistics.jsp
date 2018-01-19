<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.ltp.sqlconnection.SqlOpenAndOprea"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用于处理相关提问的次数，返回给热门问题模块</title>
</head>
<body>
	<%
	//按降序找到提交问题数目排名前十的科室
	String strSearch = "select * from discuss order by id desc limit 10";
	Connection connection =  new SqlOpenAndOprea().connecteToDatabase("com.mysql.jdbc.Driver","root", "123456","MobileDoctor");
	Statement sSearch = connection.createStatement();
	ResultSet rsSearch = sSearch.executeQuery(strSearch);
	
	while(rsSearch.next())
	{
		out.print("<a href = '#'>");
		out.print("科室: "+rsSearch.getString("administrative")+"   问题："+rsSearch.getString("message"));
		out.print("</a>");
		out.print("<hr/>");
	}
	rsSearch.close();
	sSearch.close();
	connection.close();

	%>
</body>
</html>