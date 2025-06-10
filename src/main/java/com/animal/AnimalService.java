package com.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> searchByName(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Animal> searchByFavoriteFood(String favoriteFood) {
        return animalRepository.findByFavoriteFoodContainingIgnoreCase(favoriteFood);
    }

    public void clearAllData() {
        animalRepository.deleteAll();
    }

    public void initializeData() {
        // Clear existing data
        animalRepository.deleteAll();
        
        // Create sample animals using your existing images from Animal Pictures folder
        Animal mountainChicken = new Animal("Mountain Chicken", 
            "The Mountain Chicken is the world's largest frog native to the Caribbean. They're known for their distinctive call and are critically endangered due to habitat loss and hunting.", 
            "Cloud forests of the Caribbean", 
            "Insects and small rodents", 
            3);
        mountainChicken.setImageFilename("Animal Pictures/Cluck.png");
        mountainChicken.setBehavior("Mountain Chickens are nocturnal and known for their loud, distinctive calls that can be heard from great distances. They are territorial and will aggressively defend their burrows.");
        
        Animal sloth = new Animal("Sloth", 
            "Sloths are known for their slow movement and spend most of their lives hanging upside down in trees.", 
            "Tropical rainforests of Central and South America", 
            "Leaves and small fruits", 
            8);
        sloth.setImageFilename("Animal Pictures/Speedy.png");
        sloth.setBehavior("Sloths move extremely slowly and sleep 15-20 hours per day. They only come down from trees once a week to defecate and are excellent swimmers despite their slow land movement.");
        
        Animal lobster = new Animal("Lobster", 
            "Lobsters are marine crustaceans with long bodies and tails. They are known for their delicious meat.", 
            "Ocean floors and rocky coastal areas", 
            "Small fish, mollusks, and marine worms", 
            12);
        lobster.setImageFilename("Animal Pictures/Clawdia.png");
        lobster.setBehavior("Lobsters are solitary creatures that hide in crevices during the day and hunt at night. They can regenerate lost limbs and live for over 100 years.");
        
        Animal elephant = new Animal("Elephant", 
            "Elephants are the largest land animals on Earth, known for their intelligence and strong social bonds.", 
            "African savannas and forests", 
            "Grasses, fruits, and bark", 
            25);
        elephant.setImageFilename("Animal Pictures/Ivor.png");
        elephant.setBehavior("Elephants live in complex social groups led by matriarchs. They show empathy, mourn their dead, and have excellent memories. They communicate through infrasonic calls over long distances.");
        
        Animal stickBug = new Animal("Stick Bug", 
            "Stick Bugs are masters of camouflage, resembling twigs or branches to avoid predators.", 
            "Forests and wooded areas worldwide", 
            "Leaves and plant matter", 
            1);
        stickBug.setImageFilename("Animal Pictures/stick-bug-stick-bugged.gif");
        stickBug.setBehavior("Stick bugs remain motionless for hours to avoid detection. When threatened, they can drop and regenerate limbs. Some species sway gently to mimic branches moving in the wind.");
        
        // Save all animals
        animalRepository.save(mountainChicken);
        animalRepository.save(sloth);
        animalRepository.save(lobster);
        animalRepository.save(elephant);
        animalRepository.save(stickBug);
    }
}