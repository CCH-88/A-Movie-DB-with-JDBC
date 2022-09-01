package com.example.webapimoviedb.services.movie;

import com.example.webapimoviedb.models.Movie;
import com.example.webapimoviedb.services.CrudService;
import org.springframework.stereotype.Service;


public interface MovieService extends CrudService<Movie, Integer> {
}
