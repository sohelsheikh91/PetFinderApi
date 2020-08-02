package com.udacity.AnimalRESTApi.controller;

import com.udacity.AnimalRESTApi.entity.Animal;
import com.udacity.AnimalRESTApi.service.AnimalServiceImpl;
import com.udacity.AnimalRESTApi.service.AnimalBreedServiceImpl;
import com.udacity.AnimalRESTApi.entity.AnimalBreeds;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Location microservice is running."),
        @ApiResponse(code=404, message = "Data Not found for this ID")
})
public class AnimalBreedController {
    @Autowired
    AnimalBreedServiceImpl impl;

    @Autowired
    AnimalServiceImpl animalRepo;

    @GetMapping(value="/animal/{animalName}/animalBreed")
    public ResponseEntity<List<AnimalBreeds>> getAllBreeds(@PathVariable(value = "animalName") String name){
    List<AnimalBreeds> list = impl.AllBreeds(name);
    return new ResponseEntity<List<AnimalBreeds>>(list, HttpStatus.OK);
    }
    @GetMapping("/animal/{animalName}/animalBreed/{id}")
    public ResponseEntity<List<AnimalBreeds>> animalBreedByID(@PathVariable(value = "id") Long id){
        List<AnimalBreeds> list = impl.AnimalBreedByID(id);
        return new ResponseEntity<List<AnimalBreeds>>(list, HttpStatus.OK);
    }
//    @RequestMapping(method = RequestMethod.GET,value = "/animalBreed")
    @GetMapping(value ="/animal/{animalName}/animalBreed",params = {"name"})
    public ResponseEntity<AnimalBreeds> animalBreedByName(@RequestParam(name = "name", required = true) String name){
        AnimalBreeds list = impl.AnimalBreedByName(name);
        return new ResponseEntity<AnimalBreeds>(list, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/animalBreed")
    @PostMapping("/animal/{animalName}/animalBreed")
    public String setAnimalBreed(@RequestBody AnimalBreeds animalBreed, @PathVariable(value = "animalName") String name){
        Animal animal = animalRepo.animalByName(name);
        animalBreed.setAnimal(animal,name);
        impl.createBreed(animalBreed);
        return "Pet Added";
    }

//    @RequestMapping(method = RequestMethod.PUT,value = "/animalBreed")
    @PutMapping("/animal/{animalName}/animalBreed")
    public String updateAnimalBreed(@RequestBody AnimalBreeds animalBreed, @PathVariable(value = "animalName") String name){
        Animal animal = animalRepo.animalByName(name);
        animalBreed.setAnimal(animal,name);
        impl.createBreed(animalBreed);
        return "Pet Updated";
    }

//    @RequestMapping(method = RequestMethod.DELETE,value = "/animalBreed/{id}")
    @DeleteMapping("/animal/{animalName}/animalBreed/{id}")
    public String setAnimalBreed(@PathVariable Long id){
        impl.deleteBreed(id);
        return "Dog Deleted";
    }

}
