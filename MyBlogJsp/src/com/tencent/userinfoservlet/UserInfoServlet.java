package com.tencent.userinfoservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户个人信息
 */
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取传过来的用户名
		String username = request.getParameter("username");
		//根据用户名查询用户信息
		System.out.println(username);
		//返回用户博客列表
		try {
			List<String> list = UserInfoService.getUserBlogsFromName(username);
			if(list == null) {
				System.out.println("空");
			}
			 request.setAttribute("blogList", list);
			 request.getRequestDispatcher("/jsp/userInfo.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
