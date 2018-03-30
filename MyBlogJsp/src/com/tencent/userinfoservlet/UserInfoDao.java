package com.tencent.userinfoservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tencent.util.MyDBUtils;

public class UserInfoDao {

	public static List<String>getUserBlogsFromName(String username) throws SQLException {
		Connection conn =  MyDBUtils.getDataSource().getConnection();
		String querySql = "select * from parseBlog where writer='" + username + "'";
		PreparedStatement ps = conn.prepareStatement(querySql);
		ResultSet rs = ps.executeQuery();
		List<String> list = new ArrayList<String>();
		while(rs.next()) {
			String href = rs.getString("href");
			String title = rs.getString("title");
			String str = href + "<@>" + title;
			list.add(str);
		}
		return list;
	}

}
