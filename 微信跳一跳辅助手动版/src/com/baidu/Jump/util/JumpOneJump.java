package com.baidu.Jump.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class JumpOneJump extends JFrame{
	double xSrc, ySrc, xDest, yDest;
	double old_x, old_y;
	String adbc = "D:\\百度云下载\\跳一跳素材\\ADB\\";
	boolean flag = false;
	boolean first = true;
		JumpOneJump(){
			this.setSize(400, 800);
			this.setAlwaysOnTop(true);
			this.setUndecorated(true);
			this.setLocation(200, 100);
			this.setVisible(true);
			this.setOpacity(0.4f);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLabel jl = new JLabel();
			this.add(jl);
			
			this.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					if(e.getButton() == MouseEvent.BUTTON3){
							if(!flag){
								xSrc = e.getX();
								ySrc = e.getY();
								flag = true;
								}else{
									xDest = e.getX();
									yDest = e.getY();
									flag = false;
									double _x = Math.abs(xSrc - xDest);
									double _y = Math.abs(ySrc - yDest);
									double dis = Math.sqrt(_x*_x + _y*_y);
									System.out.println("x = "+(xSrc - xDest));
									System.out.println("y = "+(ySrc - yDest));
									System.out.println("长度: "+dis);
									String cmd = adbc + "adb shell input touchscreen swipe 366 351 366 351 "+(int)(dis*3.9);
									try{
										Runtime.getRuntime().exec(cmd);
									}catch(IOException e1){
										e1.printStackTrace();
							}
								}
					}
				}
				
			});
		}
		public static void main(String[] args) {
			new JumpOneJump();
		}
}
