<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "cn.edu.utils.CookieUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang = "zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name = "viewport" content="width = device-width, initial-scale = 1 user-scalable = no">
<link rel = "stylesheet" href = "/CanteenFoodMachine/bootstrap/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<link rel = "stylesheet" href = "/CanteenFoodMachine/css/nav.css"/>
<script type="text/javascript" src="/CanteenFoodMachine/JQuery/jquery-1.11.0.min.js"></script>
<script  src = "/CanteenFoodMachine/bootstrap/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<div id = "top" style = "background-color:#29A7E1;" >
	<nav class="navbar navbar-default" style = "background-color:#29A7E1; ">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="/CanteenFoodMachine/jsp/index.jsp">首页</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	       <li><a href="/CanteenFoodMachine/jsp/index.jsp" target = "_blank">消费查询</a></li>
	        <li class="active"><a href="#" target = "_blank">饭卡充值<span class="sr-only">(current)</span></a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li>
	        <%
	        Cookie c = CookieUtils.getCookieByName("username", request.getCookies()); 
	    		if(c != null){
	        %> <%="<a href='/CanteenFoodMachine/userInfo?username="+c.getValue()+"'>" + c.getValue()+"欢迎回来！</a><a style = 'display:inline' href = '/CanteenFoodMachine/exit'><small>退出</small></a>"%>
	        <%} else {%>
	        <a href="/CanteenFoodMachine/login.html" target = "_blank">登录</a>
	    	<%
	        }
	    	%>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav><!-- 导航栏完 -->
</div>
<center style = "height:500px">
<div style = "margin-top:20px; width:350px; height:200px; border:2px solid a8a8a8; background-color:#e7e7e7; opacity: 0.8;">
<br>
	<form action = "/CanteenFoodMachine/recharge" method = "post">
		&nbsp&nbsp&nbsp&nbsp饭卡号：<input type = "text" name = "n_mealCardId"><br><br>
		充值金额：<input type = "text" name = "n_sum"><br><br>
		<input type = "submit" value = "充值">
	</form>
</div>
</center>
<center>
	<div style = "width:100%; height:200px; background-color:gray; color:white">
	<br>
		山东大学
鲁 ICP 证 18005654 号|Copyright © 2018-2018, sdedu.cn, All Rights Reserved ME
	</div>
</center>
</body>
</html>