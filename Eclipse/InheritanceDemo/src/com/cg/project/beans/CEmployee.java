package com.cg.project.beans;

public class CEmployee extends Employee{
	private int totalHours,varPay;

	public CEmployee() {
		super();
	}

	@Override
	public String toString() {
		return "totalHours=" + totalHours + ", varPay=" + varPay;
	}

	public CEmployee(int employeeId, String firstName, String lastName,
			int basicSalary) {
		super(employeeId, firstName, lastName, basicSalary);
		// TODO Auto-generated constructor stub
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public int getVarPay() {
		return varPay;
	}

	public void setVarPay(int varPay) {
		this.varPay = varPay;
	}

	@Override
	public void calculateTotalSalary() {
		varPay=totalHours*3000;
		this.setTotalSalary(this.getBasicSalary()+varPay);
	}
	

}
