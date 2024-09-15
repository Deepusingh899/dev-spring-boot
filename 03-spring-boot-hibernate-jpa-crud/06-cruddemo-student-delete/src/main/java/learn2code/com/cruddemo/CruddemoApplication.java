package learn2code.com.cruddemo;

import learn2code.com.cruddemo.DAO.StudentDao;
import learn2code.com.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
//			createStudent(studentDao);
//			readStudent(studentDao);
//			queryForStudent(studentDao);
//			queryForStudentByLastName(studentDao);
//			updateStudent(studentDao);
			deleteStudent(studentDao);
		};
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId=3;
		System.out.println("Deleting the student with ID:-  "+studentId);

		//Find the Student with the ID
		Student myStudent=studentDao.findById(studentId);

		//Deleting the Student wiith the ID;
		studentDao.delete(studentId);

		//Displaying the Deleted Students
		System.out.println(myStudent);
	}

	private void updateStudent(StudentDao studentDao) {
		int studentId=1;
		//retrieve Student based on the id: primary key
		System.out.println("Getting Student with Id:- "+studentId);
		Student myStudent=studentDao.findById(studentId);

		// Set the First Name
		myStudent.setFirstName("Deepali");

		// Update the Sudent
		studentDao.update(myStudent);

		//Dispaly the Updated Sudent
		System.out.println(myStudent);


	}

	private void queryForStudentByLastName(StudentDao studentDao) {
		//get a list of Student students by last name
		List<Student> theStudents=studentDao.findByLastName("Singh");

		//return the list of students
		for (Student st: theStudents){
			System.out.println(st);
		}
	}

	private void queryForStudent(StudentDao studentDao) {
		//get a list of students
		List<Student> theStudents=studentDao.findAll();

		//display the list of students
		for(Student st: theStudents){
			System.out.println(st);
		}
	}

	private void readStudent(StudentDao studentDao) {
		// Creating the new Student Object
		System.out.println("------- Creating the new Student Object -------\nStudent Data Successfully Created\n\n");
		Student tempStudent=new Student("Deepali","Singh","xyz123@gmail.com");

		// Saving the new Student Objects
		System.out.println("------- Saving the New Student Objects -------\nStudent Data Successfully Saved into Database\n\n");
		studentDao.save(tempStudent);

		//Saved Student ID
		System.out.println("------- Get the Student ID ------");
		int theId= tempStudent.getId();
		System.out.println("Saved Student Id :- "+theId+"\n\n");

		//Retrieving the Student Data by Id
		Student myStudent=studentDao.findById(theId);

		//Display the Student Objects
		System.out.println("------- Display the Student -------");
		System.out.println(myStudent);
	}

	private void createStudent(StudentDao studentDao) {
		//Create the Student Object
		System.out.println("Creating the new Student Object");
		Student tempStudent=new Student("Deepak","Singh","deepusingh888@gmail.com");

		//Save the Student Object
		System.out.println("Saving the new Student Object");
		studentDao.save(tempStudent);

		// Display the id for the saved student
		System.out.println("Saved Student Id :- "+ tempStudent.getId());

	}
}
