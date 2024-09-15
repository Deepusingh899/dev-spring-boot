package learn2code.com.cruddemo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import learn2code.com.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        //Create a Query
        TypedQuery<Student> theQuery=entityManager.createQuery("From Student order by id asc",Student.class);
        //return Query Results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String thelastName) {
        //Create a Query to get the Last name
        TypedQuery<Student> theQuery=entityManager.createQuery("From Student Where lastName=:theData", Student.class);

        //set the Query Parameter
        theQuery.setParameter("theData",thelastName);

        //Return the Query Result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent=entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRowDeleted=entityManager.createQuery("Delete From Student").executeUpdate();
        return numOfRowDeleted;
    }
}
