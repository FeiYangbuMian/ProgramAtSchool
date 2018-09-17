package com.qst.model;

public class UserStudent {

	private String sno;
	private String sname;
	private String spass;
	private int ssex;
	private int sage;
	private String sdept;
	
	public UserStudent() {
		
	}
	
	
	public UserStudent(String sno, String sname, String spass,int ssex, int sage, String sdept) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.spass = spass;
		this.ssex = ssex;
		this.sage = sage;
		this.sdept = sdept;
	}
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	public int getSsex() {
		return ssex;
	}
	public void setSsex(int ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}


	@Override
	public String toString() {
		return "UserStudent [sno=" + sno + ", sname=" + sname + ", spass=" + spass + ", ssex=" + ssex + ", sage=" + sage
				+ ", sdept=" + sdept + "]";
	}
	
	
}
