package cn.edu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.utils.DButils;

public class RechargeByMealCardIdAndSumDBO {
	public static int RechargeByMealCardIdAndSum(int mealCardId, float sum){
		try{
		Connection conn = DButils.getDataSource().getConnection();
		String sql = "update user set balence=balence+? where mealCardId=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setFloat(1, sum);
		st.setInt(2, mealCardId);
		int u = st.executeUpdate();
			System.out.println(u);
			DButils.closeResource(conn, st, null);
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
