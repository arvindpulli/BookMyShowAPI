package com.example.BookMyShowCloneAPI.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ownerId;
	@NotNull(message = "Owner name can't be null")
	@NotBlank(message = "owner name can't be blank")
	private String ownerName;
	@Positive(message="phone number can't be zero")
	private long ownerPhone;
	@Email
	private String ownerEmail;
	@NotNull(message = "password can't be null")
	@NotBlank(message = "password can't be blank")
	private String ownerPassword;
	
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private List<ProductionHouse> productionHouses;
	
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private List<Theater> theaters;
	
	
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getOwnerPassword() {
		return ownerPassword;
	}
	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}
	public List<ProductionHouse> getProductionHouses() {
		return productionHouses;
	}
	public void setProductionHouses(List<ProductionHouse> productionHouses) {
		this.productionHouses = productionHouses;
	}
	public List<Theater> getTheaters() {
		return theaters;
	}
	public void setTheaters(List<Theater> theaters) {
		this.theaters = theaters;
	}
	
	
}
