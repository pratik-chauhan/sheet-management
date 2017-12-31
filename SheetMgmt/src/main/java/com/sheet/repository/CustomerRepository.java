package com.sheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sheet.model.Customer;

//@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.customerName like %:customerName%")
	public List<Customer> findByName(@Param("customerName") String customerName);

}
