package com.ltp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ltp.entities.Teacher;
import com.ltp.dao.TeacherDao;

/**
 * 添加教师信息窗口
 *
 */
public class AddTeacherInfoFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddTeacherInfoFrame(String title) {
		this.setTitle(title);
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
		
		Font font = new Font("微软雅黑", 1, 15);
////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		JLabel tNoJL = new JLabel("教师编号：");
		tNoJL.setFont(font);
		tNoJL.setForeground(Color.blue);
		tNoJL.setBounds(50, 50, 100, 30);
		
		JLabel tNameJL = new JLabel("姓    名：");
		tNameJL.setFont(font);
		tNameJL.setForeground(Color.blue);
		tNameJL.setBounds(50, 100, 100, 30);
		
		JLabel tSexJL = new JLabel("性    别：");
		tSexJL.setFont(font);
		tSexJL.setForeground(Color.blue);
		tSexJL.setBounds(50, 150, 100, 30);
		
		JLabel tJobJL = new JLabel("职    务：");
		tJobJL.setFont(font);
		tJobJL.setForeground(Color.blue);
		tJobJL.setBounds(50, 200, 100, 30);
		
		JLabel tRankJL = new JLabel("职    称：");
		tRankJL.setFont(font);
		tRankJL.setForeground(Color.blue);
		tRankJL.setBounds(50, 250, 100, 30);
		
		JLabel tOfficeJL = new JLabel("部    门：");
		tOfficeJL.setFont(font);
		tOfficeJL.setForeground(Color.blue);
		tOfficeJL.setBounds(50, 300, 100, 30);
		
		JLabel tDepartmentJL = new JLabel("院    系：");
		tDepartmentJL.setFont(font);
		tDepartmentJL.setForeground(Color.blue);
		tDepartmentJL.setBounds(50, 350, 100, 30);
		
		JLabel tTelJL = new JLabel("电    话：");
		tTelJL.setFont(font);
		tTelJL.setForeground(Color.blue);
		tTelJL.setBounds(50, 400, 100, 30);
		
		JLabel tLocationJL = new JLabel("地    址：");
		tLocationJL.setFont(font);
		tLocationJL.setForeground(Color.blue);
		tLocationJL.setBounds(50, 450, 100, 30);
		
		//编号
		final JTextField tNoJTF = new JTextField();
		tNoJTF.setBounds(150,  50,  200,  30);
		
		//姓名
		final JTextField tNameJTF = new JTextField();
		tNameJTF.setBounds(150,  100,  200,  30);
		
		//性别
		ButtonGroup sexBG = new ButtonGroup();
		final JRadioButton tSexManJRB = new JRadioButton("男");
		JRadioButton tSexWomanJRB = new JRadioButton("女");
		tSexManJRB.setBounds(150,  150,  50,  30);
		tSexWomanJRB.setBounds(200,  150,  50,  30);
		sexBG.add(tSexManJRB);
		sexBG.add(tSexWomanJRB);
		
		//职务
		final JComboBox<String> tJobJCB = new JComboBox<String>();
		tJobJCB.addItem("国家级教练");
		tJobJCB.addItem("高级关务监督");
		tJobJCB.addItem("编审");
		tJobJCB.addItem("高级工程师");
		tJobJCB.addItem("研究员");
		tJobJCB.addItem("高级工艺美术师");
		tJobJCB.setBounds(150,  200,  200,  30);
		
		//职称
		final JComboBox<String> tRankJCB = new JComboBox<String>();
		tRankJCB.addItem("教授");
		tRankJCB.addItem("博士");
		tRankJCB.addItem("编审");
		tRankJCB.addItem("研究生");
		tRankJCB.addItem("副教授");
		tRankJCB.addItem("助教");
		tRankJCB.addItem("讲师");
		tRankJCB.setBounds(150,  250,  200,  30);
		
		//部门
		final JTextField tOfficeJTF = new JTextField();
		tOfficeJTF.setBounds(150,  300,  200,  30);
		
		//院系
		final JTextField tDepartmentJTF = new JTextField();
		tDepartmentJTF.setBounds(150,  350,  200,  30);
		
		//电话
		final JTextField tTelJTF = new JTextField();
		tTelJTF.setBounds(150,  400,  200,  30);
		
		//地址
		final JTextField tLocationJTF = new JTextField();
		tLocationJTF.setBounds(150,  450,  200,  30);
		
		JButton submitBtn = new JButton("提交");
		submitBtn.setBounds(350,  500,  80,  35);
		submitBtn.setBackground(Color.blue);
		submitBtn.setForeground(Color.white);
		
		this.add(tNoJL);
		this.add(tNameJL);
		this.add(tSexJL);
		this.add(tJobJL);
		this.add(tRankJL);
		this.add(tOfficeJL);
		this.add(tDepartmentJL);
		this.add(tTelJL);
		this.add(tLocationJL);
		this.add(tNoJTF);
		this.add(tNameJTF);
		this.add(tSexManJRB);
		this.add(tSexWomanJRB);
		this.add(tJobJCB);
		this.add(tRankJCB);
		this.add(tOfficeJTF);
		this.add(tDepartmentJTF);
		this.add(tTelJTF);
		this.add(tLocationJTF);
		this.add(submitBtn);
		this.setVisible(true);

////////////////////////////////////////////////////////////////////////////
///////////////////////为按钮绑定事件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////		
		submitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//获取组件的值
				String tNo = tNoJTF.getText();
				int no = new Integer(tNo);
				String tName = tNameJTF.getText();
				String tSex;
				boolean sexState = tSexManJRB.isSelected();
				if(sexState == true) {
					tSex = "男";
				} else {
					tSex = "女";
				}
				String tJob = (String)tJobJCB.getSelectedItem();
				String tRank = (String)tRankJCB.getSelectedItem();
				String tOffice = (String)tOfficeJTF.getText();
				String tDepartment = (String)tDepartmentJTF.getText();
				String tTel = (String)tTelJTF.getText();
				String tLocation = (String)tLocationJTF.getText();
				//执行添加到数据库操作
				Teacher t = new Teacher(no, tName, tSex, tJob, 
						tRank, tOffice, tDepartment, tTel, tLocation);
				boolean state = TeacherDao.addDB(t);
				if(state == true) {
					new SuccessFrame("添加成功!");
				} else {
					new ErrorFrame("添加失败，可能是主键重复!");
				}
			}
		});
	}
}
