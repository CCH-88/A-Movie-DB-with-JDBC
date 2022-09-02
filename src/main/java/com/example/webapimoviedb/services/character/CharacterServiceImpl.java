package com.example.webapimoviedb.services.character;


import com.example.webapimoviedb.models.Character;
import com.example.webapimoviedb.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Implementation of the Character service.
 * Uses the Character repository to interact with the data store.
 * Logs errors through the standard logger.
 */

@Service
public class CharacterServiceImpl implements CharacterService {

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * @param integer
     * @return
     */
    @Override
    public Character findById(Integer integer) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Character> findAll() {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Character add(Character entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Character update(Character entity) {
        return null;
    }

    /**
     * @param integer
     */
    @Override
    public void deleteById(Integer integer) {

    }

    /**
     * @param integer
     * @return
     */
    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}