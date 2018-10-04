package com.cg.project.beans;

public class PEmployee extends Employee{
	private int hra,ta,da;

	public PEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public PEmployee(int employeeId, String firstName, String lastName,
			int basicSalary) {
		super(employeeId, firstName, lastName, basicSalary);
		// TODO Auto-generated constructor stub
	}



	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getTa() {
		return ta;
	}

	public void setTa(int ta) {
		this.ta = ta;
	}

	public int getDa() {
		return da;
	}

	public void setDa(int da) {
		this.da = da;
	}

	@Override
	public void calculateTotalSalary() {
		hra=(this.getBasicSalary()*10)/100;
		da=(this.getBasicSalary()*10)/100;
		ta=(this.getBasicSalary()*10)/100;
		this.setTotalSalary(this.getBasicSalary()+hra+da+ta);
	}



	@Override
	public String toString() {
		return "hra=" + hra + ", ta=" + ta + ", da=" + da;
	}
	

}
