
package com.nissan.model;


import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer")

public class Customer {

	
	@Id
	@Column(name = "AccountNo")
	private Integer AccountNo;

	@Column(name = "CustomerName", nullable = false, length = 60)
	private String CustomerName;

	@Column(name = "AccountType", nullable = false, length = 60)
	private String AccountType;
	
	@Column(name = "Balance")
	private Integer Balance;
	
	@Column(name = "MininumBalance")
	private Integer MininumBalance;
	
	@Column(name = "MobileNumber", nullable = false, length = 60)
	private String MobileNumber;
	
	@Column(name="pan",nullable = true, length = 60)
	private String pan;
	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	@Override
	public String toString() {
		return "Customer [AccountNo=" + AccountNo + ", CustomerName=" + CustomerName + ", AccountType=" + AccountType
				+ ", Balance=" + Balance + ", MininumBalance=" + MininumBalance + ", MobileNumber=" + MobileNumber
				+ ", EmailId=" + EmailId + ", ATMPin=" + ATMPin + ", isActive=" + isActive + "]";
	}

	@Column(name = "EmailId", nullable = false, length = 60)
	private String EmailId;
	
	@Column(name = "ATMPin")
	private Integer ATMPin;
	
	
	
	//check the status of customer
	private boolean isActive=true;
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Customer(Integer accountNo, String customerName, String accountType, Integer balance, Integer mininumBalance,
			String mobileNumber, String emailId, Integer aTMPin, Integer depositAmt, Integer withdarwAmt,
			boolean isActive) {
		super();
		AccountNo = accountNo;
		CustomerName = customerName;
		AccountType = accountType;
		Balance = balance;
		MininumBalance = mininumBalance;
		MobileNumber = mobileNumber;
		EmailId = emailId;
		ATMPin = aTMPin;
		this.isActive = isActive;
	}

	
	




	public Integer getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(Integer accountNo) {
		Random r = new Random();
		this.AccountNo=100000000+r.nextInt(900000000);
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public Integer getBalance() {
		return Balance;
	}

	public void setBalance(Integer balance) {
		Balance = balance;
	}

	public Integer getMininumBalance() {
		return MininumBalance;
	}

	public void setMininumBalance(Integer mininumBalance) {
		MininumBalance = mininumBalance;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public Integer getATMPin() {
		return ATMPin;
	}

	public void setATMPin(Integer aTMPin) {
		Random r = new Random();
		this.ATMPin=100000000+r.nextInt(900000000);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

	
}