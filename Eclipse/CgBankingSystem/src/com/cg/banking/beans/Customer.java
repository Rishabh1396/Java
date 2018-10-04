package com.cg.banking.beans;

public class Customer {
	private int customerID,mobileNo,adharNo;
	private String firstName,lastName,emailId,pancardNo,dateOfBirth;
	public Customer() {
		super();
	}
	public Customer(int customerID, int mobileNo, int adharNo,
			String firstName, String lastName, String emailId,
			String pancardNo, String dateOfBirth) {
		super();
		this.customerID = customerID;
		this.mobileNo = mobileNo;
		this.adharNo = adharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.pancardNo = pancardNo;
		this.dateOfBirth = dateOfBirth;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(int adharNo) {
		this.adharNo = adharNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPancardNo() {
		return pancardNo;
	}
	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
