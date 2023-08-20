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

@RestController
@RequestMapping("/productionhouse")
public class ProductionHouseController {

	@Autowired
	private ProductionHouseService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ProductionHouse>> saveProductionHouse(@RequestParam long ownerId,@RequestBody ProductionHouseDto houseDto){
		return service.saveHouse(ownerId, houseDto);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ProductionHouse>> findProductionHouse(@RequestParam long houseId){
		return service.findHouse(houseId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ProductionHouse>> deleteProductionHouse(@RequestParam long houseId){
		return service.deleteHouse(houseId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ProductionHouse>> updateProductionHouse(@RequestParam long houseId,@RequestBody ProductionHouseDto houseDto ){
		return service.updateHouse(houseId,houseDto);
	}
}
