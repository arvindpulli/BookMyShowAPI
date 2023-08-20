package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Address;
import com.example.BookMyShowCloneAPI.repository.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;
	
	public Address saveAddress(Address address) {
		return repo.save(address);
	}

	public Address findAddress(long addressId) {
		Optional<Address>optional=repo.findById(addressId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public Address deleteAddress(long addressId) {
		Optional<Address>optional=repo.findById(addressId);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return optional.get();
		}
		return null;
	}
	
	public Address updateAddress(long addressId, Address address) {
		Optional<Address>optional=repo.findById(addressId);
		if(optional.isPresent()) {
			address.setAddressId(addressId);
			address.setTheater(optional.get().getTheater());
			repo.save(address);
			return address;
		}
		return null;
	}
}
