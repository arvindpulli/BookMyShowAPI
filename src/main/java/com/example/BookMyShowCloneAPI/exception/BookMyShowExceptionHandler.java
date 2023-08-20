package com.example.BookMyShowCloneAPI.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.BookMyShowCloneAPI.util.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class BookMyShowExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> OwnerIdNotFound(OwnerIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for Owner");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ProductionHouseIdNotFound(ProductionHouseIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for ProductionHouse");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AddressIdNotFound(AddressIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for Address");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TheaterAlreadyPresentAtTisAddress(TheaterAlreadyPresentInThisAddressException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Theater already present at given address");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TheaterIdNotFound(TheaterIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for theater");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> MovieIdNotFound(MovieIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for Movie");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> CustomerIdNotFound(CustomerIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for Customer");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ScreenIdNotFound(ScreenIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for Screen");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ScreenAlredyAlloted(ScreenAlreadyAlloted ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Screen already alloted");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> MovieShowIdNotFound(MovieShowIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for movieShow");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> SeatIdNotFound(SeatIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for Seat");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> MovieShowIsNotActivate(MovieShowIsNotActiveException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Movie show is not active");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketIdNotFound(TicketIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for Ticket");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketAlreadyCancelled(TicketAlreadyCancelledException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Ticket already cancelled");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketAlreadyExpired(TicketAlredyExpiedException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Ticket already cancelled");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketCanNotCancelled(TicketCanNotCancelledException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Ticket CanNot cancel for ongoing show");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> PasswordNotMatch(PasswordNotMatchException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Password not match");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> CustomerEmailNotFound(CustomerEmailNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Email not found for customer");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMsg());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<Object>> HandleConstraintViolationException(ConstraintViolationException ex){
		ResponseStructure<Object>structure=new ResponseStructure<Object>();
		HashMap<String, String>hashmap=new HashMap<String, String>();
		
		for(ConstraintViolation<?>violation:ex.getConstraintViolations()) {
			String field=violation.getPropertyPath().toString();
			String msg=violation.getMessage();
			hashmap.put(field, msg);
		}
		structure.setMessage("Add Proper details");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		structure.setData(hashmap);
		return new ResponseEntity<ResponseStructure<Object>>(structure,HttpStatus.BAD_REQUEST);
		}
	
}
