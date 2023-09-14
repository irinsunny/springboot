package com.nissan.DTO;

public class CustomerDTO {


	
	private int Balance;
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(int balance) {
		super();
		Balance = balance;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	
	
}
