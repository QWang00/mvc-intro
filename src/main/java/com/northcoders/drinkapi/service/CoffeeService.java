package com.northcoders.drinkapi.service;

import com.northcoders.drinkapi.model.Coffee;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CoffeeService {

    private int idCounter =0;

    public Map<String, String> getCoffeeDetails(String coffeeName) {
        Map<String, String> response = new HashMap<>();
        response.put("id", String.valueOf(++idCounter));
        response.put("name", coffeeName);
        return response;
    }

    public String getCoffeeMessage(){
        return "I like coffee!";
    }

    public void resetCounter() {
        this.idCounter = 0;
    }

    public Coffee getCoffeeByName(String name){
        return new Coffee(++idCounter,name);
    }
}
