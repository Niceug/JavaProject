<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "cn.edu.utils.CookieUtils"%>
    <%@ page import= "java.util.List" %>
    <%@ page import= "cn.edu.bean.Canteen" %>
    <%@ page import= "java.util.Calendar"%>
    <%@ page import= "java.util.Formatter" %>
    <%@ page import= "java.util.Locale" %>
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
	       <li class="active"><a href="#" target = "_blank">消费查询</a></li>
	        <li><a href="/CanteenFoodMachine/jsp/recharge.jsp" target = "_blank">饭卡充值<span class="sr-only">(current)</span></a></li>
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

<center style = "height:700px">
<%
	int sum[] = new int[3];
	for(int i = 2; i>=0; i--)
		sum[i] = 0;
	List<Canteen> list = (List<Canteen>)request.getAttribute("list");
	Canteen canteenc = null;
	canteenc = list.get(0);
	int last = 0;
	long startTime = canteenc.getConsumeTime();
	for(Canteen canteen : list){
		sum[canteen.getCanteenId()-11] += canteen.getConsumeMoney();
		last = list.lastIndexOf(canteen);
	}
	canteenc = list.get(last);
	long endTime = canteenc.getConsumeTime();
	
	
%>
<h1><strong>食堂消费情况直方图</strong></h1><br>
<%
	Calendar cal = Calendar.getInstance();
	cal.setTimeInMillis(startTime);
	Formatter ft=new Formatter(Locale.CHINA);
	String startTimeStr = ft.format("%1$tY年%1$tm月%1$td日 %1$tT", cal).toString();
	cal.setTimeInMillis(endTime);
	Formatter ft1=new Formatter(Locale.CHINA);
	String endTimeStr = ft1.format("%1$tY年%1$tm月%1$td日 %1$tT", cal).toString();
%>
<h5><%=startTimeStr %>~<%=endTimeStr %></h5>
<canvas id = "canvas" width = 300px; height=500px></canvas><br>
<div style = "display:inline-block;  width : 300px; height : 10px">食堂1&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp食堂2&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp食堂3&nbsp&nbsp&nbsp&nbsp</div>
</center>
<center>
	<div style = "width:100%; height:200px; background-color:gray; color:white">
	<br>
		山东大学
鲁 ICP 证 18005654 号|Copyright © 2018-2018, sdedu.cn, All Rights Reserved ME
	</div>
</center>
<script type="text/javascript">
function draw(){
	 var canvasDom = document.getElementById("canvas");
	 var context = canvasDom.getContext('2d');
	  		context.fillStyle = "gray";
	        context.fillRect(55,500,50,-(<%=sum[0]%>));
	        context.fillRect(125,500,50,-(<%=sum[1]%>));
	        context.fillRect(195,500,50,-(<%=sum[2]%>));
	        context.moveTo(0, 0);
	        context.lineTo(0,500);
	        context.lineTo(300,500);
	        context.stroke();
            context.font = "15px 宋体";  
            context.fillStyle = "gray";  
            context.fillText(<%=sum[0]%>+"元",55,500-(<%=sum[0]%> + 2), 300);  
            context.fillText(<%=sum[1]%> + "元",125,500-(<%=sum[1]%> + 2));  
            context.fillText(<%=sum[2]%> + "元",195,500-(<%=sum[2]%> + 2));  
}
window.onload = draw();
</script>

</body>
</html>