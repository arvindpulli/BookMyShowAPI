package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Screen;
import com.example.BookMyShowCloneAPI.repository.ScreenRepo;

@Repository
public class ScreenDao {

	@Autowired
	private ScreenRepo repo;
	
	public Screen saveScreen(Screen screen) {
		return repo.save(screen);
	}
	
	public Screen findScreen(long screenId) {
		Optional<Screen>optional=repo.findById(screenId);
		if(optional.isPresent()) {
			return optional.get();
		}return null;
	}
	
	public Screen deleteScreen(long screenId) {
		Optional<Screen>optional=repo.findById(screenId);
		if(optional.isPresent()) {
			Screen screen=optional.get();
			screen.setTheater(null);
			repo.delete(screen);
			return screen;
		}return null;
	}
	
	public Screen updateScreen(long screenId,Screen screen) {
		Optional<Screen>optional=repo.findById(screenId);
		if(optional.isPresent()) {
			screen.setScreenId(screenId);
			screen.setSeats(optional.get().getSeats());
			screen.setTheater(optional.get().getTheater());
			return repo.save(screen);
		}return null;
	}
}
