package com.ltp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ltp.dao.TeacherDao;

/**
 * 删除教师信息的窗口
 *
 */
public class DeleteTeacherInfoFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteTeacherInfoFrame(String title) {
		this.setTitle(title);
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
		
		Font font = new Font("微软雅黑", 1, 15);

////////////////////////////////////////////////////////////////////////////
///////////////////////添加组件///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		final JLabel tNoJL = new JLabel("教师编号：");
		tNoJL.setFont(font);
		tNoJL.setForeground(Color.blue);
		tNoJL.setBounds(50, 50, 100, 30);
		final JTextField tNoJTF = new JTextField();
		tNoJTF.setBounds(150,  50,  200,  30);
		
		//查询按钮
		JButton deleteBtn = new JButton("删除");
		deleteBtn.setBounds(160,  100,  80,  35);
		deleteBtn.setBackground(Color.blue);
		deleteBtn.setForeground(Color.white);
		
		this.add(tNoJL);
		this.add(tNoJTF);
		this.add(deleteBtn);
		this.setVisible(true);
////////////////////////////////////////////////////////////////////////////
///////////////////////为按钮绑定事件//////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		deleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int no = new Integer(tNoJTF.getText());
				boolean deleteState = TeacherDao.deleteDB(no);
				if(deleteState == true) {
					new SuccessFrame("删除教师信息成功!");
				} else {
					new ErrorFrame("删除教师信息失败");
				}
			}
		});
	}

}
