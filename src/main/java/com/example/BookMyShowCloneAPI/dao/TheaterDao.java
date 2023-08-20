package com.example.BookMyShowCloneAPI.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.MovieShow;
import com.example.BookMyShowCloneAPI.entity.Theater;
import com.example.BookMyShowCloneAPI.repository.TheaterRepo;

@Repository
public class TheaterDao {

	@Autowired
	private TheaterRepo repo;
	
	public Theater saveTheater(Theater theater) {
		return repo.save(theater);
	}
	
	public Theater findTheater(long theaterId) {
		Optional<Theater> optional=repo.findById(theaterId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public Theater deleteTheater(long theaterId) {

		Optional<Theater> optional=repo.findById(theaterId);
		if(optional.isPresent()) {
			Theater theater=optional.get();
			theater.setOwner(null);
			theater.setAddress(null);
			List<MovieShow> list=optional.get().getShow();
			for(MovieShow show:list) {
				show.setTheater(null);
			}
			repo.delete(optional.get());
			return optional.get();
		}
		return null;
	}
	
	public Theater updateTheater(long theaterId, Theater theater) {
		Optional<Theater> optional=repo.findById(theaterId);
		if(optional.isPresent()) {
			Theater exisTheater=optional.get();
			theater.setTheaterId(theaterId);
			theater.setAddress(exisTheater.getAddress());
			theater.setShow(exisTheater.getShow());
			theater.setOwner(exisTheater.getOwner());
			theater.setScreens(exisTheater.getScreens());
			repo.save(theater);
			return theater;
		}return null;
	}
}
