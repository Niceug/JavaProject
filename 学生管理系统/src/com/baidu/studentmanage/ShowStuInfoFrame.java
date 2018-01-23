package com.baidu.studentmanage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    Student stu = new Student();
    JTextArea stuInfoListJTA = null;

    //对输出进行处理
    public String setStringLen(int len) {
        String string = "";
        for(int i = 0; i < 35-len; ++i) {
            string += " ";
        }
        return string;
    }

    /**
     * 显示所有学生信息
     */
    public void showAllStuInfo(){
        stuInfoListJTA.setText("");
        List<Student> list = stu.queryAllStuInfo();
        for(Student student:list) {
            String sNum = new Integer(student.getStuNum()).toString();
            String sName = student.getStuName();
            String sClass = student.getStuClass();
            String sProfessional = student.getStuProfessional();
            stuInfoListJTA.setText(stuInfoListJTA.getText()
                    + sNum + setStringLen(sNum.getBytes().length)
                    + sName + setStringLen(sName.getBytes().length)
                    + sClass + setStringLen(sClass.getBytes().length)
                    + sProfessional + setStringLen(sProfessional.getBytes().length) + "\n");
        }

    }

    /**
     * 构造函数
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

        showAllStuInfo();
        this.setVisible(true);

        //添加学生信息
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
                        Integer snumAddI = new Integer(numJTF.getText().toString());
                        int snumAdd = snumAddI;
                        String snameAdd = nameJTF.getText();
                        String sclassAdd = classJTF.getText();
                        String sprofessionalAdd = professionalJTF.getText();
                        //输入的信息为空的处理
                        if(snumAdd <0 | snameAdd == null | sclassAdd == "" | sprofessionalAdd == "") {
                            JFrame tipJF = new JFrame("提示");
                            tipJF.setVisible(true);
                            tipJF.setSize(200,100);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("请填入了所有的信息之后再点击提交");
                            tipJF.add(tipJL);
                        }else {
                                stu = new Student();
                                stu.addStuInfo(snumAdd, snameAdd, snameAdd, sprofessionalAdd);
                                addJF.dispose();
                                JFrame addSuccessfulJF = new JFrame("提示");
                                addSuccessfulJF.setLocationRelativeTo(null);
                                addSuccessfulJF.setSize(260, 100);
                                addSuccessfulJF.setVisible(true);
                                addSuccessfulJF.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("添加学生信息成功！");
                                addSuccessfulJF.add(SuccessfulJL);
                        }
                    }

                });
            }
        });

    //删除学生信息
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
                                Integer sNumI = new Integer(numJTF.getText().toString());
                                stu.deleteStuInfo(sNumI);
                                deleteJF.dispose();
                                JFrame deleteSuccessfulJF = new JFrame("提示");
                                deleteSuccessfulJF.setLocationRelativeTo(null);
                                deleteSuccessfulJF.setSize(260, 100);
                                deleteSuccessfulJF.setVisible(true);
                                deleteSuccessfulJF.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("删除学生信息成功！");
                                deleteSuccessfulJF.add(SuccessfulJL);
                    }
                });
            }
        });

        //修改学生信息
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

                        //查询学生信息
                        Integer sNum = new Integer(num1JTF.getText().toString());
                        final Student stuRet = stu.queryStuInfo(sNum);

                        numJTF.setText(new Integer(stuRet.getStuNum()).toString());
                        nameJTF.setText(stuRet.getStuName());
                        classJTF.setText(stuRet.getStuClass());
                        professionalJTF.setText(stuRet.getStuProfessional());

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
                                stu.modifyStuInfo(stuRet, stuRet.getStuNum(), sName, sClass, sProfessional);
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

        //查询学生信息
        jbQuery.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //显示所有的学生信息
                showAllStuInfo();
            }
        });
    }
    public static void main(String[] args) {
        new ShowStuInfoFrame();
    }
}
