package learn2code.com.cruddemo.DAO;

import learn2code.com.cruddemo.entity.Student;

public interface StudentDao {
    void save(Student theStudent);
    Student findById(Integer id);
}
