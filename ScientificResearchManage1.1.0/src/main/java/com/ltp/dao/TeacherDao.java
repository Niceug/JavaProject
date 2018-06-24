package com.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ltp.entities.Teacher;
import com.ltp.mappers.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 *对教师的增删改查
 */
public class TeacherDao {
	public static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.sqlSessionFactory;
	//添加教师信息
	public static boolean addDB(Teacher t) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		teacherMapper.addTeacher(t);
		sqlSession.commit();
		sqlSession.close();
		return true;
	}

	//删除教师信息
	public static boolean deleteDB(int teacherNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		teacherMapper.deleteTeacher(teacherNo);
		sqlSession.commit();
		sqlSession.close();
		return true;

	}


	//修改教师信息
	public static boolean updateDB(Teacher t) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		teacherMapper.updateTeacher(t);
		sqlSession.commit();
		sqlSession.close();
		return true;
	}

	//查询教师信息
	public static Teacher queryDB(int teacherNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher t = teacherMapper.queryTeacher(teacherNo);
		sqlSession.commit();
		sqlSession.close();
		return t;
	}

}
