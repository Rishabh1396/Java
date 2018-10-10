package com.cg.banking.daoservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.util.ConnectionProvider;

public class AccountDAOImpl implements AccountDAO {
	private static Connection conn = ConnectionProvider.getDBConnection();

	@Override
	public Account add(Account account) throws SQLException, BankingServicesDownException {
		// TODO Auto-generated method stub
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt1 = conn.prepareStatement("insert into Account(accountNo,accountType,pinNumber,accountBalance,status) values(ACCNO_SEQ.nextval,?,PINNO_SEQ.nextval,?,?)");
			pstmt1.setString(1, account.getAccountType());
			pstmt1.setFloat(2, account.getAccountBalance());
			pstmt1.setString(3, "Active");
			pstmt1.executeUpdate();
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
	public boolean updateDeposit(long accountNo, float amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWithdrwal(long accountNo, float amount, int pinNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transfer(long accountNoTo, long accountNoFrom,
			float transferAmount, int pinNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account findOne(long accountNo) {
		try {
			PreparedStatement pstmt1=conn.prepareStatement("select * from Account where accountNo=?");
			pstmt1.setLong(1, accountNo);
			ResultSet accountRS = pstmt1.executeQuery();
			if(accountRS.next());
			Account account=new Account(accountRS.getInt("pinNumber"),accountRS.getString("accountType"),accountRS.getString("status"),accountRS.getFloat("accountBalance"),accountRS.getLong("accountNO"));
			else
				throw AccountNotFoundException;
			// TODO Auto-generated method stub
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Transaction> transHistory(long accountNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
