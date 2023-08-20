package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Owner;
import com.example.BookMyShowCloneAPI.repository.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	private OwnerRepo repo;
	
	public Owner saveOwner(Owner owner) {
		return repo.save(owner);
	}


	public Owner findOwner(long ownerId) {
		Optional<Owner> optional=repo.findById(ownerId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


	public Owner updateOwner(long ownerId, Owner owner) {
		Optional<Owner> optional=repo.findById(ownerId);
		if(optional.isPresent()) {
			owner.setOwnerId(ownerId);
			repo.save(owner);
			return owner;
		}
		return null;
	}


	public Owner deleteOwner(long ownerId) {
		Optional<Owner> optional=repo.findById(ownerId);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return optional.get();
		}
		return null;
	}
}
