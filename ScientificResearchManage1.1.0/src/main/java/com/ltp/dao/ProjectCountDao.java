package com.ltp.dao;


import java.util.Map;

import com.ltp.mappers.ProjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProjectCountDao {
	public static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.sqlSessionFactory;

    /**
     * 获得全校项目总数
     * @return
     */
	public static int getProjectCountDB() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		int count = projectMapper.getProjectCountDB();
		sqlSession.close();
        return count;
	}

    /**
     * 查询某个学院的项目申报数量
     * @param department
     * @return
     */
	public static int getProjectCountByDepartment(String department) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        int count = projectMapper.getProjectCountByDepartment(department);
        sqlSession.close();
        return count;
	}

    /**
     * 查询各个学院项目通过审核的数量
     * @return
     */
	public static Map<String, Integer> getCheckedCountByDepartment() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        Map<String, Integer> map =  projectMapper.getCheckedCountByDepartment();
        sqlSession.close();
        return map;
	}
}

