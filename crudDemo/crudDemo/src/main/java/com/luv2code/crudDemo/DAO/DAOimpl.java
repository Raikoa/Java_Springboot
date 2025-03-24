package com.luv2code.crudDemo.DAO;

import com.luv2code.crudDemo.Entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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


}
