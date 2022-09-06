package com.example.webapimoviedb.repositories;

import com.example.webapimoviedb.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
