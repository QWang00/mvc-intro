package com.northcoders.drinkapi.controller;

import com.northcoders.drinkapi.model.Coffee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class HomeControllerTests {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetHome() throws Exception {

        String expectedContent = "Welcome to the Drinks API!";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffeLover() throws Exception {

        String expectedContent = "I like coffee!";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/coffeelover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffee() throws Exception {

        Coffee cappuccinoCoffee = new Coffee(1, "cappuccino");
        String expectedValue = "1, cappuccino";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/coffee?name=cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedValue));
    }

    @Test
    public void testCoffeeParameter() throws Exception {

        String expectedValue = "1, cappuccino";
        String expectedPath = "cappucino";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/coffee")
                .param("name","cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedValue))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedPath));
    }
}
