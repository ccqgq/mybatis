package com.fwpt.po;

public class Admin {
	private Integer aid;
	private String number;
	private String password;
	private String name;
	public Admin(Integer aid, String number, String password, String name) {
		super();
		this.aid = aid;
		this.number = number;
		this.password = password;
		this.name = name;
	}
	public Admin() {
		super();
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
