package com.tencent.login;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tencent.Userbean.User;
import com.tencent.util.MyDBUtils;

public class UserDao {

	public User getUserByUserNameAndPwd(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(MyDBUtils.getDataSource());
		
		String querySql = "select * from user where username = ? and password = ?";
		
		User user = qr.query(querySql, new BeanHandler<User>(User.class), username, password);
		
		return user;
	}

}
