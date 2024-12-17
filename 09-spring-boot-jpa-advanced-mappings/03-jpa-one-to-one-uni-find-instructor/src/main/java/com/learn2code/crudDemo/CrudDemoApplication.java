package com.learn2code.crudDemo;

import com.learn2code.crudDemo.dao.AppDao;
import com.learn2code.crudDemo.entity.Instructor;
import com.learn2code.crudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner ->{
//			createInstructor(appDao);
			findInstructor(appDao);
		};
	}

	private void findInstructor(AppDao appDao) {
		int theId=1;
		System.out.println("Finding the Instructor Id :- "+theId);
		Instructor tempInstructor=appDao.findInstructorById(theId);
		System.out.println("Instructor :- "+tempInstructor);
		System.out.println("Associated Instructor Detail :- "+tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDao appDao) {

		// creating the Instructor
		Instructor tempInstructor=new Instructor("Deepak","Singh",
				"deepusingh8527@gmail.com");
		//creating the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail(
				"https://www.learn2code.com/youtube","Singing");
		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//save the instructor
		// Note: This will also save the instructor detail object because of CascadeType.ALL
		System.out.println("Saving Instructor :- "+tempInstructor);
		appDao.save(tempInstructor);

		System.out.println("Done !");

	}
}
