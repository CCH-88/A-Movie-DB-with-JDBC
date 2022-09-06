package com.example.webapimoviedb.services.character;


import com.example.webapimoviedb.exceptions.CharacterNotFoundException;
import com.example.webapimoviedb.models.Character;
import com.example.webapimoviedb.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**

 */
/**
 *  Implementation of the Character service.
 *  Uses the Character repository to interact with the data store.
 *  Logs errors through the standard logger.
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */

@Service
public class CharacterServiceImpl implements CharacterService {

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    /**
     * @return
     */
    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void deleteById(Integer id) {
        if(characterRepository.existsById(id)) {
            // Set relationships to null so we can delete without referential problems
            Character aChar = characterRepository.findById(id).get();
            aChar.getMovies().forEach(s -> s.setCharacters(null));
            characterRepository.delete(aChar);
        }
        else
            logger.warn("No character exists with ID: " + id);

    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean exists(Integer id) {
        return characterRepository.existsById(id);
    }

    @Override
    public Collection<Character> findAllByName(String name) {
        return characterRepository.findAllByName(name);
    }
}