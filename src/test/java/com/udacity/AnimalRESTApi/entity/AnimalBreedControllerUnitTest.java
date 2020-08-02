package com.udacity.AnimalRESTApi.entity;

import com.udacity.AnimalRESTApi.controller.AnimalBreedController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnimalBreedController.class)
public class AnimalBreedControllerUnitTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AnimalBreedController animalBreedController;

//    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity())
                .build();

    }
    @WithMockUser("admin")
    @Test
    public void getAllAnimalBreeds() throws Exception{
        mockMvc.perform(get("/animal/Cat/animalBreed").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

//                   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//
//                .andExpect(content().contentTypeCompatibleWith("application/json"))
//                .andExpect(content().json("[]"));

        verify(animalBreedController, times(1)).getAllBreeds("Cat");
    }

    @WithMockUser("admin")
    @Test
    public void getAnimalBreedById() throws Exception{
        mockMvc.perform(get("/animal/Cat/animalBreed/1"))
                .andExpect(status().isOk());
        verify(animalBreedController, times(1)).animalBreedByID(Long.valueOf(1));
    }
    @WithMockUser("admin")
   @Test
    public void getAnimalBreedByName() throws Exception{
        mockMvc.perform(get("/animal/Cat/animalBreed?name=doggy"))
                .andExpect(status().isOk());
        verify(animalBreedController, times(1)).animalBreedByName("doggy");
    }
}
