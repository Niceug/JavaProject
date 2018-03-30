<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "com.tencent.cookieutils.CookieUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang = "zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name = "viewport" content="width = device-width, initial-scale = 1 user-scalable = no">
<link rel = "stylesheet" href = "/MyBlogJsp/bootstrap/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<link rel = "stylesheet" href = "/MyBlogJsp/css/nav.css"/>
<script type="text/javascript" src="/MyBlogJsp/JQuaryjs/jquery-1.11.0.min.js"></script>
<script  src = "/MyBlogJsp/bootstrap/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div id = "top" style = "background-color:#29A7E1;" >
	<nav class="navbar navbar-default" style = "background-color:#29A7E1; ">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar">图标1</span>
	        <span class="icon-bar">图标2</span>
	        <span class="icon-bar">图标3</span>
	      </button>
	      <a class="navbar-brand" href="/MyBlogJsp/jsp/index.jsp">首页</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="/MyBlogJsp/blog?pageId=1" target = "_blank">博客<span class="sr-only">(current)</span></a></li>
	        <li><a href="/MyBlogJsp/code" target = "_blank">代码</a></li>
	        <li><a href="/MyBlogJsp/questionsAndAnswers" target = "_blank">问答</a></li>
	        <li><a href="/MyBlogJsp/activity" target = "_blank">活动</a></li>
	        <li><a href="/MyBlogJsp/store" target = "_blank">商城</a></li>
	        <li><a href="/MyBlogJsp/codeDownload" target = "_blank">源码下载</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">下拉菜单 <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">下拉选项1</a></li>
	            <li><a href="#">下拉选项2</a></li>
	            <li><a href="#">下拉选项3</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">一个分离的链接</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">另一个分离的链接</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form class="navbar-form navbar-right">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search">
	        </div>
	        <button type="submit" class="btn btn-default">全站搜索</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	        <li>
	        <%
	        Cookie c = CookieUtils.getCookieByName("username", request.getCookies()); 
	    		if(c != null){
	        %> <%="<a href='/MyBlogJsp/userInfo?username="+c.getValue()+"'>" + c.getValue()+"欢迎回来！</a><a style = 'display:inline' href = '/MyBlogJsp/exit'><small>退出</small></a>"%>
	        <%} else {%>
	        <a href="/MyBlogJsp/jsp/login.jsp" target = "_blank">登录</a>
	    	<%
	        }
	    	%>
	        </li>
	        <li><a href = "/MyBlogJsp/jsp/registe.jsp" target = "_blank">注册</a></li>
	        <li><a href = "/MyBlogJsp/cart" target = "_blank">购物车</a></li>
	        <li><a href = "/MyBlogJsp/jsp/writeBlog.jsp" target = "_blank">写博客</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人信息 <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">我的博客</a></li>
	            <li><a href="#">消息</a></li>
	            <li><a href="#">设置</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav><!-- 导航栏完 -->
</div>
</body>
</html>