package com.example.BookMyShowCloneAPI.dto;

import java.time.LocalDate;

public class ProductionHouseDto {
	private long productionHouseId;
	private String prooductionHouseName;
	private LocalDate establishment;
	public long getProductionHouseId() {
		return productionHouseId;
	}
	public void setProductionHouseId(long productionHouseId) {
		this.productionHouseId = productionHouseId;
	}
	public String getProoductionHouseName() {
		return prooductionHouseName;
	}
	public void setProoductionHouseName(String prooductionHouseName) {
		this.prooductionHouseName = prooductionHouseName;
	}
	public LocalDate getEstablishment() {
		return establishment;
	}
	public void setEstablishment(LocalDate establishment) {
		this.establishment = establishment;
	}
	
}
