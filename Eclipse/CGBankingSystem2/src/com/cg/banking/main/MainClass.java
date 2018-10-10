package com.cg.banking.main;

import java.util.Scanner;

import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args) {
		BankingServicesImpl bankingServicesImpl = new BankingServicesImpl();
		int choice=0;
		while(choice!=9){
			System.out.println("Please select one of the following options:\n");
			System.out.println("1.Open Account\n2.Deposit Amount\n3.Withdraw Amount\n4.Transfer Funds\n5.View Account Details\n");
			System.out.println("6.View all accounts\n7.View Transaction History\n8.View Account Status\n");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch(choice){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			}
		}	
	}
}
