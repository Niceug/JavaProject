package com.baidu.studentmanage;

public class Student {
    private int stuNum;//学号
    private String stuName;//姓名
    private String stuClass;//班级
    private String stuProfessional;//专业
    public Student() {
    }
    public Student(int stuNum, String stuName, String stuClass,
                   String stuProfessional) {
        super();
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuClass = stuClass;
        this.stuProfessional = stuProfessional;
    }
    public int getStuNum() {
        return stuNum;
    }
    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }
    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getStuClass() {
        return stuClass;
    }
    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }
    public String getStuProfessional() {
        return stuProfessional;
    }
    public void setStuProfessional(String stuProfessional) {
        this.stuProfessional = stuProfessional;
    }
    public void showStuInfo() {
        System.out.println("学号：" + this.stuNum);
        System.out.println("姓名：" + this.stuName);
        System.out.println("班级：" + this.stuClass);
        System.out.println("专业：" + this.stuProfessional);
    }
    public static void main(String[] args) {
        Student stu1 = new Student(102, "李天鹏", "计科1502班", "计算机专业");
        stu1.showStuInfo();
    }

}
