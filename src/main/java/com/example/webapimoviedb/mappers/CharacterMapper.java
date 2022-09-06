package com.example.webapimoviedb.mappers;

import com.example.webapimoviedb.models.Character;
import com.example.webapimoviedb.models.character.CharacterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */
@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterDTO characterToCharacterDTO(Character character);

    // Mapping the other way
    @Mapping(target = "movies", ignore = true)
    Character characterDTOToCharacter(CharacterDTO characterDTO);
}
