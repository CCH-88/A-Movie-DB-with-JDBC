package com.example.webapimoviedb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CharacterNotFoundException {
    public CharacterNotFoundException(int id) {
        super();
    }
}

