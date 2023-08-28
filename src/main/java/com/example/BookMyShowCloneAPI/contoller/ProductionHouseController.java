package com.example.BookMyShowCloneAPI.contoller;

import org.modelmapper.ModelMapper;
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

import com.example.BookMyShowCloneAPI.dto.ProductionHouseDto;
import com.example.BookMyShowCloneAPI.entity.ProductionHouse;
import com.example.BookMyShowCloneAPI.service.ProductionHouseService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/productionhouse")
public class ProductionHouseController {

	@Autowired
	private ProductionHouseService service;
	
	@Operation(summary =  "Save ProductionHouse",  description ="This API is used to save the ProductionHouse")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<ProductionHouse>> saveProductionHouse(@RequestParam long ownerId,@RequestBody ProductionHouseDto houseDto){
		return service.saveHouse(ownerId, houseDto);
	}
	
	@Operation(summary = "Find ProductionHouse", description ="This API is used to Find the existing ProductionHouse")
	@ApiResponses(value = {@ApiResponse(responseCode = "302",description = "Successfully Found"),
			@ApiResponse(responseCode = "404",description = "In not Found for ProductionHouse")})		
	@GetMapping
	public ResponseEntity<ResponseStructure<ProductionHouse>> findProductionHouse(@RequestParam long houseId){
		return service.findHouse(houseId);
	}
	
	@Operation(summary = "Delete ProductionHouse", description ="This API is used to delete the existing ProductionHouse")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for ProductionHouse")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ProductionHouse>> deleteProductionHouse(@RequestParam long houseId){
		return service.deleteHouse(houseId);
	}
	
	@Operation(summary = "Update ProductionHouse", description ="This API is used to update the existing ProductionHouse")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully updated"),
			@ApiResponse(responseCode = "404",description = "In not Found for ProductionHouse")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<ProductionHouse>> updateProductionHouse(@RequestParam long houseId,@RequestBody ProductionHouseDto houseDto ){
		return service.updateHouse(houseId,houseDto);
	}
}
