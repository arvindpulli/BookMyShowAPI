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

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<OwnerDto>> saveOwner(@RequestBody Owner owner){
		return service.saveOwner(owner);
	}
	

	@GetMapping
	public ResponseEntity<ResponseStructure<OwnerDto>> findOwner(@RequestParam long ownerId){
		return service.findOwner(ownerId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<OwnerDto>> updateOwner(@RequestParam long ownerId,@RequestBody Owner owner){
		return service.updateOwner(ownerId,owner);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<OwnerDto>>deleteOwner(@RequestParam long ownerId){
		return service.deleteOwner(ownerId);
	}
}
