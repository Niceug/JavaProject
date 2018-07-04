package com.bittech.mybatis;

import com.bittech.mybatis.entity.MemoGroup;
import com.bittech.mybatis.mapper.MemoGroupMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
public class MemoGroupMapperTest {
    
    public static SqlSessionFactory sqlSessionFactory;
    
    @BeforeClass
    public static void setBefore() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new
                SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(
                    Resources.getResourceAsStream("mybatis-config.xml")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @AfterClass
    public static void setAfter() {
        sqlSessionFactory = null;
    }
    
    
    @Test
    public void testQueryAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        List<MemoGroup> memoGroupList = memoGroupMapper.queryAll("name");
        sqlSession.close();
        System.out.println(memoGroupList);
    }
    
    
    @Test
    public void testInsetMemoGroup() {
        MemoGroup memoGroup = new MemoGroup();
        memoGroup.setName("New-X");
        memoGroup.setCreatedTime(new Date());
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        memoGroupMapper.insetMemoGroup(memoGroup);
        System.out.println(memoGroup);
        memoGroup = memoGroupMapper.queryById(memoGroup.getId());
        System.out.println(memoGroup);
        sqlSession.close();
    }
    
    
    @Test
    public void testUpdateMemoGroup() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        int effect = memoGroupMapper.updateMemoGroup(6, "JDBC4");
        sqlSession.commit();
        sqlSession.close();
        Assert.assertEquals(1, effect);
    }
    
    @Test
    public void testDeleteMemoGroup() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        int effect = memoGroupMapper.deleteMemoGroup(8);
        sqlSession.commit();
        sqlSession.close();
        Assert.assertEquals(1, effect);
    }
    
    @Test
    public void test_queryById() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        MemoGroup memoGroup = memoGroupMapper.queryById(1);
        System.out.println(memoGroup);
    }
    
    @Test
    public void test_queryByIdWithHashMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        HashMap memoGroup = memoGroupMapper.queryByIdWithHashMap(1);
        System.out.println(memoGroup);
    }
    
    @Test
    public void test_queryByIdWithResultType() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        MemoGroup memoGroup = memoGroupMapper.queryByIdWithResultType(1);
        System.out.println(memoGroup);
        
        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession(true);
        memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        memoGroup = memoGroupMapper.queryByIdWithResultType(1);
        System.out.println(memoGroup);
        
    }


}
