package com.animalgallery.animal_gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.animal")
@EnableJpaRepositories("com.animal")
@ComponentScan({"com.animalgallery.animal_gallery", "com.animal"})  // Add this line
public class AnimalGalleryApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalGalleryApplication.class, args);
    }
}