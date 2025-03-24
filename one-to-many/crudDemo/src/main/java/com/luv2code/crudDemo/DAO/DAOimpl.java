package com.luv2code.crudDemo.DAO;

import com.luv2code.crudDemo.Entity.Course;
import com.luv2code.crudDemo.Entity.Instructer_details;
import com.luv2code.crudDemo.Entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DAOimpl implements DAO{
    private EntityManager entityManager;
    @Autowired
    public DAOimpl(EntityManager entity){
        this.entityManager =entity;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstrructorByid(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor temp = entityManager.find(Instructor.class,id);
        entityManager.remove(temp);
    }

    @Override
    public Instructer_details find_instructor_edetailsByid(int id) {
        return entityManager.find(Instructer_details.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructordetailsbyid(int id) {
        Instructer_details temp = entityManager.find(Instructer_details.class,id);
        temp.getInstructor().setInstructer_details(null);
        entityManager.remove(temp);
    }

    @Override
    public List<Course> findCourses(int id) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorJoin(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " + "JOIN FETCH i.courses " + "JOIN FETCH i.instructorDetail " + "where i.id = :data", Instructor.class);
        query.setParameter("data",id);
        Instructor temp = query.getSingleResult();
        return temp;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }


}
