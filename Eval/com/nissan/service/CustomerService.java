package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Customer;
import com.nissan.repository.ICustomerRepository;
@Service

public class CustomerService implements ICustomerInterface {
	
	@Autowired
	private ICustomerRepository custrepo;

	@Transactional
	public void Deposit(int acno, int amt) {
		 custrepo.deposit(acno, amt);
		/*List<Customer> c= (List<Customer>) custrepo.findAll();
		for(Customer c1:c)
		{
			if(c1.getAccountNo()==acno)
			{	int b= c1.getBalance()+amt;
				c1.setBalance(b);
			}
		}
		*/
		
		
		
		
		
	}
	@Transactional	
	public void Withdraw(int acno, int amt) {
		int balance=custrepo.balance(amt);
		int avibalance=custrepo.aviBalance(amt);
		if(avibalance>balance-amt)
		custrepo.withdraw(acno,amt);
	}

		
	public int ShowBalance(int acno) {
		return custrepo.showBalance(acno);
	}
	@Transactional
	public void Transfer(int acno, int acno2,int amt) {
	 custrepo.transfer(acno, amt);
	}
	
	

}
