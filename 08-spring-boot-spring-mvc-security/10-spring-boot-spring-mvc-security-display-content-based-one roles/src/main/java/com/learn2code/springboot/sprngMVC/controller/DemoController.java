package com.learn2code.springboot.sprngMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    //add a another request mapping for /leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    //add a another request mapping for /systems
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
}
