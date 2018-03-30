package com.tencent.storeservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tencent.waresbean.WaresBean;

/**
 * 商城servlet,从数据库查询商品信息，然后显示商品列表
 */
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			List<WaresBean> list = (List<WaresBean>)StoreService.getWaresList();
//			for (WaresBean waresBean : list) {
//				System.out.println(waresBean.getWaresId());
//				System.out.println(waresBean.getTitle());
//				System.out.println(waresBean.getPrice());
//				System.out.println(waresBean.getCount());
//				System.out.println(waresBean.getDescription());
//				System.out.println(waresBean.getImg());
//			}
			request.setAttribute("waresList", list);
			request.getRequestDispatcher("/jsp/store.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
