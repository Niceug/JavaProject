package com.tencent.registe;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.tencent.Userbean.User;
import com.tencent.util.MyDBUtils;

public class RegisteDao {

	public static char registeByUserinfo(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(MyDBUtils.getDataSource());
		
		//先查询数据库中是否有这个用户名
		String sqlSelect = "select * from user where username=?";
		User u = qr.query(sqlSelect, new BeanHandler<User>(User.class), username);
		if(u == null) {
			//插入
			String sqlInsert = "insert into user values(?,?)";
			try {
				qr.update(sqlInsert, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
				return 2;//表示其他数据错误
			}
			return 1;//表示注册成功
		} else {
			return 0; //用户名重复注册失败
		}
	}
}
