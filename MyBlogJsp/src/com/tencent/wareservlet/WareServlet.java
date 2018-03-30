package com.tencent.wareservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tencent.waresbean.WaresBean;

/**
 * 商品详情页面
 */
public class WareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	//获取传过来的ID
	String wareId = request.getParameter("wareId");
	try {
		WaresBean w = WareService.getWareById(wareId);
		if(w != null) {
			request.setAttribute("ware", w);
			request.getRequestDispatcher("/jsp/ware.jsp").forward(request, response);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
