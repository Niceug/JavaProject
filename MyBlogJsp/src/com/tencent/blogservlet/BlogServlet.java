package com.tencent.blogservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author Z7M-SL7D2
 *
 */
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		UserService us = new UserService();
		//页面号
		int pageId = new Integer(request.getParameter("pageId"));
		try {
			List<User> list = us.getUserList(pageId - 1);
			request.setAttribute("blogList", list);
			request.getRequestDispatcher("/jsp/blog.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

