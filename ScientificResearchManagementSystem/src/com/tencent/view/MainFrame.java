package com.tencent.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.table.TableColumn;

import com.tencent.bean.Project;
import com.tencent.dao.ProjectDao;

/**
 * 主窗口
 *
 */
public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MainFrame(String title) {
		
		this.getContentPane().setBackground(new Color(62, 148, 254));
		this.setTitle(title);
		this.setSize(1500, 1000);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件、、、//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		//标题
		Font f = new Font("微软雅黑", Font.BOLD, 50);
		
		JLabel headJL = new JLabel("科研管理系统");
		headJL.setFont(f);
		headJL.setForeground(Color.white);
		headJL.setBounds(600, 20, 500, 100);
		
		//左边的按钮区域
		JButton teacherBtn = new JButton("教师信息管理");
		teacherBtn.setBounds(20, 200, 150, 50);
		
		JButton showAllBtn = new JButton("项目总览");
		showAllBtn.setBounds(20, 300, 150, 50);
		
		JButton CheckedBtn = new JButton("已审核项目");
		CheckedBtn.setBounds(20, 400, 150, 50);
		
		JButton countBtn = new JButton("统计");
		countBtn.setBounds(20, 500, 150, 50);
		
		JButton unCheckedBtn = new JButton("未审核项目");
		unCheckedBtn.setBounds(20, 600, 150, 50);
		
		JButton countYuanXiBtn = new JButton("各院系申报及审核情况");
		countYuanXiBtn.setBounds(20, 700, 150, 50);
		
		JButton exitBtn = new JButton("退出");
		exitBtn.setBounds(20, 800, 150, 50);
		
		//右边的显示区域
		final JPanel jp = new JPanel();
		jp.setBounds(200,  170, 1250, 750);
		jp.setBackground(Color.white);
		jp.setLayout(null);
		
		final String[] str = {"项目编号", "项目名称", "教师编号", "姓名", "院系", "项目类型", "项目形式", "时间", "内容", "备注", "是否审批", "是否验收"};
		final String [][] cstr = new String[20][12];
		List<Project> list = ProjectDao.queryAllDB(); 
		updateTable(list, cstr, str, jp);
		
		JButton previousBtn = new JButton("上一页");
		previousBtn.setBounds(500,  720,  80,  25);
		
		JButton updateBtn = new JButton("刷新");
		updateBtn.setBounds(600,  720,  80,  25);
		
		JButton nextBtn = new JButton("下一页");
		nextBtn.setBounds(700,  720,  80,  25);
		
		jp.add(previousBtn);
		jp.add(updateBtn);
		jp.add(nextBtn);
		
		
		this.add(headJL);
		this.add(teacherBtn);
		this.add(unCheckedBtn);
		this.add(CheckedBtn);
		this.add(countBtn);
		this.add(showAllBtn);
		this.add(countYuanXiBtn);
		this.add(exitBtn);
		this.add(jp);
		this.setVisible(true);
		
////////////////////////////////////////////////////////////////////////////
///////////////////////为按钮绑定事件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		//刷新按钮
		updateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Project> list = ProjectDao.queryAllDB(); 
				updateTable(list, cstr, str, jp);
			}
		});
		
		//项目总览按钮
		showAllBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Project> list = ProjectDao.queryAllDB(); 
				updateTable(list, cstr, str, jp);
			}
		});
		
		//已审核项目按钮
		CheckedBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Project> list = ProjectDao.queryCheckedDB(); 
				updateTable(list, cstr, str, jp);
			}
		});
		
		//教师信息管理按钮
		teacherBtn.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new TeacherInfoManageFrame("教师信息管理");
			};
		}
		);
		
		//未审核项目管理按钮
		unCheckedBtn.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new ScientificManageFrame("科研项目管理");
			};
		}
		);
		//统计全部验收项目总数
		countBtn.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new StatisticsFrame("统计验收项目总数", "已验收项目总数：");
			};
		}
		);
		
		countYuanXiBtn.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new StatisticsYuanXiFrame();
			};
		}
		);
		
		//退出按钮
		exitBtn.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			};
		}
		);
	}//空参构造函数完
	
	//对表单的操作，更新表单
	public void updateTable(List<Project> list, String [][] cstr, String[] str, JPanel jp) {
		
		//每次都要清空存储数据的二维数据，然后放入从数据库获取的数据；
		for(int j = 0;j<cstr.length;j++){
		     for(int i = 0; i<cstr[0].length; i++) {
		    	 cstr[j][i] = "";
		     }
		}
		
		//对表的赋值操作
		if(list != null) {
			int j = 0;
			for (Project project : list) {
				cstr[j][0] = (new Integer(project.getProNo())).toString();
				cstr[j][1] = project.getProName();
				cstr[j][2] = new Integer(project.getTeacherNo()).toString();
				cstr[j][3] = project.getTeacherName();
				cstr[j][4] = project.getYuanXi();
				cstr[j][5] = project.getProType();
				cstr[j][6] = project.getProForm();
				cstr[j][7] = new Long(project.getProTime()).toString();
				cstr[j][8] = project.getProText();
				cstr[j][9] = project.getMemo();
				cstr[j][10] = project.getChecking();
				cstr[j][11] = project.getPass();
				++j;
			}
			JTable table = new JTable(cstr, str);
			table.setRowHeight(30);
			table.setBounds(10,  10,  1200,  650);
			for(int i = 0; i<12; i++) {
				TableColumn firsetColumn = table.getColumnModel().getColumn(i);
				firsetColumn.setPreferredWidth(100);
				firsetColumn.setMaxWidth(100);
				firsetColumn.setMinWidth(100);
			}
			
			JScrollPane jsp= new JScrollPane(table);
			 jsp.setBounds(10,  10,  1200,  700);
			 jp.add(jsp);
		} else {
			new ErrorFrame("列表为空");
		}
		
	}
    public static void main(String[] args) {
		new MainFrame("科研项目管理系统");
	}
}