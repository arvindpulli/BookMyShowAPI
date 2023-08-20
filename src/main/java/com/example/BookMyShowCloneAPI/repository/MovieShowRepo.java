package com.example.BookMyShowCloneAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShowCloneAPI.entity.MovieShow;

public interface MovieShowRepo extends JpaRepository<MovieShow,Long> {

}
