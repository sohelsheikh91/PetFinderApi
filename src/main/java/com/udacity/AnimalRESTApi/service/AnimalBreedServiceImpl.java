package com.udacity.AnimalRESTApi.service;

import com.udacity.AnimalRESTApi.repository.AnimalBreedRepo;
import com.udacity.AnimalRESTApi.entity.AnimalBreeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalBreedServiceImpl implements AnimalBreedService {

    @Autowired
    AnimalBreedRepo AnimalBreedRepo;


    @Override
    public List<AnimalBreeds> AllBreeds(String name) {
        return AnimalBreedRepo.findByAnimalName(name);
    }

    @Override
    public List<AnimalBreeds> AnimalBreedByID(Long id) {
        Optional<Iterable<AnimalBreeds>> optionalBreed = Optional.ofNullable(AnimalBreedRepo.findAllById(Collections.singleton(id)));
        Iterable<AnimalBreeds> breed = optionalBreed.orElseThrow(AnimalNotFoundException::new);
        List<AnimalBreeds> list = new ArrayList<AnimalBreeds>();
        breed.forEach(list::add);
        return list;

    }
    @Override
    public AnimalBreeds AnimalBreedByName(String str) {
        Optional<AnimalBreeds> optionalBreed = Optional.ofNullable(AnimalBreedRepo.findByName(str));
        AnimalBreeds breed = optionalBreed.orElseThrow(AnimalNotFoundException::new);
        return breed;
     //   return (List<String>) dog_breedRepo.findAllBreed(str);
    }

    public void createBreed(AnimalBreeds animalBreeds) {
        AnimalBreedRepo.save(animalBreeds);
    }

    public void deleteBreed(Long id) {
        AnimalBreedRepo.deleteById(id);
    }
}
