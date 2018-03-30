package com.tencent.wareservlet;

import java.sql.SQLException;

import com.tencent.waresbean.WaresBean;

public class WareService {

	public static WaresBean getWareById(String wareId) throws SQLException {
		return WaresDao.getWareById(wareId);
	}

}
