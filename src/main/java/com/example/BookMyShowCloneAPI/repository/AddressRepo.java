package com.example.BookMyShowCloneAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShowCloneAPI.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
