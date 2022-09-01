package com.example.webapimoviedb.models;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 15, nullable = false)
    private String genre;
    @Column(length = 15, nullable = false)
    private String gender;
    @Column(length = 15, nullable = false)
    private int releaseYear;
    @Column(length = 15, nullable = false)
    private String director;
    @Column(length = 15, nullable = false)
    private String pictureUrl;
    @Column(length = 15, nullable = false)
    private String trailerLink;

    @ManyToMany
    @JoinColumn(name = "character_id")
    private Character character;
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