package com.tencent.blogservlet;

import java.util.List;

public class UserService {

	public List<User> getUserList(int pageId) throws Exception {
		UserDao ud = new UserDao();
		return ud.getUserList(pageId);
	}
}
