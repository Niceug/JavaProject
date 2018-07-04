package com.bittech.mybatis;

import com.bittech.mybatis.common.Page;
import com.bittech.mybatis.entity.MemoInfo;
import com.bittech.mybatis.mapper.MemoInfoMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
public class MemoInfoMapperTest {
    
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
    public void test_queryByPage() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<MemoInfo> memoInfoList = memoInfoMapper.queryByPage(2, 0, "created_time");
        for (MemoInfo memoInfo : memoInfoList) {
            System.out.println(memoInfo);
        }
        sqlSession.close();
    }
    
    @Test
    public void test_queryByPageWithObject() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        Page page = new Page();
        page.setPageSize(2);
        page.setPageNumber(1);
        page.setOrderColumnName("created_time");
        List<MemoInfo> memoInfoList = memoInfoMapper.queryByPageWithObject(page);
        for (MemoInfo memoInfo : memoInfoList) {
            System.out.println(memoInfo);
        }
        sqlSession.close();
    }

//    public void test_query
    
    @Test
    public void test_updateMemoInfo() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setId(2);
        memoInfo.setTitle("NJDBC");
        memoInfo.setPrivacy('1');
        int effect = memoInfoMapper.updateMemoInfo(memoInfo);
        sqlSession.close();
        Assert.assertEquals(1, effect);
    }
    
    @Test
    public void test_insertMemoInfo() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setTitle("Mapper");
        memoInfo.setGroupId(1);
        memoInfo.setContent("Mapper in action");
        memoInfo.setCreatedTime(new Date());
        int effect = memoInfoMapper.insertMemoInfo(memoInfo);
        sqlSession.close();
        Assert.assertEquals(1, effect);
        System.out.println(memoInfo);
//        memoInfoMapper.queryMemoInfoById(memoInfo.getId());
    }
    
    @Test
    public void test_queryMemoInfoById() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = memoInfoMapper.queryMemoInfoById(6);
        sqlSession.close();
        System.out.println(memoInfo);
    }
    
    @Test
    public void test_deleteMemoInfoById() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        int effect = memoInfoMapper.deleteMemoInfoById(6);
        sqlSession.close();
        Assert.assertEquals(1, effect);
    }
    
    @Test
    public void test_queryMemoInfoByGroupId() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<MemoInfo> memoInfos = memoInfoMapper.queryMemoInfoByGroupId(1);
        sqlSession.close();
        Assert.assertEquals(4, memoInfos.size());
        for (MemoInfo memoInfo : memoInfos) {
            System.out.println(memoInfo);
        }
    }

    @Test
    public void test_queryMemoInfoByTitleAndContentAndCreatedTime() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        PageHelper.startPage(1, 3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = null;
        try {
            date = simpleDateFormat.parse("2018-06-30 16:09:20");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<MemoInfo> list =
                memoInfoMapper.queryMemoInfoByTitleAndContentAndCreatedTime(
                        null, null, date
                );
        for(MemoInfo memoInfo : list) {
            System.out.println(memoInfo);
        }
    }

    @Test
    public void test_updateMemoInfoByMemo() {

    }

    @Test
    public void test_queryMemoInfoByPrivacy() {

    }

    @Test
    public void test_queryMemoInfoFromIds() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        for(int j = 0; j < 6; ++j) {
            PageHelper.startPage(j, 3);
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < 20; ++i) {
                list.add(i);
            }

            List<MemoInfo> memoInfoList = memoInfoMapper.queryMemoInfoFromIds(list);
            for (MemoInfo memoInfo : memoInfoList) {
                System.out.println(memoInfo);
            }

            System.out.println("下一页");
        }

    }
}
