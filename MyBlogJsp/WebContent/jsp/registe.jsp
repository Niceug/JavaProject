<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 加载导航栏 -->
    <jsp:include page="/jsp/nav.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body style = "background-color : #F5F6F7">
<ol class="breadcrumb">
  <li><a href="/MyBlogJsp/jsp/index.jsp" >首页</a></li>
  <li><a id = "nav-tag" href="#">注册</a></li>
  <li class="active">用户注册</li>
</ol>
<div class = "container">
<div style = "width:300px; height:200px; background-color:red; margin-left:auto; margin-right:auto">
	<form action = "/MyBlogJsp/registe" method = "post">
		<table style = "margin-left:auto; margin-right:auto; height:100px">
			<tr>
				<td>用户名：</td>
				<td><input type = "text" name = "username" ></td>
			</tr>
			<tr>
				<td>密&nbsp码：</td>
				<td><input type = "password" name = "password" ></td>
			</tr>
			<tr>
			<td colspan = "2"><input type = "submit" value = "注册"></td>
			</tr>
			
		
		</table>
	</form>
	</div>
</div>
</body>
</html>