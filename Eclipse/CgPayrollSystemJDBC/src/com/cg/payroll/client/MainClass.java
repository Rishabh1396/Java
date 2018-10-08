package com.cg.payroll.client;

import java.io.ObjectInputStream.GetField;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		int num=100;
		//Associate associate1 = new Associate(101, 15000, "Rishabh", "Gupta", "DCX", "Sr. Analyst", "ABC12345", "rishabhgupta@gmail.com");
		//Associate associate2 = new Associate(102, 15000, "Rishabh", "Tandon", "ADM", "Sr. Analyst", "ABC56789", "rishabhtandon@gmail.com");
		//System.out.println("Full Name:"+" "+associate1.getFirstName()+" "+associate1.getLastName());
		//BankDetails bankDetails1 = new BankDetails(563263662, "SBI", "SBIIN48378");
		//BankDetails bankDetails2 = new BankDetails(436357622, "HDFC", "HDFCIN67876");
		//Salary salary = new Salary(101, 600000, 11000, 20000, 60000, 2000, 1000, 2000, 2000, 5000, 50000, 50000);
		//Salary salary2 = new Salary(102, 600000, 11000, 20000, 60000, 2000, 1000, 2000, 2000, 5000, 50000, 50000);
		//System.out.println(Associate.getASSOCIATE_COUNTER());
		/*Associate associate3 = new Associate(101, 15000, "Vivek", "Singla", "ADM", "Sr. Analyst", "BHJ7688798", "vivek@gmail.com",new BankDetails(432423434,"HDFC","HDFC0065876"),new Salary(50000, 1000, 1000, 2000));
		System.out.println(associate3.getSalary().getBasicSalary());
		associate3.getSalary().setHra((int)0.3*associate3.getSalary().getBasicSalary());
		associate3.getSalary().setMonthlyTax((int)0.05*associate3.getSalary().getBasicSalary());
		associate3.getSalary().setConveyenceAllowance((int)0.2*associate3.getSalary().getBasicSalary());
		associate3.getSalary().setOtherAllowance((int)0.2*associate3.getSalary().getBasicSalary());
		associate3.getSalary().setPersonalAllowance((int)0.2*associate3.getSalary().getBasicSalary());
		associate3.getSalary().setGrossSalary(associate3.getSalary().getBasicSalary()+associate3.getSalary().getConveyenceAllowance()+associate3.getSalary().getOtherAllowance()+associate3.getSalary().getPersonalAllowance()+associate3.getSalary().getHra());
		System.out.println(associate3.getSalary().getGrossSalary());
		associate3.getSalary().setNetSalary(associate3.getSalary().getGrossSalary()-associate3.getSalary().getMonthlyTax()-associate3.getSalary().getEpf()-associate3.getSalary().getGratutity()-associate3.getSalary().getCompanyPf());
		System.out.println(associate3.getSalary().getNetSalary());*/
		PayrollServices payrollServices = new PayrollServicesImpl();
		String choice="y";
		/*StringBuilder choice = new StringBuilder('y');**/ 
		Scanner sc = new Scanner(System.in);
		int ch=0;
		
		while(choice.compareToIgnoreCase("y")==0){
			System.out.println("Payroll Services Menu!");
			System.out.println("1. Add Associate Details\n2. Get Total Salary of the employee\n3. Retrieve the details of a specific employee\n4. Retrieve all details");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();
			switch(ch){
			case 1: 
				try {
					System.out.println("Associate details of associate id: " + payrollServices.acceptAssociateDetails("Rishabh", "Gupta", "rishabhgupta@gmail.com", "DCX", "Sr. Analyst", "GAAGG2664F",  100000, 40000, 1000, 1000, 96853256, "ICICI", "ICIC000562") + " added.");	
					System.out.println("Associate details of associate id: " + payrollServices.acceptAssociateDetails("Rishabh", "Tandon", "rishabhtandon@gmail.com", "DCX", "Sr. Analyst", "GJJHGG2664F",  100000, 40000, 1000, 1000, 96853256, "ICICI", "ICIC000562") + " added.");
				} catch (PayrollServicesDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2: 
				try {
					System.out.println("Net Salary: " + payrollServices.calculateNetSalary(101));
					System.out.println("Net Salary: " + payrollServices.calculateNetSalary(102));
				} catch (AssociateDetailsNotFoundException | PayrollServicesDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					printDetails(payrollServices.getAssociateDetails(101));
				} catch (AssociateDetailsNotFoundException | PayrollServicesDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 4:
				try {
					ArrayList<Associate> arr=payrollServices.getAllAssociateDetails();
					int i=0;
					while(i<arr.size()){
					printDetails(arr.get(i));
					i++;
					}
				} catch (PayrollServicesDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			default:
				System.out.println("Enter valid choice");
				break;
			}
			System.out.println("Do you want to continue?");
			choice = sc.next();
		}
		sc.close();
		

	}
	public static void printDetails(Associate associate){
		System.out.println("Associate ID: " + associate.getAssociateID());
		System.out.println("First Name:" + associate.getFirstName());
		System.out.println("Basic Salary: " + associate.getSalary().getBasicSalary());
		System.out.println("HRA: " + associate.getSalary().getHra());
		System.out.println("Other Allowances: " + associate.getSalary().getOtherAllowance());
		System.out.println("Personal Allowances: " + associate.getSalary().getPersonalAllowance());
		System.out.println("Conveyence Allowances: " + associate.getSalary().getConveyenceAllowance());
		System.out.println("EPF: " + associate.getSalary().getEpf());
		System.out.println("Company PF: " + associate.getSalary().getCompanyPf());
		System.out.println("Gratuity: " + associate.getSalary().getGratuity());
		System.out.println("Gross Salary: " + associate.getSalary().getGrossSalary());
		System.out.println("MonthlyTax: " + associate.getSalary().getMonthlyTax());
		System.out.println("Net Salary: " + associate.getSalary().getNetSalary());
		
	}

}
