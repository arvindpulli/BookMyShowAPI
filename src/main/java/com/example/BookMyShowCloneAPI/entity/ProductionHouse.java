package com.example.BookMyShowCloneAPI.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProductionHouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productionHouseId;
	@NotNull(message = "house name can't be null")
	@NotBlank(message = "house name can't be blank")
	private String prooductionHouseName;
	private LocalDate establishment;
	
	@ManyToOne
	@JoinColumn
	private Owner owner;
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "productionHouse")
	private List<Movie> movies;
	
	
	
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
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}
