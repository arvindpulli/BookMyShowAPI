package com.example.BookMyShowCloneAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShowCloneAPI.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Long> {

}
