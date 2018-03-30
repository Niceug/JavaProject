package cn.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bean.Admin;
import cn.edu.db.DatabaseOpration;
import cn.edu.utils.CookieUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DatabaseOpration dbo = new DatabaseOpration();
		Admin a = dbo.queryAdminForLoginFromUsernameAndPwd(username, password);
		if(a != null) {
			
			//设置cookie
			Cookie c = new Cookie("username",a.getUsername());
			
			//设置cookie过期时间
			c.setMaxAge(3600);
			response.addCookie(c);
			//跳转到主页
			response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
		}else{
			response.sendRedirect(request.getContextPath() + "/login.html");
			response.getWriter().print("<script>alert('密码错误,或用户名不存在')</script>");
		}
	}

}
