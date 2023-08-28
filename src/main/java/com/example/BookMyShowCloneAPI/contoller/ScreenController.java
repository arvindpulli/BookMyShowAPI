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

import com.example.BookMyShowCloneAPI.dto.ScreenDto;
import com.example.BookMyShowCloneAPI.service.ScreenService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private ScreenService service;
	
	@Operation(summary =  "Save Screen",  description ="This API is used to save the Screen")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<ScreenDto>>saveScreen(@RequestBody ScreenDto screenDto,@RequestParam long theaterId){
		return service.saveScreen(theaterId, screenDto);
	}
	
	@Operation(summary = "Find Screen", description ="This API is used to Find the existing Screen")
	@ApiResponses(value = {@ApiResponse(responseCode = "302",description = "Successfully Found"),
			@ApiResponse(responseCode = "404",description = "In not Found for Screen")})		
	@GetMapping
	public ResponseEntity<ResponseStructure<ScreenDto>>findScreen(@RequestParam long screenId){
		return service.findScreen(screenId);
	}
	
	@Operation(summary = "Delete Screen", description ="This API is used to delete the existing Screen")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for Screen")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ScreenDto>>deleteScreen(@RequestParam long screenId){
		return service.deleteScreen(screenId);
	}
	
	@Operation(summary = "Update Screen", description ="This API is used to update the existing Screen")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully updated"),
			@ApiResponse(responseCode = "404",description = "In not Found for Screen")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<ScreenDto>>updateScreen(@RequestBody ScreenDto screenDto, @RequestParam long screenId){
		return service.updateScreen(screenId,screenDto);
	}
	
}
