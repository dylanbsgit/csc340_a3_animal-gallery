package com.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        return animal.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.saveAnimal(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        Optional<Animal> existingAnimal = animalService.getAnimalById(id);
        if (existingAnimal.isPresent()) {
            Animal animal = existingAnimal.get();
            animal.setName(updatedAnimal.getName());
            animal.setDescription(updatedAnimal.getDescription());
            animal.setAge(updatedAnimal.getAge());
            animal.setFavoriteFood(updatedAnimal.getFavoriteFood());
            return ResponseEntity.ok(animalService.saveAnimal(animal));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        if (animalService.getAnimalById(id).isPresent()) {
            animalService.deleteAnimal(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category")
    public List<Animal> getAnimalsByCategory(@RequestParam String favoriteFood) {
        return animalService.getAnimalsByFavoriteFood(favoriteFood);
    }

    @GetMapping("/search")
    public List<Animal> getAnimalsByNameContains(@RequestParam String name) {
        return animalService.getAnimalsByNameContains(name);
    }
}