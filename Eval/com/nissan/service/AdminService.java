package com.nissan.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.Validation;
import com.nissan.model.Customer;
import com.nissan.repository.IAdminRepository;
@Service
public class AdminService implements IAdminService {
	@Autowired
	private IAdminRepository adminRepo;
	@Autowired
	private Validation validation;
	@Override
	public List<Customer> Display() {
		// TODO Auto-generated method stub
		return  (List<Customer>) adminRepo.findAll();
	}

	@Override
	public Customer DisplaybyAccountNo(int acno) {
		return  adminRepo.findById(acno).orElseThrow(()-> new
				RuntimeException("customer not found for AccountNo"+acno));
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if(validation.isNameValid(customer.getCustomerName())){
		return adminRepo.save(customer);
	}
	return null;
	}

	@Transactional
	public void deleteCustomer(int acno) {
		adminRepo.deletecustomer(acno);
				
	}

	
}
