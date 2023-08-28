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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RequestMapping("/movie")
@RestController
public class MovieController {

	@Autowired
	private MovieService service;
	
	@Operation(summary =  "Save Movie",  description ="This API is used to save the Movie")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(@RequestParam long houseId, @RequestBody MovieDto movieDto){
		return service.saveMovie(movieDto,houseId);
	}
	
	@Operation(summary = "Find Movie", description ="This API is used to Find the existing Movie")
	@ApiResponses(value = {@ApiResponse(responseCode = "302",description = "Successfully Found"),
			@ApiResponse(responseCode = "404",description = "In not Found for Movie")})		
	@GetMapping
	public ResponseEntity<ResponseStructure<MovieDto>> findMovie(@RequestParam long movieId){
		return service.findMovie(movieId);
	}
	
	@Operation(summary = "Delete Movie", description ="This API is used to delete the existing Movie")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for Movie")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MovieDto>> deleteMovie(@RequestParam long movieId){
		return service.deleteMovie(movieId);
	}
	
	@Operation(summary = "Update Movie", description ="This API is used to update the existing Movie")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully updated"),
			@ApiResponse(responseCode = "404",description = "In not Found for Movie")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<MovieDto>> updateMovie(@RequestParam long movieId, @RequestBody MovieDto movieDto){
		return service.updateMovie(movieDto,movieId);
	}
}
