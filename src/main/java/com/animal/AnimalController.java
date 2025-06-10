package com.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // Show all animals
    @GetMapping
    public String listAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animalsList", animals);
        return "animal-list";
    }

    // Show individual animal
    @GetMapping("/{id}")
    public String showAnimal(@PathVariable Long id, Model model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        return "animal-details";
    }

    // Show form to create new animal
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create";
    }

    // Handle form submission to create new animal
    @PostMapping("/new")
    public String createAnimal(@ModelAttribute Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    // Show form to edit animal
    @GetMapping("/edit/{id}")
    public String editAnimal(@PathVariable Long id, Model model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        return "animal-update";
    }

    // Handle update form submission
    @PostMapping("/update")
    public String updateAnimal(@ModelAttribute Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    // Initialize test data
    @GetMapping("/init-data")
    public String initializeData() {
        animalService.initializeTestData();
        return "redirect:/animals";
    }

    // Clear all data
    @GetMapping("/clear-data")
    public String clearAllData() {
        animalService.deleteAllAnimals();
        return "redirect:/animals";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

    // Handle animal deletion
    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }

    // Handle search by habitat
    @PostMapping("/search-habitat")
    public String searchByHabitat(@RequestParam String habitat, Model model) {
        List<Animal> animals = animalService.searchByHabitat(habitat);
        model.addAttribute("animalsList", animals);
        model.addAttribute("searchTerm", habitat);
        return "animal-list";
    }

    // Handle search by name
    @GetMapping("/search")
    public String searchByName(@RequestParam String name, Model model) {
        List<Animal> animals = animalService.searchByName(name);
        model.addAttribute("animalsList", animals);
        model.addAttribute("searchTerm", name);
        return "animal-list";
    }

    // Change this method in your AnimalController
    @GetMapping("/category")
    public String searchByFavoriteFood(@RequestParam String favoriteFood, Model model) {
        List<Animal> animals = animalService.searchByFavoriteFood(favoriteFood);
        model.addAttribute("animalsList", animals);
        model.addAttribute("searchTerm", favoriteFood);
        return "animal-list";
    }
}