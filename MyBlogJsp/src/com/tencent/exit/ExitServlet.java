package com.tencent.exit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tencent.cookieutils.CookieUtils;

/**
 * 用户退出登录
 */
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c  = CookieUtils.getCookieByName("username", request.getCookies());
		//删除cookie
		c.setMaxAge(0);
		//获取跳转到来的页面
		response.addCookie(c);
		String url = request.getHeader("referer");
		//跳转
		response.sendRedirect(url);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
