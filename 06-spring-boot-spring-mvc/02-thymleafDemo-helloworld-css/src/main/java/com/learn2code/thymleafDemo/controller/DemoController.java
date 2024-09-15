package com.learn2code.thymleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model m){
        m.addAttribute("theDate",java.time.LocalDateTime.now());
        return "helloworld";
    }

}
