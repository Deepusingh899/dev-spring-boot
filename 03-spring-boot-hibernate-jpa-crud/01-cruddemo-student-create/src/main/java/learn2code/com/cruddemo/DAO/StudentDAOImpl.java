package learn2code.com.cruddemo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import learn2code.com.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDao {
    //Defines the entity manager
    private EntityManager entityManager;

    //inject the entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
//    @Transactional
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

}
