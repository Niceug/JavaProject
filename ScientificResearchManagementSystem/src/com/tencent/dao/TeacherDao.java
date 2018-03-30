package com.tencent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tencent.bean.Teacher;
import com.tencent.utils.DButils;

/**
 * 
 *对教师的增删改查
 */
public class TeacherDao {
	
	//添加教师信息
	public static boolean addDB(Teacher t) {
		Connection conn = DButils.getConnection();
		String insertSql = "insert into teacher values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = conn.prepareStatement(insertSql);
			st.setInt(1, t.getTeacherNo());
			st.setString(2, t.getTeacherName());
			st.setString(3, t.getSex());
			st.setString(4, t.getZhiWu());
			st.setString(5, t.getZhiCheng());
			st.setString(6, t.getBuMen());
			st.setString(7, t.getYuanXi());
			st.setString(8, t.getTel());
			st.setString(9, t.getLocation());
			st.executeUpdate();
			DButils.closeResource(conn, st, null);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	//删除教师信息
	public static boolean deleteDB(int tNo) {
		Connection conn = DButils.getConnection();
		String deleteSql = "delete from teacher where TeacherNo=?";
		try {
			PreparedStatement st = conn.prepareStatement(deleteSql);
			st.setInt(1, tNo);
			st.executeUpdate();
			DButils.closeResource(conn, st, null);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	//修改教师信息
	public static boolean updateDB(Teacher t) {
		Connection conn = DButils.getConnection();
		String updateSql = "update teacher set TeacherName =?, Sex=?, ZhiWu=?, ZhiCheng=?, BuMen=?, YuanXi=?, Tel=?, Location=? where TeacherNo=?";
		try {
			PreparedStatement st = conn.prepareStatement(updateSql);
			
			st.setString(1, t.getTeacherName());
			st.setString(2, t.getSex());
			st.setString(3, t.getZhiWu());
			st.setString(4, t.getZhiCheng());
			st.setString(5, t.getBuMen());
			st.setString(6, t.getYuanXi());
			st.setString(7, t.getTel());
			st.setString(8, t.getLocation());
			st.setInt(9, t.getTeacherNo());
			st.executeUpdate();
			DButils.closeResource(conn, st, null);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	//查询教师信息
	public static Teacher queryDB(int tNo) {
		Connection conn = DButils.getConnection();
		String querySql = "select * from teacher where TeacherNo=?";
		Teacher t = null;
		try {
			PreparedStatement st = conn.prepareStatement(querySql);
			st.setInt(1, tNo);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String tName = rs.getString("TeacherName");
				String tSex = rs.getString("Sex");
				String tZhiWu = rs.getString("ZhiWu");
				String tZhiCheng = rs.getString("ZhiCheng");
				String tBuMen = rs.getString("BuMen");
				String tYuanXi = rs.getString("YuanXi");
				String tTel = rs.getString("Tel");
				String tLocation = rs.getString("Location");
				t = new Teacher(tNo, tName, tSex, tZhiWu, tZhiCheng, tBuMen, tYuanXi, tTel, tLocation);
			}
			DButils.closeResource(conn, st, rs);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
