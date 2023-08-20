package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Booking;
import com.example.BookMyShowCloneAPI.repository.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepo repo;
	
	public Booking saveBooking(Booking booking) {
		return repo.save(booking);
	}
	
	public Booking findBooking(long bookingId) {
		Optional<Booking> optional=repo.findById(bookingId);
		if(optional.isPresent()) {
			return optional.get();
		}return null;
	}
}
