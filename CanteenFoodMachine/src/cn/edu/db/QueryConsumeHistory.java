package cn.edu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.bean.Canteen;
import cn.edu.utils.DButils;

public class QueryConsumeHistory {
	public static List<Canteen> queryConsumeHistoryByTimeAndCanteen(long startTime, long endTime){
		
		try {
		Connection conn = DButils.getDataSource().getConnection();
		String sql = "select * from Canteen where consumeTime>? and consumeTime<?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setLong(1, startTime);
		st.setLong(2, endTime);
		ResultSet rs = st.executeQuery();
		Canteen c = null;
		List<Canteen> list = new ArrayList<Canteen>();
		while(rs.next()){
			c = new Canteen();
			c.setMealCardId(rs.getInt("mealCardId"));
			c.setCanteenId(rs.getInt("canteenId"));
			c.setDeviceId(rs.getInt("deviceId"));
			c.setConsumeMoney(rs.getFloat("consumeMoney"));
			c.setConsumeTime(rs.getLong("consumeTime"));
			list.add(c);
		}
		DButils.closeResource(conn, st, rs);
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		}
}
