package com.example.BookMyShowCloneAPI.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShowCloneAPI.entity.Ticket;
import com.example.BookMyShowCloneAPI.service.TicketService;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService service;
	
	@Operation(summary =  "Book Ticket",  description ="This API is used to Book the Ticket")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Successfully Booked")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestParam long customerId,@RequestParam long showId,@RequestParam long seatId){
		return service.saveTicket(customerId, showId, seatId);
	}
	
	@Operation(summary = "Cancek Ticket", description ="This API is used to Cancel the Ticket")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted"),
			@ApiResponse(responseCode = "404",description = "In not Found for Ticket")})	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Ticket>> cancelTicket(@RequestParam long ticketId){
		return service.cancelTicket(ticketId);
	}
}
