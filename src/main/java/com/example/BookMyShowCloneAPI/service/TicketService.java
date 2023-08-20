package com.example.BookMyShowCloneAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookMyShowCloneAPI.dao.BookingDao;
import com.example.BookMyShowCloneAPI.dao.CustomerDao;
import com.example.BookMyShowCloneAPI.dao.MovieShowDao;
import com.example.BookMyShowCloneAPI.dao.SeatDao;
import com.example.BookMyShowCloneAPI.dao.TicketDao;
import com.example.BookMyShowCloneAPI.dto.BookingDto;
import com.example.BookMyShowCloneAPI.entity.Booking;
import com.example.BookMyShowCloneAPI.entity.Customer;
import com.example.BookMyShowCloneAPI.entity.MovieShow;
import com.example.BookMyShowCloneAPI.entity.Seat;
import com.example.BookMyShowCloneAPI.entity.Ticket;
import com.example.BookMyShowCloneAPI.enums.BookingStatus;
import com.example.BookMyShowCloneAPI.enums.SeatType;
import com.example.BookMyShowCloneAPI.enums.ShowStatus;
import com.example.BookMyShowCloneAPI.enums.TicketStatus;
import com.example.BookMyShowCloneAPI.exception.CustomerIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.MovieShowIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.MovieShowIsNotActiveException;
import com.example.BookMyShowCloneAPI.exception.SeatIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.TicketAlreadyCancelledException;
import com.example.BookMyShowCloneAPI.exception.TicketAlredyExpiedException;
import com.example.BookMyShowCloneAPI.exception.TicketCanNotCancelledException;
import com.example.BookMyShowCloneAPI.exception.TicketIdNotFoundException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private MovieShowDao showDao;
	
	@Autowired
	private SeatDao seatDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	public ResponseEntity<ResponseStructure<Ticket>>saveTicket(long customerId,long showId,long seatId){
		Customer dbCustomer=customerDao.findCustomer(customerId);
		Ticket ticket=new Ticket();
		if(dbCustomer!=null) {
			ticket.setCustomer(dbCustomer);
		}else {
			throw new CustomerIdNotFoundException("Sorry ! Failed to book ticket");
		}
		MovieShow dbMovieShow=showDao.findMovieShow(showId);
		if(dbMovieShow!=null) {
			if(dbMovieShow.getShowStatus().equals(ShowStatus.ACTIVE)) {
				ticket.setShow(dbMovieShow);
			}else {
				throw new MovieShowIsNotActiveException("Sorry ! failed to book ticket");
			}
		}else {
			throw new MovieShowIdNotFoundException("Sorry ! failed to book ticket");
		}
		
		List<Booking>bookings=new ArrayList<Booking>();
		List<Seat>seats=new ArrayList<Seat>();
		double totalPrice=0;
		Seat dbSeat=seatDao.findSeat(seatId);
		if(dbSeat!=null) {
			Booking booking=new Booking();
			booking.setSeatId(dbSeat.getSeatId());
			booking.setSeatType(dbSeat.getSeatType());
			booking.setBookingStatus(BookingStatus.ACTIVE);
			booking.setBookingFromTime(dbMovieShow.getShowStartTime());
			booking.setBookingTillTime(dbMovieShow.getShowEndTime());
			
			SeatType seatType=booking.getSeatType();
			switch(seatType) {
			case CLASSIC:
				booking.setSeatPrice(dbMovieShow.getClassicSeatPrice());
				totalPrice+=dbMovieShow.getClassicSeatPrice();
				break;
			
			
			case GOLD:
				booking.setSeatPrice(dbMovieShow.getGoldSeatPrice());
				totalPrice+=dbMovieShow.getGoldSeatPrice();
				break;
			
		
			case PLATINUM:
				booking.setSeatPrice(dbMovieShow.getPreminumSeatPrice());
				totalPrice+=dbMovieShow.getPreminumSeatPrice();
				break;
	}
			bookings.add(booking);
			seats.add(dbSeat);
			bookingDao.saveBooking(booking);
			
			ticket.setBooking(bookings);
			ticket.setTotalPrice(totalPrice);
			ticket.setTicketStatus(TicketStatus.ACTIVE);
			Ticket dbTicket=ticketDao.saveTicket(ticket);
			
			ResponseStructure<Ticket>structure=new ResponseStructure<Ticket>();
			structure.setMessage("Ticket booked successfully !");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dbTicket);
			return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.CREATED);
}else {
	throw new SeatIdNotFoundException("Sorry ! failed to book ticket");
}	
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> cancelTicket(long ticketId){
		Ticket dbTicket=ticketDao.findTicket(ticketId);
		if(dbTicket!=null) {
			if(dbTicket.getShow().getShowStatus().equals(ShowStatus.ON_GOING)) {
				throw new TicketCanNotCancelledException("Sorry failed to cancel ticket ");
			}else {
				if(dbTicket.getTicketStatus().equals(TicketStatus.EXPIRED)) {
					throw new TicketAlredyExpiedException("Sorry failed to cancel ticket");
				}else {
					if(dbTicket.getTicketStatus().equals(TicketStatus.CANCELLED)) {
						throw new TicketAlreadyCancelledException("Sorry failed to cancel ticket");
					}else {
						List<Booking>bookings=dbTicket.getBooking();
						for(Booking b:bookings) {
							b.setBookingStatus(BookingStatus.CAMCELLED);
							bookingDao.saveBooking(b);
						}
						dbTicket.setTicketStatus(TicketStatus.CANCELLED);
						ticketDao.saveTicket(dbTicket);
						
						ResponseStructure<Ticket>structure=new ResponseStructure<Ticket>();
						structure.setMessage("Ticket cancelled successfully !");
						structure.setStatus(HttpStatus.FOUND.value());
						structure.setData(dbTicket);
						
						return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.FOUND);
					}
				}
			}
		}else {
			throw new TicketIdNotFoundException("Sorry failed to cancel ticket");
		}
	}
	
}
