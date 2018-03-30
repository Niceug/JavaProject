<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 加载导航栏 -->
<%@ page import="com.tencent.waresbean.WaresBean" %>
<%@ page import="java.util.Map" %>
<jsp:include page="/jsp/nav.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
<div class = "container">
	<%
		Map<String, Integer> map = (Map<String, Integer>)session.getAttribute("cart");
	%>
	<table style = "border:1px solid gray; width:800px;">
		<tr style = "background-color:gray; height:50px;">
			<td>商品ID</td>
			<td>购买数量</td>
		</tr>
		<%if(map == null){ %>
		<tr><td colspan = "2">购物车为空</td></tr>
		<%} else {
			for(String name : map.keySet()) {
		%>
			<tr style = "height:40px;">
				<td><%= name%></td>
				<td><%=map.get(name)%></td>
			</tr>
		<%
			}
		}
		%>
	</table>

</div>

</body>
</html>