package com.learn2code.springboot.crud.rest;
import com.learn2code.springboot.crud.entity.Employee;
import com.learn2code.springboot.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class    EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // expose  "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // find the employee by employee id
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        return theEmployee;
    }

    // adding a mapping Post "/employees" a new user
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }
    // adding a mapping PUT "/employees" a existing user
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    //adding a mapping DELETE "/employee/id" a existing user
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee Not Found With :- "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee Id :- "+employeeId;
    }
}
