package com.ltp.sqlconnection;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;

public class SqlOpenAndOprea extends HttpServlet{
	/**
	 * @prama DriverName 驱动名
	 * @prama userName 用户名
	 * @prama userPassword 密码名
	 * @prama DbName 数据库名称
	 * */
	public Connection connecteToDatabase(String DriveName, String userName, String userPassword, String DbName) throws Exception{
		 String url="jdbc:mysql://localhost/"+DbName+"?useUnicode=true&characterEncoding=UTF-8&user="+userName+"&password="+userPassword;
		 Class.forName(DriveName).newInstance();
		 Connection connection=DriverManager.getConnection(url);
		 return connection;
	}
}

