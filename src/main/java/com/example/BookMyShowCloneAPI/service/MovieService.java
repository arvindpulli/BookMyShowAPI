package com.example.BookMyShowCloneAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BookMyShowCloneAPI.dao.MovieDao;
import com.example.BookMyShowCloneAPI.dao.ProductionHouseDao;
import com.example.BookMyShowCloneAPI.dto.MovieDto;
import com.example.BookMyShowCloneAPI.entity.Movie;
import com.example.BookMyShowCloneAPI.entity.ProductionHouse;
import com.example.BookMyShowCloneAPI.exception.MovieIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.ProductionHouseIdNotFoundException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class MovieService {

	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private ProductionHouseDao houseDao;
	
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(MovieDto movieDto, long houseId) {
		ProductionHouse house=houseDao.findProductionHouse(houseId);
		if(house!=null) {
			Movie movie=this.modelMapper.map(movieDto, Movie.class);
			movie.setProductionHouse(house);
			Movie dbMovie=movieDao.saveMovie(movie);
			
			if(house.getMovies().isEmpty()) {
				List<Movie> list=new ArrayList<Movie>();
				list.add(movie);
				house.setMovies(list);
				houseDao.saveHouse(house);
			}else {
				List<Movie>list=house.getMovies();
				list.add(movie);
				house.setMovies(list);
				houseDao.saveHouse(house);
			}
			
			ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie saved successfully !");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(this.modelMapper.map(dbMovie, MovieDto.class));
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.CREATED);
		}else {
			throw new ProductionHouseIdNotFoundException("Sorry ! Failed to add movie");
		}
	}
	
	public ResponseEntity<ResponseStructure<MovieDto>> updateMovie(@RequestBody MovieDto movieDto,@RequestParam long movieId){
		Movie movie=this.modelMapper.map(movieDto, Movie.class);
		Movie dbMovie=movieDao.updateMovie(movie,movieId);
		if(dbMovie!=null) {
			ResponseStructure<MovieDto>structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie updated successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(this.modelMapper.map(dbMovie, MovieDto.class));
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.OK);
		}else {
			throw new MovieIdNotFoundException("Sorry ! failed to update movie");
		}	
	}
	
	public ResponseEntity<ResponseStructure<MovieDto>> deleteMovie(@RequestParam long movieId){
		Movie dbMovie=movieDao.deleteMovie(movieId);
		if(dbMovie!=null) {
			ResponseStructure<MovieDto>structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie deleted successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbMovie);
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.OK);
		}else {
			throw new MovieIdNotFoundException("Sorry ! failed to update movie");
		}	
	}
	
	public ResponseEntity<ResponseStructure<MovieDto>> findMovie(@RequestParam long movieId){
		Movie dbMovie=movieDao.findMovie(movieId);
		if(dbMovie!=null) {
			ResponseStructure<MovieDto>structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie fetched successfully !");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbMovie);
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new MovieIdNotFoundException("Sorry ! failed to update movie");
		}	
	}
	
	
	
	
}
