package com.cg.banking.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args){
		try {
			BankingServicesImpl bankingServicesImpl = new BankingServicesImpl();
			int choice=0;
			while(choice!=9){
				System.out.println("Please select one of the following options:");
				System.out.println("1.Open Account\n2.Deposit Amount\n3.Withdraw Amount\n4.Transfer Funds\n5.View Account Details");
				System.out.println("6.View all accounts\n7.View Transaction History\n8.View Account Status\n");
				Scanner sc = new Scanner(System.in);
				choice = sc.nextInt();
				switch(choice){
				case 1:{
					System.out.println("Choose account type\n1.Savings\n2.Current");
					int ch=sc.nextInt();
					String accountType;
					if(ch==1)
						accountType="Savings";
					else
						accountType="Current";
					System.out.println("Enter the initial Balance: ");
					int initBalance=sc.nextInt();
					bankingServicesImpl.openAccount(accountType, initBalance);
					break;
				}
				case 2:{
					System.out.println("Enter the account number: ");
					long accountNo = sc.nextLong();
					Account account = bankingServicesImpl.getAccountDetails(accountNo);
					System.out.println("Enter the amount to be deposited: ");
					float amount = sc.nextFloat();
					bankingServicesImpl.depositAmount(accountNo, amount);
					break;
				}
				case 3:{

					System.out.println("Enter the account number: ");
					long accountNo = sc.nextLong();
					Account account = bankingServicesImpl.getAccountDetails(accountNo);
					System.out.println("Enter the amount to be withdrawed: ");
					float amount = sc.nextFloat();
					System.out.println("Enter the PIN: ");
					int pinNumber = sc.nextInt();
					bankingServicesImpl.withdrawAmount(accountNo, amount, pinNumber);
					break;	
				}
				case 4:{
					System.out.println("Enter the withdrawee account number: ");
					long accountNoFrom = sc.nextLong();
					Account account = bankingServicesImpl.getAccountDetails(accountNoFrom);
					System.out.println("Enter the amount to be withdrawed: ");
					float transferAmount = sc.nextFloat();
					System.out.println("Enter the PIN: ");
					int pinNumber = sc.nextInt();
					System.out.println("Enter the depositee account number: ");
					long accountNoTo = sc.nextLong();
					account = bankingServicesImpl.getAccountDetails(accountNoTo);
					bankingServicesImpl.fundTransfer(accountNoTo, accountNoFrom, transferAmount, pinNumber);
					break;

				}
				case 5:{
					System.out.println("Enter the account number: ");
					long accountNo = sc.nextLong();
					Account account = bankingServicesImpl.getAccountDetails(accountNo);
					System.out.println("Account No.: "+account.getAccountNo());
					System.out.println("\nAccount Balance: "+account.getAccountBalance());
					System.out.println("\nAccount Type: "+account.getAccountType());
					System.out.println("\nAccount Status: "+account.getStatus());
					break;
				}
				case 6:{
					ArrayList<Account> accounts = bankingServicesImpl.getAllAccountDetails();
					for (int i = 0; i < accounts.size(); i++) {
						System.out.println("Account No.: "+accounts.get(i).getAccountNo());
						System.out.println("\nAccount Balance: "+accounts.get(i).getAccountBalance());
						System.out.println("\nAccount Type: "+accounts.get(i).getAccountType());
						System.out.println("\nAccount Status: "+accounts.get(i).getStatus());
					}
					break;
				}
				case 7:{
					System.out.println("Enter the account number: ");
					long accountNo = sc.nextLong();
					Account account = bankingServicesImpl.getAccountDetails(accountNo);
					ArrayList<Transaction> transactions = bankingServicesImpl.getAccountAllTransaction(accountNo);
					for (int i = 0; i < transactions.size(); i++) {
						System.out.println("TransactionId: "+transactions.get(i).getTransactionId());
						System.out.println("\nTransaction Type: "+transactions.get(i).getTransactionType());
						System.out.println("\nTransaction Amount: "+transactions.get(i).getAmount());
					}
					break;
				}
				case 8:{
					System.out.println("Enter the account number: ");
					long accountNo = sc.nextLong();
					Account account = bankingServicesImpl.getAccountDetails(accountNo);
					System.out.println("Account status: "+bankingServicesImpl.accountStatus(accountNo));
				}
				}
			}
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (InvalidAccountTypeException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (BankingServicesDownException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.err.println("Account doesn't exist.");
			System.out.println(e.getMessage());
		} catch (AccountBlockedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (InvalidPinNumberException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}	
	}
}
