package com.example.BookMyShowCloneAPI.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BookMyShowCloneAPI.dao.CustomerDao;
import com.example.BookMyShowCloneAPI.dto.CustomerDto;
import com.example.BookMyShowCloneAPI.entity.Customer;
import com.example.BookMyShowCloneAPI.exception.CustomerEmailNotFoundException;
import com.example.BookMyShowCloneAPI.exception.CustomerIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.PasswordNotMatchException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(Customer customer) {
		Customer dbCustomer=customerDao.saveCustomer(customer); 
		
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer addes successfully !");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(this.modelMapper.map(dbCustomer, CustomerDto.class));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomer(long customerId){
		Customer customer=customerDao.findCustomer(customerId);
		if(customer!=null) {
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer Fetched successfully !");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(this.modelMapper.map(customer, CustomerDto.class));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.FOUND);	
	}else {
		throw new CustomerIdNotFoundException("Sorry ! Failed to fetch the customer");
	}
	}
	
	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(long customerId){
		Customer customer=customerDao.deleteCustomer(customerId);
		if(customer!=null) {
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer deleted successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(this.modelMapper.map(customer, CustomerDto.class));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.OK);	
	}else {
		throw new CustomerIdNotFoundException("Sorry ! Failed to Delete the customer");
	}
	}
	
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(long customerId,Customer customer){
		Customer dbCustomer=customerDao.updateCustomer(customerId,customer);
		if(customer!=null) {
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer updated successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(this.modelMapper.map(dbCustomer, CustomerDto.class));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.OK);	
	}else {
		throw new CustomerIdNotFoundException("Sorry ! Failed to update the customer");
	}
	}
	
	public ResponseEntity<ResponseStructure<Customer>>login(String email,String password){
		Customer dbCustomer=customerDao.findByEmail(email);
		String customerPassword=dbCustomer.getCustomerPassword();
		if(dbCustomer!=null) {
			if(customerPassword.equals(password)) {
				ResponseStructure<Customer>structure=new ResponseStructure<Customer>();
				structure.setMessage("Login successful");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dbCustomer);
				return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);
			}else {
				throw new PasswordNotMatchException("Sorry ! failed to login ");
			}}else {
				throw new CustomerEmailNotFoundException("Sorry ! failed to login");
			}
			
		}
		
	}
	
	
	

