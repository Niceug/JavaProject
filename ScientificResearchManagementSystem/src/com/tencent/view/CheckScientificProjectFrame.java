package com.tencent.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.tencent.bean.Project;
import com.tencent.dao.ProjectDao;

/**
 * 审批科研项目的窗口
 *
 */
public class CheckScientificProjectFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public CheckScientificProjectFrame(String title) {
		this.setTitle(title);
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
		
		Font font = new Font("微软雅黑", 1, 15);
////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		JLabel tNoJL = new JLabel("项目编号：");
		tNoJL.setFont(font);
		tNoJL.setForeground(Color.blue);
		tNoJL.setBounds(50, 50, 100, 30);
		final JTextField tNoJTF = new JTextField();
		tNoJTF.setBounds(150,  50,  200,  30);
		
		//查询按钮
		JButton queryBtn = new JButton("查询");
		queryBtn.setBounds(160,  100,  80,  35);
		queryBtn.setBackground(Color.blue);
		queryBtn.setForeground(Color.white);
		
		this.add(tNoJL);
		this.add(tNoJTF);
		this.add(queryBtn);
		this.setVisible(true);

////////////////////////////////////////////////////////////////////////////
///////////////////////为按钮绑定事件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		queryBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int pNo = new Integer(tNoJTF.getText());
				Project p = ProjectDao.queryCheckingDB(pNo);
				if(p == null) {
					new ErrorFrame("项目编号不存在，未查询到该教师!");
				} else {
				new QueryProResult(p);
				}
			}
		});
	}
}

/**
 * 显示查询结果的类
 *
 */
class QueryProResult extends JFrame{
	private static final long serialVersionUID = 1L;

