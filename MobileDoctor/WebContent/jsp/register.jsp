<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import = "com.ltp.sqlconnection.SqlOpenAndOprea" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册结果页面</title>
</head>
<body>
<%
         response.setCharacterEncoding("utf-8"); 
		 request.setCharacterEncoding("utf-8");
		 String registePUserName = request.getParameter("registerpUserName");
		 String registePPassword = request.getParameter("registerpPassword");
		 String registePSex = request.getParameter("registerpSex");
		
		 //连接数据库
		 Connection connection =  new SqlOpenAndOprea().connecteToDatabase("com.mysql.jdbc.Driver","root", "123456","MobileDoctor");
		 
		 //查询表中是否已经有这个用户名
		 String sqlSelect = "select pUsername from login";
		 Statement statementSelect = connection.createStatement();
		 ResultSet rsSelect = statementSelect.executeQuery(sqlSelect);
		 boolean hasThisUserName = false;
		 
		 //插入语句
		 String sqlInsert="insert into login values('"+registePUserName+ "'" +",'"+ registePPassword+"')";
		  PreparedStatement preStmt=connection.prepareStatement(sqlInsert); 
		  
		 if(registePUserName!=null){
			  while(rsSelect.next())
			  {
				  if(registePUserName.equals(rsSelect.getString("pUsername")))
				  {
					  out.print("<script>");
			    	  out.print("window.location.href='../index.html';");  
			    	  out.print("alert('注册失败，用户名已存在！');");
			    	  out.print("</script>"); 
					  hasThisUserName = true;
					  break;
				  }
			  }
			  if(hasThisUserName == false)
			  {
				  preStmt.executeUpdate();
				  out.print("<script>");
		    	  out.print("window.location.href='../index.html?UserName="+registePUserName+"';");  
		    	  out.print("alert('注册成功，已为您自动登录');");
		    	  
		    	  //显示结果为测试2
		    	  //out.print("alert('"+registePUserName+"');");
		    	  
		    	  out.print("</script>"); 
			  }
			  rsSelect.close();
			  statementSelect.close();
			  preStmt.close();
			  connection.close();
		 }
  %>
</body>
</html>