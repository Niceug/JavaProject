package com.tencent.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作工具类
 */
public class DButils {
	  //SQL Server的驱动名
	  //private static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String driverName="com.mysql.jdbc.Driver";
	  //SQLServer：jdbc:sqlserver://主机名:端口:DatabaseName=库名
	  //private static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=projectManage";
	private static String dbURL="jdbc:mysql://localhost:3306/projectManage";
	  
	  /*数据库用户名和密码，必须是SQLServer身份验证登录*/
//	  private static  String userName="sa";
//	  private static String userPwd="123456";
	
	  private static  String userName="root";
	  private static String userPwd="123456";
	static{
	  try
	  {
		//加载驱动
	   Class.forName(driverName);
	  } catch (Exception e) {
		  System.out.println("数据库驱动加载失败");
	  } 
	   //数据库连接
	}
	public static Connection getConnection() {
		Connection dbConn = null;
		try {
			dbConn = DriverManager.getConnection(DButils.dbURL,DButils.userName,DButils.userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return dbConn;
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
