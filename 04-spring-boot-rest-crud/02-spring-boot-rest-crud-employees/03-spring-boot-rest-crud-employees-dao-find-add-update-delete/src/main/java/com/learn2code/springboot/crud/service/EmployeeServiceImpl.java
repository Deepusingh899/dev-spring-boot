package com.learn2code.springboot.crud.service;

import com.learn2code.springboot.crud.dao.EmployeeDao;
import com.learn2code.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao=theEmployeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
