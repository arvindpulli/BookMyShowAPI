package com.example.BookMyShowCloneAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShowCloneAPI.entity.Theater;

public interface TheaterRepo  extends JpaRepository<Theater,Long> {

}
