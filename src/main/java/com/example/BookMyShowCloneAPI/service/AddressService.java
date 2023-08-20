package com.example.BookMyShowCloneAPI.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookMyShowCloneAPI.dao.AddressDao;
import com.example.BookMyShowCloneAPI.dto.AddressDto;
import com.example.BookMyShowCloneAPI.entity.Address;
import com.example.BookMyShowCloneAPI.exception.AddressIdNotFoundException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private ModelMapper modelmapper;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(AddressDto addressDto) {
		Address address=this.modelmapper.map(addressDto, Address.class);
		Address dbAddress=addressDao.saveAddress(address);
		ResponseStructure<Address> structure=new ResponseStructure<Address>();
		structure.setMessage("Address saved successfully !");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dbAddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> findAddress(long addressId) {
		Address address=addressDao.findAddress(addressId);
		if(address!=null) {
			ResponseStructure<Address> structure=new ResponseStructure<Address>();
			structure.setMessage("Address fetched successfully !");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFoundException("Sorry ! failed to fetch the address");
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(long addressId){
		Address address=addressDao.deleteAddress(addressId);
		if(address!=null) {
			ResponseStructure<Address> structure=new ResponseStructure<Address>();
			structure.setMessage("Address deleted successsfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}else {
			throw new AddressIdNotFoundException("Sorry ! failed to delete the address");
		}
		
		
	}

	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(long addressId, AddressDto addressDto){
		Address address=this.modelmapper.map(addressDto, Address.class);
		Address dbAddress=addressDao.updateAddress(addressId, address);
		if(dbAddress!=null) {
			ResponseStructure<Address> structure=new ResponseStructure<Address>();
			structure.setMessage("Address updated successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}else {
			throw new AddressIdNotFoundException("Sorry ! failed to update the address");
		}
		
	}
}
