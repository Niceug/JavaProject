package com.tencent.view;

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

import com.tencent.bean.Teacher;
import com.tencent.dao.TeacherDao;



/**
 * 更新教师信息窗口
 */
public class UpdateTeacherInfoFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateTeacherInfoFrame(String title) {
		this.setTitle(title);
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
		
		Font font = new Font("微软雅黑", 1, 15);
////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件、、、//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		JLabel tNoJL = new JLabel("教师编号：");
		tNoJL.setFont(font);
		tNoJL.setForeground(Color.blue);
		tNoJL.setBounds(50, 50, 100, 30);
		final JTextField tNoJTF = new JTextField();
		tNoJTF.setBounds(150,  50,  200,  30);
		
		//查询按钮
		JButton queryBtn = new JButton("查找");
		queryBtn.setBounds(160,  100,  80,  35);
		queryBtn.setBackground(Color.blue);
		queryBtn.setForeground(Color.white);
		
		this.add(tNoJL);
		this.add(tNoJTF);
		this.add(queryBtn);
		this.setVisible(true);
////////////////////////////////////////////////////////////////////////////
///////////////////////为按钮绑定事件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		queryBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tNo = new Integer(tNoJTF.getText());
				Teacher t = TeacherDao.queryDB(tNo);
				new UpdateInfo(t);
			}
		});
	}
}

class UpdateInfo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateInfo(Teacher t) {
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
		
		Font font = new Font("微软雅黑", 1, 15);
////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件。。。//////////////////////////////////////////
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
		
		JLabel tZhiWuJL = new JLabel("职    务：");
		tZhiWuJL.setFont(font);
		tZhiWuJL.setForeground(Color.blue);
		tZhiWuJL.setBounds(50, 200, 100, 30);
		
		JLabel tZhiChengJL = new JLabel("职    称：");
		tZhiChengJL.setFont(font);
		tZhiChengJL.setForeground(Color.blue);
		tZhiChengJL.setBounds(50, 250, 100, 30);
		
		JLabel tBuMenJL = new JLabel("部    门：");
		tBuMenJL.setFont(font);
		tBuMenJL.setForeground(Color.blue);
		tBuMenJL.setBounds(50, 300, 100, 30);
		
		JLabel tYuanXiJL = new JLabel("院    系：");
		tYuanXiJL.setFont(font);
		tYuanXiJL.setForeground(Color.blue);
		tYuanXiJL.setBounds(50, 350, 100, 30);
		
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
		final JComboBox<String> tZhiWuJCB = new JComboBox<String>();
		tZhiWuJCB.addItem("国家级教练");
		tZhiWuJCB.addItem("高级关务监督");
		tZhiWuJCB.addItem("编审");
		tZhiWuJCB.addItem("高级工程师");
		tZhiWuJCB.addItem("研究员");
		tZhiWuJCB.addItem("高级工艺美术师");
		tZhiWuJCB.setBounds(150,  200,  200,  30);
		
		//职称
		final JComboBox<String> tZhiChengJCB = new JComboBox<String>();
		tZhiChengJCB.addItem("教授");
		tZhiChengJCB.addItem("博士");
		tZhiChengJCB.addItem("编审");
		tZhiChengJCB.addItem("研究生");
		tZhiChengJCB.addItem("副教授");
		tZhiChengJCB.addItem("助教");
		tZhiChengJCB.addItem("讲师");
		tZhiChengJCB.setBounds(150,  250,  200,  30);
		
		//部门
		final JTextField tBuMenJTF = new JTextField();
		tBuMenJTF.setBounds(150,  300,  200,  30);
		
		//院系
		final JTextField tYuanXiJTF = new JTextField();
		tYuanXiJTF.setBounds(150,  350,  200,  30);
		
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
		this.add(tZhiWuJL);
		this.add(tZhiChengJL);
		this.add(tBuMenJL);
		this.add(tYuanXiJL);
		this.add(tTelJL);
		this.add(tLocationJL);
		this.add(tNoJTF);
		this.add(tNameJTF);
		this.add(tSexManJRB);
		this.add(tSexWomanJRB);
		this.add(tZhiWuJCB);
		this.add(tZhiChengJCB);
		this.add(tBuMenJTF);
		this.add(tYuanXiJTF);
		this.add(tTelJTF);
		this.add(tLocationJTF);
		this.add(submitBtn);
		this.setVisible(true);
		
////////////////////////////////////////////////////////////////////////////
///////////////////////为给组件赋值///////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		tNoJTF.setText(new Integer(t.getTeacherNo()).toString());
		tNameJTF.setText(t.getTeacherName());
		if(t.getSex() == "男") {
			tSexManJRB.setSelected(true);
			tSexWomanJRB.setSelected(false);
		} else {
			tSexManJRB.setSelected(false);
			tSexWomanJRB.setSelected(true);
		}
		tZhiWuJCB.setSelectedItem(t.getZhiWu());
		tZhiChengJCB.setSelectedItem(t.getZhiCheng());
		tBuMenJTF.setText(t.getBuMen());
		tYuanXiJTF.setText(t.getYuanXi());
		tTelJTF.setText(t.getTel());
		tLocationJTF.setText(t.getLocation());
		tNoJTF.setEditable(false);
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
				String tZhiWu = (String)tZhiWuJCB.getSelectedItem();
				String tZhiCheng = (String)tZhiChengJCB.getSelectedItem();
				String tBuMen = (String)tBuMenJTF.getText();
				String tYuanXi = (String)tYuanXiJTF.getText();
				String tTel = (String)tTelJTF.getText();
				String tLocation = (String)tLocationJTF.getText();
				//执行添加到数据库操作
				Teacher t = new Teacher(no, tName, tSex, tZhiWu, 
						tZhiCheng, tBuMen, tYuanXi, tTel, tLocation);
				boolean state = TeacherDao.updateDB(t);
				if(state == true) {
					new SuccessFrame("教师信息更新成功!");
				} else {
					new ErrorFrame("教师信息更新失败");
				}
			}
		});
	}
}
