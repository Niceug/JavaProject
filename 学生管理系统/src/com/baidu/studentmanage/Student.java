package com.baidu.studentmanage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int stuNum;//学号
    private String stuName;//姓名
    private String stuClass;//班级
    private String stuProfessional;//专业

    public Student() {
    }

    public Student(int stuNum, String stuName, String stuClass,
                   String stuProfessional) {
        super();
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuClass = stuClass;
        this.stuProfessional = stuProfessional;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuProfessional() {
        return stuProfessional;
    }

    public void setStuProfessional(String stuProfessional) {
        this.stuProfessional = stuProfessional;
    }

    public Connection connectToMySql() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/student?useUnicode=true&characterEncoding=UTF-8&user="
                    + "root&password=123456";
            Class.forName(driver).newInstance();
            Connection connection = DriverManager.getConnection(url);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接出错");
        }
        return null;
    }

    public boolean addStuInfo(int sNum, String sName, String sClass, String sProfessional) {
        String sqlInsert = "insert into student values(" + sNum + ",'" + sName + "','" + sClass + "','" + sProfessional + "')";
        System.out.println(sNum + sName + sClass + sProfessional);
        Connection conn = connectToMySql();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sqlInsert);
            ps.executeUpdate();
            return true;
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("添加学生信息失败！");
            return false;
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public boolean deleteStuInfo(int sNum) {

        Connection conn = connectToMySql();
        String deleteSQL = "delete from student where stuNum=" + sNum;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(deleteSQL);
            ps.executeUpdate();
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            System.out.println("数据库语句检查或执行出错");
            return false;
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public Student queryStuInfo(int sNum) {
        Student stu = new Student();
        String querySql = "select * from student where stuNum="+sNum;
        Connection conn  = connectToMySql();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(querySql);
            while(rs.next()) {
                stu.stuNum = new Integer(rs.getString("stuNum"));
                stu.stuName = rs.getString("stuName");
                stu.stuClass = rs.getString("stuClass");
                stu.stuProfessional = rs.getString("stuProfessional");
            }
            return stu;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;

        }
    }

    //修改学生信息
    public boolean modifyStuInfo(Student stu, int sNum, String sName, String sClass, String sProfessional) {

        Connection conn = connectToMySql();

        //信息有改动才提交
        if(false == sName.equals(stu.stuName)) {
            String updateSql = "update student set stuName='"+sName+"' where stuNum=" + stu.stuNum;
            try {
                PreparedStatement ps = conn.prepareStatement(updateSql);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                return false;
            }
        }

        if(false == sClass.equals(stu.stuClass)) {
            String updateSql = "update student set stuClass='"+sClass+"' where stuNum=" + stu.stuNum;
            try {
                PreparedStatement ps = conn.prepareStatement(updateSql);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                return false;
            }
        }
        if(false == sProfessional.equals(stu.stuProfessional)) {
            String updateSql = "update student set stuProfessional='"+sProfessional+"' where stuNum=" + stu.stuNum;
            try {
                PreparedStatement ps = conn.prepareStatement(updateSql);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public List<Student> queryAllStuInfo() {
        List<Student> stuList = new ArrayList<Student>();
        Student stu = null;
        ResultSet queryRS = null;
        Statement queryStatement = null;
        Connection queryConn = null;
        try{
            queryConn = connectToMySql();
            queryStatement = queryConn.createStatement();
            String sqlQuery = "select * from student";
            queryRS = queryStatement.executeQuery(sqlQuery);
            while(queryRS.next()) {
                stu = new Student();
                stu.stuNum = new Integer(queryRS.getString("stuNum"));
                stu.stuName = queryRS.getString("stuName");
                stu.stuClass = queryRS.getString("stuClass");
                stu.stuProfessional = queryRS.getString("stuProfessional");
                stuList.add(stu);
            }
            return stuList;
        }catch(Exception e2) {
            e2.printStackTrace();
            return null;
        }finally{
            try {
                queryRS.close();
                queryStatement.close();
                queryConn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}


