package cn.edu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.edu.bean.Canteen;
import cn.edu.bean.User;
import cn.edu.db.DatabaseOpration;
import cn.edu.impl.FileOperation;

public class Client extends JFrame{
	//用户的消费金额
	float consumeMoneyAll = 0;
	
	//判断用户是否存在
	boolean hasUser = false;
	
	User user = null;
	//默认食堂id
	int canteenId = 11;
	//默认设备id
	int deviceId = 10;
	
	//判断机器是否打开
	boolean open = false;
	//判断是否插卡
	boolean insert = false;
	//判断是不是第一次按数字
	boolean first = true;
	
	//操作数据库的类
	static DatabaseOpration dbo = new DatabaseOpration();
	
	//文件操作的类
	static FileOperation fo = new FileOperation();
	
	//产生随机数
	final Random id = new Random(System.currentTimeMillis());
	
	public Client(){
		this.setSize(800,  600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		Font f = new Font("微软雅黑", 1, 60);
		Font f1 = new Font("微软雅黑", 1, 30);
		Font f2 = new Font("微软雅黑", 0, 20);
		
		Color bg = new Color(58, 177, 255);
		
		//money
		final JTextField moneyJTF = new JTextField();
		moneyJTF.setBounds(20,  0,  480,  90);
		moneyJTF.setFont(f);
		
		//各种按钮
		JButton jb1 = new JButton("1");
		jb1.setFont(f);
		jb1.setBounds(20, 110, 80, 80);
		jb1.setBackground(bg);
		
		JButton jb2 = new JButton("2");
		jb2.setFont(f);
		jb2.setBounds(140, 110, 80, 80);
		jb2.setBackground(bg);
		
		JButton jb3 = new JButton("3");
		jb3.setFont(f);
		jb3.setBounds(260, 110, 80, 80);
		jb3.setBackground(bg);
		
		JButton jbAdd = new JButton("+");
		jbAdd.setFont(f);
		jbAdd.setBounds(380, 110, 80, 80);
		jbAdd.setBackground(bg);
		
		JButton jb4 = new JButton("4");
		jb4.setFont(f);
		jb4.setBounds(20, 210, 80, 80);
		jb4.setBackground(bg);
		
		JButton jb5 = new JButton("5");
		jb5.setFont(f);
		jb5.setBounds(140, 210, 80, 80);
		jb5.setBackground(bg);
		
		JButton jb6 = new JButton("6");
		jb6.setFont(f);
		jb6.setBounds(260, 210, 80, 80);
		jb6.setBackground(bg);
		
		JButton jbSub = new JButton("-");
		jbSub.setFont(f);
		jbSub.setBounds(380, 210, 80, 80);
		jbSub.setBackground(bg);
		
		JButton jb7 = new JButton("7");
		jb7.setFont(f);
		jb7.setBounds(20, 310, 80, 80);
		jb7.setBackground(bg);
		
		JButton jb8 = new JButton("8");
		jb8.setFont(f);
		jb8.setBounds(140, 310, 80, 80);
		jb8.setBackground(bg);
		
		JButton jb9 = new JButton("9");
		jb9.setFont(f);
		jb9.setBounds(260, 310, 80, 80);
		jb9.setBackground(bg);
		
		JButton jbPoint = new JButton(".");
		jbPoint.setFont(f);
		jbPoint.setBounds(380, 310, 80, 80);
		jbPoint.setBackground(bg);
		
		JButton jb0 = new JButton("0");
		jb0.setFont(f);
		jb0.setBounds(20, 420, 80, 80);
		jb0.setBackground(bg);
		
		final JButton jbInOut = new JButton("插卡");
		jbInOut.setFont(f);
		jbInOut.setBounds(140, 420, 320, 80);
		jbInOut.setBackground(Color.red);
		
		JButton upJB = new JButton("上传数据");
		upJB.setBounds(550, 360, 200, 50);
		upJB.setBackground(bg);
		
		JLabel jpsetCanteen = new JLabel("设置食堂");
		jpsetCanteen.setBounds(550,  150,  200,  40);
		jpsetCanteen.setFont(f1);
		final JComboBox<String> selectCanteenJCB = new JComboBox<String>();
		selectCanteenJCB.setBounds(550, 200, 200, 40);
		selectCanteenJCB.addItem("一食堂");
		selectCanteenJCB.addItem("二食堂");
		selectCanteenJCB.addItem("三食堂");
		selectCanteenJCB.setFont(f2);
		
		
		JLabel jpsetDevice = new JLabel("设置机号");
		jpsetDevice.setBounds(550,  250,  200,  40);
		jpsetDevice.setFont(f1);
		
		final JComboBox<String> selectDeviceJCB = new JComboBox<String>();
		selectDeviceJCB.setBounds(550, 300, 200, 40);
		for(int i = 10; i<20; i++) {
			selectDeviceJCB.addItem(i+ "号机");
		}
		
		selectDeviceJCB.setFont(f2);
		
		
		
		
		final JButton switchJB = new JButton("开");
		switchJB.setBounds(550, 430, 200, 50);
		switchJB.setBackground(Color.red);
		
		moneyJTF.setEditable(false);
		
		this.add(moneyJTF);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jbAdd);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		this.add(jbSub);
		this.add(jb7);
		this.add(jb8);
		this.add(jb9);
		this.add(jbPoint);
		this.add(jb0);
		this.add(jbInOut);
		this.add(upJB);
		this.add(selectCanteenJCB);
		this.add(selectDeviceJCB);
		this.add(switchJB);
		this.add(jpsetDevice);
		this.add(jpsetCanteen);
		this.setVisible(true);
		
		jb0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "0");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "0");
					}
				}
			}
		});
		
		jb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "1");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "1");
					}
				}
			}
		});
		
		jb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "2");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "2");
					}
				}
			}
		});
		
		jb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "3");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "3");
					}
				}
			}
		});
		
		jb4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "4");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "4");
					}
				}
			}
		});
		
		jb5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "5");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "5");
					}
				}
			}
		});
		
		jb6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "6");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "6");
					}
				}
			}
		});
		
		jb7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "7");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "7");
					}
				}
			}
		});
		
		jb8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "8");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "8");
					}
				}
			}
		});
		
		jb9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true) {
					if(first == true) {
						moneyJTF.setText("");
						moneyJTF.setText(moneyJTF.getText() + "9");
						first = false;
					} else {
						moneyJTF.setText(moneyJTF.getText() + "9");
					}
				}
			}
		});
		
		//小数点
		jbPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == true && open == true){
					
					if(first == false) {
						String oldMoney = moneyJTF.getText();
						if(oldMoney.matches(".") == true){
							moneyJTF.setText(oldMoney + ".");
							first = false;
						}
					}
				}
			}
		});
		
		//加钱
		jbAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(first == false) {
					String consumeMoney = moneyJTF.getText();
					consumeMoneyAll = consumeMoneyAll - (new Float(consumeMoney));
					float balence = user.getBalence() + (new Float(consumeMoney));
					//设置用户的余额
					user.setBalence(balence);
					//在面板上显示
					moneyJTF.setText(balence + "");
					first = true;
					
				}
				
			}
		});
		
		//减钱
		jbSub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(first == false) {
					String consumeMoney = moneyJTF.getText();
					consumeMoneyAll = consumeMoneyAll + (new Float(consumeMoney));
					float balence = user.getBalence() - (new Float(consumeMoney));
					//设置用户的余额
					user.setBalence(balence);
					//在面板上显示
					moneyJTF.setText(balence + "");
					first = true;
				}
			}
		});
		
		//上传按钮
		upJB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//使用读取xml文件并将数据存入数据库
				System.out.println("上传数据");
				List<Canteen> list = fo.readFromXMLFile();
				for(Canteen c: list){
					System.out.println(c.getCanteenId());
				}
				try {
					dbo.addToConsumeTable(list);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//产生随机数
		//插卡拔卡按钮
		jbInOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(open == false) {
					jbInOut.setEnabled(false);
				} else {
					insert = !insert;
					if(insert == false) {
						//拔卡
						//设置当前用户的余额
						jbInOut.setBackground(Color.red);
						jbInOut.setText("插卡");
						moneyJTF.setText("请插入您的饭卡");
						
						//拔卡判断将当前用户是否消费，若消费的余额信息录入数据库
						if(consumeMoneyAll != 0) {
							//判断用户是否存在
							if(hasUser == false){
								dbo.addUser(user);
							}else{
								dbo.updateBalance(user);
							}
								
						}
						
						//获取消费信息
						Canteen c = new Canteen();
						c.setMealCardId(user.getMealCardId());
						c.setCanteenId(canteenId);
						c.setDeviceId(deviceId);
						c.setConsumeMoney(consumeMoneyAll);
						Date consumeDate = new Date();
						long consumeTime = consumeDate.getTime();
						c.setConsumeTime(consumeTime);
						
						//拔卡的时候将售饭记录写入文件
						fo.writeToTextFile(c);
						fo.writeToXMLFile(c);
						fo.serializeIntoFile(c);
						
						//全局变量归零
						consumeMoneyAll = 0;
						first = true;
						user = null;
						
					} else {
						
						//插卡
						DatabaseOpration dbo = new DatabaseOpration();
						
						int mealCardId = ((id.nextInt())%1000)+1000;
						
						//查询数据库中是否有这个id
						user = dbo.queryUserInfo(mealCardId);
						
						System.out.println(mealCardId);
						
						jbInOut.setBackground(Color.GREEN);
						jbInOut.setText("拔卡");
						
						if(user == null){
							hasUser = false;
							user = new User();
							//没有我就给这个用户的余额初始化为1000
							user.setBalence(1000);
							user.setMealCardId(mealCardId);
							user.setUserName("王湾");
							moneyJTF.setText(user.getBalence() + "");
						} else {
							hasUser = true;
							moneyJTF.setText(user.getBalence() + "");
						}
						
					}
				}
				
			}
		});
		
		
		//开关
		switchJB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insert == false) {
					open = !open;
					if(open) {
						switchJB.setBackground(Color.GREEN);
						switchJB.setText("关");
					} else {
						switchJB.setBackground(Color.red);
						switchJB.setText("开");
					}
				}
			}
		});
		
