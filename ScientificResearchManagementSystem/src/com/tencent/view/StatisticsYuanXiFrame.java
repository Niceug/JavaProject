package com.tencent.view;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.tencent.dao.ProjectCountDao;
import com.tencent.dao.ProjectDao;

public class StatisticsYuanXiFrame  extends JFrame{
	private static final long serialVersionUID = 1L;
	public StatisticsYuanXiFrame() {
		this.setSize(500, 700);
		this.setLayout(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		final JPanel jp = new JPanel();
		jp.setBounds(50,  50, 360, 700);
		jp.setBackground(Color.white);
		jp.setLayout(null);
		
		final String[] str = {"学院", "申报项目总数", "审核项目总数"};
		final String [][] cstr = new String[20][3];
		//查询学院名称
		List<String> list = ProjectDao.getYuanXiNameList();
		updateTable(list, cstr, str, jp);
		
		this.add(jp);
		this.setVisible(true);
	}
	
	public void updateTable(List<String> list, String [][] cstr, String[] str, JPanel jp) {
		//每次都要清空存储数据的二维数据，然后放入从数据库获取的数据；
		for(int j = 0;j<cstr.length;j++){
		     for(int i = 0; i<cstr[0].length; i++) {
		    	 cstr[j][i] = "";
		     }
		}
		
		//对表的赋值操作
		if(list != null) {
			int j = 0;
			for (String yuanXiName : list) {
				cstr[j][0] = yuanXiName;
				Integer count = ProjectCountDao.getProjectCountByYuanXi(yuanXiName);
				cstr[j][1] = count.toString();
				count = ProjectCountDao.getCheckedCountByYuanXi(yuanXiName);
				cstr[j][2] = count.toString();
				++j;
			}
			JTable table = new JTable(cstr, str);
			table.setRowHeight(30);
			table.setBounds(10,  10,  350,  600);
			for(int i = 0; i<3; i++) {
				TableColumn firsetColumn = table.getColumnModel().getColumn(i);
				firsetColumn.setPreferredWidth(100);
				firsetColumn.setMaxWidth(100);
				firsetColumn.setMinWidth(100);
			}
			
			JScrollPane jsp= new JScrollPane(table);
			 jsp.setBounds(10,  10,  350,  600);
			 jp.add(jsp);
		} else {
			new ErrorFrame("列表为空");
		}
		
	}
}
