package com.qst.model;

public class UserTeacher {

	private String tno;
	private String tname;
	private int tsex;
	private String tpass;
	private String tdept;
	
	
	public UserTeacher() {
		
	}
	public UserTeacher(String tno, String tname, int tsex, String tpass, String tdept) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tsex = tsex;
		this.tpass = tpass;
		this.tdept = tdept;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTsex() {
		return tsex;
	}
	public void setTsex(int tsex) {
		this.tsex = tsex;
	}
	public String getTpass() {
		return tpass;
	}
	public void setTpass(String tpass) {
		this.tpass = tpass;
	}
	public String getTdept() {
		return tdept;
	}
	public void setTdept(String tdept) {
		this.tdept = tdept;
	}
	
	@Override
	public String toString() {
		return "UserTeacher [tno=" + tno + ", tname=" + tname + ", tsex=" + tsex + ", tpass=" + tpass + ", tdept="
				+ tdept + "]";
	}
	
	
}
