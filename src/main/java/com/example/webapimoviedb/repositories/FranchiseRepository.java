package com.example.webapimoviedb.repositories;

import com.example.webapimoviedb.models.Character;
import com.example.webapimoviedb.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

    @Query("select f from Franchise f where f.name like %?1%")
    Set<Franchise> findAllByName(String name);
}
