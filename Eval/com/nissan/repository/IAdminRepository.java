package com.nissan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;
@Repository
public interface IAdminRepository extends CrudRepository<Customer, Integer> {
	@Modifying
	@Query("UPDATE Customer c SET c.isActive='false' WHERE c.AccountNo=:accountNo")
	public void deletecustomer(@Param("accountNo") int accountNo);


}
