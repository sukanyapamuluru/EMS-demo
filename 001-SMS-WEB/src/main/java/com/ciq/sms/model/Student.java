package com.ciq.sms.model;

public class Student {
	
	private int SID;
	private String SNAME;
	private double SFEE;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sID, String sNAME, double sFEE) {
		super();
		SID = sID;
		SNAME = sNAME;
		SFEE = sFEE;
	}

	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public double getSFEE() {
		return SFEE;
	}
	public void setSFEE(double sFEE) {
		SFEE = sFEE;
	}
	

}
