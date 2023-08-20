package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Owner;
import com.example.BookMyShowCloneAPI.entity.ProductionHouse;
import com.example.BookMyShowCloneAPI.repository.OwnerRepo;
import com.example.BookMyShowCloneAPI.repository.ProductionHouseRepo;

@Repository
public class ProductionHouseDao {

	@Autowired
	private ProductionHouseRepo repo;
	
	public ProductionHouse saveHouse(ProductionHouse house) {
		return repo.save(house);
	}


	public ProductionHouse findProductionHouse(long houseId) {
		Optional<ProductionHouse>optional=repo.findById(houseId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


	public ProductionHouse deleteHouse(long houseId) {
		Optional<ProductionHouse>optional=repo.findById(houseId);
		if(optional.isPresent()) {
			ProductionHouse house=optional.get();
			house.setOwner(null);
			house.setMovies(null);
			
			repo.delete(house);
			return optional.get();
		}
		return null;
	}
	
	public ProductionHouse updateHouse(long houseId,ProductionHouse house) {
		Optional<ProductionHouse>optional=repo.findById(houseId);
		if(optional.isPresent()) {
			house.setProductionHouseId(houseId);
			house.setOwner(optional.get().getOwner());
			house.setMovies(optional.get().getMovies());
			repo.save(house);
			return house;
		}
		return null;
	}
}
