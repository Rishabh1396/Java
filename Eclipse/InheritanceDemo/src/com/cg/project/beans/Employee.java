package com.cg.project.beans;

public abstract class Employee {
	private int employeeId;
	private String firstName,lastName;
	private int basicSalary,totalSalary;
	public Employee() {
		super();
	}
	
	public Employee(int employeeId, String firstName, String lastName,
			int basicSalary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.basicSalary = basicSalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}
	public void calculateTotalSalary(){
		this.totalSalary=basicSalary;
	}

	@Override
	public String toString() {
		return "employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", basicSalary="
				+ basicSalary + ", totalSalary=" + totalSalary;
	}
	

}
