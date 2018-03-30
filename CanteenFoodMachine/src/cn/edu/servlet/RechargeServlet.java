package cn.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.db.RechargeByMealCardIdAndSumDBO;

/**
 * 充值servlet
 * Servlet implementation class RechargeServlet
 */
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//充值卡号
		String chargeMealCardId = request.getParameter("n_mealCardId");
		//充值金额
		String chargeSum = request.getParameter("n_sum");
		int balence = RechargeByMealCardIdAndSumDBO.RechargeByMealCardIdAndSum(new Integer(chargeMealCardId), new Float(chargeSum));
		if(balence == 1){
			System.out.println("本次充值金额为 "+chargeSum+" 充值成功!");
		}else{
			System.out.println("充值失败！");
		}
	
	}

}
