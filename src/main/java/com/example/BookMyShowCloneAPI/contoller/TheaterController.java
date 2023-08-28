package com.example.BookMyShowCloneAPI.contoller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShowCloneAPI.dao.AddressDao;
import com.example.BookMyShowCloneAPI.dao.OwnerDao;
import com.example.BookMyShowCloneAPI.dao.TheaterDao;
import com.example.BookMyShowCloneAPI.dto.TheaterDto;
import com.example.BookMyShowCloneAPI.entity.Address;
import com.example.BookMyShowCloneAPI.entity.Owner;
import com.example.BookMyShowCloneAPI.entity.Theater;
import com.example.BookMyShowCloneAPI.exception.AddressIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.OwnerIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.TheaterAlreadyPresentInThisAddressException;
import com.example.BookMyShowCloneAPI.service.TheaterService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("theater")
public class TheaterController {


	@Autowired
	private TheaterService service;
	
	@Operation(summary =  "Save Theater",  description ="This API is used to save the Theater")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Theater>> saveTheater(@RequestBody TheaterDto theaterDto,@RequestParam long addressId, @RequestParam long ownerId){
		return service.saveTheater(theaterDto, ownerId, addressId);	
	}
	
	@Operation(summary = "Find Theater", description ="This API is used to Find the existing Theater")
	@ApiResponses(value = {@ApiResponse(responseCode = "302",description = "Successfully Found"),
			@ApiResponse(responseCode = "404",description = "In not Found for Theater")})		
	@GetMapping
	public ResponseEntity<ResponseStructure<Theater>> findTheater(@RequestParam long theaterId){
		return service.findTheater(theaterId);	
	}
	
	@Operation(summary = "Delete Theater", description ="This API is used to delete the existing Theater")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for Theater")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theater>> deleteTheater(@RequestParam long theaterId){
		return service.deleteTheater(theaterId);	
	}
	
	@Operation(summary = "Update Theater", description ="This API is used to update the existing Theater")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully updated"),
			@ApiResponse(responseCode = "404",description = "In not Found for Theater")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<Theater>> findTheater(@RequestParam long theaterId, @RequestBody TheaterDto theaterDto){
		return service.updateTheater(theaterId,theaterDto);	
	}
}
