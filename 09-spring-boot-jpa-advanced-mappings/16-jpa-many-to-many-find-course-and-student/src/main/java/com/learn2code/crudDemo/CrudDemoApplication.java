package com.learn2code.crudDemo;

import com.learn2code.crudDemo.dao.AppDao;
import com.learn2code.crudDemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO) {

		return runner -> {
//			createCourseAndStudent(appDAO);
			findCourseAndStudents(appDAO);
		};
	}

	private void findCourseAndStudents(AppDao appDAO) {
		int ID=10;

		System.out.println("Finding the Course : -"+ID);
		Course tempCourse=appDAO.findCourseAndStudentByCourseId(ID);

		System.out.println("Loadded the course :- "+tempCourse);
		System.out.println("Students :- "+tempCourse.getStudents());

		System.out.println("Done !");
	}

	private void createCourseAndStudent(AppDao appDAO) {

		//create a course
		Course tempCourse=new Course("Pacman-How to score one million points");

		//creaate the student
		Student tempStudent1=new Student("Deepak","Singh","deepusingh85273@gmaail.com");
		Student tempStudent2=new Student("Deepali","Singh","deepusingh85272@gmaail.com");
		Student tempStudent3=new Student("Himanshu","Pratap","deepusingh85271@gmaail.com");

		//add student to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);

		//save the course and associated students
		System.out.println("Saving the course :- "+tempCourse);
		System.out.println("Associated students :- "+tempCourse.getStudents());
		appDAO.save(tempCourse);
	}
}