package com.ltp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ltp.entities.Project;
import com.ltp.dao.ProjectDao;

/**
 *验收科研项目的窗口
 */
public class PassScientificProjectFrame  extends JFrame{

	private static final long serialVersionUID = 1L;

	public PassScientificProjectFrame(String title) {
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
				Project p = ProjectDao.queryCheckedDB(pNo);
				
				if(p == null) {
					new ErrorFrame("项目编号输入有误，或该项目未被审核！");
				} else {
					new PassProResult(p);
				}
			}
		});
	}
}

class PassProResult extends JFrame{
			private static final long serialVersionUID = 1L;

			public PassProResult(Project p) {
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
				
				
				JLabel pDepartmentJL = new JLabel("院    系：");
				pDepartmentJL.setFont(font);
				pDepartmentJL.setForeground(Color.blue);
				pDepartmentJL.setBounds(50, 150, 100, 30);
				//院系
				final JTextField pDepartmentJTF = new JTextField();
				pDepartmentJTF.setBounds(150,  150,  200,  30);
				
				
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

				JLabel pContentJL = new JLabel("内    容：");
				pContentJL.setFont(font);
				pContentJL.setForeground(Color.blue);
				pContentJL.setBounds(50, 300, 100, 30);
				
				//内容
				final JTextArea pContentJTA = new JTextArea();
				pContentJTA.setBounds(50,  350,  700,  200);

				JLabel pMemoJL = new JLabel("备    注：");
				pMemoJL.setFont(font);
				pMemoJL.setForeground(Color.blue);
				pMemoJL.setBounds(50, 550, 100, 30);
				
				//备注
				final JTextArea pMemoJTA = new JTextArea();
				pMemoJTA.setBounds(50,  600,  700,  200);
				
				
				JLabel pcheckedJL = new JLabel("是否验收：");
				pcheckedJL.setFont(font);
				pcheckedJL.setForeground(Color.blue);
				pcheckedJL.setBounds(50, 850, 100, 30);
				
				//是否验收
				final JComboBox<String> pcheckedJCB = new JComboBox<String>();
				pcheckedJCB.addItem("否");
				pcheckedJCB.addItem("是");
				pcheckedJCB.setBounds(150,  850,  200,  30);
				

				
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
				this.add(pDepartmentJL);
				this.add(pProTypeJL);
				this.add(pProFormJL);
				this.add(pProTimeJL);
				this.add(pContentJL);
				this.add(pMemoJL);
				this.add(pcheckedJL);
				this.add(pPassJL);
////////////////////////////////////////////////////////////////////////////
///////////////////////设置组件的值//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
				pProNoJTF.setText(new Integer(p.getProNo()).toString());
				pProNameJTF.setText(p.getProName());
				pTNoJTF.setText(new Integer(p.getTeacherNo()).toString());
				pTNameJTF.setText(p.getTeacherName());
				pDepartmentJTF.setText(p.getDepartment());
				pProTypeJCB.setSelectedItem(p.getProType());
				pProFormJCB.setSelectedItem(p.getProForm());
				pProTimeJTF.setText(p.getCreateTime().toString());
				pContentJTA.setText(p.getContent());
				pMemoJTA.setText(p.getMemo());
				pcheckedJCB.setSelectedItem(p.getChecked());
				pPassJCB.setSelectedItem(p.getPass());
//////////////////////////////////////////////////////////////////////////////
///////////////////////设置部分组件为不可更改状态///////////////////////////////////
///////////////////////////////////////////////////////////////////////////
				pProNoJTF.setEditable(false);
				pProNameJTF.setEditable(false);
				pTNoJTF.setEditable(false);
				pTNameJTF.setEditable(false);
				pDepartmentJTF.setEditable(false);
				pProTypeJCB.setEnabled(false);
				pProFormJCB.setEnabled(false);
				pProTimeJTF.setEditable(false);
				pContentJTA.setEditable(false);
				pMemoJTA.setEditable(false);
				pcheckedJCB.setEnabled(false);
				
				this.add(pProNoJTF);
				this.add(pProNameJTF);
				this.add(pTNoJTF);
				this.add(pTNameJTF);
				this.add(pDepartmentJTF);
				this.add(pProTypeJCB);
				this.add(pProFormJCB);
				this.add(pProTimeJTF);
				this.add(pContentJTA);
				this.add(pMemoJTA);
				this.add(pcheckedJCB);
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
						String department = pDepartmentJTF.getText();
						String proType = (String)pProTypeJCB.getSelectedItem();
						String proForm = (String)pProFormJCB.getSelectedItem();
						Timestamp proTime = new Timestamp(new java.util.Date().getTime());
						String content = pContentJTA.getText();
						String memo = pMemoJTA.getText();
						String checked = (String)pcheckedJCB.getSelectedItem();
						String pass = (String)pPassJCB.getSelectedItem();
						Project p = new Project(new Integer(proNo), proName, new Integer(teacherNo), teacherName, 
								department, proType, proForm, proTime, content, memo, checked, pass);
							ProjectDao.passDB(p);
							new SuccessFrame("操作成功");
					}
				});
			}

}


