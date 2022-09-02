package com.example.webapimoviedb.repositories;

import com.example.webapimoviedb.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}

