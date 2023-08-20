package com.example.BookMyShowCloneAPI.entity;

import java.util.List;

import com.example.BookMyShowCloneAPI.enums.ScreenAvailability;
import com.example.BookMyShowCloneAPI.enums.ScreenStatus;
import com.example.BookMyShowCloneAPI.enums.ScreenType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long screenId;
	
	@NotNull(message = "screen name can't be null")
	@NotBlank(message = "screen name can't be blank")
	private String screenName;
	//screenType
		private ScreenType screenType;
		//screenAvailability
		private ScreenAvailability screenAvailability;
		//screenStatus
		private ScreenStatus screenStatus;
	
		
	@OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
	private List<Seat> seats;
	
	private int noOfClassicSeat;
	private int noOfPlatinumSeat;
	private int noOfGoldSeat;
	
	@ManyToOne
	@JoinColumn
	private Theater theater;

	public long getScreenId() {
		return screenId;
	}

	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public int getNoOfClassicSeat() {
		return noOfClassicSeat;
	}

	public void setNoOfClassicSeat(int noOfClassicSeat) {
		this.noOfClassicSeat = noOfClassicSeat;
	}

	public int getNoOfPlatinumSeat() {
		return noOfPlatinumSeat;
	}

	public void setNoOfPlatinumSeat(int noOfPlatinumSeat) {
		this.noOfPlatinumSeat = noOfPlatinumSeat;
	}

	public int getNoOfGoldSeat() {
		return noOfGoldSeat;
	}

	public void setNoOfGoldSeat(int noOfGoldSeat) {
		this.noOfGoldSeat = noOfGoldSeat;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public ScreenType getScreenType() {
		return screenType;
	}

	public void setScreenType(ScreenType screenType) {
		this.screenType = screenType;
	}

	public ScreenAvailability getScreenAvailability() {
		return screenAvailability;
	}

	public void setScreenAvailability(ScreenAvailability screenAvailability) {
		this.screenAvailability = screenAvailability;
	}

	public ScreenStatus getScreenStatus() {
		return screenStatus;
	}

	public void setScreenStatus(ScreenStatus screenStatus) {
		this.screenStatus = screenStatus;
	}
	
	
}
