package com.tencent.wareservlet;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.tencent.util.MyDBUtils;
import com.tencent.waresbean.WaresBean;

public class WaresDao {

	public static WaresBean getWareById(String wareId) throws SQLException {
		QueryRunner qr = new QueryRunner(MyDBUtils.getDataSource());
		String querySql = "select * from store where waresId=?";
		WaresBean w = qr.query(querySql, new BeanHandler<WaresBean>(WaresBean.class), wareId);
		return w;
	}

}
