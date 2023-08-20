package com.example.BookMyShowCloneAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShowCloneAPI.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat,Long> {

}
