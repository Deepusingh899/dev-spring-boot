package com.learn2code.thymleafDemo.controller;

import com.learn2code.thymleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    // add acontroller method to show the form
    @RequestMapping("/showStudentForm")
    public String showForm(Model themodel){

        // create a student object
        Student theStudent=new Student();

        //add student object to the model
        themodel.addAttribute("student",theStudent);

        // add the list of countries to the model
        themodel.addAttribute("countries",countries);

        // add the list of languages to the model
        themodel.addAttribute("languages",languages);

        // add the list of systems to the model
        themodel.addAttribute("systems",systems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        //log a input data
        System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());

        return "student-confirmation";
    }

}
