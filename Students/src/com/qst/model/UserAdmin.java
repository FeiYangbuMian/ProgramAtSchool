package com.qst.model;

public class UserAdmin {

	private String name;
	private String pass;
	private int sex;
	private int tel;
	private String address;
	
	
	public UserAdmin() {
		
	}
	public UserAdmin(String name, String pass, int sex, int tel, String address) {
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserAdmin [name=" + name + ", pass=" + pass + ", sex=" + sex + ", tel=" + tel + ", address=" + address
				+ "]";
	}
	
}
