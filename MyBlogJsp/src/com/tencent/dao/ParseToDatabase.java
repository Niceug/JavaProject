package com.tencent.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.tencent.blogservlet.User;
import com.tencent.parse.ParseData;
import com.tencent.util.MyDBUtils;

public class ParseToDatabase {
	public static void main(String [] args) {
		
		QueryRunner qr = new QueryRunner(MyDBUtils.getDataSource());
		
		String insertSql = "insert into parseBlog values(?, ?, ?, ?, ?)";
		
		
			try {
				List<User> list = ParseData.getInfoFromSource("http://www.zuidaima.com/blog/p1.htm", "utf-8");
				for(User u:list) {
					System.out.println(u.getTitle() + "   " + u.getHref() + "\n" + u.getSummary() + "\n" + u.getWriter());
					qr.update(insertSql, null, u.getTitle(), u.getHref(), u.getSummary(), u.getWriter());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
