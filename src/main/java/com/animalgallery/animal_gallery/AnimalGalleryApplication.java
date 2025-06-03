package com.animalgallery.animal_gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.animal")
@EnableJpaRepositories("com.animal")
public class AnimalGalleryApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalGalleryApplication.class, args);
    }
}