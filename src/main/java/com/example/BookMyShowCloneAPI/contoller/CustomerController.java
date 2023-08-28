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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Operation(summary =  "Save Customer",  description ="This API is used to save the Customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully created")})
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerDto>>saveCustomer(@RequestBody Customer customer){
		return service.saveCustomer(customer);
	}
	
	
	 @Operation(summary = "Find Customer", description ="This API is used to Find the existing Customer")
		@ApiResponses(value = {@ApiResponse(responseCode = "302",description = "Successfully Found"),
				@ApiResponse(responseCode = "404",description = "In not Found for Customer")})		
		@GetMapping
	public ResponseEntity<ResponseStructure<CustomerDto>>findCustomer(@RequestParam long customerId){
		return service.findCustomer(customerId);
	}
	
	 
	 
	@Operation(summary = "Delete Customer", description ="This API is used to delete the existing Customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for Customer")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerDto>>deleteCustomer(@RequestParam long customerId){
		return service.deleteCustomer(customerId);
	}
	
	@Operation(summary = "Update Customer", description ="This API is used to update the existing Customer")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully updated"),
			@ApiResponse(responseCode = "404",description = "In not Found for Customer")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerDto>>updateCustomer(@RequestParam long customerId,@RequestBody Customer customer){
		return service.updateCustomer(customerId,customer);
	}
	

	@Operation(summary = "Customer Login", description ="This API is used to Customer Login")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully Logged In"),
			@ApiResponse(responseCode = "404",description = "Invalid Credentials")})	
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<Customer>>login(@RequestParam String email,@RequestParam String password){
		return service.login(email, password);
	}
}
