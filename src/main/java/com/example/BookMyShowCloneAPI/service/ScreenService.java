package com.example.BookMyShowCloneAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookMyShowCloneAPI.dao.ScreenDao;
import com.example.BookMyShowCloneAPI.dao.TheaterDao;
import com.example.BookMyShowCloneAPI.dto.ScreenDto;
import com.example.BookMyShowCloneAPI.entity.Screen;
import com.example.BookMyShowCloneAPI.entity.Seat;
import com.example.BookMyShowCloneAPI.entity.Theater;
import com.example.BookMyShowCloneAPI.enums.ScreenAvailability;
import com.example.BookMyShowCloneAPI.enums.ScreenStatus;
import com.example.BookMyShowCloneAPI.enums.SeatType;
import com.example.BookMyShowCloneAPI.exception.ScreenIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.TheaterIdNotFoundException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class ScreenService {

	@Autowired
	private ScreenDao screenDao;
	
	@Autowired
	private TheaterDao theaterDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructure<ScreenDto>> saveScreen(long theaterId,ScreenDto screenDto){
		Theater theater=theaterDao.findTheater(theaterId);
		if(theater!=null) {
			Screen screen=this.modelMapper.map(screenDto, Screen.class);
			
			List<Seat> seats=new ArrayList<Seat>();
			for(int a=screen.getNoOfClassicSeat();a>0;a--) {
				Seat seat=new Seat();
				seat.setSeatType(SeatType.CLASSIC);
				seat.setScreen(screen);
				seats.add(seat);
			}
			
			for(int b=screen.getNoOfGoldSeat();b>0;b--) {
				Seat seat=new Seat();
				seat.setSeatType(SeatType.GOLD);
				seat.setScreen(screen);
				seats.add(seat);
			}
			
			for(int c=screen.getNoOfPlatinumSeat();c>0;c--) {
				Seat seat=new Seat();
				seat.setSeatType(SeatType.PLATINUM);
				seat.setScreen(screen);
				seats.add(seat);
			}
			
			screen.setTheater(theater);
			screen.setSeats(seats);
			screen.setScreenAvailability(ScreenAvailability.NOT_ALLOTED);
			screen.setScreenStatus(ScreenStatus.AVAILABLE);
			
			Screen dbScreen=screenDao.saveScreen(screen);
			
			if(theater.getScreens().isEmpty()) {
				List<Screen> list=new ArrayList<Screen>();
				list.add(dbScreen);
				theater.setScreens(list);
				theaterDao.updateTheater(theaterId, theater);
			}else {
				List<Screen>list=theater.getScreens();
				list.add(dbScreen);
				theater.setScreens(list);
				theaterDao.updateTheater(theaterId, theater);
			}
			
			ScreenDto dto=this.modelMapper.map(dbScreen, ScreenDto.class);
			ResponseStructure<ScreenDto>structure=new ResponseStructure<ScreenDto>();
			structure.setMessage("Screen added successfully !");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.CREATED);
			
		}else {
			throw new TheaterIdNotFoundException("Sorry ! failed to add theater");
		}
	}

	public ResponseEntity<ResponseStructure<ScreenDto>> findScreen(long screenId) {
		Screen screen=screenDao.findScreen(screenId);
		if(screen!=null) {
			ResponseStructure<ScreenDto>structure=new ResponseStructure<ScreenDto>();
			structure.setMessage("Screen fetched successfully !");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(this.modelMapper.map(screen, ScreenDto.class));
			return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new ScreenIdNotFoundException("Sorry ! failed to fetch screen");
		}
	}
	
	public ResponseEntity<ResponseStructure<ScreenDto>> deleteScreen(long screenId) {
		Screen screen=screenDao.deleteScreen(screenId);
		if(screen!=null) {
			ResponseStructure<ScreenDto>structure=new ResponseStructure<ScreenDto>();
			structure.setMessage("Screen deleted successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(this.modelMapper.map(screen, ScreenDto.class));
			return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.OK);
		}else {
			throw new ScreenIdNotFoundException("Sorry ! failed to Delete screen");
		}
	}

	public ResponseEntity<ResponseStructure<ScreenDto>> updateScreen(long screenId,ScreenDto screenDto){
		Screen screen=this.modelMapper.map(screenDto, Screen.class);
		Screen dbScreen=screenDao.updateScreen(screenId, screen);
		if(dbScreen!=null) {
			ResponseStructure<ScreenDto>structure=new ResponseStructure<ScreenDto>();
			structure.setMessage("Updated Screen successfully !");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(this.modelMapper.map(dbScreen, ScreenDto.class));
			return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.OK);
		}else {
			throw new ScreenIdNotFoundException("Sorry ! failed to update the screen");
		}
		
	}
}
