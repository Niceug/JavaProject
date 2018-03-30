<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <!-- 加载导航栏 -->
<jsp:include page="/jsp/nav.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type = "stylesheet" href = "/MyBlogJsp/css/userInfo.css"/>
<title>个人信息-页面</title>
</head>
<body style = "background-color:#F5F6F7">
<!-- 已经加载过了导航栏 -->
<ol class="breadcrumb">
  <li><a href="/MyBlogJsp/jsp/index.jsp" >首页</a></li>
  <li><a id = "nav-tag" href="#">个人信息</a></li>
  <li>个人博客列表</li>
</ol>
<div class = "container">
<div id = "userinfo-content" style = "width : 100%; height:1000px; background-color:#F5F6F7">
<!-- 博客列表 -->
	<div id = "left-content" style = "width : 67%; height: 1000px; background-color:#ffffff; float : left">
		<%List<String> list= (List<String>)request.getAttribute("blogList"); 
		if(list != null)
		  for(String str : list) {
			  String[] hrefAndTitle =  str.split("<@>");
		%>
		<a href =<%="'" + hrefAndTitle[0] + "'"%>><%=hrefAndTitle[1]%></a><br>
		<%
		  } else {
			 %>
		列表为空
			 <%
		  }
		%>
	
	</div>
<!-- 个人信息 -->
	<div id = "right-userinfo" style = "margin-left:3%;width : 30%; height: 900px; background-color:#ffffff; display:inline-block; ">
		<div style = "margin-left:10%; margin-top:5px">
			<div style = "width:95%; height:100px; background-color:#E5E6E7">头像和用户名</div>
			<hr>
			<div style = "width:95%; height:50px; background-color:#E5E6E7">文章信息</div>
			<hr>
			<div style = "width:95%; height:50px; background-color:#E5E6E7">博客等级信息</div>
			<hr>
			<div style = "width:95%; height:200px; background-color:#E5E6E7">爱好等隐私信息</div>
			<hr>
			<div style = "width:95%; height:300px; background-color:#E5E6E7">最近浏览文章</div>
		</div>
	</div>
</div>
</div><!-- 最大的div-container -->
</body>
</html>