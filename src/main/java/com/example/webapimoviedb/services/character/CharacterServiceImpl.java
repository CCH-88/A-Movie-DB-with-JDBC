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

public class CharacterServiceImpl  {


}