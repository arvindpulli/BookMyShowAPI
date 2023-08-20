package com.example.BookMyShowCloneAPI.dto;

import com.example.BookMyShowCloneAPI.enums.ScreenAvailability;
import com.example.BookMyShowCloneAPI.enums.ScreenStatus;
import com.example.BookMyShowCloneAPI.enums.ScreenType;

public class ScreenDto {
	private long screenId;
	private String screenName;
	//screenType
	private ScreenType screenType;
	//screenAvailability
	private ScreenAvailability screenAvailability;
	//screenStatus
	private ScreenStatus screenStatus;
	
	private int noOfClassicSeat;
	private int noOfPlatinumSeat;
	private int noOfGoldSeat;
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
