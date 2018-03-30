package com.tencent.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.tencent.parse.ParseWares;
import com.tencent.util.MyDBUtils;
import com.tencent.waresbean.WaresBean;

public class WaresToDatabase {
	public static void waresInfoToDatabase() throws SQLException{
		QueryRunner qr = new QueryRunner(MyDBUtils.getDataSource());
		String insertSql = "insert into store values(?, ?, ?, ?, ?, ?)";
		List<WaresBean> list = null;
		try {
			list = ParseWares.getInfoFromSource("http://www.zol.com/index.php?c=List&keyword=%B1%CA%BC%C7%B1%BE&spm=1865.45638", "gbk");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (WaresBean waresBean : list) {
			System.out.println(waresBean.getTitle()+"\n"+waresBean.getPrice()+"\n"+waresBean.getCount()+"\n"+waresBean.getDescription()+"\n"+waresBean.getImg());
			qr.update(insertSql, waresBean.getWaresId(), waresBean.getTitle(), waresBean.getPrice(), waresBean.getCount(), waresBean.getDescription(), waresBean.getImg());
		}
		
	}
	public static void main(String[] args) {
		try {
			waresInfoToDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
