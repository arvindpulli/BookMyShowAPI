package com.example.BookMyShowCloneAPI.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BookMyShowCloneAPI.entity.Ticket;
import com.example.BookMyShowCloneAPI.repository.TicketRepo;

@Repository
public class TicketDao {

	@Autowired
	private TicketRepo repo;
	
	public Ticket saveTicket(Ticket ticket) {
		return repo.save(ticket);
	}
	
	public Ticket findTicket(long ticketId) {
		Optional<Ticket>optional=repo.findById(ticketId);
		if(optional.isPresent()) {
			return optional.get();
		}return null;
	}
	
	
}
