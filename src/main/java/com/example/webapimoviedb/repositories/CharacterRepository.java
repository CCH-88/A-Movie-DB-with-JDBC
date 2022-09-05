package com.example.webapimoviedb.repositories;

import com.example.webapimoviedb.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */
@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query("select c from Character c where c.name like %?1%")
    Set<Character> findAllByName(String name);
}
