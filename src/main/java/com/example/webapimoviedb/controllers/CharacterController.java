package com.example.webapimoviedb.controllers;

import com.example.webapimoviedb.mappers.CharacterMapper;
import com.example.webapimoviedb.models.Character;
import com.example.webapimoviedb.models.character.CharacterDTO;
import com.example.webapimoviedb.services.character.CharacterService;
import com.example.webapimoviedb.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    private final CharacterMapper characterMapper;
    /*
    *  A base URL is defined and the relevant service is injected.
    *
    * */

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    /*
    * The getAll methods gets all the characters in the tabel character.
    * */
    @Operation(summary = "Get all characters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class))) })
    })
    @GetMapping // GET: localhost:8081/api/v1/characters
    public ResponseEntity<Collection<Character>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    /*
     * The findById methods gets the characters with the provided id.
     * */
    @Operation(summary = "Gets a character by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Character with supplied ID does not exist",
                    content = @Content)
    })
    @GetMapping("{id}") // GET: localhost:8081/api/v1/characters/1
    public ResponseEntity findById(@PathVariable int id) {

        CharacterDTO aChar = characterMapper.characterToCharacterDTO(
                characterService.findById(id)
        );
        return ResponseEntity.ok(aChar);
    }

    /*
     * The findByName method searches for the characters with the provided name.
     * */
    @Operation(summary = "Searches after character by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Character with supplied ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("search") // GET: localhost:8081/api/v1/characters/search?name=Thor
    public ResponseEntity<Collection<Character>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(characterService.findAllByName(name));
    }
    @Operation(summary = "Adds new Character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "New character added",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Character with supplied ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PostMapping // POST: localhost:8081/api/v1/characters
    public ResponseEntity add(@RequestBody Character character) {
        Character aChar = characterService.add(character);
        URI location = URI.create("characters/" + aChar.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Updates a character")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Character successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Character with supplied ID not found ",
                    content = @Content)
    })
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/characters/1
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        // Validates if body is correct
        /*if(id != aCharacter.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(aCharacter);
        return ResponseEntity.noContent().build();*/

        if(id != characterDTO.getId())
            return ResponseEntity.notFound().build();
        characterService.update(
                characterMapper.characterDTOToCharacter(characterDTO)
        );
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deletes a character")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "410",
                    description = "Character successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Character with supplied ID not found ",
                    content = @Content)
    })
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/characters/1
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
