package com.cg.banking.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAOImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices {
	AccountDAOImpl accountDAO = new AccountDAOImpl();
	static int counter=0;

	@Override
	public long openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		// TODO Auto-generated method stub
		try {
			Account account = new Account(accountType, initBalance);
			account=accountDAO.add(account);
			return account.getAccountNo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new BankingServicesDownException("Server Down");
		}
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		try {
			Account account=accountDAO.findOne(accountNo);
			if(account!=null){
			accountDAO.updateDeposit(accountNo, amount);
			return amount;
			}
			else 
				throw new AccountNotFoundException("Account doesn't exist.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new BankingServicesDownException("Server down.");
		}catch (AccountNotFoundException e) {
			// TODO: handle exception
			throw new AccountNotFoundException("Account doesn't exist.");
		}
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		try {
			Account account=accountDAO.findOne(accountNo);
			if(account!=null){
				if(account.getPinNumber()==pinNumber){
					counter=0;
					if(account.getAccountBalance()>amount)
						accountDAO.updateWithdrwal(accountNo, amount, pinNumber);
					else
						throw new InsufficientAmountException();
				}
				else{
					while(counter<3 && account.getPinNumber()!=pinNumber){
						counter++;
						Scanner sc = new Scanner(System.in);
						System.out.println("You have entered wrong PIN. Enter the PIN again:");
						pinNumber=sc.nextInt();
						sc.close();
					}
					if(account.getPinNumber()==pinNumber)
						counter=0;
					if(counter>=3){
						accountDAO.updateStatus(accountNo, "Blocked");
						throw new InvalidPinNumberException();
					}
					
				}
			}
			else
				throw new AccountNotFoundException();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new BankingServicesDownException("Server down.");
		} catch (AccountNotFoundException e) {
			// TODO: handle exception
			throw new AccountNotFoundException("Account doesn't exist.");
		} catch (InvalidPinNumberException e){
			throw new InvalidPinNumberException("Wrong PIN.");
		} catch (InsufficientAmountException e) {
			// TODO: handle exception
			throw new InsufficientAmountException("Not Enough Balance.");
		}
		
		return 0;
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		try {
			Account account=accountDAO.findOne(accountNoFrom);
			if(account!=null){
				if(account.getPinNumber()==pinNumber){
					counter=0;
					if(account.getAccountBalance()>transferAmount);
					else
						throw new InsufficientAmountException();
				}
				else {
					while(counter<3 && account.getPinNumber()!=pinNumber){
						counter++;
						Scanner sc = new Scanner(System.in);
						System.out.println("You have entered wrong PIN. Enter the PIN again:");
						pinNumber=sc.nextInt();
						sc.close();
					}
					if(account.getPinNumber()==pinNumber)
						counter=0;
					if(counter>=3){
						accountDAO.updateStatus(accountNoFrom, "Blocked");
						throw new InvalidPinNumberException();
					}
					
				}
			}
			else 
				throw new AccountNotFoundException();
			Account account2=accountDAO.findOne(accountNoTo);
			if(account2!=null)
			accountDAO.transfer(accountNoTo, accountNoFrom, transferAmount, pinNumber);
			else 
				throw new AccountNotFoundException();
			return false;
		}catch(SQLException e){
			throw new BankingServicesDownException("Server down.");
		}
		catch (AccountNotFoundException e) {
			// TODO: handle exception
			throw new AccountNotFoundException("Account doesn't exist.");
		}catch (InsufficientAmountException e) {
			// TODO: handle exception
			throw new InsufficientAmountException("Not enough funds.");
		}catch (InvalidPinNumberException e) {
			// TODO: handle exception
			throw new InvalidPinNumberException("Wrong PIN.");
		}
	}

	@Override
	public Account getAccountDetails(long accountNo) throws BankingServicesDownException, AccountNotFoundException  {
		// TODO Auto-generated method stub
		try {
			Account account = accountDAO.findOne(accountNo);
			if(account!=null)
			return account;
			else 
				throw new AccountNotFoundException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new BankingServicesDownException("Server down.");
		}catch (AccountNotFoundException e) {
			// TODO: handle exception
			throw new AccountNotFoundException("Account doesn't exists.");
		}
	}

	@Override
	public ArrayList<Account> getAllAccountDetails() throws BankingServicesDownException, AccountNotFoundException {
		// TODO Auto-generated method stub
		try {
			ArrayList<Account> accounts=accountDAO.findAll();
			if(accounts!=null)
				return accounts;
			else
				throw new AccountNotFoundException("No Records Found.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new BankingServicesDownException("Server Down.");
		}
	}

	@Override
	public ArrayList<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		// TODO Auto-generated method stub
		try {
			return accountDAO.transHistory(accountNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BankingServicesDownException();
		}
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		try {
			Account account = accountDAO.findOne(accountNo);
			// TODO Auto-generated method stub
			if(account!=null)
			return account.getStatus();
			else
				throw new AccountNotFoundException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BankingServicesDownException("Server down.");
		}catch (AccountNotFoundException e) {
			// TODO: handle exception
			throw new AccountNotFoundException("Account doesn't exist.");
		}
	}

}
