<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%@ page import= "com.ltp.sqlconnection.SqlOpenAndOprea" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录结果页面</title>
</head>
<body>

<%
     response.setCharacterEncoding("utf-8");
	//连接数据库
	 Connection connection =   new SqlOpenAndOprea().connecteToDatabase("com.mysql.jdbc.Driver","root", "123456","MobileDoctor");
	 request.setCharacterEncoding("utf-8");
	 Statement statement = connection.createStatement();
	 String sql="SELECT * FROM login";
	 ResultSet rs = statement.executeQuery(sql);
	 boolean LoginSuccess = false;
	 //查询
	 while(rs.next()) {
	   if(rs.getString("pUserName").equals(request.getParameter("pUserName")))
	   {
		   	if(rs.getString("pPassword").equals(request.getParameter("pPassword")))
		   	{
				LoginSuccess = true;
				out.print("<script>");
				out.print("window.location.href='../index.html?userName="+request.getParameter("pUserName")+"'");  
				out.print("</script>"); 
				break;
		   	}
		   	else
		    {
		   		LoginSuccess = true;
		   		out.print("<script>");
		       	out.print("window.location.href = '../index.html';");
		       	out.print("alert('密码错误');");
		       	out.print("</script>");
		       	break;
		    }
	   }
	 }
	 
	 if(LoginSuccess == false)
	 {
				out.print("<script>");
				out.print("window.location.href='../index.html';");
				out.print("window.alert('用户名不存在');");
				out.print("</script>"); 
	 }
	rs.close();
	statement.close();
	connection.close();
%>

</body>
</html>

