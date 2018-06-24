package com.ltp.testlogin;

import com.ltp.dao.AdminDao;
import com.ltp.view.ErrorFrame;
import com.ltp.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 登录窗口
 */
public class LoginFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginFrame(String title) {
		this.setTitle(title);
		this.setSize(600, 400);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
////////////////////////////////////////////////////////////////////////////
///////////////////////添加各种组件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		//标题
		Font f = new Font("微软雅黑", Font.BOLD + Font.ITALIC, 50);
		JLabel headJL = new JLabel("Wellcome Admin!");
		headJL.setFont(f);
		headJL.setForeground(Color.gray);
		headJL.setBounds(80, 20, 500, 100);
		
		Font f1 = new Font("微软雅黑", Font.BOLD, 15);
		
		JLabel head1JL = new JLabel("管理员登录");
		head1JL.setBounds(240, 90, 100, 50);
		head1JL.setFont(f1);
		head1JL.setForeground(Color.gray);
		
		
		//两个标签
		JLabel nameJL = new JLabel("用户名：");
		nameJL.setBounds(140, 150, 70, 30);
		nameJL.setFont(f1);
		JLabel pwdJL = new JLabel("密    码：");
		pwdJL.setBounds(140, 200, 70, 30);
		pwdJL.setFont(f1);
		
		//用户名和密码框
		final JTextField nameJTF = new JTextField();
		nameJTF.setBounds(210,  150,  200,  30);
		
		final JPasswordField pwdPF = new JPasswordField();
		pwdPF.setBounds(210,  200,  200,  30);
		
		//登录按钮
		JButton loginBtn = new JButton("登录");
		loginBtn.setBounds(140,  260,  80,  35);
		loginBtn.setFont(f1);
		loginBtn.setBackground(Color.blue);
		loginBtn.setForeground(Color.white);
		
		//退出按钮
		JButton exitBtn = new JButton("退出");
		exitBtn.setBounds(340,  260,  80,  35);
		exitBtn.setFont(f1);
		exitBtn.setBackground(Color.blue);
		exitBtn.setForeground(Color.white);
		
		//将以上组件添加到面板
		this.add(headJL);
		this.add(head1JL);
		this.add(nameJL);
		this.add(pwdJL);
		this.add(nameJTF);
		this.add(pwdPF);
		this.add(loginBtn);
		this.add(exitBtn);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		//判断是否点击了登录按钮
		
////////////////////////////////////////////////////////////////////////////
///////////////////////为登录和退出按钮绑定事件//////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//登录
				String username = nameJTF.getText();
				String password = new String(pwdPF.getPassword());
				if(AdminDao.getAdminFromUsernameAndPwd(username, password) == 1) {
					//登录失败，输出错误信息
					new ErrorFrame("登录失败，用户名或密码错误!");
				} else {
					//创建一个主页面
					new MainFrame("科研项目管理系统");
				}
			}
		});
		
		//退出按钮绑定事件
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//退出
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new LoginFrame("管理员登录");
	}
}
