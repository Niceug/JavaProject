<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 加载导航栏 -->
<jsp:include page="/jsp/nav.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/MyBlogJsp/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/MyBlogJsp/ueditor/ueditor.all.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class = "container">
		<div class = "UserInfo" style = "width:100%; height:50px">用户头像，个人主页链接，ltp博客</div>
		<form action = "#" method = "post">
			<div class = "artic-title" style = "width:60%; height:80px">
				<p>文章标题</p>
				<hr>
				<select>
					<option>请选择</option>
					<option>原创</option>
					<option>转载</option>
					<option>翻译</option>
				</select>
				<input type = "text" name = "article-title" size = "80" maxlenth="80"/>
			</div>
			<br>
			文章内容
			<hr>
			<div class = "editer">
				<textarea name="article-content" id="myEditor" style = "width:1000px; height:500px;">这里写你的初始化内容</textarea>
				<script type="text/javascript">
					//var editor = new UE.ui.Editor();
					//editor.render("myEditor");
					//1.2.4以后可以使用一下代码实例化编辑器
					UEDITOR_CONFIG.UEDITOR_HOME_URL = '/MyBlogJsp/ueditor/';
					UE.getEditor('myEditor');
				</script>
			</div>
			<br>
			<div div class = "article-img">
				上传图片
				<hr>
				<input type = "file" name = "image" value = "选择文件"/>
			</div>
			<br>
			<div class = "catilog">
			文章分类：
				java<input type = "checkbox">
				C++<input type = "checkbox">
				C语言<input type = "checkbox">
				Python<input type = "checkbox">
				PHP<input type = "checkbox">
			</div>
			<br>
			<div><input type = "submit" value = "提交"/></div>
		</form>
		<div class = "foot" style = "height:100px"></div>
</div>
</body>
</html>