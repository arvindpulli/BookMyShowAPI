package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Seat;
import com.example.BookMyShowCloneAPI.repository.SeatRepo;

@Repository
public class SeatDao {

	@Autowired
	private SeatRepo repo;
	
	public Seat saveSeat(Seat seat) {
		return repo.save(seat);
	}
	
	public Seat findSeat(long seatId) {
		Optional<Seat>optional=repo.findById(seatId);
		if(optional.isPresent()) {
			return optional.get();
		}return null;
	}
	
	public Seat deleteSeat(long seatId) {
		Optional<Seat>optional=repo.findById(seatId);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return optional.get();
		}return null;}
	
	public Seat updateSeat(Seat seat,long seatId) {
		Optional<Seat>optional=repo.findById(seatId);
		if(optional.isPresent()) {
			seat.setSeatId(seatId);
			return repo.save(seat);
		}return null;}
}
	
