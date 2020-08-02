package com.udacity.AnimalRESTApi.service;

import com.udacity.AnimalRESTApi.entity.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> animalService();
    List<Animal> animalByID(Long id);
    Animal animalByName(String name);
    void createAnimal(Animal animal);
    void deleteAnimal(Long id);

}
