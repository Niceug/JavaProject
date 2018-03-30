<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jsp/nav.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/MyBlogJsp/css/login.css"/>
<title>用户登录</title>
</head>
<body  style = "background-color : #F5F6F7">
<!-- 导航栏已经加载 -->
<ol class="breadcrumb">
  <li><a href="/MyBlogJsp/jsp/index.jsp" >首页</a></li>
  <li><a id = "nav-tag" href="#">登录</a></li>
  <li class="active">用户登录</li>
</ol>

<div class = "container">
	<div style = "display:inline-block; width : 60%; height:500px; float:left">
		<img src = "/MyBlogJsp/image/loginLog.jpg"/>
	</div>
	<div  class = "well" style = "margin-top:-10px;display:inline-block; width : 300px; height:400px; background-color:#29A7E1; float:left">
		<form method = "post" action = "/MyBlogJsp/login">
			<table style = "color:#ffffff">
				<tr height=70px>
					<td>用户名:</td>
					<td colspan = "2"><input type="text" class="form-control" name = "username"></td>
				</tr>
				
				<tr height=70px>
					<td>密码：</td>
					<td colspan = "2"><input type="password" class="form-control" name = "password"></td>
				</tr>
				
				<tr height = 70px>
					<td>验证码：</td>
					<td><img src = "#" width = "50px" height = "30px"></td>
					<td><input type="text" class="form-control"></td>
				</tr>
				
				<tr height=70px>
					<td><button type="submit" onmouseover = "checkLogin()" class="btn btn-primary">登录</button></td>
					<td colspan="2"><button style = "float:right" onmouseover = "checkLogin()" class="btn btn-primary">注册</button></td>
				</tr>
			</table>
		</form>
		<div style = "background-color:#1997D1; width:100%; height:90px"></div>
	</div>
</div>
<div id = "foot" class = "container-fluid" style = "width : 100%; height:200px; background-color: #84ccee">
底部
</div>
</body>
</html>>