package com.northcoders.drinkapi.controller;

import com.northcoders.drinkapi.service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/coffee")

public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/coffeelover")
    public String getCoffeeMessage() {
        return coffeeService.getCoffeeMessage();
    }

    @GetMapping("/coffee-type")
    public Map<String, String> getCoffee(@RequestParam(value = "name", defaultValue = "latte") String name) {
        return coffeeService.getCoffeeDetails(name);
    }
}
