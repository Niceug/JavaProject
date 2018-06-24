package com.ltp.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 科研项目管理窗口
 *
 */
public class ScientificManageFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ScientificManageFrame(String title) {
		this.setTitle(title);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		//创建按钮
		JButton addBtn = new JButton("申报科研项目");
		addBtn.setBounds(150, 100,  150,  50);
		JButton checkBtn = new JButton("审批科研项目");
		checkBtn.setBounds(150, 200,  150,  50);
		JButton passBtn = new JButton("验收科研项目");
		passBtn.setBounds(150, 300,  150,  50);
		
		//添加到面板
		this.add(addBtn);
		this.add(checkBtn);
		this.add(passBtn);
		this.setVisible(true);
		//绑定事件
////////////////////////////////////////////////////////////////////////////
///////////////////////为按钮绑定事件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		
		//申报科研项目按钮
		addBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddScientificProjectFrame("申报科研项目");
			}
		});
		
		//审核科研项目按钮
		checkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//更新checking字段
				new CheckScientificProjectFrame("审批科研项目");
			}
		});	
		
		//验收科研项目按钮
		passBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PassScientificProjectFrame("验收科研项目");
			}
		});
				

	}
	public ScientificManageFrame(){
	}
}
