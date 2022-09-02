package com.example.webapimoviedb.controllers;

import com.example.webapimoviedb.services.character.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

//@RestController
//@RequestMapping(path = "api/v1/test")
public class CharacterController {

    /*
    * @GetMapping, @PostMapping and other annotations configure
    * how URLs are mapped to the controller methods.
    * In this case "ResponseEntity<String> getPublic()"
    *
    * The ResponseEntity generic class helps configure the
    * response object produced by the server.
    *
    * */
    /*@GetMapping("public")
    public ResponseEntity<String> getPublic(){
        return ResponseEntity.ok("Public method");

    }*/

    /*
    * The RequestMapping is a general one. Here you need to specify a path.
    * */
    /*@RequestMapping(method = RequestMethod.GET, path = "baz")
    public ResponseEntity<String> baz() {
        return ResponseEntity.ok().body("Baz!");
    }*/

    //@GetMapping("{id}") // GET: localhost:8080/api/v1/test/1
    /*public ResponseEntity<String> path(@PathVariable int id) {
        return ResponseEntity.ok().body(String.valueOf(id));
    }*/



    /*private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<Collection<Character>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Character character) {
        characterService.add(character);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }*/

}
