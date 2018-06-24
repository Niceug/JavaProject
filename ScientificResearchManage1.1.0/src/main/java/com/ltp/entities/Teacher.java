package com.ltp.entities;

/**
 * 教师类
 *
 */
public class Teacher {
	/**
	 * 教师编号
	 */
	private int teacherNo;

	/**
	 * 教师姓名
	 */
	private String teacherName;

	/**
	 * 教师性别
	 */
	private String sex;

	/**
	 * 担任职务
	 */
	private String job;

	/**
	 * 教师职称
	 */
	private String rank;

	/**
	 * 所在部门
	 */
	private String office;

	/**
	 * 所在院系
	 */
	private String department;

	/**
	 * 联系方式
	 */
	private String tel;

	/**
	 * 住址
	 */
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public Teacher() {}

	public Teacher(int teacherNo, String teacherName, String sex,
				   String job, String rank, String office,
				   String department, String tel, String location) {
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.sex = sex;
		this.job = job;
		this.rank = rank;
		this.office = office;
		this.department = department;
		this.tel = tel;
		this.location = location;
	}
}
