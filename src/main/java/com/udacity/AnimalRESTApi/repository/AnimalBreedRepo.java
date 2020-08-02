package com.udacity.AnimalRESTApi.repository;

import com.udacity.AnimalRESTApi.entity.AnimalBreeds;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalBreedRepo extends CrudRepository <AnimalBreeds,Long> {

    AnimalBreeds findByName(String name);

    List<AnimalBreeds> findByAnimalName(String name);
//    @Query("select d.id,d.breed from Dog_breed d where d.id =:id")
//    String findAllById(Long id);
//    @Query("select d.id,d.breed from Dog_breed d where d.name =:name")
//    List<String> findAllBreed(String name);
}
