package com.tencent.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorFrame(String errorInfo) {
		this.setLayout(null);
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		Font font = new Font("微软雅黑", 1, 20);
		JLabel errorJL = new JLabel(errorInfo);
		errorJL.setBounds(50,  50,  300,  50);
		errorJL.setFont(font);
		this.add(errorJL);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
	}
}
