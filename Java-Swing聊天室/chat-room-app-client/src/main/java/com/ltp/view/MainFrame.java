package com.ltp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ltp.chat.Client;
import com.ltp.chat.Server;

public class MainFrame {
	public void createMainFrame(Client client, String head) {
		client.setUsername(head);
		ImageIcon loginBg = new ImageIcon("D:/mainbg.jpg");
        JLabel label=new JLabel(loginBg);  
          
        //设置label的大小  
        label.setBounds(0,0,900,600);  
          
        JFrame mainFrame=new JFrame();
        mainFrame.setTitle(head);
          
        //获取窗口的第二层，将label放入  
        mainFrame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
              
        //获取mainFrame的顶层容器,并设置为透明  
        JPanel j=(JPanel)mainFrame.getContentPane();  
        j.setOpaque(false);  
        
        JPanel panel=new JPanel();  
        panel.setLayout(null);
		MyComponent component = new MyComponent(panel);
		Font f = new Font("微软雅黑", 1, 15);
		JButton gBtn = component.createButton(20, 20, 100, 25, new Color(192, 192, 192), f, "加入群聊");
		JButton pBtn = component.createButton(20, 50, 100, 25, new Color(192, 192, 192), f, "私聊");
		JButton closeBtn = component.createButton(20, 80, 100, 25, new Color(192, 192, 192), f, "注销");
		
		JLabel title = new JLabel("在线列表");
		title.setBounds(680,  20,  150,  150);
		title.setBackground(new Color(255, 255, 255));
		panel.add(title);
		
		JTextArea gTextArea = component.createTextArea(150,  20,  500, 300,  new Color(0, 0, 0), f);
		JTextArea pTextArea = component.createTextArea(150,  20,  500, 300,  new Color(0, 0, 0), f);
		gTextArea.setEditable(false);
		pTextArea.setEditable(false);
		gTextArea.setSelectedTextColor(Color.RED);
		gTextArea.setLineWrap(true);
		gTextArea.setWrapStyleWord(true);
		
		JTextArea gSendTextArea = component.createTextArea(150,  330,  500, 100,  new Color(0, 0, 0), f);
		JTextArea pSendTextArea = component.createTextArea(150,  330,  500, 100,  new Color(0, 0, 0), f);
		
		JButton gSendBtn = component.createButton(570,  450,  80, 25, new Color(1, 156, 254), f, "发送");
		JTextField otherName = component.createTextFild(500, 450, 50,  25,  new Color(192, 192, 192), f);
		JButton pSendBtn = component.createButton(570,  450,  80, 25, new Color(1, 156, 254), f, "发送");
		otherName.setVisible(false);
		gBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gSendTextArea.setVisible(true);
				gTextArea.setVisible(true);
				gSendBtn.setVisible(true);
				pTextArea.setVisible(false);
				pSendTextArea.setVisible(false);
				pSendBtn.setVisible(false);
				otherName.setVisible(false);
			}
		});
		
		pBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gSendTextArea.setVisible(false);
				gTextArea.setVisible(false);
				gSendBtn.setVisible(false);
				pTextArea.setVisible(true);
				pSendTextArea.setVisible(true);
				pSendBtn.setVisible(true);
				otherName.setVisible(true);
			}
		});
		
		gSendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String msg = "G:" + gSendTextArea.getText();
				client.sendMsg(msg);
				gTextArea.setCaretPosition(gTextArea.getText().length());  
			}
		});
		
		pSendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = otherName.getText();
				if(username == null || "".equals(username)) {
					new StateFrame("请输入对方的用户名");
				} else {
					String sendMsg = pSendTextArea.getText();
					pTextArea.append("你对" + username + "说：\n" + sendMsg + "\n\n");
					String msg = "P:" + username + "-"+client.getUsername() + ":" + sendMsg;
					client.sendMsg(msg);
				}
			}
		});
		
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				client.sendMsg("bye");
				new StateFrame("你已下线");
			}
		});
		
		new Thread(new Client.ClientGetMsg(client.getSocket(), gTextArea, pTextArea, title)).start();
        panel.setOpaque(false);  
        mainFrame.setBounds(200, 200, 900, 600);
        mainFrame.setBackground(new Color(255, 255, 255));
        mainFrame.add(panel);  
        mainFrame.setVisible(true);  
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LoginAndRegiste();
	}
}

class LoginAndRegiste{
	public LoginAndRegiste() {
		ImageIcon loginBg = new ImageIcon("D:/loginBg.png");
        JLabel label=new JLabel(loginBg);  
          
        //设置label的大小  
        label.setBounds(0,0,425,325);  
          
        JFrame frame=new JFrame();  
          
        //获取窗口的第二层，将label放入  
        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
              
        //获取frame的顶层容器,并设置为透明  
        JPanel j=(JPanel)frame.getContentPane();  
        j.setOpaque(false);  
        
        JPanel panel=new JPanel();  
        panel.setLayout(null);
        MyComponent component = new MyComponent(panel);
        Color color = new Color(192, 192, 192);
		Font f = new Font("微软雅黑", 1, 15);
		
		JTextField username = component.createTextFild(113, 166,  230,  25,  color, f);
		JPasswordField pwd = component.createPasswordFild(113, 205,  230,  25,  color, f);
		JTextField address = component.createTextFild(113, 245,  230,  25,  color, f);
		
		Color btnColor = new Color(9, 192, 254);
		JButton loginBtn = component.createButton(95, 290, 230, 30, btnColor, f, "登录");
		JButton registeBtn = component.createButton(95, 325, 230, 30, btnColor, f, "注册");
		
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(username.getText() == null || "".equals(username.getText())) {
					new StateFrame("用户名不能为空");
				} else if (pwd.getPassword() == null || "".equals(pwd.getPassword())) {
					new StateFrame("密码不能为空");
				} else if (address.getText() == null || "".equals(address.getText())) {
					new StateFrame("请输入聊天服务器的地址，如127.0.0.1");
				} else {
					Client client = new Client();
					Socket socket = client.connect(address.getText());
					if(socket != null) {
						client.registe("username:" + username.getText());
						frame.dispose();
						new StateFrame("登录成功，您已自动加入群聊");
						MainFrame mainFrame = new MainFrame();
						mainFrame.createMainFrame(client, username.getText());
					}
				}
			}
		});
		
		registeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(username.getText() == null || "".equals(username.getText())) {
					new StateFrame("用户名不能为空");
				} else if (pwd.getPassword() == null || "".equals(pwd.getPassword())) {
					new StateFrame("密码不能为空");
				}  else if (address.getText() == null || "".equals(address.getText())) {
					new StateFrame("请输入聊天服务器的地址，如127.0.0.1");
				} else {
					Client client = new Client();
					Socket socket = client.connect(address.getText());
					if(socket != null) {
						client.registe("username:" + username.getText());
						new StateFrame("注册成功,您已自动加入群聊");
						frame.dispose();
						MainFrame mainFrame = new MainFrame();
						mainFrame.createMainFrame(client, username.getText());
					}
				}
			}
		});
		
        //必须设置为透明的。否则看不到图片  
        panel.setOpaque(false);  
        frame.setBackground(new Color(255, 255, 255));
        frame.add(panel);  
        frame.setSize(435,450);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
