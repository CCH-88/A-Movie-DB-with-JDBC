package com.example.webapimoviedb.models.movie;

import lombok.Data;

@Data
public class movieDTO {
    private int id;
    private String title;
    private int releaseYear;
    private String director;
    private String pictureUrl;
    private String trailerLink;
}

