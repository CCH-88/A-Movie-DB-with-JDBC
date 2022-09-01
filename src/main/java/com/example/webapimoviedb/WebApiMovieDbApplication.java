package com.example.webapimoviedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class WebApiMovieDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApiMovieDbApplication.class, args);
    }

}
