package com.learn2code.crudDemo.dao;

import com.learn2code.crudDemo.entity.Course;
import com.learn2code.crudDemo.entity.Instructor;
import com.learn2code.crudDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{

    //define fields for entity manager
    private EntityManager entityManager;

    //inject the entity manager using constructor injection
    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //retrieve the instructor
        Instructor tempInstructor=entityManager.find(Instructor.class,theId);
        //delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(int theId) {
        //retrieve the Instructor Detail By id
        InstructorDetail theInstructorDetails= entityManager.find(InstructorDetail.class,theId);

        //remove the associated object
        //break the bi-direction link
        theInstructorDetails.getInstructor().setInstructorDetail(null);

        //Delete the Instructor Details
        entityManager.remove(theInstructorDetails);

        System.out.println("Done !");
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        //create the Query
        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        //set the actual parameter for the variable
        query.setParameter("data",theId);

        //execute the Query
        List<Course> courses=query.getResultList();
        return courses;
    }
}
