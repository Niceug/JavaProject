package com.tencent.login;

import java.sql.SQLException;

import com.tencent.Userbean.User;

public class UserService {

	public User getUserByUserNameAndPwd(String username, String password) throws SQLException {
		UserDao du = new UserDao();
		return du.getUserByUserNameAndPwd(username, password);
	}

}
