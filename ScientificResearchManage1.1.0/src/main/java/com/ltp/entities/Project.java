package com.ltp.entities;

import java.sql.Timestamp;

public class Project {
	/**
	 * 项目编号
	 */
	private int proNo;

	/**
	 * 项目名称
	 */
	private String proName;

	/**
	 * 教师编号
	 */
	private int teacherNo;

	/**
	 * 教师姓名
	 */
	private String teacherName;

	/**
	 * 院系
	 */
	private String department;

	/**
	 * 项目类型
	 */
	private String proType;

	/**
	 * 项目形式
	 */
	private String proForm;

	/**
	 * 项目申报时间
	 */
	private Timestamp createTime;

	/**
	 * 项目内容
	 */
	private String content;

	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 是否被审核
	 */
	private String checked;

	/**
	 * 是否被验收
	 */
	private String pass;
	
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Project(int proNo, String proName, int teacherNo,
			String teacherName, String department, String proType, String proForm,
				   Timestamp createTime, String content, String memo, String checked,
			String pass) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.department = department;
		this.proType = proType;
		this.proForm = proForm;
		this.createTime = createTime;
		this.content = content;
		this.memo = memo;
		this.checked = checked;
		this.pass = pass;
	}
	

}
