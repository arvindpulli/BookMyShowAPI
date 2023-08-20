package com.example.BookMyShowCloneAPI.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookMyShowCloneAPI.dao.OwnerDao;
import com.example.BookMyShowCloneAPI.dto.OwnerDto;
import com.example.BookMyShowCloneAPI.entity.Owner;
import com.example.BookMyShowCloneAPI.exception.OwnerIdNotFoundException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class OwnerService {

	@Autowired
	private OwnerDao dao;
	@Autowired
	private ModelMapper modelmapper;
	
	public ResponseEntity<ResponseStructure<OwnerDto>> saveOwner(Owner o){
		
		Owner owner=dao.saveOwner(o);
		ResponseStructure<OwnerDto> structure=new ResponseStructure<OwnerDto>();
		structure.setMessage("Owner saved successfully !");
		structure.setStatus(HttpStatus.CREATED.value());
		
		OwnerDto dto=new OwnerDto();
		dto.setOwnerId(owner.getOwnerId());
		dto.setOwnerName(owner.getOwnerName());
		dto.setOwnerPhone(owner.getOwnerPhone());
		dto.setOwnerEmail(owner.getOwnerEmail());
		
		structure.setData(dto);
		
		return new ResponseEntity<ResponseStructure<OwnerDto>>(structure,HttpStatus.CREATED);
	}

	
	public ResponseEntity<ResponseStructure<OwnerDto>> findOwner(long ownerId) {
		
		Owner dbOwner=dao.findOwner(ownerId);
		OwnerDto dto=this.modelmapper.map(dbOwner, OwnerDto.class);
		if(dbOwner!=null) {
		ResponseStructure<OwnerDto> structure=new ResponseStructure<OwnerDto>();
		structure.setMessage("Owner fetched successfully !");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<OwnerDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new OwnerIdNotFoundException("Sorry ! failed to fetch the owner");
		}
	}
	
	public ResponseEntity<ResponseStructure<OwnerDto>> updateOwner(long ownerId,Owner owner){
		Owner dbOwner=dao.updateOwner(ownerId,owner);
		OwnerDto dto=this.modelmapper.map(dbOwner, OwnerDto.class);
		if(dbOwner!=null) {
		ResponseStructure<OwnerDto> structure=new ResponseStructure<OwnerDto>();
		structure.setMessage("Updated Owner successfully !");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dto);
		
		return new ResponseEntity<ResponseStructure<OwnerDto>>(structure,HttpStatus.OK);
	}else {
		throw new OwnerIdNotFoundException("Sorry ! failed to fetch the owner");
	}
	}


	public ResponseEntity<ResponseStructure<OwnerDto>> deleteOwner(long ownerId) {
		Owner dbOwner=dao.deleteOwner(ownerId);
		OwnerDto dto=this.modelmapper.map(dbOwner, OwnerDto.class);
		if(dbOwner!=null) {
		ResponseStructure<OwnerDto> structure=new ResponseStructure<OwnerDto>();
		structure.setMessage("Deleted Owner sucessfully !");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dto);
		
		return new ResponseEntity<ResponseStructure<OwnerDto>>(structure,HttpStatus.OK);
	}else {
		throw new OwnerIdNotFoundException("Sorry ! failed to fetch the owner");

	}
	}
}