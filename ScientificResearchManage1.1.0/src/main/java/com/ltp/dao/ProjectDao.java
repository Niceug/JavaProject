package com.ltp.dao;

import java.util.List;

import com.ltp.entities.Project;
import com.ltp.mappers.ProjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 对项目的增改查
 */
public class ProjectDao {
	public static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.sqlSessionFactory;

	public static List<Project> queryAllDB() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		List<Project> list = projectMapper.queryAllProject();
		sqlSession.close();
		return list;
	}

	public static List<Project> queryAllCheckedDB() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		List<Project> list = projectMapper.queryCheckedDB();
		sqlSession.close();
		return list;
	}

	public static Project queryCheckedDB(int pNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		Project p = projectMapper.queryCheckedProject(pNo);
		sqlSession.close();
		return p;

	}
	//申报项目
	public static boolean addDB(Project p) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		boolean flag = projectMapper.addProject(p);
		sqlSession.commit();
		sqlSession.close();
		return flag;
	}
	//审核项目
	public static Project queryDB(int pNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		Project p = projectMapper.queryProjectByNo(pNo);
		sqlSession.commit();
		sqlSession.close();
		return p;
	}

	//审核项目
	public static boolean checkDB(Project p) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		boolean flag = projectMapper.checkProject(p);
		sqlSession.commit();
		sqlSession.close();
		return flag;
	}
	//验收项目
	public static void passDB(Project p) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		projectMapper.passProject(p);
		sqlSession.commit();
		sqlSession.close();
	}

	public static List<String> getDepartmentList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		List<String> list = projectMapper.getDepartmentList();
		sqlSession.close();
		return list;
	}
}
