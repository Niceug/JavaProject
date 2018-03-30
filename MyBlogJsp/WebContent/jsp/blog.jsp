<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.tencent.blogservlet.User" %>
    <%@ page import = "java.util.List" %>
<!-- 加载导航栏 -->
<jsp:include page="/jsp/nav.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/MyBlogJsp/css/blog.css"/>
<title>博客列表</title>
</head>
<body style = "background-color : #F5F6F7">
<!-- 已经加载了导航栏 -->
<div>
<ol class="breadcrumb">
  <li><a href="/MyBlogJsp/jsp/index.jsp" >首页</a></li>
  <li><a id = "nav-tag" href="#">博客</a></li>
  <li>博客列表</li>
</ol>
</div>
<div class = "container">
	<div id = "main-content">
		<%List<User> list = (List<User>)request.getAttribute("blogList");
		if(list != null) {
		for(User user:list) {
		%>
			<a href = <%=user.getTitle()%>  style = "margin-left:10px"><b><%=user.getTitle()%></b></a><br>
			<br>
			<p style = "font-size:10px; color:#A1A1A1; margin-left:25px"><%=user.getSummary()%></p>
			<br>
		<%
		}
		}
		else {
		%>
		<p>列表为空</p>
		<%
		}
		%>
	</div>
<div style = "width:500px; height:70px; margin-left : auto; margin-right : auto; margin-top:auto; margin-foot:auto">
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
   <li><a href="/MyBlogJsp/blog?pageId=1">1 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=2">2 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=3">3 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=4">4 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=5">5 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=6">6 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=7">7 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=8">8 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=9">9 <span class="sr-only">(current)</span></a></li>
    <li><a href="/MyBlogJsp/blog?pageId=10">10 <span class="sr-only">(current)</span></a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    <li>&nbsp
    	<form action = /MyBlogJsp/blog; method = get; style = "display:inline">
    		<input type = "text" style = "width:30px; height:20px" name = "pageId"/>
    		<input type = "submit" style = "width:40px; height:20px; font-size:10px" value = "跳转">
    	</form>
    </li>
  </ul>
  
</nav>
</div>
</div>

<div id = "foot" class = "container-fluid" style = "width : 100%; height:200px; background-color: #84ccee">
底部

</div>
</body>
</html>