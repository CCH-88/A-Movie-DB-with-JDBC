package com.example.webapimoviedb.repositories;

import com.example.webapimoviedb.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Integer> {

}

