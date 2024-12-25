package com.learn2code.crudDemo;

import com.learn2code.crudDemo.dao.AppDao;
import com.learn2code.crudDemo.entity.Course;
import com.learn2code.crudDemo.entity.Instructor;
import com.learn2code.crudDemo.entity.InstructorDetail;
import com.learn2code.crudDemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO) {

		return runner -> {
			createCourseAndReview(appDAO);
		};
	}

	private void createCourseAndReview(AppDao appDAO) {
		// Create a course
		Course tempCourse=new Course("Pacman :- How To Score A One Million Points");

		// add Some Review with the course
		tempCourse.addReview(new Review("Great Course ... loved it"));
		tempCourse.addReview(new Review("cool course, job well done !"));
		tempCourse.addReview(new Review("what a dumb course, you are an idiot!"));

		// save the course
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done! ");

	}


}