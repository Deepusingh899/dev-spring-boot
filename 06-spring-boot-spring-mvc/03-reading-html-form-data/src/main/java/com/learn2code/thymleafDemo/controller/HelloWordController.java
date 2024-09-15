package com.learn2code.thymleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWordController {

    // Need a controller method to show the initial html form page
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // Need a controller method to process the Html form page
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

}
