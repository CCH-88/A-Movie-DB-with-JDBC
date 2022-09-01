package com.example.webapimoviedb.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String title;
    @Column(length = 15)
    private String genre;
    @Column(length = 15)
    private String gender;
    @Column(length = 15)
    private int releaseYear;
    @Column(length = 15)
    private String director;
    @Column(length = 100)
    private String pictureUrl;
    @Column(length = 15)
    private String trailerLink;

    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;


}

/*
   Autoincremented Id
• Movie title
• Genre (just a simple string of comma separated genres, there is no genre modelling required as a base)
• Release year
• Director (just a string name, no director modelling required as a base)
• Picture (URL to a movie poster)
• Trailer (YouTube link most likely)

    One movie contains many characters, and a character can play in multiple movies.

    One movie belongs to one franchise, but a franchise can contain many movies.
*/