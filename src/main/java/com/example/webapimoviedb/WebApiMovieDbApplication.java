package com.example.webapimoviedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.webapimoviedb.controllers")
//@EnableJpaRepositories(basePackages = "com.example.webapimoviedb.repositories")
//@EntityScan(basePackages = "com.example.webapimoviedb.models")

public class WebApiMovieDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApiMovieDbApplication.class, args);
    }

}
