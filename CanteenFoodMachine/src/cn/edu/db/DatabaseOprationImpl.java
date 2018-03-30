package cn.edu.db;

import java.sql.SQLException;
import java.util.List;

import cn.edu.bean.Admin;
import cn.edu.bean.Canteen;
import cn.edu.bean.User;

/**
 * 数据库操作接口
 *
 */
public interface DatabaseOprationImpl {
	
	/**
	 * 管理员登录
	 * @return
	 */
	public Admin queryAdminForLoginFromUsernameAndPwd(String username, String password);
	/**
	 * 查询是否有该用户
	 * @param u
	 * @return
	 */
	public User queryUserInfo(int id);
	
	/**
	 * 更新余额
	 * @param u 用户对象
	 */
	public void updateBalance(User u);
	
	/**
	 * 添加用户
	 * @param u 用户对象
	 */
	public void addUser(User u);
	
	/**
	 * 往数据库中插入消费记录
	 * @param list 消费信息列表
	 * @throws SQLException 
	 */
	public void addToConsumeTable(List<Canteen> list) throws SQLException;
}
