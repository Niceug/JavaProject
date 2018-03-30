package com.tencent.dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.tencent.utils.DButils;

public class ProjectCountDao {
	//获得全校项目总数
	public static int getProjectCountDB() {
		Connection conn = DButils.getConnection();
		String sql = "select checked_count from checked_count";
		int count = 0;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs =st.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	//查询各个学院的项目申报数量（存储过程）
	public static int getProjectCountByYuanXi(String yuanXiName) {
		Connection conn = DButils.getConnection();
		 String sql="{call CountProc(?,?)}";//调用存储过程的语句，call后面的就是存储过程名和需要传入的参数
		  CallableStatement cst;
		try {
			cst = conn.prepareCall(sql);
			cst.setString(1, yuanXiName);//设置in参数的值
			  cst.registerOutParameter(2, Types.INTEGER);//注册out参数的类型
			  cst.execute();
			  int projectCount = cst.getInt(2);
			  cst.close();
			  conn.close();
			  return projectCount;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	//查询各个学院项目审核的存储过程
	public static int getCheckedCountByYuanXi(String yuanXiName) {
		Connection conn = DButils.getConnection();
		 String sql="{call CountChecked(?,?)}";//调用存储过程的语句，call后面的就是存储过程名和需要传入的参数
		  CallableStatement cst;
		try {
			cst = conn.prepareCall(sql);
			cst.setString(1, yuanXiName);//设置in参数的值
			  cst.registerOutParameter(2, Types.INTEGER);//注册out参数的类型
			  cst.execute();
			  int projectCount = cst.getInt(2);
			  cst.close();
			  conn.close();
			  return projectCount;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String[] args) {
		System.out.println(getCheckedCountByYuanXi("人工智能"));
	}
	
}
