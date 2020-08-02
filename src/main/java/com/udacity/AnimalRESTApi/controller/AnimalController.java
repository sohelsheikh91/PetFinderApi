package com.udacity.AnimalRESTApi.controller;

import com.udacity.AnimalRESTApi.service.AnimalServiceImpl;
import com.udacity.AnimalRESTApi.entity.Animal;
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
public class AnimalController {
    @Autowired
    AnimalServiceImpl impl;

    @GetMapping(value="/animal")
    public ResponseEntity<List<Animal>> getAllAnimals(){
    List<Animal> list = impl.animalService();
    return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/animal/{id}")
    public ResponseEntity<List<Animal>> animalByID(@PathVariable(value = "id") Long id){
        List<Animal> list = impl.animalByID(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
//    @RequestMapping(method = RequestMethod.GET,value = "/animal")
    @GetMapping(value ="/animal",params = {"name"})
    public ResponseEntity<Animal> animalByName(@RequestParam(name = "name", required = true) String name){
        Animal list = impl.animalByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/animal")
    @PostMapping("/animal")
    public String setAnimal(@RequestBody Animal animal){
        impl.createAnimal(animal);
        return "Animal Added";
    }

//    @RequestMapping(method = RequestMethod.PUT,value = "/animal")
    @PutMapping("/animal")
    public String updateAnimal(@RequestBody Animal animal){
        impl.createAnimal(animal);
        return "Animal Updated";
    }

//    @RequestMapping(method = RequestMethod.DELETE,value = "/animal/{id}")
    @DeleteMapping("/animal/{id}")
    public String setAnimal(@PathVariable Long id){
        impl.deleteAnimal(id);
        return "Animal Deleted";
    }

}
