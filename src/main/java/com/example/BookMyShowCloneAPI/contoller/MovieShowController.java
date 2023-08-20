package com.example.BookMyShowCloneAPI.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShowCloneAPI.dto.MovieShowDto;
import com.example.BookMyShowCloneAPI.entity.MovieShow;
import com.example.BookMyShowCloneAPI.service.MovieShowService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@RestController
@RequestMapping("/movieshow")
public class MovieShowController {

	@Autowired
	private MovieShowService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MovieShow>> saveMovieShow(long theaterId,MovieShowDto showDto){
		return service.saveMovieShow(theaterId,showDto);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<MovieShow>> updateMovieShow(long showId,MovieShowDto showDto){
		return service.updateMovieShow(showId,showDto);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MovieShow>> deleteMovieShow(long showId){
		return service.deleteMovieShow(showId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MovieShow>> findMovieShow(long showId){
		return service.findMovieShow(showId);
	}
}
