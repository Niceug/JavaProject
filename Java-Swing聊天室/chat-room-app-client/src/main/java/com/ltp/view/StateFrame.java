package com.ltp.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class StateFrame extends JFrame{
	public StateFrame(String title) {
		this.setBounds(400,  400,  300,  200);
		this.setLayout(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("提示");
		JLabel text = new JLabel(title);
		text.setBounds(50,  60,  200,  30);
		this.add(text);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}
}
