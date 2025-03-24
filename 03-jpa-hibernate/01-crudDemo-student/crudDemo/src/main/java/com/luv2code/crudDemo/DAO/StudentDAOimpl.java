package com.luv2code.crudDemo.DAO;

import com.luv2code.crudDemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO{

    private EntityManager entityManager;
    @Autowired
    public StudentDAOimpl(EntityManager mana){
        this.entityManager = mana;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String last) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastname=:theData",Student.class);
        query.setParameter("theData",last);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student newStudent) {
        entityManager.merge(newStudent);
    }

    @Override
    @Transactional
    public void delete(int ID) {
        Student theStudent = entityManager.find(Student.class,ID);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int count = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return count;

    }
}
