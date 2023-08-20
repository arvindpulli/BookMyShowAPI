package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Customer;
import com.example.BookMyShowCloneAPI.repository.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepo repo;
	
	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}
	
	public Customer findCustomer(long customerId) {
		Optional<Customer>optional=repo.findById(customerId);
		if(optional.isPresent()) {
			return optional.get();
		}return null;
	}
	
	public Customer deleteCustomer(long customerId) {
		Optional<Customer>optional=repo.findById(customerId);
		if(optional.isPresent()) {
			Customer customer=optional.get();	
			repo.deleteById(customer.getCustomerId());
			return customer;
		}return null;
	}
	
	public Customer updateCustomer(long customerId,Customer customer) {
		Optional<Customer> optional=repo.findById(customerId);
		if(optional.isPresent()) {
			customer.setCustomerId(customerId);
			customer.setTickets(optional.get().getTickets());
			repo.save(customer);
			return customer;
		}return null;
	}
	
	public Customer findByEmail(String email) {
		Customer customer=repo.findByEmail(email);
		if(customer!=null) {
			return customer;
		}return null;
	}
	
}
