package com.ltp.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyComponent{
	JPanel panel;
	public MyComponent(JPanel panel) {
		this.panel = panel;
	}
	
	/**
	 * 文本框
	 * @param x 
	 * @param y
	 * @param width
	 * @param height
	 * @param fcolor
	 * @param f
	 */
	public JTextField createTextFild(int x, int y, int width, int height, Color fcolor, Font f) {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, width, height);
		textField.setFont(f);
		textField.setForeground(fcolor);
		textField.setBorder(null);
		panel.add(textField);
		return textField;
	}
	
	public JPasswordField createPasswordFild(int x, int y, int width, int height, Color fcolor, Font f) {
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(x, y, width, height);
		passwordField.setFont(f);
		passwordField.setForeground(fcolor);
		passwordField.setBorder(null);
		panel.add(passwordField);
		return passwordField;
	}
	
	/**
	 * 文本域
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 * @param f
	 */
	public JTextArea createTextArea(int x, int y, int width, int height, Color fcolor, Font f) {
		JTextArea textArea = new JTextArea();
		textArea.setBounds(x, y, width, height);
		textArea.setFont(f);
		textArea.setForeground(fcolor);
		panel.add(textArea);
		return textArea;
	}
	
	/**
	 * 按钮
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 * @param f
	 */
	public JButton createButton(int x, int y, int width, int height, Color color, Font f, String title) {
		JButton btn = new JButton();
		btn.setBounds(x, y, width, height);
		btn.setBackground(color);
		btn.setText(title);
		btn.setForeground(new Color(255, 255, 255));
		btn.setFont(f);
		btn.setBorder(null);
		panel.add(btn);
		return btn;
	}
}