	public QueryProResult(Project p) {
		this.setTitle("审核项目");
		this.setSize(800, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
		
		Font font = new Font("微软雅黑", 1, 15);

////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		JLabel pProNoJL = new JLabel("项目编号：");
		pProNoJL.setFont(font);
		pProNoJL.setForeground(Color.blue);
		pProNoJL.setBounds(50, 50, 100, 30);
		
		final JTextField pProNoJTF = new JTextField();
		pProNoJTF.setBounds(150,  50,  200,  30);
		
		JLabel pProNameJL = new JLabel("项目名称：");
		pProNameJL.setFont(font);
		pProNameJL.setForeground(Color.blue);
		pProNameJL.setBounds(360, 50, 100, 30);
		
		//项目名称
		final JTextField pProNameJTF = new JTextField();
		pProNameJTF.setBounds(460,  50,  200,  30);
		
		JLabel pTNoJL = new JLabel("教师编号：");
		pTNoJL.setFont(font);
		pTNoJL.setForeground(Color.blue);
		pTNoJL.setBounds(50, 100, 100, 30);
		//教师编号
		final JTextField pTNoJTF = new JTextField();
		pTNoJTF.setBounds(150,  100,  200,  30);
		
		JLabel pTNameJL = new JLabel("姓    名：");
		pTNameJL.setFont(font);
		pTNameJL.setForeground(Color.blue);
		pTNameJL.setBounds(360, 100, 100, 30);
		//姓名
		final JTextField pTNameJTF = new JTextField();
		pTNameJTF.setBounds(460,  100,  200,  30);
		
		
		JLabel pYuanXiJL = new JLabel("院    系：");
		pYuanXiJL.setFont(font);
		pYuanXiJL.setForeground(Color.blue);
		pYuanXiJL.setBounds(50, 150, 100, 30);
		//院系
		final JTextField pYuanXiJTF = new JTextField();
		pYuanXiJTF.setBounds(150,  150,  200,  30);
		
		
		JLabel pProTypeJL = new JLabel("项目类型：");
		pProTypeJL.setFont(font);
		pProTypeJL.setForeground(Color.blue);
		pProTypeJL.setBounds(50, 200, 100, 30);
		
		//项目类型
		final JComboBox<String> pProTypeJCB = new JComboBox<String>();
		pProTypeJCB.addItem("国家级项目");
		pProTypeJCB.addItem("省部级项目");
		pProTypeJCB.addItem("地方级项目");
		pProTypeJCB.addItem("其他项目");
		pProTypeJCB.setBounds(150,  200,  200,  30);
		
		JLabel pProFormJL = new JLabel("项目形式：");
		pProFormJL.setFont(font);
		pProFormJL.setForeground(Color.blue);
		pProFormJL.setBounds(360, 200, 100, 30);
		
		//项目形式
		final JComboBox<String> pProFormJCB = new JComboBox<String>();
		pProFormJCB.addItem("论文");
		pProFormJCB.addItem("专著");
		pProFormJCB.addItem("发明专利");
		pProFormJCB.addItem("应用软件");
		pProFormJCB.addItem("自主开发的新技术");
		pProFormJCB.addItem("其他");
		pProFormJCB.setBounds(460,  200,  200,  30);
		
		JLabel pProTimeJL = new JLabel("申报时间：");
		pProTimeJL.setFont(font);
		pProTimeJL.setForeground(Color.blue);
		pProTimeJL.setBounds(50, 250, 100, 30);

		//时间
		final JTextField pProTimeJTF = new JTextField();
		pProTimeJTF.setBounds(150,  250,  200,  30);

		JLabel pProTextJL = new JLabel("内    容：");
		pProTextJL.setFont(font);
		pProTextJL.setForeground(Color.blue);
		pProTextJL.setBounds(50, 300, 100, 30);
		
		//内容
		final JTextArea pProTextJTA = new JTextArea();
		pProTextJTA.setBounds(50,  350,  700,  200);

		JLabel pMemoJL = new JLabel("备    注：");
		pMemoJL.setFont(font);
		pMemoJL.setForeground(Color.blue);
		pMemoJL.setBounds(50, 550, 100, 30);
		
		//备注
		final JTextArea pMemoJTA = new JTextArea();
		pMemoJTA.setBounds(50,  600,  700,  200);
		
		
		JLabel pCheckingJL = new JLabel("是否验收：");
		pCheckingJL.setFont(font);
		pCheckingJL.setForeground(Color.blue);
		pCheckingJL.setBounds(50, 850, 100, 30);
		
		//是否验收
		final JComboBox<String> pCheckingJCB = new JComboBox<String>();
		pCheckingJCB.addItem("否");
		pCheckingJCB.addItem("是");
		pCheckingJCB.setBounds(150,  850,  200,  30);
		

		
		JLabel pPassJL = new JLabel("是否审批：");
		pPassJL.setFont(font);
		pPassJL.setForeground(Color.blue);
		pPassJL.setBounds(360, 850, 100, 30);
		//是否审批
		final JComboBox<String> pPassJCB = new JComboBox<String>();
		pPassJCB.addItem("否");
		pPassJCB.addItem("是");
		pPassJCB.setBounds(460,  850,  200,  30);
		
		JButton submitBtn = new JButton("提交");
		submitBtn.setBounds(350,  900,  80,  35);
		submitBtn.setBackground(Color.blue);
		submitBtn.setForeground(Color.white);
		
		this.add(pProNoJL);
		this.add(pProNameJL);
		this.add(pTNoJL);
		this.add(pTNameJL);
		this.add(pYuanXiJL);
		this.add(pProTypeJL);
		this.add(pProFormJL);
		this.add(pProTimeJL);
		this.add(pProTextJL);
		this.add(pMemoJL);
		this.add(pCheckingJL);
		this.add(pPassJL);

////////////////////////////////////////////////////////////////////////////
////////////////////把查询到的结果赋值给组件/////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		pProNoJTF.setText(new Integer(p.getProNo()).toString());
		pProNameJTF.setText(p.getProName());
		pTNoJTF.setText(new Integer(p.getTeacherNo()).toString());
		pTNameJTF.setText(p.getTeacherName());
		pYuanXiJTF.setText(p.getYuanXi());
		pProTypeJCB.setSelectedItem(p.getProType());
		pProFormJCB.setSelectedItem(p.getProForm());
		pProTimeJTF.setText(new Long(p.getProTime()).toString());
		pProTextJTA.setText(p.getProText());
		pMemoJTA.setText(p.getMemo());
		pCheckingJCB.setSelectedItem(p.getChecking());
		pPassJCB.setSelectedItem(p.getPass());
		pProNoJTF.setEditable(false);
		pPassJCB.setEnabled(false);
		
		this.add(pProNoJTF);
		this.add(pProNameJTF);
		this.add(pTNoJTF);
		this.add(pTNameJTF);
		this.add(pYuanXiJTF);
		this.add(pProTypeJCB);
		this.add(pProFormJCB);
		this.add(pProTimeJTF);
		this.add(pProTextJTA);
		this.add(pMemoJTA);
		this.add(pCheckingJCB);
		this.add(pPassJCB);
		this.add(submitBtn);
		this.setVisible(true);
		
////////////////////////////////////////////////////////////////////////////
///////////////////////为按钮绑定事件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		
		submitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//获取组件的值
				String proNo = pProNoJTF.getText();
				String proName = pProNameJTF.getText();
				String teacherNo = pTNoJTF.getText();
				String teacherName = pTNameJTF.getText();
				String yuanXi = pYuanXiJTF.getText();
				String proType = (String)pProTypeJCB.getSelectedItem();
				String proForm = (String)pProFormJCB.getSelectedItem();
				String proTime = pProTimeJTF.getText();
				String proText = pProTextJTA.getText();
				String memo = pMemoJTA.getText();
				String checking = (String)pCheckingJCB.getSelectedItem();
				String pass = (String)pPassJCB.getSelectedItem();
				System.out.println(checking+pass);
				Project p = new Project(new Integer(proNo), proName, new Integer(teacherNo), teacherName, 
						yuanXi, proType, proForm, new Long(proTime), proText, memo, checking, pass);
					ProjectDao.checkDB(p);
					new SuccessFrame("操作成功");
			}
		});
	}
}
