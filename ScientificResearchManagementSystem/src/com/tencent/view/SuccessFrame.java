package com.tencent.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SuccessFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuccessFrame(String successInfo) {
		this.setLayout(null);
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		Font font = new Font("微软雅黑", 1, 20);
		JLabel successJL = new JLabel(successInfo);
		successJL.setBounds(50,  50,  300,  50);
		successJL.setFont(font);
		this.add(successJL);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
	}
}
