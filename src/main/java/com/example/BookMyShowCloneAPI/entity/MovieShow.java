package com.example.BookMyShowCloneAPI.entity;

import java.time.LocalDateTime;

import com.example.BookMyShowCloneAPI.enums.ShowStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MovieShow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long showId;
	private LocalDateTime showStartTime;
	private LocalDateTime showEndTime;
	private String showLocation;
	private ShowStatus showStatus;
	
	private long movieId;
	private String movieName;
	private String genre;
	private String movieDescription;
	private String movieLanguage;
	
	private long screenId;
	private String screenName;
	private double classicSeatPrice;
	private double goldSeatPrice;
	private double preminumSeatPrice;
	
	@ManyToOne
	@JoinColumn
	private Theater theater;

	public long getShowId() {
		return showId;
	}
	

	public ShowStatus getShowStatus() {
		return showStatus;
	}


	public void setShowStatus(ShowStatus showStatus) {
		this.showStatus = showStatus;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public void setShowId(long showId) {
		this.showId = showId;
	}

	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}

	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}

	public String getShowLocation() {
		return showLocation;
	}

	public void setShowLocation(String showLocation) {
		this.showLocation = showLocation;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

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

	public double getClassicSeatPrice() {
		return classicSeatPrice;
	}

	public void setClassicSeatPrice(double classicSeatPrice) {
		this.classicSeatPrice = classicSeatPrice;
	}

	public double getGoldSeatPrice() {
		return goldSeatPrice;
	}

	public void setGoldSeatPrice(double goldSeatPrice) {
		this.goldSeatPrice = goldSeatPrice;
	}

	public double getPreminumSeatPrice() {
		return preminumSeatPrice;
	}

	public void setPreminumSeatPrice(double preminumSeatPrice) {
		this.preminumSeatPrice = preminumSeatPrice;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	
}
