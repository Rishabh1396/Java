package com.cg.banking.daoservices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.BankingServicesDownException;

public interface AccountDAO {
	Account add(Account account) throws SQLException, BankingServicesDownException;
	boolean updateDeposit(long accountNo,float amount);
	boolean updateWithdrwal(long accountNo,float amount,int pinNumber);
	boolean transfer(long accountNoTo,long accountNoFrom,float transferAmount,int pinNumber);
	Account findOne(long accountNo);
	ArrayList<Account> findAll();
	ArrayList<Transaction> transHistory(long accountNo); 
}