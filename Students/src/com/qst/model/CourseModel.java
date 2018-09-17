package com.qst.model;

public class CourseModel {

	private String cno;
	private String cname;
	private int ccredit;
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCcredit() {
		return ccredit;
	}
	public void setCcredit(int ccredit) {
		this.ccredit = ccredit;
	}
	@Override
	public String toString() {
		return "CourseModel [cno=" + cno + ", cname=" + cname + ", ccredit=" + ccredit + "]";
	}
	
	
}
