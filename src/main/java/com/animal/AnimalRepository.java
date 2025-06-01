package com.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Find animals by name
    List<Animal> findByName(String name);

    // Custom query: Find animals whose favorite food matches
    @Query("SELECT a FROM Animal a WHERE a.favoriteFood = ?1")
    List<Animal> findByFavoriteFood(String favoriteFood);
}