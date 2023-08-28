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

import com.example.BookMyShowCloneAPI.dto.OwnerDto;
import com.example.BookMyShowCloneAPI.entity.Owner;
import com.example.BookMyShowCloneAPI.service.OwnerService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService service;
	
	@Operation(summary =  "Save Owner",  description ="This API is used to save the Owner")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<OwnerDto>> saveOwner(@RequestBody Owner owner){
		return service.saveOwner(owner);
	}
	

	@Operation(summary = "Find Owner", description ="This API is used to Find the existing Owner")
	@ApiResponses(value = {@ApiResponse(responseCode = "302",description = "Successfully Found"),
			@ApiResponse(responseCode = "404",description = "In not Found for Owner")})		
	@GetMapping
	public ResponseEntity<ResponseStructure<OwnerDto>> findOwner(@RequestParam long ownerId){
		return service.findOwner(ownerId);
	}
	
	@Operation(summary = "Update Owner", description ="This API is used to update the existing Owner")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully updated"),
			@ApiResponse(responseCode = "404",description = "In not Found for Owner")})	
	@PutMapping

	public ResponseEntity<ResponseStructure<OwnerDto>> updateOwner(@RequestParam long ownerId,@RequestBody Owner owner){
		return service.updateOwner(ownerId,owner);
	}
	
	@Operation(summary = "Delete Owner", description ="This API is used to delete the existing Owner")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for Owner")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<OwnerDto>>deleteOwner(@RequestParam long ownerId){
		return service.deleteOwner(ownerId);
	}
}
