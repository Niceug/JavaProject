package com.ltp.view;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;


import javax.swing.*;

import com.ltp.codecount.CodeLine;

public class MainFrame extends JFrame {
	public MainFrame(String title) {
		this.setTitle(title);
		this.setBounds(200, 200, 500, 400);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addLabel(50, 50, 100, 25, "请输入文件路径", null);
		JTextField textField = addTextField(160, 50, 200, 25);
		JButton jButton = addBtn(370, 50, 80, 25, "统计", Color.decode("#1E92F2"));
		JCheckBox javaCheckBox = addCheckBox(50, 80, 60, 25, ".java");
		JCheckBox cCheckBox = addCheckBox(110, 80, 60, 25, ".c");
		JCheckBox cppCheckBox = addCheckBox(170, 80, 60, 25, ".cpp");
		JCheckBox htmlCheckBox = addCheckBox(230, 80, 60, 25, ".html");
		JCheckBox jspCheckBox = addCheckBox(290, 80, 60, 25, ".jsp");
		JCheckBox cssCheckBox = addCheckBox(350, 80, 60, 25, ".css");
		JTextField endOfFile = addTextField(410, 80, 40, 25);
		JTextArea jTextArea = addTextArea(50, 120, 400, 230);
		this.setVisible(true);
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String filePath = textField.getText();
				filePath = filePath.replaceAll("\\\\", "\\\\\\\\");
				File file = new File(filePath);
				int i = 0;
				String[] args = new String[7];
				if (javaCheckBox.isSelected()) {
					args[i] = javaCheckBox.getText();
					i++;
				}
				if (cCheckBox.isSelected()) {
					args[i] = cCheckBox.getText();
					i++;
				}
				if (cppCheckBox.isSelected()) {
					args[i] = cppCheckBox.getText();
					i++;
				}
				if (htmlCheckBox.isSelected()) {
					args[i] = htmlCheckBox.getText();
					i++;
				}
				if (jspCheckBox.isSelected()) {
					args[i] = jspCheckBox.getText();
					i++;
				}
				if (cssCheckBox.isSelected()) {
					args[i] = cssCheckBox.getText();
					i++;
				}
				String customType = endOfFile.getText();
				if (!"".equals(customType) || customType != null) {
					args[i] = customType;
					i++;
				}

					try {
						CodeLine.countCodeLine(file, args);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String text = CodeLine.sBuilder.toString();
					text += "统计完毕！\n当前文件路径下总代码行数为：" + CodeLine.COUNT + "行";
					CodeLine.COUNT = 0;
					jTextArea.setText(text);
			}
		});
	}
	

	// 添加TextField
	public JTextField addTextField(int x, int y, int width, int height) {
		JTextField jTextField = new JTextField();
		jTextField.setBounds(x, y, width, height);
		this.add(jTextField);
		return jTextField;
		
	}

	// 添加button
	public JButton addBtn(int x, int y, int width, int height, String btnName, Color color) {
		JButton jButton = new JButton(btnName);
		jButton.setBounds(x, y, width, height);
		jButton.setForeground(Color.WHITE);
		jButton.setBackground(color);
		this.add(jButton);
		return jButton;
	}

	// 添加用于显示的jLabel
	public void addLabel(int x, int y, int width, int height, String title, Color color) {
		JLabel jLabel = new JLabel();
		jLabel.setBounds(x, y, width, height);
		jLabel.setText(title);
		this.add(jLabel);
	}

	// 添加jTextArea
	public JTextArea addTextArea(int x, int y, int width, int height) {
		JTextArea txaDisplay = new JTextArea();
		txaDisplay.setBounds(x, y, width, height);
		JScrollPane scroll = new JScrollPane(txaDisplay);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(x, y, width, height);
		txaDisplay.setCaretPosition(txaDisplay.getText().length());
		txaDisplay.setEditable(false);
		this.add(scroll);
		return txaDisplay;
	}

	// 添加checkBox
	public JCheckBox addCheckBox(int x, int y, int width, int height, String text) {
		JCheckBox jCheckBox = new JCheckBox(text);
		jCheckBox.setBounds(x, y, width, height);
		this.add(jCheckBox);
		return jCheckBox;
	}

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame("统计代码行数");
	}
}
