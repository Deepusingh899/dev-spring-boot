package com.learn2code.thymleafDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // Need a controller method to read the form data
    // add the data to the model
    @RequestMapping("/processFormVersion2")
    public String readFormData(HttpServletRequest request, Model model){

        //read the request parameter from the HTML form
        String theName=request.getParameter("studentName");

        //convert the data to the upperCase
        theName=theName.toUpperCase();

        // create the Message
        String result="Yo! "+theName;

        // add the message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersion3")
    public String processFormVersion3(@RequestParam("studentName") String theName, Model model){
//convert the data to the upperCase
        theName=theName.toUpperCase();

        // create the Message
        String result="Hey My Friend from v3 "+theName;

        // add the message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }

}
