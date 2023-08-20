package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.MovieShow;
import com.example.BookMyShowCloneAPI.repository.MovieShowRepo;

@Repository
public class MovieShowDao {

	@Autowired
	private MovieShowRepo repo;
	
	public MovieShow saveMovieShow(MovieShow show) {
		return repo.save(show);
	}
	
	public MovieShow findMovieShow(long showId) {
		Optional<MovieShow> optional=repo.findById(showId);
		if(optional.isPresent()) {
			return optional.get();
		}return null;
	}
	
	public MovieShow deleteMovieShow(long showId) {
		Optional<MovieShow> optional=repo.findById(showId);
		if(optional.isPresent()) {
			optional.get().setTheater(null);
			repo.delete(optional.get());
			return optional.get();
		}return null;
	}
	
	public MovieShow updateMovieShow(long showId,MovieShow show) {
		Optional<MovieShow> optional=repo.findById(showId);
		if(optional.isPresent()) {
			MovieShow existingShow=optional.get();
			show.setShowId(showId);
			show.setTheater(existingShow.getTheater());
			repo.save(show);
			return show;
		}return null;
	}
}
