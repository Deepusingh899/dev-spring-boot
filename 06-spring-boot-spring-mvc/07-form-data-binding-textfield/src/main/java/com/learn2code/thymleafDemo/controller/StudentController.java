package com.learn2code.thymleafDemo.controller;

import com.learn2code.thymleafDemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    // add acontroller method to show the form

    @RequestMapping("/showStudentForm")
    public String showForm(Model themodel){

        // create a student object
        Student theStudent=new Student();

        //add student object to the model
        themodel.addAttribute("student",theStudent);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        //log a input data
        System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());

        return "student-confirmation";
    }

}
