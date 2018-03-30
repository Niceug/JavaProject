package com.tencent.storeservlet;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tencent.util.MyDBUtils;
import com.tencent.waresbean.WaresBean;

public class StoreDao {

	public static List<WaresBean> getWaresList() throws SQLException {
		QueryRunner qr = new QueryRunner(MyDBUtils.getDataSource());
		String querySql = "select * from store";
		return qr.query(querySql, new BeanListHandler<WaresBean>(WaresBean.class));
	}

}
