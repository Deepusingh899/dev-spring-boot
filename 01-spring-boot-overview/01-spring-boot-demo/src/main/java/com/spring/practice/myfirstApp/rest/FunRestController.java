package com.spring.practice.myfirstApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Set Up the rest Controller
public class FunRestController {
    // Expose "/" that returns "Hello World!"
    @GetMapping("/") // Handle HTTP GET Request
    public String sayHello(){
        return "<h1>Hello World!</h1>";
    }
}