//		selectCanteenJCB.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getID() == 0){
//					for(int i = 10; i<20; i++) {
//						selectDeviceJCB.addItem(i+ "号机");
//					}
//					//selectDeviceJCB.setSelectedIndex(0);
//				}
//			}
//		});
//		
//		selectCanteenJCB.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getID() == 1){
//					for(int i = 20; i<30; i++) {
//						selectDeviceJCB.addItem(i+ "号机");
//					}
//					//selectDeviceJCB.setSelectedIndex(0);
//				}
//				
//				
//			}
//		});
//		
//		selectCanteenJCB.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getID() == 2){
//					for(int i = 30; i<40; i++) {
//						selectDeviceJCB.addItem(i+ "号机");
//					}
//					//selectDeviceJCB.setSelectedIndex(0);
//				}
//				
//				
//			}
//		});
		
		//选择食堂按钮
		selectCanteenJCB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String option = (String) selectCanteenJCB.getSelectedItem();
				if(option.equals("一食堂")) {
					selectDeviceJCB.removeAllItems();
					canteenId=11;
					
					
				} else if(option.equals("二食堂")) {
					selectDeviceJCB.removeAllItems();
					canteenId=12;
					for(int i = 20; i<30; i++) {
						selectDeviceJCB.addItem(i+ "号机");
					}
					selectDeviceJCB.setSelectedIndex(0);
					
				}else if(option.equals("三食堂")) {
					selectDeviceJCB.removeAllItems();
					canteenId=13;
					for(int i = 30; i<40; i++) {
						selectDeviceJCB.addItem(i+ "号机");
					}
					selectDeviceJCB.setSelectedIndex(0);
				}
			}
		});

	}
	public static void main(String[] args) {
		new Client();
	}

}
