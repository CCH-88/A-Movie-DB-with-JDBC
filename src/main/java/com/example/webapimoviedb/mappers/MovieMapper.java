package com.example.webapimoviedb.mappers;

import com.example.webapimoviedb.models.Movie;
import com.example.webapimoviedb.models.movie.MovieDTO;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO movieToMovieDTO(Movie movie);
    @Mapping(target = "student", ignore = true)
    Movie movieToMovieDTO(Movie movie);
}
