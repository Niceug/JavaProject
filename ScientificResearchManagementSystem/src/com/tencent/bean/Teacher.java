package com.tencent.bean;

/**
 * 教师类
 *
 */
public class Teacher {
	private int teacherNo;
	private String teacherName;
	private String sex;
	private String zhiWu;
	private String zhiCheng;
	private String buMen;
	private String yuanXi;
	private String tel;
	private String location;
	public int getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getZhiWu() {
		return zhiWu;
	}
	public void setZhiWu(String zhiWu) {
		this.zhiWu = zhiWu;
	}
	public String getZhiCheng() {
		return zhiCheng;
	}
	public void setZhiCheng(String zhiCheng) {
		this.zhiCheng = zhiCheng;
	}
	public String getBuMen() {
		return buMen;
	}
	public void setBuMen(String buMen) {
		this.buMen = buMen;
	}
	public String getYuanXi() {
		return yuanXi;
	}
	public void setYuanXi(String yuanXi) {
		this.yuanXi = yuanXi;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Teacher() {
		
	}
	public Teacher(int tNo, String tName, String tSex, String tZhiWu,
			String tZhiCheng, String tBuMen, String tYuanXi, String tTel,
			String tLocation) {
		this.teacherNo = tNo;
		this.teacherName = tName;
		this.sex = tSex;
		this.zhiWu = tZhiWu;
		this.zhiCheng = tZhiCheng;
		this.buMen = tBuMen;
		this.yuanXi = tYuanXi;
		this.tel = tTel;
		this.location = tLocation;
	}
}
