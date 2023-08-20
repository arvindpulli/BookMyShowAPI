package com.example.BookMyShowCloneAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
import com.example.BookMyShowCloneAPI.exception.TheaterIdNotFoundException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class TheaterService {

	@Autowired
	private TheaterDao theaterDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Theater>> saveTheater(TheaterDto theaterDto,long ownerId,long addressId){
		Owner owner=ownerDao.findOwner(ownerId);
		if(owner!=null) {
			Address address=addressDao.findAddress(addressId);
			if(address!=null) {
			
				Theater exisTheater=address.getTheater();
				if(exisTheater!=null) {
					throw new TheaterAlreadyPresentInThisAddressException("Sorry ! Address is mapped to other Theater");
				}else {
					Theater theater=this.modelmapper.map(theaterDto, Theater.class);
					theater.setOwner(owner);
					theater.setAddress(address);
					if(owner.getTheaters().isEmpty()) {
						List<Theater> list=new ArrayList<Theater>();
						list.add(theater);
						owner.setTheaters(list);
					}else {
						List<Theater>list=owner.getTheaters();
						list.add(theater);
						owner.setTheaters(list);
					}
					
					address.setTheater(theater);
					
					Theater dbTheater=theaterDao.saveTheater(theater);
					ResponseStructure<Theater> structure=new ResponseStructure<Theater>();
					structure.setMessage("Theater added successfully !");
					structure.setStatus(HttpStatus.CREATED.value());
					structure.setData(dbTheater);
					return new ResponseEntity<ResponseStructure<Theater>>(structure,HttpStatus.CREATED);
				}
			}else {
				throw new AddressIdNotFoundException("Sorry ! failed to add theater");
			}
		}else
		{
			throw new OwnerIdNotFoundException("Sorry ! failed to add theater");
		}
	}


	public ResponseEntity<ResponseStructure<Theater>> findTheater(long theaterId) {
		Theater theater=theaterDao.findTheater(theaterId);
		if(theater!=null) {
			ResponseStructure<Theater> structure=new ResponseStructure<Theater>();
			structure.setData(theater);
			structure.setMessage("Theater fetched successfully !");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Theater>>(structure,HttpStatus.FOUND);
		}else {
			throw new TheaterIdNotFoundException("Sorry ! failed to get theater");
		}
		
	}

	public ResponseEntity<ResponseStructure<Theater>> deleteTheater(long theaterId){
		Theater theater=theaterDao.deleteTheater(theaterId);
		if(theater!=null) {
			ResponseStructure<Theater> structure=new ResponseStructure<Theater>();
			structure.setData(theater);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Theater deleted successfully !");
			
			return new ResponseEntity<ResponseStructure<Theater>>(structure,HttpStatus.OK);
		}else {
			throw new TheaterIdNotFoundException("Sorry ! failed to delete theater");
		}
	}

	public ResponseEntity<ResponseStructure<Theater>> updateTheater(long theaterId, TheaterDto theaterDto){
		Theater theater=this.modelmapper.map(theaterDto, Theater.class);
		Theater dbTheater=theaterDao.updateTheater(theaterId, theater);
		if(dbTheater!=null) {
			ResponseStructure<Theater> structure=new ResponseStructure<Theater>();
			structure.setData(dbTheater);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Theater updated successfully !");
			return new ResponseEntity<ResponseStructure<Theater>>(structure,HttpStatus.OK);
		}
		else {
			throw new TheaterIdNotFoundException("Sorry ! failed to update the theater");
		}
	}
}
