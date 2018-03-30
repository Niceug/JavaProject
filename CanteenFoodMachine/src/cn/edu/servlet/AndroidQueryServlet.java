package cn.edu.servlet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bean.Canteen;
import cn.edu.bean.User;
import cn.edu.db.AndroidQueryConsumeDBO;

/**
 * Servlet implementation class AndroidQueryServlet
 */
public class AndroidQueryServlet extends HttpServlet {
private static final long serialVersionUID = 314719472293387358L;
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {       //登陆成功标志
        	 String QUERY_FLAG="";     
             //获得客户端提交用户名密码
     String mealCardIdStr = req.getParameter("mealCardId");     
             String startTimeStr = req.getParameter("startTime");     
             String endTimeStr = req.getParameter("endTime");   
             System.out.println(mealCardIdStr);
             System.out.println(startTimeStr);
             System.out.println(endTimeStr);
             //取得消费总额
             int sum = AndroidQueryConsumeDBO.query(mealCardIdStr, startTimeStr, endTimeStr); 
             User u = AndroidQueryConsumeDBO.queryUserName(mealCardIdStr);
             System.out.println(sum);
             try {         
             	DataOutputStream output=new DataOutputStream(resp.getOutputStream());         
             	if (sum != -9999) {              
		                output.writeUTF("查询成功：\n"+"用户名："+u.getUserName()+"\n卡号："+mealCardIdStr+"\n余额："+u.getBalence()+"\n最近消费总额："+sum);
		                output.writeInt(1);
		                output.close(); 
             	}else{               
                 //登录失败  
	                output.writeUTF("查询失败饭卡号不存在");
	                output.close(); 
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
    }
}