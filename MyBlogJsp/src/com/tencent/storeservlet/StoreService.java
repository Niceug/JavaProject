package com.tencent.storeservlet;

import java.sql.SQLException;
import java.util.List;

import com.tencent.waresbean.WaresBean;

public class StoreService {

	public static List<WaresBean> getWaresList() throws SQLException {
		return StoreDao.getWaresList();
	}

}
