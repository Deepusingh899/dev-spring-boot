package com.learn2code.springboot.crud.rest;

import com.learn2code.springboot.crud.dao.EmployeeDAOImpl;
import com.learn2code.springboot.crud.dao.EmployeeDao;
import com.learn2code.springboot.crud.entity.Employee;
import com.learn2code.springboot.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // expose  "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

}
