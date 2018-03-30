package com.tencent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tencent.utils.DButils;

/**
 * 管理员账户的查询
 */
public class AdminDao {

	public static int getAdminFromUsernameAndPwd(String username, String password){
		Connection conn = DButils.getConnection();
		String querySql = "select * from administrator where username =? and password =?";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(querySql);
			st.setString(1, username);
			st.setString(2, password);
			rs = st.executeQuery();
			System.out.println(rs.next());
			if(rs.next()) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DButils.closeResource(conn, st, rs);
		}
		
	}

}
