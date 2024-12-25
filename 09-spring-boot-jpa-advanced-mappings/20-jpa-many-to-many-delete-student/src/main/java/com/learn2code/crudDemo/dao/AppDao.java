package com.learn2code.crudDemo.dao;

import com.learn2code.crudDemo.entity.Course;
import com.learn2code.crudDemo.entity.Instructor;
import com.learn2code.crudDemo.entity.InstructorDetail;
import com.learn2code.crudDemo.entity.Student;

import java.util.List;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentByCourseId(int theId);

    Student findStudentAndCourseByStudentId(int theId);

    void update(Student theStudent);

    void deleteCourseByCourseId(int theId);

    void deleteStudentById(int theId);
}