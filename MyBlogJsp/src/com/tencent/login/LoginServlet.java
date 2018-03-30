package com.tencent.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tencent.Userbean.User;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService us = new UserService();
		User user = null;
		try {
			user = us.getUserByUserNameAndPwd(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user == null) {
			response.getWriter().print("<script language='javascript'>alert('用户名或密码不存在！');window.location.href='"+request.getContextPath()+"/jsp/login.jsp';</script>");
			//response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			//response.getWriter().print("<script language='javascript'>alert(用户名或密码不存在!)</script>");
		} else {
			Cookie c = new Cookie("username",user.getUsername());
			
			//设置cookie一个小时过期
			c.setMaxAge(3600);
			response.addCookie(c);
			response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
		}
	}
}
