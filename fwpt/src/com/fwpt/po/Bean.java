package com.fwpt.po;

public class Bean {
	private String number;
	private String name;
	private Integer  begin;
	private Integer limit;
	public Bean(String number, String name, Integer begin, Integer limit) {
		super();
		this.number = number;
		this.name = name;
		this.begin = begin;
		this.limit = limit;
	}
	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
}
