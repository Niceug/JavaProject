<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 加载导航栏 -->
<%@ page import="com.tencent.waresbean.WaresBean" %>
<jsp:include page="/jsp/nav.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" href = "/MyBlogJsp/css/ware.css"/>
<%
	WaresBean w = (WaresBean)request.getAttribute("ware");
%>
<title><%=w.getTitle()%>-我的博客-商品详情</title>
</head>
<body>
<div class = "container">
	<div>
		<div>
			商品详情：<hr>
		</div>
		<div id = "wareInfo">
			<div class = "wareInfo-left col-lg-6 col-md-6 col-sm-6 col-xs-12">
			
			<img src=<%="'" + w.getImg() + "'"%> width=500px; height:500px>
			<%
			%>
			</div>
			<div class = "buyInfo-right col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<p><%=w.getTitle()%></p>
			<h1><strong style = "color:#DD0000">¥<%=w.getPrice()%></strong></h1>
			<div style = "color:gray; background-color:#FAFAFA; padding-left:10px; padding-top:10px">
			<p>配送信息：圆通快递，顺丰快递</p>
			<p>好评率：90%</p>
			<p>类别：红色可选</p>
			</div>
			<form action = "/MyBlogJsp/cart?waresId=<%=w.getWaresId()%>&title=<%=w.getTitle()%>&price=<%=w.getPrice()%>&img=<%=w.getImg()%>" method = "post">
				<p>购买数量：<input type="text" maxlength="2" size="2" name = "buyCount"/></p>
				<input class = "btn btn-default" type="submit" value = "立即购买" style = "width:140px; height:50px; background-color:#CC0000; color:#ffffff"/>
				<input class = "btn btn-default" type="submit" value = "加入购物车" style = "width:140px; height:50px; background-color:#FFEDED; color:#CC0000"/>
			</form>
			</div>
		</div>
		<div class = "other col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<img src = "/MyBlogJsp/image/hot.png" width=100%>
		</div>
	</div>

</div>


</body>
</html>