package com.example.webapimoviedb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository (DAO) for the Professor domain class.
 * Uses @Query for business logic that is difficult to achieve with default functionality.
 */
@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    /*@Modifying
    @Query("update Student s set s.character.id = ?2 where s.id = ?1")
    void updateCharacterById(int studentId, int characterId);*/
}
