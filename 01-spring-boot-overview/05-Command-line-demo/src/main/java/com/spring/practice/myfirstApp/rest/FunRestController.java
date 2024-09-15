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
    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getWorkout(){
        return "<h1> Run a Hard 5k</h1>";
    }
    @GetMapping("/fortune")
    public String getFortune(){
        return "<h1> Run a Hard 1k</h1>";
    }
    @GetMapping("/fortune/check")
    public String getCheck(){
        return "<h1> Checked Successfully </h1>";
    }
}
