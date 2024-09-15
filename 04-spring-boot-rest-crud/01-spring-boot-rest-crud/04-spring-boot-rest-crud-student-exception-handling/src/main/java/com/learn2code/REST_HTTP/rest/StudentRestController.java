package com.learn2code.REST_HTTP.rest;

import com.learn2code.REST_HTTP.entity.Student;
import com.learn2code.REST_HTTP.entity.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        // check StudentID with the student list size
        if(studentId>=theStudent.size() || studentId<0){
            throw new StudentNotFoundException("Student Not Found With the Id - "+studentId);
        }
        return theStudent.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // create a studentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // add a new Exception Handler to Catch any Exception (CatchAll)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleBadException(Exception exc){
        // create a studentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
