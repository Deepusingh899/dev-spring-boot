package com.learn2code.springboot.crud.service;

import com.learn2code.springboot.crud.dao.EmployeeDao;
import com.learn2code.springboot.crud.entity.Employee;
import jakarta.transaction.Transactional;
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

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        Employee dbEmployee=employeeDao.save(theEmployee);
        return dbEmployee;
    }

    @Override
    public Employee findById(Integer id) {
        Employee theEmployee=employeeDao.findById(id);
        return theEmployee;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeDao.deletById(id);
    }
}
