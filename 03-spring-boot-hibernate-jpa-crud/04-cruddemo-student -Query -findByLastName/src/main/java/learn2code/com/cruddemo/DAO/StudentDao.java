package learn2code.com.cruddemo.DAO;

import learn2code.com.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String thelastName);

}
