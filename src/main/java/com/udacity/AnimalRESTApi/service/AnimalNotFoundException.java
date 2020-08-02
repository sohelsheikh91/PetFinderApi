package com.udacity.AnimalRESTApi.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Animal not found for this ID")
public class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException(){
    }

    public AnimalNotFoundException(String message){
       super(message);
    }
}