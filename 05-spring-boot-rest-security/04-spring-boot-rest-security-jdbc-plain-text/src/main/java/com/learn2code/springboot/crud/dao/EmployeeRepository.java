package com.learn2code.springboot.crud.dao;

import com.learn2code.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it no need to write any code

}
