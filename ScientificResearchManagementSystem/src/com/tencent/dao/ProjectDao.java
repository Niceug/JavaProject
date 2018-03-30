package com.tencent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tencent.bean.Project;
import com.tencent.utils.DButils;

/**
 * 对项目的增该查
 */
public class ProjectDao {
	public static List<Project> queryAllDB() {
		Connection conn = DButils.getConnection();
		String querySql = "select * from project";
		List<Project> projectList = new ArrayList<Project>();
		try {
			Project p;
			PreparedStatement st = conn.prepareStatement(querySql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String proNo = rs.getString("ProNo");
				String proName = rs.getString("ProName");
				String teacherNo = rs.getString("TeacherNo");
				String teacherName = rs.getString("TeacherName");
				String yuanXi = rs.getString("YuanXi");
				String proType = rs.getString("ProType");
				String proForm = rs.getString("ProForm");
				String proTime = rs.getString("ProTime");
				String proText = rs.getString("ProText");
				String memo = rs.getString("Memo");
				String checking = rs.getString("Checking");
				String pass = rs.getString("Pass");
				p = new Project(new Integer(proNo), proName, new Integer(teacherNo), teacherName, yuanXi, proType,
						proForm, new Long(proTime), proText, memo, checking, pass);
				projectList.add(p);
			}
			DButils.closeResource(conn, st, rs);
			return projectList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Project> queryCheckedDB() {
		Connection conn = DButils.getConnection();
		String querySql = "select * from project where Checking=?";
		List<Project> projectList = new ArrayList<Project>();
		try {
			Project p;
			PreparedStatement st = conn.prepareStatement(querySql);
			st.setString(1, "是");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String proNo = rs.getString("ProNo");
				String proName = rs.getString("ProName");
				String teacherNo = rs.getString("TeacherNo");
				String teacherName = rs.getString("TeacherName");
				String yuanXi = rs.getString("YuanXi");
				String proType = rs.getString("ProType");
				String proForm = rs.getString("ProForm");
				String proTime = rs.getString("ProTime");
				String proText = rs.getString("ProText");
				String memo = rs.getString("Memo");
				String checking = rs.getString("Checking");
				String pass = rs.getString("Pass");
				p = new Project(new Integer(proNo), proName, new Integer(teacherNo), teacherName, yuanXi, proType,
						proForm, new Long(proTime), proText, memo, checking, pass);
				projectList.add(p);
			}
			DButils.closeResource(conn, st, rs);
			return projectList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//申报项目
	public static boolean addDB(Project p) {
		Connection conn = DButils.getConnection();
		String insertSql = "insert into project values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = conn.prepareStatement(insertSql);
			st.setInt(1, p.getProNo());
			st.setString(2, p.getProName());
			st.setInt(3, p.getTeacherNo());
			st.setString(4, p.getTeacherName());
			st.setString(5, p.getYuanXi());
			st.setString(6, p.getProType());
			st.setString(7, p.getProForm());
			st.setLong(8, p.getProTime());
			st.setString(9, p.getProText());
			st.setString(10, p.getMemo());
			st.setString(11, p.getChecking());
			st.setString(12, p.getPass());
			st.executeUpdate();
			DButils.closeResource(conn, st, null);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	//审核项目
	public static Project queryDB(int pNo) {
		Connection conn = DButils.getConnection();
		String querySql = "select * from project where ProNo=? and Checking <>是";
		Project p = null;
		try {
			PreparedStatement st = conn.prepareStatement(querySql);
			st.setInt(1, pNo);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String proName = rs.getString("ProName");
				String teacherNo = rs.getString("TeacherNo");
				String teacherName = rs.getString("TeacherName");
				String yuanXi = rs.getString("YuanXi");
				String proType = rs.getString("ProType");
				String proForm = rs.getString("ProForm");
				String proTime = rs.getString("ProTime");
				String proText = rs.getString("ProText");
				String memo = rs.getString("Memo");
				String checking = rs.getString("Checking");
				String pass = rs.getString("Pass");
				p = new Project(pNo, proName, new Integer(teacherNo), teacherName, yuanXi, proType, proForm, new Long(proTime), proText, memo, checking, pass);
			}
			DButils.closeResource(conn, st, rs);
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Project queryCheckingDB(int pNo) {
		Connection conn = DButils.getConnection();
		String querySql = "select * from project where ProNo=?";
		Project p = null;
		try {
			PreparedStatement st = conn.prepareStatement(querySql);
			st.setInt(1, pNo);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String proName = rs.getString("ProName");
				String teacherNo = rs.getString("TeacherNo");
				String teacherName = rs.getString("TeacherName");
				String yuanXi = rs.getString("YuanXi");
				String proType = rs.getString("ProType");
				String proForm = rs.getString("ProForm");
				String proTime = rs.getString("ProTime");
				String proText = rs.getString("ProText");
				String memo = rs.getString("Memo");
				String checking = rs.getString("Checking");
				String pass = rs.getString("Pass");
				p = new Project(pNo, proName, new Integer(teacherNo), teacherName, yuanXi, proType, proForm, new Long(proTime), proText, memo, checking, pass);
			}
			DButils.closeResource(conn, st, rs);
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//审核项目
		public static Project queryCheckedDB(int pNo) {
			Connection conn = DButils.getConnection();
			String querySql = "select * from project where ProNo=? and Checking='是'";
			Project p = null;
			try {
				PreparedStatement st = conn.prepareStatement(querySql);
				st.setInt(1, pNo);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					String proName = rs.getString("ProName");
					String teacherNo = rs.getString("TeacherNo");
					String teacherName = rs.getString("TeacherName");
					String yuanXi = rs.getString("YuanXi");
					String proType = rs.getString("ProType");
					String proForm = rs.getString("ProForm");
					String proTime = rs.getString("ProTime");
					String proText = rs.getString("ProText");
					String memo = rs.getString("Memo");
					String checking = rs.getString("Checking");
					String pass = rs.getString("Pass");
					p = new Project(pNo, proName, new Integer(teacherNo), teacherName, yuanXi, proType, proForm, new Long(proTime), proText, memo, checking, pass);
				}
				DButils.closeResource(conn, st, rs);
				return p;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
		}
	//审核项目
	public static boolean checkDB(Project p) {
		Connection conn = DButils.getConnection();
		String updateSql = "update project set ProName=?, TeacherNo=?"
				+ ", TeacherName=?, YuanXi=?,ProType=?,ProForm=?, ProTime=?, ProText=?,"
				+ "Memo=?, Checking=? where ProNo=?";
		try {
			PreparedStatement st = conn.prepareStatement(updateSql);
			st.setString(1, p.getProName());
			st.setInt(2, p.getTeacherNo());
			st.setString(3, p.getTeacherName());
			st.setString(4, p.getYuanXi());
			st.setString(5, p.getProType());
			st.setString(6, p.getProForm());
			st.setLong(7, p.getProTime());
			st.setString(8, p.getProText());
			st.setString(9, p.getMemo());
			st.setString(10, p.getChecking());
			st.setInt(11, p.getProNo());
			st.executeUpdate();
			DButils.closeResource(conn, st, null);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	//验收项目
	public static void passDB(Project p) {
		Connection conn = DButils.getConnection();
		String updateSql = "update project set Pass=? where ProNo=?";
		try {
			PreparedStatement st = conn.prepareStatement(updateSql);
			st.setString(1, p.getPass());
			st.setInt(2, p.getProNo());
			st.executeUpdate();
			DButils.closeResource(conn, st, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getYuanXiNameList() {
		List<String> list = new ArrayList<String>();
		Connection conn = DButils.getConnection();
		String sql = "select YuanXi as count from project group by YuanXi";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
