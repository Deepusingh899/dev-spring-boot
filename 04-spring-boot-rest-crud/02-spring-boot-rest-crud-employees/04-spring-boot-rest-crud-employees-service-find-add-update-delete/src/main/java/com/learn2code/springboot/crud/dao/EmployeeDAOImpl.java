package com.learn2code.springboot.crud.dao;

import com.learn2code.springboot.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDao{
    // Define Entity Manager variable
    private EntityManager entityManager;

    //Define the Constructor
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee findById(Integer id) {
        Employee theEmployee=entityManager.find(Employee.class,id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee=entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public List<Employee> findAll() {

        //Create a Query
        TypedQuery<Employee> theQuery=entityManager.createQuery("From Employee", Employee.class);

        //Execute Query and get the Result
        List<Employee> employees=theQuery.getResultList();

        //return the Employee List
        return employees;
    }

    @Override
    public void deletById(Integer id) {
        Employee theEmployee=entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
    }
}
