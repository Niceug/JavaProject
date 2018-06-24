package com.ltp.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	public static volatile Map<String, Socket> clientMap = new HashMap<>();
	public static volatile ArrayList<String> list = new ArrayList<>();
	
	/**
	 * username:hello注册
	 * G:hello群聊
	 * P:username-hello username是私聊对象，两个管道
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serverSocket = new  ServerSocket(6666);
		System.out.println("服务器等待连接...");
		
		ExecutorService clientPool = Executors.newFixedThreadPool(20);
		for(int i = 0; i < 20; ++i) {
			// 添加多个管道
			Socket client = serverSocket.accept();
			clientPool.execute(new ExecuteClient(client));
			
		}
	}
	
	static class ExecuteClient implements Runnable {
		Socket client;
		public ExecuteClient(Socket client) {
			this.client = client;
		}
		@Override
		public void run() {
			Scanner scanner = null;
			try {
				scanner = new Scanner(client.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = null;
			while (true) {
				if(scanner.hasNext()) {
					str = scanner.nextLine();
					if(str.startsWith("username:")) {
						// 注册
						String username = str.substring(9);
						registeUser(username, client);
						System.out.println(username + "上线了");
						System.out.println("当前在线人数" + clientMap.size() + "人");

						StringBuffer userList = new StringBuffer();
						for(String key : clientMap.keySet()) {
							userList.append(key + "##");
						}

						updateOnlineList(username, userList.toString());
						list.add(username);
						
					} else if (str.startsWith("G:")) {
						// 群聊
						String username = getUserName(client);
						groupChat(username, str.substring(2));
						
					} else if (str.startsWith("P:")) {
						// 私聊
						String tmp = str.split("\\:")[1];
						privateChat(tmp.split("-")[0], tmp.split("-")[1] + ":" + str.split("\\:")[2]);
					} else if ("bye".equals(str)) {
						// 客户端退出
						String username = getUserName(client);
						removeClient(username);
						System.out.println("活跃人数" + clientMap.size() + "人");
						list.remove(username);
						try {
							client.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	/**
	 * 根据socket获取用户名
	 * @param client
	 * @return
	 */
	private static String getUserName(Socket client) {
		Set<Entry<String, Socket>> set = clientMap.entrySet();
		Iterator<Entry<String, Socket>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Entry<String, Socket> map =  iterator.next();
			if(client.equals(map.getValue())) {
				return map.getKey();
			}
		}
		
		return null;
	}
	
	/**
	 * 用户上线
	 * @param username
	 * @param socket
	 */
	private static void registeUser(String username, Socket socket) {
		// TODO Auto-generated method stub
		clientMap.put(username, socket);
	}
	
	/**
	 * 群聊
	 * @param username
	 * @param msg
	 */
	private static void groupChat(String username, String msg) {
		// 给所有人发送消息
		for(String key : clientMap.keySet()) {
			Socket socket = clientMap.get(key);
			PrintStream ps = null;
			try {
				ps = new PrintStream(socket.getOutputStream(), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ps.println(username + ": " + msg);
		}
	}

	/**
	* 刷新在线列表，给每个人都发一份当前在线人员列表
	*/
	private static void updateOnlineList(String username, String userList) {
		// 给所有人发送消息
		for(String key : clientMap.keySet()) {
			Socket socket = clientMap.get(key);
			PrintStream ps = null;
			try {
				ps = new PrintStream(socket.getOutputStream(), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ps.println("@@" + username + "加入群聊@@" + userList);
		}
	}
	
	/**
	 * 私聊
	 * @param username
	 * @param msg
	 */
	private static void privateChat(String username, String msg) {
		Socket socket = clientMap.get(username);
		PrintStream pStream = null;
		try {
			pStream = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pStream.println("username:" + msg);
	}

	/**
	 * 客户端下线
	 * @param username
	 */
	public static void removeClient(String username) {
		Set<Entry<String, Socket>> set = clientMap.entrySet();
		Iterator<Entry<String, Socket>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Entry<String, Socket> map = iterator.next();
			if(map.getKey().equals(username)) {
				iterator.remove();
				list.remove(username);
			}
		}

	}

}
