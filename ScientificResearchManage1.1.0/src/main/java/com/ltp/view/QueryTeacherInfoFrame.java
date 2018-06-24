package com.ltp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ltp.entities.Teacher;
import com.ltp.dao.TeacherDao;

/**
 * 
 *查询教师信息和查询结果窗口,查询结果在下面
 */
public class QueryTeacherInfoFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryTeacherInfoFrame(String title) {
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
		JButton queryBtn = new JButton("查询");
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
				if(t == null) {
					
					new ErrorFrame("教师编号输入错误， 查询失败！");
				} else {
					new QueryResult(t);
				}
			}
		});
	}
}

/**
 * 用来显示查询结果的窗口
 *
 */
class QueryResult extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryResult(Teacher t) {

		//显示教师信息的地方
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

		// 教师编号
		final JTextField tNoJTF = new JTextField();
		tNoJTF.setBounds(150,  50,  200,  30);

		// 姓名
		final JTextField tNameJTF = new JTextField();
		tNameJTF.setBounds(150,  100,  200,  30);
		
		// 性别
		final JTextField tSexJTF = new JTextField();
		tSexJTF.setBounds(150,  150,  200,  30);
		
		// 职务
		final JTextField tJobJTF = new JTextField();
		tJobJTF.setBounds(150,  200,  200,  30);
		
		// 职称
		final JTextField tRankJTF = new JTextField();
		tRankJTF.setBounds(150,  250,  200,  30);
		
		// 部门
		final JTextField tOfficeJTF = new JTextField();
		tOfficeJTF.setBounds(150,  300,  200,  30);
		
		//院系
		final JTextField tDepartmentJTF = new JTextField();
		tDepartmentJTF.setBounds(150,  350,  200,  30);
		
		//电话
		final JTextField tTelJTF = new JTextField();
		tTelJTF.setBounds(150,  400,  200,  30);
		
		// 地址
		final JTextField tLocationJTF = new JTextField();
		tLocationJTF.setBounds(150,  450,  200,  30);
		
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
		this.add(tSexJTF);
		this.add(tJobJTF);
		this.add(tRankJTF);
		this.add(tOfficeJTF);
		this.add(tDepartmentJTF);
		this.add(tTelJTF);
		this.add(tLocationJTF);
////////////////////////////////////////////////////////////////////////////
///////////////////////给组件赋值/////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		if(t != null) {
			tNoJTF.setText(t.getTeacherNo() + "");
			 tNameJTF.setText(t.getTeacherName());
			 tSexJTF.setText(t.getSex());
			 tJobJTF.setText(t.getJob());
			 tRankJTF.setText(t.getRank());
			 tOfficeJTF.setText(t.getOffice());
			 tDepartmentJTF.setText(t.getDepartment());
			 tTelJTF.setText(t.getTel());
			 tLocationJTF.setText(t.getLocation());
		} else {
				new ErrorFrame("教师编号不存在，未查询到教师信息！");
		}
		
		this.setVisible(true);
	}
}
