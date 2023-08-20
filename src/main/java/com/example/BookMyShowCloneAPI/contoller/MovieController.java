package com.example.BookMyShowCloneAPI.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShowCloneAPI.dto.MovieDto;
import com.example.BookMyShowCloneAPI.service.MovieService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;
@RequestMapping("/movie")
@RestController
public class MovieController {

	@Autowired
	private MovieService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(@RequestParam long houseId, @RequestBody MovieDto movieDto){
		return service.saveMovie(movieDto,houseId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MovieDto>> findMovie(@RequestParam long movieId){
		return service.findMovie(movieId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MovieDto>> deleteMovie(@RequestParam long movieId){
		return service.deleteMovie(movieId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<MovieDto>> updateMovie(@RequestParam long movieId, @RequestBody MovieDto movieDto){
		return service.updateMovie(movieDto,movieId);
	}
}
