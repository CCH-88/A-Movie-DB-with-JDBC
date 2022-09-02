package com.example.webapimoviedb.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;
    @Column(length = 100)
    private String description;

    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}


/*
    • Autoincremented Id
    • Name
    • Description

    Characters and movies
    One movie contains many characters, and a character can play in multiple movies.
    Movies and franchises
    One movie belongs to one franchise, but a franchise can contain many movies.
*/