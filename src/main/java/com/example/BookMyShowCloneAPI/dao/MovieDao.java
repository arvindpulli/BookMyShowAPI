package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Movie;
import com.example.BookMyShowCloneAPI.repository.MovieRepo;
@Repository
public class MovieDao {

	@Autowired
	private MovieRepo repo;

	public Movie saveMovie(Movie movie) {
		return repo.save(movie);
	}

	public Movie updateMovie(Movie movie, long movieId) {
		Optional<Movie> optional=repo.findById(movieId);
		if(optional.isPresent()) {
			Movie exisMovie=optional.get();
			movie.setMovieId(movieId);
			movie.setProductionHouse(exisMovie.getProductionHouse());
			return repo.save(movie);
		}else {
			return null;
		}
	}
	
	public Movie deleteMovie(long movieId) {
		Optional<Movie> optional=repo.findById(movieId);
		if(optional.isPresent()) {
			optional.get().setProductionHouse(null);
			repo.delete(optional.get());
			return optional.get();
		}return null;}

	public Movie findMovie(long movieId) {
		Optional<Movie> optional=repo.findById(movieId);
		if(optional.isPresent()) {
			return optional.get();
		}return null;}
}
