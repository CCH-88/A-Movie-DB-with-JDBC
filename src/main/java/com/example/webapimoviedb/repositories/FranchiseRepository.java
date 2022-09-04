package com.example.webapimoviedb.repositories;

import com.example.webapimoviedb.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
    @Query("SELECT s FROM Franchise s WHERE s.name like %?1%")
    Set<Franchise> findAllByName(String name);
}
