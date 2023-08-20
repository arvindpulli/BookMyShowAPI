package com.example.BookMyShowCloneAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShowCloneAPI.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long>{

}
