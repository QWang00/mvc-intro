package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class HomeController {

    @GetMapping("/")
    public String getGreeting(){
        return "Welcome to the Drinks API!";
    }
}
