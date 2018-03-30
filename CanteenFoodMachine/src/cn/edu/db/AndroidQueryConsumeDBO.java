package cn.edu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.edu.bean.Canteen;
import cn.edu.bean.User;
import cn.edu.utils.DButils;

public class AndroidQueryConsumeDBO {

	public static int query(String mealCardIdStr,
			String startTimeStr, String endTimeStr) {
		try {
			Connection conn = DButils.getDataSource().getConnection();
			int mealCardId = Integer.parseInt(mealCardIdStr);
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			long startTime = 0;
			long endTime = 0;
			startTime = new Long(dateFormat.parse(startTimeStr).getTime());
			endTime = new Long(dateFormat.parse(endTimeStr).getTime());
			String sql = "select sum(consumeMoney) from canteen where mealCardId=? and consumeTime>? and consumeTime<?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, mealCardId);
			st.setLong(2, startTime);
			st.setLong(3, endTime);
			ResultSet rs = st.executeQuery();
			int sum = 0;
			while(rs.next()){
				sum=rs.getInt(1);
			}
			DButils.closeResource(conn, st, rs);
			return sum;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -9999;
	}
	
	public static User queryUserName(String mealCardIdStr) {
		try {
			Connection conn = DButils.getDataSource().getConnection();
			int mealCardId = Integer.parseInt(mealCardIdStr);
			
			String sql = "select * from user where mealCardId=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, mealCardId);
			ResultSet rs = st.executeQuery();
			User u = new User();
			while(rs.next()){
				u.setMealCardId(rs.getInt("mealCardId"));
				u.setUserName(rs.getString("userName"));
				u.setBalence(rs.getFloat("balence"));
			}
			DButils.closeResource(conn, st, rs);
			return u;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
