package com.ltp.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Client {
	private String username;
	private String pwd;
	private Socket socket;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Socket getSocket() {
		return socket;
	}

	public Socket connect(String address) {
		Socket  socket = null;
		try {
			socket = new Socket(address, 6666);
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
			e.printStackTrace();
		}
		System.out.println("client start up!");
		this.socket = socket;
		return socket;
	}

	/**
	 * 接收信息
	 * @author Z7M-SL7D2
	 *
	 */
	public static class ClientGetMsg implements Runnable{
		JTextArea groupChat;
		JTextArea privateChat;
		JLabel title;
		Socket socket;

		public ClientGetMsg(Socket socket, JTextArea groupChat, JTextArea privateChat, JLabel title) {
			this.socket = socket;
			this.groupChat = groupChat;
			this.privateChat = privateChat;
			this.title = title;
		}
		@Override
		public void run() {
			Scanner scanner = null;
			try {
				scanner = new Scanner(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String msg = "";
			while(true)
				if(scanner.hasNext()) {
					msg = scanner.nextLine();
					if(msg.startsWith("username:")) {
						privateChat.append(msg.substring(9) + "\n");
					} else if(msg.startsWith("@@")){
						String[] str = msg.split("@@");
						groupChat.append(str[1] + "\n");

						// 用户列表
						String userList = str[2];

						String[] users = userList.split("##");
						StringBuilder stringBuilder = new StringBuilder();
						stringBuilder.append("<html><body><div style='text-align: center'><h2> 群成员 </h2> <br />");
						for(int i = 0, len = users.length; i < len; ++i) {
							stringBuilder.append("<font color='gray'>" + users[i] + "</font><br />");
						}
						stringBuilder.append("</div></body></html>");

						title.setText(stringBuilder.toString());

					} else {
						groupChat.append(msg + "\n");
					}
					
				}
			}
	}
	
	/**
	 * 发送消息
	 * @param msg 消息内容
	 */
	public void sendMsg(String msg) {
		PrintStream send = null;
		try {
			send = new PrintStream(socket.getOutputStream(), true, "utf8");
			send.println(msg);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 注册
	 * @param username
	 */
	public void registe(String username) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(socket.getOutputStream(), true, "UTF8");
			ps.println(username);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
