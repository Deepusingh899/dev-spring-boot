package com.learn2code.REST_HTTP.rest;

import com.learn2code.REST_HTTP.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @GetMapping("/student")
    public List<Student> getStudents() {
        List<Student> theStudent = new ArrayList<>();
        theStudent.add(new Student("Deepak", "Singh"));
        theStudent.add(new Student("Deepali", "Singh"));
        theStudent.add(new Student("Himanshu", "Pratap"));
        theStudent.add(new Student("Payal", "Bhatt"));

        return theStudent;
    }

}
