package com.spring.practice.myfirstApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Set Up the rest Controller
public class FunRestController {
    //inject Properties for : coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // Expose "/teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach Name :- "+coachName+"\n\n"+"Team Name :- "+teamName;
    }


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
    public String getCheck() { return "<h1> Checked Successfully </h1>"; }


}
