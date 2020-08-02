package com.udacity.AnimalRESTApi.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AnimalBreedIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAnimalBreeds(){
        ResponseEntity<List> response = this.restTemplate.withBasicAuth("admin", "password").getForEntity("http://localhost:" + port + "/animal/Cat/animalBreed", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getAnimalBreedsById(){
        ResponseEntity<List> response = this.restTemplate.withBasicAuth("admin", "password").getForEntity("http://localhost:" +  port + "/animal/Cat/animalBreed/1" , List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

    }
}
