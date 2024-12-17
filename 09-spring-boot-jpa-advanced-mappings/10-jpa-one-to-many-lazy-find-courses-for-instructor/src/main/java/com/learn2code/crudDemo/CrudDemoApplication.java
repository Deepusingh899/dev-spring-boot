package com.learn2code.crudDemo;

import com.learn2code.crudDemo.dao.AppDao;
import com.learn2code.crudDemo.entity.Course;
import com.learn2code.crudDemo.entity.Instructor;
import com.learn2code.crudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return (runner -> {
//			createInstructor(appDao);
//			findInstructorDetail(appDao);
//			deleteInstructorDetails(appDao);
//			createInstructorWithCourses(appDao);
//			findInstructorWithCourse(appDao);
			findCourseForInstructor(appDao);
		});
	}

	private void findInstructorWithCourse(AppDao appDao) {
		int theId=1;
		System.out.println("Finding the Instructor Id :- "+theId);
		Instructor tempInstructor= appDao.findInstructorById(theId);
		System.out.println("Instructor :- "+tempInstructor);
		System.out.println("Associated Instructor Detail :- "+tempInstructor.getCourse());
		System.out.println("Done !");
	}

	private void createInstructorWithCourses(AppDao appDao) {
		// creating the Instructor
		Instructor tempInstructor=new Instructor("Deepali","Singh",
				"Deepalisingh8527@gmail.com");
		//creating the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail(
				"https://www.youtube.com","Blogging");
		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course theCourses=new Course("Air Guitar - The Ultimate Guide");
		Course theCourse1=new Course("The PinBall Masterclass");

		//add courses to the instructor
		tempInstructor.add(theCourses);
		tempInstructor.add(theCourse1);

		//Save the instructor

		System.out.println("Saving the Instructor :- "+tempInstructor);
		System.out.println("The Course :- "+tempInstructor.getCourse());

		appDao.save(tempInstructor);
		System.out.println("Done !");
	}

	private void deleteInstructorDetails(AppDao appDao) {
		int theId=3;
		System.out.println("Deleting the Instructor Id :- "+theId);
		appDao.deleteInstructorDetailsById(theId);
		System.out.println("Done !");
	}

	private void findInstructorDetail(AppDao appDao) {
		int theId=2;
		System.out.println("Finding the Instructor Id :- "+theId);
		InstructorDetail tempInstructorDetail= appDao.findInstructorDetailById(theId);
		System.out.println("Instructor :- "+tempInstructorDetail);
		System.out.println("Associated Instructor Detail :- "+tempInstructorDetail.getInstructor());
		System.out.println("Done !");
	}

	private void createInstructor(AppDao appDao) {

		// creating the Instructor
		Instructor tempInstructor=new Instructor("Payal","Singh",
				"payalsingh8527@gmail.com");
		//creating the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail(
				"https://www.learn2code.com/youtube","Playing");
		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//save the instructor
		// Note: This will also save the instructor detail object because of CascadeType.ALL
		System.out.println("Saving Instructor :- "+tempInstructor);
		appDao.save(tempInstructor);

		System.out.println("Done !");

	}
	private void findCourseForInstructor(AppDao appDao) {
		int theId=1;
		System.out.println("Finding the Instructor id :- "+theId);
		Instructor tempInstructor=appDao.findInstructorById(theId);
		//find the courses for instructor id
		System.out.println("Finding the courses for the instructor id :- "+theId);
		List<Course> courses=appDao.findCoursesByInstructorId(theId);
		tempInstructor.setCourse(courses);
		System.out.println("The associated courses :- "+tempInstructor.getCourse());

		System.out.println("Done !");
	}
}
