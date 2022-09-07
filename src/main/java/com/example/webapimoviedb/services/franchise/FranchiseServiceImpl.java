package com.example.webapimoviedb.services.franchise;

import com.example.webapimoviedb.exceptions.FranchiseNotFoundException;
import com.example.webapimoviedb.models.Franchise;
import com.example.webapimoviedb.repositories.FranchiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.webapimoviedb.*;

import javax.transaction.Transactional;
import java.util.Collection;


@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);
    private final FranchiseRepository franchiseRepository;

    @Autowired
    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }
    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id)
        .orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if(franchiseRepository.existsById(id)){
            Franchise franchise = franchiseRepository.findById(id).get();
            franchiseRepository.delete(franchise);
        }
        else
            logger.warn("No Franchise exists with ID: " + id);
    }

    @Override
    public boolean exists(Integer id) {
        return franchiseRepository.existsById(id);
    }

    @Override
    public Collection<Franchise> findAllByName(String name){
        return franchiseRepository.findAllByName(name);
    }
}
