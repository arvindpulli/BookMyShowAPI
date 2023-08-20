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

@RestController
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private ScreenService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ScreenDto>>saveScreen(@RequestBody ScreenDto screenDto,@RequestParam long theaterId){
		return service.saveScreen(theaterId, screenDto);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ScreenDto>>findScreen(@RequestParam long screenId){
		return service.findScreen(screenId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ScreenDto>>deleteScreen(@RequestParam long screenId){
		return service.deleteScreen(screenId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ScreenDto>>updateScreen(@RequestBody ScreenDto screenDto, @RequestParam long screenId){
		return service.updateScreen(screenId,screenDto);
	}
	
}
