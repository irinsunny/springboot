package com.nissan.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.nissan.model.Customer;

public interface IAdminService {

	//display customer
	public List<Customer> Display();
	//display customer using account no
	public Customer DisplaybyAccountNo(int acno);
	//update customer details or add details
	public Customer saveCustomer(Customer cutomer);
	//delete employee
	public void deleteCustomer(int acno);
	
}
