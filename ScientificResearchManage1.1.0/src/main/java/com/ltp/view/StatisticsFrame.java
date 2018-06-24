package com.ltp.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ltp.dao.ProjectCountDao;

/**
 * 统计窗口
 * @author Z7M-SL7D2
 *
 */
public class StatisticsFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public StatisticsFrame(String title, String str) {
		this.setTitle(title);
		this.setSize(350, 200);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JLabel proCountJL = new JLabel(str);
		proCountJL.setBounds(50, 50, 100, 25);
		JTextField proCountJTF = new JTextField();
		proCountJTF.setBounds(150, 50, 100, 25);
		
		int proCount = ProjectCountDao.getProjectCountDB();
		
		proCountJTF.setText(new Integer(proCount).toString());
		proCountJTF.setEditable(false);
		this.add(proCountJL);
		this.add(proCountJTF);
		this.setVisible(true);
	}
}
