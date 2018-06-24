package com.ltp.dao;

import com.ltp.entities.Admin;
import com.ltp.mappers.AdminMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * 管理员账户的查询
 */
public class AdminDao {

	public static int getAdminFromUsernameAndPwd(String username, String password){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.sqlSessionFactory;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		Admin admin = adminMapper.login(username, password);
		return admin == null ? 0 : 1;
	}

}
