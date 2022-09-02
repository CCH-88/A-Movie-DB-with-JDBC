package com.example.webapimoviedb.models;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String alias;
    @Column(length = 50)
    private String gender;
    @Column(length = 100)
    private String pictureUrl;

    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;


}

/*
    • Autoincremented Id
    • Full name
    • Alias (if applicable)?
    • Gender?
    • Picture (URL to photo – do not store an image)?

    Characters and movies
    One movie contains many characters, and a character can play in multiple movies.

    One movie belongs to one franchise, but a franchise can contain many movies.
*/
