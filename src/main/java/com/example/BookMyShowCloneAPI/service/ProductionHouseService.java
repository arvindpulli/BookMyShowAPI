package com.example.BookMyShowCloneAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookMyShowCloneAPI.dao.OwnerDao;
import com.example.BookMyShowCloneAPI.dao.ProductionHouseDao;
import com.example.BookMyShowCloneAPI.dto.OwnerDto;
import com.example.BookMyShowCloneAPI.dto.ProductionHouseDto;
import com.example.BookMyShowCloneAPI.entity.Owner;
import com.example.BookMyShowCloneAPI.entity.ProductionHouse;
import com.example.BookMyShowCloneAPI.exception.OwnerIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.ProductionHouseIdNotFoundException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class ProductionHouseService {

	@Autowired
	private ProductionHouseDao houseDao;
	@Autowired
	private ModelMapper modelmapper;
	@Autowired
	private OwnerDao ownerDao;
	
	public ResponseEntity<ResponseStructure<ProductionHouse>> saveHouse(long ownerId,ProductionHouseDto houseDto){
		
		Owner owner=ownerDao.findOwner(ownerId);
		if(owner !=null) {
			ProductionHouse productionHouse=this.modelmapper.map(houseDto, ProductionHouse.class);
			if(owner.getProductionHouses().isEmpty()) {
				List<ProductionHouse>list=new ArrayList<ProductionHouse>();
				list.add(productionHouse);
				owner.setProductionHouses(list);
			}else {
				List<ProductionHouse>list=owner.getProductionHouses();
				list.add(productionHouse);
				owner.setProductionHouses(list);
			}
			productionHouse.setOwner(owner);
			ProductionHouse dbproductionHouse=houseDao.saveHouse(productionHouse);
			
			ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
			structure.setMessage("Production House added successsfully !");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dbproductionHouse);
			
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.CREATED);	
		}
		else {
			throw new OwnerIdNotFoundException("sorry ! failed to save productionHouse");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<ProductionHouse>> findHouse(long houseId){
		ProductionHouse productionHouse=houseDao.findProductionHouse(houseId);
		if(productionHouse!=null) {
			ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
			structure.setMessage("ProductionHouse fetched sucessfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(productionHouse);
			
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.FOUND);
		}else
		{
			throw new ProductionHouseIdNotFoundException("sorry ! Failed to fetch ProductionHouse");
		}
	}



	
	public ResponseEntity<ResponseStructure<ProductionHouse>> deleteHouse(long houseId) {
		ProductionHouse productionHouse=houseDao.deleteHouse(houseId);
		if(productionHouse!=null) {
			ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
			structure.setMessage("ProductionHouse deleted successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(productionHouse);
			
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.OK);
		}
		else {
			throw new ProductionHouseIdNotFoundException("sorry ! failed to delete ProductionHouse");
		}
	}

	public ResponseEntity<ResponseStructure<ProductionHouse>> updateHouse(long houseId,ProductionHouseDto houseDto){
		ProductionHouse house=this.modelmapper.map(houseDto, ProductionHouse.class);
		ProductionHouse dbHouse=houseDao.updateHouse(houseId, house);
		if(dbHouse!=null) {
			ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
			structure.setMessage("updated ProductionHouse successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbHouse);
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.OK);
		}
		else {
			throw new ProductionHouseIdNotFoundException("Sorry ! Failed to updated ProductionHouse");
		}
		
	}
}