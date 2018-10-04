package com.cg.project.HasADemo.beans;

public class MainClass {

	public static void main(String[] args) {
		Address address = new Address("Pune","Maharashtra","India",4012011);
		Customer customer=new Customer(101,"Rishabh","Gupta",address);
		System.out.println(customer.getAddress().getCity());
	}

}
