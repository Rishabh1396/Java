package com.cg.banking.daoservices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;

public interface AccountDAO {
	Account add(Account account) throws SQLException, BankingServicesDownException;
	boolean updateDeposit(long accountNo,float amount) throws SQLException, AccountNotFoundException, BankingServicesDownException;
	boolean updateWithdrwal(long accountNo,float amount,int pinNumber) throws AccountNotFoundException, BankingServicesDownException, SQLException;
	boolean transfer(long accountNoTo,long accountNoFrom,float transferAmount,int pinNumber) throws SQLException;
	Account findOne(long accountNo) throws AccountNotFoundException, BankingServicesDownException, SQLException;
	ArrayList<Account> findAll() throws SQLException;
	ArrayList<Transaction> transHistory(long accountNo) throws SQLException;
/*	int retrievePinTrials(long accountNo) throws SQLException;
	boolean updatePinTrials(long accountNo,int noOfTrials) throws SQLException;*/
	boolean updateStatus(long accountNo,String status) throws SQLException;
}