package com.example.BookMyShowCloneAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookMyShowCloneAPI.dao.MovieDao;
import com.example.BookMyShowCloneAPI.dao.MovieShowDao;
import com.example.BookMyShowCloneAPI.dao.ScreenDao;
import com.example.BookMyShowCloneAPI.dao.TheaterDao;
import com.example.BookMyShowCloneAPI.dto.MovieShowDto;
import com.example.BookMyShowCloneAPI.entity.Movie;
import com.example.BookMyShowCloneAPI.entity.MovieShow;
import com.example.BookMyShowCloneAPI.entity.Screen;
import com.example.BookMyShowCloneAPI.entity.Theater;
import com.example.BookMyShowCloneAPI.enums.ScreenAvailability;
import com.example.BookMyShowCloneAPI.exception.MovieIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.MovieShowIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.ScreenAlreadyAlloted;
import com.example.BookMyShowCloneAPI.exception.ScreenIdNotFoundException;
import com.example.BookMyShowCloneAPI.exception.TheaterIdNotFoundException;
import com.example.BookMyShowCloneAPI.util.ResponseStructure;

@Service
public class MovieShowService {

	@Autowired
	private MovieShowDao showDao;
	
	@Autowired
	private TheaterDao theaterDao;
	
	@Autowired
	private ScreenDao screenDao;

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private MovieDao movieDao;
	
	public ResponseEntity<ResponseStructure<MovieShow>> saveMovieShow(long theaterId,MovieShowDto showDto) {
		Theater dbTheater=theaterDao.findTheater(theaterId);
		if(dbTheater!=null) {
			MovieShow movieShow=this.modelmapper.map(showDto, MovieShow.class);
			long screenId=movieShow.getScreenId();
			Screen dbScreen=screenDao.findScreen(screenId);
			if(dbScreen!=null) {
				if(dbScreen.getScreenAvailability().equals(ScreenAvailability.NOT_ALLOTED)) {
					long movieId=movieShow.getMovieId();
					Movie dbMovie=movieDao.findMovie(movieId);
					if(dbMovie!=null) {
						movieShow.setMovieDescription(dbMovie.getMovieDescription());
						movieShow.setMovieLanguage(dbMovie.getMovieLanguage());
						movieShow.setMovieName(dbMovie.getMovieName());
						movieShow.setScreenName(dbScreen.getScreenName());
						movieShow.setTheater(dbTheater);
						MovieShow dbShow=showDao.saveMovieShow(movieShow);
						
						if(dbTheater.getShow().isEmpty()) {
							List<MovieShow>list=new ArrayList<MovieShow>();
							list.add(movieShow);
							dbTheater.setShow(list);
							theaterDao.updateTheater(theaterId, dbTheater);
						}else {
							List<MovieShow>list=dbTheater.getShow();
							list.add(movieShow);
							dbTheater.setShow(list);
							theaterDao.updateTheater(theaterId, dbTheater);
						}
						ResponseStructure<MovieShow>structure=new ResponseStructure<MovieShow>();
						structure.setMessage("Show added successfully !");
						structure.setStatus(HttpStatus.CREATED.value());
						structure.setData(dbShow);
						return new ResponseEntity<ResponseStructure<MovieShow>>(structure,HttpStatus.CREATED);
					}else {
						throw new MovieIdNotFoundException("Sorry ! failed to add show");
					}
				}else {
					throw new ScreenAlreadyAlloted("Sorry ! failed to add show");
				}
			}else {
				throw new ScreenIdNotFoundException("Sorry ! failed to add show");
			}
		}else {
			throw new TheaterIdNotFoundException("Sorry ! failed to add show");
		}
	}
	
	public ResponseEntity<ResponseStructure<MovieShow>> findMovieShow(long showId){
		MovieShow show=showDao.findMovieShow(showId);
		if(show!=null) {
			ResponseStructure<MovieShow>structure=new ResponseStructure<MovieShow>();
			structure.setMessage("movie show fetched successfully !");
			structure.setStatus(HttpStatus.FOUND .value());
			structure.setData(show);
			return new ResponseEntity<ResponseStructure<MovieShow>>(structure,HttpStatus.FOUND);
		}else {
			throw new MovieShowIdNotFoundException("Sorry ! failed to fetch movie show");
		}
	}
	
	public ResponseEntity<ResponseStructure<MovieShow>> deleteMovieShow(long showId){
		MovieShow show=showDao.deleteMovieShow(showId);
		if(show!=null) {
			ResponseStructure<MovieShow>structure=new ResponseStructure<MovieShow>();
			structure.setMessage("movie show deleted successfully !");
			structure.setStatus(HttpStatus.OK .value());
			structure.setData(show);
			return new ResponseEntity<ResponseStructure<MovieShow>>(structure,HttpStatus.OK);
		}else {
			throw new MovieShowIdNotFoundException("Sorry ! failed to delete movie show");
		}
	}
	
	public ResponseEntity<ResponseStructure<MovieShow>> updateMovieShow(long showId,MovieShowDto movieShowDto){
		MovieShow movieShow=this.modelmapper.map(movieShowDto, MovieShow.class);
		MovieShow show=showDao.updateMovieShow(showId,movieShow);
		if(show!=null) {
			ResponseStructure<MovieShow>structure=new ResponseStructure<MovieShow>();
			structure.setMessage("movie show updated successfully !");
			structure.setStatus(HttpStatus.OK .value());
			structure.setData(show);
			return new ResponseEntity<ResponseStructure<MovieShow>>(structure,HttpStatus.OK);
		}else {
			throw new MovieShowIdNotFoundException("Sorry ! failed to update movie show");
		}
	}
	
}
