package com.example.BookMyShowCloneAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShowCloneAPI.entity.Owner;

public interface OwnerRepo  extends JpaRepository<Owner,Long>{

}
