<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.tencent.waresbean.WaresBean" %>
        <!-- 加载导航栏 -->
    <jsp:include page="/jsp/nav.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" href = "/MyBlogJsp/css/store.css"/>
<title>商城</title>
</head>
<body  style = "background-color : #F5F6F7">
商品列表
<div class = "container" style = "background-color:#ffffff">

<%
	List<WaresBean> list = (List<WaresBean>)request.getAttribute("waresList");
	if(list != null) {
	for(WaresBean w : list) {
		System.out.println(w.getTitle());
%>	
	<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
	<div style = "width:200px; height:350px">
		<br>
		<a href = "/MyBlogJsp/ware?wareId=<%=w.getWaresId()%>"> <img src = <%="'" + w.getImg() + "'"%> width = 200px; height = 200px; title = <%="'" + w.getTitle() + "'"%>/></a>
		<br>
		<a class = "title" href = "/MyBlogJsp/ware?wareId=<%=w.getWaresId()%>" style = "color:black;font-family:微软雅黑;font-size:10px;"><%=w.getTitle()%></a>
		<br>
		<p class = "count">剩余商品数：<%=w.getCount() %></p>
		<p class = "description"><%=w.getDescription()%></p>
	</div>
	</div>
<%
	}
	} else {
%>列表为空<%
	}
%>
</div>
</body>
</html>