package com.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public List<Animal> getAnimalsByNameContains(String name) {
        return animalRepository.findByNameContaining(name);
    }

    public List<Animal> getAnimalsByFavoriteFood(String favoriteFood) {
        return animalRepository.findByFavoriteFood(favoriteFood);
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimalsByHabitat(String habitat) {
        return animalRepository.findByHabitat(habitat);
    }
    
    public List<Animal> getAnimalsByAge(int age) {
        return animalRepository.findAll().stream()
                .filter(animal -> animal.getAge() == age)
                .toList();
    }
}