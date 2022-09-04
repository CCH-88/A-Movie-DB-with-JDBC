package com.example.webapimoviedb.controllers;

import com.example.webapimoviedb.services.franchise.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/franchise")
public class FranchiseController {

        private FranchiseService franchiseService;

        @Autowired
        public FranchiseController(FranchiseService franchiseService){
            this.franchiseService = franchiseService;
        }


    }

