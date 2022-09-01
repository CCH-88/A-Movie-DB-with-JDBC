package com.example.webapimoviedb.services.character;

import com.example.webapimoviedb.exceptions.CharacterNotFoundException;
import com.example.webapimoviedb.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Implementation of the Professor service.
 * Uses the Professor repository to interact with the data store.
 * Logs errors through the standard logger.
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if(characterRepository.existsById(id)) {
            // Set relationships to null so we can delete without referential problems
            Character character = characterRepository.findById(id).get();
            //character.getStudents().forEach(s -> s.setCharacter(null));
            //character.getSubjects().forEach(s -> s.setCharacter(null));
            characterRepository.delete(character);
        }
        else
            logger.warn("No character exists with ID: " + id);
    }

    @Override
    public boolean exists(Integer id) {
        return characterRepository.existsById(id);
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }
}