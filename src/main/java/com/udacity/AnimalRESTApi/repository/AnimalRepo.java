package com.udacity.AnimalRESTApi.repository;

import com.udacity.AnimalRESTApi.entity.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends CrudRepository <Animal,Long> {

    Animal findByName(String name);
//    @Query("select d.id,d.breed from Dog_breed d where d.id =:id")
//    String findAllById(Long id);
//    @Query("select d.id,d.breed from Dog_breed d where d.name =:name")
//    List<String> findAllBreed(String name);
}
