package com.example.webapimoviedb.controllers;

import com.example.webapimoviedb.models.Character;
import com.example.webapimoviedb.services.character.CharacterService;
import com.example.webapimoviedb.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */
@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {


    private final CharacterService characterService;

    /*
    *  Abase URL is defined and the relevant service is injected.
    *
    * */

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /*
    * The getAll methods gets all the characters in the tabel character.
    * */
    @GetMapping // GET: localhost:8081/api/v1/characters
    public ResponseEntity<Collection<Character>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    /*
     * The getById methods gets the characters with the provided id.
     * */
    @GetMapping("{id}") // GET: localhost:8081/api/v1/characters/1
    public ResponseEntity<Character> getById(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    /*
     * The findByName method searches for the characters with the provided name.
     * */
    @GetMapping("search") // GET: localhost:8081/api/v1/characters/search?name=Thor
    public ResponseEntity<Collection<Character>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(characterService.findAllByName(name));
    }

    @PostMapping // POST: localhost:8081/api/v1/characters
    public ResponseEntity add(@RequestBody Character character) {
        Character aChar = characterService.add(character);
        URI location = URI.create("characters/" + aChar.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/characters/1
    public ResponseEntity update(@RequestBody Character aCharacter, @PathVariable int id) {
        // Validates if body is correct
        if(id != aCharacter.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(aCharacter);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/characters/1
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
