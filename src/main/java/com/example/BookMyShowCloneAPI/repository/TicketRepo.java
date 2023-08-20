package com.example.BookMyShowCloneAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShowCloneAPI.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket,Long> {

}
