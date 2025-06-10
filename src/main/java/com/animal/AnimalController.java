package com.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    private final String UPLOAD_DIR = "src/main/resources/static/Animal Pictures/";

    // Display list of all animals
    @GetMapping("")
    public String listAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animalsList", animals);
        return "animal-list";
    }

    // Display single animal details
    @GetMapping("/{id}")
    public String showAnimal(@PathVariable Long id, Model model) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (animal.isPresent()) {
            model.addAttribute("animal", animal.get());
            return "animal-details";
        } else {
            return "redirect:/animals";
        }
    }

    // Show create animal form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create";
    }

    // Handle create animal form submission with file upload
    @PostMapping("/new")
    public String createAnimal(@ModelAttribute Animal animal, 
                              @RequestParam("imageFile") MultipartFile imageFile) {
        
        // Save animal first to get the generated ID
        Animal savedAnimal = animalService.saveAnimal(animal);
        
        // Handle file upload if file is provided (now we have the ID)
        if (!imageFile.isEmpty()) {
            try {
                String filename = saveUploadedFile(imageFile, savedAnimal.getName(), savedAnimal.getAnimalId());
                savedAnimal.setImageFilename("Animal Pictures/" + filename);
                // Save again with the updated filename
                animalService.saveAnimal(savedAnimal);
            } catch (IOException e) {
                // If file upload fails, continue without image
                System.err.println("Failed to upload image: " + e.getMessage());
            }
        }
        
        return "redirect:/animals/" + savedAnimal.getAnimalId();
    }

    // Show edit animal form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (animal.isPresent()) {
            model.addAttribute("animal", animal.get());
            return "animal-update";
        } else {
            return "redirect:/animals";
        }
    }

    // Handle update animal form submission with file upload
    @PostMapping("/update")
    public String updateAnimal(@ModelAttribute Animal animal,
                              @RequestParam("imageFile") MultipartFile imageFile) {
        
        // Handle file upload if new file is provided
        if (!imageFile.isEmpty()) {
            try {
                String filename = saveUploadedFile(imageFile, animal.getName(), animal.getAnimalId());
                animal.setImageFilename("Animal Pictures/" + filename);
            } catch (IOException e) {
                // If file upload fails, keep existing image
                System.err.println("Failed to upload image: " + e.getMessage());
                // Get existing animal to preserve current image filename
                Optional<Animal> existingAnimal = animalService.getAnimalById(animal.getAnimalId());
                if (existingAnimal.isPresent()) {
                    animal.setImageFilename(existingAnimal.get().getImageFilename());
                }
            }
        } else {
            // No new file uploaded, keep existing image
            Optional<Animal> existingAnimal = animalService.getAnimalById(animal.getAnimalId());
            if (existingAnimal.isPresent()) {
                animal.setImageFilename(existingAnimal.get().getImageFilename());
            }
        }
        
        animalService.saveAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    // Helper method to save uploaded files with custom naming
    private String saveUploadedFile(MultipartFile file, String animalName, Long animalId) throws IOException {
        // Create upload directory if it doesn't exist
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        
        // Get file extension
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        
        // Create filename using animal name + ID (replace spaces with underscores)
        String cleanAnimalName = animalName.replaceAll("\\s+", "_"); // Replace spaces with underscores
        String customFilename = cleanAnimalName + animalId + extension;
        
        // Save file
        Path filePath = uploadPath.resolve(customFilename);
        Files.copy(file.getInputStream(), filePath);
        
        return customFilename;
    }

    // Handle animal deletion
    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }

    // Handle search by name
    @GetMapping("/search")
    public String searchByName(@RequestParam String name, Model model) {
        List<Animal> animals = animalService.searchByName(name);
        model.addAttribute("animalsList", animals);
        model.addAttribute("searchTerm", name);
        return "animal-list";
    }

    // Handle search by favorite food
    @GetMapping("/category")
    public String searchByFavoriteFood(@RequestParam String favoriteFood, Model model) {
        List<Animal> animals = animalService.searchByFavoriteFood(favoriteFood);
        model.addAttribute("animalsList", animals);
        model.addAttribute("searchTerm", favoriteFood);
        return "animal-list";
    }

    // Clear all data
    @GetMapping("/clear-data")
    public String clearAllData() {
        animalService.clearAllData();
        return "redirect:/animals";
    }

    // Initialize test data
    @GetMapping("/init-data")
    public String initializeData() {
        animalService.initializeData();
        return "redirect:/animals";
    }
}