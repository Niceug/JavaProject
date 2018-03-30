package cn.edu.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.bean.Admin;
import cn.edu.bean.Canteen;
import cn.edu.bean.User;
import cn.edu.utils.DButils;

/**
 * 数据库操作实现类
 *
 */
public class DatabaseOpration implements DatabaseOprationImpl{
	@Override
	public Admin queryAdminForLoginFromUsernameAndPwd(String username, String password) {
		QueryRunner qr = new QueryRunner(DButils.getDataSource());
		String sql = "select * from Admin where username=? and password=?";
		try {
			Admin a = qr.query(sql, new BeanHandler<Admin>(Admin.class), username, password);
			return a;
		} catch (SQLException e) {
			System.out.println("查询管理员语句出错");
			return null;
		}
	}
	
	@Override
	public User queryUserInfo(int id){
		QueryRunner qr = new QueryRunner(DButils.getDataSource());
		String sql = "select * from User where mealCardId=?";
		try {
			User u = qr.query(sql, new BeanHandler<User>(User.class), id);
			return u;
		} catch (SQLException e) {
			System.out.println("查询语句出错");
			return null;
		}
	}

	@Override
	public void updateBalance(User u) {
		QueryRunner qr = new QueryRunner(DButils.getDataSource());
		String sql = "update from User set balence=? where mealCardId=?";
		User user = null;
		try {
			qr.update(sql, u.getBalence(), u.getMealCardId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User u) {
		QueryRunner qr = new QueryRunner(DButils.getDataSource());
		String sql = "insert into User values(?, ?, ?)";
		try {
			qr.update(sql, u.getMealCardId(), u.getUserName(), u.getBalence());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void addToConsumeTable(List<Canteen> list) throws SQLException {
		QueryRunner qr = new QueryRunner(DButils.getDataSource());
		String sql = "insert into Canteen values(?, ?, ?, ?, ?)";
		for(Canteen c : list){
			qr.update(sql, c.getMealCardId(), c.getCanteenId(), c.getDeviceId(), c.getConsumeMoney(), c.getConsumeTime());
		}
	}
}
