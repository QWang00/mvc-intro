package com.northcoders.drinkapi.controller;

import com.northcoders.drinkapi.service.CoffeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeControllerTests {

    @Autowired
    private MockMvc mockMvcController;

    @MockBean
    private CoffeeService coffeeService;

    @BeforeEach
    public void setUp() {
        coffeeService.resetCounter();
    }

    @Test
    public void testGetCoffeeLover() throws Exception {

        String expectedContent = "I like coffee!";
        when(coffeeService.getCoffeeMessage()).thenReturn(expectedContent);
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/coffee/coffeelover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffeeWithDefaultValue() throws Exception {
        Map<String, String> mockResponse = new HashMap<>();
        mockResponse.put("id", "1");
        mockResponse.put("name", "latte");

        when(coffeeService.getCoffeeDetails("latte")).thenReturn(mockResponse);
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/coffee/coffee-type"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("latte"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }


    @Test
    public void testGetCoffeeWithParameter() throws Exception {
        String expectedName = "cappuccino";
        Map<String, String> mockResponse = new HashMap<>();
        mockResponse.put("id", "1");
        mockResponse.put("name", expectedName);

        when(coffeeService.getCoffeeDetails(expectedName)).thenReturn(mockResponse);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/coffee/coffee-type")
                .param("name", expectedName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }
}
