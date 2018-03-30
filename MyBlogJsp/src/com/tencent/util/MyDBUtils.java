package com.tencent.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDBUtils {
	
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	public static ComboPooledDataSource getDataSource() {
		return cpds;
	}
	
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConnection(conn);
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
	}
	public static void closeStatement(Statement st) {
		if(st != null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				st = null;
			}
	}
	public static void closeConnection(Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
	}
	

}
