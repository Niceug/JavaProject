package com.tencent.blogservlet;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tencent.util.MyDBUtils;

public class UserDao {

	public List<User> getUserList(int pageId) throws SQLException {
		Connection conn = MyDBUtils.getDataSource().getConnection();
		String querySql = "select * from parseBlog limit " + pageId*12 + ", 12";
		PreparedStatement st = conn.prepareStatement(querySql);
		ResultSet rs = st.executeQuery();
		User user = null;
		List <User> list = new ArrayList<User>();
		while(rs.next()) {
			String title = rs.getString("title");
			String href = rs.getString("href");
			String summary = rs.getString("summary");
			user = new User();
			user.setTitle(title);
			user.setHref(href);
			user.setSummary(summary);
			list.add(user);
		}
		MyDBUtils.closeResource(conn, st, rs);
		return list;
	}
}
