package com.udacity.AnimalRESTApi.service;

import com.udacity.AnimalRESTApi.repository.AnimalRepo;
import com.udacity.AnimalRESTApi.service.AnimalService;
import com.udacity.AnimalRESTApi.entity.Animal;
import com.udacity.AnimalRESTApi.service.AnimalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepo animalRepo;

    @Override
    public List<Animal> animalService() {
        return (List<Animal>) animalRepo.findAll();
    }

    @Override
    public List<Animal> animalByID(Long id) {
        Optional<Iterable<Animal>> optionalBreed = Optional.ofNullable(animalRepo.findAllById(Collections.singleton(id)));
        Iterable<Animal> breed = optionalBreed.orElseThrow(AnimalNotFoundException::new);
        List<Animal> list = new ArrayList<Animal>();
        breed.forEach(list::add);
        return list;

    }
    @Override
    public Animal animalByName(String str) {
        Optional<Animal> optionalBreed = Optional.ofNullable(animalRepo.findByName(str));
        Animal breed = optionalBreed.orElseThrow(AnimalNotFoundException::new);
        return breed;
     //   return (List<String>) AnimalRepo.findAllBreed(str);
    }

    public void createAnimal(Animal animal) {
        animalRepo.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepo.deleteById(id);
    }
}
