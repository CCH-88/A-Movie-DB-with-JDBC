package com.example.webapimoviedb.services.franchise;

import com.example.webapimoviedb.models.Franchise;
import com.example.webapimoviedb.repositories.CharacterRepository;
import com.example.webapimoviedb.repositories.FranchiseRepository;
import com.example.webapimoviedb.services.character.CharacterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class FranchiseServiceImpl implements FranchiseService {

    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);
    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }
    @Override
    public Franchise findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Franchise> findAll() {
        return null;
    }

    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}