package com.learn2code.crudDemo.dao;

import com.learn2code.crudDemo.entity.Instructor;
import org.springframework.context.annotation.Bean;

public interface AppDao{
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);
}
