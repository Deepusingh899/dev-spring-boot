package com.learn2code.springboot.crud.dao;

import com.learn2code.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(Integer id);
    Employee save(Employee theEmployee);
    List<Employee> findAll();
    void deeletById(Integer id);
}
