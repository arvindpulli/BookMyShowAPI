package com.example.BookMyShowCloneAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	@Positive(message = "flat number can't be zero")
	private int flatNumber;
	@NotNull(message = "area can't be null")
	@NotBlank(message = "area can't be blank")
	private String area;
	@NotNull(message = "landmark can't be null")
	@NotBlank(message = "landmark can't be blank")
	private String landmark;
	@NotNull(message = "city can't be null")
	@NotBlank(message = "city can't be blank")
	private String city;
	@NotNull(message = "state can't be null")
	@NotBlank(message = "state can't be blank")
	private String state;
	@NotNull(message = "country can't be null")
	@NotBlank(message = "country can't be blank")
	private String country;
	@Positive(message = "pincode number can't be zero")
	private long pincode;
	
	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private Theater theater;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	
}
