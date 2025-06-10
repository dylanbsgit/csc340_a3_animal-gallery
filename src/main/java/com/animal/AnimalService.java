package com.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAllAnimals() {
        animalRepository.deleteAll();
    }

    public void initializeTestData() {
        // Only add if database is empty
        if (animalRepository.count() == 0) {
            Animal animal1 = new Animal("Mountain Chicken", "The Mountain Chicken is the world's largest frog native to the Caribbean.", 3, "Insects and small rodents", "Cloud forests of the Caribbean");
            Animal animal2 = new Animal("African Elephant", "Large mammal known for intelligence and memory.", 25, "Grass, fruits, and bark", "African savannas and forests");
            Animal animal3 = new Animal("Red Panda", "Small, arboreal mammal native to the eastern Himalayas.", 5, "Bamboo leaves and shoots", "Temperate forests with bamboo");
            
            animalRepository.save(animal1);
            animalRepository.save(animal2);
            animalRepository.save(animal3);
        }
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> searchByName(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Animal> searchByHabitat(String habitat) {
        return animalRepository.findByHabitatContainingIgnoreCase(habitat);
    }

    // Add this new method
    public List<Animal> searchByFavoriteFood(String favoriteFood) {
        return animalRepository.findByFavoriteFoodContainingIgnoreCase(favoriteFood);
    }
}