package com.example.webapimoviedb.services.character;


import com.example.webapimoviedb.models.Character;
import com.example.webapimoviedb.services.CrudService;

import java.util.Collection;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

public interface CharacterService extends CrudService<Character, Integer> {

    Collection<Character> findAllByName(String name);
}
