package cn.edu.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bean.Canteen;
import cn.edu.db.QueryConsumeHistory;

/**
 * Servlet implementation class QueryConsumeServlet
 */
public class QueryConsumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String startTimeStr = request.getParameter("startTime");
		String  endTimeStr = request.getParameter("endTime");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		long startTime = 0;
		long endTime = 0;
		try {
			startTime = new Long(dateFormat.parse(startTimeStr).getTime());
			endTime = new Long(dateFormat.parse(endTimeStr).getTime());
		
			List<Canteen> list = new ArrayList<Canteen>();
			list = QueryConsumeHistory.queryConsumeHistoryByTimeAndCanteen(startTime, endTime);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/showConsumeHistory.jsp").forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
