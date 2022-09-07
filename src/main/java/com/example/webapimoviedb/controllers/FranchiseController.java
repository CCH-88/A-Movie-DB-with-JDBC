package com.example.webapimoviedb.controllers;

import com.example.webapimoviedb.mappers.FranchiseMapper;
import com.example.webapimoviedb.models.Franchise;
import com.example.webapimoviedb.models.franchise.FranchiseDTO;
import com.example.webapimoviedb.services.franchise.FranchiseService;
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

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable int id) {
            FranchiseDTO franchiseDTO = franchiseMapper.franchiseToFranchiseDto(
                    franchiseService.findById(id)
            );
            return ResponseEntity.ok(franchiseDTO);
        }

        @GetMapping
        public ResponseEntity<Collection<Franchise>> getAll() {
            return ResponseEntity.ok(franchiseService.findAll());
        }


        @GetMapping("search")
        public ResponseEntity<Collection<Franchise>> findByName(@RequestParam String name){
            return ResponseEntity.ok(franchiseService.findAllByName(name));
        }


        @PostMapping
        public ResponseEntity add(@RequestBody Franchise franchise){
            Franchise franch = franchiseService.add(franchise);
            URI location = URI.create("franchises/" + franchise.getId());
            return ResponseEntity.created(location).build();
        }

        @PutMapping("{id}")
        public ResponseEntity updateFranchise(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
            if(id != franchiseDTO.getId())
                return ResponseEntity.notFound().build();
            franchiseService.update(
                    franchiseMapper.franchiseDtoToFranchise(franchiseDTO)
            );

            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("{id}")
        public ResponseEntity delete(@PathVariable int id) {
            franchiseService.deleteById(id);
            return ResponseEntity.noContent().build();
        }








    }

