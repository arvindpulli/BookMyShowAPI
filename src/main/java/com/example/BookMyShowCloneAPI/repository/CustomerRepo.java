package com.example.BookMyShowCloneAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.BookMyShowCloneAPI.entity.Customer;

public interface CustomerRepo  extends JpaRepository<Customer,Long>{

	@Query("select c from Customer c where c.customerEmail=?1")
	public Customer findByEmail(String email);
}
