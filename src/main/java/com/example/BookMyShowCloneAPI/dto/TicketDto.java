package com.example.BookMyShowCloneAPI.dto;

import com.example.BookMyShowCloneAPI.enums.TicketStatus;

public class TicketDto {
	private long ticketId;
	private double totalPrice;
	//ticketStatus
	private TicketStatus ticketStatus;
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	
}
