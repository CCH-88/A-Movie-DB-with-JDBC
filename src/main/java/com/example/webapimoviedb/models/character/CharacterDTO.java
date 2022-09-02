package com.example.webapimoviedb.models.character;

import lombok.Data;

@Data
public class CharacterDTO {
    private int id;
    private String alias;
    private String gender;
    private String pictureUrl;
}
