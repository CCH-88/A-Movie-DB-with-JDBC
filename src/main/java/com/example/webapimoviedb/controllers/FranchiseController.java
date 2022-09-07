package com.example.webapimoviedb.controllers;

import com.example.webapimoviedb.mappers.FranchiseMapper;
import com.example.webapimoviedb.models.Character;
import com.example.webapimoviedb.models.Franchise;
import com.example.webapimoviedb.models.character.CharacterDTO;
import com.example.webapimoviedb.models.franchise.FranchiseDTO;
import com.example.webapimoviedb.services.franchise.FranchiseService;
import com.example.webapimoviedb.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchise")
public class FranchiseController {

        private final FranchiseService franchiseService;
        private final FranchiseMapper franchiseMapper;


        public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper){
            this.franchiseService = franchiseService;
            this.franchiseMapper = franchiseMapper;
        }

        /*
         * The findById methods gets the franchises with the provided id.
         * */
        @Operation(summary = "Gets a franchise by ID")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Success",
                        content = { @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Franchise.class)) }),
                @ApiResponse(responseCode = "404",
                        description = "Franchise with supplied ID does not exist",
                        content = @Content)
        })
        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable int id) {
            FranchiseDTO franchiseDTO = franchiseMapper.franchiseToFranchiseDto(
                    franchiseService.findById(id)
            );
            return ResponseEntity.ok(franchiseDTO);
        }

        /*
         * The getAll methods gets all the franchises in the tabel franchise.
         * */
        @Operation(summary = "Get all franchises")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Success",
                        content = {
                                @Content(
                                        mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = FranchiseDTO.class))) })
        })
        @GetMapping
        public ResponseEntity<Collection<Franchise>> getAll() {
            return ResponseEntity.ok(franchiseService.findAll());
        }

        /*
         * The findByName method searches for the franchises with the provided name.
         * */
        @Operation(summary = "Searches after franchises by name")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Success",
                        content = { @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Franchise.class)) }),
                @ApiResponse(responseCode = "404",
                        description = "Character with supplied ID does not exist",
                        content = { @Content(mediaType = "application/json",
                                schema = @Schema(implementation = ApiErrorResponse.class)) })
        })
        @GetMapping("search")
        public ResponseEntity<Collection<Franchise>> findByName(@RequestParam String name){
            return ResponseEntity.ok(franchiseService.findAllByName(name));
        }

        @Operation(summary = "Adds a franchise")
        @ApiResponses( value = {
                @ApiResponse(responseCode = "204",
                        description = "Franchise successfully added",
                        content = @Content),
                @ApiResponse(responseCode = "400",
                        description = "Malformed request",
                        content = @Content),
                @ApiResponse(responseCode = "404",
                        description = "Franchise with supplied ID not found ",
                        content = @Content)
        })
        @PostMapping
        public ResponseEntity add(@RequestBody Franchise franchise){
            Franchise franch = franchiseService.add(franchise);
            URI location = URI.create("franchises/" + franchise.getId());
            return ResponseEntity.created(location).build();
        }

        @Operation(summary = "Updates a franchise")
        @ApiResponses( value = {
                @ApiResponse(responseCode = "204",
                        description = "Franchise successfully updated",
                        content = @Content),
                @ApiResponse(responseCode = "400",
                        description = "Malformed request",
                        content = @Content),
                @ApiResponse(responseCode = "404",
                        description = "Character with supplied ID not found ",
                        content = @Content)
        })
        @PutMapping("{id}")
        public ResponseEntity updateFranchise(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
            if(id != franchiseDTO.getId())
                return ResponseEntity.notFound().build();
            franchiseService.update(
                    franchiseMapper.franchiseDtoToFranchise(franchiseDTO)
            );

            return ResponseEntity.noContent().build();
        }

        @Operation(summary = "Deletes a franchise")
        @ApiResponses( value = {
                @ApiResponse(responseCode = "410",
                        description = "Character successfully deleted",
                        content = @Content),
                @ApiResponse(responseCode = "400",
                        description = "Malformed request",
                        content = @Content),
                @ApiResponse(responseCode = "404",
                        description = "Franchise with supplied ID not found ",
                        content = @Content)
        })
        @DeleteMapping("{id}")
        public ResponseEntity delete(@PathVariable int id) {
            franchiseService.deleteById(id);
            return ResponseEntity.noContent().build();
        }








    }

