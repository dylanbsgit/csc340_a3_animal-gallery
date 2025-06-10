package com.animal;

import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;
    
    private String name;
    private String description;
    private String habitat;
    private String favoriteFood;
    private Integer age;
    private String imageFilename; // New field for image
    private String behavior; // New field for behavior
    
    // Default constructor
    public Animal() {}
    
    // Keep your ORIGINAL constructor unchanged
    public Animal(String name, String description, String habitat, String favoriteFood, Integer age) {
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.favoriteFood = favoriteFood;
        this.age = age;
        // imageFilename and behavior will be null by default - can be set later
    }
    
    // Getters and Setters
    public Long getAnimalId() {
        return animalId;
    }
    
    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    public String getFavoriteFood() {
        return favoriteFood;
    }
    
    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    // NEW: Add getter and setter for imageFilename
    public String getImageFilename() {
        return imageFilename;
    }
    
    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }
    
    // NEW: Add getter and setter for behavior
    public String getBehavior() {
        return behavior;
    }
    
    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
    
    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", habitat='" + habitat + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", age=" + age +
                ", imageFilename='" + imageFilename + '\'' +
                ", behavior='" + behavior + '\'' +
                '}';
    }
}