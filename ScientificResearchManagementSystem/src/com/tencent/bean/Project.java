package com.tencent.bean;

/**
 * project类
 *
 */
public class Project {
	int proNo;
	String proName;
	int teacherNo;
	String teacherName;
	String yuanXi;
	String proType;
	String proForm;
	long proTime;
	String proText;
	String memo;
	String checking;
	String pass;
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
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
	public String getYuanXi() {
		return yuanXi;
	}
	public void setYuanXi(String yuanXi) {
		this.yuanXi = yuanXi;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getProForm() {
		return proForm;
	}
	public void setProForm(String proForm) {
		this.proForm = proForm;
	}
	public long getProTime() {
		return proTime;
	}
	public void setProTime(long proTime) {
		this.proTime = proTime;
	}
	public String getProText() {
		return proText;
	}
	public void setProText(String proText) {
		this.proText = proText;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getChecking() {
		return checking;
	}
	public void setChecking(String checking) {
		this.checking = checking;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Project(int proNo, String proName, int teacherNo,
			String teacherName, String yuanXi, String proType, String proForm,
			long proTime, String proText, String memo, String checking,
			String pass) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.yuanXi = yuanXi;
		this.proType = proType;
		this.proForm = proForm;
		this.proTime = proTime;
		this.proText = proText;
		this.memo = memo;
		this.checking = checking;
		this.pass = pass;
	}
	

}
