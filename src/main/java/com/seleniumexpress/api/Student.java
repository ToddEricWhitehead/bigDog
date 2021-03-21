package com.seleniumexpress.api;

public class Student {

	private int roolno;
	private String name;
	private String address;
	
	public int getRoolno() {
		return roolno;
	}
	public void setRoolno(int roolno) {
		this.roolno = roolno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [roolno=" + roolno + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
