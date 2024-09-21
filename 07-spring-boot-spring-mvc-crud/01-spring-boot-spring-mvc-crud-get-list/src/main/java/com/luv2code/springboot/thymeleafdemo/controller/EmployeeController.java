package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }
    //add a mapping for list of the employees
    @GetMapping("/list")
    public String getEmployee(Model theModel){
        // get the list of Employees
        List<Employee> theEmployee=employeeService.findAll();

        // add the list of employee to the odel attribute
        theModel.addAttribute("employees",theEmployee);

        return "list-employees";
    }
}
