package com.bittech.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
public class MybatisApplication {
    
    private final static Logger logger = LoggerFactory
            .getLogger(MybatisApplication.class);
    
    public static SqlSessionFactory sqlSessionFactory;
    
    //SqlSessionFactoryBuilder  : 为了创建一个SqlSessionFactory
    //SqlSessionFactory ： 一个应用程序，只需要一个就可以了
    //SqlSession：使用SQL操作的时候，创建一个SqlSession
    
    
    public static void buildWithXML() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new
                SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(
                    Resources.getResourceAsStream("mybatis-config.xml")
            );
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                //使用命令的名称 = 名命空间+"."+命令Id
//        List<MemoGroup> memoGroupList=   sqlSession.selectList("com.bittech.mybatis.mapper.MemoGroupMapper.queryAll");
//            System.out.println(memoGroupList);
          
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void buildWithJava() {
        Configuration configuration = new Configuration();
        String id = "dev";
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        DataSource dataSource = new PooledDataSource(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/memo",
                "root",
                "root"
        );
        Environment environment = new Environment(id, transactionFactory, dataSource);
        configuration.setEnvironment(environment);
        sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        System.out.println(sqlSessionFactory);
    }
    
    public static void main(String[] args) {
        buildWithXML();
    }
}
