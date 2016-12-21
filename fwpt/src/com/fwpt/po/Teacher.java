package com.fwpt.po;

public class Teacher {
	private Integer tid;
	private String name;
	private String number;
	private String password;
	private String sxe;
	//职称
	private String title;
	//所在的学院
	private String academe;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(Integer tid, String name, String number, String password, String sxe, String title, String academe) {
		super();
		this.tid = tid;
		this.name = name;
		this.number = number;
		this.password = password;
		this.sxe = sxe;
		this.title = title;
		this.academe = academe;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
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
	public String getSxe() {
		return sxe;
	}
	public void setSxe(String sxe) {
		this.sxe = sxe;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAcademe() {
		return academe;
	}
	public void setAcademe(String academe) {
		this.academe = academe;
	}
	
}
