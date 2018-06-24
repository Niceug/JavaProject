package com.ltp.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 教师信息管理窗口
 *
 */
public class TeacherInfoManageFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TeacherInfoManageFrame(String title) {
		this.setTitle(title);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		//创建按钮
		JButton addBtn = new JButton("添加教师信息");
		addBtn.setBounds(150, 100,  150,  50);
		JButton deleteBtn = new JButton("删除教师信息");
		deleteBtn.setBounds(150, 200,  150,  50);
		JButton updateBtn = new JButton("修改教师信息");
		updateBtn.setBounds(150, 300,  150,  50);
		JButton queryBtn = new JButton("查询教师信息");
		queryBtn.setBounds(150, 400,  150,  50);
		
		//添加到面板
		this.add(addBtn);
		this.add(deleteBtn);
		this.add(updateBtn);
		this.add(queryBtn);
		this.setVisible(true);
////////////////////////////////////////////////////////////////////////////
///////////////////////为按钮绑定事件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		//添加教师信息按钮
		addBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddTeacherInfoFrame("添加教师信息");
			}
		});
		//删除教师信息按钮
		deleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DeleteTeacherInfoFrame("删除教师信息");
			}
		});
		
		//更新教师信息按钮
		updateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UpdateTeacherInfoFrame("修改教师信息");
			}
		});	
		
		//查询教师信息按钮
		queryBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new QueryTeacherInfoFrame("查询教师信息");
			}
		});
		

	}
	public TeacherInfoManageFrame() {
	}
}
