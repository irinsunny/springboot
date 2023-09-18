package com.nissan.service;

import com.nissan.model.Customer;

public interface ICustomerInterface {
	public void Deposit(int acno ,int amt);

	public  void Withdraw(int acno,int amt);
	
	public  int ShowBalance(int acno);


	public void Transfer(int accountNo, int amount);
}
