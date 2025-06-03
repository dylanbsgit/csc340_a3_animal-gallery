package com.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByNameContaining(String name);

    @Query("SELECT a FROM Animal a WHERE a.favoriteFood = ?1")
    List<Animal> findByFavoriteFood(String favoriteFood);

    @Query("SELECT a FROM Animal a WHERE a.habitat = ?1")
    List<Animal> findByHabitat(String habitat);
}