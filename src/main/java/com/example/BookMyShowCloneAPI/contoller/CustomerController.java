package com.example.BookMyShowCloneAPI.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShowCloneAPI.dto.CustomerDto;
import com.example.BookMyShowCloneAPI.entity.Customer;
import com.example.BookMyShowCloneAPI.service.CustomerService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerDto>>saveCustomer(@RequestBody Customer customer){
		return service.saveCustomer(customer);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerDto>>findCustomer(@RequestParam long customerId){
		return service.findCustomer(customerId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerDto>>deleteCustomer(@RequestParam long customerId){
		return service.deleteCustomer(customerId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerDto>>updateCustomer(@RequestParam long customerId,@RequestBody Customer customer){
		return service.updateCustomer(customerId,customer);
	}
	

	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<Customer>>login(@RequestParam String email,@RequestParam String password){
		return service.login(email, password);
	}
}
