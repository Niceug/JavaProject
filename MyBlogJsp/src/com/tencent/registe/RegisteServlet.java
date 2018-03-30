package com.tencent.registe;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册
 */
public class RegisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//返回注册状态
		char registeState = 0;
		try {
			registeState = RegisteDao.registeByUserinfo(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(registeState == 0) {
			//注册失败，用户名已存在，跳转到注册页面
			//其他的注册失败原因，跳转到注册页面
			response.getWriter().print("<script language='javascript'>alert('注册失败！用户名已存在');window.location.href='"+request.getContextPath()+"/jsp/registe.jsp';</script>");
			//response.sendRedirect(request.getContextPath() + "/jsp/registe.jsp");
			//response.getWriter().print("<script>alert('注册失败！用户名已存在')</script>");
		} else if(registeState == 1) {
			//注册成功
			//写回cookie
			Cookie userC = new Cookie("username", username);
			userC.setMaxAge(600);//设置cookie保存10分钟
			response.addCookie(userC);
			
			//获取跳转过来的页面
			//String url = request.getHeader("referer");
			//跳转到主页面
			response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
		} else if (registeState == 2) {
			//其他的注册失败原因，跳转到注册页面
			response.getWriter().print("<script language='javascript'>alert('注册失败！网络出错');window.location.href='"+request.getContextPath()+"/jsp/registe.jsp';</script>");
			//response.sendRedirect(request.getContextPath() + "/jsp/registe.jsp");
			//response.getWriter().print("<script>windows.alert('注册失败！网络错误')</script>");
		}
		
		
	}
}
