package com.learn2code.springboot.crud.service;
import com.learn2code.springboot.crud.dao.EmployeeRepository;
import com.learn2code.springboot.crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee=employeeRepository.save(theEmployee);
        return dbEmployee;
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result=employeeRepository.findById(id);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else{
            throw new RuntimeException("Did not find employee id with :-"+id);
        }
        return theEmployee;
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
