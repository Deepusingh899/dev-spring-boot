package com.learn2code.REST_HTTP.rest;

import com.learn2code.REST_HTTP.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController<studentId> {
    private List<Student> theStudent=new ArrayList<>();

    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();
        theStudent.add(new Student("Deepak", "Singh"));
        theStudent.add(new Student("Deepali", "Singh"));
        theStudent.add(new Student("Himanshu", "Pratap"));
        theStudent.add(new Student("Payal", "Bhatt"));
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return theStudent;
    }
    @GetMapping("/student/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        return theStudent.get(studentId);
    }

}
