package com.cg.project.main;

import com.cg.project.beans.CEmployee;
import com.cg.project.beans.Employee;
import com.cg.project.beans.PEmployee;

public class MainClass {

	public static void main(String[] args) {
		//Employee employee//=new Employee(101, "Rishabh", "Gupta", 40000);
		//employee.calculateTotalSalary();
		PEmployee pemp=new PEmployee(102, "Rishabh", "Tandon", 40000);
		CEmployee cemp=new CEmployee(103, "Vivek", "Singla", 40000);
		cemp.setTotalHours(90);
		System.out.println(pemp.getTotalSalary());
		pemp.calculateTotalSalary();
		cemp.calculateTotalSalary();
		System.out.println(pemp.getTotalSalary());
		//System.out.println(employee.toString());
		System.out.println(pemp.toString());
		System.out.println(cemp.toString());
		//System.out.println(employee.toString()+", "+pemp.toString()+", "+cemp.toString());
		Employee emp=new PEmployee(101, "Rishabh", "Gupta", 40000);
		emp.calculateTotalSalary();
		System.out.println(emp.getTotalSalary());
		

	}


}
