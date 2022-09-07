package com.example.webapimoviedb.services.franchise;

import com.example.webapimoviedb.models.Franchise;
import com.example.webapimoviedb.services.CrudService;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public interface FranchiseService extends CrudService<Franchise, Integer> {
    Collection<Franchise> findAllByName(String name);
}
