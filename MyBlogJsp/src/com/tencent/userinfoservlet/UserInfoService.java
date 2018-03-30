package com.tencent.userinfoservlet;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserInfoService {

	public static List<String> getUserBlogsFromName(String username) throws SQLException {
		// TODO Auto-generated method stub
		return UserInfoDao.getUserBlogsFromName(username);
	}
}
