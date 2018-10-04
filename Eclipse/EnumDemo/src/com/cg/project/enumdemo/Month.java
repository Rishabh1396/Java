package com.cg.project.enumdemo;

import org.omg.CORBA.PRIVATE_MEMBER;

public enum Month {
	JAN(1,"Jan"),
	FEB(2,"Feb"),
	MARCH(3,"March"),
	APRIL(4,"April"),
	MAY(5,"May");
	
	private int monthIndex;
	private String monthName;
	
	private Month() {}
	private Month(int monthIndex,String monthName){
		this.monthIndex=monthIndex;
		this.monthName=monthName;
	}
	public int getMonthIndex() {
		return monthIndex;
	}
	public void setMonthIndex(int monthIndex) {
		this.monthIndex = monthIndex;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	

}
