package com.qst.model;

public class ScoreModel {

	private String sno;
	private String cno;
	private  int grade;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "ScoreModel [sno=" + sno + ", cno=" + cno + ", grade=" + grade + "]";
	}
	
	
}
