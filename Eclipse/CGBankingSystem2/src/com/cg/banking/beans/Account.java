package com.cg.banking.beans;

public class Account {
	private int pinNumber;
	private String accountType,status;
	private float accountBalance;
	private long accountNo;
	public int getPinNumber() {
		return pinNumber;
	}
	public Account(String accountType, float accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public Account(int pinNumber, String accountType, String status,
			float accountBalance, long accountNo) {
		super();
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
	}
	public Account(String accountType, String status, float accountBalance,
			long accountNo) {
		super();
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
	}	

}