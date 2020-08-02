package com.udacity.AnimalRESTApi.entity;

import javax.persistence.*;

@Entity
public class AnimalBreeds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String breed;
    private String name;
    @ManyToOne
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal, String name) {
        this.animal = animal;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalBreeds(Long id, String breed, String name) {
        this.id = id;
        this.breed = breed;
        this.name = name;
    }

    public AnimalBreeds() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
