package com.tencent.cartservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tencent.cookieutils.CookieUtils;

/**
 * 加入购物车Servlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//传进商品信息
		String waresId = request.getParameter("waresId");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String img = request.getParameter("img");
		if(waresId == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
			return;
		}
		//传进了加入购物车的数量 
		int buyCount = new Integer(request.getParameter("buyCount"));
		Cookie c = CookieUtils.getCookieByName("username", request.getCookies());
		//判断用户是否登录
		if(c != null) {
		//表示用户已经登录，进行添加购物车操作
			Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
			if(map == null) {
				//代表第一次购物，创建购物车
				map = new HashMap<String, Integer>();
				//将当前商品放入购物车
				request.getSession().setAttribute("cart", map);
			} else {
				//购物车不为空，判断购物车中是否有该商品
				Integer iCount = map.get(waresId);
				if(iCount == null) {
					//如果没有该商品
					buyCount = buyCount;
					System.out.println("数量为空");
				} else {
					//如果有该商品
					buyCount = buyCount + iCount;
				}
			}
			//将商品放入购物车
			map.put(waresId, buyCount);
			response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
			System.out.println("已经加入购物车");
		} else {
		//表示用户未登录，则跳转到登录页面
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
