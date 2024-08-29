package com.northcoders.drinkapi.controller;

import com.northcoders.drinkapi.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Welcome to the Drinks API!";
    }

    @GetMapping("/coffeelover")
    public String getCoffeeMessage() {
        return "I like coffee!";
    }

    @GetMapping("/coffee")
    public String getCoffee(@RequestParam(value = "name", defaultValue = "latte") String name) {
        return "1, " + name;
    }
}
