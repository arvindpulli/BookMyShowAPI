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

import com.example.BookMyShowCloneAPI.dto.AddressDto;
import com.example.BookMyShowCloneAPI.entity.Address;
import com.example.BookMyShowCloneAPI.service.AddressService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;
	
	@Operation(summary =  "Save Address",  description ="This API is used to save the Address")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully created")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody AddressDto addressDto){
		return service.saveAddress(addressDto);
	}
	
	@Operation(summary = "Find Address", description ="This API is used to Find the existing Address")
	@ApiResponses(value = {@ApiResponse(responseCode = "302",description = "Successfully Found"),
			@ApiResponse(responseCode = "404",description = "In not Found for Address")})		
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> findAddress(@RequestParam long addressId){
		return service.findAddress(addressId);
	}
	
	@Operation(summary = "Update Address", description ="This API is used to update the existing Address")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully updated"),
			@ApiResponse(responseCode = "404",description = "In not Found for Address")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam long addressId ,@RequestBody AddressDto addressDto){
		return service.updateAddress(addressId,addressDto);
	}
	
	@Operation(summary = "Delete Address", description ="This API is used to delete the existing Address")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for Address")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam long addressId){
		return service.deleteAddress(addressId);
	}
	
}
