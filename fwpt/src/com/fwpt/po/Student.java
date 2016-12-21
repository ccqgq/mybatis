package com.fwpt.po;

public class Student {
	private Integer sid;
	//姓名
	private String name;
	//学号
	private String number;
	//密码
	private String password;
	//性别
	private String sex;
	//专业
	private String speciality;
	//所在的学院
	private String academe;
	//学籍状态
	private String status;
	public Student(Integer sid, String name, String number, String password, String sex, String speciality,
			String academe, String status) {
		super();
		this.sid = sid;
		this.name = name;
		this.number = number;
		this.password = password;
		this.sex = sex;
		this.speciality = speciality;
		this.academe = academe;
		this.status = status;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getAcademe() {
		return academe;
	}
	public void setAcademe(String academe) {
		this.academe = academe;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
