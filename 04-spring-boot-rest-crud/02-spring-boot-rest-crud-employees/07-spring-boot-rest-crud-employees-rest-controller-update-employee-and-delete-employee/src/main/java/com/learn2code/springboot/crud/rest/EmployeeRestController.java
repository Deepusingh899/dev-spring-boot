package com.learn2code.springboot.crud.rest;

import com.learn2code.springboot.crud.dao.EmployeeDAOImpl;
import com.learn2code.springboot.crud.dao.EmployeeDao;
import com.learn2code.springboot.crud.entity.Employee;
import com.learn2code.springboot.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    //adding the Get "/employees/{employeeId} for geting  a single employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee Not Found With :- "+employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST "/employees" for adding a new employee
    @PostMapping("/employees")
    public Employee saveEmplyee(@RequestBody Employee theEmployee){
        //also just in case the pass a id in json set a in to 0
        //this is to force a new item  instead of update

        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for PUT "/employees" for updating an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for DELETE "/employees/{employeeId} for delete an existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee not found with :- "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee id:- "+employeeId;
    }

}
