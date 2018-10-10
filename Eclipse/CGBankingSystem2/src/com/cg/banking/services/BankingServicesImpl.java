package com.cg.banking.services;
import java.sql.SQLException;
import java.util.List;

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
			e.printStackTrace();
			throw new BankingServicesDownException("Server Down", e);
		}
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		Account account=accountDAO.findOne(accountNo);
		if(account.getAccountNo()==accountNo)
		accountDAO.updateDeposit(accountNo, amount);
		else
			throw AccountNotFoundException("Account doesn't Exist",);
		return 0;
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		accountDAO.updateWithdrwal(accountNo, amount, pinNumber);
		return 0;
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		accountDAO.transfer(accountNoTo, accountNoFrom, transferAmount, pinNumber);
		return false;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		// TODO Auto-generated method stub
		return accountDAO.findOne(accountNo);
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		// TODO Auto-generated method stub
		return accountDAO.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		// TODO Auto-generated method stub
		return accountDAO.transHistory(accountNo);
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account account = accountDAO.findOne(accountNo);
		// TODO Auto-generated method stub
		return account.getStatus();
	}

}
