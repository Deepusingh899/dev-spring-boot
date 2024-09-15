package com.learn2code.springdemo.mvc.controller;

import com.learn2code.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {
    //add an initBinder to convert the trim iput string
    // remove the white spaces and trim
    //resolve the issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder theDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        theDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }
    @PostMapping("/processCustomerForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer
        ,BindingResult theBindingResult){
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        else{
            return "customer-confirmation";
        }
    }
}
