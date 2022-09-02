package com.example.webapimoviedb.services.movie;

import com.example.webapimoviedb.models.Movie;

import com.example.webapimoviedb.repositories.MovieRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class MovieServiceImpl implements MovieService {

    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * @param integer
     * @return
     */
    @Override
    public Movie findById(Integer integer) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Movie> findAll() {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Movie add(Movie entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Movie update(Movie entity) {
        return null;
    }

    /**
     * @param integer
     */
    @Override
    public void deleteById(Integer integer) {

    }

    /**
     * @param integer
     * @return
     */
    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}
