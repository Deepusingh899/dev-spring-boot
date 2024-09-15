package com.learn2code.springboot.crud.service;

import com.learn2code.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee theEmployee);
    Employee findById(int id);
    void deleteById(Integer id);
}
