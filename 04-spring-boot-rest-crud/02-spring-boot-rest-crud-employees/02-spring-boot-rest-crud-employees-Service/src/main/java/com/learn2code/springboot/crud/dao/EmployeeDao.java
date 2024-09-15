package com.learn2code.springboot.crud.dao;

import com.learn2code.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
