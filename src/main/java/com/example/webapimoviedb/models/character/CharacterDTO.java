package com.example.webapimoviedb.models.character;

import lombok.Data;


/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

@Data
public class CharacterDTO {
    private int id;
    private String name;
    private String alias;
    private String gender;
    private String pictureUrl;
}
