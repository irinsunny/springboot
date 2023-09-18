package com.nissan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
	@Modifying
	@Query("UPDATE Customer c SET c.Balance = c.Balance + :depositAmt WHERE c.AccountNo = :accountNo")
	public void deposit(@Param("accountNo") int accountNo, @Param("depositAmt") int depositAmt);

	@Modifying
	@Query("UPDATE Customer c SET c.Balance = c.Balance - :withdrawAmt WHERE c.AccountNo = :accountNo") 
	public void withdraw(@Param("accountNo") int accountNo, @Param("withdrawAmt") int withdrawAmt);
	
	@Query("SELECT c.balance FROM Customer c WHERE c.accountNo=:accno")
	public int balance(@Param("accno")long accno);

	@Query("SELECT c.minBalance FROM Customer c WHERE c.accountNo=:accno")
	public int aviBalance(@Param("accno")long accno);

	@Query("SELECT Balance FROM com.nissan.model.Customer WHERE AccountNo=?1")
	public int showBalance(int AccountNo);


}
