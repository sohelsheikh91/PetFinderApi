package com.udacity.AnimalRESTApi.service;

import com.udacity.AnimalRESTApi.entity.AnimalBreeds;

import java.util.List;

public interface AnimalBreedService {
    List<AnimalBreeds> AllBreeds(String name);
    List<AnimalBreeds> AnimalBreedByID(Long id);
    AnimalBreeds AnimalBreedByName(String name);
    void createBreed(AnimalBreeds dogBreed);
    void deleteBreed(Long id);

}
