package com.example.BookMyShowCloneAPI.entity;

import java.time.LocalDateTime;

import com.example.BookMyShowCloneAPI.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movieId;
	@NotNull(message = "Movie name can't be null")
	@NotBlank(message = "Movie name can't be blank")
	private String movieName;
	private LocalDateTime movieDuration;
	//genres
	private Genre genre1;
	private Genre genre2;
	private Genre genre3;
	private String movieDescription;
	@NotNull(message = "movie language can't be null")
	@NotBlank(message = "movie language can't be blank")
	private String movieLanguage;
	
	@ManyToOne
	@JsonIgnore
	private ProductionHouse productionHouse;

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

	public LocalDateTime getMovieDuration() {
		return movieDuration;
	}

	
	public Genre getGenre1() {
		return genre1;
	}

	public void setGenre1(Genre genre1) {
		this.genre1 = genre1;
	}

	public Genre getGenre2() {
		return genre2;
	}

	public void setGenre2(Genre genre2) {
		this.genre2 = genre2;
	}

	public Genre getGenre3() {
		return genre3;
	}

	public void setGenre3(Genre genre3) {
		this.genre3 = genre3;
	}

	public void setMovieDuration(LocalDateTime movieDuration) {
		this.movieDuration = movieDuration;
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

	public ProductionHouse getProductionHouse() {
		return productionHouse;
	}

	public void setProductionHouse(ProductionHouse productionHouse) {
		this.productionHouse = productionHouse;
	}
	
	
}
