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
			findInstructorDetail(appDao);
//			deleteInstructor(appDao);
		};
	}

	private void deleteInstructor(AppDao appDao) {
		int theId=1;
		System.out.println("Deleting the Instructor Id :- "+theId);
		appDao.deleteInstructorById(theId);
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
}
