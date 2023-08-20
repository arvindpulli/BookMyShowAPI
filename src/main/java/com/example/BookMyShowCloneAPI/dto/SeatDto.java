package com.example.BookMyShowCloneAPI.dto;

import com.example.BookMyShowCloneAPI.enums.SeatType;

public class SeatDto {

	private long seatId;
	//seatType
	private SeatType seatType;

	public long getSeatId() {
		return seatId;
	}

	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	
	
}
