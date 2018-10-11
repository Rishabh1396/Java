package com.cg.banking.daoservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.util.ConnectionProvider;

public class AccountDAOImpl implements AccountDAO {
	private static Connection conn = ConnectionProvider.getDBConnection();

	@Override
	public Account add(Account account) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt1 = conn.prepareStatement("insert into Account(accountNo,accountType,pinNumber,accountBalance,status) values(ACCNO_SEQ.nextval,?,PINNO_SEQ.nextval,?,?)");
			pstmt1.setString(1, account.getAccountType());
			pstmt1.setFloat(2, account.getAccountBalance());
			pstmt1.setString(3, "Active");
			pstmt1.executeUpdate();
			conn.commit();
			return account;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally{
			conn.setAutoCommit(true);
		}
		
	}

	@Override
	public boolean updateDeposit(long accountNo, float amount) throws SQLException{
		// TODO Auto-generated method stub
			conn.setAutoCommit(false);
			PreparedStatement pstmt1 = conn.prepareStatement("update account set accountBalance=? where accountNo="+accountNo);
			Account account = this.findOne(accountNo);
			pstmt1.setFloat(1, account.getAccountBalance()+amount);
			pstmt1.executeUpdate();
			conn.commit();
			PreparedStatement pstmt2 = conn.prepareStatement("insert into transaction(accountNo,transactionId,amount,transactionType) values (?,TRANSID_SEQ.nextval,?,'Deposit')");
			pstmt2.setLong(1, accountNo);
			pstmt2.setFloat(2, amount);
			pstmt2.executeUpdate();
			conn.commit();
			return true;
	}

	@Override
	public boolean updateWithdrwal(long accountNo, float amount, int pinNumber) throws SQLException {
		// TODO Auto-generated method stub
			conn.setAutoCommit(false);
			PreparedStatement pstmt1 = conn.prepareStatement("update account set accountBalance=? where accountNo="+accountNo);
			Account account = this.findOne(accountNo);
			pstmt1.setFloat(1, account.getAccountBalance()-amount);
			pstmt1.executeUpdate();
			conn.commit();
			PreparedStatement pstmt2 = conn.prepareStatement("insert into transaction(accountNo,transactionId,amount,transactionType) values (?,TRANSID_SEQ.nextval,?,'Withdrawl')");
			pstmt2.setLong(1, accountNo);
			pstmt2.setFloat(2, amount);
			pstmt2.executeUpdate();
			conn.commit();
			return true;
	}

	@Override
	public boolean transfer(long accountNoTo, long accountNoFrom,
			float transferAmount, int pinNumber) throws SQLException {
			this.updateWithdrwal(accountNoFrom, transferAmount, pinNumber);
			this.updateDeposit(accountNoTo, transferAmount);
			return true;
		// TODO Auto-generated method stub
	}

	@Override
	public Account findOne(long accountNo) throws SQLException {
			PreparedStatement pstmt1=conn.prepareStatement("select * from Account where accountNo="+accountNo);
			ResultSet accountRS = pstmt1.executeQuery();
			if(accountRS.next()){
			 Account account = new Account(accountRS.getInt("pinNumber"),accountRS.getString("accountType"),accountRS.getString("status"),accountRS.getFloat("accountBalance"),accountRS.getLong("accountNO"));
			 return account;
			}
			else
				return null;
			// TODO Auto-generated method stub 
	}

	@Override
	public ArrayList<Account> findAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Account> accounts = new ArrayList<>();
		PreparedStatement pstmt1 = conn.prepareStatement("select * from account");
		ResultSet accountRS = pstmt1.executeQuery();
		if(accountRS.next()){
		while(accountRS.next()){
			long accountNo = accountRS.getLong("accountNo");
			String status = accountRS.getString("status");
			String accountType = accountRS.getString("accountType");
			float accountBalance = accountRS.getFloat("accountBalance");
			Account account = new Account(accountType, status, accountBalance, accountNo);
			accounts.add(account);
		}
		return accounts;
		}
		else 
			return null;
	}

	@Override
	public ArrayList<Transaction> transHistory(long accountNo) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Transaction> transactions = new ArrayList<>();
		PreparedStatement pstmt1 = conn.prepareStatement("select * from transaction where accountNo="+accountNo);
		ResultSet transactionRS = pstmt1.executeQuery();
		while(transactionRS.next()){
			int transactionId = transactionRS.getInt("transactionId");
			String transactionType = transactionRS.getString("transactionType");
			float amount = transactionRS.getFloat("amount");
			Transaction transaction = new Transaction(transactionId, amount, transactionType);
			transactions.add(transaction);
		}
		return transactions;
	}

	@Override
	public boolean updateStatus(long accountNo,String status) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt1 = conn.prepareStatement("update account set status=? where accountNo="+accountNo);
		pstmt1.setString(1, status);
		return true;
	}

	/*@Override
	public int retrievePinTrials(long accountNo) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt1 = conn.prepareStatement("Select noOfTrials from pintrials where accountNo="+accountNo);
		ResultSet trialsRS = pstmt1.executeQuery();
		return trialsRS.getInt("noOfTrials");
	}

	@Override
	public boolean updatePinTrials(long accountNo, int noOfTrials) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt1 = conn.prepareStatement("update pintrials set noOfTrials=? where accountNo="+accountNo);
		pstmt1.setInt(1,noOfTrials);
		pstmt1.executeUpdate();
		return false;
	}*/
	
}
