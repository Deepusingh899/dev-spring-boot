package com.learn2code.springboot.crud.rest;

import com.learn2code.springboot.crud.dao.EmployeeDAOImpl;
import com.learn2code.springboot.crud.dao.EmployeeDao;
import com.learn2code.springboot.crud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDao employeeDao;

    public EmployeeRestController(EmployeeDao theEmployeeDao){
        employeeDao=theEmployeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }


}
