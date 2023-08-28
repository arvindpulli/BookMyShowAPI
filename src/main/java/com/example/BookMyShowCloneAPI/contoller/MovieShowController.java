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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/movieshow")
public class MovieShowController {

	@Autowired
	private MovieShowService service;
	
	@Operation(summary =  "Save MovieShow",  description ="This API is used to save the MovieShow")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<MovieShow>> saveMovieShow(long theaterId,MovieShowDto showDto){
		return service.saveMovieShow(theaterId,showDto);
	}
	
	@Operation(summary = "Update MovieShow", description ="This API is used to update the existing MovieShow")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully updated"),
			@ApiResponse(responseCode = "404",description = "In not Found for MovieShow")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<MovieShow>> updateMovieShow(long showId,MovieShowDto showDto){
		return service.updateMovieShow(showId,showDto);
	}
	
	@Operation(summary = "Delete MovieShow", description ="This API is used to delete the existing MovieShow")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for MovieShow")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MovieShow>> deleteMovieShow(long showId){
		return service.deleteMovieShow(showId);
	}
	
	@Operation(summary = "Find MovieShow", description ="This API is used to Find the existing MovieShow")
	@ApiResponses(value = {@ApiResponse(responseCode = "302",description = "Successfully Found"),
			@ApiResponse(responseCode = "404",description = "In not Found for MovieShow")})		
	@GetMapping
	public ResponseEntity<ResponseStructure<MovieShow>> findMovieShow(long showId){
		return service.findMovieShow(showId);
	}
}
