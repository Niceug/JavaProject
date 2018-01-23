package com.baidu.studentmanage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import java.sql.*;
/**
 *
 * @author Z7M-SL7D2
 * @since 2018年1月19日21:24:27
 * 用来显示学生管理系统主界面
 */

public class ShowStuInfoFrame extends JFrame {
    List<Student> stuList  = new ArrayList<Student>();
    Student stu = null;
    JTextArea stuInfoListJTA = null;

    public String setStringLen(int len) {
        String string = "";
        for(int i = 0; i < 35-len; ++i) {
            string += " ";
        }
        return string;
    }

    public Connection connectToMySql() {
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/student?useUnicode=true&characterEncoding=UTF-8&user="
                    +"root&password=123456";
            Class.forName(driver).newInstance();
            Connection connection = DriverManager.getConnection(url);
            return connection;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     */
    public ShowStuInfoFrame() {
        this.setSize(600, 600);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //界面标题部分
        JLabel titleJL = new JLabel("学生管理系统");
        Font font = new Font("微软雅黑", 1, 15);
        titleJL.setFont(font);
        titleJL.setLayout(null);
        titleJL.setBounds(250, 10, 100, 20);

        //按钮部分
        JPanel buttonJP = new JPanel();
        buttonJP.setLayout(null);
      //  buttonJP.setBackground(Color.blue);
        buttonJP.setBounds(0, 50, 600, 40);

        JButton jbAdd = new JButton("添加学生信息");
        jbAdd.setBounds(25, 10, 120, 30);
        jbAdd.setBackground(Color.gray);

        JButton jbDelete = new JButton("删除学生信息");
        jbDelete.setBounds(170, 10, 120, 30);
        jbDelete.setBackground(Color.gray);

        JButton jbModify = new JButton("修改学生信息");
        jbModify.setBounds(315, 10, 120, 30);
        jbModify.setBackground(Color.gray);

        JButton jbQuery = new JButton("查询学生信息");
        jbQuery.setBounds(455, 10, 120, 30);
        jbQuery.setBackground(Color.gray);

      //  buttonJP.setLayout(new FlowLayout());
        buttonJP.add(jbAdd);
        buttonJP.add(jbDelete);
        buttonJP.add(jbModify);
        buttonJP.add(jbQuery);

        JPanel listHeadJP = new JPanel();
        listHeadJP.setBackground(Color.lightGray);
        listHeadJP.setLayout(null);
        listHeadJP.setBounds(0, 120, 580, 30);

        JLabel numHeadJL = new JLabel(" 学  号");
        numHeadJL.setBackground(Color.gray);
        numHeadJL.setBounds(20, 0, 150, 25);

        JLabel nameHeadJL = new JLabel("姓  名");
        nameHeadJL.setBounds(170, 0, 150, 25);

        JLabel classHeadJL = new JLabel("班  级");
        classHeadJL.setBounds(320, 0, 150, 25);

        JLabel professionalHeadJL = new JLabel("专  业");
        professionalHeadJL.setBounds(470, 0, 150, 25);

        listHeadJP.add(numHeadJL);
        listHeadJP.add(nameHeadJL);
        listHeadJP.add(classHeadJL);
        listHeadJP.add(professionalHeadJL);

        Font stuInfoListFont = new  Font("微软雅黑", 0, 13);
        stuInfoListJTA = new JTextArea(20,20);
        stuInfoListJTA.setBounds(10, 152, 560, 400);
        stuInfoListJTA.setBorder (BorderFactory.createEmptyBorder (1,1,1,5));
        stuInfoListJTA.setColumns (20);
        stuInfoListJTA.setRows (20);//相当于设置文本区组件的初始大小,并不是说一行只能写0
        stuInfoListJTA.setFont(stuInfoListFont);

        this.add(titleJL);
        this.add(buttonJP);
        this.add(listHeadJP);
        this.add(stuInfoListJTA);

        stuInfoListJTA.setText("");
        ResultSet queryRS = null;
        Statement queryStatement = null;
        Connection queryConn = null;

        try{
            queryConn = connectToMySql();
            queryStatement = queryConn.createStatement();
            String sqlQuery = "select * from student";
            queryRS = queryStatement.executeQuery(sqlQuery);
            while(queryRS.next()) {
                String sNum = queryRS.getString("stuNum");
                String sName = queryRS.getString("stuName");
                String sClass = queryRS.getString("stuClass");
                String sProfessional = queryRS.getString("stuProfessional");
                stuInfoListJTA.setText(stuInfoListJTA.getText()
                        + sNum + setStringLen(sNum.getBytes().length)
                        + sName + setStringLen(sName.getBytes().length)
                        + sClass + setStringLen(sClass.getBytes().length)
                        + sProfessional + setStringLen(sProfessional.getBytes().length) + "\n");
            }
        }catch(Exception e2) {
            e2.printStackTrace();
        }finally{
            try {
                queryRS.close();
                queryStatement.close();
                queryConn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        this.setVisible(true);
        jbAdd.addMouseListener(new MouseAdapter(){
            //匿名内部类使用方法的临时变量需要提前，负责会让你改为final，改为final是为了延长变量的声明周期
            JTextField nameJTF = null;
            JTextField numJTF = null;
            JTextField classJTF = null;
            JTextField professionalJTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                final JFrame addJF = new JFrame();
                addJF.setSize(300, 400);
                addJF.setBackground(Color.gray);
                addJF.setLocationRelativeTo(null);
                addJF.setVisible(true);
                addJF.setLayout(new FlowLayout());
                JLabel numJL = new JLabel("学号：");
                numJTF = new JTextField(20);
                JLabel nameJL = new JLabel("姓名：");
                nameJTF = new JTextField(20);
                JLabel classJL = new JLabel("班级：");
                classJTF = new JTextField(20);
                JLabel professionalJL = new JLabel("专业：");
                professionalJTF = new JTextField(20);
                //addJF.dispose();//销毁子窗口
                addJF.add(numJL);
                addJF.add(numJTF);
                addJF.add(nameJL);
                addJF.add(nameJTF);
                addJF.add(classJL);
                addJF.add(classJTF);
                addJF.add(professionalJL);
                addJF.add(professionalJTF);
                JButton addJB = new JButton("添加");
                addJF.add(addJB);
                addJB.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Integer snumI = new Integer(numJTF.getText().toString());
                        int snum = snumI;
                        String sname = nameJTF.getText();
                        String sclass = classJTF.getText();
                        String sprofessional = professionalJTF.getText();
                        //输入的信息为空的处理
                        if(snum <0 | sname == null | sclass == "" | sprofessional == "") {
                            JFrame tipJF = new JFrame("提示");
                            tipJF.setVisible(true);
                            tipJF.setSize(200,100);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("请填入了所有的信息之后再点击提交");
                            tipJF.add(tipJL);
                        }else {
                            String sqlInsert = "insert into student values("+snum+",'"+sname+"','"+sclass+"','"+sprofessional+"')";
                            Connection conn = connectToMySql();
                            PreparedStatement ps = null;
                            try{
                                ps = conn.prepareStatement(sqlInsert);
                                ps.executeUpdate();
                                addJF.dispose();
                                JFrame addSuccessfulJF = new JFrame("提示");
                                addSuccessfulJF.setLocationRelativeTo(null);
                                addSuccessfulJF.setSize(260, 100);
                                addSuccessfulJF.setVisible(true);
                                addSuccessfulJF.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("添加学生信息成功！");
                                addSuccessfulJF.add(SuccessfulJL);
                            }catch(Exception e1) {
                                e1.printStackTrace();
                                System.out.println("创建Statement失败");
                            }finally {
                                try {
                                    ps.close();
                                    conn.close();
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            }

                        }
                    }

                });
            }
        });
        jbDelete.addMouseListener(new MouseAdapter() {
            JTextField numJTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {

                final JFrame deleteJF = new JFrame("删除学生信息");
                deleteJF.setLayout(new FlowLayout());
                deleteJF.setSize(300, 80);
                deleteJF.setVisible(true);
                deleteJF.setLocationRelativeTo(null);
                JLabel numJL = new JLabel("学号:");
                numJTF = new JTextField(15);
                JButton numJB = new JButton("提交");
                deleteJF.add(numJL);
                deleteJF.add(numJTF);
                deleteJF.add(numJB);
                numJB.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Connection conn = connectToMySql();
                        Integer isnum = new Integer(numJTF.getText().toString());
                        if(isnum != null) {
                            int sNum = isnum;
                            String deleteSQL = "delete from student where stuNum="+sNum;
                            PreparedStatement ps = null;
                            try{
                                ps = conn.prepareStatement(deleteSQL);
                                ps.executeUpdate();
                                deleteJF.dispose();
                                JFrame deleteSuccessfulJF = new JFrame("提示");
                                deleteSuccessfulJF.setLocationRelativeTo(null);
                                deleteSuccessfulJF.setSize(260, 100);
                                deleteSuccessfulJF.setVisible(true);
                                deleteSuccessfulJF.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("删除学生信息成功！");
                                deleteSuccessfulJF.add(SuccessfulJL);
                            } catch(Exception e3){
                                e3.printStackTrace();
                                System.out.println("数据库语句检查出错");
                            }finally {
                                try {
                                    ps.close();
                                    conn.close();
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            }

                        } else {
                            System.out.println("请输入学号再点击提交");
                        }
                    }
                });
            }
        });
        jbModify.addMouseListener(new MouseAdapter(){
            JTextField num1JTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                final JFrame modifyJF = new JFrame("修改学生信息");
                modifyJF.setSize(300, 80);
                modifyJF.setLocationRelativeTo(null);
                modifyJF.setLayout(new FlowLayout());
                modifyJF.setVisible(true);
                JLabel numJL = new JLabel("学号：");
                num1JTF = new JTextField(15);
                JButton numJB = new JButton("提交");
                modifyJF.add(numJL);
                modifyJF.add(num1JTF);
                modifyJF.add(numJB);
                numJB.addMouseListener(new MouseAdapter() {
                    JTextField numJTF = null;
                    JTextField nameJTF = null;
                    JTextField classJTF = null;
                    JTextField professionalJTF = null;
                    String tempNum = null;
                    String tempName = null;
                    String tempClass = null;
                    String tempProfessional = null;
                    Connection conn = null;
                    @Override
                    public void mouseClicked(MouseEvent e) {

//////////////////////////////////////////////////////////////
//////////////显示学号对应的学生信息///////////////////////////////
/////////////////////////////////////////////////////////////
                        final JFrame modifyJF1 = new JFrame();
                        modifyJF1.setSize(300, 400);
                        modifyJF1.setBackground(Color.gray);
                        modifyJF1.setLocationRelativeTo(null);
                        modifyJF1.setVisible(true);
                        modifyJF1.setLayout(new FlowLayout());
                        JLabel numJL = new JLabel("学号：");
                        numJTF = new JTextField(20);
                        JLabel nameJL = new JLabel("姓名：");
                        nameJTF = new JTextField(20);
                        JLabel classJL = new JLabel("班级：");
                        classJTF = new JTextField(20);
                        JLabel professionalJL = new JLabel("专业：");
                        professionalJTF = new JTextField(20);
                        modifyJF1.add(numJL);
                        modifyJF1.add(numJTF);
                        modifyJF1.add(nameJL);
                        modifyJF1.add(nameJTF);
                        modifyJF1.add(classJL);
                        modifyJF1.add(classJTF);
                        modifyJF1.add(professionalJL);
                        modifyJF1.add(professionalJTF);

                        Integer isnum = new Integer(num1JTF.getText().toString());
                        final int snum = isnum;
                        String querySql = "select * from student where stuNum="+snum;
                        conn  = connectToMySql();
                        try {
                            Statement statement = conn.createStatement();
                            ResultSet rs = statement.executeQuery(querySql);
                            while(rs.next()) {
                                tempNum = rs.getString("stuNum");
                                tempName = rs.getString("stuName");
                                tempClass = rs.getString("stuClass");
                                tempProfessional = rs.getString("stuProfessional");
                                numJTF.setText(tempNum);
                                nameJTF.setText(tempName);
                                classJTF.setText(tempClass);
                                professionalJTF.setText(tempProfessional);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
//////////////////////////////////////////////////////////////
//////////////提交修改后的学生信息///////////////////////////////
/////////////////////////////////////////////////////////////
                        JButton submitJB = new JButton("提交修改");
                        modifyJF1.add(submitJB);
                        submitJB.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                String sName = nameJTF.getText();
                                String sClass = classJTF.getText();
                                String sProfessional = professionalJTF.getText();
                                if(false == sName.equals(tempName)) {
                                    String updateSql = "update student set stuName='"+sName+"' where stuNum="+snum;
                                    try {
                                        PreparedStatement ps = conn.prepareStatement(updateSql);
                                        ps.executeUpdate();
                                        ps.close();
                                    } catch (SQLException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                                if(false == sClass.equals(tempClass)) {
                                    String updateSql = "update student set stuClass='"+sClass+"' where stuNum="+snum;
                                    try {
                                        PreparedStatement ps = conn.prepareStatement(updateSql);
                                        ps.executeUpdate();
                                        ps.close();
                                    } catch (SQLException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                                if(false == sProfessional.equals(tempProfessional)) {
                                    String updateSql = "update student set stuProfessional='"+sProfessional+"' where stuNum="+snum;
                                    try {
                                        PreparedStatement ps = conn.prepareStatement(updateSql);
                                        ps.executeUpdate();
                                        ps.close();
                                    } catch (SQLException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                                modifyJF1.dispose();
                                JFrame updateSucessfulJF = new JFrame("提示");
                                updateSucessfulJF.setLocationRelativeTo(null);
                                updateSucessfulJF.setSize(260, 100);
                                updateSucessfulJF.setVisible(true);
                                updateSucessfulJF.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("修改学生信息成功！");
                                updateSucessfulJF.add(SuccessfulJL);
                            }

                        });
                        modifyJF.dispose();
                    }
                });
            }
        });
        jbQuery.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stuInfoListJTA.setText("");
                ResultSet rs = null;
                Statement statement = null;
                Connection conn = null;

                try{
                    conn = connectToMySql();
                    statement = conn.createStatement();
                    String sqlQuery = "select * from student";
                    rs = statement.executeQuery(sqlQuery);
                    while(rs.next()) {
                        String sNum = rs.getString("stuNum");
                        String sName = rs.getString("stuName");
                        String sClass = rs.getString("stuClass");
                        String sProfessional = rs.getString("stuProfessional");
                        stuInfoListJTA.setText(stuInfoListJTA.getText()
                                + sNum + setStringLen(sNum.getBytes().length)
                                + sName + setStringLen(sName.getBytes().length)
                                + sClass + setStringLen(sClass.getBytes().length)
                                + sProfessional + setStringLen(sProfessional.getBytes().length) + "\n");
                    }
                }catch(Exception e2) {
                    e2.printStackTrace();
                }finally{
                    try {
                        rs.close();
                        statement.close();
                        conn.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
    public static void main(String[] args) {
        new ShowStuInfoFrame();
    }
}
