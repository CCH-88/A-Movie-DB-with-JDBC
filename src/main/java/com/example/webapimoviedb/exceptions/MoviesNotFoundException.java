package com.example.webapimoviedb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MoviesNotFoundException extends RuntimeException {
    public MoviesNotFoundException(int id) {
        super("Movie does not exist with ID: " + id);
    }
    public MoviesNotFoundException(String message) {
        super(message);
    }
    public MoviesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public MoviesNotFoundException(Throwable cause) {
        super(cause);
    }
    public MoviesNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
